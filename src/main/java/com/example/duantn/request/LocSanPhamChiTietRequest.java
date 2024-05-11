package com.example.duantn.request;

import com.example.duantn.model.KichCo;
import com.example.duantn.model.LoaiSanPham;
import com.example.duantn.model.MauSac;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocSanPhamChiTietRequest {
    private List<String> ds_uuid_loaiSP;
    private List<String> ds_uuid_mauSac;
    private List<String> ds_uuid_sizeGiay;
}
