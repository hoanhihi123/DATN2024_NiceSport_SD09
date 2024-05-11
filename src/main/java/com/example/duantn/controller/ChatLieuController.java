package com.example.duantn.controller;

import com.example.duantn.dto.Constant;
import com.example.duantn.model.ChatLieu;
import com.example.duantn.request.ChatLieuRequest;
import com.example.duantn.service.impl.ChatLieuServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/chat-lieu")
public class ChatLieuController {
    @Autowired
    ChatLieuServiceImpl chatLieuService;

    @GetMapping("/hien-thi")
    public String index(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") int currentPage,
            HttpServletRequest request
    ) {
        model.addAttribute("chatLieu", new ChatLieu());
        String textSearch = request.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<ChatLieu> pageChatLieu = chatLieuService.layDanhSach(textSearch, pageable);
        List<ChatLieu> chatLieus = pageChatLieu.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL", pageChatLieu.getNumberOfElements());
        model.addAttribute("totalPage", pageChatLieu.getTotalPages());
        model.addAttribute("dsChatLieu", chatLieus);
        model.addAttribute("pageChoosedNumber", currentPage);
        return "admin/chatLieu/create";
    }

    @GetMapping("/view-sua/{id}")
    public String view_sua(
            @PathVariable("id") UUID id,
            @ModelAttribute("chatLieu") ChatLieuRequest chatLieu,
            Model model
    ) {
        ChatLieu chatLieu1 = chatLieuService.chiTietTheoId(id);
        model.addAttribute("chatLieu", chatLieu1);
//        System.out.println("chatLieu : " + chatLieu1.getId());
        return "admin/chatLieu/update";
    }

    @PostMapping("/sua/{id}")
    public String sua(
            @PathVariable("id") UUID id,
            @Valid @ModelAttribute("chatLieu") ChatLieuRequest chatLieu,
            BindingResult result,
            HttpServletRequest request,
            Model model
    ) throws ParseException {
        if (result.hasErrors()) {
            return "admin/chatLieu/update";
        }

        ChatLieu chatLieuCu = chatLieuService.chiTietTheoId(id);

        if (chatLieuService.kiemTraTrungMaKhong(chatLieu.getMa(), chatLieuCu.getMa())) {
            model.addAttribute("trungMa", true);
             return "admin/chatLieu/update";
        }

        if (chatLieuService.kiemTraTrungTenKhong(chatLieu.getTen(), chatLieuCu.getTen())) {
            model.addAttribute("trungTen", true);
             return "admin/chatLieu/update";
        }

        ChatLieu ChatLieuUpdate = new ChatLieu();
        ChatLieuUpdate.setId(chatLieuCu.getId());
        ChatLieuUpdate.setMa(chatLieu.getMa());
        ChatLieuUpdate.setTen(chatLieu.getTen());
        ChatLieuUpdate.setMoTa(chatLieu.getMoTa());

        Integer trangThai = chatLieu.getTrangThai();
        ChatLieuUpdate.setTrangThai(trangThai);
        ChatLieuUpdate.setNgaySua(Constant.getDateNow());

        ChatLieuUpdate.setNgayTao(chatLieuCu.getNgayTao());
        ChatLieuUpdate.setNguoiSua(chatLieuCu.getNguoiSua());
        ChatLieuUpdate.setNguoiTao(chatLieuCu.getNguoiTao());

        chatLieuService.capNhat(ChatLieuUpdate);
        model.addAttribute("chatLieu", chatLieu);
        model.addAttribute("messageSuccess", true);

        return "redirect:/chat-lieu/hien-thi";
    }

    @PostMapping("/them")
    public String themMoi(Model model,
                          @Valid @ModelAttribute("chatLieu")
                          ChatLieuRequest request, BindingResult result,
                          @RequestParam(name = "page", defaultValue = "0")
                          int currentPage,
                          HttpServletRequest httpServletRequest)
            throws ParseException {
        if (result.hasErrors()) {
            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<ChatLieu> pageChatLieu = chatLieuService.layDanhSach(textSearch, pageable);
            List<ChatLieu> chatLieus = pageChatLieu.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageChatLieu.getNumberOfElements());
            model.addAttribute("totalPage", pageChatLieu.getTotalPages());
            model.addAttribute("dsChatLieu", chatLieus);
            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/chatLieu/create";
        }


        if (chatLieuService.kiemTraTrungMaKhong(request.getMa())) {
//            System.out.println("Trùng mã rồi ...");
            model.addAttribute("trungMa", true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<ChatLieu> pageChatLieu = chatLieuService.layDanhSach(textSearch, pageable);
            List<ChatLieu> chatLieus = pageChatLieu.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageChatLieu.getNumberOfElements());
            model.addAttribute("totalPage", pageChatLieu.getTotalPages());
            model.addAttribute("dsChatLieu", chatLieus);
            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/chatLieu/create";
        }

        if (chatLieuService.kiemTraTrungTenKhong(String.valueOf(request.getTen()))) {
            model.addAttribute("trungTen", true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<ChatLieu> pageChatLieu = chatLieuService.layDanhSach(textSearch, pageable);
            List<ChatLieu> chatLieus = pageChatLieu.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL", pageChatLieu.getNumberOfElements());
            model.addAttribute("totalPage", pageChatLieu.getTotalPages());
            model.addAttribute("dsChatLieu", chatLieus);
            model.addAttribute("pageChoosedNumber", currentPage);
            return "admin/chatLieu/create";
        }
        ChatLieu chatLieuThemMoi = new ChatLieu();
        chatLieuThemMoi.setId(null);
        chatLieuThemMoi.setTen(request.getTen());
        chatLieuThemMoi.setMa(request.getMa());
        chatLieuThemMoi.setMoTa(request.getMoTa());
        chatLieuThemMoi.setNguoiTao(1);
        chatLieuThemMoi.setNguoiSua(1);
        chatLieuThemMoi.setNgayTao(Constant.getDateNow());
        chatLieuThemMoi.setNgaySua(Constant.getDateNow());
        chatLieuThemMoi.setTrangThai(request.getTrangThai());

        chatLieuService.themMoi(chatLieuThemMoi);
        model.addAttribute("chatLieu", new ChatLieuRequest());
        model.addAttribute("messageSuccess", true);

        String textSearch = httpServletRequest.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<ChatLieu> pageChatLieu = chatLieuService.layDanhSach(textSearch, pageable);
        List<ChatLieu> chatLieus = pageChatLieu.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL", pageChatLieu.getNumberOfElements());
        model.addAttribute("totalPage", pageChatLieu.getTotalPages());
        model.addAttribute("dsChatLieu", chatLieus);
        model.addAttribute("pageChoosedNumber", currentPage);
        return "admin/chatLieu/create";
    }

    @GetMapping("/xoa/{id}")
    public String xoa(
            @PathVariable("id") UUID id
    ) {
        ChatLieu chatLieux = chatLieuService.chiTietTheoId(id);
        chatLieuService.xoa(id);
        return "redirect:/chat-lieu/hien-thi";
    }
}
