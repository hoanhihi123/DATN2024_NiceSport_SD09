package com.example.duantn.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietSanPham_theoSanPham_soLuong {
    private UUID idSanPham;
    private String tenSanPham;
    private Integer soLuong;
    private String tenDanhMuc;
    private String tenThuongHieu;
    private Integer trangThaiSanPham;
}
