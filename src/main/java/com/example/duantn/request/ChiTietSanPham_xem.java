package com.example.duantn.request;

import com.example.duantn.model.*;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietSanPham_xem {

    private UUID idSanPhamChiTiet;

    private LoaiSanPham loaiSanPham;

    private DotKhuyenMai dotKhuyenMai;

    private UUID idSanPham;

    private UUID idMauSac;

    private DanhMuc danhMuc;

    private KieuDang kieuDang;

    private ThuongHieu thuongHieu;

    private MuiGiay muiGiay;

    private DeGiay deGiay;

    private LotGiay lotGiay;

    private DayGiay dayGiay;

    private KichCo kichCo;

    private ChatLieu chatLieu;


    private String ten;

    private Double giaTriSanPham;

    private Double giaTriGiam;

    private Double khoiLuong;


    private Date ngayHetGiamGia;


    private String moTa;

    private Integer soLuong;

    private String hinhAnh;
}
