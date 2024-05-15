package com.example.duantn.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhieuGiamGiaRequest {
    private UUID id;

    @NotBlank(message = "{phieuGiamGia.maPhieu.notblank}")
    private String ma;

    @NotBlank(message = "{phieuGiamGia.tenPhieu.notblank}")
    @Length(min=5, max=100, message = "Vui lòng nhập tên tối thiếu 5 kí tự ")
    private String tenPhieu;

    @NotNull(message = "Vui lòng nhập giá trị")
    private Double giaTriGiam;



    private Integer trangThai;
}