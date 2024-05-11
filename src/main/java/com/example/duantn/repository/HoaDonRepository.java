package com.example.duantn.repository;

import com.example.duantn.model.HoaDon;
import com.example.duantn.record.OrderDetailRecord;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {
    @Query(value = "select * from HoaDon ", nativeQuery = true)
    List<HoaDon> getAll();

    @Query(value = "select * from HoaDon where trangThai =:trangThai order by NgayMua asc ",
            countQuery = "select * from HoaDon where trangThai =:trangThai", nativeQuery = true)
    List<HoaDon> getHoaDonBy_status(@Param("trangThai") Integer trangThai);


    @Query(value = "select * from HoaDon where Ma =:maInput ",
            countQuery = "select * from HoaDon where Ma =:maInput", nativeQuery = true)
    HoaDon getHoaDonBy_ma(@Param("maInput") String maHoaDon);


    Page<HoaDon> findByMa(String ma, Pageable pageable);


    @SuppressWarnings("all")
    @Query("""
             select new com.example.duantn.record.OrderDetailRecord(
                 od.hoaDon.id,
                 od.hoaDon.ma,
                 product.ten,
                 cast(pd.giaTriSanPham as double),
                 cast(od.soLuong as int),
                 cast(od.soLuong * pd.giaTriSanPham as double))
             from HoaDonChiTiet od
             left join od.hoaDon hoaDon
             left join od.chiTietSanPham pd
             left join pd.sanPham product
             where od.hoaDon.id = :orderId
             order by od.ngayTao desc
            """)
    List<OrderDetailRecord> findByOrderId(UUID orderId);

    // hoan code
    // cap nhat idKhachHang, voi idHoaDon tương ứng
    @Transactional
    @Modifying
    @Query(value = "update HoaDon set IdKhachHang=:idKhachHang " +
            "where Id =:idHoaDon"
            , nativeQuery = true)
    void capNhatThonTinHoaDon_voiThongTinKhachHang(
            @Param("idHoaDon") UUID idHoaDon,
            @Param("idKhachHang") UUID idKhachHang
    );

    // xoa hoa don cho theo idHoaDon
    @Transactional
    @Modifying
    @Query(value = "delete from HoaDon where id=:idHoaDon", nativeQuery = true)
    void xoaHoaDonCho_bangIdHoaDon(@Param("idHoaDon") UUID idHoaDon);

    //
    @Transactional
    @Modifying
    @Query(value = "Update HoaDon set IdPhieuGiamGia =:idPhieuGiamGia where Id=:idHoaDon"
            , nativeQuery = true)
    void capNhatHoaDon_apDungPhieuGiamGiaNao(
            @Param("idHoaDon") UUID idHoaDon,
            @Param("idPhieuGiamGia") UUID idPhieuGiamGia
    );

    // Tiến Sỹ - Admin thống kê tổng thu, hoa hồng từ khóa học, Doanh thu quang cáo
    @Query(value = "EXEC ADTKDoanhThu :DieuKien", nativeQuery = true)
    List<Map<String, Object>> ADTKDoanhThu(String DieuKien);

    @Query("SELECT h FROM HoaDon h WHERE (h.ma LIKE %:ma%) " +
            "AND (h.hinhThucTT LIKE %:hinhThucTT%) " +
            "AND (h.trangThai LIKE %:trangThai%) " +
            "AND ((:startDate is null and :endDate is null and true) or (:startDate is not null and h.ngayMua >= :startDate)) " +
            "AND (:endDate is null or h.ngayMua <= :endDate) ORDER BY h.ngaySua DESC")
    Page<HoaDon> customSearch(
            @Param("ma") String ma,
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate,
            @Param("hinhThucTT") String hinhThucThanhToan,
            @Param("trangThai") String trangThai,
            Pageable pageable
    );

    @Query("SELECT h FROM HoaDon h ORDER BY h.ngaySua DESC")
    Page<HoaDon> searchAll(
            Pageable pageable
    );
}
