package com.example.duantn.repository;

import com.example.duantn.model.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac, UUID> {
    @Query(value = "select * from MauSac order by ngayTao desc", nativeQuery = true)
    public List<MauSac> getAll();

    // getAll
    @Query(value = "select * from MauSac order by ngaySua desc",
            countQuery = "select count(*) from MauSac", nativeQuery = true)
    public Page<MauSac> getAll(Pageable pageable);

    @Query(value = "select * from MauSac where concat(Ten, MoTa) like %:textSearch%  order by ngaySua desc",
            countQuery = "select count(*) from MauSac where concat(Ten, MoTa) like %:textSearch% ",
            nativeQuery = true)
    public Page<MauSac> getAll(@Param("textSearch") String textSearch, Pageable pageable);

    @Query(value = "select * from MauSac where Ma =:textSearch  order by ten desc",
            countQuery = "select count(*) from MauSac where Ma =:textSearch ", nativeQuery = true)
    public List<MauSac> getAllTheoMa(@Param("textSearch") String textSearch);

    @Query(value = "select * from MauSac where Ten =:textSearch  order by ten desc",
            countQuery = "select count(*) from MauSac where Ten =:textSearch ", nativeQuery = true)
    public List<MauSac> getAllTheoTen(@Param("textSearch") String textSearch);
}