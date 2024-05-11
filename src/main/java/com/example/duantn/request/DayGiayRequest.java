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
public class DayGiayRequest {
    private UUID id;

    @NotBlank(message = "{daygiay.ma.notblank}")
    private String ma;

    @NotBlank(message = "{daygiay.ten.notblank}")
    @Size(min=1, max=30, message = "{daygiay.ten.size}")
    private String ten ;

    @NotBlank(message = "{daygiay.moTa.notblank}")
    private String moTa;

    @NotNull(message = "{daygiay.trangThai.notnull}")
    private Integer trangThai;
}
