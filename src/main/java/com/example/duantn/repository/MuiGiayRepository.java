package com.example.duantn.repository;

import com.example.duantn.model.MuiGiay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MuiGiayRepository extends JpaRepository<MuiGiay, UUID> {
    @Query(value = "select * from MuiGiay order by ngayTao desc", nativeQuery = true)
    public List<MuiGiay> getAll();

    // getAll
    @Query(value = "select * from MuiGiay order by ngaySua desc",
            countQuery = "select count(*) from MuiGiay", nativeQuery = true)
    public Page<MuiGiay> getAll(Pageable pageable);

    @Query(value = "select * from MuiGiay where concat(Ten, MoTa) like %:textSearch%  order by ngaySua desc",
            countQuery = "select count(*) from MuiGiay where concat(Ten, MoTa) like %:textSearch% ",
            nativeQuery = true)
    public Page<MuiGiay> getAll(@Param("textSearch") String textSearch, Pageable pageable);

    @Query(value = "select * from MuiGiay where Ma =:textSearch  order by ten desc",
            countQuery = "select count(*) from MuiGiay where Ma =:textSearch ", nativeQuery = true)
    public List<MuiGiay> getAllTheoMa(@Param("textSearch") String textSearch);

    @Query(value = "select * from MuiGiay where Ten =:textSearch  order by ten desc",
            countQuery = "select count(*) from MuiGiay where Ten =:textSearch ", nativeQuery = true)
    public List<MuiGiay> getAllTheoTen(@Param("textSearch") String textSearch);

}
