package com.finos.tradecapture.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

import javax.jms.ConnectionFactory;

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
     * Solace Connection Factory
     * Note: This is a development mock. In production, you would use the actual Solace JMS API.
     */
    @Bean
    public ConnectionFactory solaceConnectionFactory() {
        try {
            logger.info("Creating mock Solace connection factory for development");
            
            // For development, create a mock connection factory
            // In production, replace this with actual Solace connection factory:
            // SolConnectionFactory connectionFactory = new SolConnectionFactory();
            // connectionFactory.setHost(solaceHost);
            // connectionFactory.setPort(Integer.parseInt(solacePort));
            // connectionFactory.setUsername(solaceUsername);
            // connectionFactory.setPassword(solacePassword);
            // connectionFactory.setVPN(solaceVpn);
            
            // Return a mock connection factory for development
            return new org.springframework.jms.connection.SingleConnectionFactory() {
                @Override
                public javax.jms.Connection createConnection() throws javax.jms.JMSException {
                    logger.info("Mock connection created for development");
                    return new javax.jms.Connection() {
                        @Override
                        public javax.jms.Session createSession(boolean transacted, int acknowledgeMode) throws javax.jms.JMSException {
                            return new javax.jms.Session() {
                                @Override
                                public javax.jms.MessageProducer createProducer(javax.jms.Destination destination) throws javax.jms.JMSException {
                                    return null;
                                }
                                @Override
                                public javax.jms.MessageConsumer createConsumer(javax.jms.Destination destination) throws javax.jms.JMSException {
                                    return null;
                                }
                                @Override
                                public void close() throws javax.jms.JMSException {}
                                @Override
                                public void commit() throws javax.jms.JMSException {}
                                @Override
                                public void rollback() throws javax.jms.JMSException {}
                                @Override
                                public void recover() throws javax.jms.JMSException {}
                                @Override
                                public javax.jms.MessageListener getMessageListener() throws javax.jms.JMSException {
                                    return null;
                                }
                                @Override
                                public void setMessageListener(javax.jms.MessageListener listener) throws javax.jms.JMSException {}
                                @Override
                                public void run() {}
                                @Override
                                public javax.jms.Message createMessage() throws javax.jms.JMSException {
                                    return null;
                                }
                                @Override
                                public javax.jms.BytesMessage createBytesMessage() throws javax.jms.JMSException {
                                    return null;
                                }
                                @Override
                                public javax.jms.MapMessage createMapMessage() throws javax.jms.JMSException {
                                    return null;
                                }
                                @Override
                                public javax.jms.ObjectMessage createObjectMessage() throws javax.jms.JMSException {
                                    return null;
                                }
                                @Override
                                public javax.jms.ObjectMessage createObjectMessage(java.io.Serializable object) throws javax.jms.JMSException {
                                    return null;
                                }
                                @Override
                                public javax.jms.StreamMessage createStreamMessage() throws javax.jms.JMSException {
                                    return null;
                                }
                                @Override
                                public javax.jms.TextMessage createTextMessage() throws javax.jms.JMSException {
                                    return null;
                                }
                                @Override
                                public javax.jms.TextMessage createTextMessage(String text) throws javax.jms.JMSException {
                                    return null;
                                }
                                @Override
                                public boolean getTransacted() throws javax.jms.JMSException {
                                    return false;
                                }
                                @Override
                                public int getAcknowledgeMode() throws javax.jms.JMSException {
                                    return 0;
                                }
                            };
                        }
                        @Override
                        public javax.jms.Session createSession(int sessionMode) throws javax.jms.JMSException {
                            return createSession(false, sessionMode);
                        }
                        @Override
                        public javax.jms.Session createSession() throws javax.jms.JMSException {
                            return createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);
                        }
                        @Override
                        public String getClientID() throws javax.jms.JMSException {
                            return "mock-client";
                        }
                        @Override
                        public void setClientID(String clientID) throws javax.jms.JMSException {}
                        @Override
                        public javax.jms.ConnectionMetaData getMetaData() throws javax.jms.JMSException {
                            return null;
                        }
                        @Override
                        public javax.jms.ExceptionListener getExceptionListener() throws javax.jms.JMSException {
                            return null;
                        }
                        @Override
                        public void setExceptionListener(javax.jms.ExceptionListener listener) throws javax.jms.JMSException {}
                        @Override
                        public void start() throws javax.jms.JMSException {}
                        @Override
                        public void stop() throws javax.jms.JMSException {}
                        @Override
                        public void close() throws javax.jms.JMSException {}
                        @Override
                        public javax.jms.ConnectionConsumer createConnectionConsumer(javax.jms.Destination destination, String messageSelector, javax.jms.ServerSessionPool sessionPool, int maxMessages) throws javax.jms.JMSException {
                            return null;
                        }
                        @Override
                        public javax.jms.ConnectionConsumer createDurableConnectionConsumer(javax.jms.Topic topic, String subscriptionName, String messageSelector, javax.jms.ServerSessionPool sessionPool, int maxMessages) throws javax.jms.JMSException {
                            return null;
                        }
                        @Override
                        public javax.jms.ConnectionConsumer createSharedConnectionConsumer(javax.jms.Topic topic, String subscriptionName, String messageSelector, javax.jms.ServerSessionPool sessionPool, int maxMessages) throws javax.jms.JMSException {
                            return null;
                        }
                        @Override
                        public javax.jms.ConnectionConsumer createSharedDurableConnectionConsumer(javax.jms.Topic topic, String subscriptionName, String messageSelector, javax.jms.ServerSessionPool sessionPool, int maxMessages) throws javax.jms.JMSException {
                            return null;
                        }
                    };
                }
                @Override
                public javax.jms.Connection createConnection(String userName, String password) throws javax.jms.JMSException {
                    return createConnection();
                }
            };
            
        } catch (Exception e) {
            logger.error("Failed to create Solace connection factory", e);
            throw new RuntimeException("Solace connection factory creation failed", e);
        }
    }
} 