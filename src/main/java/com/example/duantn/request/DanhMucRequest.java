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
public class DanhMucRequest {
    private UUID id;

    @NotBlank(message = "{danhmuc.ma.notblank}")
    private String ma;

    @NotBlank(message = "{danhmuc.ten.notblank}")
    @Size(min=1, max=30, message = "{danhmuc.ten.size}")
    private String ten ;

    @NotBlank(message = "{danhmuc.moTa.notblank}")
    private String moTa;

    @NotNull(message = "{danhmuc.trangThai.notnull}")
    private Integer trangThai;
}
