package com.example.duantn.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "KichThuoc")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class KichCo extends BaseModel{

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "MoTa")
    private String moTa;

}
