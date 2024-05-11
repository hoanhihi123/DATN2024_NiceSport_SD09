package com.example.duantn.service.impl;

import com.example.duantn.model.DanhMuc;
import com.example.duantn.repository.DanhMucRepository;
import com.example.duantn.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DanhMucServiceImpl implements BaseService<DanhMuc> {
    @Autowired
    DanhMucRepository repo_danhMuc;

    public List<DanhMuc> layDanhSach() {
        return repo_danhMuc.getAll();
    }

    @Override
    public Page<DanhMuc> layDanhSach(Pageable pageable) {
        return repo_danhMuc.getAll(pageable);
    }

    @Override
    public Page<DanhMuc> layDanhSach(String textSearch, Pageable pageable) {
        if(textSearch!=null){
            return repo_danhMuc.getAll(textSearch, pageable);
        }
        return repo_danhMuc.getAll(pageable);
    }

    @Override
    public void xoa(UUID id) {
        DanhMuc DanhMucXoa = repo_danhMuc.findById(id).get();
        repo_danhMuc.delete(DanhMucXoa);
    }

    @Override
    public void themMoi(DanhMuc entity) {
        if(entity!=null){
            repo_danhMuc.save(entity);
        }
    }

    @Override
    public void capNhat(DanhMuc entity) {
        if(entity!=null){
             repo_danhMuc.save(entity);
        }
    }

    @Override
    public DanhMuc chiTietTheoId(UUID id) {
        Optional<DanhMuc> danhMuc = repo_danhMuc.findById(id);
        DanhMuc danhMuc1 = danhMuc.get();
        return danhMuc1;
    }

    @Override
    public List<DanhMuc> layDanhSachTheoTen(String ten) {
        return null;
    }
    public Boolean kiemTraTrungTenKhong(String tenMoi, String tenCu) {
        List<DanhMuc> dsDanhMuc = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for (DanhMuc danhMuc : dsDanhMuc) {
            if (danhMuc.getTen().equalsIgnoreCase(tenMoi.trim())) {
                isCheck = true;
            }
        }

        // kiem tra xem ten moi co bang ten cu khong
        if (tenMoi.trim().equalsIgnoreCase(tenCu)) {
            isCheck2 = false;
        }

        return isCheck && isCheck2;
    }

    public Boolean kiemTraTrungTenKhong(String tenCheck) {
        List<DanhMuc> dsDanhMuc = this.layDanhSach();
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for (DanhMuc danhMuc : dsDanhMuc)  {
            if (danhMuc.getTen().equalsIgnoreCase(tenCheck.trim())) {
                isCheck = true;
                break;
            }
        }
        return isCheck;
    }

    public Boolean kiemTraTrungMaKhong(String maCkeck) {
        List<DanhMuc> dsDanhMuc = repo_danhMuc.getAllTheoMa(maCkeck);
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        if (dsDanhMuc.size() > 0) {
            isCheck = true;
        }
        return isCheck;
    }

    public Boolean kiemTraTrungMaKhong(String maMoi, String maCu) {
        List<DanhMuc> dsDanhMuc = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ma moi co trung voi cac ma khac khong
        for (DanhMuc danhMuc : dsDanhMuc) {
            if (danhMuc.getMa().equalsIgnoreCase(maMoi.trim())) {
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
}

