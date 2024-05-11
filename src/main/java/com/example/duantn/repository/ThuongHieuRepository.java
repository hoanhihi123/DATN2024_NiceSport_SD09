package com.example.duantn.repository;

import com.example.duantn.model.ThuongHieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
@Repository
public interface ThuongHieuRepository extends JpaRepository<ThuongHieu, UUID> {
    @Query(value = "select * from ThuongHieu order by ngayTao desc", nativeQuery = true)
    public List<ThuongHieu> getAll();

    // getAll
    @Query(value = "select * from ThuongHieu order by ngaySua desc",
            countQuery = "select count(*) from ThuongHieu", nativeQuery = true)
    public Page<ThuongHieu> getAll(Pageable pageable);

    @Query(value = "select * from ThuongHieu where concat(Ten, MoTa) like %:textSearch%  order by ngaySua desc",
            countQuery = "select count(*) from ThuongHieu where concat(Ten, MoTa) like %:textSearch% ",
            nativeQuery = true)
    public Page<ThuongHieu> getAll(@Param("textSearch") String textSearch, Pageable pageable);

    @Query(value = "select * from ThuongHieu where Ma =:textSearch  order by ten desc",
            countQuery = "select count(*) from ThuongHieu where Ma =:textSearch ", nativeQuery = true)
    public List<ThuongHieu> getAllTheoMa(@Param("textSearch") String textSearch);

    @Query(value = "select * from ThuongHieu where Ten =:textSearch  order by ten desc",
            countQuery = "select count(*) from ThuongHieu where Ten =:textSearch ", nativeQuery = true)
    public List<ThuongHieu> getAllTheoTen(@Param("textSearch") String textSearch);


}
