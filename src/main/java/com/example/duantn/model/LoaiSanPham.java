package com.example.duantn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name = "LoaiSanPham")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoaiSanPham extends BaseModel {


    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;
//    @Column(name = "MoTa")
//    private String moTa;
}