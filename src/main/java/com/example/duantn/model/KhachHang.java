package com.example.duantn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "KhachHang")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class KhachHang extends BaseModel {
    @Column(name = "Ma")
    private String ma;
    @Column(name = "HoTen")
    private String hoTen;
    @Column(name = "TaiKhoan")
    private String taiKhoan;

    @Column(name = "MatKhau")
    private String matKhau;

    @Column(name = "GioiTinh")
    private Integer gioiTinh;

    @Column(name = "SoDT")
    private String soDT;

    @Column(name = "Email")
    private String email;

}
