package com.finos.tradecapture.config;

import com.solacesystems.jms.SolConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.jms.ChannelPublishingJmsMessageListener;
import org.springframework.integration.jms.JmsMessageDrivenEndpoint;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.messaging.MessageChannel;

import javax.jms.ConnectionFactory;
import javax.jms.MessageListener;

/**
 * Solace Configuration
 * 
 * Configuration for Solace JMS connection and message processing.
 * Handles connection to Solace message broker for receiving raw trade messages.
 * 
 * @version 1.0.0
 */
@Configuration
public class SolaceConfig {

    private static final Logger logger = LoggerFactory.getLogger(SolaceConfig.class);

    @Value("${solace.host}")
    private String solaceHost;

    @Value("${solace.port}")
    private String solacePort;

    @Value("${solace.username}")
    private String solaceUsername;

    @Value("${solace.password}")
    private String solacePassword;

    @Value("${solace.vpn}")
    private String solaceVpn;

    @Value("${solace.queue.name}")
    private String queueName;

    @Value("${solace.connection.retries:3}")
    private int connectionRetries;

    @Value("${solace.connection.timeout:30000}")
    private int connectionTimeout;

    /**
     * Solace Connection Factory
     */
    @Bean
    public ConnectionFactory solaceConnectionFactory() {
        try {
            SolConnectionFactory connectionFactory = new SolConnectionFactory();
            
            // Connection properties
            connectionFactory.setHost(solaceHost);
            connectionFactory.setPort(Integer.parseInt(solacePort));
            connectionFactory.setUsername(solaceUsername);
            connectionFactory.setPassword(solacePassword);
            connectionFactory.setVPN(solaceVpn);
            
            // Connection settings
            connectionFactory.setReapplySubscriptions(true);
            connectionFactory.setConnectRetries(connectionRetries);
            connectionFactory.setConnectTimeout(connectionTimeout);
            connectionFactory.setReadTimeout(connectionTimeout);
            connectionFactory.setConnectTimeoutInMillis(connectionTimeout);
            
            // SSL/TLS settings (if required)
            // connectionFactory.setSSLTrustStore("path/to/truststore");
            // connectionFactory.setSSLTrustStorePassword("truststore-password");
            // connectionFactory.setSSLKeyStore("path/to/keystore");
            // connectionFactory.setSSLKeyStorePassword("keystore-password");
            
            logger.info("Solace connection factory configured for host: {}:{}", solaceHost, solacePort);
            return connectionFactory;
            
        } catch (Exception e) {
            logger.error("Failed to create Solace connection factory", e);
            throw new RuntimeException("Solace connection factory creation failed", e);
        }
    }

    /**
     * Raw Trade Message Channel
     */
    @Bean("rawTradeChannel")
    public MessageChannel rawTradeChannel() {
        return new DirectChannel();
    }

    /**
     * Processed Contract Message Channel
     */
    @Bean("processedContractChannel")
    public MessageChannel processedContractChannel() {
        return new DirectChannel();
    }

    /**
     * Error Message Channel
     */
    @Bean("errorChannel")
    public MessageChannel errorChannel() {
        return new DirectChannel();
    }

    /**
     * JMS Message Listener Container
     */
    @Bean
    public DefaultMessageListenerContainer jmsMessageListenerContainer() {
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(solaceConnectionFactory());
        container.setDestinationName(queueName);
        container.setMessageListener(rawTradeMessageListener());
        container.setConcurrentConsumers(5);
        container.setMaxConcurrentConsumers(10);
        container.setSessionTransacted(true);
        container.setAutoStartup(true);
        
        logger.info("JMS message listener container configured for queue: {}", queueName);
        return container;
    }

    /**
     * Raw Trade Message Listener
     */
    @Bean
    public MessageListener rawTradeMessageListener() {
        ChannelPublishingJmsMessageListener listener = new ChannelPublishingJmsMessageListener();
        listener.setChannel(rawTradeChannel());
        return listener;
    }

    /**
     * JMS Message Driven Endpoint
     */
    @Bean
    public JmsMessageDrivenEndpoint jmsMessageDrivenEndpoint() {
        return new JmsMessageDrivenEndpoint(jmsMessageListenerContainer(), rawTradeMessageListener());
    }
} 