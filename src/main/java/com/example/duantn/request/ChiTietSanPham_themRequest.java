package com.example.duantn.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietSanPham_themRequest  implements Serializable{
    private UUID idSanPham;
    private UUID idThuongHieu;
    private UUID idNSX;
    private UUID idDanhMuc;
    private UUID idLoaiSanPham;
    private UUID idKieuDang;
    private UUID idChatLieu;
    private UUID idMuiGiay;
    private UUID idDayGiay;
    private UUID idDeGiay;
    private UUID idLotGiay;
    private String moTa;
    private Integer trangThai;

    private UUID idMauSac;
    private UUID idSizeGiay;
    private Integer soLuong;
    private Double khoiLuong;
    private String giaTriSanPham;

    private MultipartFile duongDanAnhChinh;
    private ArrayList<String> danhSachDuongDanAnhPhu;


}
