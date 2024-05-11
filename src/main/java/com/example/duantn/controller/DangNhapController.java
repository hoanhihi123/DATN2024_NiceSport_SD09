package com.example.duantn.controller;

import com.example.duantn.model.KhachHang;
import com.example.duantn.service.impl.KhachHangServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class DangNhapController {
    @Autowired
    private KhachHangServiceImpl khachHangService;
    @GetMapping("/dangNhap")
    public String showLoginPage() {
        return "customer/dangnhap/dangNhap";
    }

    @GetMapping("/login")
    public String showLoginPage1() {
        return "customer/dangnhap/login";
    }

    @GetMapping("/welcome")
    public String showWelcomePage1(Model model, Principal principal) {
        if (principal != null) {
            String taiKhoan = principal.getName(); // Lấy tên đăng nhập của người dùng đã đăng nhập
            KhachHang khachHang = khachHangService.getCustomerByTaiKhoan(taiKhoan);
            if (khachHang != null) {
                model.addAttribute("welcomeMessage", "welcome, " + khachHang.getTaiKhoan() + "!");
                System.out.println("chạy vào đây chưa");
                model.addAttribute("khachHang", khachHang); // Thêm thông tin khách hàng vào model
            }
        }

        // Kiểm tra xem thông tin khachHang đã được thêm vào model hay chưa
        if (model.containsAttribute("khachHang")) {
            // Thuộc tính khachHang đã được thêm vào model
            System.out.println("Thông tin khachHang đã được thêm vào model.");
        } else {
            // Thuộc tính khachHang chưa được thêm vào model
            System.out.println("Thông tin khachHang chưa được thêm vào model.");
        }

        return "customer/dangnhap/trangChu";
    }

    @GetMapping("/trangChu")
    public String showWelcomePage(Model model, Principal principal) {
        if (principal != null) {
            String taiKhoan = principal.getName(); // Lấy tên đăng nhập của người dùng đã đăng nhập
            KhachHang khachHang = khachHangService.getCustomerByTaiKhoan(taiKhoan);
            if (khachHang != null) {
                model.addAttribute("welcomeMessage", "trangChu, " + khachHang.getTaiKhoan() + "!");
                System.out.println("chạy vào đây chưa");
                model.addAttribute("khachHang", khachHang); // Thêm thông tin khách hàng vào model
            }
        }

        // Kiểm tra xem thông tin khachHang đã được thêm vào model hay chưa
        if (model.containsAttribute("khachHang")) {
            // Thuộc tính khachHang đã được thêm vào model
            System.out.println("Thông tin khachHang đã được thêm vào model.");
        } else {
            // Thuộc tính khachHang chưa được thêm vào model
            System.out.println("Thông tin khachHang chưa được thêm vào model.");
        }

        return "customer/dangnhap/trangChu";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("taiKhoan") String taiKhoan, @RequestParam("matKhau") String matKhau, Model model, HttpSession session) {
        if (khachHangService.isValidDangNhap(taiKhoan, matKhau)) {
            KhachHang khachHang = khachHangService.getCustomerByTaiKhoan(taiKhoan);
            if (khachHang != null) {
                // Lưu thông tin tài khoản vào session
                session.setAttribute("taiKhoan", taiKhoan);
                session.setAttribute("ten", khachHang.getHoTen());
                model.addAttribute("khachHang", khachHang);
                model.addAttribute("success", "đăng nhập thành công"); // Thêm thông báo đăng nhập thành công vào model
                return "redirect:/welcome"; // Redirect to welcome page upon successful login
            }
        }
        model.addAttribute("error", "tài khoản mật khẩu không tồn tại");
        model.addAttribute("messageSuccess", true);
        return "customer/dangnhap/login"; // Show login page with error message
    }

    @PostMapping("/dangNhap")
    public String dangNhap(
            @RequestParam("taiKhoan") String taiKhoan, @RequestParam("matKhau") String matKhau, Model model, HttpSession session) {
        if (khachHangService.isValidDangNhap(taiKhoan, matKhau)) {
            KhachHang khachHang = khachHangService.getCustomerByTaiKhoan(taiKhoan);
            if (khachHang != null) {
                // Lưu thông tin tài khoản vào session
                session.setAttribute("taiKhoan", taiKhoan);
                session.setAttribute("ten", khachHang.getHoTen());
                model.addAttribute("khachHang", khachHang);
                model.addAttribute("success", "đăng nhập thành công"); // Thêm thông báo đăng nhập thành công vào model
                return "redirect:/trangChu"; // Redirect to welcome page upon successful login
            }
        }
        model.addAttribute("error", "tài khoản mật khẩu không tồn tại");
        model.addAttribute("messageSuccess", true);
        return "customer/dangnhap/dangNhap"; // Show login page with error message
    }

}
