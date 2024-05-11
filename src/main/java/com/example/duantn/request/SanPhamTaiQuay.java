package com.example.duantn.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamTaiQuay {
    private UUID idKichCo;
    private UUID idLoaiSP;
    private UUID idMauSac;
    private String tenSP;
    private Integer currentPage;
    private Integer pageLimit;
}
