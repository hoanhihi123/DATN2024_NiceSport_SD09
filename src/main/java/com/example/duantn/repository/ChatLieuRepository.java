package com.example.duantn.repository;

import com.example.duantn.model.ChatLieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChatLieuRepository extends JpaRepository<ChatLieu, UUID> {
    //    @Query(value = "select * from ChatLieuRequest", nativeQuery = true)
//    public List<ChatLieuRequest> getAll();

    @Query(value = "select * from ChatLieu order by ngayTao desc", nativeQuery = true)
    public List<ChatLieu> getAll();
    // getAll
    @Query(value = "select * from ChatLieu order by ngaySua desc",
            countQuery = "select count(*) from ChatLieu", nativeQuery = true)
    public Page<ChatLieu> getAll(Pageable pageable);

    @Query(value = "select * from ChatLieu where concat(Ten, MoTa) like %:textSearch%  order by ngaySua desc",
            countQuery = "select count(*) from ChatLieu where concat(Ten, MoTa) like %:textSearch% ",
            nativeQuery = true)
    public Page<ChatLieu> getAll(@Param("textSearch") String textSearch, Pageable pageable);

    @Query(value = "select * from ChatLieu where Ma =:textSearch  order by ten desc",
            countQuery = "select count(*) from ChatLieu where Ma =:textSearch ", nativeQuery = true)
    public List<ChatLieu> getAllTheoMa(@Param("textSearch") String textSearch);

    @Query(value = "select * from ChatLieu where Ten =:textSearch  order by ten desc",
            countQuery = "select count(*) from ChatLieu where Ten =:textSearch ", nativeQuery = true)
    public List<ChatLieu> getAllTheoTen(@Param("textSearch") String textSearch);
}
