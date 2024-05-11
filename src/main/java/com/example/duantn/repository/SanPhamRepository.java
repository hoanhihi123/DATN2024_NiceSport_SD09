package com.example.duantn.repository;

import com.example.duantn.model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, UUID> {
    @Query(value = "select * from SanPham order by ngayTao desc", nativeQuery = true)
    public List<SanPham> getAll();

    @Query(value = "select * from SanPham WHERE trangThai=1",
            countQuery = "select count(*) from SanPham WHERE trangThai=1", nativeQuery = true)
    public Page<SanPham> getAllWithStatus_1(Pageable pageable);

    // getAll
    @Query(value = "select * from SanPham order by ngayTao desc",
            countQuery = "select count(*) from SanPham ", nativeQuery = true)
    public Page<SanPham> getAllSanPham_phanTrang(Pageable pageable);

    @Query(value = "select * from SanPham where concat(Ten, MoTa) like %:textSearch%  order by ngaySua desc",
            countQuery = "select count(*) from SanPham where concat(Ten, MoTa) like %:textSearch% ",
            nativeQuery = true)
    public Page<SanPham> getAll(@Param("textSearch") String textSearch, Pageable pageable);

    @Query(value = "select Ten from SanPham where Ten =:textSearch  order by ngayTao desc",
            countQuery = "select count(Ten) from SanPham where Ten =:textSearch ", nativeQuery = true)
    public List<SanPham> getAllTheoTen(@Param("textSearch") String textSearch);

    @Query(value = "select * from SanPham where Ma =:textSearch  order by ngayTao desc",
            countQuery = "select count(*) from SanPham where Ma =:textSearch ", nativeQuery = true)
    public List<SanPham> getAllTheoMa(@Param("textSearch") String textSearch);

    Page<SanPham> findByTenContainingIgnoreCase(String textSearch, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT sp.* FROM SanPham sp JOIN DotKhuyenMai km ON sp.id = km.idSanPham WHERE km.id = :idDotKhuyenMai")
    List<SanPham> findByDotKhuyenMaiId(@Param("idDotKhuyenMai") UUID idDotKhuyenMai);



    Page<SanPham> findByTrangThai(int trangThai, Pageable pageable);

    List<SanPham> findByTen(String ten);

    @Query(value = "UPDATE SanPham SET IdDotKhuyenMai = :idDotKhuyenMai WHERE Id = :id", nativeQuery = true)
    void apDungDotKhuyenMaiChoSanPham(@Param("id") UUID id, @Param("idDotKhuyenMai") UUID idDotKhuyenMai);

    @Query(nativeQuery = true,
            value = "SELECT sp.* FROM SanPham sp " +
                    "JOIN SanPham_DotKhuyenMai sp_dkm ON sp.id = sp_dkm.idSanPham " +
                    "JOIN DotKhuyenMai dkm ON sp_dkm.idDotKhuyenMai = dkm.id " +
                    "WHERE sp_dkm.idDotKhuyenMai = :id")
    List<SanPham> getSanPhamByMaIdKM(@Param("id") UUID id);

    @Query(value = "select sp.* from SanPham sp " +
            "join SanPham_DotKhuyenMai sp_dkm on sp.id = sp_dkm.idSanPham " +
            "join DotKhuyenMai dkm on sp_dkm.idDotKhuyenMai = dkm.id " +
            "join SanPhamCT spct on sp.id = spct.idSanPham " +
            "where sp.ma = :maSP", nativeQuery = true)
    SanPham getSanPhamByMaSP(@Param("maSP") String maSP);


}
