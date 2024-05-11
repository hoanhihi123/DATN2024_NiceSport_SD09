package com.example.duantn.controller.admin;

import com.example.duantn.model.ChiTietSanPham;
import com.example.duantn.model.SanPham;
import com.example.duantn.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/ql-san-pham")   // /api/ban-hang/getDanhSachSanPham
public class QLSanPhamRestController {
    @Autowired
    SanPhamServiceImpl sanPhamService;

    @Autowired
    ThuongHieuServiceImpl thuongHieuService;

    @Autowired
    NSXServiceImpl nsxService;

    @Autowired
    DanhMucServiceImpl danhMucService;

    @Autowired
    LoaiSanPhamServiceImpl loaiSanPhamService;

    @Autowired
    KieuDangServiceImpl kieuDangService;

    @Autowired
    ChatLieuServiceImpl chatLieuService;

    @Autowired
    MuiGiayServiceImpl muiGiayService;

    @Autowired
    DayGiayServiceImpl dayGiayService;

    @Autowired
    DeGiayServiceImpl deGiayService;

    @Autowired
    LotGiayServiceImpl lotGiayService;

    @Autowired
    MauSacServiceImpl mauSacService;

    @Autowired
    KichCoServiceImpl kichCoService;

    @Autowired
    ChiTietSPServiceImpl chiTietSPService;

    @GetMapping("/getDanhSachSanPhamCT_TheoSoLuong")
    public ResponseEntity<?> getDanhSachSanPhamCT_TheoSoLuong(
    ){
        List<ChiTietSanPham> dsSanPhamCT = chiTietSPService.layDanhSach();
        // Danh sách sản phẩm chi tiết
        List<Map<String, Object>> danhSachSanPhamChiTiet = new ArrayList<>();
        for(ChiTietSanPham chiTietSanPham : dsSanPhamCT){
            danhSachSanPhamChiTiet.add(Map.of("idSanPham", chiTietSanPham.getSanPham().getId(), "tenSanPham",chiTietSanPham.getSanPham().getTen(), "soLuong", chiTietSanPham.getSoLuong(),"trangThai",chiTietSanPham.getSanPham().getTrangThai()));
        }

        // Tạo một map để lưu tổng số lượng sản phẩm tương ứng với mỗi idSanPham
        Map<UUID, Integer> tongSoLuong = new HashMap<>();

        // Tính tổng số lượng sản phẩm tương ứng với mỗi idSanPham
        for (Map<String, Object> sanPhamCT : danhSachSanPhamChiTiet) {
            UUID idSanPham = (UUID) sanPhamCT.get("idSanPham");
            Integer soLuong = (Integer) sanPhamCT.get("soLuong");

            // Kiểm tra xem idSanPham đã tồn tại trong Map chưa
            if (tongSoLuong.containsKey(idSanPham)) {
                // Nếu đã tồn tại, cộng số lượng sản phẩm mới vào tổng
                Integer tongSoLuongHienTai = (Integer) tongSoLuong.get(idSanPham);
                tongSoLuong.put(idSanPham, tongSoLuongHienTai + soLuong);
            } else {
                // Nếu chưa tồn tại, đặt giá trị mặc định là 0 và thêm vào Map
                tongSoLuong.put(idSanPham, soLuong);
            }
        }

        // Tạo danh sách mới từ map
        List<Map<String, Object>> danhSachMoi = new ArrayList<>();
        for (Map.Entry<UUID, Integer> entry : tongSoLuong.entrySet()) {
            Map<String, Object> sanPhamMoi = new HashMap<>();
            sanPhamMoi.put("idSanPham", entry.getKey());
            sanPhamMoi.put("tongSoLuong", (Integer) entry.getValue()); // Ép kiểu thành Integer
            danhSachMoi.add(sanPhamMoi);
        }

        List<Map<String, Object>> newProductList = new ArrayList<>();
        for (Map<String, Object> sanPhamMoi : danhSachMoi) {
            UUID idSanPham = (UUID) sanPhamMoi.get("idSanPham");
            int tongSL = (Integer) sanPhamMoi.get("tongSoLuong");

            List<SanPham> danhSachSanPham = sanPhamService.layDanhSach();
            // Tìm kiếm trong danh sách sản phẩm chi tiết
            for (SanPham sanPham : danhSachSanPham) {
                UUID idSanPhamChiTiet = sanPham.getId();
                if (idSanPham.equals(idSanPhamChiTiet)) {
                    // Tìm thấy sản phẩm, lấy thông tin và thêm vào sản phẩm mới
                    Map<String, Object> newProduct = new HashMap<>(sanPhamMoi); // Sao chép dữ liệu từ sanPhamMoi
                    newProduct.put("tenSanPham", sanPham.getTen());
                    newProduct.put("trangThai", sanPham.getTrangThai());
                    newProduct.put("tongSoLuong",tongSL);
                    newProduct.put("idSanPham",idSanPham);
                    newProductList.add(newProduct);
                    break; // Thoát khỏi vòng lặp sau khi thêm sản phẩm mới
                }
            }
        }

        // In ra danh sách mới
//        System.out.println("Danh sách mới sau khi tính tổng số lượng sản phẩm tương ứng với mỗi idSanPham:");
//        // In ra danh sách mới
//        System.out.println("Danh sách mới sau khi thêm thông tin sản phẩm:");
//        for (Map<String, Object> product : newProductList) {
//            System.out.println("ID sản phẩm: " + product.get("idSanPham"));
//            System.out.println("Tên sản phẩm: " + product.get("tenSanPham"));
//            System.out.println("Trạng thái: " + product.get("trangThai"));
//            System.out.println("Tổng số lượng: " + product.get("tongSoLuong"));
//            System.out.println("----------------------------------");
//        }

        return ResponseEntity.of(Optional.ofNullable(newProductList));
    }

    @GetMapping("/getDanhSachSanPham")
    public ResponseEntity<?> layDanhSachSanPham(
    ){
        return ResponseEntity.of(Optional.ofNullable(sanPhamService.layDanhSach()));
    }

    @GetMapping("/getDanhSachThuongHieu")
    public ResponseEntity<?> layDanhSachThuongHieu(
    ){
        return ResponseEntity.of(Optional.ofNullable(thuongHieuService.layDanhSach()));
    }

    @GetMapping("/getDanhSachNSX")
    public ResponseEntity<?> layDanhSachNSX(
    ){
        return ResponseEntity.of(Optional.ofNullable(nsxService.layDanhSach()));
    }

    @GetMapping("/getDanhSachDanhMuc")
    public ResponseEntity<?> layDanhSachDanhMuc(
    ){
        return ResponseEntity.of(Optional.ofNullable(danhMucService.layDanhSach()));
    }

    @GetMapping("/getDanhSachLoaiSanPham")
    public ResponseEntity<?> layDanhSachLoaiSanPham(
    ){
        return ResponseEntity.of(Optional.ofNullable(loaiSanPhamService.layDanhSach()));
    }

    @GetMapping("/getDanhSachKieuDang")
    public ResponseEntity<?> layDanhSachKieuDang(
    ){
        return ResponseEntity.of(Optional.ofNullable(kieuDangService.layDanhSach()));
    }

    @GetMapping("/getDanhSachChatLieu")
    public ResponseEntity<?> layDanhSachChatLieu(
    ){
        return ResponseEntity.of(Optional.ofNullable(chatLieuService.layDanhSach()));
    }

    @GetMapping("/getDanhSachMuiGiay")
    public ResponseEntity<?> layDanhSachMuiGiay(
    ){
        return ResponseEntity.of(Optional.ofNullable(muiGiayService.layDanhSach()));
    }

    @GetMapping("/getDanhSachDayGiay")
    public ResponseEntity<?> layDanhSachDayGiay(
    ){
        return ResponseEntity.of(Optional.ofNullable(dayGiayService.layDanhSach()));
    }

    @GetMapping("/getDanhSachDeGiay")
    public ResponseEntity<?> layDanhSachDeGiay(
    ){
        return ResponseEntity.of(Optional.ofNullable(deGiayService.layDanhSach()));
    }

    @GetMapping("/getDanhSachLotGiay")
    public ResponseEntity<?> layDanhSachLotGiay(
    ){
        return ResponseEntity.of(Optional.ofNullable(lotGiayService.layDanhSach()));
    }
    @GetMapping("/getDanhSachMauSac")
    public ResponseEntity<?> layDanhSachMauSac (
    ){
        return ResponseEntity.of(Optional.ofNullable(mauSacService.layDanhSach()));
    }

    @GetMapping("/getDanhSachSizeGiay")
    public ResponseEntity<?> layDanhSachSizeGiay(
    ){
        return ResponseEntity.of(Optional.ofNullable(kichCoService.layDanhSach()));
    }




}
