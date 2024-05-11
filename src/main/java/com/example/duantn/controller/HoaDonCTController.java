package com.example.duantn.controller;

import com.example.duantn.model.HoaDonChiTiet;
import com.example.duantn.record.OrderDetailRecord;
import com.example.duantn.repository.HoaDonCTRepository;
import com.example.duantn.service.impl.HoaDonCTServiceImpl;
import com.example.duantn.service.impl.HoaDonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/hoa-donct")
public class HoaDonCTController {
    @Autowired
    HoaDonCTRepository hoaDonCTRepository;

    @Autowired
    HoaDonCTServiceImpl hoaDonCtService;

    @Autowired
    HoaDonServiceImpl hoaDonService;

    //hienthi
    @GetMapping("/hien-thi")
    public String getAll(Model model,
                         @RequestParam(value = "page", defaultValue = "0") int page) {
        Integer size = 5;
        Pageable pageable = PageRequest.of(page, size);
        model.addAttribute("hoaDonCT", new HoaDonChiTiet());
        model.addAttribute("listHDCT", hoaDonCTRepository.findAll(pageable).getContent());
        model.addAttribute("totalPage", hoaDonCTRepository.findAll(pageable).getTotalElements());
        model.addAttribute("listHD", hoaDonService.getAll());
        return "admin/HoaDonCTForm/trangChu";
    }

    //detail
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable String id, Model model) {
        List<OrderDetailRecord> orderDetailList = hoaDonCtService.findByOrderId(UUID.fromString(id));
        model.addAttribute("orderDetailList", orderDetailList);
        return "admin/HoaDonForm/detail";
    }

    //delete
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        hoaDonCtService.xoa(UUID.fromString(id));
        return "redirect:/hoa-donct/hien-thi";
    }

    //add
    @PostMapping("/add")
    public String add(@Validated @ModelAttribute("hoaDonCT") HoaDonChiTiet hoaDonCT) {
        hoaDonCtService.themMoi(hoaDonCT);
        return "redirect:/hoa-donct/hien-thi";
    }

    //update
    @PostMapping("/update/{id}")
    public String update(@PathVariable String id, @ModelAttribute("hoaDonCT") HoaDonChiTiet hoaDonCT) {
        hoaDonCtService.capNhat(UUID.fromString(id), hoaDonCT);
        return "redirect:/hoa-donct/hien-thi";
    }
}