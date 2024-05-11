package com.example.duantn.service.impl;

import com.example.duantn.model.GiamGia;
import com.example.duantn.repository.GiamGiaRepository;
import com.example.duantn.service.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GiamGiaServiceImpl implements BaseService<GiamGia> {
    @Autowired
    private GiamGiaRepository giamGiaRepository;

    public List<GiamGia> layDanhSach() {
        return giamGiaRepository.getAll();
    }

    @Override
    public Page<GiamGia> layDanhSach(Pageable pageable) {
        return giamGiaRepository.getAll(pageable);
    }

    @Override
    public Page<GiamGia> layDanhSach(String textSearch, Pageable pageable) {
        if (textSearch != null) {
            return giamGiaRepository.getAll(textSearch, pageable);
        }
        return giamGiaRepository.getAll(pageable);
    }

    @Override
    public void xoa(UUID id) {
        GiamGia GiamGiaXoa = giamGiaRepository.findById(id).get();
        giamGiaRepository.delete(GiamGiaXoa);
    }

    @Override
    public void themMoi(GiamGia entity) {
        if (entity != null) {
            giamGiaRepository.save(entity);
        }
    }

    @Override
    public void capNhat(GiamGia entity) {
        if (entity != null) {
             giamGiaRepository.save(entity);
        }
    }

    @Override
    public GiamGia chiTietTheoId(UUID id) {
        Optional<GiamGia> giamGia = giamGiaRepository.findById(id);
        GiamGia giamGia1 = giamGia.get();
        return giamGia1;
    }

    @Override
    public List<GiamGia> layDanhSachTheoTen(String ten) {
        return giamGiaRepository.getAllTheoTen(ten);
    }

    public Boolean kiemTraTrungTenKhong(String tenMoi, String tenCu) {
        List<GiamGia> dsGiamGia = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for (GiamGia giamGia : dsGiamGia) {
            if (giamGia.getTen().equalsIgnoreCase(tenMoi.trim())) {
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
        List<GiamGia> dsGiamGia = this.layDanhSach();
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for (GiamGia giamGia : dsGiamGia) {
            if (giamGia.getTen().equalsIgnoreCase(tenCheck.trim())) {
                isCheck = true;
                break;
            }
        }
        return isCheck;
    }

    public Boolean kiemTraTrungMaKhong(String maCkeck) {
        List<GiamGia> dsGiamGia = giamGiaRepository.getAllTheoMa(maCkeck);
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        if (dsGiamGia.size() > 0) {
            isCheck = true;
        }
        return isCheck;
    }

    public Boolean kiemTraTrungMaKhong(String maMoi, String maCu) {
        List<GiamGia> dsGiamGia = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ma moi co trung voi cac ma khac khong
        for (GiamGia giamGia : dsGiamGia) {
            if (giamGia.getMa().equalsIgnoreCase(maMoi.trim())) {
                isCheck = true;
                break;
            }
        }

        if (maMoi.trim().equalsIgnoreCase(maCu)) {
            isCheck2 = false;
        }

        return isCheck && isCheck2;
    }

    public boolean kiemTraTrungMa(String ma) {
        return giamGiaRepository.existsByMa(ma);
    }

    public boolean kiemTraTrungTen(String ten) {
        return giamGiaRepository.existsByTen(ten);
    }

    @Transactional
    public void updateExpiredGiamGiaStatus() {
        Date currentDate = new Date();
        List<GiamGia> expiredGiamGias = giamGiaRepository.findByNgayKetThucBeforeAndTrangThai(currentDate, 1);
        for (GiamGia giamGia : expiredGiamGias) {
            giamGia.setTrangThai(0);
            giamGiaRepository.save(giamGia);
        }
    }


}
