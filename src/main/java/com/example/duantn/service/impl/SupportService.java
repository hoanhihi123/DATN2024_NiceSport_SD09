//package com.example.duantn.service.impl;
//
//import org.springframework.stereotype.Service;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
//
//
//@Service
//public class SupportService {
//
//    public byte[]  PrintInvoice(String billCode) throws Exception {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm - dd/MM/yyyy");
//        Map<String, Object> props = new HashMap<>();
//        // lấy ra hóa đơn hiện tại
//        Bill b = billService.findBillByCode(billCode).get();
//        // lấy thông tin ngày mua hóa đơn
//        // số hóa đơn
//        // tên khách hang
//        // mã code hóa đnư a
//        props.put("invoiceDate", dateFormat.format(new Date()).toString());
//        props.put("invoiceNumber", "1233");
//        props.put("bill", b);
//
//        if(b.getCustomer() != null){
//            props.put("customer", b.getCustomer());
//        }else{
//            Customer customer = new Customer();
//            customer.setFullName("Guest");
//            props.put("customer", customer);
//        }
//        props.put("billCode", b.getCodeBill());
//
//        // tên người nhận aaaa
//        props.put("receiverName", b.getBillFormat().equalsIgnoreCase(BillType.OFFLINE.getLabel())?
//                b.getCustomer()!=null?
//                        b.getCustomer().getFullName():null:b.getReceiverName());
//        props.put("receiverPhone", b.getBillFormat().equalsIgnoreCase(BillType.OFFLINE.getLabel())?
//                b.getCustomer()!=null?
//                        b.getCustomer().getPhone():null
//                :b.getReceiverPhone());
//        props.put("billDetails", b.getLstBillDetails());
//
//        // lấy ra số lượng của từng sản phẩm trong hóa đơn chi tiết
//        Set<BillDetails> billDetails = b.getLstBillDetails();
//        int totalQuantity = billDetails.stream()
//                .mapToInt(billDetails1 -> billDetails1.getQuantity()) // Lấy ra tổng số lượng từ mỗi BillDetail
//                .sum();
//
//
//        props.put("billStatus", b.getStatus());
//        props.put("NetTotal", b.getTotalMoney());
//        props.put("Discount", b.getVoucherMoney());
//        props.put("Ship", b.getShipMoney());
//        props.put("Total", b.getIntoMoney());
//        props.put("Quantity", totalQuantity);
//
////        import org.thymeleaf.context.Context;
////import org.thymeleaf.spring6.SpringTemplateEngine;
//        Context context = new Context();
//        context.setVariables(props);
//        String html = templateEngine.process("newinvoice", context);
//        byte[] pdfBytes = generatePdfFromHtml(html);
//        return pdfBytes;
//    }
//
//
//}
