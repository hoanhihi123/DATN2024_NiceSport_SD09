package com.example.duantn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThongKeController {


    @GetMapping("/thong-ke")
    public String viewThongKe() {
        return "admin/ThongKe/index";
    }
}