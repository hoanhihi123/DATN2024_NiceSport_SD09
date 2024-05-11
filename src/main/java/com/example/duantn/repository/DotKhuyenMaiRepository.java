package com.example.duantn.repository;

import com.example.duantn.model.DotKhuyenMai;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DotKhuyenMaiRepository extends JpaRepository<DotKhuyenMai, UUID> {
    @Query(value = "select * from DotKhuyenMai order by ngaySua desc", nativeQuery = true)
    public List<DotKhuyenMai> getAll();

    @Query(value = "select * from DotKhuyenMai order by ngaySua desc",
            countQuery = "select count(*) from DotKhuyenMai", nativeQuery = true)
    public Page<DotKhuyenMai> getAll(Pageable pageable);

    @Query(value = "select * from DotKhuyenMai where concat(Ma, tenDotKhuyenMai) like %:textSearch%  order by ngaySua desc",
            countQuery = "select count(*) from DotKhuyenMai where concat(Ma, tenDotKhuyenMai) like %:textSearch% ",
            nativeQuery = true)
    public Page<DotKhuyenMai> getAll(@Param("textSearch") String textSearch, Pageable pageable);

    @Query(value = "select * from DotKhuyenMai where Ma =:textSearch  order by tenDotKhuyenMai desc",
            countQuery = "select count(*) from DotKhuyenMai where Ma =:textSearch ", nativeQuery = true)
    public List<DotKhuyenMai> getAllTheoMa(@Param("textSearch") String textSearch);

    @Query(value = "select * from DotKhuyenMai where tenDotKhuyenMai =:textSearch  order by ten desc",
            countQuery = "select count(*) from DotKhuyenMai where tenDotKhuyenMai =:textSearch ", nativeQuery = true)
    public List<DotKhuyenMai> getAllTheoTen(@Param("textSearch") String textSearch);

    boolean existsByMa(String ma);

    boolean existsByTen(String ten);

    // Tìm kiếm đợt khuyến mãi theo ID
    Optional<DotKhuyenMai> findById(UUID id);

    // Tìm đợt khuyến mãi mới nhất
    DotKhuyenMai findTopByOrderByIdDesc();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO DotKhuyenMai (Ma, tenDotKhuyenMai, NgayBatDau, NgayKetThuc, TrangThai) " +
            "VALUES (:ma, :tenDotKhuyenMai, :ngayBatDau, :ngayKetThuc, :trangThai)", nativeQuery = true)
    void themMoiDotKhuyenMai(@Param("ma") String ma,
                             @Param("tenDotKhuyenMai") String tenDotKhuyenMai,
                             @Param("ngayBatDau") Date ngayBatDau,
                             @Param("ngayKetThuc") Date ngayKetThuc,
                             @Param("trangThai") int trangThai);

    @Query(value = "select dkm.* from DotKhuyenMai dkm " +
            "join SanPham_DotKhuyenMai sp_dkm on dkm.id = sp_dkm.idDotKhuyenMai " +
            "where sp_dkm.idsanpham = :idSp", nativeQuery = true)
    DotKhuyenMai getDotKhuyenMaiByIdSanPham(@Param("idSp") UUID idSp);
}
