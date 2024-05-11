package com.example.duantn.controller;

import com.example.duantn.dto.Constant;
import com.example.duantn.model.DiaChi;
import com.example.duantn.model.KhachHang;
import com.example.duantn.request.DiaChiRequest;
import com.example.duantn.service.impl.DiaChiServiceImpl;
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
@RequestMapping("/dia-chi")
public class DiaChiController {
    @Autowired
    DiaChiServiceImpl diaChiService;

    @Autowired
    KhachHangServiceImpl khachHangService;

    @GetMapping("/hien-thi")
    public String index(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") int currentPage,
            HttpServletRequest request
    ) {

        model.addAttribute("diaChi", new DiaChi());
        String textSearch = request.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<DiaChi> pageDiaChi = diaChiService.layDanhSach(textSearch, pageable);
        List<DiaChi> diaChix = pageDiaChi.getContent();
        List<KhachHang> dsKhachHang = khachHangService.layDanhSach();

        // muon hien thi so trang
        model.addAttribute("tongSL", pageDiaChi.getNumberOfElements());
        model.addAttribute("totalPage", pageDiaChi.getTotalPages());
        model.addAttribute("dsDiaChi", diaChix);
        model.addAttribute("dsKhachHang", dsKhachHang);
        model.addAttribute("pageChoosedNumber", currentPage);
        return "admin/diaChi/create";
    }

    @GetMapping("/view-sua/{id}")
    public String view_sua(
            @PathVariable("id") UUID id,
            @ModelAttribute("diaChi") DiaChiRequest diaChi,
            Model model
    ) {
        DiaChi diaChix = diaChiService.chiTietTheoId(id);
        model.addAttribute("diaChi", diaChix);
        model.addAttribute("dsKhachHang", khachHangService.layDanhSach());
        return "admin/diaChi/update";
    }

    @PostMapping("/sua/{id}")
    public String sua(
            @PathVariable("id") UUID id,
            @Valid @ModelAttribute("diaChi") DiaChiRequest request,
            BindingResult result,
            Model model
    ) throws ParseException {

        if (result.hasErrors()) {
            model.addAttribute("dsKhachHang", khachHangService.layDanhSach());
            System.out.println("Có lỗi nhưng không hiện lỗi");
            System.out.println("Ngày sinh của nhân viên : " + request.getMoTa());
            System.out.println("Lỗi tại : " + result.toString());
            return "admin/diaChi/update";
        }

        DiaChi diaChiCu = diaChiService.chiTietTheoId(id);

        DiaChi diaChiUpdate = new DiaChi();
        KhachHang tenKhachHang = new KhachHang();

        tenKhachHang.setId(request.getKhachHang().getId());
        diaChiUpdate.setKhachHang(tenKhachHang);

        diaChiUpdate.setId(diaChiCu.getId());
        diaChiUpdate.setMa(request.getMa());
        diaChiUpdate.setTen(request.getTen());
        diaChiUpdate.setMoTa(request.getMoTa());
        diaChiUpdate.setThanhPho(request.getThanhPho());
        diaChiUpdate.setHuyen(request.getHuyen());
        diaChiUpdate.setXa(request.getXa());
        diaChiUpdate.setTrangThai(Integer.valueOf(request.getTrangThai()));
        diaChiUpdate.setNguoiTao(1);
        diaChiUpdate.setNguoiSua(1);
        diaChiUpdate.setNgayTao(Constant.getDateNow());
        diaChiUpdate.setNgaySua(Constant.getDateNow());

        diaChiService.capNhat(diaChiUpdate);
        System.out.println("Sửa dữ liệu thành công");
        model.addAttribute("diaChi", diaChiUpdate);
        model.addAttribute("messageSuccess", true);

        return "redirect:/dia-chi/hien-thi";
    }

    @PostMapping("/them")
    public String themMoi(
            Model model,
            @ModelAttribute("diaChi") DiaChiRequest request
    ) throws ParseException {
        DiaChi diaChiThemMoi = new DiaChi();
        KhachHang tenKhachHang = new KhachHang();
        tenKhachHang.setId(request.getKhachHang().getId());
        diaChiThemMoi.setKhachHang(tenKhachHang);

        diaChiThemMoi.setId(null);
        diaChiThemMoi.setMa(request.getMa());
        diaChiThemMoi.setTen(request.getTen());
        diaChiThemMoi.setMoTa(request.getMoTa());
        diaChiThemMoi.setThanhPho(request.getThanhPho());
        diaChiThemMoi.setHuyen(request.getHuyen());
        diaChiThemMoi.setXa(request.getXa());
        diaChiThemMoi.setTrangThai(Integer.valueOf(request.getTrangThai()));
        diaChiThemMoi.setNguoiTao(1);
        diaChiThemMoi.setNguoiSua(1);
        diaChiThemMoi.setNgayTao(Constant.getDateNow());
        diaChiThemMoi.setNgaySua(Constant.getDateNow());

        diaChiService.themMoi(diaChiThemMoi);
        System.out.println("Thêm mới nhân viên thành công");

        return "redirect:/dia-chi/hien-thi";
    }

    @GetMapping("/xoa/{id}")
    public String xoa(
            @PathVariable("id") UUID id
    ) {
        diaChiService.xoa(id);
        return "redirect:/dia-chi/hien-thi";
    }
}
