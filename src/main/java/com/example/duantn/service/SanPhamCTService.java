package com.example.duantn.service;

import com.example.duantn.model.ChiTietSanPham;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface SanPhamCTService {
    List<ChiTietSanPham> getAll();
    void delete(UUID id);
    void add(ChiTietSanPham sanPhamCT);
    ChiTietSanPham detail(UUID id);
    ChiTietSanPham update(UUID id,ChiTietSanPham sanPhamCT);
}
