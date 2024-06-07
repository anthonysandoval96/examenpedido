package com.example.examenpedido.infraestructure.repository;

import com.example.examenpedido.domain.entity.Order;
import com.example.examenpedido.domain.entity.OrderDetail;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDetailRepository extends ReactiveMongoRepository<OrderDetail, String> {
}
