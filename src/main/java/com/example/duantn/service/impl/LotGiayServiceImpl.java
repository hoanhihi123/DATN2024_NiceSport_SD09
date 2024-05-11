package com.example.duantn.service.impl;

import com.example.duantn.model.LotGiay;
import com.example.duantn.repository.LotGiayRepository;
import com.example.duantn.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LotGiayServiceImpl implements BaseService<LotGiay> {
    @Autowired
    LotGiayRepository lotGiayRepository;

    public List<LotGiay> layDanhSach(){
        return lotGiayRepository.getAll();
    }


    @Override
    public Page<LotGiay> layDanhSach(Pageable pageable) {
        return lotGiayRepository.getAll(pageable);
    }

    @Override
    public Page<LotGiay> layDanhSach(String textSearch, Pageable pageable) {
        if(textSearch!=null){
            return lotGiayRepository.getAll(textSearch,pageable);
        }
        return lotGiayRepository.getAll(pageable);
    }


    @Override
    public void xoa(UUID id) {
        LotGiay lotGiay = lotGiayRepository.findById(id).get();
        lotGiayRepository.delete(lotGiay);

    }

    @Override
    public void themMoi(LotGiay lotGiay) {
        lotGiayRepository.save(lotGiay);

    }

    @Override
    public void capNhat(LotGiay lotGiay) {
         lotGiayRepository.save(lotGiay);
    }



    @Override
    public LotGiay chiTietTheoId(UUID id) {
        Optional<LotGiay> lotGiay = lotGiayRepository.findById(id);
        LotGiay lotGiay1 = lotGiay.get();
        return lotGiay1;
    }

    @Override
    public List<LotGiay> layDanhSachTheoTen(String ten) {

        return lotGiayRepository.getAllTheoTen(ten);
    }
    ///h
    public Boolean kiemTraTrungTenKhong(String tenMoi, String tenCu){
        List<LotGiay> dslotGiay = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for(LotGiay lotGiay : dslotGiay){
            if(lotGiay.getTen().equalsIgnoreCase(tenMoi.trim())){
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
        List<LotGiay> dslotGiay = this.layDanhSach();
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for(LotGiay lotGiay : dslotGiay){
            if(lotGiay.getTen().equalsIgnoreCase(tenCheck.trim())){
                isCheck = true;
                break;
            }
        }
        return isCheck ;
    }

    public Boolean kiemTraTrungMaKhong(String maCkeck){
        List<LotGiay> dslotGiay = lotGiayRepository.getAllTheoMa(maCkeck);
//        System.out.println("dsKich co co size : " + dsKichCo.size());
//        System.out.println("Mã check trùng : " + maCkeck);
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        if(dslotGiay.size()>0){
            isCheck = true;
        }
        return isCheck ;
    }

    public Boolean kiemTraTrungMaKhong(String maMoi, String maCu){
        List<LotGiay> dslotGiay = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem mã moi co trung voi cac ten khac khong
        for(LotGiay lotGiay : dslotGiay){
            if(lotGiay.getMa().equalsIgnoreCase(maMoi.trim())){
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
