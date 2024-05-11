package com.example.duantn.controller;


import com.example.duantn.dto.Constant;
import com.example.duantn.model.KhachHang;
import com.example.duantn.request.KhachHangRequest;
import com.example.duantn.service.impl.KhachHangServiceImpl;
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
@RequestMapping("/khach-hang")
public class KhachHangController {
    @Autowired
    KhachHangServiceImpl khachHangService;
    @GetMapping("/hien-thi")
    public String index(
            Model model,
            @RequestParam(name = "page",defaultValue = "0") int currentPage ,
            HttpServletRequest request
    ) {

        model.addAttribute("khachHang", new KhachHang());
        String textSearch = request.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<KhachHang> pageKhachHang = khachHangService.layDanhSach(textSearch, pageable);
        List<KhachHang> khachHangs = pageKhachHang.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL", pageKhachHang.getNumberOfElements());
        model.addAttribute("totalPage", pageKhachHang.getTotalPages());
        model.addAttribute("dsKhachHang", khachHangs);
        model.addAttribute("pageChoosedNumber", currentPage);
        return "admin/khachHang/create";
    }
    @GetMapping("/view-sua/{id}")
    public String view_sua(
            @PathVariable("id") UUID id,
            @ModelAttribute("khachHang") KhachHangRequest khachHang,
            Model model
    ) {
        KhachHang khachHang1 = khachHangService.chiTietTheoId(id);
        model.addAttribute("khachHang", khachHang1);
        return "admin/khachHang/update";
    }
    @PostMapping("/sua/{id}")
    public String sua(
            @PathVariable("id") UUID id ,
            @Valid  @ModelAttribute("khachHang") KhachHangRequest khachHang,
            BindingResult result ,
            HttpServletRequest request,
            Model model
    ) throws ParseException {

        if(result.hasErrors()){
            model.addAttribute("dsKhachHang",khachHangService.layDanhSach());
            System.out.println("Có lỗi nhưng không hiện lỗi");
            System.out.println("Lỗi tại : " + result.toString());
            return "admin/khachHang/update";
        }

        KhachHang khachHangCu = khachHangService.chiTietTheoId(id);

        if(khachHangService.kiemTraTrungMaKhong(khachHang.getMa(),khachHangCu.getMa())){
            model.addAttribute("trungMa",true);
            return "admin/sanPham/update";
        }

        if(khachHangService.kiemTraTrungTenKhong(khachHang.getHoTen(), khachHangCu.getHoTen())){
            model.addAttribute("trungTen",true);
            return "admin/sanPham/update";
        }

        KhachHang khachHangUpdate = new KhachHang();


        khachHangUpdate.setId(khachHangCu.getId());
        khachHangUpdate.setMa(khachHang.getMa());
        khachHangUpdate.setTaiKhoan(khachHang.getTaiKhoan());
//        khachHangUpdate.setMatKhau(khachHang.getMatKhau());
        khachHangUpdate.setHoTen(khachHang.getHoTen());
        khachHangUpdate.setGioiTinh(khachHang.getGioiTinh());
        khachHangUpdate.setEmail(khachHang.getEmail());
        khachHangUpdate.setSoDT(khachHang.getSoDT());
//        khachHangUpdate.setTrangThai(khachHang.getTrangThai());
//        khachHangUpdate.setNguoiTao(1);
//        khachHangUpdate.setNguoiSua(1);
//        khachHangUpdate.setNgayTao(Constant.getDateNow());
//        khachHangUpdate.setNgaySua(Constant.getDateNow());

        khachHangService.capNhat(khachHangUpdate);
        System.out.println("Sửa dữ liệu thành công");
        model.addAttribute("khachHang",khachHangUpdate);
        model.addAttribute("messageSuccess",true);

        return "admin/khachHang/update";
    }
    @PostMapping("/them")
    public String themMoi(
            Model model,
            @Valid @ModelAttribute("khachHang") KhachHangRequest khachHang,BindingResult result
    ) throws ParseException
    {
        if(result.hasErrors()){
            model.addAttribute("dsKhachHang",khachHangService.layDanhSach());
            System.out.println("Có lỗi nhưng không hiện lỗi");
            System.out.println("Lỗi tại : " + result.toString());
            return "admin/khachHang/create";
        }

        KhachHang khachHangThemMoi = new KhachHang();




        khachHangThemMoi.setId(null);
        khachHangThemMoi.setMa(khachHang.getMa());
        khachHangThemMoi.setTaiKhoan(khachHang.getTaiKhoan());
//        khachHangThemMoi.setMatKhau(khachHang.getMatKhau());
        khachHangThemMoi.setHoTen(khachHang.getHoTen());
        khachHangThemMoi.setGioiTinh(khachHang.getGioiTinh());
        khachHangThemMoi.setEmail(khachHang.getEmail());
        khachHangThemMoi.setSoDT(khachHang.getSoDT());

//        khachHangThemMoi.setTrangThai(khachHang.getTrangThai());
//
//        khachHangThemMoi.setNguoiTao(1);
//        khachHangThemMoi.setNguoiSua(1);
//        khachHangThemMoi.setNgayTao(Constant.getDateNow());
//        khachHangThemMoi.setNgaySua(Constant.getDateNow());

        khachHangService.themMoi(khachHangThemMoi);
        System.out.println("Thêm mới khách hàng thành công");
        return "redirect:/khach-hang/hien-thi" ;
    }

    @GetMapping("/xoa/{id}")
    public String xoa(
            @PathVariable("id") UUID id
    ) {
        khachHangService.xoa(id);
        return "redirect:/khach-hang/hien-thi";
    }
}

