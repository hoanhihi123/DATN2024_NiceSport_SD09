package com.example.duantn.service;

import com.example.duantn.model.BaseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface BaseService <E extends BaseModel>{

//    List<E> findByCondition(E entity);
    
    Page<E> layDanhSach(Pageable pageable) ;

    Page<E> layDanhSach(String textSearch, Pageable pageable);

//    Page<E> findPage(E entity, Pageable pageable) ;

    void xoa(UUID id) ;

    void themMoi(E entity);

    void capNhat( E entity) ;

    E chiTietTheoId(UUID id) ;

    List<E> layDanhSachTheoTen(String ten);

    List<E> layDanhSach() ;

}
