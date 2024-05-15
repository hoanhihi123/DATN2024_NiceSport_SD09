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
public class NhanVienRequest  {

    private UUID id;

    @NotBlank(message = "Vui lòng nhập mã")
    private String ma;

    @NotBlank(message = "Vui lòng nhập tên nhân viên")
    @Size(min=6,max=50, message = "{nhanVien.tenNhanVien.size}")
    private String hoVaTen ;

    @NotNull(message = "{nhanVien.gioiTinh.notnull}")
    private Integer gioiTinh;

    @NotBlank(message = "{nhanVien.tenTaiKhoan.notblank}")
    private String taiKhoan;

    @NotBlank(message = "{nhanVien.matKhau.notblank}")
    private String matKhau;

    private ChucVu chucVu;

    @NotNull(message = "{nhanVien.ngaySinh.notnull}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySinh;


    @NotBlank(message = "{nhanVien.sdt.notblank}")
    @Size(min = 10,max = 10, message = "số điện thoại không hợp lệ")
    private String sdt;

    @NotBlank(message = "{nhanVien.diaChi.notblank}")
    private String diaChi;

    private Integer trangThai;

}