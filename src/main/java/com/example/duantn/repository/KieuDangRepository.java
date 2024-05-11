package com.example.duantn.repository;

import com.example.duantn.model.KieuDang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface KieuDangRepository extends JpaRepository<KieuDang, UUID> {
    @Query(value = "select * from KieuDang order by ngayTao desc", nativeQuery = true)
    public List<KieuDang> getAll();

    //get all
    @Query(value = "select * from KieuDang order by ten desc",
            countQuery = "select count(*) from KieuDang", nativeQuery = true)
    public Page<KieuDang> getAll(Pageable pageable);


    @Query(value = "select * from KieuDang where concat(Ten, MoTa) like %:textSearch%  order by ten desc",
            countQuery = "select count(*) from KieuDang where concat(Ten, MoTa) like %:textSearch% ",
            nativeQuery = true)
    public Page<KieuDang> getAll(@Param("textSearch") String textSearch, Pageable pageable);

    @Query(value = "select * from KieuDang where Ma =:textSearch  order by ten desc",
            countQuery = "select count(*) from KieuDang where Ma =:textSearch ", nativeQuery = true)
    public List<KieuDang> getAllTheoMa(@Param("textSearch") String textSearch);

    @Query(value = "select * from KieuDang where Ten =:textSearch  order by ten desc",
            countQuery = "select count(*) from KieuDang where Ten =:textSearch ", nativeQuery = true)
    public List<KieuDang> getAllTheoTen(@Param("textSearch") String textSearch);

}
