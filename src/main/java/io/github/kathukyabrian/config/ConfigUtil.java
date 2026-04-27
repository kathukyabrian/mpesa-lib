package io.github.kathukyabrian.config;

import io.github.kathukyabrian.constants.ServiceConstants;
import io.github.kathukyabrian.exceptions.ConfigurationException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigUtil {
    public static Properties readConfig() throws Exception {
        String fileName = System.getenv().get(ServiceConstants.MPESA_CONFIG_ENV_VARIABLE);

        Properties properties = new Properties();
        if (fileName != null) {
            properties.load(Files.newInputStream(Paths.get(fileName)));
        } else {
            properties.load(ConfigUtil.class.getClassLoader().getResourceAsStream(ServiceConstants.DEFAULT_CONFIG_FILE_NAME));
        }

        return properties;
    }

    public static ApplicationProperties getProperties(Properties properties) {
        ApplicationProperties applicationProperties = new ApplicationProperties();

        applicationProperties.setShortCode(properties.getProperty(ServiceConstants.SHORT_CODE_CONFIG_KEY));
        applicationProperties.setIdentifier(properties.getProperty(ServiceConstants.IDENTIFIER_CONFIG_KEY));
        applicationProperties.setCallbackUrl(properties.getProperty(ServiceConstants.CALLBACK_URL_CONFIG_KEY));
        applicationProperties.setPassKey(properties.getProperty(ServiceConstants.PASS_KEY_CONFIG_KEY));
        applicationProperties.setTransactionType(properties.getProperty(ServiceConstants.TRANSACTION_TYPE_CONFIG_KEY));
        applicationProperties.setConsumerKey(properties.getProperty(ServiceConstants.CONSUMER_KEY_CONFIG_KEY));
        applicationProperties.setConsumerSecret(properties.getProperty(ServiceConstants.CONSUMER_SECRET_CONFIG_KEY));
        applicationProperties.setAuthUrl(properties.getProperty(ServiceConstants.AUTH_URL_CONFIG_KEY));
        applicationProperties.setPaymentUrl(properties.getProperty(ServiceConstants.PAYMENT_URL_CONFIG_KEY));
        applicationProperties.setQueryUrl(properties.getProperty(ServiceConstants.QUERY_URL_CONFIG_KEY));

        return applicationProperties;
    }

    public static void validateProperties(ApplicationProperties applicationProperties) throws ConfigurationException {
        String reason = null;
        if (applicationProperties.getShortCode() == null || applicationProperties.getShortCode().isEmpty()) {
            reason = ServiceConstants.SHORT_CODE_CONFIG_KEY;
        }

        if (applicationProperties.getIdentifier() == null || applicationProperties.getIdentifier().isEmpty()) {
            reason = ServiceConstants.IDENTIFIER_CONFIG_KEY;
        }

        if (applicationProperties.getCallbackUrl() == null || applicationProperties.getCallbackUrl().isEmpty()) {
            reason = ServiceConstants.CALLBACK_URL_CONFIG_KEY;
        }

        if (applicationProperties.getPassKey() == null || applicationProperties.getPassKey().isEmpty()) {
            reason = ServiceConstants.PASS_KEY_CONFIG_KEY;
        }

        if (applicationProperties.getTransactionType() == null || applicationProperties.getTransactionType().isEmpty()) {
            reason = ServiceConstants.TRANSACTION_TYPE_CONFIG_KEY;
        }

        if (applicationProperties.getConsumerKey() == null || applicationProperties.getConsumerKey().isEmpty()) {
            reason = ServiceConstants.CONSUMER_KEY_CONFIG_KEY;
        }

        if (applicationProperties.getConsumerSecret() == null || applicationProperties.getConsumerSecret().isEmpty()) {
            reason = ServiceConstants.CONSUMER_SECRET_CONFIG_KEY;
        }

        if (applicationProperties.getAuthUrl() == null || applicationProperties.getAuthUrl().isEmpty()) {
            reason = ServiceConstants.AUTH_URL_CONFIG_KEY;
        }

        // payment url
        if (applicationProperties.getPaymentUrl() == null || applicationProperties.getPaymentUrl().isEmpty()) {
            reason = ServiceConstants.PAYMENT_URL_CONFIG_KEY;
        }

        if (reason != null) {
            throw new ConfigurationException(reason + " cannot be null or empty");
        }
    }
}
