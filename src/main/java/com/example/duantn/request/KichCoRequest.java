package com.example.duantn.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KichCoRequest {
    private UUID id;

    @NotBlank(message = "{kichco.ma.notblank}")
    private String ma;

    @NotNull(message = "{kichco.ten.notnull}")
    @Min(value = 34, message = "{kichco.ten.size}")
    @Max(value = 50, message = "{kichco.ten.size}")
    private Integer ten ;

    @NotBlank(message = "{kichco.moTa.notblank}")
    private String moTa;

    @NotNull(message = "{kichco.trangThai.notnull}")
    private Integer trangThai;
}
