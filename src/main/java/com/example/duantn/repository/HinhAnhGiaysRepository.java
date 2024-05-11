package com.example.duantn.repository;

import com.example.duantn.model.ChatLieu;
import com.example.duantn.model.ChucVu;
import com.example.duantn.model.HinhAnhGiays;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface HinhAnhGiaysRepository extends JpaRepository<HinhAnhGiays, UUID> {
//    @Query(value = "select * from HinhAnhGiays", nativeQuery = true)
//    public List<HinhAnhGiays> getAll();

    @Query(value = "select * from HinhAnhGiays where IdSanPhamCT =:idSanPhamCT",
                    nativeQuery = true)
    public List<HinhAnhGiays> getListHinhAnhGiay_theoIDSanPhamCT(@Param("idSanPhamCT") UUID idSanPhamCT);


    @Transactional
    @Modifying
    @Query(value = "delete from HinhAnhGiays where IdSanPhamCT =:idSanPhamCT ", nativeQuery = true)
    public void xoaHinhAnhTheoIdSanPhamCT(@Param("idSanPhamCT") UUID idSanPhamCT);

}
