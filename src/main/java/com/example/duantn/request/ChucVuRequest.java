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
public class ChucVuRequest {
    private UUID id;

    @NotBlank(message = "{chucvu.ma.notblank}")
    private String ma;

    @NotBlank(message = "{chucvu.ten.notblank}")
    @Size(min=1, max=30, message = "{chucvu.ten.size}")
    private String ten ;

    @NotNull(message = "{chucvu.trangThai.notnull}")
    private Integer trangThai;
}
