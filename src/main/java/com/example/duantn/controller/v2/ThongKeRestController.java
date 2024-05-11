package com.example.duantn.controller.v2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;
import com.example.duantn.repository.HoaDonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ThongKeRestController {
    @Autowired
    HoaDonRepository hoaDonRepository;

    @GetMapping("/api/v2/thongke/{DieuKien}")
    public ResponseEntity<?> getADDoanhThuHoaHong(
            @PathVariable("DieuKien") String dieuKien) {
        try {
            List<Map<String, Object>> result = hoaDonRepository.ADTKDoanhThu(dieuKien);
            Double totalAmount = 0.0;
            for (Map<String, Object> item: result){
                totalAmount += Double.parseDouble(item.get("TotalRevenue").toString());
            }

            Map<String, Object> responseThongKe = new HashMap<>();
            responseThongKe.put("result", result);
            responseThongKe.put("totalAmount", totalAmount);

            return ResponseEntity.ok(new ObjectMapper().writeValueAsString(responseThongKe));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"errorCode\": \"FAIL - GETTHONGKE\"}");
        }
    }
}