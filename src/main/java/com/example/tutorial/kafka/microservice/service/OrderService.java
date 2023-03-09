package com.example.tutorial.kafka.microservice.service;

import com.example.tutorial.kafka.microservice.domain.Order;
import com.example.tutorial.kafka.microservice.repository.OrderRepository;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {

    private final KafkaTemplate<Object, Object> template;

    private final OrderRepository repository;

    @KafkaListener(topics = "SaveOrder", groupId = "SaveOrderMicroservice")
    private void execute(ConsumerRecord<String, String> record){

        log.info("RECORD ->>>>>> " + record.value().toString());

        Order order = new Gson().fromJson(record.value(), Order.class);

        this.save(order);
    }

    public void save(Order order) {
        Order savedOrder = repository.save(order);
        log.info("Order saved >>> " + savedOrder.getId().toString());
    }

}
