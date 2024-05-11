package com.example.duantn.controller.v2;

import com.example.duantn.model.HoaDon;
import com.example.duantn.service.v2.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v2/order")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/{id}")
    public HoaDon get(@PathVariable UUID id) {
        HoaDon hd = orderService.get(id);
        System.out.println(hd);
        return hd;
    }
}