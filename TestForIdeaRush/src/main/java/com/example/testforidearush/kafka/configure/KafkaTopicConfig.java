package com.example.testforidearush.kafka.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

//    @Value(value = "${spring.kafka.bootstrap-servers}")
//    private String bootstrapAddress = "3.37.88.128:9092";
//
//    @Bean
//    public KafkaAdmin kafkaAdmin() {
//        Map<String, Object> configs = new HashMap<>();
//        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
//        return new KafkaAdmin(configs);
//    }
//
//    @Bean
//    public NewTopic topic1() {
//        return new NewTopic("baeldung", 1, (short) 1);
//    }
}