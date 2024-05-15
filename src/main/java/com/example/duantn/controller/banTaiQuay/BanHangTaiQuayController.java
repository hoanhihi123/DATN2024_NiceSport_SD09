package com.example.duantn.controller.banTaiQuay;

import com.example.duantn.dto.Constant;
import com.example.duantn.model.*;
import com.example.duantn.request.KhachHangTaiQuay;
import com.example.duantn.request.MuaHangTaiQuay;
import com.example.duantn.request.PhanTrangRequest;
import com.example.duantn.request.SanPhamTaiQuay;
import com.example.duantn.service.impl.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

@Controller
@RequestMapping("/ban-hang")   // /ban-hang/view
public class BanHangTaiQuayController {

    // , khachHang, GiamGia, SanPhamCT, HoaDon
    @Autowired
    ChiTietSPServiceImpl sanPhamCTService;

    @Autowired
    PhieuGiamGiaServiceImpl phieuGiamGiaService;

    @Autowired
    HoaDonServiceImpl hoaDonService;

    @Autowired
    HoaDonCTServiceImpl hoaDonCTService;

    @Autowired
    KhachHangServiceImpl khachHangService;

    @Autowired
    MauSacServiceImpl mauSacService;

    @Autowired
    KichCoServiceImpl kichCoService;

    @Autowired
    LoaiSanPhamServiceImpl loaiSanPhamService;


    @GetMapping("view")
    public String xemBanHangTaiQuay(
            Model model,
            HttpServletRequest httpServletRequest
    ){
        sanPhamCTService.xoaSanPhamChiTietTheoTrangThai(2);

        return "admin/banHangTaiQuay/banHang2";
    }

    @PostMapping("/phan-trang-sanPhamChiTiet")
    public ResponseEntity<Map<String, Object>> phanTrangSanPhamChiTiet(
            final Model model
            , final HttpServletRequest request
            , final HttpServletResponse response
            , @RequestBody PhanTrangRequest phanTrang
    ) throws IOException {
        int currentPage = 0;
        int pageLimit = phanTrang.getPageLimit()==null?4:phanTrang.getPageLimit();
        currentPage = phanTrang.getCurrentPage()==null?0:phanTrang.getCurrentPage();
//        System.out.println("Current page: " + currentPage);

        Pageable pageable = PageRequest.of(currentPage, pageLimit);
        Page<ChiTietSanPham> pageChiTietSP =  sanPhamCTService.layDanhSach(pageable);
        List<ChiTietSanPham> chiTietSanPhams = pageChiTietSP.getContent();


        Map<String, Object> jsonResult = new HashMap<String, Object>();
        jsonResult.put("code", 200);
        jsonResult.put("status", "Success");
        jsonResult.put("danhSachSanPhamChiTiet", chiTietSanPhams);

        return ResponseEntity.ok(jsonResult);
    }

    @PostMapping("/phan-trang-sanPhamChiTiet-timkiem")
    public ResponseEntity<Map<String, Object>> phanTrangSanPhamChiTiet_timKiem(
            final Model model
            , final HttpServletRequest request
            , final HttpServletResponse response
            ,@RequestBody SanPhamTaiQuay sanPhamTaiQuay
    ) throws IOException {
        System.out.println("Chay vao : /phan-trang-sanPhamChiTiet-timkiem");
        UUID idKichCo = sanPhamTaiQuay.getIdKichCo();
        UUID idLoaiSP = sanPhamTaiQuay.getIdLoaiSP();
        UUID idMauSac = sanPhamTaiQuay.getIdMauSac();
        String tenSanPham = sanPhamTaiQuay.getTenSP();

        System.out.println("ID kích cỡ : " + idKichCo);
        System.out.println("idLoaiSP : " + idLoaiSP);
        System.out.println("idMauSac : " + idMauSac);
        System.out.println("tenSanPham : " + tenSanPham);

        int currentPage = 0;
        int pageLimit = sanPhamTaiQuay.getPageLimit()==null?4:sanPhamTaiQuay.getPageLimit();
        currentPage = sanPhamTaiQuay.getCurrentPage()==null?0:sanPhamTaiQuay.getCurrentPage();
        System.out.println("Current page tại /phan-trang-sanPhamChiTiet-timkiem : " + currentPage);

        Pageable pageable = PageRequest.of(currentPage, pageLimit);

        Map<String,String> keyWork = new HashMap<>();
        keyWork.put("tenSanPham",tenSanPham);
        if(idKichCo!=null){
            KichCo kichCoSearch = kichCoService.chiTietTheoId(idKichCo);
            keyWork.put("tenKichCo",kichCoSearch.getTen());
        }else {
            keyWork.put("tenKichCo","");
        }

        if(idLoaiSP!=null){
            LoaiSanPham loaiSanPhamSearch = loaiSanPhamService.chiTietTheoId(idLoaiSP);
            keyWork.put("tenLoaiSanPham",loaiSanPhamSearch.getTen());
        }else{
            keyWork.put("tenLoaiSanPham","");
        }

        if(idMauSac!=null){
            MauSac mauSacSearch = mauSacService.chiTietTheoId(idMauSac);
            keyWork.put("tenMauSac",mauSacSearch.getTen());
        }else{
            keyWork.put("tenMauSac","");
        }

        System.out.println("Danh sách key tìm kiếm trong hàm /phan-trang-sanPhamChiTiet-timkiem");
        for (String key : keyWork.keySet()) {
            System.out.println("Key: " + key + ", Value: " + keyWork.get(key));
        }

        Page<ChiTietSanPham> pageChiTietSP =  sanPhamCTService.danhSachSanPhamTimKiem_phanTrang(keyWork, pageable);
        List<ChiTietSanPham> chiTietSanPhams = pageChiTietSP.getContent();
        System.out.println("Kết quả tìm kiếm và phân trang - trang số " + currentPage + " là : " + chiTietSanPhams.size());

        for(ChiTietSanPham sanPhamCT : chiTietSanPhams){
            System.out.println(sanPhamCT.toString());
        }

        Map<String, Object> jsonResult = new HashMap<String, Object>();
        jsonResult.put("code", 200);
        jsonResult.put("status", "Success");
        jsonResult.put("danhSachSanPhamChiTiet", chiTietSanPhams);

        return ResponseEntity.ok(jsonResult);
    }

    @PostMapping("/taoMoiKhachHang")
    public ResponseEntity<Map<String, Object>> taoMoiKhachHang(
            final Model model
            , final HttpServletRequest request
            , final HttpServletResponse response
            , @RequestBody KhachHangTaiQuay khachHangTaiQuay
    ) throws IOException, ParseException {
        KhachHang khachHangThemMoi = new KhachHang();
        khachHangThemMoi.setEmail(khachHangTaiQuay.getEmail());
        khachHangThemMoi.setSoDT(khachHangTaiQuay.getSdt());
        khachHangThemMoi.setHoTen(khachHangTaiQuay.getTenKhachHang());
        khachHangThemMoi.setGioiTinh(khachHangTaiQuay.getGioiTinh());
        khachHangThemMoi.setNgayTao(Constant.getDateNow());
        khachHangThemMoi.setNguoiTao(1);

        khachHangService.themMoi(khachHangThemMoi);

        Map<String, Object> jsonResult = new HashMap<String, Object>();
        jsonResult.put("code", 200);
        jsonResult.put("status", "Success");
        jsonResult.put("message","Thêm mới khách hàng thành công");
//        jsonResult.put("danhSachSanPhamChiTiet", chiTietSanPhams);

        return ResponseEntity.ok(jsonResult);
    }



    @PostMapping("/phan-trang-hoaDonCho")
    public ResponseEntity<Map<String, Object>> phanTrangChoHoaDonCho(
            final Model model
            , final HttpServletRequest request
            , final HttpServletResponse response
            , @RequestBody PhanTrangRequest phanTrang
    ) throws IOException {
        UUID idHoaDon = phanTrang.getIdHoaDon();
        int currentPage = 0;
        int pageLimit = phanTrang.getPageLimit()==null?2:phanTrang.getPageLimit();
        currentPage = phanTrang.getCurrentPage()==null?0:phanTrang.getCurrentPage();

//        System.out.println("IdHoa don hien tại trong /phan-trang-hoaDonCho :  " + idHoaDon);

        Pageable pageable = PageRequest.of(currentPage, pageLimit);
        Page<HoaDonChiTiet> pageHoaDonChiTiet =  hoaDonCTService.layDanhSachHoaDonChiTiet_va_PhanTrang(idHoaDon, pageable);
        List<HoaDonChiTiet> hoaDonChiTiets = pageHoaDonChiTiet.getContent();


//        System.out.println("Danh sách hóa đơn lấy được trong phân trang : " + hoaDonChiTiets.size());
        // có idHoaDon => lấy ra hóa dơn
        // từ hóa dơn => lấy ra khách hàng
        // từ khách hàng => set thông tin khách hàng vào kết quả trả về
        HoaDon hoaDonCurrent = hoaDonService.chiTietTheoId(idHoaDon);
        KhachHang khachHangOfHoaDon = khachHangService.layThongTinKhachHang_voiSDT("0000000000");
        if(hoaDonCurrent!=null){
//            System.out.println("Hoa đơn current - /phan-trang-hoaDonCho " + hoaDonCurrent.toString());
            khachHangOfHoaDon = khachHangService.layKhachHangTheoId(hoaDonCurrent.getKhachHang().getId());
        }
//        System.out.println("Size of hoa đơn chi tiết - /phan-trang-hoaDonCho : " + hoaDonChiTiets.size());
        Map<String, Object> jsonResult = new HashMap<String, Object>();
        jsonResult.put("code", 200);
        jsonResult.put("status", "Success");
        jsonResult.put("danhSachHoaDonChiTiet", hoaDonChiTiets);
        jsonResult.put("khachHangOfHoaDon", khachHangOfHoaDon);

        return ResponseEntity.ok(jsonResult);
    }

    @PostMapping("/phan-trang-thongTinKhachHang")
    public ResponseEntity<Map<String, Object>> phanTrang_thongTinKhachHang(
            final Model model
            , final HttpServletRequest request
            , final HttpServletResponse response
            , @RequestBody PhanTrangRequest phanTrang
    ) throws IOException {
        int currentPage = 0;
        int pageLimit = phanTrang.getPageLimit()==null?4:phanTrang.getPageLimit();
        currentPage = phanTrang.getCurrentPage()==null?0:phanTrang.getCurrentPage();
//        System.out.println("Current page: " + currentPage);

        Pageable pageable = PageRequest.of(currentPage, pageLimit);
        Page<KhachHang> pageKhachHang =  khachHangService.layDanhSach(pageable);
        List<KhachHang> khachHangs = pageKhachHang.getContent();




        Map<String, Object> jsonResult = new HashMap<String, Object>();
        jsonResult.put("code", 200);
        jsonResult.put("status", "Success");
        jsonResult.put("danhSachKhachHang", khachHangs);


        return ResponseEntity.ok(jsonResult);
    }

    @PostMapping("/phan-trang-phieuGiamGia")
    public ResponseEntity<Map<String, Object>> phanTrang_phieuGiamGia(
            final Model model
            , final HttpServletRequest request
            , final HttpServletResponse response
            , @RequestBody PhanTrangRequest phanTrang
    ) throws IOException {
        int currentPage = 0;
        int pageLimit = phanTrang.getPageLimit()==null?4:phanTrang.getPageLimit();
        currentPage = phanTrang.getCurrentPage()==null?0:phanTrang.getCurrentPage();

        System.out.println("Tổng tiền đơn hàng - /phan-trang-phieuGiamGiaaAAAAaaaa : " + phanTrang.getTongTienDonHang());

        Pageable pageable = PageRequest.of(currentPage, pageLimit);
        Page<PhieuGiamGia> pagePhieuGiamGia =  phieuGiamGiaService.layDanhSach_voiTongTienDonHang(pageable,phanTrang.getTongTienDonHang());
        List<PhieuGiamGia> phieuGiamGias = pagePhieuGiamGia.getContent();

        Double tongTienDonHang = phanTrang.getTongTienDonHang();
//        System.out.println("Tổng tiền đơn hàng - tại /phan-trang-phieuGiamGia : " + tongTienDonHang);

        List<PhieuGiamGia> dsPhieuGiamGiaHopLe = new ArrayList<>();
        int count = 0;
        if(tongTienDonHang!=null){
            for(PhieuGiamGia phieuGiamGia : phieuGiamGias){
                if(tongTienDonHang >= phieuGiamGia.getGiaTienXetDieuKien()){
                    dsPhieuGiamGiaHopLe.add(phieuGiamGia);
                    count++;
                }
            }
        }

//        System.out.println("Count - tại /phan-trang-phieuGiamGia : " + count);
//        System.out.println("Danh sách phiếu giảm giá hợp lệ - tại /phan-trang-phieuGiamGia : " + dsPhieuGiamGiaHopLe.size());

        Map<String, Object> jsonResult = new HashMap<String, Object>();
        jsonResult.put("code", 200);
        jsonResult.put("status", "Success");
        jsonResult.put("danhSachPhieuGiamGia", dsPhieuGiamGiaHopLe);


        return ResponseEntity.ok(jsonResult);
    }

    @PostMapping("/capNhatThongTinHoaDon_apDungPhieuGiamGiaNao")
    public ResponseEntity<Map<String, Object>> capNhatThongTinPhieuGiamGia(
            final Model model
            , final HttpServletRequest request
            , final HttpServletResponse response
            , @RequestBody MuaHangTaiQuay muaHangTaiQuay
    ) throws IOException {
        UUID idHoaDon = muaHangTaiQuay.getIdHoaDon();
        UUID idPhieuGiamGia = muaHangTaiQuay.getIdPhieuGiamGia();

        // tinh tong tien duoc giam
        HoaDon hoaDonCurrent = hoaDonService.detail(idHoaDon);
        PhieuGiamGia phieuGiamGia_InBillCurrent = new PhieuGiamGia();
        Integer soLuongPGG_current = 0;

        Double tongTienDonHang = hoaDonCurrent.getTongTienThanhToan();
        Double tongTienDonHangSauGiam = 0.0;
        Double tienDuocGiam = 0.0;
        Boolean checkTrungPhieuGiamGiaApDung = false;

        // xử lý tăng giảm số lượng phiếu giảm giá
        if (hoaDonCurrent.getPhieuGiamGia() == null) {
            phieuGiamGia_InBillCurrent = phieuGiamGiaService.detail(idPhieuGiamGia);
            soLuongPGG_current = phieuGiamGia_InBillCurrent.getSoLuong();
            // cập nhật lại số lượng phiếu giảm giá
            phieuGiamGiaService.capNhatSoLuongMoi_phieuGiamGia(soLuongPGG_current-1,phieuGiamGia_InBillCurrent.getId());
        }else{
            phieuGiamGia_InBillCurrent = phieuGiamGiaService.detail(hoaDonCurrent.getPhieuGiamGia().getId());
            soLuongPGG_current = phieuGiamGia_InBillCurrent.getSoLuong();
//            System.out.println("Id phiếu giảm hóa đơn cũ :  " +hoaDonCurrent.getPhieuGiamGia().getId() );
//            System.out.println("Id phiếu giảm giá mới áp dụng : " + idPhieuGiamGia);

            if(hoaDonCurrent.getPhieuGiamGia().getId().equals(idPhieuGiamGia)){ // trùng phiếu giảm giá áp dụng
                checkTrungPhieuGiamGiaApDung = true;
            }else {
                // kiểm tra xem phiếu giảm giá hiện tại != phiếu giảm giá mới chọn ko
                // nếu trùng phiếu giảm giá
                // phieu giam giá cũ + 1
                // cap nhat db
                phieuGiamGiaService.capNhatSoLuongMoi_phieuGiamGia(soLuongPGG_current+1,phieuGiamGia_InBillCurrent.getId());


                // phiếu giảm giá mới - 1
                PhieuGiamGia phieuGiamGiaMoiChonVaoHoaDon = phieuGiamGiaService.detail(idPhieuGiamGia);
                int soLuongPhieuGiamGiaMoi_current= phieuGiamGiaMoiChonVaoHoaDon.getSoLuong();
                System.out.println(" soLuongPhieuGiamGiaMoi_current -1 =  " + (soLuongPhieuGiamGiaMoi_current-1));
                // câp nhat vao db
                phieuGiamGiaService.capNhatSoLuongMoi_phieuGiamGia(soLuongPhieuGiamGiaMoi_current-1, idPhieuGiamGia);
            }
        }

        PhieuGiamGia phieuGiamGiaMoiApDung = new PhieuGiamGia();
        phieuGiamGiaMoiApDung = phieuGiamGiaService.detail(idPhieuGiamGia);
        // tính tiền được giảm bao nhiêu để sửa tổng tiền thanh toán, tiền được giảm vào hóa đơn hiện tại
        if(phieuGiamGiaMoiApDung.getHinhThucGiam().equalsIgnoreCase("tiền mặt")){
            tongTienDonHangSauGiam = tongTienDonHang - phieuGiamGiaMoiApDung.getGiaTriGiam();
        }else {
            tongTienDonHangSauGiam = tongTienDonHang - tongTienDonHang*(phieuGiamGiaMoiApDung.getGiaTriGiam()/100);
        }
        tienDuocGiam = tongTienDonHang - tongTienDonHangSauGiam;
        System.out.println("Tiền được giảm : " + tienDuocGiam);

        hoaDonCurrent.setTongTienDuocGiamGia(tienDuocGiam);

        hoaDonService.update(idHoaDon, hoaDonCurrent);

        // cập nhật phiếu giảm giá được áp dụng vào hóa đơn
        hoaDonService.capNhatPhieuGiamGiaApDungCho_hoaDonCho(idHoaDon, idPhieuGiamGia);

        Map<String, Object> jsonResult = new HashMap<String, Object>();
        jsonResult.put("code", 200);
        jsonResult.put("status", "Success");
        jsonResult.put("tongTienDonHang", hoaDonCurrent.getTongTienThanhToan());
        jsonResult.put("tienDuocGiam", tienDuocGiam);
        jsonResult.put("tongTienDonHangSauGiam", tongTienDonHangSauGiam);
        jsonResult.put("checkTrungPhieuGiamGiaApDung", checkTrungPhieuGiamGiaApDung);

        return ResponseEntity.ok(jsonResult);
    }

    @PostMapping("/capNhatTongTienDonHang_cuaHoaDonCurrent")
    public ResponseEntity<Map<String, Object>> capNhatTongTienDonHangHoaDonCurrent(
            final Model model
            , final HttpServletRequest request
            , final HttpServletResponse response
            , @RequestBody PhanTrangRequest phanTrangRequest
    ) throws IOException {
        List<HoaDonChiTiet> dsHoaDonChiTiet = hoaDonCTService.layDanhSachHoaDonChiTiet_theoIdHoaDon(phanTrangRequest.getIdHoaDon());
        UUID idHoaDon = phanTrangRequest.getIdHoaDon();

        Double tongTienDonHang = 0.0;
        Double  tongTienSauGiam = 0.0;
        Double tienDuocGiam = 0.0;
        for(HoaDonChiTiet hoaDonChiTiet : dsHoaDonChiTiet){
            if ( hoaDonChiTiet.getChiTietSanPham().getGiaTriGiam() == null || hoaDonChiTiet.getChiTietSanPham().getGiaTriGiam() ==0) {
                tongTienDonHang += (hoaDonChiTiet.getChiTietSanPham().getGiaTriSanPham() * hoaDonChiTiet.getSoLuong());
            } else {
                tongTienDonHang += (hoaDonChiTiet.getChiTietSanPham().getGiaTriGiam() * hoaDonChiTiet.getSoLuong());
            }
        }

        HoaDon hoaDonCurrent = hoaDonService.chiTietTheoId(phanTrangRequest.getIdHoaDon());
        if(hoaDonCurrent!=null){
//                System.out.println("Hoa đơn current - capNhatTongTienDonHang_cuaHoaDonCurrent :  " + hoaDonCurrent.toString());

            if(hoaDonCurrent.getTongTienDuocGiamGia()==null){
                hoaDonCurrent.setTongTienDuocGiamGia(0.0);
            }

            //            System.out.println("Hoa don current : " + hoaDonCurrent.toString());




            //        System.out.println("Tổng tiền đơn hàng : " + tongTienDonHang);
            tienDuocGiam = hoaDonCurrent.getTongTienDuocGiamGia();
            tongTienSauGiam  = tongTienDonHang - tienDuocGiam;
            hoaDonCurrent.setTongTienThanhToan(tongTienSauGiam);



            hoaDonService.capNhat(hoaDonCurrent);
        }

        // tại sao phần tổng tiền sau giảm ko được tính


        Map<String, Object> jsonResult = new HashMap<String, Object>();
        jsonResult.put("code", 200);
        jsonResult.put("status", "Success");
        jsonResult.put("tongTienDonHang", tongTienDonHang);
        if(hoaDonCurrent.getPhieuGiamGia()!=null) {
            jsonResult.put("tienDuocGiam", tienDuocGiam);
            jsonResult.put("tongTienDonHangSauGiam", tongTienSauGiam);
        }else{
            jsonResult.put("tienDuocGiam", 0);
            jsonResult.put("tongTienDonHangSauGiam", 0);
        }


//        System.out.println("Tổng tiền đơn hàng - " + tongTienDonHang);
//        System.out.println("Tiền được giảm - " + tienDuocGiam);
//        System.out.println("Tổng tiền sau giảm - " + tongTienSauGiam);
        return ResponseEntity.ok(jsonResult);
    }

    // api tự động tạo 1 hóa đơn chờ khi ko có hóa đơn chờ nào trong hệ thống
    @PostMapping("/tuDongTao1HoaDonCho")
    public ResponseEntity<?> tuDongTao1HoaDonCho(
            final Model model
            , final HttpServletRequest request
            , final HttpServletResponse response
    ) throws IOException, ParseException {

        // lấy ra idKhachHangLe của Mã khách hàng là khách hàng lẻ
        KhachHang khachHangLe = khachHangService.layThongTinKhachHang_voiSDT("0000000000");

        HoaDon hoaDon_status_waitForPay = new HoaDon();
        hoaDon_status_waitForPay.setTrangThai("0");
        hoaDon_status_waitForPay.setKhachHang(khachHangLe);
        hoaDon_status_waitForPay.setLoaiHoaDon("1");
        hoaDon_status_waitForPay.setNgayMua(Constant.getDateNow());
        hoaDon_status_waitForPay.setNgayTao(Constant.getDateNow());

        HoaDon hoaDonTaoMoi = hoaDonService.themMoi(hoaDon_status_waitForPay);

        Map<String, Object> jsonResult = new HashMap<String, Object>();
        jsonResult.put("code", 200);
        jsonResult.put("status", "Success");
        jsonResult.put("idHoaDon", hoaDonTaoMoi.getId());

        return ResponseEntity.ok(jsonResult);
    }

    // api lấy danh sách khách hàng theo sdt
    @PostMapping("/getListKhachHangBySDT")
    public ResponseEntity<Map<String, Object>> layDanhSachKhachHang_theoSDT(
            final Model model
            , final HttpServletRequest request
            , final HttpServletResponse response
            , @RequestBody MuaHangTaiQuay muaHangTaiQuay
    ) throws IOException {
        List<KhachHang> dsKhachHang = khachHangService.layDanhSachKhachHang_theoSDT(muaHangTaiQuay.getSdt_KhachHang());

        Map<String, Object> jsonResult = new HashMap<String, Object>();
        jsonResult.put("code", 200);
        jsonResult.put("status", "Success");
        jsonResult.put("danhSachKhacHang", dsKhachHang);

        return ResponseEntity.ok(jsonResult);
    }

    // api cập nhật idKhachHang trong hóa đơn chờ
    @PostMapping("/capNhatIdKhachHangTrongHoaDonChoDuocChon")
    public ResponseEntity<?> updateIDCustomerInBillWait(
            final Model model
            , final HttpServletRequest request
            , final HttpServletResponse response
            , @RequestBody MuaHangTaiQuay muaHangTaiQuay
    ) throws IOException {
        // lấy ra thông tin khách hàng
        KhachHang khachHang = khachHangService.chiTietTheoId(muaHangTaiQuay.getIdKhachHangChon());

        HoaDon hoaDonCurrent = hoaDonService.chiTietTheoId(muaHangTaiQuay.getIdHoaDon());
        hoaDonCurrent.setTenKH(khachHang.getHoTen());
        hoaDonCurrent.setSoDT(khachHang.getSoDT());
        hoaDonCurrent.setEmail(khachHang.getEmail());

        hoaDonService.capNhat(hoaDonCurrent);

        hoaDonService.capNhatThongTinHoaDon_laThongTinKhachHang(muaHangTaiQuay.getIdHoaDon(), muaHangTaiQuay.getIdKhachHangChon());

        Map<String, Object> jsonResult = new HashMap<String, Object>();
        jsonResult.put("code", 200);
        jsonResult.put("status", "Success");
        jsonResult.put("khachHangDuocChon", khachHang);

        return ResponseEntity.ok(jsonResult);
    }

    // api xóa sản phẩm khỏi hóa đơn chi tiết
    @PostMapping("/xoaSanPhamKhoiHoaDonChiTiet")
    public ResponseEntity<Map<String, Object>> xoaSanPhamKhoiHoaDonChiTiet(
            final Model model
            , final HttpServletRequest request
            , final HttpServletResponse response
            , @RequestBody MuaHangTaiQuay muaHangTaiQuay
    ) throws IOException {
        ChiTietSanPham chiTietSanPhamCapNhatLaiSoLuong = new ChiTietSanPham();
        chiTietSanPhamCapNhatLaiSoLuong = sanPhamCTService.chiTietTheoId(muaHangTaiQuay.getIdSanPhamCT());
        int soLuongSPKho = chiTietSanPhamCapNhatLaiSoLuong.getSoLuong();
        int soLuongTrongHoaDon = hoaDonCTService.getSoLuongSanPhamTrongHoaDonCT(muaHangTaiQuay.getIdHoaDon(), muaHangTaiQuay.getIdSanPhamCT());
        System.out.println("Số lượng trong kho : " + soLuongSPKho);
        System.out.println("Số lượng trong hóa đơn : " + soLuongTrongHoaDon);

        chiTietSanPhamCapNhatLaiSoLuong.setSoLuong(soLuongSPKho+soLuongTrongHoaDon);
        sanPhamCTService.capNhat(chiTietSanPhamCapNhatLaiSoLuong);

        hoaDonCTService.xoaSanPhamCTKhoiHoaDonChiTiet(muaHangTaiQuay.getIdHoaDon(), muaHangTaiQuay.getIdSanPhamCT());

        // trên đã xóa sản phẩm khỏi hóa đơn chi tiết
        // tính tống tiền hóa đơn hiện tại lại
        // lấy ra KhuyenMai được áp dụng - lấy ra giá trị xét điều kiện để so sánh với tổng tiền
        // nếu ko hợp lệ thì update lại đợt giảm giá và tính lại tổng tiền giảm giá
        List<HoaDonChiTiet> danhSachHoaDonCTTheo_idHoaDon = new ArrayList<>();
        danhSachHoaDonCTTheo_idHoaDon = hoaDonCTService.layDanhSachHoaDonChiTiet_theoIdHoaDon(muaHangTaiQuay.getIdHoaDon());

        Double tongTienHoaDon = 0.0;
        for(HoaDonChiTiet hoaDonCT : danhSachHoaDonCTTheo_idHoaDon){
            tongTienHoaDon+=hoaDonCT.getDonGia()*hoaDonCT.getSoLuong();
        }

        HoaDon hoaDonCurrent = hoaDonService.chiTietTheoId(muaHangTaiQuay.getIdHoaDon());

        if(hoaDonCurrent.getPhieuGiamGia()!=null){
            UUID idPhieuGiamGia = hoaDonCurrent.getPhieuGiamGia().getId();
            PhieuGiamGia phieuGiamGiaCurrent = phieuGiamGiaService.detail(hoaDonCurrent.getPhieuGiamGia().getId());
            Double dieuKienGiamGia = phieuGiamGiaCurrent.getGiaTienXetDieuKien();
            Integer soLuongPhieuGiamGia = phieuGiamGiaCurrent.getSoLuong();
            if(tongTienHoaDon <= dieuKienGiamGia){  // ko còn phù hợp điều kiện để giảm giá nữa
                // set lại idPhieuGiam = null cho hóa đơn hiện tại
                // tính lại tổng tiền giảm => set lại tổng tiền thanh toán= tổng mới , tổng tiền được giảm =0
                hoaDonCurrent.setPhieuGiamGia(null);
                hoaDonCurrent.setTongTienDuocGiamGia(0.0);
                hoaDonCurrent.setTongTienThanhToan(tongTienHoaDon);
                hoaDonService.capNhat(hoaDonCurrent);

                // cập nhật lại voucher đã sử dụng khi chưa thanh toán
                phieuGiamGiaService.capNhatSoLuongMoi_phieuGiamGia(soLuongPhieuGiamGia+1,idPhieuGiamGia);
            }
        }

        Map<String, Object> jsonResult = new HashMap<String, Object>();
        jsonResult.put("code", 200);
        jsonResult.put("status", "Success");
        jsonResult.put("xacNhanXoa", true);

        return ResponseEntity.ok(jsonResult);
    }

    // api xoa hoa don cho va hoa don chi tiet cua hoa don cho
    @PostMapping("/xoaHoaDonCho_vaHoaDonChiTiet")
    public ResponseEntity<Map<String, Object>> xoaHoaDonCho_vaHoaDonChiTiet(
            final Model model
            , final HttpServletRequest request
            , final HttpServletResponse response
            , @RequestBody MuaHangTaiQuay muaHangTaiQuay
    ) throws IOException {
        System.out.println("ID hóa đơn được chọn xóa : " + muaHangTaiQuay.getIdHoaDon());
        HoaDon hoaDonXoa = hoaDonService.chiTietTheoId(muaHangTaiQuay.getIdHoaDon());
        if(hoaDonXoa.getPhieuGiamGia()!=null){
            PhieuGiamGia phieuGiamGia_detail = phieuGiamGiaService.detail(hoaDonXoa.getPhieuGiamGia().getId());
            phieuGiamGiaService.capNhatSoLuongMoi_phieuGiamGia(phieuGiamGia_detail.getSoLuong()+1,phieuGiamGia_detail.getId());
        }

        // lay ra danh sach hoa don chi tiet => lay ra so luong 
        List<HoaDonChiTiet> dsHoaDonChiTiet = new ArrayList<>();
        dsHoaDonChiTiet = hoaDonCTService.layDanhSachHoaDonChiTiet_theoIdHoaDon(muaHangTaiQuay.getIdHoaDon());
        for(HoaDonChiTiet hoaDonChiTiet : dsHoaDonChiTiet){
            // lấy ra san pham chi tiet can cap nhat => set gia tri moi
            ChiTietSanPham chiTietSanPhamCapNhatSoLuong = new ChiTietSanPham();
            chiTietSanPhamCapNhatSoLuong = sanPhamCTService.chiTietTheoId(hoaDonChiTiet.getChiTietSanPham().getId());
            int soLuongKhoCurrent = chiTietSanPhamCapNhatSoLuong.getSoLuong();
            int soLuongTrongHDCT = hoaDonChiTiet.getSoLuong();
            chiTietSanPhamCapNhatSoLuong.setSoLuong(soLuongKhoCurrent+soLuongTrongHDCT);
            sanPhamCTService.capNhat(chiTietSanPhamCapNhatSoLuong);
        }

        // lay ra thong tin san pham chi tiet tuong ung

        // xoa hoa don chi tiet
        hoaDonCTService.xoaHoaDonChiTietBangIDHoaDon(muaHangTaiQuay.getIdHoaDon());
        // xoa hoa don
        hoaDonService.xoaHoaDonBangIdHoaDon(muaHangTaiQuay.getIdHoaDon());

        Map<String, Object> jsonResult = new HashMap<String, Object>();
        jsonResult.put("code", 200);
        jsonResult.put("status", "Success");
        jsonResult.put("xacNhanXoa", true);

        return ResponseEntity.ok(jsonResult);
    }

    @PostMapping("/taoHoaDonThanhToanTaiQuay")
    public ResponseEntity<Map<String, Object>> taoHoaDonThanhToanTaiQuay(
            final Model model
            , final HttpServletRequest request
            , final HttpServletResponse response
            , @RequestBody MuaHangTaiQuay muaHangTaiQuay
    ) throws IOException, ParseException {
        UUID idHoaDon = muaHangTaiQuay.getIdHoaDon();
        // cap nhat trang thai hoa don va hoa don chi tiet
        HoaDon hoaDonCurrent = hoaDonService.chiTietTheoId(idHoaDon);
        hoaDonCurrent.setTrangThai("4");
        hoaDonCurrent.setNgayThanhToan(Constant.getDateNow());
        hoaDonCurrent.setNgayTao(Constant.getDateNowByTime());
        hoaDonCurrent.setNgaySua(Constant.getDateNowByTime());
        hoaDonCurrent.setHinhThucTT("1");

        if(hoaDonCurrent.getKhachHang().getId()!=null){
            KhachHang khachHangCurrent = khachHangService.layKhachHangTheoId(hoaDonCurrent.getKhachHang().getId());
            hoaDonCurrent.setKhachHang(khachHangCurrent);
            hoaDonCurrent.setTenKH(khachHangCurrent.getHoTen());
            hoaDonCurrent.setSoDT(khachHangCurrent.getSoDT());
            hoaDonCurrent.setEmail(khachHangCurrent.getEmail());
            hoaDonCurrent.setMa("HD-" + getRandomNumber(10, 100));
        }
        hoaDonService.capNhat(hoaDonCurrent);
        List<HoaDonChiTiet> dsHoaDonChiTietCuaHoaDonHienTai = new ArrayList<>();
        dsHoaDonChiTietCuaHoaDonHienTai = hoaDonCTService.layDanhSachHoaDonChiTiet_theoIdHoaDon(idHoaDon);
        for(HoaDonChiTiet hoaDonChiTiet : dsHoaDonChiTietCuaHoaDonHienTai){
            hoaDonChiTiet.setTrangThai(4);
            hoaDonCTService.capNhat(hoaDonChiTiet);
        }

//        if(hoaDonCurrent.getPhieuGiamGia()!=null){
//            // cap nhat so luong voucher áp dụng
//            PhieuGiamGia phieuGiamGia = phieuGiamGiaService.detail(hoaDonCurrent.getPhieuGiamGia().getId());
//            phieuGiamGia.setSoLuong(phieuGiamGia.getSoLuong()-1);
//
//            phieuGiamGiaService.capNhat(phieuGiamGia);
//        }

        // cập nhật số lượng trong kho khi mua tại quầy ngay khi thanh toán
        for (HoaDonChiTiet sanPhamChiTietTrongHoaDon : dsHoaDonChiTietCuaHoaDonHienTai) {
            // cập nhật số lượng sản phẩm trong DB
            sanPhamCTService.capNhatSoLuongSauKhiDatHang(sanPhamChiTietTrongHoaDon.getSoLuong(), sanPhamChiTietTrongHoaDon.getChiTietSanPham().getId());
        }

        Map<String, Object> jsonResult = new HashMap<String, Object>();
        jsonResult.put("code", 200);
        jsonResult.put("status", "Success");

        return ResponseEntity.ok(jsonResult);
    }


    @PostMapping("/capNhatSoLuongMuaTaiQuay")
    public ResponseEntity<Map<String, Object>> capNhatSoLuongMuaTaiQuay(
            final Model model
            , final HttpServletRequest request
            , final HttpServletResponse response
            , @RequestBody MuaHangTaiQuay muaHangTaiQuay
    ) throws IOException, ParseException {
        UUID idHoaDon = muaHangTaiQuay.getIdHoaDon();
        UUID idSanPhamCT = muaHangTaiQuay.getIdSanPhamCT();
        Integer soLuongCapNhat = muaHangTaiQuay.getSoLuong_sanPhamMua();

        System.out.println(">>>>> capNhatSoLuongMuaTaiQuay");
        System.out.println("id hoa don : " + idHoaDon);
        System.out.println("id san pham ct : " + idSanPhamCT);

//        hoaDonCTService.capNhatSoLuongSanPhamMua_HDCT_taiQuay(idHoaDon,idSanPhamCT,soLuongCapNhat);
        HoaDonChiTiet hoaDonChiTiet = hoaDonCTService.xemHoaDonChiTiet_detail(idHoaDon, idSanPhamCT);
        // sl mua cu
        // sl mua moi
        // sl hoàn lại về kho = sl mua moi - sl mua cu
        int soLuongMuaCu = hoaDonChiTiet.getSoLuong();
        int soLuongKhoUpdate_spct = 0;
        // neu sl mua moi > sl mua cu => cập nhật sl trong hóa đơn, trừ đi sản phẩm trong kho
        // sl mua moi < sl mua cu => cập nhật sl trong hóa đơn, cộng lại số lượng bị giảm đi
        ChiTietSanPham chiTietSanPhamCapNhat = sanPhamCTService.chiTietTheoId(idSanPhamCT);
        int soLuongTrongKho = chiTietSanPhamCapNhat.getSoLuong();

        if(soLuongCapNhat>soLuongMuaCu){
            soLuongKhoUpdate_spct = soLuongTrongKho - (soLuongCapNhat-soLuongMuaCu);  // số lượng còn lại trong kho
//            System.out.println("chạy trường hợp soLuongCapNhat > soLuongMuaCu ");
//            System.out.println("Số lượng cập nhật : " + soLuongCapNhat);
//            System.out.println("Số lượng trong kho : " + soLuongTrongKho);
//            System.out.println("Số lượng kho update : " + soLuongKhoUpdate_spct);
        }else{
            soLuongKhoUpdate_spct = soLuongTrongKho + (soLuongMuaCu-soLuongCapNhat);  // so luong con lai trong kho
//            System.out.println("chạy trường hợp soLuongCapNhat < soLuongMuaCu ");
//            System.out.println("Số lượng cập nhật : " + soLuongCapNhat);
//            System.out.println("Số lượng trong kho : " + soLuongTrongKho);
//            System.out.println("Số lượng kho update : " + soLuongKhoUpdate_spct);
        }

        chiTietSanPhamCapNhat.setSoLuong(soLuongKhoUpdate_spct);
        sanPhamCTService.capNhat(chiTietSanPhamCapNhat);  // cap nhat so luong san pham trong kho

        ChiTietSanPham chiTietSanPham = sanPhamCTService.chiTietTheoId(idSanPhamCT);
        hoaDonChiTiet.setSoLuong(soLuongCapNhat);
        Double giaMua=0.0;
        if ( chiTietSanPham.getGiaTriGiam() == null || chiTietSanPham.getGiaTriGiam() ==0) {
            giaMua = chiTietSanPham.getGiaTriSanPham()*soLuongCapNhat;
        } else {
            giaMua = chiTietSanPham.getGiaTriGiam()*soLuongCapNhat;
        }
        hoaDonChiTiet.setDonGia(giaMua);
        hoaDonCTService.capNhat(hoaDonChiTiet);

        // kiểm tra lại tổng hóa đơn có còn phù hợp với phiếu giảm giá được chọn hay không ?
        List<HoaDonChiTiet> danhSachHoaDonCTTheo_idHoaDon = new ArrayList<>();
        danhSachHoaDonCTTheo_idHoaDon = hoaDonCTService.layDanhSachHoaDonChiTiet_theoIdHoaDon(muaHangTaiQuay.getIdHoaDon());

        Double tongTienHoaDon = 0.0;
        for(HoaDonChiTiet hoaDonCT : danhSachHoaDonCTTheo_idHoaDon){
            tongTienHoaDon+=hoaDonCT.getDonGia()*hoaDonCT.getSoLuong();
        }

        HoaDon hoaDonCurrent = hoaDonService.chiTietTheoId(muaHangTaiQuay.getIdHoaDon());
        if(hoaDonCurrent.getPhieuGiamGia()!=null){
            PhieuGiamGia phieuGiamGiaCurrent = phieuGiamGiaService.detail(hoaDonCurrent.getPhieuGiamGia().getId());
            Double dieuKienGiamGia = phieuGiamGiaCurrent.getGiaTienXetDieuKien();
            Integer soLuongPhieuGiamGia = phieuGiamGiaCurrent.getSoLuong();
            if(tongTienHoaDon <= dieuKienGiamGia){  // ko còn phù hợp điều kiện để giảm giá nữa
                // set lại idPhieuGiam = null cho hóa đơn hiện tại
                // tính lại tổng tiền giảm => set lại tổng tiền thanh toán= tổng mới , tổng tiền được giảm =0
                hoaDonCurrent.setPhieuGiamGia(null);
                hoaDonCurrent.setTongTienDuocGiamGia(0.0);
                hoaDonCurrent.setTongTienThanhToan(tongTienHoaDon);
                hoaDonService.capNhat(hoaDonCurrent);

                // cập nhật lại voucher đã sử dụng khi chưa thanh toán
                phieuGiamGiaService.capNhatSoLuongMoi_phieuGiamGia(soLuongPhieuGiamGia+1,phieuGiamGiaCurrent.getId());
            }
        }



        Map<String, Object> jsonResult = new HashMap<String, Object>();
        jsonResult.put("code", 200);
        jsonResult.put("status", "Success");

        return ResponseEntity.ok(jsonResult);
    }
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}