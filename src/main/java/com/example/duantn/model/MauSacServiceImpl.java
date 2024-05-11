//package com.example.duantn.model;
//
//import com.example.duantn.repository.MauSacRepository;
//import com.example.duantn.service.BaseService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.UUID;
//
//@Service
//public class MauSacServiceImpl implements BaseService<MauSac> {
//    @Autowired
//    MauSacRepository repo_mauSac;
//
//    @Override
//    public List<MauSac> layDanhSach() {
//        return repo_mauSac.getAll();
//    }
//
//    @Override
//    public Page<MauSac> layDanhSach(Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public Page<MauSac> layDanhSach(String textSearch, Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public void xoa(UUID id) {
//
//    }
//
//    @Override
//    public void themMoi(MauSac entity) {
//
//    }
//
//    @Override
//    public MauSac capNhat(MauSac entity) {
//        return null;
//    }
//
//    @Override
//    public MauSac chiTietTheoId(UUID id) {
//        return null;
//    }
//
//    @Override
//    public List<MauSac> layDanhSachTheoTen(String ten) {
//        return null;
//    }
//}
