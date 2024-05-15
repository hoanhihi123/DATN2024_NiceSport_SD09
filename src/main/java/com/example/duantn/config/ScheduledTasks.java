package com.example.duantn.config;

import com.example.duantn.model.ChiTietSanPham;
import com.example.duantn.model.DotKhuyenMai;
import com.example.duantn.model.HoaDon;
import com.example.duantn.model.HoaDonChiTiet;
import com.example.duantn.repository.*;
import com.example.duantn.service.SanPhamCTService;
import com.example.duantn.service.impl.ChiTietSPServiceImpl;
import com.example.duantn.service.impl.DotKhuyenMaiServiceImpl;
import com.example.duantn.service.impl.HoaDonCTServiceImpl;
import com.example.duantn.service.impl.HoaDonServiceImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class ScheduledTasks {
    private DotKhuyenMaiServiceImpl dotKhuyenMaiService;
    private SanPhamCTRepository sanPhamCTRepository;
    private DotKhuyenMaiRepository dotKhuyenMaiRepository;

    private HoaDonRepository hoaDonRepository;
    private HoaDonCTRepository hoaDonCTRepository;
    private ChiTietSanPhamRepository chiTietSanPhamRepository;

//    private HoaDonCTServiceImpl hoaDonCTService;
//    private HoaDonServiceImpl hoaDonService;
//    private ChiTietSPServiceImpl chiTietSPService;

    public ScheduledTasks(
            DotKhuyenMaiServiceImpl dotKhuyenMaiService
            , SanPhamCTRepository sanPhamCTRepository
            , DotKhuyenMaiRepository dotKhuyenMaiRepository
            , HoaDonRepository hoaDonRepository
            , HoaDonCTRepository hoaDonCTRepository
            , ChiTietSanPhamRepository chiTietSanPhamRepository) {
        this.dotKhuyenMaiService = dotKhuyenMaiService;
        this.sanPhamCTRepository = sanPhamCTRepository;
        this.dotKhuyenMaiRepository = dotKhuyenMaiRepository;
        this.hoaDonRepository = hoaDonRepository;
        this.hoaDonCTRepository = hoaDonCTRepository;
        this.chiTietSanPhamRepository = chiTietSanPhamRepository;
    }

    @Scheduled(cron = "0 * * * * *") // Chạy mỗi phút
    public void checkAndChangeStatus() {
        Date currentTime = new Date();
        // Lấy danh sách DotKhuyenMai từ cơ sở dữ liệu
        List<DotKhuyenMai> danhSachDotKhuyenMai = dotKhuyenMaiService.layDanhSach();
        for (DotKhuyenMai dotKhuyenMai : danhSachDotKhuyenMai) {
            Date ngayKetThuc = dotKhuyenMai.getNgayKetThuc();
            // Kiểm tra và thay đổi trạng thái cho từng DotKhuyenMai
            if (ngayKetThuc.after(currentTime)) {
                dotKhuyenMai.setTrangThai(1);
            } else {
                dotKhuyenMai.setTrangThai(0);
            }
            // Lưu thay đổi vào cơ sở dữ liệu
            dotKhuyenMaiService.capNhat(dotKhuyenMai);
        }

        List<ChiTietSanPham> lstData = sanPhamCTRepository.getAll();
        Calendar cal = Calendar.getInstance();
        Date curDate = cal.getTime();
        for (ChiTietSanPham ctsp : lstData) {
            DotKhuyenMai km = dotKhuyenMaiRepository.getDotKhuyenMaiByIdSanPham(ctsp.getSanPham().getId());
            if (km == null) continue;
            if (!km.getNgayBatDau().after(curDate) && !km.getNgayKetThuc().before(curDate)) {
                if (km.getGiaTriGiam() < ctsp.getGiaTriSanPham()) {
                    ctsp.setGiaTriGiam(ctsp.getGiaTriSanPham() - km.getGiaTriGiam());
                    sanPhamCTRepository.save(ctsp);
                }
            } else {
                ctsp.setGiaTriGiam(0.0); // như này oke
                sanPhamCTRepository.save(ctsp);
            }
        }


        // cập nhật giá gốc, giá giảm, thành tiền trong hóa đơn chi tiết
        // khi cronjob thực hiện hoặc giá gốc của sản phẩm bị thay đổi

        //=> cần update các hóa đơn-chưa thanh toán có sản phẩm áp dụng đợt giảm giá đó
        //=> cập nhật lại giá của tất cả hóa đơn chờ => mk hiểu tại sao cho active rồi

//        private HoaDonCTServiceImpl hoaDonCTService;
//        private HoaDonServiceImpl hoaDonService;

        // lấy ra các hóa đơn chờ trang thái = 0
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

        // lấy ra các hóa đơn chi tiết của các hóa đơn chờ đó


        // lấy ra giá sản phẩm sau khi được cập nhật - sản phẩm chi tiết
        // set lại giá gốc, giá giảm, thành tiền cho hóa đơn chi tiết


    }
}
