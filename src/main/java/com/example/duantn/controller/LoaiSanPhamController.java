package com.example.duantn.controller;

import com.example.duantn.dto.Constant;
import com.example.duantn.model.ChucVu;
import com.example.duantn.model.LoaiSanPham;
import com.example.duantn.request.ChucVuRequest;
import com.example.duantn.request.LoaiSanPhamRequest;
import com.example.duantn.service.impl.ChucVuServiceImpl;
import com.example.duantn.service.impl.LoaiSanPhamServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/loai-sp")
public class LoaiSanPhamController {
    @Autowired
    LoaiSanPhamServiceImpl loaiSanPhamService;
    @GetMapping("/hien-thi")
    public String index(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") int currentPage,
            HttpServletRequest request
    ) {
        model.addAttribute("loaiSanPham", new LoaiSanPhamRequest());
        String textSearch = request.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<LoaiSanPham> pageLoaiSanPham = loaiSanPhamService.layDanhSach( textSearch,pageable);
        List<LoaiSanPham> loaiSanPhams = pageLoaiSanPham.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL", pageLoaiSanPham.getNumberOfElements());
        model.addAttribute("totalPage", pageLoaiSanPham.getTotalPages());
        model.addAttribute("dsLoaiSanPham", loaiSanPhams);
        model.addAttribute("pageChoosedNumber", currentPage);
        return "admin/loaiSanPham/create";
    }
    @GetMapping("/view-sua/{id}")
    public String view_sua(
            @PathVariable("id") UUID id,
            @ModelAttribute("chucVu") ChucVuRequest chucVu,
            Model model
    ) {
        LoaiSanPham loaiSanPham1 = loaiSanPhamService.chiTietTheoId(id);
        model.addAttribute("loaiSanPham", loaiSanPham1);

        return "admin/loaiSanPham/update";
    }
    @PostMapping("/sua/{id}")
    public String sua(
            @PathVariable("id") UUID id,
            @Valid @ModelAttribute("loaiSanPham") LoaiSanPhamRequest loaiSanPham,
            BindingResult result,
            HttpServletRequest request,
            Model model
    ) throws ParseException {
        if (result.hasErrors()) {
            return "admin/loaiSanPham/update";
        }

        LoaiSanPham loaiSanPhamCu = loaiSanPhamService.chiTietTheoId(id);

        if (loaiSanPhamService.kiemTraTrungMaKhong(loaiSanPham.getMa(), loaiSanPhamCu.getMa())) {
            model.addAttribute("trungMa", true);
            return "admin/loaiSanPham/update";
        }

        if (loaiSanPhamService.kiemTraTrungTenKhong(loaiSanPham.getTen(),loaiSanPhamCu.getTen())) {
            model.addAttribute("trungTen", true);
            return "admin/loaiSanPham/update";
        }

        LoaiSanPham LoaiSanPhamUpdate = new LoaiSanPham();
        LoaiSanPhamUpdate.setId(loaiSanPhamCu.getId());
        LoaiSanPhamUpdate.setMa(loaiSanPham.getMa());
        LoaiSanPhamUpdate.setTen(loaiSanPham.getTen());
//        ChucVuUpdate.setMoTa(chucVuCu.getMoTa());

        Integer trangThai = loaiSanPham.getTrangThai();
        LoaiSanPhamUpdate.setTrangThai(trangThai);
        LoaiSanPhamUpdate.setNgaySua(Constant.getDateNow());

        LoaiSanPhamUpdate.setNgayTao(loaiSanPhamCu.getNgayTao());
        LoaiSanPhamUpdate.setNguoiSua(loaiSanPhamCu.getNguoiSua());
        LoaiSanPhamUpdate.setNguoiTao(loaiSanPhamCu.getNguoiTao());

        loaiSanPhamService.capNhat(LoaiSanPhamUpdate);
        System.out.println("Sửa dữ liệu thành công");
        model.addAttribute("loaiSanPham", LoaiSanPhamUpdate);
        model.addAttribute("messageSuccess", true);

        return "admin/loaiSanPham/update";
    }
    @PostMapping("/them")
    public String themMoi(Model model,
                          @Valid @ModelAttribute("loaiSanPham")
                          LoaiSanPhamRequest request, BindingResult result,
                          @RequestParam(name = "page", defaultValue = "0")
                          int currentPage,
                          HttpServletRequest httpServletRequest)
            throws ParseException {
        if (result.hasErrors()) {
            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<LoaiSanPham> pageLoaiSanPham = loaiSanPhamService.layDanhSach(textSearch, pageable);
            List<LoaiSanPham> loaiSanPhams = pageLoaiSanPham.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageLoaiSanPham.getNumberOfElements());
            model.addAttribute("totalPage", pageLoaiSanPham.getTotalPages());
            model.addAttribute("dsLoaiSanPham", loaiSanPhams);
            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/loaiSanPham/create";
        }


        if (loaiSanPhamService.kiemTraTrungMaKhong(request.getMa())) {
//            System.out.println("Trùng mã rồi ...");
            model.addAttribute("trungMa", true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<LoaiSanPham> pageLoaiSanPham = loaiSanPhamService.layDanhSach(textSearch, pageable);
            List<LoaiSanPham> loaiSanPhams = pageLoaiSanPham.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageLoaiSanPham.getNumberOfElements());
            model.addAttribute("totalPage", pageLoaiSanPham.getTotalPages());
            model.addAttribute("dsLoaiSanPham", loaiSanPhams);
            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/loaiSanPham/create";
        }

        if (loaiSanPhamService.kiemTraTrungTenKhong(String.valueOf(request.getTen()))) {
            model.addAttribute("trungTen", true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<LoaiSanPham> pageLoaiSanPham = loaiSanPhamService.layDanhSach(textSearch, pageable);
            List<LoaiSanPham> loaiSanPhams = pageLoaiSanPham.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageLoaiSanPham.getNumberOfElements());
            model.addAttribute("totalPage", pageLoaiSanPham.getTotalPages());
            model.addAttribute("dsLoaiSanPham", loaiSanPhams);
            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/loaiSanPham/create";
        }
        LoaiSanPham loaiSanPhamThemMoi = new LoaiSanPham();
        loaiSanPhamThemMoi.setId(null);
        loaiSanPhamThemMoi.setTen(request.getTen());
        loaiSanPhamThemMoi.setMa(request.getMa());

        loaiSanPhamThemMoi.setNguoiTao(1);
        loaiSanPhamThemMoi.setNguoiSua(1);
        loaiSanPhamThemMoi.setNgayTao(Constant.getDateNow());
        loaiSanPhamThemMoi.setNgaySua(Constant.getDateNow());
        loaiSanPhamThemMoi.setTrangThai(request.getTrangThai());


        model.addAttribute("loaiSanPham", new LoaiSanPhamRequest());
        model.addAttribute("messageSuccess", true);
        loaiSanPhamService.themMoi(loaiSanPhamThemMoi);
        String textSearch = httpServletRequest.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<LoaiSanPham> pageLoaiSanPham = loaiSanPhamService.layDanhSach(textSearch, pageable);
        List<LoaiSanPham> loaiSanPhams = pageLoaiSanPham.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL", pageLoaiSanPham.getNumberOfElements());
        model.addAttribute("totalPage", pageLoaiSanPham.getTotalPages());
        model.addAttribute("dsLoaiSanPham", loaiSanPhams);
        model.addAttribute("pageChoosedNumber", currentPage);
        return "admin/loaiSanPham/create";
    }
    @GetMapping("/xoa/{id}")
    public String xoa(
            @PathVariable("id") UUID id
    ) {
        LoaiSanPham loaiSanPhamx = loaiSanPhamService.chiTietTheoId(id);
        loaiSanPhamService.xoa(id);
        return "redirect:/loai-sp/hien-thi";
    }
}