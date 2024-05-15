package com.example.duantn.service;

import com.example.duantn.model.PhieuGiamGia;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface PhieuGiamGiaService {
    List<PhieuGiamGia> getAll();
    void delete(UUID id);
    void add(PhieuGiamGia phieuGiamGia);
    PhieuGiamGia detail(UUID id);
    PhieuGiamGia update(UUID id,PhieuGiamGia phieuGiamGia);
    PhieuGiamGia chiTietTheoId(UUID id) ;
}
