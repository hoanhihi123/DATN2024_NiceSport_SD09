package com.example.duantn.service;

import com.example.duantn.model.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface HoaDonService {
    List<HoaDon> getAll();
    void delete(UUID id);
    void add(HoaDon hoaDon);
    HoaDon detail(UUID id);
    HoaDon update(UUID id,HoaDon hoaDon);
    Page<HoaDon> searchByMa(String ma,Integer pageNum,Integer pageSize);
    Page<HoaDon> phanTrangHoaDon(Integer pageNum,Integer pageNo);

}
