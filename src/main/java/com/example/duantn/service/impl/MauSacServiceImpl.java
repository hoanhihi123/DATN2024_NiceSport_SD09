package com.example.duantn.service.impl;

import com.example.duantn.model.MauSac;
import com.example.duantn.repository.MauSacRepository;
import com.example.duantn.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MauSacServiceImpl implements BaseService<MauSac> {

    @Autowired
    MauSacRepository mauSacRepository;

    @Override
    public List<MauSac> layDanhSach() {
        return mauSacRepository.getAll();
    }

    @Override
    public Page<MauSac> layDanhSach(Pageable pageable) {
        return mauSacRepository.getAll(pageable);
    }

    @Override
    public Page<MauSac> layDanhSach(String textSearch, Pageable pageable) {
        if (textSearch != null) {
//            System.out.println("Chạy vào đây");
            return mauSacRepository.getAll(textSearch, pageable);
        }

        return mauSacRepository.getAll(pageable);
    }

    @Override
    public void xoa(UUID id) {
        MauSac mauSac = mauSacRepository.findById(id).get();
        mauSacRepository.delete(mauSac);
    }

    @Override
    public void themMoi(MauSac entity) {
        mauSacRepository.save(entity);
    }

    public MauSac themMoiCoTraVe(MauSac entity) {
        return mauSacRepository.save(entity);
    }


    @Override
    public void capNhat(MauSac entity) {
         mauSacRepository.save(entity);
    }

    @Override
    public MauSac chiTietTheoId(UUID id) {
        Optional<MauSac> mauSac = mauSacRepository.findById(id);
        MauSac mauSac1 = mauSac.get();
        return mauSac1;
    }

    @Override
    public List<MauSac> layDanhSachTheoTen(String ten) {
        return mauSacRepository.getAllTheoTen(ten);
    }

    public Boolean kiemTraTrungTenKhong(String tenMoi, String tenCu) {
        List<MauSac> dsMauSac = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for (MauSac mauSac : dsMauSac) {
            if (mauSac.getTen().equalsIgnoreCase(tenMoi.trim())) {
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
        List<MauSac> dsMauSac = this.layDanhSach();
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for (MauSac mauSac : dsMauSac) {
            if (mauSac.getTen().equalsIgnoreCase(tenCheck.trim())) {
                isCheck = true;
                break;
            }
        }
        return isCheck;
    }

    public Boolean kiemTraTrungMaKhong(String maCkeck) {
        List<MauSac> dsMauSac = mauSacRepository.getAllTheoMa(maCkeck);
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        if (dsMauSac.size() > 0) {
            isCheck = true;
        }
        return isCheck;
    }

    public Boolean kiemTraTrungMaKhong(String maMoi, String maCu) {
        List<MauSac> dsMauSac = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ma moi co trung voi cac ma khac khong
        for (MauSac mauSac : dsMauSac) {
            if (mauSac.getMa().equalsIgnoreCase(maMoi.trim())) {
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