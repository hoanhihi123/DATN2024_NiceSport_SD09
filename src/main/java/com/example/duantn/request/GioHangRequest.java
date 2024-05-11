package com.example.duantn.request;

import com.example.duantn.model.KhachHang;
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
public class GioHangRequest {
    private UUID id;

    private String ma;
    @NotBlank(message = "{giohang.ten.notblank}")
    @Size(min = 1, max = 30, message = "{giohang.ten.size}")
    private String ten;
    @NotNull(message = "{giohang.tenkhachhang.notnull}")
    private KhachHang khachHang;
    @NotBlank(message = "{giohang.trangThai.notblank}")
    private String trangThai;

}
