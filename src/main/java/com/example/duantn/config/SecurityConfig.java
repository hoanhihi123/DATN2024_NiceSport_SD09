//package com.example.duantn.config;
//
//import com.example.duantn.model.NhanVien;
//import com.example.duantn.service.impl.NhanVienServiceImpl;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//@EnableWebSecurity
////chạy security trước khi gọi đến api
//public class SecurityConfig {
//    @Autowired
//    NhanVienServiceImpl nhanVienService;
//    //mã hóa mật khẩu và xác minh mật khẩu
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    //pass: abc
//    //hsgjhsk => được mã hóa từ abc ta 1 thời điểm nhất định
//    //tại 1 thời điểm a: abc => hdhsgdk (mã hóa)
//    //tại 1 thời điểm b: abc => iihshhg32 (mã hóa)
//    //từ cái mã hóa iihshhg32 sẽ phải dịch ngược nó => abc
//
//    // tạo ra đối tượng để login
//    @Bean
//    public UserDetailsService userDetailsService(){
//        //tất cả những tài khoản login đều sẽ đc convert về userdetailsservice
//        PasswordEncoder encoder= passwordEncoder();//khởi tạo 1 passwordencoder để mã hóa mật khẩu
//
////        int countNhanVien=0;
////        int countAdmin=0;
//        List<NhanVien> danhSachNhanVien = new ArrayList<>();
//        danhSachNhanVien = nhanVienService.layDanhSach();
//
////        System.out.println("Tổng nhân viên " + countNhanVien);
////        System.out.println("Tổng admin " + countAdmin);
//
//        List<UserDetails> listUser=new ArrayList<>(); //khởi tạo 1 list để lưu trữ các tài khoản
//        //userDetails là 1 đối tượng có sẵn trong security
//
//        for(NhanVien nhanVien : danhSachNhanVien){
//            if(nhanVien.getChucVu().getTen().equalsIgnoreCase("Nhân viên")){
//                UserDetails user= User.builder().username(nhanVien.getTaiKhoan()).password(encoder.encode(nhanVien.getMatKhau())).roles("Nhân viên").build();
//                listUser.add(user);
//            }else{
//                UserDetails admin= User.builder().username(nhanVien.getTaiKhoan()).password(encoder.encode(nhanVien.getMatKhau())).roles("Quản lý").build();
//                listUser.add(admin);
//            }
//        }
//
//        return new InMemoryUserDetailsManager(listUser);
//    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//                httpSecurity
//                .authorizeHttpRequests(//bắt các đường dẫn phải tuân theo cấu hình của nó
//                // /admin: chỉ dẫn đến các đường dẫn requestmapping đc khai báo phía trên controller
//                //**: có nhiều đường dẫn hơn sau admin ( là những đường dẫn nằm trong controller)
//                req-> req.requestMatchers("/quanLy/**","/nhanVien/**").hasRole("Quản lý") ///để truy cập vào đường dẫn /admin/** thì phải có role là ADMIN
//                        .requestMatchers("/nhanVien/**").hasRole("USER")
//                        .anyRequest().permitAll() // những đường dẫn còn lại thì sẽ permitAll: tức là không cần phải security
//                ).formLogin(
//                        login->login.loginProcessingUrl("/login")
//                                .defaultSuccessUrl("/home", true)
//                                .defaultSuccessUrl("/login", false)
//                            )
//                .logout(
//                        logout->logout.logoutUrl("/logout")
//                                .logoutSuccessUrl("/login")
//                                .invalidateHttpSession(true)
//                                .deleteCookies("JSESSIONID")
//                )
//                .exceptionHandling(exception ->
//                        exception.accessDeniedHandler((request, response, accessDeniedException) -> {
//                            // Thiết lập loại nội dung và mã trạng thái của phản hồi
//                            response.setContentType("text/html;charset=UTF-8");
//                            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//
//                            // Sử dụng JavaScript để hiển thị một cửa sổ cảnh báo
//                            PrintWriter out = response.getWriter();
//                            out.println("<script type=\"text/javascript\">");
//                            out.println("alert('Tài khoản của bạn không có quyền truy cập vào tài nguyên này.');");
////                            out.println("window.location.href='/';"); // Chuyển hướng người dùng đến trang chủ hoặc trang khác
//                            out.println("</script>");
//                        }));
//
//        //nếu như có thiết kế form login riêng thì sử dụng loginPage()
//                //neeus k có thì sd form login có sẵn cuae security : .loginProcessingUrl("/login")
//        return httpSecurity.build();
//    }
//
//
//
//}
