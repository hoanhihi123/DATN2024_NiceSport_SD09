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
public class SanPhamRequest {
    private UUID id;

    @NotBlank(message = "{sanpham.ma.notblank}")
    private String ma;

    @NotBlank(message = "{sanpham.ten.notblank}")
    @Size(min=7, max=50, message = "{sanpham.ten.size}")
    private String ten ;

    @NotBlank(message = "{sanpham.moTa.notblank}")
    private String moTa;

    @NotNull(message = "{sanpham.trangThai.notnull}")
    private Integer trangThai;
}
