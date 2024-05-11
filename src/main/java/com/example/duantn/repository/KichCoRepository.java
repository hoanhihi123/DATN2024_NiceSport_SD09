package com.example.duantn.repository;

import com.example.duantn.model.KichCo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface KichCoRepository extends JpaRepository<KichCo, UUID> {

    @Query(value = "select * from KichThuoc order by ten desc", nativeQuery = true)
    public List<KichCo> getAll();

    // getAll
    @Query(value = "select * from KichThuoc order by ten desc",
            countQuery = "select count(*) from KichThuoc", nativeQuery = true)
    public Page<KichCo> getAll( Pageable pageable);

//    @Query(value = "select * from KichCo where TrangThai=:status order by NgaySua desc",
//            countQuery = "select * from KichCo where  TrangThai=:status",
//            nativeQuery = true)
//    public Page<KichCo> getAll(@Param("status") Integer status, Pageable pageable);


//    @Query(value = "select * from KichCo where concat(Ten, MoTa) like %:textSearch% or TrangThai=:status order by NgaySua desc",
//            countQuery = "select count(*) from KichCo where concat(Ten, MoTa) like %:textSearch% or TrangThai=:status",
//            nativeQuery = true)
//    public Page<KichCo> getAll(@Param("textSearch") String textSearch, @Param("status") Integer status, Pageable pageable);

    @Query(value = "select * from KichThuoc where concat(Ten, MoTa) like %:textSearch%  order by ten desc",
            countQuery = "select count(*) from KichThuoc where concat(Ten, MoTa) like %:textSearch% ",
            nativeQuery = true)
    public Page<KichCo> getAll(@Param("textSearch") String textSearch, Pageable pageable);

    @Query(value = "select * from KichThuoc where Ma =:textSearch  order by ten desc",
            countQuery = "select count(*) from KichThuoc where Ma =:textSearch ", nativeQuery = true)
    public List<KichCo> getAllTheoMa(@Param("textSearch") String textSearch);

    @Query(value = "select * from KichThuoc where Ten =:textSearch  order by ten desc",
            countQuery = "select count(*) from KichThuoc where Ten =:textSearch ", nativeQuery = true)
    public List<KichCo> getAllTheoTen(@Param("textSearch") String textSearch);
}
