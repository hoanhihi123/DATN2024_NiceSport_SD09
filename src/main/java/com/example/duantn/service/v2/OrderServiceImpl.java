package com.example.duantn.service.v2;

import com.example.duantn.model.HoaDon;
import com.example.duantn.repository.HoaDonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OrderServiceImpl implements OrderService{
    private final HoaDonRepository hoaDonRepository;
    @Override
    public HoaDon get(UUID id) {
        return hoaDonRepository.findById(id).orElse(null);
    }
}
