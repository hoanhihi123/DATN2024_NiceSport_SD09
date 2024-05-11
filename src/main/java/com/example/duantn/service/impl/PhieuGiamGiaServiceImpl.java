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
}
