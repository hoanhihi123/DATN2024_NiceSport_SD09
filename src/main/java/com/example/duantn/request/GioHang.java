package com.example.duantn.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GioHang {
    List<SanPhamTrongGioHang> ds_SanPhamTrongGioHang = new ArrayList<SanPhamTrongGioHang>();

    // đếm tổng sản phẩm trong giỏ
    public Integer totalSanPhamTrongGioHangs() {
        Integer total = 0;

        for(SanPhamTrongGioHang sanPhamTrongGioHang : ds_SanPhamTrongGioHang) {
            total = total + sanPhamTrongGioHang.getSoLuong();
        }

        return total;
    }

    // tính tổng giá các sản phẩm trong giỏ hàng
    public Double tongTienTrongGioHang() {
        Double total =  0.0;

        for(SanPhamTrongGioHang sanPhamTrongGioHang : ds_SanPhamTrongGioHang) {
            total = total + sanPhamTrongGioHang.getGia()*sanPhamTrongGioHang.getSoLuong();
        }

        return total;

    }

}
