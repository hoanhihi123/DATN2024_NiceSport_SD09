package com.example.duantn.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Table(name = "NhanVien")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NhanVien extends BaseModel {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdChucVu",referencedColumnName = "Id")
    private ChucVu chucVu;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "HoTen")
    private String hoVaTen;

    @Column(name = "TaiKhoan")
    private String taiKhoan;

    @Column(name = "MatKhau")
    private String matKhau;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "GioiTinh")
    private Integer gioiTinh;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "Email")
    private String email;

    @Column(name = "diaChi")
    private String diaChi;


}
