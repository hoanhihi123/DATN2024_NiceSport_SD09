package com.example.duantn.controller;

import com.example.duantn.dto.Constant;
import com.example.duantn.model.ChiTietSanPham;
import com.example.duantn.model.DotKhuyenMai;
import com.example.duantn.model.SanPham;
import com.example.duantn.model.SanPhamDotKhuyenMai;
import com.example.duantn.request.DotKhuyenMaiRequest;
import com.example.duantn.service.impl.DotKhuyenMaiServiceImpl;
import com.example.duantn.service.impl.SanPhamServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/dot-khuyen-mai")
public class DotKhuyenMaiController {

    private final DotKhuyenMaiServiceImpl dotKhuyenMaiService;
    private final SanPhamServiceImpl sanPhamService;


    public DotKhuyenMaiController(DotKhuyenMaiServiceImpl dotKhuyenMaiService, SanPhamServiceImpl sanPhamService) {
        this.dotKhuyenMaiService = dotKhuyenMaiService;
        this.sanPhamService = sanPhamService;
    }

    @GetMapping("/hien-thi")
    public String index(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") int currentPage,
            HttpServletRequest request
    ) {
        model.addAttribute("dotKhuyenMai", new DotKhuyenMai());
        String textSearch = request.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<DotKhuyenMai> pageDotKhuyenMai = dotKhuyenMaiService.layDanhSach(textSearch, pageable);
        List<DotKhuyenMai> dotKhuyenMaix = pageDotKhuyenMai.getContent();
        List<SanPham> dsSanPham = sanPhamService.layDanhSach();

        // muon hien thi so trang
        model.addAttribute("tongSL", pageDotKhuyenMai.getNumberOfElements());
        model.addAttribute("totalPage", pageDotKhuyenMai.getTotalPages());
        model.addAttribute("dsDotKhuyenMai", dotKhuyenMaix);
        model.addAttribute("dsSanPham", dsSanPham);
        model.addAttribute("pageChoosedNumber", currentPage);
        return "admin/dotKhuyenMai/index";
    }

    @GetMapping("/view-add")
    public String viewAdd(Model model, @RequestParam(name = "page", defaultValue = "0") int currentPage) {
        // Truy vấn danh sách sản phẩm từ cơ sở dữ liệu với phân trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber); // Số lượng sản phẩm trên mỗi trang
        Page<SanPham> pageSanPham = sanPhamService.layDanhSach(pageable);

        model.addAttribute("dsSanPham", pageSanPham.getContent()); // Gán danh sách sản phẩm vào model
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", pageSanPham.getTotalPages());

        return "admin/dotKhuyenMai/themDotKhuyenMai";
    }

    @PostMapping("/them")
    public String themMoi(Model model, @ModelAttribute("dotKhuyenMai") DotKhuyenMaiRequest request, BindingResult result,
                          @RequestParam(name = "page", defaultValue = "0") int currentPage,
                          HttpServletRequest httpServletRequest) throws ParseException {

        if (dotKhuyenMaiService.kiemTraTrungMa(request.getMa())) {
            model.addAttribute("trungMa", true);
            model.addAttribute("dsDotKhuyenMai", dotKhuyenMaiService.layDanhSach());
            return "admin/dotKhuyenMai/index";
        }

        // Tạo mới đợt khuyến mãi từ dữ liệu nhập vào
        DotKhuyenMai dotKhuyenMaiThemMoi = new DotKhuyenMai();
        dotKhuyenMaiThemMoi.setMa(request.getMa());
        dotKhuyenMaiThemMoi.setTen(request.getTen());
        dotKhuyenMaiThemMoi.setGiaTriGiam(request.getGiaTriGiam());
        dotKhuyenMaiThemMoi.setNgayBatDau(request.getNgayBatDau());
        dotKhuyenMaiThemMoi.setNgayKetThuc(request.getNgayKetThuc());
        dotKhuyenMaiThemMoi.setTrangThai(1);

        if (request.getNgayKetThuc().before(Constant.getDateNow())) {
            dotKhuyenMaiThemMoi.setTrangThai(0);
        } else {
            dotKhuyenMaiThemMoi.setTrangThai(1);
        }
        dotKhuyenMaiThemMoi.setNguoiTao(1);
        dotKhuyenMaiThemMoi.setNguoiSua(1);
        dotKhuyenMaiThemMoi.setNgayTao(Constant.getDateNow());
        dotKhuyenMaiThemMoi.setNgaySua(Constant.getDateNow());

        SanPhamDotKhuyenMai spDkm = new SanPhamDotKhuyenMai();

        // Lưu đợt khuyến mãi mới vào cơ sở dữ liệu
        dotKhuyenMaiService.apDungDotKhuyenMaiChoSanPham(spDkm, dotKhuyenMaiThemMoi, Arrays.asList(request.getSelectedProducts()), request.getGiaTriGiam());

        return String.format("redirect:/dot-khuyen-mai/hien-thi?page=%d", currentPage);
    }

    @GetMapping("/view-sua/{id}")
    public String viewSua(@PathVariable("id") UUID id,
                          @ModelAttribute("dotKhuyenMai") DotKhuyenMaiRequest request,
                          Model model,
                          @RequestParam(defaultValue = "0") int page) {
        DotKhuyenMai dotKhuyenMaiDetail = dotKhuyenMaiService.chiTietTheoId(id);
        model.addAttribute("dotKhuyenMai", dotKhuyenMaiDetail);

        int pageSize = 5;

        Page<SanPham> sanPhamPage = sanPhamService.layDanhSachSanPhamPhanTrang(page, pageSize);
        List<SanPham> danhSachSanPham = sanPhamPage.getContent();
        int totalPages = sanPhamPage.getTotalPages();

//        List<SanPham> sanPhamApDung = sanPhamService.layDanhSachSanPhamApDungMaGiamGia(id);

        List<SanPham> sp = sanPhamService.getSanPhamByIdKM(id);

        model.addAttribute("dsSanPham", danhSachSanPham);
        model.addAttribute("sanPhamApDung", sp);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", page);

        // Return the view
        return "admin/dotKhuyenMai/dotKhuyenMaiDetail";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @PostMapping("/sua/{id}")
    public String sua(
            @PathVariable("id") UUID id,
            @Valid @ModelAttribute("dotKhuyenMai") DotKhuyenMaiRequest request,
            BindingResult result,
            Model model
    ) throws ParseException {
        if (request.getNgayBatDau() == null || request.getNgayKetThuc() == null) {
            result.rejectValue("ngayBatDau", "error.ngayBatDau", "Ngày bắt đầu và ngày kết thúc không được để trống");
            model.addAttribute("dsDotKhuyenMai", dotKhuyenMaiService.layDanhSach());
            return "admin/dotKhuyenMai/dotKhuyenMaiDetail";
        }

        if (result.hasErrors()) {
            model.addAttribute("dsDotKhuyenMai", dotKhuyenMaiService.layDanhSach());
            return "admin/dotKhuyenMai/dotKhuyenMaiDetail";
        }

        DotKhuyenMai dotKhuyenMaiCu = dotKhuyenMaiService.chiTietTheoId(id);
        if (dotKhuyenMaiService.kiemTraTrungMaKhong(request.getMa(), dotKhuyenMaiCu.getMa())) {
            model.addAttribute("trungMa", true);
            return "admin/dotKhuyenMai/dotKhuyenMaiDetail";
        }

        if (dotKhuyenMaiService.kiemTraTrungTenKhong(request.getTen(), dotKhuyenMaiCu.getTen())) {
            model.addAttribute("trungTen", true);
            return "admin/dotKhuyenMai/dotKhuyenMaiDetail";
        }

        DotKhuyenMai dotKhuyenMaiUpdate = new DotKhuyenMai();


        dotKhuyenMaiUpdate.setId(dotKhuyenMaiCu.getId());
        dotKhuyenMaiUpdate.setMa(request.getMa());
        dotKhuyenMaiUpdate.setTen(request.getTen());
        dotKhuyenMaiUpdate.setGiaTriGiam(request.getGiaTriGiam());

        dotKhuyenMaiUpdate.setNgayBatDau(request.getNgayBatDau() != null ? request.getNgayBatDau() : dotKhuyenMaiCu.getNgayBatDau());

        dotKhuyenMaiUpdate.setNgayKetThuc(request.getNgayKetThuc() != null ? request.getNgayKetThuc() : dotKhuyenMaiCu.getNgayKetThuc());

        dotKhuyenMaiUpdate.setNguoiTao(1);
        dotKhuyenMaiUpdate.setNguoiSua(1);
        dotKhuyenMaiUpdate.setNgayTao(Constant.getDateNow());
        dotKhuyenMaiUpdate.setNgaySua(Constant.getDateNow());

        if (dotKhuyenMaiUpdate.getNgayKetThuc() != null) {
            if (dotKhuyenMaiUpdate.getNgayKetThuc().after(new Date())) {
                dotKhuyenMaiUpdate.setTrangThai(1);
            } else {
                dotKhuyenMaiUpdate.setTrangThai(0);
            }
        } else {
            dotKhuyenMaiUpdate.setTrangThai(1);
        }

        dotKhuyenMaiService.capNhat(dotKhuyenMaiUpdate);
        System.out.println("Sửa dữ liệu thành công");

        return "redirect:/dot-khuyen-mai/hien-thi";
    }

    @GetMapping("/san-pham")
    public String sanPham(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") int currentPage,
            @RequestParam(name = "textsearch", required = false) String textSearch, // Thêm tham số textsearch
            HttpServletRequest request
    ) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<SanPham> pageSanPham = sanPhamService.layDanhSach(textSearch, pageable);

        List<SanPham> sanPhamList = pageSanPham.getContent();

        int totalPages = pageSanPham.getTotalPages();

        model.addAttribute("dsSanPham", sanPhamList);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("sanPham", new SanPham());
        return "admin/dotKhuyenMai/themDotKhuyenMai";
    }

    @GetMapping("/xoa/{id}")
    public String xoa(
            @PathVariable("id") UUID id
    ) {
        DotKhuyenMai dotKhuyenMaix = dotKhuyenMaiService.chiTietTheoId(id);
        dotKhuyenMaiService.xoa(id);
        return "redirect:/dot-khuyen-mai/hien-thi";
    }

    @GetMapping("/checkStatus")
    @ResponseBody
    public String checkStatus() {
        dotKhuyenMaiService.checkAndChangeStatus();
        return "Status checked and changed if needed.";
    }

}
