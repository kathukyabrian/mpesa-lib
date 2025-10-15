package io.github.kathukyabrian.dto;

import lombok.Data;

@Data
public class MpesaPaymentResult {
    private String merchantRequestId;

    private Integer code;

    private String description;

    private Integer amount;

    private String transactionRef;

    private String phoneNumber;

    private boolean success;

}
