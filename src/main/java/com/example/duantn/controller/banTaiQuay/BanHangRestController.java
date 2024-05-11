package com.example.duantn.controller.banTaiQuay;

import com.example.duantn.dto.Constant;
import com.example.duantn.model.*;
import com.example.duantn.request.MuaHangTaiQuay;
import com.example.duantn.request.PhanTrangRequest;
import com.example.duantn.request.SanPhamTaiQuay;
import com.example.duantn.service.impl.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

@RestController
@RequestMapping("/api/ban-hang")   // /api/ban-hang/getDanhSachSanPham
public class BanHangRestController {

//    @Autowired
//    SupportService supportService;

    @Autowired
    ChiTietSPServiceImpl sanPhamCTService;


    @Autowired
    KhachHangServiceImpl khachHangService;

    @Autowired
    PhieuGiamGiaServiceImpl phieuGiamGiaService;

    @Autowired
    HoaDonServiceImpl hoaDonService;

    @Autowired
    HoaDonCTServiceImpl hoaDonCTService;

    @Autowired
    SanPhamServiceImpl sanPhamService;

    @Autowired
    MauSacServiceImpl mauSacService;

    @Autowired
    KichCoServiceImpl kichCoService;

    @Autowired
    LoaiSanPhamServiceImpl loaiSanPhamService;

    /**
     *
     * @param model
     * @return
     */
    // api lấy ra danh sách các sản phẩm chi tiết
    @GetMapping("/getDanhSachSanPham")
    public ResponseEntity<?> getListProductDetail(
            Model model
    ){
        return ResponseEntity.of(Optional.ofNullable(sanPhamCTService.layDanhSach()));
    }

    // api lấy ra danh sách khách hàng
    @GetMapping("/getDanhSachKhachHang")
    public ResponseEntity<?> getListCustomer(
            Model model
    ){
        return ResponseEntity.of(Optional.ofNullable(khachHangService.layDanhSach()));
    }

    // api lấy ra danh sách phieu giảm giá
    @PostMapping("/getDanhSachPhieuGiamGia")
    public ResponseEntity<?> getListDiscount(
            Model model ,
            @RequestBody MuaHangTaiQuay muaHangTaiQuay
    ){

        // lay danh sach phieu giam gia
        List<PhieuGiamGia> dsPhieuGiamGia = phieuGiamGiaService.layDanhSach_voiTongTienDonHang(muaHangTaiQuay.getTongTienDonHang());
        System.out.println("Kết quả dsPhieuGiamGia: " + dsPhieuGiamGia.size());

        Double tongTienDonHang = muaHangTaiQuay.getTongTienDonHang();
        System.out.println("Tổng tiền đơn hàng - getDanhSachPhieuGiamGia: " + tongTienDonHang);

        int count = 0;
        List<PhieuGiamGia> dsPhieuGiamGiaHopLe = new ArrayList<>();
        if(tongTienDonHang!=null){
            for(PhieuGiamGia phieuGiamGia : dsPhieuGiamGia){
                if(tongTienDonHang >= phieuGiamGia.getGiaTienXetDieuKien()){
                    count++;
                    dsPhieuGiamGiaHopLe.add(phieuGiamGia);
                }
            }
        }
        System.out.println("ds phiếu giảm giá hợp lệ - getDanhSachPhieuGiamGia : " + dsPhieuGiamGiaHopLe.size());
        System.out.println("Count - getDanhSachPhieuGiamGia : " + count);

        return ResponseEntity.of(Optional.ofNullable(dsPhieuGiamGiaHopLe));
    }

    // api lấy ra danh sách hoa don cho
    @PostMapping("/getDanhSachHoaDonCho_theoIDHoaDonActive")
    public ResponseEntity<?> getDanhSachHoaDonChiTiet(
            Model model,
            @RequestBody PhanTrangRequest phanTrangRequest
            ){
         return ResponseEntity.of(Optional.ofNullable(hoaDonCTService.layDanhSachHoaDonChiTiet_theoIdHoaDon(phanTrangRequest.getIdHoaDon())));
    }

    // api lấy ra danh sách phieu giảm giá
    @GetMapping("/getDanhSachHoaDonTheoTrangThai_hoaDonCho")
    public ResponseEntity<?> getListBill_byStatus(
            Model model
    ){
        return ResponseEntity.of(Optional.ofNullable(hoaDonService.layDanhSachHoaDon_theoTrangThai(0)));
    }

    @PostMapping("/kiemTraSoLuongMuaBiVuotQuaKhong")
    public ResponseEntity<Map<String, Object>> kiemTraSoLuongMuaVuotQuaTrongKho(
            final Model model
            , final HttpServletRequest request
            , final HttpServletResponse response
            , @RequestBody MuaHangTaiQuay muaHangTaiQuay
    ) throws IOException {
        UUID idSanPhamChiTiet = muaHangTaiQuay.getIdSanPhamCT();
        UUID idHoaDon = muaHangTaiQuay.getIdHoaDon();
        Integer soLuongMua = muaHangTaiQuay.getSoLuong_sanPhamMua();
//        System.out.println("Chạy vào hàm kiểm tra số lượng mua có bị vượt quá trong kho hay không ?");
//        System.out.println("ID sản phẩm chi tiết " + idSanPhamChiTiet);
//        System.out.println("ID hóa đơn " + idHoaDon);
//        System.out.println("Số lượng mua " + soLuongMua);

        Integer soLuongSanPhamKho = sanPhamCTService.laySoLuongTrongKho(idSanPhamChiTiet);
        Integer soLuongSanPhamDaChonTrongHoaDon = hoaDonCTService.getSoLuongSanPhamTrongHoaDonCT(idHoaDon, idSanPhamChiTiet);
//        System.out.println("Số lượng khoa " + soLuongSanPhamKho);
//        System.out.println("Số lượng đã chọn vào hóa dơn chi tiết " + soLuongSanPhamDaChonTrongHoaDon);

        Boolean checkSoLuongHoaDon = true;
        if(muaHangTaiQuay.getSoLuong_sanPhamMua()==0){
            checkSoLuongHoaDon = false;
        }
        if(soLuongSanPhamDaChonTrongHoaDon==null){  // = null có nghĩa là ko có sản phẩm nào trong hóa đơn chi tiết
            if(soLuongMua > soLuongSanPhamKho){
                checkSoLuongHoaDon = false;
            }
        }else {
            if((soLuongMua + soLuongSanPhamDaChonTrongHoaDon) > soLuongSanPhamKho){
                checkSoLuongHoaDon = false;
            }
        }


        Map<String, Object> jsonResult = new HashMap<String, Object>();
        jsonResult.put("code", 200);
        jsonResult.put("status", "Success");
        jsonResult.put("ketQuaKiemTraSL_muaHopLe",checkSoLuongHoaDon);

        Integer soLuongDaChonVaoHoaDon = soLuongSanPhamDaChonTrongHoaDon==null?0:soLuongSanPhamDaChonTrongHoaDon;
        Integer soLuongCoTheThemVaoHoaDon = (soLuongSanPhamKho-soLuongMua)<0?soLuongSanPhamKho:soLuongMua;
        System.out.println("Số lượng đã chọn vào hóa đơn : " + soLuongDaChonVaoHoaDon);
        System.out.println("Số lượng có thể thêm vào hóa đơn : " + soLuongCoTheThemVaoHoaDon);

        jsonResult.put("soLuongDaChonVaoHoaDon", soLuongDaChonVaoHoaDon);
        jsonResult.put("soLuongCoTheThemVaoHoaDon", soLuongCoTheThemVaoHoaDon);
        jsonResult.put("soLuongMuaVaoHoaDon", muaHangTaiQuay.getSoLuong_sanPhamMua());
        jsonResult.put("soLuongConTrongKho", soLuongSanPhamKho);

        return ResponseEntity.ok(jsonResult);
    }

    @PostMapping("/themSanPhamVaoHoaDonChiTiet")
    public ResponseEntity<Map<String, Object>> themSanPhamVaoHoaDonChiTiet(
            final Model model
            , final HttpServletRequest request
            , final HttpServletResponse response
            , @RequestBody MuaHangTaiQuay muaHangTaiQuay
    ) throws IOException, ParseException {
        UUID idSanPhamChiTiet = muaHangTaiQuay.getIdSanPhamCT();
        UUID idHoaDon = muaHangTaiQuay.getIdHoaDon();
        Integer soLuongMua = muaHangTaiQuay.getSoLuong_sanPhamMua();

        Integer soLuongSanPhamDaChonTrongHoaDon = hoaDonCTService.getSoLuongSanPhamTrongHoaDonCT(idHoaDon, idSanPhamChiTiet);

        // lam sao de cap nhat so luong san pham trong kho , sau khi them vao hoaDonChiTiet ?
        // só lượng thêm vào hóa đơn ( có 2 trường hợp : trường hợp chưa có hóa đơn nào, trường hợp có hóa đơn )
        // số lượng trong kho
        // số lượng

        boolean checkThemSanPhamVaoHDCT = false;
        // kiểm tra xem co san pham trong hoa don ko
        if(soLuongSanPhamDaChonTrongHoaDon!=null && soLuongSanPhamDaChonTrongHoaDon>0){
//            System.out.println("Sản phẩm này đã được thêm vào hóa đơn chi tiết trước đó rồi " +
//                    "\n cập nhật số lượng sản phẩm");
            // viết 1 service xử lý việc cập nhật số lượng
             hoaDonCTService.capNhatSoLuongSanPhamMua_HDCT(idHoaDon, idSanPhamChiTiet, soLuongMua);

             // cập nhật số lượng sản phẩm chi tiết đồng thời
            ChiTietSanPham chiTietSanPhamCapNhat = sanPhamCTService.chiTietTheoId(idSanPhamChiTiet);
            int soLuongKho = chiTietSanPhamCapNhat.getSoLuong();
            int soLuongSauMua = soLuongKho - soLuongMua;
            chiTietSanPhamCapNhat.setSoLuong(soLuongSauMua);
            sanPhamCTService.capNhat(chiTietSanPhamCapNhat);

                checkThemSanPhamVaoHDCT = true;
//                System.out.println("Chạy xong  hàm cập nhật số lượng ");
        }else {
//            System.out.println("Chạy vào hàm thêm mới sản phẩm chi tiết  ");
            // ngược lại thêm sản phẩm vào hóa đơn chi tiết
            // viết 1 service thêm sản phẩm vào hóa đơn chi tiết
            // thêm sản phẩm vào hóa đơn chi tiết như thế nào ???
            HoaDonChiTiet hoaDonChiTietMoi = new HoaDonChiTiet();
            HoaDon hoaDonThem = new HoaDon();
            hoaDonThem = hoaDonService.chiTietTheoId(idHoaDon);
            hoaDonChiTietMoi.setHoaDon(hoaDonThem);

            ChiTietSanPham sanPhamChiTietThem = sanPhamCTService.chiTietTheoId(idSanPhamChiTiet);
            hoaDonChiTietMoi.setChiTietSanPham(sanPhamChiTietThem);

            hoaDonChiTietMoi.setSoLuong(soLuongMua);
//            Double thanhTien = sanPhamChiTietThem.getGiaTriGiam()>0?(soLuongMua * ) : (soLuongMua * );
            Double thanhTien;
            Double giaTriGiam = sanPhamChiTietThem.getGiaTriGiam();
            Double giaTriSanPham = sanPhamChiTietThem.getGiaTriSanPham();

            if (giaTriGiam ==null || giaTriGiam<=0) {
                thanhTien = giaTriSanPham*soLuongMua;
            } else {
                thanhTien = giaTriGiam*soLuongMua;
            }
            System.out.println("Thành tiền : " + thanhTien);

            hoaDonChiTietMoi.setDonGia(thanhTien);
            hoaDonChiTietMoi.setNgayTao(Constant.getDateNow());
            hoaDonChiTietMoi.setTrangThai(0);

            HoaDonChiTiet ketQuaThemHoaDonChiTiet =  hoaDonCTService.themMoi2(hoaDonChiTietMoi);
            ChiTietSanPham chiTietSanPhamCapNhat = sanPhamCTService.chiTietTheoId(idSanPhamChiTiet);
            int soLuongKho = chiTietSanPhamCapNhat.getSoLuong();
            int soLuongSauMua = soLuongKho - soLuongMua;
            chiTietSanPhamCapNhat.setSoLuong(soLuongSauMua);
            sanPhamCTService.capNhat(chiTietSanPhamCapNhat);

            if(ketQuaThemHoaDonChiTiet!=null){
                checkThemSanPhamVaoHDCT = true;
            }
        }

        Map<String, Object> jsonResult = new HashMap<String, Object>();
        jsonResult.put("code", 200);
        jsonResult.put("status", "Success");
        jsonResult.put("ketQuaThemSPVaoHoaDonCT", checkThemSanPhamVaoHDCT);

//        jsonResult.put("ketQuaSauThemHoaDonCT",checkSoLuongHoaDon);

        return ResponseEntity.ok(jsonResult);
    }

    @PostMapping("/layDanhSachHoaDon_theoIDHoaDon")
    public ResponseEntity<Map<String, Object>> layDanhSachHoaDonChiTietTheoIDHoaDon(
            final Model model
            , final HttpServletRequest request
            , final HttpServletResponse response
            , @RequestBody MuaHangTaiQuay muaHangTaiQuay
    ) throws IOException {
        List<HoaDonChiTiet> dsHoaDonChiTiet = hoaDonCTService.layDanhSachHoaDonChiTiet_theoIdHoaDon(muaHangTaiQuay.getIdHoaDon());
//        System.out.println("Số lượng hóa đơn chi tiết lấy được " + dsHoaDonChiTiet.size());

        Map<String, Object> jsonResult = new HashMap<String, Object>();
        jsonResult.put("code", 200);
        jsonResult.put("status", "Success");
        jsonResult.put("dsHoaDonChiTiet",dsHoaDonChiTiet);

        return ResponseEntity.ok(jsonResult);
    }

    @PostMapping("/getIdDotKhuyenMaiApDung")
    public ResponseEntity<?> getIdDotKhuyenMaiApDung(
             @RequestBody MuaHangTaiQuay muaHangTaiQuay
    ){
        UUID idHoaDonActive = muaHangTaiQuay.getIdHoaDon();
        System.out.println("Id hóa đơn active : " + idHoaDonActive);

        HoaDon hoaDonDetail = hoaDonService.chiTietTheoId(idHoaDonActive);

        if(hoaDonDetail.getPhieuGiamGia()==null){
            return ResponseEntity.ok().body(null);
        }

//        System.out.println("Hoa don detail :  " + hoaDonDetail.getPhieuGiamGia().getId());
        PhieuGiamGia phieuGiamGiaDetail = phieuGiamGiaService.detail(hoaDonDetail.getPhieuGiamGia().getId());
        String maGiamGia = phieuGiamGiaDetail.getMa();
//        System.out.println("Hóa đơn ấp dụng mã giảm giá : " + maGiamGia);

        return ResponseEntity.ok().body(maGiamGia);
    }

    @PostMapping("/timKiemSanPhamTaiQuay")
    public ResponseEntity<?> timKiemSanPhamTaiQuay(
            final Model model
            , @RequestBody SanPhamTaiQuay sanPhamTaiQuay
    ) throws IOException, ParseException {
        // idKichCo, idLoaiSP, idMauSac, tenSP
        UUID idKichCo = sanPhamTaiQuay.getIdKichCo();
        UUID idLoaiSP = sanPhamTaiQuay.getIdLoaiSP();
        UUID idMauSac = sanPhamTaiQuay.getIdMauSac();
        String tenSanPham = sanPhamTaiQuay.getTenSP();


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

        List<ChiTietSanPham> chiTietSanPhams = sanPhamCTService.danhSachSanPhamTimKiem(keyWork);

        System.out.println("Kết quả trả về tìm kiếm : " + chiTietSanPhams.size());
        return ResponseEntity.of(Optional.ofNullable(chiTietSanPhams));
    }

//    @GetMapping("/print/{code}")
//    public ResponseEntity<?> printInvoice(@PathVariable("code") String billCode) throws Exception {
//        byte[] pdfBytes  = supportService.PrintInvoice(billCode);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_PDF);
//        headers.setContentType(MediaType.APPLICATION_PDF);
////        headers.setContentDispositionFormData("attachment", billCode+".pdf");
//        headers.setContentDispositionFormData("inline", billCode + ".pdf");
////        headers.setContentDisposition(ContentDisposition.inline().filename(billCode + ".pdf").build());
////        headers.add("Content-Disposition", "inline; filename=" + fileName);
//
//        return ResponseEntity.ok()
//                .headers(headers)
//                .body(new ByteArrayResource(pdfBytes));
//
//    }

}
