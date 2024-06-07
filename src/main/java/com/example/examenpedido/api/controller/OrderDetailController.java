package com.example.examenpedido.api.controller;

import com.example.examenpedido.aplication.impl.OrderDetailService;
import com.example.examenpedido.crosscuting.utilitys.Constant;
import com.example.examenpedido.domain.entity.OrderDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constant.API_BASE_PATH + "orderdetail")

public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    @GetMapping
    public Flux<OrderDetail> getAllOrderDetails() {
        return orderDetailService.getAllOrderDetails();
    }

    @GetMapping("/{id}")
    public Mono<OrderDetail> getProductById(@PathVariable String id) {
        return orderDetailService.getOrderDetailById(id);
    }

    @PostMapping
    public Mono<OrderDetail> createProduct(@RequestBody OrderDetail orderdetail) {
        return orderDetailService.createOrderDetail(orderdetail);
    }

    @PutMapping("/{id}")
    public Mono<OrderDetail> updateProduct(@PathVariable String id, @RequestBody OrderDetail orderdetail) {
        return orderDetailService.updateOrderDetail(id, orderdetail);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id) {
        return orderDetailService.deleteOrderDetail(id);
    }
}
