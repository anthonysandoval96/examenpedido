package com.example.examenpedido.aplication.impl;

import com.example.examenpedido.aplication.IOrderDetailService;
import com.example.examenpedido.domain.entity.OrderDetail;
import com.example.examenpedido.infraestructure.repository.IOrderDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor

public class OrderDetailService implements IOrderDetailService {

    private final IOrderDetailRepository orderDetailRepository;

    @Override
    public Flux<OrderDetail> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    @Override
    public Mono<OrderDetail> getOrderDetailById(String id) {
        return orderDetailRepository.findById(id);
    }

    @Override
    public Mono<OrderDetail> createOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public Mono<OrderDetail> updateOrderDetail(String id, OrderDetail orderDetail) {
        return orderDetailRepository.findById(id)
                .flatMap(existingOrderDetail -> {
                    existingOrderDetail.setCantidad(orderDetail.getCantidad());
                    existingOrderDetail.setImporte(orderDetail.getImporte());
                    return orderDetailRepository.save(existingOrderDetail);
                });
    }

    @Override
    public Mono<Void> deleteOrderDetail(String id) {
        return orderDetailRepository.deleteById(id);
    }
}
