package com.example.duantn.repository;

import com.example.duantn.model.DayGiay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

@Repository
public interface DayGiayRepository extends JpaRepository<DayGiay, UUID> {
    @Query(value = "select * from DayGiay order by ngayTao desc", nativeQuery = true)
    public List<DayGiay> getAll();

    @Query(value = "select * from DayGiay order by ngaySua desc",
            countQuery = "select count(*) from DayGiay", nativeQuery = true)
    public Page<DayGiay> getAll(Pageable pageable);

    @Query(value = "select * from DayGiay where concat(Ten, MoTa) like %:textSearch%  order by ngaySua desc",
            countQuery = "select count(*) from DayGiay where concat(Ten, MoTa) like %:textSearch% ",
            nativeQuery = true)
    public Page<DayGiay> getAll(@Param("textSearch") String textSearch, Pageable pageable);

    @Query(value = "select * from DayGiay where Ma =:textSearch  order by ten desc",
            countQuery = "select count(*) from DayGiay where Ma =:textSearch ", nativeQuery = true)
    public List<DayGiay> getAllTheoMa(@Param("textSearch") String textSearch);

    @Query(value = "select * from DayGiay where Ten =:textSearch  order by ten desc",
            countQuery = "select count(*) from DayGiay where Ten =:textSearch ", nativeQuery = true)
    public List<DayGiay> getAllTheoTen(@Param("textSearch") String textSearch);

}
