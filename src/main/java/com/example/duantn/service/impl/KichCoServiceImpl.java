package com.example.duantn.service.impl;

import com.example.duantn.model.KichCo;
import com.example.duantn.repository.KichCoRepository;
import com.example.duantn.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KichCoServiceImpl implements BaseService<KichCo>{
    @Autowired
    KichCoRepository repo_kichThuoc;

    public List<KichCo> layDanhSach() {
        return repo_kichThuoc.getAll();
    }


    @Override
    public Page<KichCo> layDanhSach(Pageable pageable) {
        return  repo_kichThuoc.getAll(pageable);
    }

    @Override
    public Page<KichCo> layDanhSach(String textSearch, Pageable pageable) {
        // nếu 1 trong các điều kiện truyền vào null câu query sẽ không được thực hiện dù 1 trong 2 điều kiện đúng
        if(textSearch!=null){
            return repo_kichThuoc.getAll(textSearch, pageable);
        }

        return repo_kichThuoc.getAll(pageable);
    }

    @Override
    public void xoa(UUID id) {
        KichCo kichThuocXoa = repo_kichThuoc.findById(id).get();
        repo_kichThuoc.delete(kichThuocXoa);
    }

    @Override
    public void themMoi(KichCo kichThuoc) {
        repo_kichThuoc.save(kichThuoc);
    }

    @Override
    public void capNhat(KichCo kichThuoc) {
         repo_kichThuoc.save(kichThuoc);
    }

    @Override
    public KichCo chiTietTheoId(UUID id) {
        Optional<KichCo> kichThuoc = repo_kichThuoc.findById(id);
        KichCo kichThuoc1 = kichThuoc.get();
        return kichThuoc1;
    }

    @Override
    public List<KichCo> layDanhSachTheoTen(String ten) {
        return  repo_kichThuoc.getAllTheoTen(ten);
    }

    public Boolean kiemTraTrungTenKhong(String tenMoi, String tenCu){
        List<KichCo> dsKichThuoc = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for(KichCo kichThuoc : dsKichThuoc){
            if(kichThuoc.getTen().equalsIgnoreCase(tenMoi.trim())){
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
        List<KichCo> dsKichThuoc = this.layDanhSach();
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for(KichCo kichThuoc : dsKichThuoc){
            if(kichThuoc.getTen().equalsIgnoreCase(tenCheck.trim())){
                isCheck = true;
                break;
            }
        }
        return isCheck ;
    }

    public Boolean kiemTraTrungMaKhong(String maCkeck){
        List<KichCo> dsKichCo = repo_kichThuoc.getAllTheoMa(maCkeck);
//        System.out.println("dsKich co co size : " + dsKichCo.size());
//        System.out.println("Mã check trùng : " + maCkeck);
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        if(dsKichCo.size()>0){
            isCheck = true;
        }
        return isCheck ;
    }

    public Boolean kiemTraTrungMaKhong(String maMoi, String maCu){
        List<KichCo> dsKichThuoc = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem mã moi co trung voi cac ten khac khong
        for(KichCo kichThuoc : dsKichThuoc){
            if(kichThuoc.getMa().equalsIgnoreCase(maMoi.trim())){
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
