package com.example.duantn.repository;

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
public interface NSXRepository extends JpaRepository<NSX, UUID> {
    @Query(value = "select * from NhaSanXuat  order by ngayTao desc", nativeQuery = true)
    public List<NSX> getAll();

    @Query(value = "select * from NhaSanXuat order by ngaySua desc",
            countQuery = "select count(*) from NhaSanXuat", nativeQuery = true)
    public Page<NSX> getAll(Pageable pageable);

    @Query(value = "select * from NhaSanXuat where concat(Ten, MoTa) like %:textSearch%  order by ngaySua desc",
            countQuery = "select count(*) from NhaSanXuat where concat(Ten, MoTa) like %:textSearch% ",
            nativeQuery = true)
    public Page<NSX> getAll(@Param("textSearch") String textSearch, Pageable pageable);

    @Query(value = "select * from NhaSanXuat where Ma =:textSearch  order by ten desc",
            countQuery = "select count(*) from NhaSanXuat where Ma =:textSearch ", nativeQuery = true)
    public List<NSX> getAllTheoMa(@Param("textSearch") String textSearch);

    @Query(value = "select * from NhaSanXuat where Ten =:textSearch  order by ten desc",
            countQuery = "select count(*) from NhaSanXuat where Ten =:textSearch ", nativeQuery = true)
    public List<NSX> getAllTheoTen(@Param("textSearch") String textSearch);
}