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
public class ThuongHieuRequest {
    private UUID id;

    @NotBlank(message = "{thuonghieu.ma.notblank}")
    private String ma;

    @NotBlank(message = "{thuonghieu.ten.notblank}")
    @Size(min=1, max=30, message = "{thuonghieu.ten.size}")
    private String ten ;

    @NotBlank(message = "{thuonghieu.moTa.notblank}")
    private String moTa;

    @NotNull(message = "{thuonghieu.trangThai.notnull}")
    private Integer trangThai;
}
