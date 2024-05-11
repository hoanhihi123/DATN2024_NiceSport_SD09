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
public class DiaChiRequest {
    private UUID id;

    @NotBlank(message = "{diachi.ma.notblank}")
    private String ma;

    @NotBlank(message = "{diachi.tendiachi.notblank}")
    @Size(min=1, max=30, message = "{diachi.tendiachi.size}")
    private String ten ;

    @NotBlank(message = "{diachi.moTa.notblank}")
    private String moTa;

    @NotBlank(message = "{diachi.thanhPho.notblank}")
    private String thanhPho;

    @NotNull(message = "{diachi.tenkhachhang.notnull}")
    private KhachHang khachHang;

    @NotBlank(message = "{diachi.huyen.notblank}")
    private String huyen;

    @NotBlank(message = "{diachi.xa.notblank}")
    private String xa;

    @NotBlank(message = "{diachi.trangThai.notblank}")
    private String trangThai;

}
