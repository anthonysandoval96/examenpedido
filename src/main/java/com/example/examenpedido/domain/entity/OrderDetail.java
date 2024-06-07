package com.example.examenpedido.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orderdetail")

public class OrderDetail {
    @Id
    private String id;

    private int cantidad;

    private double importe;
}
