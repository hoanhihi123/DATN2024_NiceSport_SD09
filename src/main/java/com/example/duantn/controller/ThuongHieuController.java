package com.example.duantn.controller;


import com.example.duantn.dto.Constant;
import com.example.duantn.model.ThuongHieu;
import com.example.duantn.request.DayGiayRequest;
import com.example.duantn.request.ThuongHieuRequest;
import com.example.duantn.service.impl.ThuongHieuServiceImpl;
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
@RequestMapping("/thuong-hieu")
public class ThuongHieuController {
    @Autowired
    ThuongHieuServiceImpl thuongHieuService;

    @GetMapping("/hien-thi")
    public String index(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") int currentPage,
            HttpServletRequest request
    ) {
        model.addAttribute("thuongHieu", new ThuongHieu());
        String textSearch = request.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<ThuongHieu> pageThuongHieu = thuongHieuService.layDanhSach(textSearch, pageable);
        List<ThuongHieu> thuongHieus = pageThuongHieu.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL", pageThuongHieu.getNumberOfElements());
        model.addAttribute("totalPage", pageThuongHieu.getTotalPages());
        model.addAttribute("dsThuongHieu", thuongHieus);
        model.addAttribute("pageChoosedNumber", currentPage);
        return "admin/thuongHieu/create";
    }

    @GetMapping("/view-sua/{id}")
    public String view_sua(
            @PathVariable("id") UUID id,
            @ModelAttribute("thuongHieu") ThuongHieuRequest thuongHieu,
            Model model
    ) {
        ThuongHieu thuongHieu1 = thuongHieuService.chiTietTheoId(id);
        model.addAttribute("thuongHieu", thuongHieu1);
//        System.out.println("chatLieu : " + chatLieu1.getId());
        return "admin/thuongHieu/update";
    }

    @PostMapping("/sua/{id}")
    public String sua(
            @PathVariable("id") UUID id,
            @Valid @ModelAttribute("thuongHieu") ThuongHieuRequest thuongHieu,
            BindingResult result,
            HttpServletRequest request,
            Model model
    ) throws ParseException {
        if (result.hasErrors()) {
            return "admin/thuongHieu/update";
        }

        ThuongHieu thuongHieuCu = thuongHieuService.chiTietTheoId(id);

        if (thuongHieuService.kiemTraTrungMaKhong(thuongHieu.getMa(), thuongHieuCu.getMa())) {
            model.addAttribute("trungMa", true);
            return "admin/dayGiay/update";
        }

        if (thuongHieuService.kiemTraTrungTenKhong(thuongHieu.getTen(), thuongHieuCu.getTen())) {
            model.addAttribute("trungTen", true);
            return "admin/thuongHieu/update";
        }

        ThuongHieu ThuongHieuUpdate = new ThuongHieu();
        ThuongHieuUpdate.setId(thuongHieuCu.getId());
        ThuongHieuUpdate.setMa(thuongHieu.getMa());
        ThuongHieuUpdate.setTen(thuongHieu.getTen());
        ThuongHieuUpdate.setMoTa(thuongHieu.getMoTa());

        Integer trangThai = thuongHieu.getTrangThai();
        ThuongHieuUpdate.setTrangThai(trangThai);
        ThuongHieuUpdate.setNgaySua(Constant.getDateNow());

        ThuongHieuUpdate.setNgayTao(thuongHieuCu.getNgayTao());
        ThuongHieuUpdate.setNguoiSua(thuongHieuCu.getNguoiSua());
        ThuongHieuUpdate.setNguoiTao(thuongHieuCu.getNguoiTao());

        thuongHieuService.capNhat(ThuongHieuUpdate);
        System.out.println("Sửa thương hiệu thành công");
        model.addAttribute("thuongHieu", thuongHieu);
        model.addAttribute("messageSuccess", true);

        return "admin/thuongHieu/update";
    }

    @PostMapping("/them")
    public String themMoi(Model model,
                          @Valid @ModelAttribute("thuongHieu")
                                  ThuongHieuRequest request, BindingResult result,
                          @RequestParam(name = "page", defaultValue = "0")
                                  int currentPage,
                          HttpServletRequest httpServletRequest)
            throws ParseException {
        if (result.hasErrors()) {
            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<ThuongHieu> pageThuongHieu = thuongHieuService.layDanhSach(textSearch, pageable);
            List<ThuongHieu> thuongHieus = pageThuongHieu.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageThuongHieu.getNumberOfElements());
            model.addAttribute("totalPage", pageThuongHieu.getTotalPages());
            model.addAttribute("dsThuongHieu", thuongHieus);
            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/thuongHieu/create";
        }


        if (thuongHieuService.kiemTraTrungMaKhong(request.getMa())) {
//            System.out.println("Trùng mã rồi ...");
            model.addAttribute("trungMa", true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<ThuongHieu> pageThuongHieu = thuongHieuService.layDanhSach(textSearch, pageable);
            List<ThuongHieu> thuongHieus = pageThuongHieu.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageThuongHieu.getNumberOfElements());
            model.addAttribute("totalPage", pageThuongHieu.getTotalPages());
            model.addAttribute("dsThuongHieu", thuongHieus);
            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/thuongHieu/create";
        }

        if (thuongHieuService.kiemTraTrungTenKhong(String.valueOf(request.getTen()))) {
            model.addAttribute("trungTen", true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<ThuongHieu> pageThuongHieu = thuongHieuService.layDanhSach(textSearch, pageable);
            List<ThuongHieu> thuongHieus = pageThuongHieu.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageThuongHieu.getNumberOfElements());
            model.addAttribute("totalPage", pageThuongHieu.getTotalPages());
            model.addAttribute("dsThuongHieu", thuongHieus);
            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/thuongHieu/create";
        }
        ThuongHieu thuongHieuThemMoi = new ThuongHieu();
        thuongHieuThemMoi.setId(null);
        thuongHieuThemMoi.setTen(request.getTen());
        thuongHieuThemMoi.setMa(request.getMa());
        thuongHieuThemMoi.setMoTa(request.getMoTa());
        thuongHieuThemMoi.setNguoiTao(1);
        thuongHieuThemMoi.setNguoiSua(1);
        thuongHieuThemMoi.setNgayTao(Constant.getDateNow());
        thuongHieuThemMoi.setNgaySua(Constant.getDateNow());
        thuongHieuThemMoi.setTrangThai(request.getTrangThai());

        thuongHieuService.themMoi(thuongHieuThemMoi);
        System.out.println("Thêm mới thành công");
        model.addAttribute("thuongHieu", new DayGiayRequest());
        model.addAttribute("messageSuccess", true);

        String textSearch = httpServletRequest.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<ThuongHieu> pageThuongHieu = thuongHieuService.layDanhSach(textSearch, pageable);
        List<ThuongHieu> thuongHieus = pageThuongHieu.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL", pageThuongHieu.getNumberOfElements());
        model.addAttribute("totalPage", pageThuongHieu.getTotalPages());
        model.addAttribute("dsThuongHieu", thuongHieus);
        model.addAttribute("pageChoosedNumber", currentPage);
        return "admin/thuongHieu/create";
    }

    @GetMapping("/xoa/{id}")
    public String xoa(
            @PathVariable("id") UUID id
    ) {
        ThuongHieu thuongHieux = thuongHieuService.chiTietTheoId(id);
        thuongHieuService.xoa(id);
        return "redirect:/thuong-hieu/hien-thi";
    }
}
