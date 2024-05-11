package com.example.duantn.service.impl;

import com.example.duantn.model.MuiGiay;
import com.example.duantn.model.SanPham;
import com.example.duantn.repository.SanPhamRepository;
import com.example.duantn.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements BaseService<SanPham> {

    @Autowired
    SanPhamRepository sanPhamRepository;


    @Override
    public Page<SanPham> layDanhSach(Pageable pageable) {
        return sanPhamRepository.findAll(pageable);
    }

    @Override
    public Page<SanPham> layDanhSach(String textSearch, Pageable pageable) {
        if (textSearch != null && !textSearch.isEmpty()) {
            return sanPhamRepository.findByTenContainingIgnoreCase(textSearch, pageable);
        } else {
            return sanPhamRepository.getAllSanPham_phanTrang(pageable);
        }
    }

    public Page<SanPham> layDanhSachTheoTrangThai(int trangThai, Pageable pageable) {
        return sanPhamRepository.findByTrangThai(trangThai, pageable);
    }

    public List<SanPham> layDanhSachTheoTen(String ten) {
        return sanPhamRepository.findByTen(ten);
    }

    @Override
    public List<SanPham> layDanhSach() {
        return sanPhamRepository.getAll();
    }

    @Override
    public void xoa(UUID id) {
        sanPhamRepository.deleteById(id);
    }

    @Override
    public void themMoi(SanPham entity) {
        sanPhamRepository.save(entity);
    }

    @Override
    public void capNhat(SanPham entity) {
         sanPhamRepository.save(entity);
    }

    @Override
    public SanPham chiTietTheoId(UUID id) {
        Optional<SanPham> optionalSanPham = sanPhamRepository.findById(id);
        return optionalSanPham.orElse(null);
    }

    public Boolean kiemTraTrungTenKhong(String tenMoi, String tenCu) {
        List<SanPham> dsSanPham = layDanhSach();
        boolean isCheck = false;
        boolean isCheck2 = true;

        for (SanPham sanPham : dsSanPham) {
            if (sanPham.getTen().equalsIgnoreCase(tenMoi.trim())) {
                isCheck = true;
            }
        }

        if (tenMoi.trim().equalsIgnoreCase(tenCu)) {
            isCheck2 = false;
        }

        return isCheck && isCheck2;
    }

    public Boolean kiemTraTrungTenKhong(String tenCheck) {
        List<SanPham> dsSanPham =  layDanhSach();
        boolean isCheck = false;

        for (SanPham sanPham : dsSanPham) {
            if (sanPham.getTen().equalsIgnoreCase(tenCheck.trim())) {
                isCheck = true;
            }
        }
        return isCheck;
    }

    public Boolean kiemTraTrungMaKhong(String maCkeck) {
        List<SanPham> dsSanPham = layDanhSach();
        boolean isCheck = false;

        for (SanPham sanPham : dsSanPham) {
            if (sanPham.getMa().equalsIgnoreCase(maCkeck.trim())) {
                isCheck = true;
            }
        }
        return isCheck;
    }

    public Boolean kiemTraTrungMaKhong(String maMoi, String maCu){
        List<SanPham> dsSanPham =  this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ma moi co trung voi cac ma khac khong
        for(SanPham sanPham : dsSanPham){
            if(sanPham.getMa().equalsIgnoreCase(maMoi.trim())){
                isCheck = true;
                break;
            }
        }

        // kiem tra xem ma moi co bang ma cu khong
        if(maMoi.trim().equalsIgnoreCase(maCu)){
            isCheck2 = false;
        }

        return isCheck&&isCheck2 ;
    }


    public Page<SanPham> layDanhSachSanPhamPhanTrang(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return sanPhamRepository.findAll(pageable);
    }

    public List<SanPham> layDanhSachSanPhamApDungMaGiamGia(UUID idDotKhuyenMai) {
        return sanPhamRepository.findByDotKhuyenMaiId(idDotKhuyenMai);
    }
    public List<SanPham> getSanPhamByIdKM(UUID id) {
        return sanPhamRepository.getSanPhamByMaIdKM(id);
    }

}
