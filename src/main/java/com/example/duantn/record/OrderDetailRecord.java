
package com.example.duantn.record;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
public class OrderDetailRecord {
    private UUID orderId;
    private String orderCode;
    private String productName;
    private Double price;
    private Integer quantity;
    private Double totalMoney;
}