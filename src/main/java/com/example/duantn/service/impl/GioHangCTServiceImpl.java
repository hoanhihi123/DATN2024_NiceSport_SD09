//package com.example.duantn.service.impl;
//
//import com.example.duantn.Model.GioHang;
//import com.example.duantn.Model.GioHangCT;
//import com.example.duantn.Repository.GioHangCTRepository;
//import com.example.duantn.Service.BaseService;
//import com.example.duantn.service.BaseService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//@Service
//public class GioHangCTServiceImpl implements BaseService<GioHangCT> {
//    @Autowired
//    GioHangCTRepository gioHangCTRepository;
//    @Override
//    public List<GioHangCT> layDanhSach() {
//        return gioHangCTRepository.getAll();
//    }
//
//    @Override
//    public Page<GioHangCT> layDanhSach(Pageable pageable) {
//        return gioHangCTRepository.getAll(pageable);
//    }
//
//    @Override
//    public Page<GioHangCT> layDanhSach(String textSearch, Pageable pageable) {
//        if(textSearch!=null){
//            return gioHangCTRepository.getAll(textSearch, pageable);
//        }
//        return gioHangCTRepository.getAll(pageable);
//    }
//
//    @Override
//    public void xoa(UUID id) {
//        GioHangCT gioHangCTXoa = gioHangCTRepository.findById(id).get();
//        gioHangCTRepository.delete(gioHangCTXoa);
//    }
//
//    @Override
//    public void themMoi(GioHangCT entity) {
//        if(entity!=null){
//            gioHangCTRepository.save(entity);
//        }
//    }
//
//    @Override
//    public GioHangCT capNhat(GioHangCT entity) {
//        if(entity!=null){
//            return gioHangCTRepository.save(entity);
//        }
//        return null;
//    }
//
//    @Override
//    public GioHangCT chiTietTheoId(UUID id) {
//        Optional<GioHangCT> gioHangCT = gioHangCTRepository.findById(id);
//        GioHangCT gioHangCT1 = gioHangCT.get();
//        return gioHangCT1;
//    }
//
//    @Override
//    public List<GioHangCT> layDanhSachTheoTen(String ten) {
//        return  gioHangCTRepository.getAllTheoTen(ten);
//    }
//
//    public Boolean kiemTraTrungTenKhong(String tenMoi, String tenCu){
//        List<GioHangCT> dsGioHangCT = this.layDanhSach();
//        Boolean isCheck = false;
//        Boolean isCheck2 = true;
//
//        // kiem tra xem ten moi co trung voi cac ten khac khong
//        for(GioHangCT gioHangCT : dsGioHangCT){
//            if(gioHangCT.getTen().equalsIgnoreCase(tenMoi.trim())){
//                isCheck = true;
//                break;
//            }
//        }
//
//        // kiem tra xem ten moi co bang ten cu khong
//        if(tenMoi.trim().equalsIgnoreCase(tenCu)){
//            isCheck2 = false;
//        }
//
//        return isCheck&&isCheck2 ;
//    }
//
//    public Boolean kiemTraTrungTenKhong(String tenCheck){
//        List<GioHangCT> dsGioHangCT = this.layDanhSach();
//        Boolean isCheck = false;
//
//        // kiem tra xem ten moi co trung voi cac ten khac khong
//        for(GioHangCT gioHangCT : dsGioHangCT){
//            if(gioHangCT.getTen().equalsIgnoreCase(tenCheck.trim())){
//                isCheck = true;
//                break;
//            }
//        }
//        return isCheck ;
//    }
//
//    public Boolean kiemTraTrungMaKhong(String maCkeck){
//        List<GioHangCT> dsGioHangCT = this.layDanhSach();
//        Boolean isCheck = false;
//
//        // kiem tra xem ten moi co trung voi cac ten khac khong
//        for(GioHangCT gioHangCT : dsGioHangCT){
//            if(gioHangCT.getMa().equalsIgnoreCase(maCkeck.trim())){
//                isCheck = true;
//            }
//        }
//        return isCheck ;
//    }
//
//    public Boolean kiemTraTrungMaKhong(String maMoi, String maCu){
//        List<GioHangCT> dsGioHangCT = this.layDanhSach();
//        Boolean isCheck = false;
//        Boolean isCheck2 = true;
//
//        // kiem tra xem ten moi co trung voi cac ten khac khong
//        for(GioHangCT gioHangCT : dsGioHangCT){
//            if(gioHangCT.getMa().equalsIgnoreCase(maMoi.trim())){
//                isCheck = true;
//            }
//        }
//
//        // kiem tra xem ten moi co bang ten cu khong
//        if(maMoi.trim().equalsIgnoreCase(maCu)){
//            isCheck2 = false;
//        }
//
//        return isCheck&&isCheck2 ;
//    }
//
//}
//
