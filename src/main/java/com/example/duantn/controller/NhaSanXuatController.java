package com.example.duantn.controller;


import com.example.duantn.dto.Constant;
import com.example.duantn.model.NSX;
import com.example.duantn.request.NSXRequest;
import com.example.duantn.service.impl.NSXServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/nha-sx")
public class NhaSanXuatController {
    @Autowired
    NSXServiceImpl nhaSanXuatService;
    @GetMapping("/hien-thi")
    public String index(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") int currentPage,
            HttpServletRequest request
    ) {
        model.addAttribute("nhaSanXuat", new NSXRequest());
        String textSearch = request.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<NSX> pageNSX = nhaSanXuatService.layDanhSach( textSearch,pageable);
        List<NSX> nhaSanXuats = pageNSX.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL", pageNSX.getNumberOfElements());
        model.addAttribute("totalPage", pageNSX.getTotalPages());
        model.addAttribute("dsnhaSanXuat", nhaSanXuats);
        model.addAttribute("pageChoosedNumber", currentPage);
        return "admin/nhaSanXuat/create";
    }
    @GetMapping("/xoa/{id}")
    public String xoa(
            @PathVariable("id") UUID id
    ) {
        NSX nsxs  = nhaSanXuatService.chiTietTheoId(id);
        nhaSanXuatService.xoa(id);
        return "redirect:/nha-sx/hien-thi";
    }
    @PostMapping("/them")
    public String themMoi(Model model,
                          @Valid @ModelAttribute("nhaSanXuat")
                          NSXRequest request, BindingResult result,
                          @RequestParam(name = "page", defaultValue = "0")
                          int currentPage,
                          HttpServletRequest httpServletRequest)
            throws ParseException {
        if (result.hasErrors()) {
            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<NSX> pageNSX = nhaSanXuatService.layDanhSach(textSearch, pageable);
            List<NSX> nhaSanXuats = pageNSX.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageNSX.getNumberOfElements());
            model.addAttribute("totalPage", pageNSX.getTotalPages());
            model.addAttribute("dsnhaSanXuat", nhaSanXuats);
            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/nhaSanXuat/create";
        }


        if (nhaSanXuatService.kiemTraTrungMaKhong(request.getMa())) {
//            System.out.println("Trùng mã rồi ...");
            model.addAttribute("trungMa", true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<NSX> pageNSX = nhaSanXuatService.layDanhSach(textSearch, pageable);
            List<NSX> nhaSanXuats = pageNSX.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageNSX.getNumberOfElements());
            model.addAttribute("totalPage", pageNSX.getTotalPages());
            model.addAttribute("dsnhaSanXuat", nhaSanXuats);
            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/nhaSanXuat/create";
        }

        if (nhaSanXuatService.kiemTraTrungTenKhong(String.valueOf(request.getTen()))) {
            model.addAttribute("trungTen", true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<NSX> pageNSX = nhaSanXuatService.layDanhSach(textSearch, pageable);
            List<NSX> nhaSanXuats = pageNSX.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageNSX.getNumberOfElements());
            model.addAttribute("totalPage", pageNSX.getTotalPages());
            model.addAttribute("dsnhaSanXuat", nhaSanXuats);
            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/nhaSanXuat/create";
        }
        NSX nhaSanXuatThemMoi = new NSX();
        nhaSanXuatThemMoi.setId(null);
        nhaSanXuatThemMoi.setTen(request.getTen());
        nhaSanXuatThemMoi.setMa(request.getMa());
//        chucVuThemMoi.setMoTa(request.getMoTa());
        nhaSanXuatThemMoi.setNguoiTao(1);
        nhaSanXuatThemMoi.setNguoiSua(1);
        nhaSanXuatThemMoi.setNgayTao(Constant.getDateNow());
        nhaSanXuatThemMoi.setNgaySua(Constant.getDateNow());
        nhaSanXuatThemMoi.setTrangThai(request.getTrangThai());

        nhaSanXuatService.themMoi(nhaSanXuatThemMoi);
        model.addAttribute("nhaSanXuat", new NSXRequest());
        model.addAttribute("messageSuccess", true);

        String textSearch = httpServletRequest.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<NSX> pageNSX = nhaSanXuatService.layDanhSach(textSearch, pageable);
        List<NSX> nhaSanXuats = pageNSX.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL", pageNSX.getNumberOfElements());
        model.addAttribute("totalPage", pageNSX.getTotalPages());
        model.addAttribute("dsnhaSanXuat", nhaSanXuats);
        model.addAttribute("pageChoosedNumber", currentPage);
        return "admin/nhaSanXuat/create";
    }
    @GetMapping("/view-sua/{id}")
    public String view_sua(
            @PathVariable("id") UUID id,
            @ModelAttribute("nhaSanXuat") NSXRequest nhaSanXuat,
            Model model
    ) {
        NSX nhaSanXuat1 = nhaSanXuatService.chiTietTheoId(id);
        model.addAttribute("nhaSanXuat", nhaSanXuat1);

        return "admin/nhaSanXuat/update";
    }
    @PostMapping("/sua/{id}")
    public String sua(
            @PathVariable("id") UUID id,
            @Valid @ModelAttribute("nhaSanXuat") NSXRequest nhaSanXuat,
            BindingResult result,
            HttpServletRequest request,
            Model model
    ) throws ParseException {
        if (result.hasErrors()) {
            return "admin/nhaSanXuat/update";
        }

        NSX nhaSanXuatCu = nhaSanXuatService.chiTietTheoId(id);

        if (nhaSanXuatService.kiemTraTrungMaKhong(nhaSanXuat.getMa(), nhaSanXuatCu.getMa())) {
            model.addAttribute("trungMa", true);
            return "admin/nhaSanXuat/update";
        }

        if (nhaSanXuatService.kiemTraTrungTenKhong(nhaSanXuat.getTen(),nhaSanXuatCu.getTen())) {
            model.addAttribute("trungTen", true);
            return "admin/nhaSanXuat/update";
        }

        NSX nhaSanXuatUpdate = new NSX();
        nhaSanXuatUpdate.setId(nhaSanXuatCu.getId());
        nhaSanXuatUpdate.setMa(nhaSanXuat.getMa());
        nhaSanXuatUpdate.setTen(nhaSanXuat.getTen());
//        ChucVuUpdate.setMoTa(chucVuCu.getMoTa());

        Integer trangThai = nhaSanXuat.getTrangThai();
        nhaSanXuatUpdate.setTrangThai(trangThai);
        nhaSanXuatUpdate.setNgaySua(Constant.getDateNow());

        nhaSanXuatUpdate.setNgayTao(nhaSanXuatCu.getNgayTao());
        nhaSanXuatUpdate.setNguoiSua(nhaSanXuatCu.getNguoiSua());
        nhaSanXuatUpdate.setNguoiTao(nhaSanXuatCu.getNguoiTao());

        nhaSanXuatService.capNhat(nhaSanXuatUpdate);
        System.out.println("Sửa dữ liệu thành công");
        model.addAttribute("nhaSanXuat", nhaSanXuatUpdate);
        model.addAttribute("messageSuccess", true);

        return "admin/nhaSanXuat/update";
    }
}
