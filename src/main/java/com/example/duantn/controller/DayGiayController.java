package com.example.duantn.controller;


import com.example.duantn.dto.Constant;
import com.example.duantn.model.DayGiay;
import com.example.duantn.request.DayGiayRequest;
import com.example.duantn.service.impl.DayGiayServiceImpl;
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
@RequestMapping("/day-giay")
public class DayGiayController {
    @Autowired
    DayGiayServiceImpl dayGiayService;
    @GetMapping("/hien-thi")
    public String index(
            Model model,
            @RequestParam(name = "page",defaultValue = "0")  int currentPage,
            HttpServletRequest request
    ){
     model.addAttribute("dayGiay",new DayGiay());
     String textSearch = request.getParameter("textsearch");

// phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<DayGiay> pageDayGiay = dayGiayService.layDanhSach(textSearch, pageable);
        List<DayGiay> dayGiays = pageDayGiay.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL", pageDayGiay.getNumberOfElements());
        model.addAttribute("totalPage", pageDayGiay.getTotalPages());
        model.addAttribute("dsDayGiay", dayGiays);
        model.addAttribute("pageChoosedNumber", currentPage);
        return "admin/dayGiay/create";
    }
    @GetMapping("/view-sua/{id}")
    public String view_sua(
            @PathVariable("id") UUID id,
            @ModelAttribute("dayGiay") DayGiayRequest dayGiay,
            Model model
    ) {
        DayGiay dayGiay1 = dayGiayService.chiTietTheoId(id);
        model.addAttribute("dayGiay", dayGiay1);
//        System.out.println("chatLieu : " + chatLieu1.getId());
        return "admin/dayGiay/update";
    }
    @PostMapping("/sua/{id}")
    public String sua(
            @PathVariable("id") UUID id,
            @Valid @ModelAttribute("dayGiay") DayGiayRequest dayGiay,
            BindingResult result,
            HttpServletRequest request,
            Model model
    ) throws ParseException {
        if (result.hasErrors()) {
            return "admin/dayGiay/update";
        }

        DayGiay dayGiayCu = dayGiayService.chiTietTheoId(id);

        if (dayGiayService.kiemTraTrungMaKhong(dayGiay.getMa(), dayGiayCu.getMa())) {
            model.addAttribute("trungMa", true);
            return "admin/dayGiay/update";
        }

        if (dayGiayService.kiemTraTrungTenKhong(dayGiay.getTen(), dayGiayCu.getTen())) {
            model.addAttribute("trungTen", true);
            return "admin/dayGiay/update";
        }

        DayGiay DayGiayUpdate = new DayGiay();
        DayGiayUpdate.setId(dayGiayCu.getId());
        DayGiayUpdate.setMa(dayGiay.getMa());
        DayGiayUpdate.setTen(dayGiay.getTen());
        DayGiayUpdate.setMoTa(dayGiay.getMoTa());

        Integer trangThai = dayGiay.getTrangThai();
        DayGiayUpdate.setTrangThai(trangThai);
        DayGiayUpdate.setNgaySua(Constant.getDateNow());

        DayGiayUpdate.setNgayTao(dayGiayCu.getNgayTao());
        DayGiayUpdate.setNguoiSua(dayGiayCu.getNguoiSua());
        DayGiayUpdate.setNguoiTao(dayGiayCu.getNguoiTao());

        dayGiayService.capNhat(DayGiayUpdate);
        System.out.println("Sửa dây giày thành công");
        model.addAttribute("dayGiay", dayGiay);
        model.addAttribute("messageSuccess", true);

        return "admin/dayGiay/update";
    }
    @PostMapping("/them")
    public String themMoi(Model model,
                          @Valid @ModelAttribute("dayGiay")
                                  DayGiayRequest request, BindingResult result,
                          @RequestParam(name = "page", defaultValue = "0")
                                  int currentPage,
                          HttpServletRequest httpServletRequest)
            throws ParseException {
        if (result.hasErrors()) {
            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<DayGiay> pageDayGiay = dayGiayService.layDanhSach(textSearch, pageable);
            List<DayGiay> dayGiays = pageDayGiay.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageDayGiay.getNumberOfElements());
            model.addAttribute("totalPage", pageDayGiay.getTotalPages());
            model.addAttribute("dsDayGiay", dayGiays);
            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/dayGiay/create";
        }


        if (dayGiayService.kiemTraTrungMaKhong(request.getMa())) {
//            System.out.println("Trùng mã rồi ...");
            model.addAttribute("trungMa", true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<DayGiay> pageDayGiay = dayGiayService.layDanhSach(textSearch, pageable);
            List<DayGiay> dayGiays = pageDayGiay.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageDayGiay.getNumberOfElements());
            model.addAttribute("totalPage", pageDayGiay.getTotalPages());
            model.addAttribute("dsDayGiay", dayGiays);
            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/dayGiay/create";
        }

        if (dayGiayService.kiemTraTrungTenKhong(String.valueOf(request.getTen()))) {
            model.addAttribute("trungTen", true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<DayGiay> pageDayGiay = dayGiayService.layDanhSach(textSearch, pageable);
            List<DayGiay> dayGiays = pageDayGiay.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageDayGiay.getNumberOfElements());
            model.addAttribute("totalPage", pageDayGiay.getTotalPages());
            model.addAttribute("dsDayGiay", dayGiays);
            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/dayGiay/create";
        }
        DayGiay dayGiayThemMoi = new DayGiay();
        dayGiayThemMoi.setId(null);
        dayGiayThemMoi.setTen(request.getTen());
        dayGiayThemMoi.setMa(request.getMa());
        dayGiayThemMoi.setMoTa(request.getMoTa());
        dayGiayThemMoi.setNguoiTao(1);
        dayGiayThemMoi.setNguoiSua(1);
        dayGiayThemMoi.setNgayTao(Constant.getDateNow());
        dayGiayThemMoi.setNgaySua(Constant.getDateNow());
        dayGiayThemMoi.setTrangThai(request.getTrangThai());

        dayGiayService.themMoi(dayGiayThemMoi);
        System.out.println("Thêm mới dây giày thành công");
        model.addAttribute("dayGiay", new DayGiayRequest());
        model.addAttribute("messageSuccess", true);

        String textSearch = httpServletRequest.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<DayGiay> pageDayGiay = dayGiayService.layDanhSach(textSearch, pageable);
        List<DayGiay> dayGiays = pageDayGiay.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL", pageDayGiay.getNumberOfElements());
        model.addAttribute("totalPage", pageDayGiay.getTotalPages());
        model.addAttribute("dsDayGiay", dayGiays);
        model.addAttribute("pageChoosedNumber", currentPage);
        return "admin/dayGiay/create";
    }
    @GetMapping("/xoa/{id}")
    public String xoa(
            @PathVariable("id") UUID id
    ) {
        DayGiay dayGiayx = dayGiayService.chiTietTheoId(id);
        dayGiayService.xoa(id);
        return "redirect:/day-giay/hien-thi";
    }
}
