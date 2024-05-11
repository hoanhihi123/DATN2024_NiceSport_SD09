package com.example.duantn.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HoaDonRequest {
    private UUID id;

    @NotBlank(message = "{hoaDon.datHang.hoVaTen.notblank}")
    private String hoVaTen;

    @NotBlank(message = "{hoaDon.datHang.soDT.notblank}")
    private String soDT;

    @NotBlank(message = "{hoaDon.datHang.email.notblank}")
    private String email;

    @NotBlank(message = "{hoaDon.datHang.diaChi.notblank}")
    private String diaChi;

    @NotBlank(message = "{hoaDon.datHang.tinh_thanhPho.notblank}")
    private String tinh_thanhPho;

    @NotBlank(message = "{hoaDon.datHang.quan_huyen.notblank}")
    private String quan_huyen;

    private String phuong_xa;

    private String ghiChu;

    private Double tongTienDonHang;
    private Double phiShip;

    private String hinhThucThanhToan;
}
