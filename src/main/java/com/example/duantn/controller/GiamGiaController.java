//package com.example.duantn.controller;
//
//import com.example.duantn.dto.Constant;
//import com.example.duantn.model.GiamGia;
//import com.example.duantn.model.SanPham;
//import com.example.duantn.request.GiamGiaRequest;
//import com.example.duantn.service.impl.GiamGiaServiceImpl;
//import com.example.duantn.service.impl.SanPhamServiceImpl;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import java.text.ParseException;
//import java.util.Date;
//import java.util.List;
//import java.util.UUID;
//
//@Controller
//@RequestMapping("/giam-gia")
//public class GiamGiaController {
//
//    @Autowired
//    private GiamGiaServiceImpl giamGiaService;
//    @Autowired
//    private SanPhamServiceImpl sanPhamService;
//
//    @GetMapping("/hien-thi")
//    public String index(
//            Model model,
//            @RequestParam(name = "page", defaultValue = "0") int currentPage,
//            HttpServletRequest request
//    ) {
//        model.addAttribute("giamGia", new GiamGia());
//        String textSearch = request.getParameter("textsearch");
//
//        // phan trang
//        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
//        Page<GiamGia> pageGiamGia = giamGiaService.layDanhSach(textSearch, pageable);
//        List<GiamGia> giamGiax = pageGiamGia.getContent();
//        List<SanPham> dsSanPham = sanPhamService.layDanhSach();
//
//        // muon hien thi so trang
//        model.addAttribute("tongSL", pageGiamGia.getNumberOfElements());
//        model.addAttribute("totalPage", pageGiamGia.getTotalPages());
//        model.addAttribute("dsGiamGia", giamGiax);
//        model.addAttribute("dsSanPham", dsSanPham);
//        model.addAttribute("pageChoosedNumber", currentPage);
//        return "admin/giamGia/index";
//    }
//
//    @GetMapping("/san-pham")
//    public String sanPham(
//            Model model,
//            @RequestParam(name = "page", defaultValue = "0") int currentPage,
//            HttpServletRequest request
//    ) {
//        model.addAttribute("sanPham", new SanPham());
//        String textSearch = request.getParameter("textsearch");
//
//        // phan trang
//        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
//        Page<SanPham> pageSanPham = sanPhamService.layDanhSach(textSearch, pageable);
//        List<SanPham> sanPham = pageSanPham.getContent();
//
//        // muon hien thi so trang
//        model.addAttribute("tongSL", pageSanPham.getNumberOfElements());
//        model.addAttribute("totalPage", pageSanPham.getTotalPages());
//        model.addAttribute("dsSanPham", sanPham);
//        model.addAttribute("pageChoosedNumber", currentPage);
//        return "admin/giamGia/index";
//    }
//
//    @GetMapping("/view-sua/{id}")
//    public String viewSua(@PathVariable("id") UUID id,
//                          @ModelAttribute("giamGia") GiamGiaRequest giamGia,
//                          Model model,
//                          @RequestParam(defaultValue = "0") int page) {
//        // Lấy thông tin chi tiết của đợt giảm giá theo id
//        GiamGia giamGiaDetail = giamGiaService.chiTietTheoId(id);
//        model.addAttribute("giamGia", giamGiaDetail);
//
//        // Số lượng sản phẩm trên mỗi trang
//        int pageSize = 5;
//
//        // Lấy danh sách sản phẩm và phân trang
//        Page<SanPham> sanPhamPage = sanPhamService.layDanhSachSanPhamPhanTrang(page, pageSize);
//        List<SanPham> danhSachSanPham = sanPhamPage.getContent();
//        int totalPages = sanPhamPage.getTotalPages();
//
//        // Lấy danh sách sản phẩm áp dụng mã giảm giá cùng với trạng thái
//        List<SanPham> sanPhamApDung = sanPhamService.layDanhSachSanPhamApDungMaGiamGia(id);
//
//        // Truyền danh sách sản phẩm và thông tin phân trang vào model
//        model.addAttribute("dsSanPham", danhSachSanPham);
//        model.addAttribute("sanPhamApDung", sanPhamApDung);
//        model.addAttribute("totalPages", totalPages);
//        model.addAttribute("currentPage", page);
//
//        // Return the view
//        return "admin/giamGia/dotGiamGia";
//    }
//
//
//    @PostMapping("/sua/{id}")
//    public String sua(
//            @PathVariable("id") UUID id,
//            @Valid @ModelAttribute("giamGia") GiamGiaRequest request,
//            BindingResult result,
//            Model model
//    ) throws ParseException {
//        // Kiểm tra xem có lỗi không
//        if (result.hasErrors()) {
//            // Nếu có lỗi, trả về trang chỉnh sửa và truyền lại danh sách sản phẩm
//            model.addAttribute("dsSanPham", sanPhamService.layDanhSach());
//            return "admin/giamGia/dotGiamGia";
//        }
//
//        // Lấy thông tin đợt giảm giá cũ
//        GiamGia giamGiaCu = giamGiaService.chiTietTheoId(id);
//        if (giamGiaService.kiemTraTrungMaKhong(request.getMa(), giamGiaCu.getMa())) {
//            model.addAttribute("trungMa", true);
//            return "admin/giamGia/dotGiamGia";
//        }
//
//        if (giamGiaService.kiemTraTrungTenKhong(request.getTen(), giamGiaCu.getTen())) {
//            model.addAttribute("trungTen", true);
//            return "admin/giamGia/dotGiamGia";
//        }
//
//        // Tạo đối tượng GiamGia mới để cập nhật thông tin
//        GiamGia giamGiaUpdate = new GiamGia();
//
//        // Thiết lập đối tượng SanPham cho trường idSanPham
////        giamGiaUpdate.setIdSanPham(giamGiaCu.getIdSanPham());
//
//        // Cập nhật thông tin cho đối tượng GiamGia
//        giamGiaUpdate.setId(giamGiaCu.getId());
//        giamGiaUpdate.setMa(request.getMa());
//        giamGiaUpdate.setTen(request.getTen());
//        giamGiaUpdate.setGiaTriGiam(request.getGiaTriGiam());
//        giamGiaUpdate.setNgayBatDau(request.getNgayBatDau());
//        giamGiaUpdate.setNgayKetThuc(request.getNgayKetThuc());
//        giamGiaUpdate.setNguoiTao(1);
//        giamGiaUpdate.setNguoiSua(1);
//        giamGiaUpdate.setNgayTao(Constant.getDateNow());
//        giamGiaUpdate.setNgaySua(Constant.getDateNow());
//
//        // Kiểm tra nếu ngày kết thúc nhỏ hơn ngày hiện tại thì đặt trạng thái là "Ngưng hoạt động"
//        if (giamGiaUpdate.getNgayKetThuc().before(Constant.getDateNow())) {
//            giamGiaUpdate.setTrangThai(0); // 0 là ngưng hoạt động
//        } else {
//            giamGiaUpdate.setTrangThai(1); // 1 là hoạt động
//        }
//
//        // Cập nhật đợt giảm giá
//        giamGiaService.capNhat(giamGiaUpdate);
//        System.out.println("Sửa dữ liệu thành công");
//
//        // Chuyển hướng người dùng đến trang hiển thị danh sách đợt giảm giá
//        return "redirect:/giam-gia/hien-thi";
//    }
//
//    // Trong controller
//    @GetMapping("/view-add")
//    public String viewAdd(Model model, @RequestParam(name = "page", defaultValue = "0") int currentPage) {
//        // Truy vấn danh sách sản phẩm từ cơ sở dữ liệu với phân trang
//        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber); // Số lượng sản phẩm trên mỗi trang
//        Page<SanPham> pageSanPham = sanPhamService.layDanhSach(pageable);
//
//        model.addAttribute("dsSanPham", pageSanPham.getContent()); // Gán danh sách sản phẩm vào model
//        model.addAttribute("currentPage", currentPage);
//        model.addAttribute("totalPages", pageSanPham.getTotalPages());
//
//        return "admin/giamGia/dotGiamGia";
//    }
//
//    @PostMapping("/them")
//    public String themMoi(Model model,
//                          @ModelAttribute("giamGia") GiamGiaRequest request, BindingResult result,
//                          @RequestParam(name = "page", defaultValue = "0")
//                          int currentPage,
//                          HttpServletRequest httpServletRequest)
//            throws ParseException {
//        // Kiểm tra có lỗi trong dữ liệu đầu vào không
//        if (result.hasErrors()) {
//            // Nếu có lỗi, hiển thị lại form thêm mới với thông tin đã nhập và thông báo lỗi
//            model.addAttribute("dsSanPham", sanPhamService.layDanhSach());
//            return "admin/giamGia/index";
//        }
//
//        // Kiểm tra trùng mã
//        if (giamGiaService.kiemTraTrungMa(request.getMa())) {
//            model.addAttribute("trungMa", true);
//            model.addAttribute("dsSanPham", sanPhamService.layDanhSach());
//            return "admin/giamGia/index";
//        }
//
//        // Kiểm tra trùng tên
//        if (giamGiaService.kiemTraTrungTen(request.getTen())) {
//            model.addAttribute("trungTen", true);
//            model.addAttribute("dsSanPham", sanPhamService.layDanhSach());
//            return "admin/giamGia/index";
//        }
//
//        // Tạo mới đối tượng GiamGia và lưu vào cơ sở dữ liệu
//        GiamGia giamGiaThemMoi = new GiamGia();
//
//        // Lấy đối tượng SanPham từ idSanPham
//        SanPham tenSanPham = sanPhamService.chiTietTheoId(request.getIdSanPham());
//
//        // Kiểm tra xem đối tượng SanPham có tồn tại không
//        if (tenSanPham != null) {
//            giamGiaThemMoi.setIdSanPham(tenSanPham);
//        } else {
//            // Xử lý khi không tìm thấy đối tượng SanPham
//            System.err.println("Error: SanPham not found for id " + request.getIdSanPham());
//            // Có thể thông báo lỗi hoặc xử lý theo nhu cầu của bạn
//            // return "redirect:/error";
//        }
//
//        // Thiết lập các trường khác của GiamGia từ request
//        giamGiaThemMoi.setMa(request.getMa());
//        giamGiaThemMoi.setTen(request.getTen());
//        giamGiaThemMoi.setGiaTriGiam(request.getGiaTriGiam());
//        giamGiaThemMoi.setNgayBatDau(request.getNgayBatDau());
//        giamGiaThemMoi.setNgayKetThuc(request.getNgayKetThuc());
//
//        // Kiểm tra nếu ngày kết thúc nhỏ hơn ngày hiện tại thì đặt trạng thái là "Ngưng hoạt động"
//        if (request.getNgayKetThuc().before(Constant.getDateNow())) {
//            giamGiaThemMoi.setTrangThai(0); // 0 là ngưng hoạt động
//        } else {
//            giamGiaThemMoi.setTrangThai(1); // 1 là hoạt động
//        }
//
//        giamGiaThemMoi.setNguoiTao(1); // Giả sử ID người tạo là 1
//        giamGiaThemMoi.setNguoiSua(1); // Giả sử ID người sửa là 1
//        giamGiaThemMoi.setNgayTao(Constant.getDateNow()); // Lấy ngày hiện tại
//        giamGiaThemMoi.setNgaySua(Constant.getDateNow()); // Lấy ngày hiện tại
//
//        // Gọi service để thêm mới GiamGia và thực hiện các thao tác khác cần thiết
//        giamGiaService.themMoi(giamGiaThemMoi);
//        System.out.println("Thêm mới mã giảm giá thành công");
//
//        // Kiểm tra và cập nhật trạng thái của đợt giảm giá nếu ngày kết thúc nhỏ hơn ngày hiện tại
//        if (giamGiaThemMoi.getNgayKetThuc().before(new Date())) {
//            giamGiaThemMoi.setTrangThai(0); // Đặt trạng thái là ngưng hoạt động
//            giamGiaService.capNhat(giamGiaThemMoi); // Cập nhật đối tượng đợt giảm giá
//        }
//
//        return "redirect:/giam-gia/hien-thi";
//    }
//    @GetMapping("/xoa/{id}")
//    public String xoa(
//            @PathVariable("id") UUID id
//    ) {
//        GiamGia giamGiax = giamGiaService.chiTietTheoId(id);
//        giamGiaService.xoa(id);
//        return "redirect:/giam-gia/hien-thi";
//    }
//
//    @GetMapping("/update-status")
//    public String updateExpiredGiamGiaStatus() {
//        giamGiaService.updateExpiredGiamGiaStatus();
//        return "Cập nhật trạng thái đợt khuyến mãi thành công";
//    }
//}
