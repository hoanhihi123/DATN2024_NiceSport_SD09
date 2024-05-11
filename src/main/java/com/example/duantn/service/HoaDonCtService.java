package com.example.duantn.service;

import com.example.duantn.model.HoaDonChiTiet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface HoaDonCtService {
    List<HoaDonChiTiet> getAll();
    void delete(UUID id);
    void add(HoaDonChiTiet hoaDonCT);
    HoaDonChiTiet detail(UUID id);
    HoaDonChiTiet update(UUID id,HoaDonChiTiet hoaDonCT);

}
