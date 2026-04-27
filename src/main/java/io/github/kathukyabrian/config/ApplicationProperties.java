package io.github.kathukyabrian.config;

import lombok.Data;

@Data
public class ApplicationProperties {
    private String shortCode;
    private String transactionType;
    private String identifier;
    private String passKey;
    private String callbackUrl;
    private String consumerKey;
    private String consumerSecret;
    private String authUrl;
    private String paymentUrl;
    private String queryUrl;
}
