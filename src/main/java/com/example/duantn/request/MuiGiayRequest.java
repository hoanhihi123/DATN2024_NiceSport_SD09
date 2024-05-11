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
public class MuiGiayRequest {
    private UUID id;

    @NotBlank(message = "{muigiay.ma.notblank}")
    private String ma;

    @NotBlank(message = "{muigiay.ten.notblank}")
    @Size(min=8, max=50, message = "{muigiay.ten.size}")
    private String ten ;

    @NotBlank(message = "{muigiay.moTa.notblank}")
    private String moTa;

    @NotNull(message = "{muigiay.trangThai.notnull}")
    private Integer trangThai;
}
