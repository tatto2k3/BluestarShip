package edu.poly.boatbooking.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionStatusDto {
    private String status;
    private String message;
    private String data;
}
