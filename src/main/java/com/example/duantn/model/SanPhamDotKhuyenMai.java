package com.example.duantn.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name = "SanPham_DotKhuyenMai")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SanPhamDotKhuyenMai {
    @Column(name = "idSanPham")
    private UUID idSanPham;
    @Column(name = "idDotKhuyenMai")
    private UUID idDotKhuyenMai;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
