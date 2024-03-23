package edu.poly.boatbooking.controller;

import edu.poly.boatbooking.config.Config;
import edu.poly.boatbooking.dto.PaymentDto;
import edu.poly.boatbooking.entity.Customer;
import edu.poly.boatbooking.entity.Ticket;
import edu.poly.boatbooking.repository.CustomerRepository;
import edu.poly.boatbooking.repository.TicketRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/auth/payment")
public class PaymentController {

    private CustomerRepository customerRepository;
    private TicketRepository ticketRepository;

    public PaymentController(CustomerRepository customerRepository, TicketRepository ticketRepository) {
        this.customerRepository = customerRepository;
        this.ticketRepository = ticketRepository;
    }

    @PostMapping("/create_payment")
    public ResponseEntity<?> createPayment(@RequestBody Map<String, Object> jsonData) throws UnsupportedEncodingException {
        int amount = (int) jsonData.get("ticket_amount");
        String customer_name = (String) jsonData.get("customer_name");
        String customer_email = (String) jsonData.get("customer_email");
        String customer_birth = (String) jsonData.get("customer_birth");
        String customer_identify = (String) jsonData.get("customer_identify");
        String customer_address = (String) jsonData.get("customer_address");
        String seat_id = (String) jsonData.get("seat_id");
        int schedule = (int) jsonData.get("flight_id");
        String departure_day = (String) jsonData.get("departure_day");
        String departure_time = (String) jsonData.get("departure_time");
        String customer_phone = (String) jsonData.get("customer_phone");
        String trip_type = (String) jsonData.get("trip_type");

        String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        String orderType = "other";
        amount = amount * 100;
        String bankCode = "NCB";

        String vnp_TxnRef = Config.getRandomNumber(8);
        String vnp_IpAddr = "127.0.0.1";

        String vnp_TmnCode = Config.vnp_TmnCode;

        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(amount));
        vnp_Params.put("vnp_CurrCode", "VND");

        if (bankCode != null && !bankCode.isEmpty()) {
            vnp_Params.put("vnp_BankCode", bankCode);
        }
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang:" + vnp_TxnRef);
        vnp_Params.put("vnp_OrderType", orderType);

            vnp_Params.put("vnp_Locale", "vn");

        vnp_Params.put("vnp_ReturnUrl", Config.vnp_ReturnUrl);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);


        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = Config.hmacSHA512(Config.secretKey, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = Config.vnp_PayUrl + "?" + queryUrl;

        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setStatus("Ok");
        paymentDto.setMessage("Successfully!");
        paymentDto.setURL(paymentUrl);

        Customer customer = new Customer();
        customer.setName(customer_name);
        customer.setNumId(customer_identify);
        customer.setBirth(customer_birth);
        customer.setAddress(customer_address);

        customer = customerRepository.save(customer);

        Long c_id = customerRepository.findCustomerIdByNumId(customer_identify).getId();
        long ticket_schedule = schedule;
        Ticket ticket = new Ticket();
        ticket.setSeatId(seat_id);
        ticket.setCId(c_id);
        ticket.setSId(ticket_schedule);
        ticket = ticketRepository.save(ticket);

        return ResponseEntity.status(HttpStatus.OK).body(paymentDto.getURL());
    }


}
