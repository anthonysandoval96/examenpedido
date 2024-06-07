package com.example.examenpedido.aplication;

import com.example.examenpedido.domain.entity.OrderDetail;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IOrderDetailService {

    public Flux<OrderDetail> getAllOrderDetails();

    public Mono<OrderDetail> getOrderDetailById(String id);

    public Mono<OrderDetail> createOrderDetail(OrderDetail orderDetail);

    public Mono<OrderDetail> updateOrderDetail(String id, OrderDetail orderDetail);

    public Mono<Void> deleteOrderDetail(String id);

}
