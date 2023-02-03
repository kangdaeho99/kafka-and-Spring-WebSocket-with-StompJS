package org.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.kafka.domain.MessageVO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
@EnableKafka
public class SenderConfig {
    @Bean
    public ProducerFactory<String, MessageVO> producerFactory() {
        return new DefaultKafkaProducerFactory<>(senderProps());
    }
    private Map<String, Object> senderProps() {
        Map<String, Object> props = new HashMap<>();
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "54.144.84.182:9092");
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "ec2-54-144-84-182.compute-1.amazonaws.com:9092");
        props.put(ProducerConfig.LINGER_MS_CONFIG, 10);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        //...
        return props;
    }
    @Bean
    public KafkaTemplate<String, MessageVO> kafkaTemplate(ProducerFactory<String, MessageVO> producerFactory) {
        return new KafkaTemplate<String, MessageVO>(producerFactory);
    }
}
