package com.example.duantn.service.impl;

import com.example.duantn.model.DayGiay;
import com.example.duantn.repository.DayGiayRepository;
import com.example.duantn.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DayGiayServiceImpl implements BaseService<DayGiay> {
    @Autowired
    DayGiayRepository repo_dayGiay;


    @Override
    public List<DayGiay> layDanhSach() {
        return repo_dayGiay.getAll();
    }

    @Override
    public Page<DayGiay> layDanhSach(Pageable pageable) {
        return repo_dayGiay.getAll(pageable);
    }

    @Override
    public Page<DayGiay> layDanhSach(String textSearch, Pageable pageable) {
        if (textSearch != null) {
//            System.out.println("Chạy vào đây");
            return repo_dayGiay.getAll(textSearch, pageable);
        }
        return repo_dayGiay.getAll(pageable);
    }

    @Override
    public void xoa(UUID id) {
        DayGiay dayGiay = repo_dayGiay.findById(id).get();
        repo_dayGiay.delete(dayGiay);
    }

    @Override
    public void themMoi(DayGiay entity) {
        repo_dayGiay.save(entity);
    }

    @Override
    public void capNhat(DayGiay entity) {
         repo_dayGiay.save(entity);
    }

    @Override
    public DayGiay chiTietTheoId(UUID id) {
        Optional<DayGiay> dayGiay = repo_dayGiay.findById(id);
        DayGiay dayGiay1 = dayGiay.get();
        return dayGiay1;
    }

    @Override
    public List<DayGiay> layDanhSachTheoTen(String ten) {
        return repo_dayGiay.getAllTheoTen(ten);
    }

    public Boolean kiemTraTrungMaKhong(String maMoi, String maCu) {
        List<DayGiay> dsDayGiay = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ma moi co trung voi cac ma khac khong
        for (DayGiay dayGiay : dsDayGiay) {
            if (dayGiay.getMa().equalsIgnoreCase(maMoi.trim())) {
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
        List<DayGiay> dsDayGiay = repo_dayGiay.getAllTheoMa(maCkeck);
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        if (dsDayGiay.size() > 0) {
            isCheck = true;
        }
        return isCheck;
    }
    public Boolean kiemTraTrungTenKhong(String tenMoi, String tenCu) {
        List<DayGiay> dsDayGiay = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for (DayGiay dayGiay : dsDayGiay) {
            if (dayGiay.getTen().equalsIgnoreCase(tenMoi.trim())) {
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
        List<DayGiay> dsDayGiay = this.layDanhSach();
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for (DayGiay dayGiay : dsDayGiay) {
            if (dayGiay.getTen().equalsIgnoreCase(tenCheck.trim())) {
                isCheck = true;
                break;
            }
        }
        return isCheck;
    }
}
