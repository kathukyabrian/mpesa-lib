package io.github.kathukyabrian.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MpesaQueryTransactionResponse {
    private String merchantRequestId;
    private String responseCode;
    private String responseDescription;
    private boolean success;
}
