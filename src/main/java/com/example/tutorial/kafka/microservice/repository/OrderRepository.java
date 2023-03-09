package com.example.tutorial.kafka.microservice.repository;

import com.example.tutorial.kafka.microservice.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {



}
