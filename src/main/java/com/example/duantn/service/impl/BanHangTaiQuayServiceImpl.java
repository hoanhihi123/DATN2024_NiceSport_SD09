package com.example.duantn.service.impl;

import com.example.duantn.model.ChiTietSanPham;
import com.example.duantn.repository.ChiTietSanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BanHangTaiQuayServiceImpl  {
    @Autowired
    ChiTietSanPhamRepository repo_chiTietSP;

    public List<ChiTietSanPham> layDanhSach_sanPhamChiTiet(){
        return  repo_chiTietSP.getAll();
    }

    
}
