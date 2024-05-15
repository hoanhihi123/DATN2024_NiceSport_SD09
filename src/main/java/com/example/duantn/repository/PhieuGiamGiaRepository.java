package com.example.duantn.repository;

import com.example.duantn.model.ChiTietSanPham;
import com.example.duantn.model.NSX;
import com.example.duantn.model.PhieuGiamGia;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PhieuGiamGiaRepository extends JpaRepository<PhieuGiamGia, UUID> {

//- code hoan
//    @Query(value = "select * from PhieuGiamGia where soLuong > 0  and NgayKetThuc >= GETDATE() and NgayBatDau <= GETDATE()  ",nativeQuery = true)
//    List<PhieuGiamGia>getAll();
//
//    @Query(value = "select  count(*) from PhieuGiamGia where soLuong > 0  and NgayKetThuc >= GETDATE()",
//            countQuery = "select  count(*) from PhieuGiamGia where soLuong > 0  and NgayKetThuc >= GETDATE()", nativeQuery = true)
//    public Page<PhieuGiamGia> getAll(Pageable pageable);
//- code hoan

//- code duc anh
    @Query(value = "select * from PhieuGiamGia order by ngayTao desc", nativeQuery = true)
    public List<PhieuGiamGia> getAll();

    // getAll
    @Query(value = "select * from PhieuGiamGia order by ngaySua desc",
            countQuery = "select count(*) from PhieuGiamGia", nativeQuery = true)
    public Page<PhieuGiamGia> getAll(Pageable pageable);
//- code duc anh


    // hoan code
    @Query(value = "SELECT *\n" +
            "FROM PhieuGiamGia\n" +
            "where GiaTienXetDieuKien <= :tongTienDHang   and soLuong > 0  and NgayKetThuc >= GETDATE() and NgayBatDau <= GETDATE()  and trangThai=1 \n" +
            "ORDER BY \n" +
            "    CASE \n" +
            "        WHEN HinhThucGiam = N'tiền mặt' THEN GiaTriGiam\n" +
            "        WHEN HinhThucGiam = '%' THEN  ( :tongTienDHang * (GiaTriGiam  / 100))\n" +
            "\t\telse 0\n" +
            "    END desc;",nativeQuery = true)
    List<PhieuGiamGia>getAll_voiTongTien(@Param("tongTienDHang") Double tongTienDonHang);

    @Query(value = "SELECT *\n" +
            "FROM PhieuGiamGia\n" +
            "where  GiaTienXetDieuKien <= :tongTienDHang  and soLuong > 0 and NgayKetThuc >= GETDATE() and NgayBatDau <= GETDATE()  and trangThai=1 \n" +
            "ORDER BY \n" +
            "    CASE \n" +
            "        WHEN HinhThucGiam = N'tiền mặt' THEN GiaTriGiam\n" +
            "        WHEN HinhThucGiam = '%' THEN  ( :tongTienDHang * (GiaTriGiam  / 100))\n" +
            "\t\telse 0\n" +
            "    END desc;",
            countQuery = "SELECT count(*) FROM PhieuGiamGia where GiaTienXetDieuKien <= :tongTienDHang and soLuong > 0 and NgayKetThuc >= GETDATE() and NgayBatDau <= GETDATE()  and trangThai=1 ", nativeQuery = true)
    public Page<PhieuGiamGia> getAll_tongTienDonHang(Pageable pageable , @Param("tongTienDHang") Double tongTienDonHang);

//    @Query(value = "select  * from PhieuGiamGia " +
//                    "where Concat(PhieuGiamGia.ten) like %:textSearch%\n",
//            nativeQuery = true)
//    public Page<PhieuGiamGia> getAll(@Param("textSearch") String textSearch, Pageable pageable);
//
//    @Query(value = "select * from PhieuGiamGia where Ma =:textSearch  order by ten desc",
//            countQuery = "select count(*) from PhieuGiamGia where Ma =:textSearch ", nativeQuery = true)
//    public List<PhieuGiamGia> getAllTheoMa(@Param("textSearch") String textSearch);
//
//    @Query(value = "select * from PhieuGiamGia where Ten =:textSearch  order by ten desc",
//            countQuery = "select count(*) from PhieuGiamGia where Ten =:textSearch ", nativeQuery = true)
//    public List<PhieuGiamGia> getAllTheoTen(@Param("textSearch") String textSearch);

    // hoan them ngay 8/5
    @Transactional
    @Modifying
    @Query(value = "update PhieuGiamGia\n" +
            "set soLuong=:soLuongMoi \n" +
            "where Id=:idPhieuGiamGia", nativeQuery = true)
    public void updateSoLuongMoi_phieuGiamGia( @Param("idPhieuGiamGia") UUID idPhieuGiamGia, @Param("soLuongMoi") Integer soLuongMoi);


    @Query(value = "select  * from PhieuGiamGia where concat(Ma,TenPhieu) like %:textSearch% order by ngaySua desc",
            countQuery = "select  count(*) from PhieuGiamGia  where concat(Ma,TenPhieu) like  %:textSearch",
            nativeQuery = true)
    public Page<PhieuGiamGia> getAll(@Param("textSearch") String textSearch, Pageable pageable);

    @Query(value = "select * from PhieuGiamGia where Ma =:textSearch  order by TenPhieu desc",
            countQuery = "select count(*) from PhieuGiamGia where Ma =:textSearch ", nativeQuery = true)
    public List<PhieuGiamGia> getAllTheoMa(@Param("textSearch") String textSearch);

    @Query(value = "select * from PhieuGiamGia where TenPhieu =:textSearch  order by TenPhieu desc",
            countQuery = "select count(*) from PhieuGiamGia where TenPhieu =:textSearch ", nativeQuery = true)
    public List<PhieuGiamGia> getAllTheoTen(@Param("textSearch") String textSearch);
}
