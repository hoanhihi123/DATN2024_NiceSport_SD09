package com.example.duantn.request;

import com.example.duantn.model.ChucVu;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NhanVienRequest {

    private UUID id;

    private String ma;

    @NotBlank(message = "{nhanVien.tenNhanVien.notblank}")
    @Size(max=50, message = "{nhanVien.tenNhanVien.size}")
    private String hoVaTen ;

    @NotNull(message = "{nhanVien.gioiTinh.notnull}")
    private Integer gioiTinh;

    @NotBlank(message = "{nhanVien.tenTaiKhoan.notblank}")
    private String taiKhoan;

    @NotBlank(message = "{nhanVien.matKhau.notblank}")
    private String matKhau;

    @NotNull(message = "{nhanVien.idChucVu.notnull}")
    private ChucVu chucVu;

    @NotNull(message = "{nhanVien.ngaySinh.notnull}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySinh;

    @NotBlank(message = "{nhanVien.email.notblank}")
    private String email;

    @NotBlank(message = "{nhanVien.sdt.notblank}")
    private String sdt;

    @NotBlank(message = "{nhanVien.diaChi.notblank}")
    private String diaChi;

    @NotNull(message = "{nhanVien.trangThai.notnull}")
    private Integer trangThai;

}
