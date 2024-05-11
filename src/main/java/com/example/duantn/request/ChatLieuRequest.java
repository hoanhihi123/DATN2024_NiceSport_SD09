package com.example.duantn.request;

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
public class ChatLieuRequest {
    private UUID id;

    @NotBlank(message = "{chatlieu.ma.notblank}")
    private String ma;

    @NotBlank(message = "{chatlieu.ten.notblank}")
    @Size(min=1, max=30, message = "{chatlieu.ten.size}")
    private String ten ;

    @NotBlank(message = "{chatlieu.moTa.notblank}")
    private String moTa;

    @NotNull(message = "{chatlieu.trangThai.notnull}")
    private Integer trangThai;
}
