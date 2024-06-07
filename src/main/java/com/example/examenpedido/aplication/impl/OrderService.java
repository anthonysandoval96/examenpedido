package com.example.examenpedido.aplication.impl;

import com.example.examenpedido.aplication.IOrderService;
import com.example.examenpedido.domain.entity.Order;
import com.example.examenpedido.infraestructure.repository.IOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {

    private final IOrderRepository orderRepository;

    @Override
    public Flux<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Mono<Order> getOrderById(String id) {
        return orderRepository.findById(id);
    }

    @Override
    public Mono<Order> createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Mono<Order> updateOrder(String id, Order order) {
        return orderRepository.findById(id)
                .flatMap(existingOrder -> {
                    existingOrder.setFecha(order.getFecha());
                    existingOrder.setTotal(order.getTotal());
                    return orderRepository.save(existingOrder);
                });
    }

    @Override
    public Mono<Void> deleteOrder(String id) {
        return orderRepository.deleteById(id);
    }
}
