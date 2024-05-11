package com.example.duantn.service;

import com.example.duantn.model.LotGiay;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface LotGiayService {
    List<LotGiay> getAll();
    void delete(UUID id);
    void add(LotGiay lotGiay);
    LotGiay detail(UUID id);
    LotGiay update(UUID id,LotGiay lotGiay);
}
