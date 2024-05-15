package com.example.duantn.service.impl;

import com.example.duantn.model.MauSac;
import com.example.duantn.model.PhieuGiamGia;
import com.example.duantn.repository.PhieuGiamGiaRepository;
import com.example.duantn.service.PhieuGiamGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PhieuGiamGiaServiceImpl implements PhieuGiamGiaService {
    @Autowired
    PhieuGiamGiaRepository phieuGiamGiaRepository;

    public void capNhatSoLuongMoi_phieuGiamGia(Integer soLuong, UUID idPhieuGiam){
        phieuGiamGiaRepository.updateSoLuongMoi_phieuGiamGia(idPhieuGiam, soLuong);
    }

    public List<PhieuGiamGia> layDanhSach() {
        return phieuGiamGiaRepository.getAll();
    }

    // hoan code
    public List<PhieuGiamGia> layDanhSach_voiTongTienDonHang(Double tongTienDonHang) {
        return phieuGiamGiaRepository.getAll_voiTongTien(tongTienDonHang);
    }

    public Page<PhieuGiamGia> layDanhSach_voiTongTienDonHang(Pageable pageable, Double tongTienDonHang) {
        return phieuGiamGiaRepository.getAll_tongTienDonHang(pageable, tongTienDonHang);
    }

    public void capNhat(PhieuGiamGia phieuGiamGia) {
        phieuGiamGiaRepository.save(phieuGiamGia);
    }
    // hoan code

    @Override
    public List<PhieuGiamGia> getAll() {
        return phieuGiamGiaRepository.getAll();
    }

    public Page<PhieuGiamGia> layDanhSach(String textSearch, Pageable pageable) {
        if (textSearch != null) {
            return phieuGiamGiaRepository.getAll(textSearch, pageable);
        }

        return phieuGiamGiaRepository.getAll(pageable);
    }

    public Page<PhieuGiamGia> layDanhSach(Pageable pageable) {
        return phieuGiamGiaRepository.getAll(pageable);
    }


    @Override
    public void delete(UUID id) {
        phieuGiamGiaRepository.deleteById(id);

    }

    @Override
    public void add(PhieuGiamGia phieuGiamGia) {
        phieuGiamGiaRepository.save(phieuGiamGia);

    }

    @Override
    public PhieuGiamGia detail(UUID id) {
        Optional<PhieuGiamGia> phieuGiamGia = phieuGiamGiaRepository.findById(id);
        PhieuGiamGia phieuGiamGias = phieuGiamGia.get();
        return phieuGiamGias;
    }


    @Override
    public PhieuGiamGia update(UUID id, PhieuGiamGia phieuGiamGia) {
        PhieuGiamGia phieuGiamGia1 = phieuGiamGiaRepository.save(phieuGiamGia);
        return phieuGiamGia1;
    }

    @Override
    public PhieuGiamGia chiTietTheoId(UUID id) {
        Optional<PhieuGiamGia> phieuGiamGia = phieuGiamGiaRepository.findById(id);
        PhieuGiamGia phieuGiamGia1 = phieuGiamGia.get();
        return phieuGiamGia1;
    }

    public Boolean kiemTraTrungMaKhong(String maCkeck) {
        List<PhieuGiamGia> dsPhieuGiam = phieuGiamGiaRepository.getAllTheoMa(maCkeck);
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        if (dsPhieuGiam.size() > 0) {
            isCheck = true;
        }
        return isCheck;
    }

    public Boolean kiemTraTrungMaKhong(String maMoi, String maCu) {
        List<PhieuGiamGia> dsPhieuGiam = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ma moi co trung voi cac ma khac khong
        for (PhieuGiamGia phieuGiamGia : dsPhieuGiam) {
            if (phieuGiamGia.getMa().equalsIgnoreCase(maMoi.trim())) {
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

    public Boolean kiemTraTrungTenKhong(String tenMoi, String tenCu) {
        List<PhieuGiamGia> dsPhieuGiam = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for (PhieuGiamGia phieuGiamGia : dsPhieuGiam) {
            if (phieuGiamGia.getTenPhieu().equalsIgnoreCase(tenMoi.trim())) {
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
        List<PhieuGiamGia> dsPhieuGiam = this.layDanhSach();
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for (PhieuGiamGia phieuGiamGia : dsPhieuGiam) {
            if (phieuGiamGia.getTenPhieu().equalsIgnoreCase(tenCheck.trim())) {
                isCheck = true;
                break;
            }
        }
        return isCheck;
    }

//    @Autowired
//    public PhieuGiamGia chiTietTheoId(UUID idPhieuGiamGia) {
//        Optional<PhieuGiamGia> phieuGiamGia = phieuGiamGiaRepository.findById(idPhieuGiamGia);
//        PhieuGiamGia phieuGiamGia1 = phieuGiamGia.get();
//        return phieuGiamGia1;
//
//    }
}
