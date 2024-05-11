package com.example.duantn.service.impl;

import com.example.duantn.model.HoaDon;

import com.example.duantn.repository.HoaDonRepository;
import com.example.duantn.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HoaDonServiceImpl implements HoaDonService {

    @Autowired
    HoaDonRepository hoaDonRepository;


    public  List<HoaDon> layDanhSachHoaDon_theoTrangThai(Integer trangThai){
        return hoaDonRepository.getHoaDonBy_status(trangThai);
    }

    @Override
    public void delete(UUID id) {
        hoaDonRepository.deleteById(id);

    }

    @Override
    public void add(HoaDon hoaDon) {
        hoaDonRepository.save(hoaDon);

    }


    public HoaDon themMoi(HoaDon hoaDon) {
        return hoaDonRepository.save(hoaDon);
    }

    @Override
    public HoaDon detail(UUID id) {
        HoaDon hoaDon = new HoaDon();
        if(id!=null){
            hoaDon = hoaDonRepository.findById(id).get();
        }
        return hoaDon;
    }


    public HoaDon chiTietTheoId(UUID id) {
        return hoaDonRepository.findById(id).orElse(null);
    }



    @Override
    public HoaDon update(UUID id, HoaDon hoaDon) {
        HoaDon hoaDon1 = hoaDonRepository.save(hoaDon);
        return hoaDon1;
    }


    public Page<HoaDon> searchByMa(String ma, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        return hoaDonRepository.findByMa(ma,pageable);
    }


//    public Page<HoaDon> phanTrangHoaDon(Integer pageNum, Integer pageNo) {
//        Pageable pageable = PageRequest.of(pageNum,pageNo);
//        return hoaDonRepository.findAll(pageable);
//    }

    // hoan code
        public void capNhatThongTinHoaDon_laThongTinKhachHang(UUID idHoaDon, UUID idKhachHang){
            hoaDonRepository.capNhatThonTinHoaDon_voiThongTinKhachHang(idHoaDon, idKhachHang);
        }

        public void xoaHoaDonBangIdHoaDon(UUID idHoaDon){
            hoaDonRepository.xoaHoaDonCho_bangIdHoaDon(idHoaDon);
        }

        public void capNhatPhieuGiamGiaApDungCho_hoaDonCho(UUID idHoaDon, UUID idPhieuGiamGia){
            hoaDonRepository.capNhatHoaDon_apDungPhieuGiamGiaNao(idHoaDon, idPhieuGiamGia);
        }

//        public HoaDon chiTietTheoId(UUID id) {
//            Optional<HoaDon> optionalHoaDon = hoaDonRepository.findById(id);
//            return optionalHoaDon.orElse(null);
//        }

    public HoaDon capNhat(HoaDon hoaDon) {
        return hoaDonRepository.save(hoaDon);
    }

    // hoan code

    // code duc anh

    @Override
    public List<HoaDon> getAll() {
        return hoaDonRepository.getAll();
    }

    @Override
    public Page<HoaDon> phanTrangHoaDon(Integer pageNum, Integer pageNo) {
        // Tạo đối tượng Sort cho sắp xếp theo mã hóa đơn tăng dần
        Sort sort = Sort.by(Sort.Direction.ASC, "Ma");

        // Tạo đối tượng Pageable với sắp xếp và số trang, số lượng mỗi trang
        Pageable pageable = PageRequest.of(pageNum, pageNo, sort);

        // Thực hiện truy vấn với điều kiện sắp xếp và trang
        return hoaDonRepository.findAll(pageable);
    }



}
