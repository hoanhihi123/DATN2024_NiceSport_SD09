package com.example.duantn.service.impl;


import com.example.duantn.model.ChucVu;
import com.example.duantn.model.LoaiSanPham;
import com.example.duantn.model.NhanVien;
import com.example.duantn.repository.LoaiSanPhamRepository;
import com.example.duantn.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoaiSanPhamServiceImpl implements BaseService<LoaiSanPham> {
    @Autowired
    LoaiSanPhamRepository repo_loaiSanPham;

    public List<LoaiSanPham> layDanhSach() {
        return repo_loaiSanPham.getAll();
    }

    public LoaiSanPham chiTietTheoId(UUID id) {
        Optional<LoaiSanPham> loaiSanPham = repo_loaiSanPham.findById(id);
        LoaiSanPham loaiSanPham1 = loaiSanPham.get();
        return loaiSanPham1;
    }

    @Override
    public List<LoaiSanPham> layDanhSachTheoTen(String ten) {
        return repo_loaiSanPham.getAllTheoTen(ten);
    }

    @Override
    public Page<LoaiSanPham> layDanhSach(Pageable pageable) {
        return repo_loaiSanPham.getAll(pageable);
    }

    public Page<LoaiSanPham> layDanhSach(String textSearch, Pageable pageable) {
        if (textSearch != null){
            return repo_loaiSanPham.getAll(textSearch, pageable);
        }
        return repo_loaiSanPham.getAll(pageable);
    }

    @Override
    public void xoa(UUID id) {
        LoaiSanPham LoaiSanPhamXoa = repo_loaiSanPham.findById(id).get();
        repo_loaiSanPham.delete(LoaiSanPhamXoa);
    }

    @Override
    public void themMoi(LoaiSanPham entity) {
        if(entity!=null){
            repo_loaiSanPham.save(entity);
        }
    }

    @Override
    public void capNhat(LoaiSanPham entity) {
        if(entity!=null){
            repo_loaiSanPham.save(entity);
        }
    }

    public boolean kiemTraTrungMaKhong(String maMoi, String maCu) {
        List<LoaiSanPham> dsLoaiSanPham = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;
        // kiem tra xem ma moi co trung voi cac ma khac khong
        for (LoaiSanPham loaiSanPham : dsLoaiSanPham) {
            if (loaiSanPham.getMa().equalsIgnoreCase(maMoi.trim())) {
                isCheck = true;
                break;
            }
        }

        // kiem tra xem ma moi co bang ma cu khong
        if (maMoi.trim().equalsIgnoreCase(maCu)) {
            isCheck2 = false;
        }

        return isCheck && isCheck2;
    }

    public boolean kiemTraTrungTenKhong(String tenMoi, String tenCu) {
        List<LoaiSanPham> dsLoaiSanPham = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;
        // kiem tra xem ma moi co trung voi cac ma khac khong
        for (LoaiSanPham loaiSanPham : dsLoaiSanPham) {
            if (loaiSanPham.getTen().equalsIgnoreCase(tenMoi.trim())) {
                isCheck = true;

            }
        }

        // kiem tra xem ma moi co bang ma cu khong
        if (tenMoi.trim().equalsIgnoreCase(tenCu)) {
            isCheck2 = false;
        }

        return isCheck && isCheck2;
    }



    public boolean kiemTraTrungMaKhong(String maCkeck) {
        List<LoaiSanPham> dsLoaiSanPham = repo_loaiSanPham.getAllTheoMa(maCkeck);
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        if (dsLoaiSanPham.size() > 0) {
            isCheck = true;
        }
        return isCheck;
    }

    public boolean kiemTraTrungTenKhong(String tenCheck) {
        List<LoaiSanPham> dsLoaiSanPham = this.layDanhSach();
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for (LoaiSanPham loaiSanPham : dsLoaiSanPham) {
            if (loaiSanPham.getTen().equalsIgnoreCase(tenCheck.trim())) {
                isCheck = true;
                break;
            }
        }
        return isCheck;
    }




}