
package com.example.duantn.controller;

import com.example.duantn.model.ChucVu;
import com.example.duantn.model.MauSac;
import com.example.duantn.model.NhanVien;
import com.example.duantn.request.MauSacRequest;
import com.example.duantn.request.NhanVienRequest;
import com.example.duantn.service.impl.ChucVuServiceImpl;
import com.example.duantn.service.impl.NhanVienServiceImpl;
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
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/nhan-vien")
public class NhanVienController {
    @Autowired
    NhanVienServiceImpl nhanVienService;

    @Autowired
    ChucVuServiceImpl chucVuService;

    @GetMapping("/hien-thi")
    public String index(
            Model model,
            @RequestParam(name = "page",defaultValue = "0") int currentPage ,
            HttpServletRequest request
    ) {
        model.addAttribute("nhanVien", new NhanVien());
        String textSearch = request.getParameter("textsearch");
        System.out.println("Text search : " + textSearch);

        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<NhanVien> pageNhanVien =  nhanVienService.layDanhSach(textSearch, pageable);
        List<NhanVien> nhanViens = pageNhanVien.getContent();
        List<ChucVu> dsChucVu = chucVuService.layDanhSach();

        // muon hien thi so trang
        model.addAttribute("tongSL",pageNhanVien.getNumberOfElements());
        model.addAttribute("totalPage",pageNhanVien.getTotalPages());
        model.addAttribute("dsNhanVien", nhanViens);
        model.addAttribute("dsChucVu",dsChucVu);
        model.addAttribute("pageChoosedNumber",currentPage);
        return "admin/nhanVien/create1";
    }

    @GetMapping("/view-sua/{id}")
    public String view_sua(
            @PathVariable("id") UUID id ,
            @ModelAttribute("nhanVien") NhanVienRequest nhanVien,
            Model model
    ) {
        NhanVien nhanVienx = nhanVienService.chiTietTheoId(id);
        model.addAttribute("nhanVien",nhanVienx);
        model.addAttribute("dsChucVu",chucVuService.layDanhSach());
        return "admin/nhanVien/update";
    }

    @PostMapping("/sua/{id}")
    public String sua(
            @PathVariable("id") UUID id ,
            @Valid  @ModelAttribute("nhanVien") NhanVienRequest request,
            BindingResult result ,
            Model model
    ) throws ParseException {

        if(result.hasErrors()){
            model.addAttribute("dsNhanVien",nhanVienService.layDanhSach());
            model.addAttribute("dsChucVu",chucVuService.layDanhSach());
            System.out.println("Có lỗi nhưng không hiện lỗi");
            System.out.println("Ngày sinh của nhân viên : " + request.getNgaySinh());
            System.out.println("Lỗi tại : " + result.toString());
            return "admin/nhanVien/update";
        }

        NhanVien nhanVienCu = nhanVienService.chiTietTheoId(id);

//        if(nhanVienService.kiemTraTrungMaKhong(request.getMa(), nhanVienCu.getMa())){
//            model.addAttribute("trungMa",true);
//            return "admin/sanPham/update";
//        }
//
        if(nhanVienService.kiemTraTrungTenKhong(request.getHoVaTen(), nhanVienCu.getHoVaTen())){
            model.addAttribute("trungTen",true);
            return "admin/nhanVien/update";
        }

        NhanVien nhanVienUpdate = new NhanVien();
        ChucVu loaiChucVu = new ChucVu();

        loaiChucVu.setId(request.getChucVu().getId());
        nhanVienUpdate.setChucVu(loaiChucVu);

        nhanVienUpdate.setId(nhanVienCu.getId());
        nhanVienUpdate.setMa(request.getMa());
        nhanVienUpdate.setTaiKhoan(request.getTaiKhoan());
        nhanVienUpdate.setMatKhau(request.getMatKhau());
        nhanVienUpdate.setHoVaTen(request.getHoVaTen());
        nhanVienUpdate.setGioiTinh(request.getGioiTinh());
        nhanVienUpdate.setSdt(request.getSdt());
        nhanVienUpdate.setDiaChi(request.getDiaChi());
        nhanVienUpdate.setTrangThai(request.getTrangThai());

        Date ngaySinh = request.getNgaySinh();
        nhanVienUpdate.setNgaySinh(new java.sql.Date(ngaySinh.getTime()));


        nhanVienService.capNhat(nhanVienUpdate);
        System.out.println("Sửa dữ liệu thành công");
        model.addAttribute("nhanVien",nhanVienUpdate);
        model.addAttribute("messageSuccess",true);

        return "admin/nhanVien/update" ;
    }

    @PostMapping("/them")
    public String themMoi(
            Model model,
            @Valid @ModelAttribute("nhanVien") NhanVienRequest request,
            BindingResult result,
            @RequestParam(name = "page",defaultValue = "0")
                    int currentPage,
            HttpServletRequest httpServletRequest)
            throws ParseException {
        if(result.hasErrors()){
            model.addAttribute("dsNhanVien",nhanVienService.layDanhSach());
            model.addAttribute("dsChucVu",chucVuService.layDanhSach());

            System.out.println("Có lỗi nhưng không hiện lỗi");
            System.out.println("Ngày sinh của nhân viên : " + request.getNgaySinh());
            System.out.println("Lỗi tại : " + result.toString());
            return "admin/nhanVien/create1";
        }

        if (nhanVienService.kiemTraTrungMaKhong(request.getMa())) {
//            System.out.println("Trùng mã rồi ...");
            model.addAttribute("trungMa", true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<NhanVien> pageNhanVien = nhanVienService.layDanhSach(textSearch, pageable);
            List<NhanVien> nhanViens = pageNhanVien.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageNhanVien.getNumberOfElements());
            model.addAttribute("totalPage", pageNhanVien.getTotalPages());
            model.addAttribute("dsNhanVien", nhanViens);
            model.addAttribute("dsChucVu", chucVuService.layDanhSach());

            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/nhanVien/create1";
        }
        if (nhanVienService.kiemTraTrungTenKhong(String.valueOf(request.getHoVaTen()))) {
            model.addAttribute("trungTen", true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<NhanVien> pageNhanVien = nhanVienService.layDanhSach(textSearch, pageable);
            List<NhanVien> nhanViens = pageNhanVien.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageNhanVien.getNumberOfElements());
            model.addAttribute("totalPage", pageNhanVien.getTotalPages());
            model.addAttribute("dsNhanVien", nhanViens);
            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/nhanVien/create1";
        }
        NhanVien nhanVienThemMoi = new NhanVien();
        ChucVu loaiChucVu = new ChucVu();
        loaiChucVu.setId(request.getChucVu().getId());
        nhanVienThemMoi.setChucVu(loaiChucVu);


        Date ngaySinh = request.getNgaySinh();
        nhanVienThemMoi.setNgaySinh(new java.sql.Date(ngaySinh.getTime()));

        nhanVienThemMoi.setId(null);
        nhanVienThemMoi.setMa(request.getMa());
        nhanVienThemMoi.setTaiKhoan(request.getTaiKhoan());
        nhanVienThemMoi.setMatKhau(request.getMatKhau());
        nhanVienThemMoi.setHoVaTen(request.getHoVaTen());
        nhanVienThemMoi.setGioiTinh(request.getGioiTinh());
        nhanVienThemMoi.setSdt(request.getSdt());
        nhanVienThemMoi.setDiaChi(request.getDiaChi());
        nhanVienThemMoi.setTrangThai(request.getTrangThai());



        nhanVienService.themMoi(nhanVienThemMoi);
        model.addAttribute("nhanVien", new NhanVienRequest());
        model.addAttribute("messageSuccess", true);
        String textSearch = httpServletRequest.getParameter("textsearch");


        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<NhanVien> pageNhanVien = nhanVienService.layDanhSach(textSearch, pageable);
        List<NhanVien> nhanViens = pageNhanVien.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL", pageNhanVien.getNumberOfElements());
        model.addAttribute("totalPage", pageNhanVien.getTotalPages());
        model.addAttribute("dsNhanVien", nhanViens);
        model.addAttribute("pageChoosedNumber", currentPage);

        return "redirect:/nhan-vien/hien-thi" ;
    }
    @GetMapping("/xoa/{id}")
    public String xoa(
            @PathVariable("id") UUID id
    ) {
        nhanVienService.xoa(id);
        return "redirect:/nhan-vien/hien-thi";
    }

}
