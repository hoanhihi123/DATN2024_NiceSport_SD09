package com.example.duantn.controller;

import com.example.duantn.dto.Constant;
import com.example.duantn.model.LotGiay;
import com.example.duantn.request.LotGiayReques;
import com.example.duantn.service.impl.LotGiayServiceImpl;
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
@RequestMapping("/lot-giay")
public class LotGiayController {
   

    @Autowired
    LotGiayServiceImpl lotGiayService;

    //hienthi
    @GetMapping("/hien-thi")
    public String getAll(Model model,
                         @RequestParam(value = "page",defaultValue = "0")int currentPage,
                         HttpServletRequest request){
        model.addAttribute("lotGiay", new LotGiay());
        String textSearch = request.getParameter("textsearch");
        
        //phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<LotGiay> pageLotGiay =  lotGiayService.layDanhSach(textSearch, pageable);
        List<LotGiay> lotGiays = pageLotGiay.getContent();
        //muon hien thi so trang
        model.addAttribute("tongSL",pageLotGiay.getNumberOfElements());
        model.addAttribute("totalPage",pageLotGiay.getTotalPages());
        model.addAttribute("listLG", lotGiays);
        model.addAttribute("pageChoosedNumber",currentPage);
    
        return "admin/LotGiayForm/trangChu";
    }
    @GetMapping("/view-sua/{id}")
    public String view_sua(
            @PathVariable("id") UUID id ,
            @ModelAttribute("lotGiay") LotGiayReques lotGiay,
            Model model
    ) {
        LotGiay lotGiay1 = lotGiayService.chiTietTheoId(id);
        model.addAttribute("lotGiay",lotGiay1);
        return "admin/LotGiayForm/update";
    }

    @PostMapping("/sua/{id}")
    public String sua(
            @PathVariable("id") UUID id ,
            @Valid @ModelAttribute("lotGiay") LotGiayReques lotGiay,
            BindingResult result ,
            HttpServletRequest request ,
            Model model
    ) throws ParseException {

        if(result.hasErrors()){
            return "admin/LotGiayForm/update";
        }

        LotGiay lotGiay1 = lotGiayService.chiTietTheoId(id);

        if(lotGiayService.kiemTraTrungMaKhong(lotGiay.getMa(), lotGiay1.getMa())){
            model.addAttribute("trungMa",true);
            return "admin/LotGiayForm/update";
        }

        if(lotGiayService.kiemTraTrungTenKhong(String.valueOf(lotGiay.getTen()), lotGiay1.getTen())){
            model.addAttribute("trungTen",true);
            return "admin/LotGiayForm/update";
        }

        LotGiay lotGiayUpdate = new LotGiay();
        lotGiayUpdate.setId(lotGiay1.getId());
        lotGiayUpdate.setMa(lotGiay.getMa());
        lotGiayUpdate.setTen(String.valueOf(lotGiay.getTen()));
        lotGiayUpdate.setMoTa(lotGiay.getMoTa());

        Integer trangThai = lotGiay.getTrangThai();
        lotGiayUpdate.setTrangThai(trangThai);
        lotGiayUpdate.setNgaySua(Constant.getDateNow());

        lotGiayUpdate.setNgayTao(lotGiay1.getNgayTao());
        lotGiayUpdate.setNguoiSua(lotGiay1.getNguoiSua());
        lotGiayUpdate.setNguoiTao(lotGiay1.getNguoiTao());

        lotGiayService.capNhat(lotGiayUpdate);
        System.out.println("Sửa dữ liệu thành công");

        model.addAttribute("lotGiay",lotGiay);
        model.addAttribute("messageSuccess",true);

        return "admin/LotGiayForm/update";
    }

    @PostMapping("/them")
    public String themMoi(
            Model model,
            @Valid @ModelAttribute("lotGiay") LotGiayReques request,
            BindingResult result ,
            @RequestParam(name = "page",defaultValue = "0") int currentPage ,
            HttpServletRequest httpServletRequest
    ) throws ParseException
    {
        if(result.hasErrors()){
            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage,Constant.pageNumber);
            Page<LotGiay> pageLotGiay =  lotGiayService.layDanhSach(textSearch, pageable);
            List<LotGiay> lotGiays = pageLotGiay.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL",pageLotGiay.getNumberOfElements());
            model.addAttribute("totalPage",pageLotGiay.getTotalPages());
            model.addAttribute("listLG", lotGiays);
            model.addAttribute("pageChoosedNumber",currentPage);
//            System.out.println("Lỗi nhưng không hiển thị lỗi");
//            System.out.println("Error basic : " + result.toString());
            return "admin/LotGiayForm/trangChu";
        }
//        System.out.println("Mã request : " + request.getMa());
        if(lotGiayService.kiemTraTrungMaKhong(request.getMa())){
//            System.out.println("Trùng mã rồi ...");
            model.addAttribute("trungMa",true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<LotGiay> pageLotGiay =  lotGiayService.layDanhSach(textSearch, pageable);
            List<LotGiay> lotGiays = pageLotGiay.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL",pageLotGiay.getNumberOfElements());
            model.addAttribute("totalPage",pageLotGiay.getTotalPages());
            model.addAttribute("listLG", lotGiays);
            return "admin/LotGiayForm/trangChu";
        }

        if(lotGiayService.kiemTraTrungTenKhong(String.valueOf(request.getTen()))){
            model.addAttribute("trungTen",true);

            String textSearch = httpServletRequest.getParameter("textsearch");

            // phan trang
            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            Page<LotGiay> pageLotGiay =  lotGiayService.layDanhSach(textSearch, pageable);
            List<LotGiay> lotGiays = pageLotGiay.getContent();

            // muon hien thi so trang
            model.addAttribute("tongSL",pageLotGiay.getNumberOfElements());
            model.addAttribute("totalPage",pageLotGiay.getTotalPages());
            model.addAttribute("listLG", lotGiays);
            return "admin/LotGiayForm/trangChu";
        }

        LotGiay LotGiayThemMoi = new LotGiay();
        LotGiayThemMoi.setMa(request.getMa());
        LotGiayThemMoi.setTen(String.valueOf(request.getTen()));
        LotGiayThemMoi.setMoTa(request.getMoTa());
        LotGiayThemMoi.setNguoiTao(1);
        LotGiayThemMoi.setNguoiSua(1);
        LotGiayThemMoi.setNgayTao(Constant.getDateNow());
        LotGiayThemMoi.setNgaySua(Constant.getDateNow());
        LotGiayThemMoi.setTrangThai(1);

        lotGiayService.themMoi(LotGiayThemMoi);

        model.addAttribute("lotGiay",new LotGiayReques());
        model.addAttribute("messageSuccess",true);

        // cập nhật nội dung mới lên table
        String textSearch = httpServletRequest.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage,Constant.pageNumber);
        Page<LotGiay> pageLotGiay =  lotGiayService.layDanhSach(textSearch, pageable);
        List<LotGiay> LotGiays = pageLotGiay.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL",pageLotGiay.getNumberOfElements());
        model.addAttribute("totalPage",pageLotGiay.getTotalPages());
        model.addAttribute("listLG", LotGiays);
        model.addAttribute("pageChoosedNumber",currentPage);

        return "admin/LotGiayForm/trangChu";
    }

    @GetMapping("/xoa/{id}")
    public String xoa(
            @PathVariable("id") UUID id
    ) {
        LotGiay LotGiayx = lotGiayService.chiTietTheoId(id);
        lotGiayService.xoa(id);
        return "redirect:/lot-giay/hien-thi";
    }
   
}
