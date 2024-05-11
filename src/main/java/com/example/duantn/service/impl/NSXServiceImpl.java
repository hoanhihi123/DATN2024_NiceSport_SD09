package com.example.duantn.service.impl;

import com.example.duantn.model.ChucVu;
import com.example.duantn.model.DanhMuc;
import com.example.duantn.model.NSX;
import com.example.duantn.model.NhanVien;
import com.example.duantn.model.SanPham;
import com.example.duantn.repository.NSXRepository;
import com.example.duantn.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NSXServiceImpl implements BaseService<NSX> {
    @Autowired
    NSXRepository  repo_NSX;

    public List<NSX> layDanhSach() {
        return repo_NSX.getAll();
    }

    @Override
    public Page<NSX> layDanhSach(Pageable pageable) {
        return repo_NSX.getAll(pageable);
    }

    @Override
    public Page<NSX> layDanhSach(String textSearch, Pageable pageable) {
        if(textSearch!=null){
            return repo_NSX.getAll(textSearch, pageable);
        }
        return repo_NSX.getAll(pageable);
    }

    @Override
    public void xoa(UUID id) {
        NSX NSXXoa = repo_NSX.findById(id).get();
        repo_NSX.delete(NSXXoa);
    }

    @Override
    public void themMoi(NSX entity) {

        repo_NSX.save(entity);

    }

    @Override
    public void capNhat(NSX entity) {
        if(entity!=null){
            repo_NSX.save(entity);
        }
    }

    public NSX chiTietTheoId(UUID id) {
        Optional<NSX> nhaSanXuat = repo_NSX.findById(id);
        NSX nhaSanXuatNsx = nhaSanXuat.get();
        return nhaSanXuatNsx;
    }

    @Override
    public List<NSX> layDanhSachTheoTen(String ten) {
        return repo_NSX.getAllTheoTen(ten);
    }

    public boolean kiemTraTrungMaKhong(String maCkeck) {
        List<NSX> dsNhaSanXuat = repo_NSX.getAllTheoMa(maCkeck);
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        if (dsNhaSanXuat.size() > 0) {
            isCheck = true;
        }
        return isCheck;
    }

    public boolean kiemTraTrungTenKhong(String tenCheck) {
        List<NSX> dsNhaSanXuat = this.layDanhSach();
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for (NSX nhaSanXuat : dsNhaSanXuat) {
            if (nhaSanXuat.getTen().equalsIgnoreCase(tenCheck.trim())) {
                isCheck = true;
                break;
            }
        }
        return isCheck;
    }

    public boolean kiemTraTrungMaKhong(String maMoi, String maCu) {
        List<NSX> dsNhaSanXuat = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ma moi co trung voi cac ma khac khong
        for (NSX nhaSanXuat : dsNhaSanXuat) {
            if (nhaSanXuat.getMa().equalsIgnoreCase(maMoi.trim())) {
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
        List<NSX> dsNhaSanXuat = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for (NSX nhaSanXuat : dsNhaSanXuat) {
            if (nhaSanXuat.getTen().equalsIgnoreCase(tenMoi.trim())) {
                isCheck = true;
            }
        }

        // kiem tra xem ten moi co bang ten cu khong
        if (tenMoi.trim().equalsIgnoreCase(tenCu)) {
            isCheck2 = false;
        }

        return isCheck && isCheck2;
    }
}