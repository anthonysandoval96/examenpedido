package com.example.examenpedido.aplication;

import com.example.examenpedido.domain.entity.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IOrderService {

    public Flux<Order> getAllOrders();

    public Mono<Order> getOrderById(String id);

    public Mono<Order> createOrder(Order order);

    public Mono<Order> updateOrder(String id, Order order);

    public Mono<Void> deleteOrder(String id);

}
