package com.example.duantn.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MuaHangTaiQuay {
    UUID idSanPhamCT;
    UUID idHoaDon;
    Integer soLuong_sanPhamMua;

    UUID idKhachHangChon;
    UUID idPhieuGiamGia;
    String sdt_KhachHang;
    Double tongTienDonHang;

}
