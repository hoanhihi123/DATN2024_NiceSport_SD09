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
public class NSXRequest {

    private UUID id;

    @NotBlank(message = "{nsx.ma.notblank}")
    private String ma;

    @NotBlank(message = "{nsx.ten.notblank}")
    @Size(min=1, max=30, message = "{nsx.ten.size}")
    private String ten ;

//        @NotBlank(message = "{nsx.moTa.notblank}")
//        private String moTa;

    @NotNull(message = "{nsx.trangThai.notnull}")
    private Integer trangThai;
}