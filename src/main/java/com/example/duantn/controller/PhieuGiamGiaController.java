package com.example.duantn.controller;

import com.example.duantn.model.PhieuGiamGia;
import com.example.duantn.repository.PhieuGiamGiaRepository;
import com.example.duantn.service.PhieuGiamGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/phieu-giam-gia")
public class PhieuGiamGiaController {
    @Autowired
    PhieuGiamGiaRepository phieuGiamGiaRepository;
    @Autowired
    PhieuGiamGiaService phieuGiamGiaService;

    //hienthi
    @GetMapping("/hien-thi")
    public String getAll(Model model,
                         @RequestParam(value = "page",defaultValue = "0")int page){
        Integer  size = 5;
        Pageable pageable = PageRequest.of(page,size);
        model.addAttribute("phieuGiam",new PhieuGiamGia());
        model.addAttribute("listPG",phieuGiamGiaRepository.findAll(pageable).getContent());
        model.addAttribute("totalPage",phieuGiamGiaRepository.findAll(pageable).getTotalElements());
        return "/admin/PhieuGiamGiaForm/trangChu";
    }
    //detail
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable String id,Model model){
        PhieuGiamGia phieuGiamGia = phieuGiamGiaService.detail(UUID.fromString(id));
        model.addAttribute("phieuGiam",phieuGiamGia);
        return "/admin/PhieuGiamGiaForm/update";
    }
    //delete
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        phieuGiamGiaService.delete(UUID.fromString(id));
        return "redirect:/phieu-giam-gia/hien-thi";
    }
    //add
    @PostMapping("/add")
    public String add(@Validated @ModelAttribute("phieuGiam")PhieuGiamGia phieuGiamGia){
        phieuGiamGiaService.add(phieuGiamGia);
        return "redirect:/phieu-giam-gia/hien-thi";
    }
    //update
    @PostMapping("/update/{id}")
    public String update(@PathVariable String id,@ModelAttribute("phieuGiam")PhieuGiamGia phieuGiamGia){
        phieuGiamGiaService.update(UUID.fromString(id),phieuGiamGia);
        return "redirect:/phieu-giam-gia/hien-thi";
    }

}
