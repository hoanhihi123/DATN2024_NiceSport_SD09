package com.example.duantn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "ChucVu")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChucVu extends BaseModel {

    @Column(name = "Ma")
    private String ma;

    @NotBlank(message = "Vui lòng không để trống tên ")
    @Column(name = "Ten")
    private String ten;

}
