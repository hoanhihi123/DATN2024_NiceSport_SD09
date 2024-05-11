//package com.example.duantn.service.impl;
//
//import com.example.duantn.model.ChiTietSanPham;
//import com.example.duantn.repository.SanPhamCTRepository;
//import com.example.duantn.service.SanPhamCTService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.UUID;
//
//@Service
//public class SanPhamCTServiceImpl implements SanPhamCTService {
//    @Autowired
//    SanPhamCTRepository sanPhamCTRepository;
//
//    @Override
//    public List<ChiTietSanPham> getAll() {
//        return sanPhamCTRepository.getAll();
//    }
//
//    @Override
//    public void delete(UUID id) {
//        sanPhamCTRepository.deleteById(id);
//
//    }
//
//
//
//    @Override
//    public void add(ChiTietSanPham sanPhamCT) {
//        sanPhamCTRepository.save(sanPhamCT);
//
//    }
//
//    @Override
//    public ChiTietSanPham detail(UUID id) {
//        ChiTietSanPham sanPhamCT = sanPhamCTRepository.findById(id).get();
//        return sanPhamCT;
//    }
//
//
//    @Override
//    public ChiTietSanPham update(UUID id, ChiTietSanPham sanPhamCT) {
//        ChiTietSanPham sanPhamCT1 = sanPhamCTRepository.save(sanPhamCT);
//        return sanPhamCT1;
//    }
//}
