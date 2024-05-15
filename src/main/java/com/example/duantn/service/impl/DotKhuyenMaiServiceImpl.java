package com.example.duantn.service.impl;

import com.example.duantn.model.*;
import com.example.duantn.repository.*;
import com.example.duantn.service.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DotKhuyenMaiServiceImpl implements BaseService<DotKhuyenMai> {
    private final DotKhuyenMaiRepository dotKhuyenMaiRepository;
    private final SanPhamRepository sanPhamRepository;
    private final SanPhamCTRepository sanPhamCTRepository;
    private final SanPhamDotKhuyenMaiRepository sanPhamDotKhuyenMaiRepository;

    private  HoaDonRepository hoaDonRepository;
    private HoaDonCTRepository hoaDonCTRepository;
    private ChiTietSanPhamRepository chiTietSanPhamRepository;

    public DotKhuyenMaiServiceImpl(
            DotKhuyenMaiRepository dotKhuyenMaiRepository
            , SanPhamRepository sanPhamRepository
            , SanPhamCTRepository sanPhamCTRepository
            , SanPhamDotKhuyenMaiRepository sanPhamDotKhuyenMaiRepository
            , HoaDonRepository hoaDonRepository
            , HoaDonCTRepository hoaDonCTRepository
            , ChiTietSanPhamRepository chiTietSanPhamRepository
    ) {
        this.dotKhuyenMaiRepository = dotKhuyenMaiRepository;
        this.sanPhamRepository = sanPhamRepository;
        this.sanPhamCTRepository = sanPhamCTRepository;
        this.sanPhamDotKhuyenMaiRepository = sanPhamDotKhuyenMaiRepository;
        this.hoaDonCTRepository = hoaDonCTRepository;
        this.hoaDonRepository = hoaDonRepository;
        this.chiTietSanPhamRepository = chiTietSanPhamRepository;
    }

    public List<DotKhuyenMai> layDanhSach() {
        return dotKhuyenMaiRepository.getAll();
    }

    @Override
    public Page<DotKhuyenMai> layDanhSach(Pageable pageable) {
        return dotKhuyenMaiRepository.getAll(pageable);
    }

    @Override
    public Page<DotKhuyenMai> layDanhSach(String textSearch, Pageable pageable) {
        if (textSearch != null) {
            return dotKhuyenMaiRepository.getAll(textSearch, pageable);
        }
        return dotKhuyenMaiRepository.getAll(pageable);
    }

    @Override
    public void xoa(UUID id) {
        DotKhuyenMai DotKhuyenMaiXoa = dotKhuyenMaiRepository.findById(id).get();
        dotKhuyenMaiRepository.delete(DotKhuyenMaiXoa);
    }

    @Override
    public void themMoi(DotKhuyenMai entity) {
        if (entity != null) {
            dotKhuyenMaiRepository.save(entity);
        }
    }

    @Override
    public void capNhat(DotKhuyenMai entity) {
        if (entity != null) {
            dotKhuyenMaiRepository.save(entity);
        }
    }

    @Override
    public DotKhuyenMai chiTietTheoId(UUID id) {
        Optional<DotKhuyenMai> dotKhuyenMai = dotKhuyenMaiRepository.findById(id);
        DotKhuyenMai dotKhuyenMai1 = dotKhuyenMai.get();
        return dotKhuyenMai1;
    }

    @Override
    public List<DotKhuyenMai> layDanhSachTheoTen(String ten) {
        return dotKhuyenMaiRepository.getAllTheoTen(ten);
    }

    public Boolean kiemTraTrungTenKhong(String tenMoi, String tenCu) {
        List<DotKhuyenMai> dsDotKhuyenMai = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for (DotKhuyenMai dotKhuyenMai : dsDotKhuyenMai) {
            if (dotKhuyenMai.getTen().equalsIgnoreCase(tenMoi.trim())) {
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
        List<DotKhuyenMai> dsDotKhuyenMai = this.layDanhSach();
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for (DotKhuyenMai dotKhuyenMai : dsDotKhuyenMai) {
            if (dotKhuyenMai.getTen().equalsIgnoreCase(tenCheck.trim())) {
                isCheck = true;
                break;
            }
        }
        return isCheck;
    }

    public Boolean kiemTraTrungMaKhong(String maCkeck) {
        List<DotKhuyenMai> dsDotKhuyenMai = dotKhuyenMaiRepository.getAllTheoMa(maCkeck);
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        if (dsDotKhuyenMai.size() > 0) {
            isCheck = true;
        }
        return isCheck;
    }

    public Boolean kiemTraTrungMaKhong(String maMoi, String maCu) {
        List<DotKhuyenMai> dsDotKhuyenMai = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ma moi co trung voi cac ma khac khong
        for (DotKhuyenMai dotKhuyenMai : dsDotKhuyenMai) {
            if (dotKhuyenMai.getMa().equalsIgnoreCase(maMoi.trim())) {
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
        return dotKhuyenMaiRepository.existsByMa(ma);
    }

    public void checkAndChangeStatus() {
        Date currentTime = new Date();
        Date desiredTime = new Date(124, 3, 12, 12, 0, 0);

        if (currentTime.after(desiredTime)) {
            System.out.println("Thời gian hiện tại lớn hơn thời gian được chỉ định. Thay đổi trạng thái...");
        } else {
            System.out.println("Thời gian hiện tại chưa đến thời gian được chỉ định.");
        }
    }

    public void apDungDotKhuyenMaiChoSanPham(SanPhamDotKhuyenMai spDkm, DotKhuyenMai dotKhuyenMai, List<UUID> selectedProductIds, double giaTriGiam) {
        // 1. Tạo mới đợt khuyến mãi
        dotKhuyenMaiRepository.save(dotKhuyenMai);
        for (UUID id : selectedProductIds) {
            Optional<SanPham> sp = sanPhamRepository.findById(id);
            if (sanPhamDotKhuyenMaiRepository.getExistProduct(sp.get().getId()) != null) {
                spDkm = sanPhamDotKhuyenMaiRepository.getExistProduct(sp.get().getId());
            } else {
                spDkm = new SanPhamDotKhuyenMai();
            }
            spDkm.setIdSanPham(sp.get().getId());
            spDkm.setIdDotKhuyenMai(dotKhuyenMai.getId());
            sanPhamDotKhuyenMaiRepository.save(spDkm);

            List<ChiTietSanPham> lstData = sanPhamCTRepository.getListDetailProductByCode(sp.get().getId());
            SanPham res = sanPhamRepository.getSanPhamByMaSP(sp.get().getMa());
            if (res == null) {
                continue;
            }
            Calendar cal = Calendar.getInstance();
            Date curDate = cal.getTime();
            DotKhuyenMai dkm = dotKhuyenMaiRepository.getDotKhuyenMaiByIdSanPham(res.getId());
            for (ChiTietSanPham ctsp : lstData) {
                if (dkm.getNgayBatDau().after(curDate) || dkm.getNgayKetThuc().before(curDate)) {
                    ctsp.setGiaTriGiam(ctsp.getGiaTriSanPham() - 0.0);
                    sanPhamCTRepository.save(ctsp);
                } else {
                    if (dkm.getGiaTriGiam() < ctsp.getGiaTriSanPham()) {
                        ctsp.setGiaTriGiam(ctsp.getGiaTriSanPham() - dkm.getGiaTriGiam());
                        sanPhamCTRepository.save(ctsp);
                    }
                }
            }
        }

        // -----------------------------------
        List<HoaDon> danhSach_hoaDonCho = new ArrayList<>();
        danhSach_hoaDonCho = hoaDonRepository.getHoaDonBy_status(0);

        for(HoaDon hoaDonCho : danhSach_hoaDonCho){
            List<HoaDonChiTiet> danhSachHoaDonChiTiet_tuongUng = new ArrayList<>();
            danhSachHoaDonChiTiet_tuongUng = hoaDonCTRepository.getListHoaDonChiTiet_theoIdHoaDon(hoaDonCho.getId());
            for(HoaDonChiTiet hoaDonChiTiet: danhSachHoaDonChiTiet_tuongUng){
                // duyệt lần lượt hóa đơn chi tiết - mỗi hóa đơn chi tiết tương ứng với 1 sản phẩm chi tiết
                // lấy ra thông tin của sản phẩm chi tiết ứng với hóa đơn chi tiết đó => cập nhật lại thông tin cho hóa đơn chi tiết đó
                HoaDonChiTiet hoaDonChiTiet_update = hoaDonChiTiet;
                ChiTietSanPham chiTietSanPham = chiTietSanPhamRepository.findById(hoaDonChiTiet.getChiTietSanPham().getId()).orElse(null);
                hoaDonChiTiet_update.setGiaGocSP(chiTietSanPham.getGiaTriSanPham());
                Double giaGiam = 0.0;
                if(chiTietSanPham.getGiaTriGiam()!=null&&chiTietSanPham.getGiaTriGiam()>0){
                    giaGiam = chiTietSanPham.getGiaTriGiam();
                }
                hoaDonChiTiet_update.setGiaSauGiam(giaGiam);
                Double thanhTien = 0.0;
                if(chiTietSanPham.getGiaTriGiam()!=null&&chiTietSanPham.getGiaTriGiam()>0) {
                    thanhTien = chiTietSanPham.getGiaTriGiam()*hoaDonChiTiet_update.getSoLuong();
                }else {
                    thanhTien = chiTietSanPham.getGiaTriSanPham()*hoaDonChiTiet_update.getSoLuong();
                }
                hoaDonChiTiet_update.setDonGia(thanhTien);
                System.out.println(">>>>>>>>>>>>>>> tại class scheduled task - cập nhật hóa đơn chi tiết ");
                System.out.println("Thành tiền : " + thanhTien);
                System.out.println("Gia giam : " + giaGiam);
                System.out.println("gia gốc : " + chiTietSanPham.getGiaTriSanPham());
                System.out.println("Hóa đơn chi tiết được cập nhật : " + hoaDonChiTiet_update.toString());
                hoaDonCTRepository.save(hoaDonChiTiet_update);
            }
        }



    }
}
