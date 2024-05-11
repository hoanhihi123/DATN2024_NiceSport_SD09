package com.example.duantn.service.impl;

import com.example.duantn.model.ChucVu;
import com.example.duantn.repository.ChucVuRepository;
import com.example.duantn.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChucVuServiceImpl implements BaseService <ChucVu> {
    @Autowired
    ChucVuRepository repo_chucVu;

    public List<ChucVu> layDanhSach() {
        return repo_chucVu.getAll();
    }

    @Override
    public Page<ChucVu> layDanhSach(Pageable pageable) {
        return repo_chucVu.getAll(pageable);
    }

    @Override
    public Page<ChucVu> layDanhSach(String textSearch, Pageable pageable) {
        if (textSearch != null) {
//            System.out.println("Chạy vào đây");
            return repo_chucVu.getAll(textSearch, pageable);
        }

        return repo_chucVu.getAll(pageable);
    }


    @Override
    public void xoa(UUID id) {
        ChucVu chucVu = repo_chucVu.findById(id).get();
        repo_chucVu.delete(chucVu);
    }

    @Override
    public void themMoi(ChucVu entity) {
        repo_chucVu.save(entity);
    }

    @Override
    public void capNhat(ChucVu entity) {
         repo_chucVu.save(entity);
    }

    @Override
    public ChucVu chiTietTheoId(UUID id) {
        Optional<ChucVu> chucVu = repo_chucVu.findById(id);
        ChucVu chucVu1 = chucVu.get();
        return chucVu1;
    }

    @Override
    public List<ChucVu> layDanhSachTheoTen(String ten) {
        return repo_chucVu.getAllTheoTen(ten);
    }

    public Boolean kiemTraTrungMaKhong(String maMoi, String maCu) {
        List<ChucVu> dsChucVu = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ma moi co trung voi cac ma khac khong
        for (ChucVu chucVu : dsChucVu) {
            if (chucVu.getMa().equalsIgnoreCase(maMoi.trim())) {
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
    public Boolean kiemTraTrungMaKhong(String maCkeck) {
        List<ChucVu> dsChucVu = repo_chucVu.getAllTheoMa(maCkeck);
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        if (dsChucVu.size() > 0) {
            isCheck = true;
        }
        return isCheck;
    }
    public Boolean kiemTraTrungTenKhong(String tenMoi, String tenCu) {
        List<ChucVu> dsChucVu = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for (ChucVu chucVu : dsChucVu) {
            if (chucVu.getTen().equalsIgnoreCase(tenMoi.trim())) {
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
        List<ChucVu> dsChucVu = this.layDanhSach();
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for (ChucVu chucVu : dsChucVu) {
            if (chucVu.getTen().equalsIgnoreCase(tenCheck.trim())) {
                isCheck = true;
                break;
            }
        }
        return isCheck;
    }
}

