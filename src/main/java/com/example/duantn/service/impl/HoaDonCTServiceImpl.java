package com.example.duantn.service.impl;

import com.example.duantn.model.HoaDon;
import com.example.duantn.model.HoaDonChiTiet;
import com.example.duantn.record.OrderDetailRecord;
import com.example.duantn.repository.HoaDonCTRepository;
import com.example.duantn.repository.HoaDonRepository;
import com.example.duantn.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HoaDonCTServiceImpl implements BaseService<HoaDonChiTiet> {
    @Autowired
    HoaDonCTRepository hoaDonCTRepository;
    @Autowired
    private HoaDonRepository hoaDonRepository;

    // hoan code
        public Integer getSoLuongSanPhamTrongHoaDonCT(UUID idHoaDon, UUID idSanPham){
            Integer soLuong = hoaDonCTRepository.getSoLuongSanPham_trongHoaDonCT(idHoaDon, idSanPham);
            return  soLuong;
        }

        public Page<HoaDonChiTiet> layDanhSachHoaDonChiTiet_va_PhanTrang(UUID idHoaDon, Pageable pageable){
            return hoaDonCTRepository.getListHoaDonChiTiet_theoIdHoaDon_phanTrang(idHoaDon, pageable);
        }

        // cập nhật số lượng sản phẩm trong hóa đơn chi tiết
        public void capNhatSoLuongSanPhamMua_HDCT(UUID idHoaDon, UUID idSanPhamCT, Integer soLuongMua){
             hoaDonCTRepository.capNhatSoLuongSanPhamTrong_HoaDonChiTiet(idHoaDon, idSanPhamCT, soLuongMua);
        }

        public void capNhatSoLuongSanPhamMua_HDCT_taiQuay(UUID idHoaDon, UUID idSanPhamCT, Integer soLuongMua){
            hoaDonCTRepository.capNhatSoLuongSanPhamTrong_HoaDonChiTiet_muaTaiQuay(idHoaDon, idSanPhamCT, soLuongMua);
        }

        public HoaDonChiTiet themMoi2(HoaDonChiTiet entity) {
            return hoaDonCTRepository.save(entity);
        }

        // lay danh sach hoa don chi tiet theo idHoaDon
        public List<HoaDonChiTiet> layDanhSachHoaDonChiTiet_theoIdHoaDon(UUID idHoaDon){
            return hoaDonCTRepository.getListHoaDonChiTiet_theoIdHoaDon(idHoaDon);
        }

        @Override
        public Page<HoaDonChiTiet> layDanhSach(Pageable pageable) {
            return hoaDonCTRepository.findAll(pageable);
        }

        @Override
        public List<HoaDonChiTiet> layDanhSach() {
            return hoaDonCTRepository.getAll();
        }

        public void xoaSanPhamCTKhoiHoaDonChiTiet(UUID idHoaDon, UUID idSanPhamCT){
            hoaDonCTRepository.xoaSanPhamKhoiHoaDonCT_byIdHoaDon_IdSanPhamCT(idHoaDon, idSanPhamCT);
        }

        public void xoaHoaDonChiTietBangIDHoaDon(UUID idHoaDon){
            hoaDonCTRepository.xoaHoaDonChiTiet_bangIdHoaDon(idHoaDon);
        }

        public HoaDonChiTiet xemHoaDonChiTiet_detail(UUID idHoaDon, UUID idSanPhamCT){
           return hoaDonCTRepository.getHoaDonChiTietTheo_idHoaDon_IdSPCT(idHoaDon, idSanPhamCT);
        }


    // hoan code



    @Override
    public Page<HoaDonChiTiet> layDanhSach(String textSearch, Pageable pageable) {
        return null;
    }



    @Override
    public void xoa(UUID id) {

    }


    @Override
    public void themMoi(HoaDonChiTiet entity) {
        hoaDonCTRepository.save(entity);
    }




    @Override
    public void capNhat( HoaDonChiTiet hoaDonChiTiet) {
         hoaDonCTRepository.save(hoaDonChiTiet);
    }

    public void capNhat(UUID id, HoaDonChiTiet entity) {
        HoaDonChiTiet hoaDon1 = hoaDonCTRepository.save(entity);
    }

    @Override
    public HoaDonChiTiet chiTietTheoId(UUID id) {
        return null;
    }

    public List<OrderDetailRecord> findByOrderId(UUID id) {
        return hoaDonRepository.findByOrderId(id);
    }

    public  List<HoaDonChiTiet> layDanhSachHoaDon_theoIdHoaDon(UUID idHoaDon){
//        return hoaDonRepository.getHoaDonBy_status(trangThai);
        return  hoaDonCTRepository.layDanhSachHoaDonCT_theoIDHoaDon(idHoaDon);
    }

    @Override
    public List<HoaDonChiTiet> layDanhSachTheoTen(String ten) {
        return null;
    }

    public void capNhatTrangThaiHDCT(UUID idHoaDon, String trangThai){
            hoaDonCTRepository.updateTrangThaiHoaDonCT(idHoaDon, trangThai);
    }


}
