package com.example.duantn.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "HinhAnhGiays")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class HinhAnhGiays extends BaseModel{

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdSanPhamCT",referencedColumnName = "Id")
    private ChiTietSanPham chiTietSanPham;

    @Column(name = "duongDanAnh")
    private String  duongDanAnh;


}
