package com.example.duantn.controller.admin;

import com.example.duantn.dto.Constant;
import com.example.duantn.model.*;
import com.example.duantn.request.ChiTietSanPham_themRequest;
import com.example.duantn.request.SanPhamRequest;
import com.example.duantn.service.impl.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

@Controller
@RequestMapping("/admin/quanLySanPham")   //  /admin/quanLySanPham/viewSuaSanPhamChiTiet/
public class QLSanPhamController {

    @Autowired
    SanPhamServiceImpl sanPhamService;

    @Autowired
    ThuongHieuServiceImpl thuongHieuService;

    @Autowired
    NSXServiceImpl nsxService;

    @Autowired
    DanhMucServiceImpl danhMucService;

    @Autowired
    LoaiSanPhamServiceImpl loaiSanPhamService;

    @Autowired
    KieuDangServiceImpl kieuDangService;

    @Autowired
    ChatLieuServiceImpl chatLieuService;

    @Autowired
    MuiGiayServiceImpl muiGiayService;

    @Autowired
    DayGiayServiceImpl dayGiayService;

    @Autowired
    DeGiayServiceImpl deGiayService;

    @Autowired
    LotGiayServiceImpl lotGiayService;

    @Autowired
    ChiTietSPServiceImpl chiTietSPService;

    @Autowired
    MauSacServiceImpl mauSacService;

    @Autowired
    HinhAnhGiaysService hinhAnhGiaysService;


    @Autowired
    KichCoServiceImpl kichCoService;

    @Autowired
    HinhAnhGiaysService hinhAnhGiayService;

    @GetMapping("/hien-thi")
    public String index(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") int currentPage,
            HttpServletRequest request
    ) {
        model.addAttribute("sanPham", new SanPham());
        String textSearch = request.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<SanPham> pageSanPham =  sanPhamService.layDanhSach(textSearch, pageable);
        List<SanPham> sanPhams = pageSanPham.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL",pageSanPham.getNumberOfElements());
        model.addAttribute("totalPage",pageSanPham.getTotalPages());
        model.addAttribute("dsSanPham", sanPhams);
        model.addAttribute("pageChoosedNumber",currentPage);
        return "admin/quanLySanPham/qLSanPham";
    }

    @GetMapping("/view-tao-sanPhamChiTiet")
    public String quanLySanPhamChiTiet(
            Model model,
            @RequestParam(name = "page",defaultValue = "0") int currentPage ,
            HttpServletRequest request ,
            @ModelAttribute("sanPhamChiTiet") ChiTietSanPham_themRequest chiTietSP_request
    ) {
        model.addAttribute("sanPhamChiTiet", new ChiTietSanPham());
        String textSearch = request.getParameter("textsearch");

        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<SanPham> pageSanPham =  sanPhamService.layDanhSach(textSearch, pageable);
        List<SanPham> sanPhams = pageSanPham.getContent();

        // muon hien thi so trang
        model.addAttribute("tongSL",pageSanPham.getNumberOfElements());
        model.addAttribute("totalPage",pageSanPham.getTotalPages());
        model.addAttribute("dsSanPham", sanPhams);
        model.addAttribute("pageChoosedNumber",currentPage);
        return "admin/quanLySanPham/qlSanPhamChiTiet";
    }


    @PostMapping("/taoSanPhamChiTiet")
    public String taoSanPhamChiTiet(
            final Model model
            , final HttpServletRequest request
            , final HttpServletResponse response
            ,  ChiTietSanPham_themRequest chiTietSP_request
            , @ModelAttribute("sanPhamChiTiet") ChiTietSanPham_themRequest chiTietSanPham
            , @RequestParam("duongDanAnhChinh") MultipartFile fileAnhChinh
            , @RequestParam("duongDanAnhCon") MultipartFile[] cacFileAnhCon
            ) throws IOException, ParseException {
        SanPham sanPhamThem = new SanPham();
        sanPhamThem = sanPhamService.chiTietTheoId(chiTietSP_request.getIdSanPham());

        ThuongHieu thuongHieuThem = new ThuongHieu();
        thuongHieuThem = thuongHieuService.chiTietTheoId(chiTietSP_request.getIdThuongHieu());

        NSX nsxThem = new NSX();
        nsxThem = nsxService.chiTietTheoId(chiTietSP_request.getIdNSX());

        DanhMuc danhMucThem = new DanhMuc();
        danhMucThem = danhMucService.chiTietTheoId(chiTietSP_request.getIdDanhMuc());

        LoaiSanPham loaiSanPhamThem = new LoaiSanPham();
        loaiSanPhamThem = loaiSanPhamService.chiTietTheoId(chiTietSP_request.getIdLoaiSanPham());

        KieuDang kieuDangThem = new KieuDang();
        kieuDangThem = kieuDangService.chiTietTheoId(chiTietSP_request.getIdKieuDang());

        ChatLieu chatLieuThem = new ChatLieu();
        chatLieuThem = chatLieuService.chiTietTheoId(chiTietSP_request.getIdChatLieu());

        MuiGiay muiGiayThem = new MuiGiay();
        muiGiayThem = muiGiayService.chiTietTheoId(chiTietSP_request.getIdMuiGiay());

        DayGiay dayGiayThem = new DayGiay();
        dayGiayThem = dayGiayService.chiTietTheoId(chiTietSP_request.getIdDayGiay());

        DeGiay deGiayThem = new DeGiay();
        deGiayThem = deGiayService.chiTietTheoId(chiTietSP_request.getIdDeGiay());

        LotGiay lotGiayThem = new LotGiay();
        lotGiayThem = lotGiayService.chiTietTheoId(chiTietSP_request.getIdLotGiay());

        MauSac mauSacThem = new MauSac();
        mauSacThem = mauSacService.chiTietTheoId(chiTietSP_request.getIdMauSac());

        KichCo kichCoThem = new KichCo();
        kichCoThem = kichCoService.chiTietTheoId(chiTietSP_request.getIdSizeGiay());

            // lưu đường dẫn ảnh vào project : để khi lấy dữ liệu từ DB ra có thể hiển thị được ảnh lên
            String urlSaveImageChinh_resource = "C:/Users/DELL/Documents/DuAnTotNghiep_2024/DATN_Hoan/DATN_SD09/src/main/resources/static/user/assets/imagesgiay/" + fileAnhChinh.getOriginalFilename();

            File luuAnhVaoResource = new File(urlSaveImageChinh_resource);
            fileAnhChinh.transferTo(luuAnhVaoResource);
            // đường dẫn ảnh => lưu vào DB
            String urlAnhChinh_toSaveDB = "/user/assets/imagesgiay/" + fileAnhChinh.getOriginalFilename();
            System.out.println("url save to DB : " + urlAnhChinh_toSaveDB );
            // in ra đường dẫn ảnh chính
            System.out.println("Đường dẫn ảnh chính : " + urlSaveImageChinh_resource);

//            for(MultipartFile anhCon : cacFileAnhCon){
//                String urlDuongDanAnhCon = anhCon.getOriginalFilename();
//                System.out.println("Đường dẫn ảnh con : " + urlDuongDanAnhCon);
//            }

            ChiTietSanPham chiTietSanPhamThemMoi = new ChiTietSanPham();
            chiTietSanPhamThemMoi.setSanPham(sanPhamThem);
            chiTietSanPhamThemMoi.setThuongHieu(thuongHieuThem);
            chiTietSanPhamThemMoi.setNsx(nsxThem);
            chiTietSanPhamThemMoi.setDanhMuc(danhMucThem);
            chiTietSanPhamThemMoi.setLoaiSanPham(loaiSanPhamThem);
            chiTietSanPhamThemMoi.setKieuDang(kieuDangThem);
            chiTietSanPhamThemMoi.setChatLieu(chatLieuThem);
            chiTietSanPhamThemMoi.setMuiGiay(muiGiayThem);
            chiTietSanPhamThemMoi.setDayGiay(dayGiayThem);
            chiTietSanPhamThemMoi.setDeGiay(deGiayThem);
            chiTietSanPhamThemMoi.setLotGiay(lotGiayThem);

            chiTietSanPhamThemMoi.setMauSac(mauSacThem);
            chiTietSanPhamThemMoi.setKichCo(kichCoThem);

            chiTietSanPhamThemMoi.setKhoiLuong(chiTietSP_request.getKhoiLuong());
            chiTietSanPhamThemMoi.setGiaTriSanPham(Double.parseDouble(chiTietSP_request.getGiaTriSanPham()));
            chiTietSanPhamThemMoi.setSoLuong(chiTietSP_request.getSoLuong());

            chiTietSanPhamThemMoi.setMoTa(chiTietSP_request.getMoTa());
            chiTietSanPhamThemMoi.setTrangThai(chiTietSanPham.getTrangThai());
            chiTietSanPhamThemMoi.setHinhAnh(urlAnhChinh_toSaveDB);

          ChiTietSanPham chiTietSanPhamVuaThem = chiTietSPService.themMoi_traVeKetQua(chiTietSanPhamThemMoi);

            for(int i=0;i<cacFileAnhCon.length; i++){

                String urlSaveImageCon_toResource = "C:/Users/DELL/Documents/DuAnTotNghiep_2024/DATN_Hoan/DATN_SD09/src/main/resources/static/user/assets/imagesgiay/"
                        + cacFileAnhCon[i].getOriginalFilename();

                File luuAnhVaoResource2 = new File(urlSaveImageCon_toResource);
                cacFileAnhCon[i].transferTo(luuAnhVaoResource2);

                String urlDuongDanAnhConSaveToDB = "/user/assets/imagesgiay/" +cacFileAnhCon[i].getOriginalFilename();
                System.out.println("Đường dẫn ảnh con : " + urlDuongDanAnhConSaveToDB);
                HinhAnhGiays hinhAnhGiaysThemMoi = new HinhAnhGiays();
                hinhAnhGiaysThemMoi.setChiTietSanPham(chiTietSanPhamVuaThem);
                hinhAnhGiaysThemMoi.setNgayTao(Constant.getDateNow());
                hinhAnhGiaysThemMoi.setNguoiTao(1);
                hinhAnhGiaysThemMoi.setDuongDanAnh(urlDuongDanAnhConSaveToDB);
                hinhAnhGiaysService.themMoi(hinhAnhGiaysThemMoi);
            }

        return "redirect:/admin/quanLySanPham/hien-thi";
    }

    @GetMapping("/viewSanPhamChiTiet/{id}")
    public String view_sua(
            @PathVariable("id") UUID idSanPham ,
            @RequestParam(name = "page",defaultValue = "0") int currentPage ,
            @RequestParam(name = "searchTrangThaiSPCT", defaultValue = "") String trangThai,
            Model model,
            HttpServletRequest request
    ) {
        if(trangThai.equals("")){
            // phan trang
//            Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
            List<ChiTietSanPham> sanPhams = chiTietSPService.layDanhSachTheoIDSanPham(idSanPham);

            // muon hien thi so trang
            model.addAttribute("idSanPham", idSanPham);
            model.addAttribute("dsSanPham", sanPhams);
        }else{
            Integer trangThaiInteger = Integer.parseInt(trangThai);
            System.out.println("Trạng thái integer : " + trangThaiInteger);
            List<ChiTietSanPham> sanPhams = chiTietSPService.layDanhSachTheoIDSanPham_searchTrangThai(trangThaiInteger,idSanPham);

            // muon hien thi so trang
            model.addAttribute("idSanPham", idSanPham);
            model.addAttribute("dsSanPham", sanPhams);
        }
        return "admin/quanLySanPham/viewSanPhamChiTietCuaSanPham";
    }

    @GetMapping("/viewSuaSanPhamChiTiet/{id}")
    public String viewSuaSanPhamChiTiet(
            @PathVariable("id") UUID idSanPhamChiTiet ,
            Model model,
            @RequestParam(name = "page",defaultValue = "0") int currentPage ,
            HttpServletRequest request ,
            @ModelAttribute("sanPhamChiTiet") ChiTietSanPham chiTietSanPham
    ) {
        // lấy ra sản phẩm chi tiết
        ChiTietSanPham chiTietSanPham_detail = chiTietSPService.chiTietTheoId(idSanPhamChiTiet);
        model.addAttribute("sanPhamChiTiet",chiTietSanPham_detail);

        // lấy ra danh sách tên sản phẩm
        List<SanPham> dsTenSanPham = new ArrayList<>();
        dsTenSanPham = sanPhamService.layDanhSach();

        List<ThuongHieu> dsTenThuongHieu = new ArrayList<>();
        dsTenThuongHieu = thuongHieuService.layDanhSach();

        List<NSX> dsTenNSX = new ArrayList<>();
        dsTenNSX = nsxService.layDanhSach();

        List<DanhMuc> dsTenDanhMuc = new ArrayList<>();
        dsTenDanhMuc = danhMucService.layDanhSach();

        List<LoaiSanPham> dsTenLoaiSanPham = new ArrayList<>();
        dsTenLoaiSanPham = loaiSanPhamService.layDanhSach();

        List<KieuDang> dsTenKieuDang = new ArrayList<>();
        dsTenKieuDang = kieuDangService.layDanhSach();

        List<ChatLieu> dsTenChatLieu = new ArrayList<>();
        dsTenChatLieu = chatLieuService.layDanhSach();

        List<MuiGiay> dsTenMuiGiay = new ArrayList<>();
        dsTenMuiGiay = muiGiayService.layDanhSach();

        List<DayGiay> dsTenDayGiay = new ArrayList<>();
        dsTenDayGiay = dayGiayService.layDanhSach();

        List<DeGiay> dsTenDeGiay = new ArrayList<>();
        dsTenDeGiay = deGiayService.layDanhSach();

        List<LotGiay> dsTenLotGiay = new ArrayList<>();
        dsTenLotGiay = lotGiayService.layDanhSach();

        List<MauSac> dsTenMauSac = new ArrayList<>();
        dsTenMauSac = mauSacService.layDanhSach();

        List<KichCo> dsTenKichCo = new ArrayList<>();
        dsTenKichCo = kichCoService.layDanhSach();

        model.addAttribute("dsTenSanPham",dsTenSanPham);
        model.addAttribute("dsTenThuongHieu",dsTenThuongHieu);
        model.addAttribute("dsTenNSX",dsTenNSX);
        model.addAttribute("dsTenDanhMuc",dsTenDanhMuc);
        model.addAttribute("dsTenLoaiSanPham",dsTenLoaiSanPham);
        model.addAttribute("dsTenKieuDang",dsTenKieuDang);
        model.addAttribute("dsTenChatLieu",dsTenChatLieu);
        model.addAttribute("dsTenMuiGiay",dsTenMuiGiay);
        model.addAttribute("dsTenDayGiay",dsTenDayGiay);
        model.addAttribute("dsTenDeGiay",dsTenDeGiay);
        model.addAttribute("dsTenLotGiay",dsTenLotGiay);
        model.addAttribute("dsTenMauSac",dsTenMauSac);
        model.addAttribute("dsTenKichCo",dsTenKichCo);

        return "admin/quanLySanPham/viewSuaSanPhamChiTiet";
    }

    @PostMapping("/suaSanPhamChiTiet")
    public String suaSanPhamChiTiet(
             final Model model
            , final HttpServletRequest request
            , final HttpServletResponse response
            ,  ChiTietSanPham_themRequest chiTietSP_request
            , @ModelAttribute("sanPhamChiTiet") ChiTietSanPham chiTietSanPham
            , @RequestParam(value = "duongDanAnhChinh", required = false) MultipartFile fileAnhChinh
            , @RequestParam(value = "duongDanAnhCon", required = false) MultipartFile[] cacFileAnhCon
            , @RequestParam("idSanPhamChiTiet") UUID idSanPhamChiTiet

    ) throws IOException {
//        System.out.println("Chạy vào sửa thông tin sản phẩm chi tiết - có idSanPhamChiTiet: " + idSanPhamChiTiet);
        SanPham sanPhamThem = new SanPham();
        sanPhamThem = sanPhamService.chiTietTheoId(chiTietSanPham.getSanPham().getId());

        ThuongHieu thuongHieuThem = new ThuongHieu();
        thuongHieuThem = thuongHieuService.chiTietTheoId(chiTietSanPham.getThuongHieu().getId());

        NSX nsxThem = new NSX();
        nsxThem = nsxService.chiTietTheoId(chiTietSanPham.getNsx().getId());

        DanhMuc danhMucThem = new DanhMuc();
        danhMucThem = danhMucService.chiTietTheoId(chiTietSanPham.getDanhMuc().getId());

        LoaiSanPham loaiSanPhamThem = new LoaiSanPham();
        loaiSanPhamThem = loaiSanPhamService.chiTietTheoId(chiTietSanPham.getLoaiSanPham().getId());

        KieuDang kieuDangThem = new KieuDang();
        kieuDangThem = kieuDangService.chiTietTheoId(chiTietSanPham.getKieuDang().getId());

        ChatLieu chatLieuThem = new ChatLieu();
        chatLieuThem = chatLieuService.chiTietTheoId(chiTietSanPham.getChatLieu().getId());

        MuiGiay muiGiayThem = new MuiGiay();
        muiGiayThem = muiGiayService.chiTietTheoId(chiTietSanPham.getMuiGiay().getId());

        DayGiay dayGiayThem = new DayGiay();
        dayGiayThem = dayGiayService.chiTietTheoId(chiTietSanPham.getDayGiay().getId());

        DeGiay deGiayThem = new DeGiay();
        deGiayThem = deGiayService.chiTietTheoId(chiTietSanPham.getDeGiay().getId());

        LotGiay lotGiayThem = new LotGiay();
        lotGiayThem = lotGiayService.chiTietTheoId(chiTietSanPham.getLotGiay().getId());

        MauSac mauSacThem = new MauSac();
        mauSacThem = mauSacService.chiTietTheoId(chiTietSanPham.getMauSac().getId());

        KichCo kichCoThem = new KichCo();
        kichCoThem = kichCoService.chiTietTheoId(chiTietSanPham.getKichCo().getId());

        ChiTietSanPham chiTietSanPhamThemMoi = chiTietSPService.chiTietTheoId(chiTietSanPham.getId());
        chiTietSanPhamThemMoi.setId(idSanPhamChiTiet);
        chiTietSanPhamThemMoi.setSanPham(sanPhamThem);
        chiTietSanPhamThemMoi.setThuongHieu(thuongHieuThem);
        chiTietSanPhamThemMoi.setNsx(nsxThem);
        chiTietSanPhamThemMoi.setDanhMuc(danhMucThem);
        chiTietSanPhamThemMoi.setLoaiSanPham(loaiSanPhamThem);
        chiTietSanPhamThemMoi.setKieuDang(kieuDangThem);
        chiTietSanPhamThemMoi.setChatLieu(chatLieuThem);
        chiTietSanPhamThemMoi.setMuiGiay(muiGiayThem);
        chiTietSanPhamThemMoi.setDayGiay(dayGiayThem);
        chiTietSanPhamThemMoi.setDeGiay(deGiayThem);
        chiTietSanPhamThemMoi.setLotGiay(lotGiayThem);

        chiTietSanPhamThemMoi.setMauSac(mauSacThem);
        chiTietSanPhamThemMoi.setKichCo(kichCoThem);

        chiTietSanPhamThemMoi.setKhoiLuong(chiTietSP_request.getKhoiLuong());
        chiTietSanPhamThemMoi.setGiaTriSanPham(Double.parseDouble(chiTietSP_request.getGiaTriSanPham()));
        chiTietSanPhamThemMoi.setSoLuong(chiTietSP_request.getSoLuong());

        chiTietSanPhamThemMoi.setMoTa(chiTietSP_request.getMoTa());
        Integer trangThai = chiTietSanPham.getTrangThai()==null?0:1;
        chiTietSanPhamThemMoi.setTrangThai(trangThai);

        if (fileAnhChinh.getOriginalFilename().length()>0) {
            String urlSaveImageChinh_resource = "C:/Users/DELL/Documents/DuAnTotNghiep_2024/DATN_Final/SP2024_SD09_DATN_WEBSITE_NICESPORT/src/main/resources/static/user/assets/imagesgiay/" + fileAnhChinh.getOriginalFilename();

            File luuAnhVaoResource = new File(urlSaveImageChinh_resource);
            fileAnhChinh.transferTo(luuAnhVaoResource);
            // đường dẫn ảnh => lưu vào DB
            String urlAnhChinh_toSaveDB = "/user/assets/imagesgiay/" + fileAnhChinh.getOriginalFilename();
//            System.out.println("url save to DB : " + urlAnhChinh_toSaveDB );
            // in ra đường dẫn ảnh chính
//            System.out.println("Đường dẫn ảnh chính : " + urlSaveImageChinh_resource);

            chiTietSanPhamThemMoi.setHinhAnh(urlAnhChinh_toSaveDB);
        }

        ChiTietSanPham chiTietSanPhamVuaThem = chiTietSPService.capNhat_traVeKetQua(chiTietSanPhamThemMoi);

        boolean isCheckCoAnhCon = false;
        for(MultipartFile cacAnhCon : cacFileAnhCon){
            if(cacAnhCon.getOriginalFilename().length()>0){
                isCheckCoAnhCon=true;
            }
        }

        if (isCheckCoAnhCon == true){
            System.out.println("Hợp lệ chạy vào thêm cacFileAnhCon ");
//            System.out.println("size file con : " + cacFileAnhCon.length);

            hinhAnhGiayService.xoaTheoIdSanPhamCT(chiTietSanPhamVuaThem.getId());
            for(int i=0;i<cacFileAnhCon.length; i++){

                String urlSaveImageCon_toResource = "C:/Users/DELL/Documents/DuAnTotNghiep_2024/DATN_Final/SP2024_SD09_DATN_WEBSITE_NICESPORT/src/main/resources/static/user/assets/imagesgiay/"
                        + cacFileAnhCon[i].getOriginalFilename();
//                System.out.println("urlsavaeimage icon : " + urlSaveImageCon_toResource);
                File luuAnhVaoResource2 = new File(urlSaveImageCon_toResource);
                cacFileAnhCon[i].transferTo(luuAnhVaoResource2);

                String urlDuongDanAnhConSaveToDB = "/user/assets/imagesgiay/" +cacFileAnhCon[i].getOriginalFilename();
//                System.out.println("Đường dẫn ảnh con : " + urlDuongDanAnhConSaveToDB);
                HinhAnhGiays hinhAnhGiaysThemMoi = new HinhAnhGiays();
                hinhAnhGiaysThemMoi.setChiTietSanPham(chiTietSanPhamVuaThem);
                try {
                    hinhAnhGiaysThemMoi.setNgayTao(Constant.getDateNow());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                hinhAnhGiaysThemMoi.setNguoiTao(1);
                hinhAnhGiaysThemMoi.setDuongDanAnh(urlDuongDanAnhConSaveToDB);
                hinhAnhGiaysService.themMoi(hinhAnhGiaysThemMoi);
            }
        }

        System.out.println("Sửa chi tiết sản phẩm thành công");
        return "redirect:/admin/quanLySanPham/viewSanPhamChiTiet/"+chiTietSanPhamVuaThem.getSanPham().getId();
    }

    @GetMapping("/xoaSanPhamChiTiet/{id}")
    public String xoaSanPhamChiTiet(
            @PathVariable("id") UUID idSanPhamChiTiet ,
            Model model,
            @RequestParam(name = "page",defaultValue = "0") int currentPage ,
            HttpServletRequest request
    ) {
        // lấy ra sản phẩm chi tiết
        ChiTietSanPham chiTietSanPham_detail = chiTietSPService.chiTietTheoId(idSanPhamChiTiet);
        System.out.println("idSanPham chi tiet muon xoa : " + idSanPhamChiTiet);

        chiTietSPService.capNhatTrangThaiSanPhamCT(idSanPhamChiTiet);

        return "redirect:/admin/quanLySanPham/viewSanPhamChiTiet/"+chiTietSanPham_detail.getSanPham().getId();
    }

}
