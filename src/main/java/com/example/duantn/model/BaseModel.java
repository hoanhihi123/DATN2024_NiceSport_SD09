package com.example.duantn.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.UUID;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class BaseModel { //:)))
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "NgaySua")
    private Date ngaySua;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NguoiSua")
    private Integer nguoiSua;

    @Column(name = "NguoiTao")
    private Integer nguoiTao;

    @Column(name = "TrangThai")
    private Integer trangThai;
}
