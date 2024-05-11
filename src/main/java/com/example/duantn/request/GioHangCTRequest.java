//package com.example.duantn.request;
//
//import com.example.duantn.Model.GioHang;
//import com.example.duantn.Model.SanPhamCT;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.UUID;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class GioHangCTRequest {
//    private UUID id;
//    @NotBlank(message = "{giohangchitiet.ma.notblank}")
//    private String ma;
//    @NotBlank(message = "{giohangchitiet.ten.notblank}")
//    @Size(min = 1, max = 30, message = "{giohangchitiet.ten.size}")
//    private String ten;
//
//    @NotNull(message = "{giohangchitiet.magiohang.notnull}")
//    private GioHang gioHang;
//
//    @NotNull(message = "{giohangchitiet.maSPCT.notnull}")
//    private SanPhamCT sanPhamCT;
//
//    @NotBlank(message = "{giohangchitiet.trangThai.notblank}")
//    private String trangThai;
//    private String donGia;
//    private String soLuong;
//}
