package com.example.duantn.repository;

import com.example.duantn.model.DiaChi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DiaChiRepository extends JpaRepository<DiaChi, UUID> {
    @Query(value = "select * from DiaChi order by ngaySua desc", nativeQuery = true)
    public List<DiaChi> getAll();

    // getAll
    @Query(value = "select * from DiaChi order by ngaySua desc",
            countQuery = "select count(*) from DiaChi", nativeQuery = true)
    public Page<DiaChi> getAll(Pageable pageable);

    @Query(value = "select * from DiaChi where concat(Ma, TenDiaChi, MoTaCT, TinhThanhPho) like %:textSearch%  order by ngaySua desc",
            countQuery = "select count(*) from DiaChi where concat(Ma, TenDiaChi, MoTaCT, TinhThanhPho) like %:textSearch% ",
            nativeQuery = true)
    public Page<DiaChi> getAll(@Param("textSearch") String textSearch, Pageable pageable);

    @Query(value = "select * from DiaChi where Ma =:textSearch  order by ten desc",
            countQuery = "select count(*) from DiaChi where Ma =:textSearch ", nativeQuery = true)
    public List<DiaChi> getAllTheoMa(@Param("textSearch") String textSearch);

    @Query(value = "select * from DiaChi where TenDiaChi =:textSearch  order by ten desc",
            countQuery = "select count(*) from DiaChi where TenDiaChi =:textSearch ", nativeQuery = true)
    public List<DiaChi> getAllTheoTen(@Param("textSearch") String textSearch);

}

