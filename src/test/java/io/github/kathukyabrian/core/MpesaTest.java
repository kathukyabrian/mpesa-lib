package io.github.kathukyabrian.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import io.github.kathukyabrian.dto.MpesaPaymentResult;
import io.github.kathukyabrian.dto.result.MpesaResult;

class MpesaTest {
    @Test
    void testHandleResult() throws JsonProcessingException {
        String result = "{    \n" +
                "            \"Body\": {        \n" +
                "                \"stkCallback\": {            \n" +
                "                    \"MerchantRequestID\": \"29115-34620561-1\",            \n" +
                "                    \"CheckoutRequestID\": \"ws_CO_191220191020363925\",            \n" +
                "                    \"ResultCode\": 0,            \n" +
                "                    \"ResultDesc\": \"The service request is processed successfully.\",            \n" +
                "                    \"CallbackMetadata\": {                \n" +
                "                    \"Item\": [{                        \n" +
                "                        \"Name\": \"Amount\",                        \n" +
                "                        \"Value\": 1.00                    \n" +
                "                    },                    \n" +
                "                    {                        \n" +
                "                        \"Name\": \"MpesaReceiptNumber\",                        \n" +
                "                        \"Value\": \"NLJ7RT61SV\"                    \n" +
                "                    },                    \n" +
                "                    {                        \n" +
                "                        \"Name\": \"TransactionDate\",                        \n" +
                "                        \"Value\": 20191219102115                    \n" +
                "                    },                    \n" +
                "                    {                        \n" +
                "                        \"Name\": \"PhoneNumber\",                        \n" +
                "                        \"Value\": 254708374149                    \n" +
                "                    }]            \n" +
                "                    }        \n" +
                "                }    \n" +
                "            }\n" +
                "            }";

        MpesaResult mpesaResult = new ObjectMapper().readValue(result, MpesaResult.class);

        MpesaPaymentResult paymentResult = Mpesa.handleResult(mpesaResult);

        assert paymentResult.isSuccess();
        assert paymentResult.getPhoneNumber().equals("254708374149");
        assert paymentResult.getTransactionRef().equals("NLJ7RT61SV");
        assert paymentResult.getAmount().equals(1);
        assert paymentResult.getDescription().equals("The service request is processed successfully.");
        assert paymentResult.getCode().equals(0);
        assert paymentResult.getMerchantRequestId().equals("29115-34620561-1");
    }

}