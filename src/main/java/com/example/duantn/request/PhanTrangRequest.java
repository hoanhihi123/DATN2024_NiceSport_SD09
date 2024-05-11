package com.example.duantn.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PhanTrangRequest {
    private Integer currentPage;
    private Integer pageLimit;
    private UUID idHoaDon;
    private String textSearch_SDT_KhachHang;
    private Double tongTienDonHang;

}
