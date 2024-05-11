package com.example.duantn.controller;

import com.example.duantn.dto.Constant;
import com.example.duantn.model.KieuDang;
import com.example.duantn.request.KieuDangReques;
import com.example.duantn.service.impl.KieuDangServiceImpl;
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
@RequestMapping("/kieu-dang")
public class KieuDangController {
    @Autowired
    KieuDangServiceImpl kieuDangService;

    @GetMapping("/hien-thi")
    public String index(
            Model model,
            @RequestParam(name = "page",defaultValue = "0") int currentPage ,
            HttpServletRequest request
    ) {

        model.addAttribute("kieuDang", new KieuDang());
        String textSearch = request.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<KieuDang> pageKieuDang =  kieuDangService.layDanhSach(textSearch, pageable);
        List<KieuDang> kieuDangs = pageKieuDang.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL",pageKieuDang.getNumberOfElements());
        model.addAttribute("totalPage",pageKieuDang.getTotalPages());
        model.addAttribute("listKD", kieuDangs);
        model.addAttribute("pageChoosedNumber",currentPage);
        return "admin/KieuDangForm/trangChu";
    }

    @GetMapping("/view-sua/{id}")
    public String view_sua(
            @PathVariable("id") UUID id ,
            @ModelAttribute("kieuDang") KieuDangReques kieuDang,
            Model model
    ) {
        KieuDang kieuDangx = kieuDangService.chiTietTheoId(id);
        model.addAttribute("kieuDang",kieuDangx);
        return "admin/KieuDangForm/update";
    }

    @PostMapping("/sua/{id}")
    public String sua(
            @PathVariable("id") UUID id ,
            @Valid @ModelAttribute("kieuDang") KieuDangReques kieuDang,
            BindingResult result ,
            HttpServletRequest request ,
            Model model
    ) throws ParseException {

        if(result.hasErrors()){
            return "admin/KieuDangForm/update";
        }

        KieuDang kieuDangcu = kieuDangService.chiTietTheoId(id);

        if(kieuDangService.kiemTraTrungMaKhong(kieuDang.getMa(), kieuDangcu.getMa())){
            model.addAttribute("trungMa",true);
            return "admin/KieuDangForm/update";
        }

        if(kieuDangService.kiemTraTrungTenKhong(String.valueOf(kieuDang.getTen()), kieuDangcu.getTen())){
            model.addAttribute("trungTen",true);
            return "admin/KieuDangForm/update";
        }

        KieuDang kichThuocUpdate = new KieuDang();
        kichThuocUpdate.setId(kieuDangcu.getId());
        kichThuocUpdate.setMa(kieuDang.getMa());
        kichThuocUpdate.setTen(String.valueOf(kieuDang.getTen()));
        kichThuocUpdate.setMoTa(kieuDang.getMoTa());

        Integer trangThai = kieuDang.getTrangThai();
        kichThuocUpdate.setTrangThai(trangThai);
        kichThuocUpdate.setNgaySua(Constant.getDateNow());

        kichThuocUpdate.setNgayTao(kieuDangcu.getNgayTao());
        kichThuocUpdate.setNguoiSua(kieuDangcu.getNguoiSua());
        kichThuocUpdate.setNguoiTao(kieuDangcu.getNguoiTao());

        kieuDangService.capNhat(kichThuocUpdate);
        System.out.println("Sửa dữ liệu thành công");

        model.addAttribute("kieuDang",kieuDang);
        model.addAttribute("messageSuccess",true);

        return "admin/KieuDangForm/update";
    }

    @PostMapping("/them")
    public String themMoi(
            Model model,
            @Valid @ModelAttribute("kieuDang") KieuDangReques request,
            BindingResult result ,
            @RequestParam(name = "page",defaultValue = "0") int currentPage ,
            HttpServletRequest httpServletRequest
    ) throws ParseException
    {
        if(result.hasErrors()){
            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage,Constant.pageNumber);
            Page<KieuDang> pageKieuDang =  kieuDangService.layDanhSach(textSearch, pageable);
            List<KieuDang> kieuDangs = pageKieuDang.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL",pageKieuDang.getNumberOfElements());
            model.addAttribute("totalPage",pageKieuDang.getTotalPages());
            model.addAttribute("listKD", kieuDangs);
            model.addAttribute("pageChoosedNumber",currentPage);
//            System.out.println("Lỗi nhưng không hiển thị lỗi");
//            System.out.println("Error basic : " + result.toString());
            return "admin/KieuDangForm/trangChu";
        }
//        System.out.println("Mã request : " + request.getMa());
        if(kieuDangService.kiemTraTrungMaKhong(request.getMa())){
//            System.out.println("Trùng mã rồi ...");
            model.addAttribute("trungMa",true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<KieuDang> pageKieuDang =  kieuDangService.layDanhSach(textSearch, pageable);
            List<KieuDang> kieuDangs = pageKieuDang.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL",pageKieuDang.getNumberOfElements());
            model.addAttribute("totalPage",pageKieuDang.getTotalPages());
            model.addAttribute("listKD", kieuDangs);
            return "admin/KieuDangForm/trangChu";
        }

        if(kieuDangService.kiemTraTrungTenKhong(String.valueOf(request.getTen()))){
            model.addAttribute("trungTen",true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<KieuDang> pageKieuDang =  kieuDangService.layDanhSach(textSearch, pageable);
            List<KieuDang> kieuDangs = pageKieuDang.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL",pageKieuDang.getNumberOfElements());
            model.addAttribute("totalPage",pageKieuDang.getTotalPages());
            model.addAttribute("listKD", kieuDangs);
            return "admin/KieuDangForm/trangChu";
        }

        KieuDang KieuDangThemMoi = new KieuDang();
        KieuDangThemMoi.setMa(request.getMa());
        KieuDangThemMoi.setTen(String.valueOf(request.getTen()));
        KieuDangThemMoi.setMoTa(request.getMoTa());
        KieuDangThemMoi.setNguoiTao(1);
        KieuDangThemMoi.setNguoiSua(1);
        KieuDangThemMoi.setNgayTao(Constant.getDateNow());
        KieuDangThemMoi.setNgaySua(Constant.getDateNow());
        KieuDangThemMoi.setTrangThai(1);

        kieuDangService.themMoi(KieuDangThemMoi);

        model.addAttribute("kieuDang",new KieuDangReques());
        model.addAttribute("messageSuccess",true);

        // cập nhật nội dung mới lên table
        String textSearch = httpServletRequest.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage,Constant.pageNumber);
        Page<KieuDang> pageKieuDang =  kieuDangService.layDanhSach(textSearch, pageable);
        List<KieuDang> kieuDangs = pageKieuDang.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL",pageKieuDang.getNumberOfElements());
        model.addAttribute("totalPage",pageKieuDang.getTotalPages());
        model.addAttribute("listKD", kieuDangs);
        model.addAttribute("pageChoosedNumber",currentPage);

        return "admin/KieuDangForm/trangChu";
    }

    @GetMapping("/xoa/{id}")
    public String xoa(
            @PathVariable("id") UUID id
    ) {
        KieuDang kieuDangx = kieuDangService.chiTietTheoId(id);
        kieuDangService.xoa(id);
        return "redirect:/kieu-dang/hien-thi";
    }
}
