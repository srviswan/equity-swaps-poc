package com.finos.tradecapture.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.jms.ChannelPublishingJmsMessageListener;
import org.springframework.integration.jms.JmsMessageDrivenEndpoint;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.messaging.MessageChannel;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

/**
 * Solace Configuration
 * 
 * Configuration for JMS connection and message processing.
 * Handles connection to message broker for receiving raw trade messages.
 * 
 * @version 1.0.0
 */
@Configuration
@EnableJms
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
     * Raw Trade Message Channel
     */
    @Bean("rawTradeChannel")
    public MessageChannel rawTradeChannel() {
        logger.info("Raw trade channel configured");
        return new DirectChannel();
    }

    /**
     * Processed Contract Message Channel
     */
    @Bean("processedContractChannel")
    public MessageChannel processedContractChannel() {
        logger.info("Processed contract channel configured");
        return new DirectChannel();
    }

    /**
     * Error Message Channel
     */
    @Bean("errorChannel")
    public MessageChannel errorChannel() {
        logger.info("Error channel configured");
        return new DirectChannel();
    }

    /**
     * Raw Trades Queue
     */
    @Bean("rawTradesQueue")
    public Queue rawTradesQueue() {
        logger.info("Raw trades queue configured: {}", queueName);
        return new org.apache.activemq.command.ActiveMQQueue(queueName);
    }

    /**
     * JMS Message Listener Container
     */
    @Bean
    public DefaultMessageListenerContainer jmsMessageListenerContainer(ConnectionFactory connectionFactory) {
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setDestination(rawTradesQueue());
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
    public ChannelPublishingJmsMessageListener rawTradeMessageListener() {
        ChannelPublishingJmsMessageListener listener = new ChannelPublishingJmsMessageListener();
        listener.setRequestChannel(rawTradeChannel());
        return listener;
    }

    /**
     * JMS Message Driven Endpoint
     */
    @Bean
    public JmsMessageDrivenEndpoint jmsMessageDrivenEndpoint(DefaultMessageListenerContainer container) {
        return new JmsMessageDrivenEndpoint(container, rawTradeMessageListener());
    }
} 