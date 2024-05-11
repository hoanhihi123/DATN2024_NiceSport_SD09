package com.example.duantn.controller;

import com.example.duantn.dto.Constant;
import com.example.duantn.model.DanhMuc;
import com.example.duantn.request.DanhMucRequest;
import com.example.duantn.service.impl.DanhMucServiceImpl;
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
@RequestMapping("/danh-muc")
public class DanhMucController {
    @Autowired
    DanhMucServiceImpl danhMucService;

    @GetMapping("/hien-thi")
    public String index(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") int currentPage,
            HttpServletRequest request
    ) {
        model.addAttribute("danhMuc", new DanhMuc());
        String textSearch = request.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<DanhMuc> pageDanhMuc = danhMucService.layDanhSach(textSearch, pageable);
        List<DanhMuc> danhMucs = pageDanhMuc.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL", pageDanhMuc.getNumberOfElements());
        model.addAttribute("totalPage", pageDanhMuc.getTotalPages());
        model.addAttribute("dsDanhMuc", danhMucs);
        model.addAttribute("pageChoosedNumber", currentPage);
        return "admin/danhMuc/create";
    }

    @GetMapping("/view-sua/{id}")
    public String view_sua(
            @PathVariable("id") UUID id,
            @ModelAttribute("danhMuc") DanhMucRequest danhMuc,
            Model model
    ) {
        DanhMuc danhMuc1 = danhMucService.chiTietTheoId(id);
        model.addAttribute("danhMuc", danhMuc1);
//        System.out.println("danhMuc : " + danhMuc1.getId());
        return "admin/danhMuc/update";
    }

    @PostMapping("/sua/{id}")
    public String sua(
            @PathVariable("id") UUID id,
            @Valid @ModelAttribute("danhMuc") DanhMucRequest danhMuc,
            BindingResult result,
            HttpServletRequest request,
            Model model
    ) throws ParseException {
        if (result.hasErrors()) {
            return "admin/danhMuc/update";
        }

        DanhMuc danhMucCu = danhMucService.chiTietTheoId(id);

        if (danhMucService.kiemTraTrungMaKhong(danhMuc.getMa(), danhMucCu.getMa())) {
            model.addAttribute("trungMa", true);
            return "admin/danhMuc/update";
        }

        if (danhMucService.kiemTraTrungTenKhong(danhMuc.getTen(), danhMucCu.getTen())) {
            model.addAttribute("trungTen", true);
            return "admin/danhMuc/update";
        }

        DanhMuc DanhMucUpdate = new DanhMuc();
        DanhMucUpdate.setId(danhMucCu.getId());
        DanhMucUpdate.setMa(danhMuc.getMa());
        DanhMucUpdate.setTen(danhMuc.getTen());
        DanhMucUpdate.setMoTa(danhMuc.getMoTa());

        Integer trangThai = danhMuc.getTrangThai();
        DanhMucUpdate.setTrangThai(trangThai);
        DanhMucUpdate.setNgaySua(Constant.getDateNow());

        DanhMucUpdate.setNgayTao(danhMucCu.getNgayTao());
        DanhMucUpdate.setNguoiSua(danhMucCu.getNguoiSua());
        DanhMucUpdate.setNguoiTao(danhMucCu.getNguoiTao());

        danhMucService.capNhat(DanhMucUpdate);
        model.addAttribute("danhMuc", danhMuc);
        model.addAttribute("messageSuccess", true);

        return "redirect:/danh-muc/hien-thi";
    }

    @PostMapping("/them")
    public String themMoi(Model model,
                          @Valid @ModelAttribute("danhMuc")
                          DanhMucRequest request, BindingResult result,
                          @RequestParam(name = "page", defaultValue = "0")
                          int currentPage,
                          HttpServletRequest httpServletRequest)
            throws ParseException {
        if (result.hasErrors()) {
            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<DanhMuc> pageDanhMuc = danhMucService.layDanhSach(textSearch, pageable);
            List<DanhMuc> danhMucs = pageDanhMuc.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageDanhMuc.getNumberOfElements());
            model.addAttribute("totalPage", pageDanhMuc.getTotalPages());
            model.addAttribute("dsDanhMuc", danhMucs);
            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/danhMuc/create";
        }


        if (danhMucService.kiemTraTrungMaKhong(request.getMa())) {
//            System.out.println("Trùng mã rồi ...");
            model.addAttribute("trungMa", true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<DanhMuc> pageDanhMuc = danhMucService.layDanhSach(textSearch, pageable);
            List<DanhMuc> danhMucs = pageDanhMuc.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageDanhMuc.getNumberOfElements());
            model.addAttribute("totalPage", pageDanhMuc.getTotalPages());
            model.addAttribute("dsDanhMuc", danhMucs);
            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/danhMuc/create";
        }

        if (danhMucService.kiemTraTrungTenKhong(String.valueOf(request.getTen()))) {
            model.addAttribute("trungTen", true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<DanhMuc> pageDanhMuc = danhMucService.layDanhSach(textSearch, pageable);
            List<DanhMuc> danhMucs = pageDanhMuc.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageDanhMuc.getNumberOfElements());
            model.addAttribute("totalPage", pageDanhMuc.getTotalPages());
            model.addAttribute("dsDanhMuc", danhMucs);
            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/danhMuc/create";
        }
        DanhMuc danhMucThemMoi = new DanhMuc();
        danhMucThemMoi.setId(null);
        danhMucThemMoi.setTen(request.getTen());
        danhMucThemMoi.setMa(request.getMa());
        danhMucThemMoi.setMoTa(request.getMoTa());
        danhMucThemMoi.setNguoiTao(1);
        danhMucThemMoi.setNguoiSua(1);
        danhMucThemMoi.setNgayTao(Constant.getDateNow());
        danhMucThemMoi.setNgaySua(Constant.getDateNow());
        danhMucThemMoi.setTrangThai(request.getTrangThai());

        danhMucService.themMoi(danhMucThemMoi);
        model.addAttribute("danhMuc", new DanhMucRequest());
        model.addAttribute("messageSuccess", true);

        String textSearch = httpServletRequest.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<DanhMuc> pageDanhMuc = danhMucService.layDanhSach(textSearch, pageable);
        List<DanhMuc> danhMucs = pageDanhMuc.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL", pageDanhMuc.getNumberOfElements());
        model.addAttribute("totalPage", pageDanhMuc.getTotalPages());
        model.addAttribute("dsDanhMuc", danhMucs);
        model.addAttribute("pageChoosedNumber", currentPage);
        return "admin/danhMuc/create";
    }

    @GetMapping("/xoa/{id}")
    public String xoa(
            @PathVariable("id") UUID id
    ) {
        DanhMuc danhMucx = danhMucService.chiTietTheoId(id);
        danhMucService.xoa(id);
        return "redirect:/danh-muc/hien-thi";
    }
}
