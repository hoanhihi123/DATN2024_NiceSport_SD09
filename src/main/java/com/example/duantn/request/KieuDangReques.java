package com.example.duantn.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class    KieuDangReques {
    private UUID id;

    @NotBlank(message = "{kieudang.ma.notblank}")
    private String ma;

    @NotNull(message = "{kieudang.ten.notblank}")
    private String ten ;

    @NotBlank(message = "{kieudang.moTa.notblank}")
    private String moTa;

    @NotNull(message = "{kieudang.trangThai.notnull}")
    private Integer trangThai;
}
