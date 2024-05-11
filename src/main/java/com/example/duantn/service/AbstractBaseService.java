package com.example.duantn.service;

import com.example.duantn.model.BaseModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@SuppressWarnings("all")
// E là entity và extend để sử dụng được các thuộc tính trong basemodel
// implements baseservice : implements các phương thức trong interface BaseService
public abstract class AbstractBaseService<E extends BaseModel> implements BaseService<E> {
    @Autowired
    protected JpaRepository<E, UUID> repo;

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public Page<E> layDanhSach(Pageable pageable) {
        return repo.findAll(pageable);
    }

    // tìm kiếm theo thông tin của entity truyền vào
    public List<E> findByCondition(E entity) {
        return this.repo.findAll(Example.of(entity));
    }

    @Override
    public Page<E> layDanhSach(String textSearch, Pageable pageable) {
        return null;
    }


    // tìm kiếm và phân trang
    public Page<E> findPage(E entity, Pageable pageable) {
        Example<E> eExample = Example.of(entity);
        return this.repo.findAll(eExample, pageable);
    }

    @Override
    public void xoa(UUID id) {
        this.repo.deleteById(id);
    }

    @Override
    public void themMoi(E entity) {
//        this.validateInsert(entity);
        this.repo.save(entity);
    }

    @Override
    public void capNhat(E entity) {
        repo.save(entity);
    }


    @Override
    public E chiTietTheoId(UUID id) {
        return this.repo.findById(id).orElse(null);
    }

    @Override
    public List<E> layDanhSachTheoTen(String ten) {
        return null;
    }

//    protected abstract void validateInsert(E entity);
}
