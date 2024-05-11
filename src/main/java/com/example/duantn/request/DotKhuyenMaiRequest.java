package com.example.duantn.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DotKhuyenMaiRequest {
//    private UUID id;

    @NotBlank(message = "{giamgia.ma.notblank}")
    private String ma;

    private double giaTriGiam;

    @NotBlank(message = "{giamgia.ten.notblank}")
    @Size(min=1, max=30, message = "{giamgia.ten.size}")
    private String ten;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Định dạng ngày tháng năm, giờ phút giây
    private Date ngayBatDau;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Định dạng ngày tháng năm, giờ phút giây
    private Date ngayKetThuc;

    private Integer trangThai;
    private UUID[] selectedProducts;
}
