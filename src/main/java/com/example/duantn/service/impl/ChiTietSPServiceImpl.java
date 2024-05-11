package com.example.duantn.service.impl;

import com.example.duantn.model.*;
import com.example.duantn.repository.ChiTietSanPhamRepository;
import com.example.duantn.repository.LoaiSanPhamRepository;
import com.example.duantn.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChiTietSPServiceImpl implements BaseService<ChiTietSanPham> {
    public List<ChiTietSanPham> timKiemSanPhamCT_taiQuay(Pageable pageable, Map<String,String> keyWork){
      return repo_chiTietSanPham.timKiemSanPhamCT_taiQuayNhieuDieuKien(pageable, keyWork);
    }

//    public List<ChiTietSanPham> danhSachSanPhamTimKiem(
//            UUID idKichCo,
//            UUID idLoaiSP,
//            UUID idMauSac,
//            String tenSP
//    ){
//        System.out.println("Chạy vào service thực thi hàm lấy danhSachSanPhamTimKiem");
//        System.out.println("ID kích cỡ : " + idKichCo);
//        System.out.println("idLoaiSP : " + idLoaiSP);
//        System.out.println("idMauSac : " + idMauSac);
//        System.out.println("tenSanPham : " + tenSP);
//        return repo_chiTietSanPham.timKiemSanPhamTaiQuay(idKichCo, idLoaiSP, idMauSac, tenSP);
//    }
        public List<ChiTietSanPham> danhSachSanPhamTimKiem(
                Map<String,String> keyWork
    ){
        return repo_chiTietSanPham.timKiemSanPhamTaiQuay(keyWork);
    }

    public Page<ChiTietSanPham> danhSachSanPhamTimKiem_phanTrang(
            Map<String,String> keyWork,
            Pageable pageable
    ){
        return repo_chiTietSanPham.timKiemSanPhamTaiQuay_phanTrang(keyWork,pageable);
    }

    public List<ChiTietSanPham> locSanPhamChiTiet_layDanhSachSPCT(
            List<String> tenLoaiGiay, List<String> tenSizeGiay, List<String> tenMauSac
    ){
        return repo_chiTietSanPham.locSanPhamTaiBanHangOnline(tenLoaiGiay, tenSizeGiay, tenMauSac);
    }

    public Page<ChiTietSanPham> locSanPhamChiTiet_layDanhSachSPCT_phanTrang(
            List<String> tenLoaiGiay, List<String> tenSizeGiay, List<String> tenMauSac , Pageable pageable
    ){
        return repo_chiTietSanPham.locSanPhamTaiBanHangOnline_phanTrang(tenLoaiGiay, tenSizeGiay, tenMauSac, pageable);
    }

    public void capNhatGiaTriGiamNull(){
        repo_chiTietSanPham.capNhatCacGiaTriSP_isNull();
    }
    @Autowired
    ChiTietSanPhamRepository repo_chiTietSanPham;

    @Autowired
    LoaiSanPhamRepository repo_loaiSanPham;

    @Override
    public Page<ChiTietSanPham> layDanhSach(Pageable pageable) {
        return repo_chiTietSanPham.getAll(pageable);
    }

    public List<ChiTietSanPham> layDanhSachTheoIDSanPham(UUID idSanPham) {
        return repo_chiTietSanPham.getAll(idSanPham);
    }

    public List<ChiTietSanPham> layDanhSachTheoIDSanPham_searchTrangThai(Integer trangThai, UUID idSanPham) {
        return repo_chiTietSanPham.getAllTheoTrangThai(idSanPham, trangThai);
    }


    @Override
    public Page<ChiTietSanPham> layDanhSach(String textSearch, Pageable pageable) {
        if(textSearch!=null){
            return repo_chiTietSanPham.getAll(textSearch, pageable);
        }

        return repo_chiTietSanPham.getAll(pageable);
    }



    @Override
    public void xoa(UUID id) {
        repo_chiTietSanPham.updateTrangThaiSanPhamCT(id);
    }

    public void capNhatTrangThaiSanPhamCT(UUID id) {
        repo_chiTietSanPham.updateTrangThaiSanPhamCT(id);
    }

    @Override
    public void themMoi(ChiTietSanPham entity) {
        repo_chiTietSanPham.save(entity);
    }

    public ChiTietSanPham themMoi_traVeKetQua(ChiTietSanPham chiTietSanPham) {
        return repo_chiTietSanPham.save(chiTietSanPham);
    }

    public ChiTietSanPham capNhat_traVeKetQua(ChiTietSanPham chiTietSanPham) {
        return repo_chiTietSanPham.save(chiTietSanPham);
    }

    @Override
    public void capNhat(ChiTietSanPham entity) {
        repo_chiTietSanPham.save(entity);
    }

    @Override
    public ChiTietSanPham chiTietTheoId(UUID id) {
        return repo_chiTietSanPham.findById(id).orElse(null);
    }

    @Override
    public List<ChiTietSanPham> layDanhSachTheoTen(String ten) {
        return null;
    }

    @Override
    public List<ChiTietSanPham> layDanhSach() {
        return repo_chiTietSanPham.getAll();
    }

    public void capNhatSoLuongSauKhiDatHang(Integer soLuongMua, UUID idChiTietSP) {
        repo_chiTietSanPham.updateSoLuong(soLuongMua, idChiTietSP);
    }

    public  List<LoaiSanPham> layTatCa_idLoaiSP_distinct_trongChiTietSP(){
        List<UUID> dsId_loaiSP = new ArrayList<>();
        List<LoaiSanPham> dsLoaiSanPham = new ArrayList<>();
        dsId_loaiSP = repo_chiTietSanPham.getAllLoaiSanPham_coTrongChiTietSP();
        dsLoaiSanPham = repo_loaiSanPham.findAll();

        List<LoaiSanPham> dsLoaiSanPhamNew = new ArrayList<>();
        for(LoaiSanPham x : dsLoaiSanPham){
            for(UUID id : dsId_loaiSP){
                if(id.equals(x.getId())){
                    dsLoaiSanPhamNew.add(x);
                }
            }
        }

        return dsLoaiSanPhamNew;
    }

    public  List<ChiTietSanPham> layDanhSachSanPham_soLuongLonHon_0(Pageable pageable){
        return (List<ChiTietSanPham>) repo_chiTietSanPham.getAllProductLonHon_0(pageable);
    }


    // getListIDMauSacFromSanPhamChiTiet_byIdSanPham
    public  List<UUID> layDanhSachIDMauSacTuSanPhamCT_bangIdSanPham(UUID idSanPham){
        return repo_chiTietSanPham.getListIDMauSacFromSanPhamChiTiet_byIdSanPham(idSanPham);
    }

    // getListSanPhamChiTietTheo_idSanPham
    public  List<ChiTietSanPham> layDanhSachSPCT_theoIDSanPham(UUID idSanPham){
        return repo_chiTietSanPham.getListSanPhamChiTietTheo_idSanPham(idSanPham);
    }

    // getListSanPhamCT_theoIdMauSac_IdSanPham
    public  List<ChiTietSanPham> layDanhSachSPCT_theoIDSanPham_va_ID_mauSac(UUID idSanPham, UUID idMauSac){
        return repo_chiTietSanPham.getListSanPhamCT_theoIdMauSac_IdSanPham(idSanPham,idMauSac);
    }

    // getListUUID_SanPham_fromChiTietSP
    public  List<UUID> layDanhSach_IdSanPham_trongSanPhamCT(){
        return repo_chiTietSanPham.getListUUID_SanPham_fromChiTietSP();
    }

    // lay so luong trong kho bang idSanPhamChiTiet
    public Integer laySoLuongTrongKho(UUID idSanPhamCT){
        return  repo_chiTietSanPham.getSoLuong_byIdSanPhamChiTiet(idSanPhamCT);
    }

    public void xoaSanPhamChiTietTheoTrangThai(Integer trangThai){
        repo_chiTietSanPham.xoaSanPhamChiTietTheoTrangThai(trangThai);
    }


}
