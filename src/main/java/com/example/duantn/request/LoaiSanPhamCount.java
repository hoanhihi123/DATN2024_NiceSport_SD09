package com.example.duantn.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoaiSanPhamCount {
    private UUID id_loaiSP;
    private String tenLoaiSP;
    private Integer soLuongLoaiSP;
}
