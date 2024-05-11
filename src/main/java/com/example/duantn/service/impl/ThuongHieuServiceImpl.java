package com.example.duantn.service.impl;

import com.example.duantn.model.ThuongHieu;
import com.example.duantn.repository.ThuongHieuRepository;
import com.example.duantn.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ThuongHieuServiceImpl implements BaseService<ThuongHieu> {
    @Autowired
    ThuongHieuRepository repo_thuongHieu;


    @Override
    public List<ThuongHieu> layDanhSach() {
        return repo_thuongHieu.getAll();
    }

    @Override
    public Page<ThuongHieu> layDanhSach(Pageable pageable) {

        return repo_thuongHieu.getAll(pageable);

    }

    @Override
    public Page<ThuongHieu> layDanhSach(String textSearch, Pageable pageable) {

        if (textSearch != null){
            return repo_thuongHieu.getAll(textSearch,pageable);
        }
        return repo_thuongHieu.getAll(pageable);

    }

    @Override
    public void xoa(UUID id) {
        ThuongHieu thuongHieu = repo_thuongHieu.findById(id).get();
        repo_thuongHieu.delete(thuongHieu);

    }

    @Override
    public void themMoi(ThuongHieu entity) {
        repo_thuongHieu.save(entity);

    }

    @Override
    public void capNhat(ThuongHieu entity) {

         repo_thuongHieu.save(entity);

    }

    @Override
    public ThuongHieu chiTietTheoId(UUID id) {

        Optional<ThuongHieu> thuongHieu=repo_thuongHieu.findById(id);
        ThuongHieu thuongHieu1 = thuongHieu.get();
        return thuongHieu1;

    }

    @Override
    public List<ThuongHieu> layDanhSachTheoTen(String ten) {

        return repo_thuongHieu.getAllTheoTen(ten);
    }

    public Boolean kiemTraTrungMaKhong(String maMoi, String maCu) {
        List<ThuongHieu> dsThuongHieu = this.layDanhSach();
        Boolean isCheck =false;
        Boolean isCheck2 = true;
        for (ThuongHieu thuongHieu : dsThuongHieu){
            if (thuongHieu.getMa().equalsIgnoreCase(maMoi.trim())){
                isCheck = true;
                break;
            }
        }
        if (maMoi.trim().equalsIgnoreCase(maCu)){
            isCheck2 = false;
        }
        return isCheck && isCheck2;
    }
    public Boolean kiemTraTrungMaKhong(String maCkeck) {
        List<ThuongHieu> dsThuongHieu = repo_thuongHieu.getAllTheoMa(maCkeck);
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        if (dsThuongHieu.size() > 0) {
            isCheck = true;
        }
        return isCheck;


    }
    public Boolean kiemTraTrungTenKhong(String tenMoi, String tenCu) {
        List<ThuongHieu> dsThuongHieu = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for (ThuongHieu thuongHieu : dsThuongHieu) {
            if (thuongHieu.getTen().equalsIgnoreCase(tenMoi.trim())) {
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
        List<ThuongHieu> dsThuongHieu = this.layDanhSach();
        Boolean isCheck = false;
        for (ThuongHieu thuongHieu : dsThuongHieu){
            if (thuongHieu.getTen().equalsIgnoreCase(tenCheck.trim())){
                isCheck = true;
                break;
            }
        }
        return isCheck;

    }
}
