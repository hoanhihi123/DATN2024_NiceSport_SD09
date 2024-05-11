package com.example.duantn.repository;

import com.example.duantn.model.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {
    @Query(value = "select * from NhanVien where trangThai=1 order by ngayTao desc", nativeQuery = true)
    public List<NhanVien> getAll();

    // getAll
    @Query(value = "select * from NhanVien order by ngaySua desc",
            countQuery = "select count(*) from NhanVien", nativeQuery = true)
    public Page<NhanVien> getAll(Pageable pageable);

    @Query(value = "select * from NhanVien where concat(HoTen, TaiKhoan, Sdt, diaChi) like %:textSearch%  order by ngaySua desc",
            countQuery = "select count(*) from NhanVien where concat(HoTen, TaiKhoan, Sdt, diaChi) like %:textSearch% ",
            nativeQuery = true)
    public Page<NhanVien> getAll(@Param("textSearch") String textSearch, Pageable pageable);

    @Query(value = "select * from NhanVien where Ma =:textSearch  order by ten desc",
            countQuery = "select count(*) from NhanVien where Ma =:textSearch ", nativeQuery = true)
    public List<NhanVien> getAllTheoMa(@Param("textSearch") String textSearch);

    @Query(value = "select * from NhanVien where Ten =:textSearch  order by ten desc",
            countQuery = "select count(*) from NhanVien where Ten =:textSearch ", nativeQuery = true)
    public List<NhanVien> getAllTheoTen(@Param("textSearch") String textSearch);
}
