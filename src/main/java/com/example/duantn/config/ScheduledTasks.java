package com.example.duantn.config;

import com.example.duantn.model.ChiTietSanPham;
import com.example.duantn.model.DotKhuyenMai;
import com.example.duantn.repository.DotKhuyenMaiRepository;
import com.example.duantn.repository.SanPhamCTRepository;
import com.example.duantn.service.impl.DotKhuyenMaiServiceImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class ScheduledTasks {
    private DotKhuyenMaiServiceImpl dotKhuyenMaiService;
    private SanPhamCTRepository sanPhamCTRepository;
    private DotKhuyenMaiRepository dotKhuyenMaiRepository;

    public ScheduledTasks(DotKhuyenMaiServiceImpl dotKhuyenMaiService, SanPhamCTRepository sanPhamCTRepository, DotKhuyenMaiRepository dotKhuyenMaiRepository) {
        this.dotKhuyenMaiService = dotKhuyenMaiService;
        this.sanPhamCTRepository = sanPhamCTRepository;
        this.dotKhuyenMaiRepository = dotKhuyenMaiRepository;
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
    }
}
