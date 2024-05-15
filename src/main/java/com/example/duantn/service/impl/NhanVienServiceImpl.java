package com.example.duantn.service.impl;


import com.example.duantn.model.NhanVien;
import com.example.duantn.repository.NhanVienRepository;
import com.example.duantn.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NhanVienServiceImpl implements BaseService<NhanVien> {
    @Autowired
    NhanVienRepository repo_nhanVien;

    //    @Override
//    public List<NhanVien> layDanhSach() {
//        return repo_nhanVien.getAll();
//    }
    @Override
    public List<NhanVien> layDanhSach() {
        return repo_nhanVien.getAll();
    }

    ///anh code
    public List<NhanVien> layDanhSachNhanVien_theoSDT(String sdt){
        return repo_nhanVien.getAllBySDT_Customer(sdt);
    }

    @Override
    public Page<NhanVien> layDanhSach(Pageable pageable) {
        return  repo_nhanVien.getAll(pageable);
    }

    @Override
    public Page<NhanVien> layDanhSach(String textSearch, Pageable pageable) {
        if(textSearch!=null){
            return repo_nhanVien.getAll(textSearch, pageable);
        }
        return repo_nhanVien.getAll(pageable);
    }

    @Override
    public void xoa(UUID id) {
        NhanVien NhanVienXoa = repo_nhanVien.findById(id).get();
        repo_nhanVien.delete(NhanVienXoa);
    }

    @Override
    public void themMoi(NhanVien entity) {
        repo_nhanVien.save(entity);
    }

    @Override
    public void capNhat(NhanVien entity) {
        repo_nhanVien.save(entity);
    }

    @Override
    public NhanVien chiTietTheoId(UUID id) {
        Optional<NhanVien> NhanVien = repo_nhanVien.findById(id);
        NhanVien NhanVien1 = NhanVien.get();
        return NhanVien1;
    }

    @Override
    public List<NhanVien> layDanhSachTheoTen(String ten) {
        return  repo_nhanVien.getAllTheoTen(ten);
    }




    public Boolean kiemTraTrungTenKhong(String tenMoi, String tenCu){
        List<NhanVien> dsNhanVien = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for(NhanVien nhanVien : dsNhanVien){
            if(nhanVien.getHoVaTen().equalsIgnoreCase(tenMoi.trim())){
                isCheck = true;

            }
        }

        // kiem tra xem ten moi co bang ten cu khong
        if(tenMoi.trim().equalsIgnoreCase(tenCu)){
            isCheck2 = false;
        }

        return isCheck && isCheck2 ;
    }

    public Boolean kiemTraTrungTenKhong(String tenCheck){
        List<NhanVien> dsNhanVien = this.layDanhSach();
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for(NhanVien nhanVien : dsNhanVien){
            if(nhanVien.getHoVaTen().equalsIgnoreCase(tenCheck.trim())){
                isCheck = true;
                break;
            }
        }
        return isCheck ;
    }

    public Boolean kiemTraTrungMaKhong(String maCkeck) {
        List<NhanVien> dsNhanVien = repo_nhanVien.getAllTheoMa(maCkeck);
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        if (dsNhanVien.size() > 0) {
            isCheck = true;
        }
        return isCheck;
    }

    public Boolean kiemTraTrungMaKhong(String maMoi, String maCu){
        List<NhanVien> dsnhanVien = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for(NhanVien nhanVien : dsnhanVien){
            if(nhanVien.getMa().equalsIgnoreCase(maMoi.trim())){
                isCheck = true;
                break;
            }
        }

        // kiem tra xem ten moi co bang ten cu khong
        if(maMoi.trim().equalsIgnoreCase(maCu)){
            isCheck2 = false;
        }

        return isCheck && isCheck2 ;
    }


}
