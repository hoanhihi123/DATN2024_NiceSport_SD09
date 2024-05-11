package com.example.duantn.controller;

import com.example.duantn.dto.Constant;
import com.example.duantn.model.SanPham;
import com.example.duantn.request.SanPhamRequest;
import com.example.duantn.service.impl.SanPhamServiceImpl;
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
@RequestMapping("/san-pham")
public class SanPhamController {
    @Autowired
    SanPhamServiceImpl sanPhamService;

    @GetMapping("/hien-thi")
    public String index(
            Model model,
            @RequestParam(name = "page",defaultValue = "0") int currentPage ,
            HttpServletRequest request
    ) {
        model.addAttribute("sanPham", new SanPham());
        String textSearch = request.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<SanPham> pageSanPham =  sanPhamService.layDanhSach(textSearch, pageable);
        List<SanPham> sanPhams = pageSanPham.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL",pageSanPham.getNumberOfElements());
        model.addAttribute("totalPage",pageSanPham.getTotalPages());
        model.addAttribute("dsSanPham", sanPhams);
        model.addAttribute("pageChoosedNumber",currentPage);
        return "admin/sanPham/create";
    }

    @GetMapping("/view-sua/{id}")
    public String view_sua(
            @PathVariable("id") UUID id ,
            @ModelAttribute("sanPham") SanPhamRequest sanPhamRequest,
            Model model
    ) {
        SanPham sanPhamx = sanPhamService.chiTietTheoId(id);
        model.addAttribute("sanPham",sanPhamx);
//        System.out.println("muiGiay : " + muiGiayx.getId());
        return "admin/sanPham/update";
    }

    @PostMapping("/sua/{id}")
    public String sua(
            @PathVariable("id") UUID id ,
            @Valid @ModelAttribute("sanPham") SanPhamRequest sanPhamRequest,
            BindingResult result,
            HttpServletRequest request,
            Model model
    ) throws ParseException {
        if(result.hasErrors()){
            return "admin/sanPham/update";
        }

        SanPham sanPhamCu = sanPhamService.chiTietTheoId(id);

        if(sanPhamService.kiemTraTrungMaKhong(sanPhamRequest.getMa(), sanPhamCu.getMa())){
            model.addAttribute("trungMa",true);
            return "admin/sanPham/update";
        }

        if(sanPhamService.kiemTraTrungTenKhong(sanPhamRequest.getTen(), sanPhamCu.getTen())){
            model.addAttribute("trungTen",true);
            return "admin/sanPham/update";
        }

        SanPham sanPhamUpdate = new SanPham();
        sanPhamUpdate.setId(sanPhamCu.getId());
        sanPhamUpdate.setMa(sanPhamRequest.getMa());
        sanPhamUpdate.setTen(sanPhamRequest.getTen());
        sanPhamUpdate.setMoTa(sanPhamRequest.getMoTa());

        Integer trangThai = sanPhamRequest.getTrangThai();
        sanPhamUpdate.setTrangThai(trangThai);
        sanPhamUpdate.setNgaySua(Constant.getDateNow());

        sanPhamUpdate.setNgayTao(sanPhamCu.getNgayTao());
        sanPhamUpdate.setNguoiSua(sanPhamCu.getNguoiSua());
        sanPhamUpdate.setNguoiTao(sanPhamCu.getNguoiTao());

        sanPhamService.capNhat(sanPhamUpdate);
        model.addAttribute("sanPham",sanPhamRequest);
        model.addAttribute("messageSuccess",true);

        return "admin/sanPham/update";
    }

    @PostMapping("/them")
    public String themMoi(
            Model model,
            @Valid @ModelAttribute("sanPham") SanPhamRequest sanPhamRequest,
            BindingResult result ,
            @RequestParam(name = "page",defaultValue = "0") int currentPage ,
            HttpServletRequest httpServletRequest
    ) throws ParseException
    {
        if(result.hasErrors()){
            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<SanPham> pageSanPham =  sanPhamService.layDanhSach(textSearch, pageable);
            List<SanPham> sanPhams = pageSanPham.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL",pageSanPham.getNumberOfElements());
            model.addAttribute("totalPage",pageSanPham.getTotalPages());
            model.addAttribute("dsSanPham", sanPhams);
            model.addAttribute("pageChoosedNumber",currentPage);
            return "admin/sanPham/create";
        }

        if(sanPhamService.kiemTraTrungMaKhong(sanPhamRequest.getMa())){
//            System.out.println("Trùng mã rồi ...");
            model.addAttribute("trungMa",true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<SanPham> pageSanPham =  sanPhamService.layDanhSach(textSearch, pageable);
            List<SanPham> sanPhams = pageSanPham.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL",pageSanPham.getNumberOfElements());
            model.addAttribute("totalPage",pageSanPham.getTotalPages());
            model.addAttribute("dsSanPham", sanPhams);
            model.addAttribute("pageChoosedNumber",currentPage);
            return "admin/sanPham/create";
        }

        if(sanPhamService.kiemTraTrungTenKhong(String.valueOf(sanPhamRequest.getTen()))){
            model.addAttribute("trungTen",true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<SanPham> pageSanPham =  sanPhamService.layDanhSach(textSearch, pageable);
            List<SanPham> sanPhams = pageSanPham.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL",pageSanPham.getNumberOfElements());
            model.addAttribute("totalPage",pageSanPham.getTotalPages());
            model.addAttribute("dsSanPham", sanPhams);
            model.addAttribute("pageChoosedNumber",currentPage);
            return "admin/sanPham/create";
        }
        SanPham sanPhamThemMoi = new SanPham();
        sanPhamThemMoi.setId(null);
        sanPhamThemMoi.setTen(sanPhamRequest.getTen());
        sanPhamThemMoi.setMa(sanPhamRequest.getMa());
        sanPhamThemMoi.setMoTa(sanPhamRequest.getMoTa());
        sanPhamThemMoi.setNguoiTao(1);
        sanPhamThemMoi.setNguoiSua(1);
        sanPhamThemMoi.setNgayTao(Constant.getDateNow());
        sanPhamThemMoi.setNgaySua(Constant.getDateNow());
        sanPhamThemMoi.setTrangThai(sanPhamRequest.getTrangThai());

        sanPhamService.themMoi(sanPhamThemMoi);
        model.addAttribute("sanPham",new SanPhamRequest());
        model.addAttribute("messageSuccess",true);

        String textSearch = httpServletRequest.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<SanPham> pageSanPham =  sanPhamService.layDanhSach(textSearch, pageable);
        List<SanPham> sanPhams = pageSanPham.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL",pageSanPham.getNumberOfElements());
        model.addAttribute("totalPage",pageSanPham.getTotalPages());
        model.addAttribute("dsSanPham", sanPhams);
        model.addAttribute("pageChoosedNumber",currentPage);

        return "admin/sanPham/create";
    }

    @GetMapping("/xoa/{id}")
    public String xoa(
            @PathVariable("id") UUID id
    ) {
        SanPham sanPhamx = sanPhamService.chiTietTheoId(id);
        sanPhamService.xoa(id);
        return "redirect:/san-pham/hien-thi";
    }


}
