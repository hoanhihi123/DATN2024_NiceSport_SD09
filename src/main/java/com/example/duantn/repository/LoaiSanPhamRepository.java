package com.example.duantn.repository;

import com.example.duantn.model.LoaiSanPham;
import com.example.duantn.model.NSX;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LoaiSanPhamRepository extends JpaRepository<LoaiSanPham, UUID> {
    @Query(value = "select * from LoaiSanPham where trangThai=1 order by ngayTao desc", nativeQuery = true)
    public List<LoaiSanPham> getAll();

    @Query(value = "select * from LoaiSanPham order by ngaySua desc",
            countQuery = "select count(*) from LoaiSanPham", nativeQuery = true)
    public Page<LoaiSanPham> getAll(Pageable pageable);

    @Query(value = "select * from LoaiSanPham where concat(Ten, MoTa) like %:textSearch%  order by ngaySua desc",
            countQuery = "select count(*) from LoaiSanPham where concat(Ten, MoTa) like %:textSearch% ",
            nativeQuery = true)
    public Page<LoaiSanPham> getAll(@Param("textSearch") String textSearch, Pageable pageable);

    @Query(value = "select * from LoaiSanPham where Ma =:textSearch  order by ten desc",
            countQuery = "select count(*) from LoaiSanPham where Ma =:textSearch ", nativeQuery = true)
    public List<LoaiSanPham> getAllTheoMa(@Param("textSearch") String textSearch);

    @Query(value = "select * from LoaiSanPham where Ten =:textSearch  order by ten desc",
            countQuery = "select count(*) from LoaiSanPham where Ten =:textSearch ", nativeQuery = true)
    public List<LoaiSanPham> getAllTheoTen(@Param("textSearch") String textSearch);
}