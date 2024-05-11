package com.example.duantn.request;

import com.example.duantn.model.BaseModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KhachHangRequest extends BaseModel {
    @NotBlank(message = "{giohang.taikhoan.notblank}")
    private String taiKhoan;

//    @NotBlank(message = "{giohang.matkhau.notblank}")
    private String matKhau;

    private UUID id;
    @NotBlank(message = "{khachHang.maKhachHang.notblank}")
    private String ma;

    @NotBlank(message = "{khachHang.tenKhachHang.notblank}")
    @Size(max=50, message = "{khachHang.tenKhachHang.size}")
    private String hoTen ;

    //
//    @NotBlank(message = "{khachHang.matKhau.notblank}")
//    private String matKhau;
//
    @NotNull(message = "{khachHang.gioiTinh.notnull}")
    private Integer gioiTinh;

    @NotBlank(message = "{khachHang.sdt.notblank}")
    private String soDT;

    @NotBlank(message = "{khachHang.email.notblank}")
    private String email;

//    @NotNull(message = "{khachHang.trangThai.notnull}")
//    private Integer trangThai;
}