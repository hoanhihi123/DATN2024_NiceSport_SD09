package com.example.duantn.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "MuiGiay")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MuiGiay extends BaseModel{

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "MoTa")
    private String moTa;

}
