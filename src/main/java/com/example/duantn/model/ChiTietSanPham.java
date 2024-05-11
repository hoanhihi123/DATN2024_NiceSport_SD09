package com.example.duantn.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Table(name = "SanPhamCT")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChiTietSanPham extends BaseModel{

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Id_NSX")
    private NSX nsx;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_loaiSP")
    private LoaiSanPham loaiSanPham;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "IdDotKhuyenMai")
//    private DotKhuyenMai dotKhuyenMai;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdSanPham")
    private SanPham sanPham;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdDanhMuc")
    private DanhMuc danhMuc;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdKieuDang")
    private KieuDang kieuDang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdThuongHieu")
    private ThuongHieu thuongHieu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdMuiGiay")
    private MuiGiay muiGiay;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdDeGiay")
    private DeGiay deGiay;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdLotGiay")
    private LotGiay lotGiay;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdDayGiay")
    private DayGiay dayGiay;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdKichThuoc")
    private KichCo kichCo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdChatLieu")
    private ChatLieu chatLieu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdMauSac")
    private MauSac mauSac;

//    @Column(name = "ma")
//    private String ma;
//
//    @Column(name = "Ten")
//    private String ten;

    @Column(name = "GiaTriSanPham")
    private Double giaTriSanPham;

    @Column(name = "GiaTriGiam")
    private Double giaTriGiam;

    @Column(name = "KhoiLuong")
    private Double khoiLuong;

//    @Column(name = "NgayHetGiamGia")
//    private Date ngayHetGiamGia;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "HinhAnh")
    private String hinhAnh;

}
