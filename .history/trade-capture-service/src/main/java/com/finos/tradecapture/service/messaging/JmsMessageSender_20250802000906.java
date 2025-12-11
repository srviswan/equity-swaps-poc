package com.finos.tradecapture.service.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finos.tradecapture.model.RawTrade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

/**
 * JMS Message Sender
 * 
 * Service for sending raw trade messages to the JMS queue.
 * Used for testing and development with ActiveMQ.
 * 
 * @version 1.0.0
 */
@Service
public class JmsMessageSender {

    private static final Logger logger = LoggerFactory.getLogger(JmsMessageSender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue rawTradesQueue;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${solace.queue.name}")
    private String queueName;

    /**
     * Send a raw trade message to the queue
     */
    public void sendRawTrade(RawTrade rawTrade) {
        try {
            String message = objectMapper.writeValueAsString(rawTrade);
            logger.info("Sending raw trade to queue: {}", queueName);
            logger.info("Trade ID: {}, Instrument: {}, Side: {}, Quantity: {}", 
                rawTrade.getTradeId(), rawTrade.getInstrumentId(), 
                rawTrade.getSide(), rawTrade.getQuantity());
            
            jmsTemplate.convertAndSend(rawTradesQueue, message);
            logger.info("Successfully sent trade {} to queue", rawTrade.getTradeId());
            
        } catch (Exception e) {
            logger.error("Failed to send trade {} to queue", rawTrade.getTradeId(), e);
            throw new RuntimeException("Failed to send message to queue", e);
        }
    }

    /**
     * Send a raw trade message to the queue using queue name
     */
    public void sendRawTradeToQueue(RawTrade rawTrade, String destinationQueue) {
        try {
            String message = objectMapper.writeValueAsString(rawTrade);
            logger.info("Sending raw trade to queue: {}", destinationQueue);
            logger.info("Trade ID: {}, Instrument: {}, Side: {}, Quantity: {}", 
                rawTrade.getTradeId(), rawTrade.getInstrumentId(), 
                rawTrade.getSide(), rawTrade.getQuantity());
            
            jmsTemplate.convertAndSend(destinationQueue, message);
            logger.info("Successfully sent trade {} to queue {}", rawTrade.getTradeId(), destinationQueue);
            
        } catch (Exception e) {
            logger.error("Failed to send trade {} to queue {}", rawTrade.getTradeId(), destinationQueue, e);
            throw new RuntimeException("Failed to send message to queue", e);
        }
    }
} 