package com.example.duantn.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.UUID;

@Table(name = "HoaDon")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class HoaDon  {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdKhachHang",referencedColumnName = "Id")
    private KhachHang khachHang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdPhieuGiamGia",referencedColumnName = "Id")
    private PhieuGiamGia phieuGiamGia;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdNhanVien",referencedColumnName = "Id")
    private NhanVien nhanVien;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "NgayMua")
    private Date ngayMua;


    @Column(name = "NgayNhan")
    private Date ngayNhan;

    @Column(name = "NgayGiao")
    private Date ngayGiao;

    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;

    @Column(name = "TongTienThanhToan")
    private Double tongTienThanhToan;

    @Column(name = "TienVanChuyen")
    private Double tienVanChuyen;

    @Column(name = "TongTienDuocGiamGia")
    private Double tongTienDuocGiamGia;

    @Column(name = "TenKH")
    private String tenKH;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "SoDT")
    private String soDT;

    @Column(name = "ghiChu")
    private String ghiChu;

    @Column(name = "email")
    private String email;

    @Column(name = "HinhThucTT")
    private String hinhThucTT;

    @Column(name = "TrangThai")
    private String  trangThai;

    @Column(name = "tinh_thanhPho")
    private String tinh_thanhPho;

    @Column(name = "quan_huyen")
    private String quan_huyen;

    @Column(name = "phuong_xa")
    private String phuong_xa;

    // hoan them
    @Column(name = "loaiHoaDon")
    private String loaiHoaDon;

    @Column(name = "NgaySua")
    private java.util.Date ngaySua;

    @Column(name = "NgayTao")
    private java.util.Date ngayTao;

    @Column(name = "NguoiSua")
    private Integer nguoiSua;

    @Column(name = "NguoiTao")
    private Integer nguoiTao;
    // duc anh them
    @Column(name = "LYDOHUY")
    private String lyDoHuy;

}
