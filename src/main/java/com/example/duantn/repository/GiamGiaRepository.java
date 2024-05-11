package com.example.duantn.repository;

import com.example.duantn.model.GiamGia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface GiamGiaRepository extends JpaRepository<GiamGia, UUID> {
    @Query(value = "select * from DotKhuyenMai order by ngaySua desc", nativeQuery = true)
    public List<GiamGia> getAll();

    // getAll
    @Query(value = "select * from DotKhuyenMai order by ngaySua desc",
            countQuery = "select count(*) from DotKhuyenMai", nativeQuery = true)
    public Page<GiamGia> getAll(Pageable pageable);

    @Query(value = "select * from DotKhuyenMai where concat(Ma, tenDotKhuyenMai) like %:textSearch%  order by ngaySua desc",
            countQuery = "select count(*) from DotKhuyenMai where concat(Ma, tenDotKhuyenMai) like %:textSearch% ",
            nativeQuery = true)
    public Page<GiamGia> getAll(@Param("textSearch") String textSearch, Pageable pageable);

    @Query(value = "select * from DotKhuyenMai where Ma =:textSearch  order by tenDotKhuyenMai desc",
            countQuery = "select count(*) from DotKhuyenMai where Ma =:textSearch ", nativeQuery = true)
    public List<GiamGia> getAllTheoMa(@Param("textSearch") String textSearch);

    @Query(value = "select * from DotKhuyenMai where tenDotKhuyenMai =:textSearch  order by ten desc",
            countQuery = "select count(*) from DotKhuyenMai where tenDotKhuyenMai =:textSearch ", nativeQuery = true)
    public List<GiamGia> getAllTheoTen(@Param("textSearch") String textSearch);

    // Kiểm tra xem có mã giảm giá nào trùng với mã được cung cấp không
    boolean existsByMa(String ma);

    // Kiểm tra xem có tên giảm giá nào trùng với tên được cung cấp không
    boolean existsByTen(String ten);
    List<GiamGia> findByNgayKetThucBeforeAndTrangThai(Date ngayKetThuc, int trangThai);
}
