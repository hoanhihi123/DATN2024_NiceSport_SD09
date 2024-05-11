package com.example.duantn.controller;


import com.example.duantn.dto.Constant;
import com.example.duantn.model.DeGiay;
import com.example.duantn.request.DeGiayRequest;
import com.example.duantn.service.impl.DeGiayServiceImpl;
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
@RequestMapping("/de-giay")
public class DeGiayController {
    @Autowired
    DeGiayServiceImpl deGiayService;
    @GetMapping("/hien-thi")

    public String index(Model model,@RequestParam(name = "page",defaultValue = "0") int currentPage,HttpServletRequest request){
     model.addAttribute("deGiay",new DeGiay());
        String textSearch = request.getParameter("textsearch");
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<DeGiay> pageDeGiay = deGiayService.layDanhSach(textSearch,pageable);
        List<DeGiay>deGiays = pageDeGiay.getContent();
        model.addAttribute("tongSL", pageDeGiay.getNumberOfElements());
        model.addAttribute("totalPage", pageDeGiay.getTotalPages());
        model.addAttribute("dsDeGiay", deGiays);
        model.addAttribute("pageChoosedNumber", currentPage);
        return "admin/deGiay/create";
    }
    @GetMapping("/view-sua/{id}")
    public String view_sua(
            @PathVariable("id") UUID id,
            @ModelAttribute("deGiay") DeGiayRequest deGiay,
            Model model
    ) {
        DeGiay deGiay1 = deGiayService.chiTietTheoId(id);
        model.addAttribute("deGiay", deGiay1);

        return "admin/deGiay/update";
    }
    @PostMapping("/sua/{id}")
    public String sua(
            @PathVariable("id") UUID id,
            @Valid @ModelAttribute("deGiay") DeGiayRequest deGiay,
            BindingResult result,
            HttpServletRequest request,
            Model model
    ) throws ParseException {
        if (result.hasErrors()) {
            return "admin/deGiay/update";
        }

        DeGiay deGiayCu = deGiayService.chiTietTheoId(id);

        if (deGiayService.kiemTraTrungMaKhong(deGiay.getMa(), deGiayCu.getMa())) {
            model.addAttribute("trungMa", true);
            return "admin/deGiay/update";
        }

        if (deGiayService.kiemTraTrungTenKhong(deGiay.getTen(), deGiayCu.getTen())) {
            model.addAttribute("trungTen", true);
            return "admin/deGiay/update";
        }

        DeGiay DeGiayUpdate = new DeGiay();
        DeGiayUpdate.setId(deGiayCu.getId());
        DeGiayUpdate.setMa(deGiay.getMa());
        DeGiayUpdate.setTen(deGiay.getTen());
        DeGiayUpdate.setMoTa(deGiay.getMoTa());

        Integer trangThai = deGiay.getTrangThai();
        DeGiayUpdate.setTrangThai(trangThai);
        DeGiayUpdate.setNgaySua(Constant.getDateNow());

        DeGiayUpdate.setNgayTao(deGiayCu.getNgayTao());
        DeGiayUpdate.setNguoiSua(deGiayCu.getNguoiSua());
        DeGiayUpdate.setNguoiTao(deGiayCu.getNguoiTao());

        deGiayService.capNhat(DeGiayUpdate);
        System.out.println("Sửa dữ liệu thành công");
        model.addAttribute("deGiay", deGiay);
        model.addAttribute("messageSuccess", true);

        return "admin/deGiay/update";
    }
    @PostMapping("/them")
    public String themMoi(Model model,
                          @Valid @ModelAttribute("deGiay")
                                  DeGiayRequest request, BindingResult result,
                          @RequestParam(name = "page", defaultValue = "0")
                                  int currentPage,
                          HttpServletRequest httpServletRequest)
            throws ParseException {
        if (result.hasErrors()) {
            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<DeGiay> pageDeGiay = deGiayService.layDanhSach(textSearch, pageable);
            List<DeGiay> deGiays = pageDeGiay.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageDeGiay.getNumberOfElements());
            model.addAttribute("totalPage", pageDeGiay.getTotalPages());
            model.addAttribute("dsDeGiay", deGiays);
            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/deGiay/create";
        }


        if (deGiayService.kiemTraTrungMaKhong(request.getMa())) {
//            System.out.println("Trùng mã rồi ...");
            model.addAttribute("trungMa", true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<DeGiay> pageDeGiay = deGiayService.layDanhSach(textSearch, pageable);
            List<DeGiay> deGiays = pageDeGiay.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageDeGiay.getNumberOfElements());
            model.addAttribute("totalPage", pageDeGiay.getTotalPages());
            model.addAttribute("dsDeGiay", deGiays);
            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/deGiay/create";
        }

        if (deGiayService.kiemTraTrungTenKhong(String.valueOf(request.getTen()))) {
            model.addAttribute("trungTen", true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<DeGiay> pageDeGiay = deGiayService.layDanhSach(textSearch, pageable);
            List<DeGiay> deGiays = pageDeGiay.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageDeGiay.getNumberOfElements());
            model.addAttribute("totalPage", pageDeGiay.getTotalPages());
            model.addAttribute("dsDeGiay", deGiays);
            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/deGiay/create";
        }
        DeGiay deGiayThemMoi = new DeGiay();
        deGiayThemMoi.setId(null);
        deGiayThemMoi.setTen(request.getTen());
        deGiayThemMoi.setMa(request.getMa());
        deGiayThemMoi.setMoTa(request.getMoTa());
        deGiayThemMoi.setNguoiTao(1);
        deGiayThemMoi.setNguoiSua(1);
        deGiayThemMoi.setNgayTao(Constant.getDateNow());
        deGiayThemMoi.setNgaySua(Constant.getDateNow());
        deGiayThemMoi.setTrangThai(request.getTrangThai());

        deGiayService.themMoi(deGiayThemMoi);
        System.out.println("Thêm mới đế giày thành công");
        model.addAttribute("deGiay", new DeGiayRequest());
        model.addAttribute("messageSuccess", true);

        String textSearch = httpServletRequest.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<DeGiay> pageDeGiay = deGiayService.layDanhSach(textSearch, pageable);
        List<DeGiay> deGiays = pageDeGiay.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL", pageDeGiay.getNumberOfElements());
        model.addAttribute("totalPage", pageDeGiay.getTotalPages());
        model.addAttribute("dsDeGiay", deGiays);
        model.addAttribute("pageChoosedNumber", currentPage);
        return "admin/deGiay/create";
    }
    @GetMapping("/xoa/{id}")
    public String xoa(
            @PathVariable("id") UUID id
    ) {
        DeGiay deGiayx = deGiayService.chiTietTheoId(id);
        deGiayService.xoa(id);
        return "redirect:/de-giay/hien-thi";
    }
}
