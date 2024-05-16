package com.example.duantn.repository;

import com.example.duantn.model.ChucVu;
import com.example.duantn.model.HoaDon;
import com.example.duantn.model.HoaDonChiTiet;
import com.example.duantn.record.OrderDetailRecord;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public interface HoaDonCTRepository extends JpaRepository<HoaDonChiTiet, UUID> {
    @Query(value = "select * from HoaDonCT ",nativeQuery = true)
    List<HoaDonChiTiet> getAll();
    List<HoaDonChiTiet> findByHoaDon(HoaDon hoaDon);
    // hoan code
        //            countQuery = "select * from HoaDon where Ma =:maInput", nativeQuery = true)
        //    HoaDon getHoaDonBy_ma(@Param("maInput") Strin        //    @Query(value = "select * from HoaDon where Ma =:maInput ",g maHoaDon);
            @Query(value = "select sum(soLuong) from HoaDonCT where IdHoaDon =:idHoaDon " +
                            "and IdSanPhamCT =:idSanPhamCT"
                             , nativeQuery = true)
            Integer getSoLuongSanPham_trongHoaDonCT(@Param("idHoaDon") UUID idHoaDon, @Param("idSanPhamCT") UUID idSanPhamCT );

            // cap nhat so luong san pham trong hoa don chi tiet
            @Transactional
            @Modifying
            @Query(value = "update HoaDonCT set SoLuong = SoLuong + :soLuongMuaThem where IdHoaDon =:idHoaDon and IdSanPhamCT =:idSanPhamCT"
                    , nativeQuery = true)
            void capNhatSoLuongSanPhamTrong_HoaDonChiTiet(
                    @Param("idHoaDon") UUID idHoaDon ,
                    @Param("idSanPhamCT") UUID idSanPhamCT,
                    @Param("soLuongMuaThem") Integer soLuongMuaThem);

            @Transactional
            @Modifying
            @Query(value = "update HoaDonCT set SoLuong =:soLuongMuaThem where IdHoaDon =:idHoaDon and IdSanPhamCT =:idSanPhamCT"
                    , nativeQuery = true)
            void capNhatSoLuongSanPhamTrong_HoaDonChiTiet_muaTaiQuay(
                    @Param("idHoaDon") UUID idHoaDon ,
                    @Param("idSanPhamCT") UUID idSanPhamCT,
                    @Param("soLuongMuaThem") Integer soLuongMuaThem);


            @Query(value = "select * from HoaDonCT where IdHoaDon =:idHoaDon"
                    , nativeQuery = true)
            List<HoaDonChiTiet> getListHoaDonChiTiet_theoIdHoaDon(@Param("idHoaDon") UUID idHoaDon);

        @Query(value = "select * from HoaDonCT where IdHoaDon =:idHoaDon ",
            countQuery = "select count(*) from HoaDonCT where IdHoaDon =:idHoaDon", nativeQuery = true)
    Page<HoaDonChiTiet> getListHoaDonChiTiet_theoIdHoaDon_phanTrang(@Param("idHoaDon") UUID idHoaDon,
                                                                    Pageable pageable);

    @Query(value = "select * from HoaDonCT where IdHoaDon =:idHoaDon and IdSanPhamCT=:idSanPhamCT ", nativeQuery = true)
    HoaDonChiTiet getHoaDonChiTietTheo_idHoaDon_IdSPCT(@Param("idHoaDon") UUID idHoaDon
            ,@Param("idSanPhamCT") UUID idSanPhamCT);

        @Transactional
        @Modifying
        @Query(value = "delete from HoaDonCT where IdHoaDon =:idHoaDon and IdSanPhamCT =:idSanPhamCT"
                , nativeQuery = true)
        void xoaSanPhamKhoiHoaDonCT_byIdHoaDon_IdSanPhamCT(
                @Param("idHoaDon") UUID idHoaDon ,
                @Param("idSanPhamCT") UUID idSanPhamCT);

        @Transactional
        @Modifying
        @Query(value = "delete from HoaDonCT where IdHoaDon=:idHoaDon", nativeQuery = true)
        void xoaHoaDonChiTiet_bangIdHoaDon(@Param("idHoaDon") UUID idHoaDon );

    // hoan code

    @Query(value = "select * from HoaDonCT where IdHoaDon =:idHoaDon order by NgayTao asc ",
            countQuery = "select * from HoaDonCT where IdHoaDon =:idHoaDon", nativeQuery = true)
    List<HoaDonChiTiet> layDanhSachHoaDonCT_theoIDHoaDon(@Param("idHoaDon") UUID idHoaDon);


    @Query(value = "select * from HoaDon where Ma =:maInput ", countQuery = "select * from HoaDon where Ma =:maInput", nativeQuery = true)
    HoaDon getHoaDonBy_ma(@Param("maInput") String maHoaDon);

    @Transactional
    @Modifying
    @Query(value = "update HoaDonCT\n" +
            "set TrangThai=:trangThaiNew \n" +
            "where IdHoaDon = :idHoaDon", nativeQuery = true)
    public void updateTrangThaiHoaDonCT( @Param("idHoaDon") UUID idHoaDon, @Param("trangThaiNew") String trangThaiNew);

    ///


}

