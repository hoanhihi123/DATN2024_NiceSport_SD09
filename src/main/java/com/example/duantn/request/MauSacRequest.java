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
public class MauSacRequest {
    private UUID id;

    @NotBlank(message = "{mausac.ma.notblank}")
    private String ma;

    @NotBlank(message = "{mausac.ten.notblank}")
    @Size(min=1, max=30, message = "{mausac.ten.size}")
    private String ten ;

    @NotBlank(message = "{mausac.moTa.notblank}")
    private String moTa;

    @NotNull(message = "{mausac.trangThai.notnull}")
    private Integer trangThai;
}

