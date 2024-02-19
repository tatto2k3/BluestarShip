import * as React from 'react';
import "./TicketResult.css";
import logo from '../../../../assets/logo2.PNG';
import AttachMoneyOutlinedIcon from '@mui/icons-material/AttachMoneyOutlined';
export default function TicketResult({ flight, handleClick }) {
    function removeTrailingZeros(price) {
        if (typeof price === 'string') {
            const trimmedPrice = price.trim(); // Remove leading and trailing spaces
            return trimmedPrice;
        } else if (typeof price === 'number') {
            const fixedPrice = price.toFixed(4);
            const trimmedPrice = parseFloat(fixedPrice);
            return trimmedPrice;
        } else {
            // Handle other cases where price is not a valid string or number
            console.error("Invalid flight price:", price);
            return null; // Or any other fallback value or action you prefer
        }
    }
    
    function formatTimeDuration(departureTime, arrivalTime) {
        // Đảm bảo định dạng của chuỗi đầu vào là "HH:mm"
        const timeFormat = /^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$/;
    
        if (!timeFormat.test(departureTime) || !timeFormat.test(arrivalTime)) {
            console.error("Invalid time format");
            return null; // Hoặc xử lý khác tùy thuộc vào yêu cầu của bạn
        }
    
        // Chuyển đổi departureTime và arrivalTime từ string sang Date object
        const departureDate = new Date(`2000-01-01T${departureTime}`);
        const arrivalDate = new Date(`2000-01-01T${arrivalTime}`);
    
        // Kiểm tra xem chuyển đổi đã thành công chưa
        if (isNaN(departureDate) || isNaN(arrivalDate)) {
            console.error("Invalid date format");
            return null; // Hoặc xử lý khác tùy thuộc vào yêu cầu của bạn
        }
    
        // Tính toán thời gian bay
        const durationInMinutes = (arrivalDate - departureDate) / (1000 * 60);
        const hours = Math.floor(durationInMinutes / 60);
        const minutes = durationInMinutes % 60;
    
        let formattedDuration = `${hours} hr`;
        if (minutes > 0) {
            formattedDuration += ` ${minutes} min`;
        }
        return formattedDuration;
    }
    
    

    return (
        <div className="Ticket-Wrapper" onClick={handleClick} >
            <div className="Ticket-Left" >
                <div className="Logo-Wrapper">
                    <div className="Logo-Image">
                        <img src={logo } />
                    </div>
                </div>
                <div className="schedule">
                    <div className="schedule-depart">
                        <p className="schedule-header">
                            Depart
                        </p>
                        <h5 className="schedule-time">
                            {flight.departureTime}
                        </h5>
                        <p className="schedule-date">
                            {flight.departureDay}
                        </p>
                    </div>
                    <div className="schedule-detail">
                        <div className="schedule-detail-top">
                        <span className="schedule-round-left"></span>
                        <div className="time-duration-wrapper">
                            <div className="time-duration">
                                {formatTimeDuration(flight.departureTime, flight.arrivalTime)}
                            </div>
                        </div>
                        <span className="schedule-round-right"></span>
                        </div>
                        <div className='schedule-detail-bottom'>
                            <p  className="schedule-boatName-text">{flight.boat_name}</p>
                        </div>
                    </div>
                    <div className="schedule-des">
                        <p className="schedule-header">
                            Arrive
                        </p>
                        <h5 className="schedule-time">
                            {flight.arrivalTime}
                        </h5>
                        <p className="schedule-date">
                            {flight.departureDay}
                        </p>
                    </div>

                </div>
            </div>

            <div className="Ticket-Right">
                <p className="Price-header">
                    Price
                </p>
                <div className="Price-value">
                    <p className="price-value">
                        {removeTrailingZeros(flight.price)}
                    </p>
                    <p className="price-value-VND" >VND</p>
                </div>
            </div>

        </div>
    )
}