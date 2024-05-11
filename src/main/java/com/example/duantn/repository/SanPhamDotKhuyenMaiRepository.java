package com.example.duantn.repository;

import com.example.duantn.model.SanPhamDotKhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SanPhamDotKhuyenMaiRepository extends JpaRepository<SanPhamDotKhuyenMai, Long> {

    @Query(value = "select * from SanPham_DotKhuyenMai where idSanPham = :idSanPham ",nativeQuery = true)
    SanPhamDotKhuyenMai getExistProduct(@Param("idSanPham") UUID idSanPham);
}
