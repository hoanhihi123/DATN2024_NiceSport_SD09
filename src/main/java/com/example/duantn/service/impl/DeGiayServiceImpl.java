package com.example.duantn.service.impl;

import com.example.duantn.model.DeGiay;
import com.example.duantn.repository.DeGiayRepository;
import com.example.duantn.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DeGiayServiceImpl implements BaseService<DeGiay> {
    @Autowired
    DeGiayRepository repo_deGiay;

    @Override
    public List<DeGiay> layDanhSach() {
        return repo_deGiay.getAll();
    }

    @Override
    public Page<DeGiay> layDanhSach(Pageable pageable) {


        return repo_deGiay.getAll(pageable);

    }

    @Override
    public Page<DeGiay> layDanhSach(String textSearch, Pageable pageable) {


        if (textSearch != null) {
            return repo_deGiay.getAll(textSearch, pageable);
        }
        return repo_deGiay.getAll(pageable);

    }

    @Override
    public void xoa(UUID id) {


        DeGiay deGiay = repo_deGiay.findById(id).get();
        repo_deGiay.delete(deGiay);

    }

    @Override
    public void themMoi(DeGiay entity) {

        repo_deGiay.save(entity);

    }

    @Override
    public void capNhat(DeGiay entity) {

         repo_deGiay.save(entity);

    }

    @Override
    public DeGiay chiTietTheoId(UUID id) {

        Optional<DeGiay> deGiay = repo_deGiay.findById(id);
        DeGiay deGiay1 = deGiay.get();
        return deGiay1;

    }

    @Override
    public List<DeGiay> layDanhSachTheoTen(String ten) {


        return repo_deGiay.getAllTheoTen(ten);
    }

    public Boolean kiemTraTrungKhong(String tenMoi, String tenCu) {
        List<DeGiay> dsDeGiay = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;
        for (DeGiay deGiay : dsDeGiay) {
            if (deGiay.getTen().equalsIgnoreCase(tenMoi.trim())) ;
            isCheck = true;
        }
        if (tenMoi.trim().equalsIgnoreCase(tenCu)) {
            isCheck2 = false;
        }
        return isCheck && isCheck2;
    }

    public Boolean kiemTraTrungMaKhong(String maMoi, String maCu) {
        List<DeGiay> dsDeGiay = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;
        for (DeGiay deGiay : dsDeGiay) {
            if (deGiay.getMa().equalsIgnoreCase(maMoi.trim())) {
                isCheck = true;
                break;
            }
        }
        if (maMoi.trim().equalsIgnoreCase(maCu)) {
            isCheck2 = false;
        }
        return isCheck && isCheck2;
    }

    public Boolean kiemTraTrungMaKhong(String maCkeck) {
        List<DeGiay> dsDeGiay = repo_deGiay.getAllTheoMa(maCkeck);
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        if (dsDeGiay.size() > 0) {
            isCheck = true;
        }
        return isCheck;


    }

    public Boolean kiemTraTrungTenKhong(String tenMoi, String tenCu) {
        List<DeGiay> dsDeGiay = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for (DeGiay deGiay : dsDeGiay) {
            if (deGiay.getTen().equalsIgnoreCase(tenMoi.trim())) {
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
        List<DeGiay> dsDeGiay = this.layDanhSach();
        Boolean isCheck = false;
        for (DeGiay deGiay : dsDeGiay) {
            if (deGiay.getTen().equalsIgnoreCase(tenCheck.trim())) {
                isCheck = true;
                break;
            }
        }
        return isCheck;
    }
}

