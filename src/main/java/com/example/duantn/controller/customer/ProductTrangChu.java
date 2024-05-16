package com.example.duantn.controller.customer;

import com.example.duantn.model.ChiTietSanPham;
import com.example.duantn.model.HinhAnhGiays;
import com.example.duantn.request.*;
import com.example.duantn.service.impl.ChiTietSPServiceImpl;
import com.example.duantn.service.impl.HinhAnhGiaysService;
import com.example.duantn.service.impl.HoaDonCTServiceImpl;
import com.example.duantn.service.impl.HoaDonServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/giay")
public class ProductTrangChu {
    @Autowired
    HttpSession session;

    @Autowired
    ChiTietSPServiceImpl chiTietSPService;

    @Autowired
    HoaDonServiceImpl hoaDonService;

    @Autowired
    HoaDonCTServiceImpl hoaDonChiTietService;

    @Autowired
    HinhAnhGiaysService hinhAnhGiaysService;

    @GetMapping("/view-chiTietSanPham/{idSanPhamChiTiet}")
    public String viewChiTietSanPhamChinh(
            @PathVariable("idSanPhamChiTiet") UUID idSanPhamChiTiet_url ,
            HttpServletRequest request,
            Model model
    ) {
        HttpSession session = request.getSession();

        // chi tiết sản phẩm theo idSanPham
        ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
        chiTietSanPham = chiTietSPService.chiTietTheoId(idSanPhamChiTiet_url);

        // lấy danh sách chi tiết sản phẩm _ hiển thị theo màu sắc được chọn
        List<ChiTietSanPham> dsChiTietSP_color = new ArrayList<>();

        // kiểm tra nếu dsChiTietSP_color_sp không null, tức là được load từ viewSanPhamChiTiet
        // không null thì lấy dữ liệu luôn
        // -- sửa ở đây
//        if(session.getAttribute("dsChiTietSP_color_sp")!=null) {
//            dsChiTietSP_color = (List<ChiTietSanPham>) session.getAttribute("dsChiTietSP_color_sp");
////        }
        // chưa có trường hợp ngược lại

        // với idSanPhamChiTiet => lấy ra danh sách hình ảnh với trạng thái sản phẩm chi tiết = 1
        List<ChiTietSanPham> dsChiTietSP = new ArrayList<>();
        dsChiTietSP = chiTietSPService.layDanhSachSPCT_theoIDSanPham_va_ID_mauSac(chiTietSanPham.getSanPham().getId(),chiTietSanPham.getMauSac().getId());

        // set lại giá trị cho dsChiTietSP_color_sp với danh sách mới
        session.setAttribute("dsChiTietSP_color_sp",dsChiTietSP);

        // danh sach size giay theo mau sac
        model.addAttribute("dsSP_theoColor_image",dsChiTietSP_color);

        // danh sach hinh anh chi tiet cua san pham
        if(dsChiTietSP_color.size()>0){
            System.out.println("Lấy hình ảnh sản phẩm khi chọn color");
           List<HinhAnhGiays> dsHinhAnhGiays = new ArrayList<>();
           dsHinhAnhGiays = hinhAnhGiaysService.layDanhSachHinhAnhGiayTheo_idSanPhamChiTiet(idSanPhamChiTiet_url);
           String duongDanAnh = dsHinhAnhGiays.get(0).getDuongDanAnh();
//           chiTietSanPham.setHinhAnh(duongDanAnh);  // set lai duong dan anh chinh
           model.addAttribute("dsHinhAnhGiay",dsHinhAnhGiays);
        }else{
//            System.out.println("Lấy hình ảnh sản phẩm ban đầu ");
            List<HinhAnhGiays> dsHinhAnhGiays = new ArrayList<>();
            dsHinhAnhGiays = hinhAnhGiaysService.layDanhSachHinhAnhGiayTheo_idSanPhamChiTiet(idSanPhamChiTiet_url);
//            System.out.println("Lấy hình ảnh theo idSanPhamCT được chọn");
            chiTietSanPham.setHinhAnh(chiTietSanPham.getHinhAnh());  // set lai duong dan anh chinh
            model.addAttribute("dsHinhAnhGiay",dsHinhAnhGiays);
        }
//        System.out.println("Chi tiết sản phẩm : " + chiTietSanPham.toString());

        model.addAttribute("sanPhamCT",chiTietSanPham);  // lấy tên sản phẩm , giá bán, giá giảm
        // ở đây có SanPhamCT - của 1 sản phẩm => từ idSanPhamCT => cần lấy hình ảnh của sản phẩm chi tiết

        List<UUID> dsIDMauSac = new ArrayList<>();
        dsIDMauSac = chiTietSPService.layDanhSachIDMauSacTuSanPhamCT_bangIdSanPham(chiTietSanPham.getSanPham().getId());

        // danh sach SanPhamChiTietTheoIDSanPham
        List<ChiTietSanPham> dsSanPhamCT = new ArrayList<>();
        dsSanPhamCT = chiTietSPService.layDanhSachSPCT_theoIDSanPham(chiTietSanPham.getSanPham().getId());

        List<ChiTietSanPham> dsSanPham_mauSac_hinhAnh = new ArrayList<>();

        for(UUID idMauSac : dsIDMauSac){
            for(ChiTietSanPham ctsp : dsSanPhamCT){
                    if(idMauSac.equals(ctsp.getMauSac().getId())){
                        dsSanPham_mauSac_hinhAnh.add(ctsp);
                        break;
                    }
                }
        }
        model.addAttribute("dsSP_theoColor_image",dsSanPham_mauSac_hinhAnh);

//        System.out.println("Danh sach san pham theo mau sac va hinh anh : ");
//        for(ChiTietSanPham ctsp : dsSanPham_mauSac_hinhAnh){
//            System.out.println(ctsp.toString());
//        }

        // làm sao để lấy được các mã màu sắc mà không bị trùng lặp
        // lấy idsanPham từ cái bên trên tìm kiếm các sanPhamCT có idSanPham => lấy ra các mã màu sắc distinct => ko lấy giá trị trùng lặp

        // lấy được các mã màu của sản phẩm rồi thì sao =>
        // lấy danh sách sản phẩm chi tiết truyền vào where idSanPham = ?
        // duyệt danh sách sản phẩm => distinct các sản phẩm chi tiết
        // => lấy được ảnh sản phẩm ko trùng -- thay vì chỉ lấy mỗi ảnh sản phẩm => truyền cái kết quả lấy được đó
        // vào trong 1 list mới => list lên trên giao diện phần màu sắc dễ dàng

        return "customer/gioHang/chiTietSanPham";
    }

    // /giay/upload-sizeGiay/${sanPhamCT.sanPham.id}/${dsColor_image.mauSac.id}
    @GetMapping("/upload-sizeGiay/{idSanPham}/{idMauSac}")
    public String xoaSanPhamKhoiCartThanhToan(
            @PathVariable("idSanPham") UUID idSanPham,
            @PathVariable("idMauSac") UUID idMauSac,
            Model model,
            HttpServletRequest httpServletRequest
    ) {
        HttpSession session = httpServletRequest.getSession();  // tạo mới 1 session
        List<ChiTietSanPham> dsChiTietSP = new ArrayList<>();

        // set lại session null, để có thể gán các giá trị khác của sản phẩm chi tiết khác mà không bị sung đột dữ liệu
        session.setAttribute("dsChiTietSP_color_sp",dsChiTietSP);

        // lay idMauSac, idSanPham
        dsChiTietSP = chiTietSPService.layDanhSachSPCT_theoIDSanPham_va_ID_mauSac(idSanPham,idMauSac);

//        System.out.println("List sản phẩm sau khi click vào màu sắc");
//        for(ChiTietSanPham ds : dsChiTietSP){
//            System.out.println(ds.toString());
//        }

        // set lại giá trị cho dsChiTietSP_color_sp với danh sách mới
        session.setAttribute("dsChiTietSP_color_sp",dsChiTietSP);

        model.addAttribute("dsChiTietSP_color_sp",dsChiTietSP);

        // lấy idSanPham
        UUID idSanPhamCT = dsChiTietSP.get(0).getId();

        Map<String, Object> jsonResult = new HashMap<String, Object>();
        jsonResult.put("code", 200);
        jsonResult.put("status", "Success");
        jsonResult.put("dsChiTietSP_color_sp",dsChiTietSP);
        return "redirect:/giay/view-chiTietSanPham/"+idSanPhamCT;
    }


    @PostMapping("/laySoLuongCoSanSP")
    public ResponseEntity<Map<String, Object>> laySoLuongCoSanSP(
            Model model,
            HttpServletRequest httpServletRequest,
            @RequestBody ChiTietSanPham_xem chiTietSanPham_xem
    ) {
        ChiTietSanPham chiTietSanPham = chiTietSPService.chiTietTheoId(chiTietSanPham_xem.getIdSanPhamChiTiet());
        Integer soLuongCoSan = chiTietSanPham.getSoLuong();
//        System.out.println("Số lượng có sẵn" + soLuongCoSan);

        Map<String, Object> jsonResult = new HashMap<String, Object>();
        jsonResult.put("code", 200);
        jsonResult.put("status", "Success");
        jsonResult.put("soLuongSP",soLuongCoSan);
        return ResponseEntity.ok(jsonResult);
    }


}
