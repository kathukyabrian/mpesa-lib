package io.github.kathukyabrian.config;

import org.junit.jupiter.api.Test;
import io.github.kathukyabrian.constants.ServiceConstants;

import java.util.Properties;

public class ConfigUtilTest {
    @Test
    void testReadConfig() throws Exception {
        Properties properties = ConfigUtil.readConfig();
        assert properties.containsKey(ServiceConstants.SHORT_CODE_CONFIG_KEY);
        assert properties.containsKey(ServiceConstants.TRANSACTION_TYPE_CONFIG_KEY);
        assert properties.containsKey(ServiceConstants.IDENTIFIER_CONFIG_KEY);
        assert properties.containsKey(ServiceConstants.PASS_KEY_CONFIG_KEY);
        assert properties.containsKey(ServiceConstants.CALLBACK_URL_CONFIG_KEY);
        assert properties.containsKey(ServiceConstants.CONSUMER_KEY_CONFIG_KEY);
        assert properties.containsKey(ServiceConstants.CONSUMER_SECRET_CONFIG_KEY);
        assert properties.containsKey(ServiceConstants.AUTH_URL_CONFIG_KEY);
        assert properties.containsKey(ServiceConstants.PAYMENT_URL_CONFIG_KEY);
    }

    @Test
    void testReadProperties() throws Exception {
        Properties properties = ConfigUtil.readConfig();
        ApplicationProperties applicationProperties = ConfigUtil.getProperties(properties);
        assert applicationProperties.getShortCode() != null;
        assert applicationProperties.getTransactionType() != null;
        assert applicationProperties.getIdentifier() != null;
        assert applicationProperties.getPassKey() != null;
        assert applicationProperties.getCallbackUrl() != null;
        assert applicationProperties.getConsumerKey() != null;
        assert applicationProperties.getConsumerSecret() != null;
        assert applicationProperties.getAuthUrl() != null;
        assert applicationProperties.getPaymentUrl() != null;
        // queryUrl can be null - ignore test
    }
}
