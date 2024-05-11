package com.example.duantn.controller;


import com.example.duantn.dto.Constant;
import com.example.duantn.model.ChucVu;
import com.example.duantn.request.ChucVuRequest;
import com.example.duantn.service.impl.ChucVuServiceImpl;
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
@RequestMapping("/chuc-vu")
public class ChucVuController {
    @Autowired
    ChucVuServiceImpl chucVuService;
    @GetMapping("/hien-thi")
    public String index(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") int currentPage,
            HttpServletRequest request
    ) {
        model.addAttribute("chucVu", new ChucVuRequest());
        String textSearch = request.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<ChucVu> pageChucVu = chucVuService.layDanhSach( textSearch,pageable);
        List<ChucVu> chucVus = pageChucVu.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL", pageChucVu.getNumberOfElements());
        model.addAttribute("totalPage", pageChucVu.getTotalPages());
        model.addAttribute("dsChucVu", chucVus);
        model.addAttribute("pageChoosedNumber", currentPage);
        return "admin/chucVu/create";
    }
    @GetMapping("/view-sua/{id}")
    public String view_sua(
            @PathVariable("id") UUID id,
            @ModelAttribute("chucVu") ChucVuRequest chucVu,
            Model model
    ) {
        ChucVu chucVu1 = chucVuService.chiTietTheoId(id);
        model.addAttribute("chucVu", chucVu1);

        return "admin/chucVu/update";
    }
    @PostMapping("/sua/{id}")
    public String sua(
            @PathVariable("id") UUID id,
            @Valid @ModelAttribute("chucVu") ChucVuRequest chucVu,
            BindingResult result,
            HttpServletRequest request,
            Model model
    ) throws ParseException {
        if (result.hasErrors()) {
            return "admin/chucVu/update";
        }

        ChucVu chucVuCu = chucVuService.chiTietTheoId(id);

        if (chucVuService.kiemTraTrungMaKhong(chucVu.getMa(), chucVuCu.getMa())) {
            model.addAttribute("trungMa", true);
            return "admin/chucVu/update";
        }

        if (chucVuService.kiemTraTrungTenKhong(chucVu.getTen(),chucVuCu.getTen())) {
            model.addAttribute("trungTen", true);
            return "admin/chucVu/update";
        }

        ChucVu ChucVuUpdate = new ChucVu();
        ChucVuUpdate.setId(chucVuCu.getId());
        ChucVuUpdate.setMa(chucVu.getMa());
        ChucVuUpdate.setTen(chucVu.getTen());
//        ChucVuUpdate.setMoTa(chucVuCu.getMoTa());

        Integer trangThai = chucVu.getTrangThai();
        ChucVuUpdate.setTrangThai(trangThai);
        ChucVuUpdate.setNgaySua(Constant.getDateNow());

        ChucVuUpdate.setNgayTao(chucVuCu.getNgayTao());
        ChucVuUpdate.setNguoiSua(chucVuCu.getNguoiSua());
        ChucVuUpdate.setNguoiTao(chucVuCu.getNguoiTao());

        chucVuService.capNhat(ChucVuUpdate);
        System.out.println("Sửa dữ liệu thành công");
        model.addAttribute("chucVu", ChucVuUpdate);
        model.addAttribute("messageSuccess", true);

        return "admin/chucVu/update";
    }
    @PostMapping("/them")
    public String themMoi(Model model,
                          @Valid @ModelAttribute("chucVu")
                                  ChucVuRequest request, BindingResult result,
                          @RequestParam(name = "page", defaultValue = "0")
                                  int currentPage,
                          HttpServletRequest httpServletRequest)
            throws ParseException {
        if (result.hasErrors()) {
            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<ChucVu> pageChucVu = chucVuService.layDanhSach(textSearch, pageable);
            List<ChucVu> chucVus = pageChucVu.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageChucVu.getNumberOfElements());
            model.addAttribute("totalPage", pageChucVu.getTotalPages());
            model.addAttribute("dsChucVu", chucVus);
            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/chucVu/create";
        }


        if (chucVuService.kiemTraTrungMaKhong(request.getMa())) {
//            System.out.println("Trùng mã rồi ...");
            model.addAttribute("trungMa", true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<ChucVu> pageChucVu = chucVuService.layDanhSach(textSearch, pageable);
            List<ChucVu> chucVus = pageChucVu.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageChucVu.getNumberOfElements());
            model.addAttribute("totalPage", pageChucVu.getTotalPages());
            model.addAttribute("dsChucVu", chucVus);
            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/chucVu/create";
        }

        if (chucVuService.kiemTraTrungTenKhong(String.valueOf(request.getTen()))) {
            model.addAttribute("trungTen", true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<ChucVu> pageChucVu = chucVuService.layDanhSach(textSearch, pageable);
            List<ChucVu> chucVus = pageChucVu.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageChucVu.getNumberOfElements());
            model.addAttribute("totalPage", pageChucVu.getTotalPages());
            model.addAttribute("dsChucVu", chucVus);
            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/chucVu/create";
        }
        ChucVu chucVuThemMoi = new ChucVu();
        chucVuThemMoi.setId(null);
        chucVuThemMoi.setTen(request.getTen());
        chucVuThemMoi.setMa(request.getMa());
//        chucVuThemMoi.setMoTa(request.getMoTa());
        chucVuThemMoi.setNguoiTao(1);
        chucVuThemMoi.setNguoiSua(1);
        chucVuThemMoi.setNgayTao(Constant.getDateNow());
        chucVuThemMoi.setNgaySua(Constant.getDateNow());
        chucVuThemMoi.setTrangThai(request.getTrangThai());

        chucVuService.themMoi(chucVuThemMoi);
        model.addAttribute("chucVu", new ChucVuRequest());
        model.addAttribute("messageSuccess", true);

        String textSearch = httpServletRequest.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<ChucVu> pageChucVu = chucVuService.layDanhSach(textSearch, pageable);
        List<ChucVu> chucVus = pageChucVu.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL", pageChucVu.getNumberOfElements());
        model.addAttribute("totalPage", pageChucVu.getTotalPages());
        model.addAttribute("dsChucVu", chucVus);
        model.addAttribute("pageChoosedNumber", currentPage);
        return "admin/chucVu/create";
    }
    @GetMapping("/xoa/{id}")
    public String xoa(
            @PathVariable("id") UUID id
    ) {
        ChucVu chucVux = chucVuService.chiTietTheoId(id);
        chucVuService.xoa(id);
        return "redirect:/chuc-vu/hien-thi";
    }

}
