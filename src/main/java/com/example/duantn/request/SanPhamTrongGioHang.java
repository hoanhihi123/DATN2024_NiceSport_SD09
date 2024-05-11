package com.example.duantn.request;

import com.example.duantn.model.KichCo;
import com.example.duantn.model.MauSac;
import com.example.duantn.model.SanPham;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamTrongGioHang {
    private String tenHoaDon;
    private UUID idSanPhamCT;
    private SanPham sanPham;
    private KichCo kichCo;
    private MauSac mauSac;
    private String hinhAnh;
    private Integer soLuong;  // so luong trong gio
    private Integer soLuongMuaThem;  // so luong mua them
    private Double gia;
    private Integer numberCheck;
    private Double trongLuong;

    // hàm tính thành tiền của sản phẩm
    public Double tongTien() {
        if(this.gia==null || this.soLuong==null) {
            return 0.0;
        }
        return this.soLuong*this.gia;
    }
}
