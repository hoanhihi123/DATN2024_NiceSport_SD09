package com.example.duantn.service.impl;

import com.example.duantn.model.DiaChi;
import com.example.duantn.repository.DiaChiRepository;
import com.example.duantn.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DiaChiServiceImpl implements BaseService<DiaChi> {
    @Autowired
    DiaChiRepository diaChiRepository;

    public List<DiaChi> layDanhSach() {
        return diaChiRepository.getAll();
    }

    @Override
    public Page<DiaChi> layDanhSach(Pageable pageable) {
        return diaChiRepository.getAll(pageable);
    }

    @Override
    public Page<DiaChi> layDanhSach(String textSearch, Pageable pageable) {
        if (textSearch != null) {
            return diaChiRepository.getAll(textSearch, pageable);
        }
        return diaChiRepository.getAll(pageable);
    }

    @Override
    public void xoa(UUID id) {
        DiaChi DiaChiXoa = diaChiRepository.findById(id).get();
        diaChiRepository.delete(DiaChiXoa);
    }

    @Override
    public void themMoi(DiaChi entity) {
        if (entity != null) {
            diaChiRepository.save(entity);
        }
    }

    @Override
    public void capNhat(DiaChi entity) {
        if (entity != null) {
             diaChiRepository.save(entity);
        }
    }

    @Override
    public DiaChi chiTietTheoId(UUID id) {
        Optional<DiaChi> diaChi = diaChiRepository.findById(id);
        DiaChi diaChi1 = diaChi.get();
        return diaChi1;
    }

    @Override
    public List<DiaChi> layDanhSachTheoTen(String ten) {
        return diaChiRepository.getAllTheoTen(ten);
    }

    public Boolean kiemTraTrungTenKhong(String tenMoi, String tenCu) {
        List<DiaChi> dsDiaChi = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for (DiaChi diaChi : dsDiaChi) {
            if (diaChi.getTen().equalsIgnoreCase(tenMoi.trim())) {
                isCheck = true;
                break;
            }
        }

        // kiem tra xem ten moi co bang ten cu khong
        if (tenMoi.trim().equalsIgnoreCase(tenCu)) {
            isCheck2 = false;
        }

        return isCheck && isCheck2;
    }

    public Boolean kiemTraTrungTenKhong(String tenCheck) {
        List<DiaChi> dsDiaChi = this.layDanhSach();
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for (DiaChi diaChi : dsDiaChi) {
            if (diaChi.getTen().equalsIgnoreCase(tenCheck.trim())) {
                isCheck = true;
                break;
            }
        }
        return isCheck;
    }

    public Boolean kiemTraTrungMaKhong(String maCkeck) {
        List<DiaChi> dsDiaChi = this.layDanhSach();
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for (DiaChi diaChi : dsDiaChi) {
            if (diaChi.getMa().equalsIgnoreCase(maCkeck.trim())) {
                isCheck = true;
            }
        }
        return isCheck;
    }

    public Boolean kiemTraTrungMaKhong(String maMoi, String maCu) {
        List<DiaChi> dsDiaChi = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for (DiaChi diaChi : dsDiaChi) {
            if (diaChi.getMa().equalsIgnoreCase(maMoi.trim())) {
                isCheck = true;
            }
        }

        // kiem tra xem ten moi co bang ten cu khong
        if (maMoi.trim().equalsIgnoreCase(maCu)) {
            isCheck2 = false;
        }

        return isCheck && isCheck2;
    }

}
