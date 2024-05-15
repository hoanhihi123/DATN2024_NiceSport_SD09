package com.example.duantn.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "HoaDonCT")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class HoaDonChiTiet extends BaseModel {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdHoaDon",referencedColumnName = "Id")
    private HoaDon hoaDon;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdSanPhamCT",referencedColumnName = "Id")
    private ChiTietSanPham chiTietSanPham;

//    @Column(name = "MaHoaDonCT")
//    private String maHoaDonCT;

    @Column(name = "DonGia")
    private Double donGia;

    @Column(name = "giaGoc")
    private Double giaGocSP;

    @Column(name = "giaGiam")
    private Double giaSauGiam;

    @Column(name = "SoLuong")
    private Integer soLuong;


}