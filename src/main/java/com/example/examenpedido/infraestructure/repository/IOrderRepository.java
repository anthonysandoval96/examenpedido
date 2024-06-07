package com.example.examenpedido.infraestructure.repository;

import com.example.examenpedido.domain.entity.Order;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends ReactiveMongoRepository<Order, String> {

}
