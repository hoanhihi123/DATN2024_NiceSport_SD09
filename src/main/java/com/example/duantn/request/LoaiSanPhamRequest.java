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
public class LoaiSanPhamRequest {
    private UUID id;

    @NotBlank(message = "{loaisanpham.ma.notblank}")
    private String ma;

    @NotBlank(message = "{loaisanpham..ten.notblank}")
    @Size(min=1, max=30, message = "{loaisanpham..ten.size}")
    private String ten ;

//    @NotBlank(message = "{loaisanpham..moTa.notblank}")
//    private String moTa;

    @NotNull(message = "{loaisanpham..trangThai.notnull}")
    private Integer trangThai;
}