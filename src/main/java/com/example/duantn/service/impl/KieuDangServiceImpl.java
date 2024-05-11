package com.example.duantn.service.impl;

import com.example.duantn.model.KieuDang;
import com.example.duantn.repository.KieuDangRepository;
import com.example.duantn.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KieuDangServiceImpl implements BaseService<KieuDang> {
    @Autowired
    KieuDangRepository repo_kieuDang;

    public List<KieuDang> layDanhSach(){
        return repo_kieuDang.getAll();
    }


//    @Override
//    public List<KieuDang> layDanhSach() {
//        return repo_kieuDang.getAll();
//    }
//
//    @Override
//    public List<KieuDang> findByCondition(KieuDang entity) {
//        return null;
//    }

    @Override
    public Page<KieuDang> layDanhSach(Pageable pageable) {
        return repo_kieuDang.getAll(pageable);
    }

    @Override
    public Page<KieuDang> layDanhSach(String textSearch, Pageable pageable) {
        if(textSearch!=null){
            return repo_kieuDang.getAll(textSearch,pageable);
        }
        return repo_kieuDang.getAll(pageable);
    }

//    @Override
//    public Page<KieuDang> findPage(KieuDang entity, Pageable pageable) {
//        return null;
//    }

    @Override
    public void xoa(UUID id) {
        KieuDang kieuDang = repo_kieuDang.findById(id).get();
        repo_kieuDang.delete(kieuDang);

    }

    @Override
    public void themMoi(KieuDang kieuDang) {
        repo_kieuDang.save(kieuDang);

    }

    @Override
    public void capNhat(KieuDang kieuDang) {
         repo_kieuDang.save(kieuDang);
    }

//    @Override
//    public KieuDang capNhat(KieuDang entity) {
//        return null;
//    }

    @Override
    public KieuDang chiTietTheoId(UUID id) {
        Optional<KieuDang> kieuDang = repo_kieuDang.findById(id);
        KieuDang  kieuDang1 = kieuDang.get();
        return kieuDang1;
    }

    @Override
    public List<KieuDang> layDanhSachTheoTen(String ten) {
        return repo_kieuDang.getAllTheoTen(ten);
    }
    ///h
    public Boolean kiemTraTrungTenKhong(String tenMoi, String tenCu){
        List<KieuDang> dsKieuDang = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for(KieuDang kieuDang : dsKieuDang){
            if(kieuDang.getTen().equalsIgnoreCase(tenMoi.trim())){
                isCheck = true;
            }
        }

        // kiem tra xem ten moi co bang ten cu khong
        if(tenMoi.trim().equalsIgnoreCase(tenCu)){
            isCheck2 = false;
        }

        return isCheck&&isCheck2 ;
    }

    public Boolean kiemTraTrungTenKhong(String tenCheck){
        List<KieuDang> dsKieuDang = this.layDanhSach();
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for(KieuDang kieuDang : dsKieuDang){
            if(kieuDang.getTen().equalsIgnoreCase(tenCheck.trim())){
                isCheck = true;
                break;
            }
        }
        return isCheck ;
    }

    public Boolean kiemTraTrungMaKhong(String maCkeck){
        List<KieuDang> dsKieuDang = repo_kieuDang.getAllTheoMa(maCkeck);
//        System.out.println("dsKich co co size : " + dsKichCo.size());
//        System.out.println("Mã check trùng : " + maCkeck);
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        if(dsKieuDang.size()>0){
            isCheck = true;
        }
        return isCheck ;
    }

    public Boolean kiemTraTrungMaKhong(String maMoi, String maCu){
        List<KieuDang> dsKieuDang = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem mã moi co trung voi cac ten khac khong
        for(KieuDang kieuDang : dsKieuDang){
            if(kieuDang.getMa().equalsIgnoreCase(maMoi.trim())){
                isCheck = true;
                break;
            }
        }

        // kiem tra xem mã moi co bang ten cu khong
        if(maMoi.trim().equalsIgnoreCase(maCu)){
            isCheck2 = false;
        }

        return isCheck&&isCheck2 ;
    }
}
