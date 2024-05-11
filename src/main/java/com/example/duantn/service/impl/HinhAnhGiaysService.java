package com.example.duantn.service.impl;

import com.example.duantn.model.HinhAnhGiays;
import com.example.duantn.repository.HinhAnhGiaysRepository;
import com.example.duantn.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HinhAnhGiaysService implements BaseService<HinhAnhGiays> {
    @Autowired
    HinhAnhGiaysRepository repo_hinhAnhGiays;

//    getListHinhAnhGiay_theoIDSanPhamCT
    public List<HinhAnhGiays> layDanhSachHinhAnhGiayTheo_idSanPhamChiTiet(UUID idSanPhamCT){
        return  repo_hinhAnhGiays.getListHinhAnhGiay_theoIDSanPhamCT(idSanPhamCT);
    }

    @Override
    public Page<HinhAnhGiays> layDanhSach(Pageable pageable) {
        return null;
    }

    @Override
    public Page<HinhAnhGiays> layDanhSach(String textSearch, Pageable pageable) {
        return null;
    }

    @Override
    public void xoa(UUID id) {

    }

    public void xoaTheoIdSanPhamCT(UUID idSanPhamCT){
        repo_hinhAnhGiays.xoaHinhAnhTheoIdSanPhamCT(idSanPhamCT);
    }

    @Override
    public void themMoi(HinhAnhGiays entity) {
        repo_hinhAnhGiays.save(entity);
    }


    @Override
    public void capNhat(HinhAnhGiays entity) {
        repo_hinhAnhGiays.save(entity);
    }

    @Override
    public HinhAnhGiays chiTietTheoId(UUID id) {
        return null;
    }

    @Override
    public List<HinhAnhGiays> layDanhSachTheoTen(String ten) {
        return null;
    }

    @Override
    public List<HinhAnhGiays> layDanhSach() {
        return null;
    }
}
