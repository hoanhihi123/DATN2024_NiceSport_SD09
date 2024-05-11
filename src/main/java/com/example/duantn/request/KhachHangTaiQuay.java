package com.example.duantn.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KhachHangTaiQuay {
    private String tenKhachHang;
    private String sdt;
    private String email;
    private Integer gioiTinh;
}
