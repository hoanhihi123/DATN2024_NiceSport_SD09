package com.example.duantn.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import com.example.duantn.model.DeGiay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DeGiayRepository extends JpaRepository<DeGiay, UUID> {
    @Query(value = "select * from DeGiay order by ngayTao desc", nativeQuery = true)
    public List<DeGiay> getAll();

    @Query(value = "select * from DeGiay order by ngaySua desc",
            countQuery = "select count(*) from DeGiay", nativeQuery = true)
    public Page<DeGiay> getAll(Pageable pageable);

    @Query(value = "select * from DeGiay where concat(Ten, MoTa) like %:textSearch%  order by ngaySua desc",
            countQuery = "select count(*) from DeGiay where concat(Ten, MoTa) like %:textSearch% ",
            nativeQuery = true)
    public Page<DeGiay> getAll(@Param("textSearch") String textSearch, Pageable pageable);

    @Query(value = "select * from DeGiay where Ma =:textSearch  order by ten desc",
            countQuery = "select count(*) from DeGiay where Ma =:textSearch ", nativeQuery = true)
    public List<DeGiay> getAllTheoMa(@Param("textSearch") String textSearch);

    @Query(value = "select * from DeGiay where Ten =:textSearch  order by ten desc",
            countQuery = "select count(*) from DeGiay where Ten =:textSearch ", nativeQuery = true)
    public List<DeGiay> getAllTheoTen(@Param("textSearch") String textSearch);


}
