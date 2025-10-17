package io.github.kathukyabrian.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class QueryTransactionRequest {
    @JsonProperty("Initiator")
    private String initiator;

    @JsonProperty("SecurityCredential")
    private String securityCredential;

    @JsonProperty("CommandID")
    private String commandId = "TransactionStatusQuery";

    @JsonProperty("TransactionID")
    private String transactionId;

    @JsonProperty("OriginatorConversationId")
    private String originatorConversationId;

    @JsonProperty("PartyA")
    private Long partyA;

    @JsonProperty("IdentifierType")
    private Integer identifierType = 4;

    @JsonProperty("ResultURL")
    private String resultUrl;

    @JsonProperty("QueueTimeOutURL")
    private String queueTimeOutUrl;

    @JsonProperty("Remarks")
    private String remarks = "TransactionStatusQuery";

    @JsonProperty("Occasion")
    private String occasion = "TransactionStatusQuery";
}
