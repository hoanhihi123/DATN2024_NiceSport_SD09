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
public class DeGiayRequest {
    private UUID id;

    @NotBlank(message = "{degiay.ma.notblank}")
    private String ma;

    @NotBlank(message = "{degiay.ten.notblank}")
    @Size(min=1, max=30, message = "{degiay.ten.size}")
    private String ten ;

    @NotBlank(message = "{degiay.moTa.notblank}")
    private String moTa;

    @NotNull(message = "{degiay.trangThai.notnull}")
    private Integer trangThai;
}
