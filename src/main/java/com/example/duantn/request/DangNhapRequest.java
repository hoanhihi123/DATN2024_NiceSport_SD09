package com.example.duantn.request;

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
public class DangNhapRequest {
    private UUID id;
    @NotBlank(message = "{dangnhap.taikhoan.notblank}")
    private String taiKhoan;
    @NotBlank(message = "{dangnhap.matkhau.notblank}")
    private String matKhau ;

}
