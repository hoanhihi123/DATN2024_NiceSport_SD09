package com.example.duantn.request;

import com.example.duantn.model.DanhMuc;
import com.example.duantn.model.ThuongHieu;
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
public class ChiTietSPRequest {
    private UUID id;

    @NotBlank(message = "{chiTietSP.ma.notblank}")
    private String ma;

    @NotBlank(message = "{chiTietSP.ten.notblank}")
    @Size(min=8, max=50, message = "{chiTietSP.ten.size}")
    private String ten ;

    @NotNull(message = "{chiTietSP.idDanhMuc.notnull}")
    private DanhMuc danhMuc;

    @NotNull(message = "{chiTietSP.idThuongHieu.notnull}")
    private ThuongHieu thuongHieu;
}
