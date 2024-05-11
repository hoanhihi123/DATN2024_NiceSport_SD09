package com.example.duantn.controller;

import com.example.duantn.model.KichCo;
import com.example.duantn.request.KichCoRequest;
import com.example.duantn.service.impl.KichCoServiceImpl;
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
@RequestMapping("/kich-thuoc")
public class KichCoController extends Constant {
    @Autowired
    KichCoServiceImpl kichThuocService;

    @GetMapping("/hien-thi")
    public String index(
            Model model,
            @RequestParam(name = "page",defaultValue = "0") int currentPage ,
            HttpServletRequest request
    ) {

        model.addAttribute("kichThuoc", new KichCo());
        String textSearch = request.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage,Constant.pageNumber);
        Page<KichCo> pageKichThuoc =  kichThuocService.layDanhSach(textSearch, pageable);
        List<KichCo> kichThuocs = pageKichThuoc.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL",pageKichThuoc.getNumberOfElements());
        model.addAttribute("totalPage",pageKichThuoc.getTotalPages());
        model.addAttribute("dsKichThuoc", kichThuocs);
        model.addAttribute("pageChoosedNumber",currentPage);
        return "admin/kichCo/create";
    }

    @GetMapping("/view-sua/{id}")
    public String view_sua(
            @PathVariable("id") UUID id ,
            @ModelAttribute("kichThuoc") KichCoRequest kichThuoc,
            Model model
            ) {
        KichCo kichThuocx = kichThuocService.chiTietTheoId(id);
        model.addAttribute("kichThuoc",kichThuocx);
        return "admin/kichCo/update";
    }

    @PostMapping("/sua/{id}")
    public String sua(
            @PathVariable("id") UUID id ,
            @Valid  @ModelAttribute("kichThuoc") KichCoRequest kichThuoc,
            BindingResult result ,
            HttpServletRequest request ,
            Model model
    ) throws ParseException {

        if(result.hasErrors()){
            return "admin/kichCo/update";
        }

        KichCo kichThuocCu = kichThuocService.chiTietTheoId(id);

        if(kichThuocService.kiemTraTrungMaKhong(kichThuoc.getMa(), kichThuocCu.getMa())){
            model.addAttribute("trungMa",true);
            return "admin/kichCo/update";
        }

        if(kichThuocService.kiemTraTrungTenKhong(String.valueOf(kichThuoc.getTen()), kichThuocCu.getTen())){
            model.addAttribute("trungTen",true);
            return "admin/kichCo/update";
        }

        KichCo kichThuocUpdate = new KichCo();
        kichThuocUpdate.setId(kichThuocCu.getId());
        kichThuocUpdate.setMa(kichThuoc.getMa());
        kichThuocUpdate.setTen(String.valueOf(kichThuoc.getTen()));
        kichThuocUpdate.setMoTa(kichThuoc.getMoTa());

        Integer trangThai = kichThuoc.getTrangThai();
        kichThuocUpdate.setTrangThai(trangThai);
        kichThuocUpdate.setNgaySua(Constant.getDateNow());

        kichThuocUpdate.setNgayTao(kichThuocCu.getNgayTao());
        kichThuocUpdate.setNguoiSua(kichThuocCu.getNguoiSua());
        kichThuocUpdate.setNguoiTao(kichThuocCu.getNguoiTao());

        kichThuocService.capNhat(kichThuocUpdate);
        System.out.println("Sửa dữ liệu thành công");

        model.addAttribute("kichThuoc",kichThuoc);
        model.addAttribute("messageSuccess",true);

        return "admin/kichCo/update";
    }

    @PostMapping("/them")
    public String themMoi(
            Model model,
            @Valid @ModelAttribute("kichThuoc") KichCoRequest request,
            BindingResult result ,
            @RequestParam(name = "page",defaultValue = "0") int currentPage ,
            HttpServletRequest httpServletRequest
    ) throws ParseException
    {
        if(result.hasErrors()){
            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage,Constant.pageNumber);
            Page<KichCo> pageKichThuoc =  kichThuocService.layDanhSach(textSearch, pageable);
            List<KichCo> kichThuocs = pageKichThuoc.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL",pageKichThuoc.getNumberOfElements());
            model.addAttribute("totalPage",pageKichThuoc.getTotalPages());
            model.addAttribute("dsKichThuoc", kichThuocs);
            model.addAttribute("pageChoosedNumber",currentPage);
//            System.out.println("Lỗi nhưng không hiển thị lỗi");
//            System.out.println("Error basic : " + result.toString());
            return "admin/kichCo/create";
        }
//        System.out.println("Mã request : " + request.getMa());
        if(kichThuocService.kiemTraTrungMaKhong(request.getMa())){
//            System.out.println("Trùng mã rồi ...");
            model.addAttribute("trungMa",true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<KichCo> pageKichCo =  kichThuocService.layDanhSach(textSearch, pageable);
            List<KichCo> kichCos = pageKichCo.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL",pageKichCo.getNumberOfElements());
            model.addAttribute("totalPage",pageKichCo.getTotalPages());
            model.addAttribute("dsKichCo", kichCos);
            return "admin/kichCo/create";
        }

        if(kichThuocService.kiemTraTrungTenKhong(String.valueOf(request.getTen()))){
            model.addAttribute("trungTen",true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<KichCo> pageKichCo =  kichThuocService.layDanhSach(textSearch, pageable);
            List<KichCo> kichCos = pageKichCo.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL",pageKichCo.getNumberOfElements());
            model.addAttribute("totalPage",pageKichCo.getTotalPages());
            model.addAttribute("dsKichCo", kichCos);
            return "admin/kichCo/create";
        }

        KichCo kichThuocThemMoi = new KichCo();
        kichThuocThemMoi.setMa(request.getMa());
        kichThuocThemMoi.setTen(String.valueOf(request.getTen()));
        kichThuocThemMoi.setMoTa(request.getMoTa());
        kichThuocThemMoi.setNguoiTao(1);
        kichThuocThemMoi.setNguoiSua(1);
        kichThuocThemMoi.setNgayTao(Constant.getDateNow());
        kichThuocThemMoi.setNgaySua(Constant.getDateNow());
        kichThuocThemMoi.setTrangThai(1);

        kichThuocService.themMoi(kichThuocThemMoi);

        model.addAttribute("kichThuoc",new KichCoRequest());
        model.addAttribute("messageSuccess",true);

        // cập nhật nội dung mới lên table
        String textSearch = httpServletRequest.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage,Constant.pageNumber);
        Page<KichCo> pageKichThuoc =  kichThuocService.layDanhSach(textSearch, pageable);
        List<KichCo> kichThuocs = pageKichThuoc.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL",pageKichThuoc.getNumberOfElements());
        model.addAttribute("totalPage",pageKichThuoc.getTotalPages());
        model.addAttribute("dsKichThuoc", kichThuocs);
        model.addAttribute("pageChoosedNumber",currentPage);

        return "admin/kichCo/create";
    }

    @GetMapping("/xoa/{id}")
    public String xoa(
            @PathVariable("id") UUID id
    ) {
        KichCo kichThuocx = kichThuocService.chiTietTheoId(id);
        kichThuocService.xoa(id);
        return "redirect:/kich-thuoc/hien-thi";
    }

}
