package com.example.duantn.controller;

import com.example.duantn.dto.Constant;
import com.example.duantn.model.MauSac;
import com.example.duantn.request.MauSacRequest;
import com.example.duantn.service.impl.MauSacServiceImpl;
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
@RequestMapping("/mau-sac")
public class MauSacController {
    @Autowired
    private MauSacServiceImpl mauSacService;

    @GetMapping("/hien-thi")
    public String index(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") int currentPage,
            HttpServletRequest request
    ) {
        model.addAttribute("mauSac", new MauSac());
        String textSearch = request.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<MauSac> pageMauSac = mauSacService.layDanhSach(textSearch, pageable);
        List<MauSac> mauSacs = pageMauSac.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL", pageMauSac.getNumberOfElements());
        model.addAttribute("totalPage", pageMauSac.getTotalPages());
        model.addAttribute("dsMauSac", mauSacs);
        model.addAttribute("pageChoosedNumber", currentPage);
        return "admin/mauSac/create";
    }

    @GetMapping("/view-sua/{id}")
    public String view_sua(
            @PathVariable("id") UUID id,
            @ModelAttribute("mauSac") MauSacRequest mauSac,
            Model model
    ) {
        MauSac mauSac1 = mauSacService.chiTietTheoId(id);
        model.addAttribute("mauSac", mauSac1);
//        System.out.println("mauSac : " + mauSac1.getId());
        return "admin/mauSac/update";
    }

    @PostMapping("/sua/{id}")
    public String sua(
            @PathVariable("id") UUID id,
            @Valid @ModelAttribute("mauSac") MauSacRequest mauSac,
            BindingResult result,
            HttpServletRequest request,
            Model model
    ) throws ParseException {
        if (result.hasErrors()) {
            return "admin/mauSac/update";
        }

        MauSac mauSacCu = mauSacService.chiTietTheoId(id);

        if (mauSacService.kiemTraTrungMaKhong(mauSac.getMa(), mauSacCu.getMa())) {
            model.addAttribute("trungMa", true);
            return "admin/mauSac/update";
        }

        if (mauSacService.kiemTraTrungTenKhong(mauSac.getTen(), mauSacCu.getTen())) {
            model.addAttribute("trungTen", true);
            return "admin/mauSac/update";
        }

        MauSac mauSacUpdate = new MauSac();
        mauSacUpdate.setId(mauSacCu.getId());
        mauSacUpdate.setMa(mauSac.getMa());
        mauSacUpdate.setTen(mauSac.getTen());
        mauSacUpdate.setMoTa(mauSac.getMoTa());

        Integer trangThai = mauSac.getTrangThai();
        mauSacUpdate.setTrangThai(trangThai);
        mauSacUpdate.setNgaySua(Constant.getDateNow());

        mauSacUpdate.setNgayTao(mauSacCu.getNgayTao());
        mauSacUpdate.setNguoiSua(mauSacCu.getNguoiSua());
        mauSacUpdate.setNguoiTao(mauSacCu.getNguoiTao());

        mauSacService.capNhat(mauSacUpdate);
        model.addAttribute("mauSac", mauSac);
        model.addAttribute("messageSuccess", true);

        return "redirect:/mau-sac/hien-thi";
    }

    @PostMapping("/them")
    public String themMoi(Model model,
                          @Valid @ModelAttribute("mauSac") MauSacRequest request,
                          BindingResult result,
                          @RequestParam(name = "page", defaultValue = "0")
                          int currentPage,
                          HttpServletRequest httpServletRequest)
            throws ParseException {
        if (result.hasErrors()) {
            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<MauSac> pageMauSac = mauSacService.layDanhSach(textSearch, pageable);
            List<MauSac> mauSacs = pageMauSac.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageMauSac.getNumberOfElements());
            model.addAttribute("totalPage", pageMauSac.getTotalPages());
            model.addAttribute("dsMauSac", mauSacs);
            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/mauSac/create";
        }


        if (mauSacService.kiemTraTrungMaKhong(request.getMa())) {
//            System.out.println("Trùng mã rồi ...");
            model.addAttribute("trungMa", true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<MauSac> pageMauSac = mauSacService.layDanhSach(textSearch, pageable);
            List<MauSac> mauSacs = pageMauSac.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageMauSac.getNumberOfElements());
            model.addAttribute("totalPage", pageMauSac.getTotalPages());
            model.addAttribute("dsMauSac", mauSacs);
            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/mauSac/create";
        }

        if (mauSacService.kiemTraTrungTenKhong(String.valueOf(request.getTen()))) {
            model.addAttribute("trungTen", true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<MauSac> pageMauSac = mauSacService.layDanhSach(textSearch, pageable);
            List<MauSac> mauSacs = pageMauSac.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageMauSac.getNumberOfElements());
            model.addAttribute("totalPage", pageMauSac.getTotalPages());
            model.addAttribute("dsMauSac", mauSacs);
            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/mauSac/create";
        }
        MauSac mauSacThemMoi = new MauSac();
        mauSacThemMoi.setId(null);
        mauSacThemMoi.setTen(request.getTen());
        mauSacThemMoi.setMa(request.getMa());
        mauSacThemMoi.setMoTa(request.getMoTa());
        mauSacThemMoi.setNguoiTao(1);
        mauSacThemMoi.setNguoiSua(1);
        mauSacThemMoi.setNgayTao(Constant.getDateNow());
        mauSacThemMoi.setNgaySua(Constant.getDateNow());
        mauSacThemMoi.setTrangThai(request.getTrangThai());

        mauSacService.themMoi(mauSacThemMoi);
        model.addAttribute("mauSac", new MauSacRequest());
        model.addAttribute("messageSuccess", true);

        String textSearch = httpServletRequest.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<MauSac> pageMauSac = mauSacService.layDanhSach(textSearch, pageable);
        List<MauSac> mauSacs = pageMauSac.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL", pageMauSac.getNumberOfElements());
        model.addAttribute("totalPage", pageMauSac.getTotalPages());
        model.addAttribute("dsMauSac", mauSacs);
        model.addAttribute("pageChoosedNumber", currentPage);
        return "admin/mauSac/create";
    }

    @GetMapping("/xoa/{id}")
    public String xoa(
            @PathVariable("id") UUID id
    ) {
        MauSac mauSacx = mauSacService.chiTietTheoId(id);
        mauSacService.xoa(id);
        return "redirect:/mau-sac/hien-thi";
    }

}
