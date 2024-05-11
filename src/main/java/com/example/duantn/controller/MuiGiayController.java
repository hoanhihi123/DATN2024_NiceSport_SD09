package com.example.duantn.controller;

import com.example.duantn.model.MuiGiay;
import com.example.duantn.request.MuiGiayRequest;
import com.example.duantn.service.impl.MuiGiayServiceImpl;
import com.example.duantn.dto.Constant;
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
@RequestMapping("/mui-giay")
public class MuiGiayController {
    @Autowired
    MuiGiayServiceImpl muiGiayService;

    @GetMapping("/hien-thi")
    public String index(
            Model model,
            @RequestParam(name = "page",defaultValue = "0") int currentPage ,
            HttpServletRequest request
    ) {
        model.addAttribute("muiGiay", new MuiGiay());
        String textSearch = request.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<MuiGiay> pageMuiGiay =  muiGiayService.layDanhSach(textSearch, pageable);
        List<MuiGiay> muiGiays = pageMuiGiay.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL",pageMuiGiay.getNumberOfElements());
        model.addAttribute("totalPage",pageMuiGiay.getTotalPages());
        model.addAttribute("dsMuiGiay", muiGiays);
        model.addAttribute("pageChoosedNumber",currentPage);
        return "admin/muiGiay/create";
    }

    @GetMapping("/view-sua/{id}")
    public String view_sua(
            @PathVariable("id") UUID id ,
            @ModelAttribute("muiGiay") MuiGiayRequest muiGiay,
            Model model
    ) {
        MuiGiay muiGiayx = muiGiayService.chiTietTheoId(id);
        model.addAttribute("muiGiay",muiGiayx);
//        System.out.println("muiGiay : " + muiGiayx.getId());
        return "admin/muiGiay/update";
    }

    @PostMapping("/sua/{id}")
    public String sua(
            @PathVariable("id") UUID id ,
            @Valid @ModelAttribute("muiGiay") MuiGiayRequest muiGiay,
            BindingResult result,
            HttpServletRequest request,
            Model model
    ) throws ParseException {
        if(result.hasErrors()){
            return "admin/muiGiay/update";
        }

        MuiGiay muiGiayCu = muiGiayService.chiTietTheoId(id);

        if(muiGiayService.kiemTraTrungMaKhong(muiGiay.getMa(), muiGiayCu.getMa())){
            model.addAttribute("trungMa",true);
            return "admin/muiGiay/update";
        }

        if(muiGiayService.kiemTraTrungTenKhong(muiGiay.getTen(), muiGiayCu.getTen())){
            model.addAttribute("trungTen",true);
            return "admin/muiGiay/update";
        }

        MuiGiay muiGiayUpdate = new MuiGiay();
        muiGiayUpdate.setId(muiGiayCu.getId());
        muiGiayUpdate.setMa(muiGiay.getMa());
        muiGiayUpdate.setTen(muiGiay.getTen());
        muiGiayUpdate.setMoTa(muiGiay.getMoTa());

        Integer trangThai = muiGiay.getTrangThai();
        muiGiayUpdate.setTrangThai(trangThai);
        muiGiayUpdate.setNgaySua(Constant.getDateNow());

        muiGiayUpdate.setNgayTao(muiGiayCu.getNgayTao());
        muiGiayUpdate.setNguoiSua(muiGiayCu.getNguoiSua());
        muiGiayUpdate.setNguoiTao(muiGiayCu.getNguoiTao());

        muiGiayService.capNhat(muiGiayUpdate);
        model.addAttribute("muiGiay",muiGiay);
        model.addAttribute("messageSuccess",true);

        return "admin/muiGiay/update";
    }

    @PostMapping("/them")
    public String themMoi(
            Model model,
            @Valid @ModelAttribute("muiGiay") MuiGiayRequest request,
            BindingResult result ,
            @RequestParam(name = "page",defaultValue = "0") int currentPage ,
            HttpServletRequest httpServletRequest
    ) throws ParseException
    {
        if(result.hasErrors()){
            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<MuiGiay> pageMuiGiay =  muiGiayService.layDanhSach(textSearch, pageable);
            List<MuiGiay> muiGiays = pageMuiGiay.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL",pageMuiGiay.getNumberOfElements());
            model.addAttribute("totalPage",pageMuiGiay.getTotalPages());
            model.addAttribute("dsMuiGiay", muiGiays);
            model.addAttribute("pageChoosedNumber",currentPage);
            return "admin/muiGiay/create";
        }

        if(muiGiayService.kiemTraTrungMaKhong(request.getMa())){
//            System.out.println("Trùng mã rồi ...");
            model.addAttribute("trungMa",true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<MuiGiay> pageMuiGiay =  muiGiayService.layDanhSach(textSearch, pageable);
            List<MuiGiay> muiGiays = pageMuiGiay.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL",pageMuiGiay.getNumberOfElements());
            model.addAttribute("totalPage",pageMuiGiay.getTotalPages());
            model.addAttribute("dsMuiGiay", muiGiays);
            model.addAttribute("pageChoosedNumber",currentPage);
            return "admin/muiGiay/create";
        }

        if(muiGiayService.kiemTraTrungTenKhong(String.valueOf(request.getTen()))){
            model.addAttribute("trungTen",true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<MuiGiay> pageMuiGiay =  muiGiayService.layDanhSach(textSearch, pageable);
            List<MuiGiay> muiGiays = pageMuiGiay.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL",pageMuiGiay.getNumberOfElements());
            model.addAttribute("totalPage",pageMuiGiay.getTotalPages());
            model.addAttribute("dsMuiGiay", muiGiays);
            model.addAttribute("pageChoosedNumber",currentPage);
            return "admin/muiGiay/create";
        }
        MuiGiay muiGiayThemMoi = new MuiGiay();
        muiGiayThemMoi.setId(null);
        muiGiayThemMoi.setTen(request.getTen());
        muiGiayThemMoi.setMa(request.getMa());
        muiGiayThemMoi.setMoTa(request.getMoTa());
        muiGiayThemMoi.setNguoiTao(1);
        muiGiayThemMoi.setNguoiSua(1);
        muiGiayThemMoi.setNgayTao(Constant.getDateNow());
        muiGiayThemMoi.setNgaySua(Constant.getDateNow());
        muiGiayThemMoi.setTrangThai(request.getTrangThai());

        muiGiayService.themMoi(muiGiayThemMoi);
        model.addAttribute("MuiGiay",new MuiGiayRequest());
        model.addAttribute("messageSuccess",true);

        String textSearch = httpServletRequest.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<MuiGiay> pageMuiGiay =  muiGiayService.layDanhSach(textSearch, pageable);
        List<MuiGiay> muiGiays = pageMuiGiay.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL",pageMuiGiay.getNumberOfElements());
        model.addAttribute("totalPage",pageMuiGiay.getTotalPages());
        model.addAttribute("dsMuiGiay", muiGiays);
        model.addAttribute("pageChoosedNumber",currentPage);

        return "admin/muiGiay/create";
    }

    @GetMapping("/xoa/{id}")
    public String xoa(
            @PathVariable("id") UUID id
    ) {
        MuiGiay muiGiayx = muiGiayService.chiTietTheoId(id);
        muiGiayService.xoa(id);
        return "redirect:/mui-giay/hien-thi";
    }


}
