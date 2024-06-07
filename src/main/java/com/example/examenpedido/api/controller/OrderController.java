package com.example.examenpedido.api.controller;

import com.example.examenpedido.aplication.impl.OrderService;
import com.example.examenpedido.crosscuting.utilitys.Constant;
import com.example.examenpedido.domain.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constant.API_BASE_PATH + "order")

public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public Flux<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Mono<Order> getProductById(@PathVariable String id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public Mono<Order> createProduct(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @PutMapping("/{id}")
    public Mono<Order> updateProduct(@PathVariable String id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id) {
        return orderService.deleteOrder(id);
    }
}
