package com.example.duantn.repository;

import com.example.duantn.model.ChiTietSanPham;
import com.example.duantn.model.KhachHang;
import com.example.duantn.model.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, UUID> {

    // hoan code
    @Query(value = "select * from KhachHang where SoDT =:phoneNumber", nativeQuery = true)
    public List<KhachHang> getAllBySDT_Customer(@Param("phoneNumber") String phoneNumber);

    @Query(value = "select * from KhachHang where SoDT =:phoneNumber", nativeQuery = true)
    public KhachHang getCustomerOnlyByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    @Query(value = "select * from KhachHang where SoDT =:phoneNumber",
            countQuery = "select count(*) from KhachHang where SoDT =:phoneNumber", nativeQuery = true)
    public Page<KhachHang> getAllBySDT_Customer_phanTrang(@Param("phoneNumber") String phoneNumber, Pageable pageable);

    // hoan code

    @Query(value = "select * from KhachHang order by ngayTao desc", nativeQuery = true)
    public List<KhachHang> getAll();

    @Query(value = "select  * from KhachHang order  by ngayTao desc",
            countQuery = "select  count(*) from KhachHang", nativeQuery = true)
    public Page<KhachHang> getAll(Pageable pageable);

    @Query(value = "select * from KhachHang where Ma =:textSearch  order by hoTen desc",
            countQuery = "select count(*) from KhachHang where Ma =:textSearch ", nativeQuery = true)
    public List<KhachHang> getAllTheoMa(@Param("textSearch") String textSearch);

    @Query(value = "select HoTen from KhachHang where HoTen =:textSearch  order by HoTen desc",
            countQuery = "select count(*) from KhachHang where HoTen =:textSearch ", nativeQuery = true)
    public List<KhachHang> getAllTheoTen(@Param("textSearch") String textSearch);


    @Query("select k from KhachHang k where k.taiKhoan = :username")
    KhachHang findByUsername(String username);


    @Query(value = "select  * from KhachHang where concat(Ma,HoTen) like %:textSearch% order by ngaySua desc",
            countQuery = "select  count(*) from KhachHang where concat(Ma,HoTen) like %:textSearch%",
            nativeQuery = true)
    public Page<KhachHang> getAll(@Param("textSearch") String textSearch, Pageable pageable);


    KhachHang findByTaiKhoan(String TaiKhoan);
    KhachHang findByHoTen(String ten);

}
