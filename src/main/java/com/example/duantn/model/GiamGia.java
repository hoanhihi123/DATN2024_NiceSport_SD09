package com.example.duantn.model;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;


@Entity
@Table(name = "DotKhuyenMai")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class GiamGia extends BaseModel{
    @Column(name = "Ma")
    private String ma;

    @Column(name = "tenDotKhuyenMai")
    private String ten;

    @Column(name = "GiaTriGiam")
    private double giaTriGiam;

    @Column(name = "NgayBatDau")
    private Date ngayBatDau;

    @Column(name = "NgayKetThuc")
    private Date ngayKetThuc;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "IdSanPham", referencedColumnName = "Id")
//    private SanPham idSanPham;

}
