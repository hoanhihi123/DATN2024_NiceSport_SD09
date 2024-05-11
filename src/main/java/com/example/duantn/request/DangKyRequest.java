package com.example.duantn.request;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DangKyRequest {
    private UUID id;
    @NotBlank(message = "{dangky.taikhoan.notblank}")
    private String taiKhoan;
    @NotBlank(message = "{dangky.tenhienthi.notblank}")
    private String tenDangNhap;
    @NotBlank(message = "{dangky.matkhau.notblank}")
    private String matKhau ;
    @NotBlank(message = "{dangky.nhaplaimatkhau.notblank}")
    private String nhapLaiMatKhau;
}
