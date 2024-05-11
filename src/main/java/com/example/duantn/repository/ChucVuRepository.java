package com.example.duantn.repository;

import com.example.duantn.model.ChucVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu, UUID> {
    @Query(value = "select * from ChucVu order by ten desc", nativeQuery = true)
    public List<ChucVu> getAll();

    // getAll
    @Query(value = "select * from ChucVu order by ten desc",
            countQuery = "select count(*) from ChucVu", nativeQuery = true)
    public Page<ChucVu> getAll(Pageable pageable);

    @Query(value = "select * from ChucVu where concat(Ten, MoTa) like %:textSearch%  order by ten desc",
            countQuery = "select count(*) from ChucVu where concat(Ten, MoTa) like %:textSearch% ",
            nativeQuery = true)
    public Page<ChucVu> getAll(@Param("textSearch") String textSearch, Pageable pageable);

    @Query(value = "select Ten from ChucVu where Ten =:textSearch  order by ten desc",
            countQuery = "select count(Ten) from ChucVu where Ten =:textSearch ", nativeQuery = true)
    public List<ChucVu> getAllTheoTen(@Param("textSearch") String textSearch);


    @Query(value = "select * from ChucVu where Ma =:textSearch  order by ten desc",
            countQuery = "select count(*) from ChucVu where Ma =:textSearch ", nativeQuery = true)
    public List<ChucVu> getAllTheoMa(@Param("textSearch") String textSearch);



}
