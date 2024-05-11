package com.example.duantn.repository;

import com.example.duantn.model.LotGiay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LotGiayRepository extends JpaRepository<LotGiay, UUID> {
    @Query(value = "select * from LotGiay order by ngayTao desc",nativeQuery = true)
    List<LotGiay> getAll();

    @Query(value = "select * from LotGiay order by ten desc",
            countQuery = "select count(*) from LotGiay", nativeQuery = true)
    public Page<LotGiay> getAll(Pageable pageable);


    @Query(value = "select * from LotGiay where concat(Ten, MoTa) like %:textSearch%  order by ten desc",
            countQuery = "select count(*) from LotGiay where concat(Ten, MoTa) like %:textSearch% ",
            nativeQuery = true)
    public Page<LotGiay> getAll(@Param("textSearch") String textSearch, Pageable pageable);

    @Query(value = "select * from LotGiay where Ma =:textSearch  order by ten desc",
            countQuery = "select count(*) from LotGiay where Ma =:textSearch ", nativeQuery = true)
    public List<LotGiay> getAllTheoMa(@Param("textSearch") String textSearch);

    @Query(value = "select * from LotGiay where Ten =:textSearch  order by ten desc",
            countQuery = "select count(*) from LotGiay where Ten =:textSearch ", nativeQuery = true)
    public List<LotGiay> getAllTheoTen(@Param("textSearch") String textSearch);
}
