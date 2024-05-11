package com.example.duantn.repository;

import com.example.duantn.model.DanhMuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DanhMucRepository extends JpaRepository<DanhMuc, UUID> {
    @Query(value = "select * from DanhMuc order by ngayTao desc", nativeQuery = true)
    public List<DanhMuc> getAll();

    // getAll
    @Query(value = "select * from DanhMuc order by ngaySua desc",
            countQuery = "select count(*) from DanhMuc", nativeQuery = true)
    public Page<DanhMuc> getAll(Pageable pageable);

    @Query(value = "select * from DanhMuc where concat(Ten, MoTa) like %:textSearch%  order by ngaySua desc",
            countQuery = "select count(*) from DanhMuc where concat(Ten, MoTa) like %:textSearch% ",
            nativeQuery = true)
    public Page<DanhMuc> getAll(@Param("textSearch") String textSearch, Pageable pageable);

    @Query(value = "select * from DanhMuc where Ma =:textSearch  order by ten desc",
            countQuery = "select count(*) from DanhMuc where Ma =:textSearch ", nativeQuery = true)
    public List<DanhMuc> getAllTheoMa(@Param("textSearch") String textSearch);

    @Query(value = "select * from DanhMuc where Ten =:textSearch  order by ten desc",
            countQuery = "select count(*) from DanhMuc where Ten =:textSearch ", nativeQuery = true)
    public List<DanhMuc> getAllTheoTen(@Param("textSearch") String textSearch);
}
