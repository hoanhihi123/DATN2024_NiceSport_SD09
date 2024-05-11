package com.example.duantn.request;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GiamGiaRequest {
    private UUID id;
    @NotBlank(message = "{giamgia.ma.notblank}")
    private String ma;
    private double giaTriGiam;
    @NotBlank(message = "{giamgia.ten.notblank}")
    @Size(min=1, max=30, message = "{giamgia.ten.size}")
    private String ten;
    @NotNull(message = "{giamgia.tensanpham.notnull}")
    private UUID idSanPham = UUID.randomUUID();
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private Integer trangThai;
}