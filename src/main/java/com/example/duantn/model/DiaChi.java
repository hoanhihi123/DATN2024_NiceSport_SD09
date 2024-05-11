package com.example.duantn.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "DiaChi")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DiaChi extends BaseModel {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdKhachHang", referencedColumnName = "Id")
    private KhachHang khachHang;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "TenDiaChi")
    private String ten;
    @Column(name = "MoTaCT")
    private String moTa;
    @Column(name = "TinhThanhPho")
    private String thanhPho;
    @Column(name = "QuanHuyen")
    private String huyen;
    @Column(name = "PhuongXa")
    private String xa;

}
