package io.github.kathukyabrian.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class QueryTransactionResponse {
    @JsonProperty("OriginatorConversationID")
    private String originatorConversationId;

    @JsonProperty("ConversationID")
    private String conversationId;

    @JsonProperty("ResponseCode")
    private String responseCode;

    @JsonProperty("ResponseDescription")
    private String responseDescription;
}
