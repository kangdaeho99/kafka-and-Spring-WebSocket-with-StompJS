package org.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.kafka.domain.MessageVO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;


@Configuration
@EnableKafka
public class ListenerConfig {
	
    @Bean
    ConcurrentKafkaListenerContainerFactory<String, MessageVO>
                        kafkaListenerContainerFactory(ConsumerFactory<String, MessageVO> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<String, MessageVO> factory =
                                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }

    @Bean
    public ConsumerFactory<String, MessageVO> consumerFactory() {
    	//Deserializer 사용을 위해서는 아래와 같이 사용합니다. https://stackoverflow.com/questions/42419526/kafkaexception-could-not-instantiate-class-jsondeserializer
        return new DefaultKafkaConsumerFactory<>(consumerProps(), new StringDeserializer(), new JsonDeserializer<>(MessageVO.class));
    }
    
    private Map<String, Object> consumerProps() {
        Map<String, Object> props = new HashMap<>();
        
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "54.144.84.182:9092");
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "ec2-54-144-84-182.compute-1.amazonaws.com:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "group");
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        // ...
        return props;
    }
    
}
