package com.pb.swap.rules.admin.trace;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pb.swap.rules.core.trace.DecisionTrace;
import com.pb.swap.rules.core.trace.TraceSink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

public final class KafkaTraceSink implements TraceSink {
    private static final Logger log = LoggerFactory.getLogger(KafkaTraceSink.class);
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic;
    private final ObjectMapper mapper = new ObjectMapper();

    public KafkaTraceSink(KafkaTemplate<String, String> kafkaTemplate, String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @Override
    public void publishAsync(DecisionTrace trace) {
        try {
            String json = mapper.writeValueAsString(trace);
            kafkaTemplate.send(topic, trace.tradeId(), json);
        } catch (Exception e) {
            log.warn("Failed to publish trace {}: {}", trace.traceId(), e.getMessage());
        }
    }
}
