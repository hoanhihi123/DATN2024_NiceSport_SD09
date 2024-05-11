<%@ page import="com.example.duantn.request.SanPhamTrongGioHang" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>

<!DOCTYPE html>
<html lang="en">


<!-- molla/cart.html  22 Nov 2019 09:55:06 GMT -->
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Giỏ hàng</title>
    <meta name="keywords" content="HTML5 Template">
    <meta name="description" content="Molla - Bootstrap eCommerce Template">
    <meta name="author" content="p-themes">
    <!-- Favicon -->
    <link rel="apple-touch-icon" sizes="180x180" href="/user/assets/images/icons/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/user/assets/images/logo-black.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/user/assets/images/logo-black.png">
    <link rel="manifest" href="/user/assets/images/icons/site.html">
    <link rel="mask-icon" href="/user/assets/images/icons/safari-pinned-tab.svg" color="#666666">
    <link rel="shortcut icon" href="/user/assets/images/logo-black.png">
    <meta name="apple-mobile-web-app-title" content="Molla">
    <meta name="application-name" content="Molla">
    <meta name="msapplication-TileColor" content="#cc9966">
    <meta name="msapplication-config" content="/user/assets/images/icons/browserconfig.xml">
    <meta name="theme-color" content="#ffffff">
    <!-- Plugins CSS File -->
    <link rel="stylesheet" href="/user/assets/css/bootstrap.min.css">
    <!-- Main CSS File -->
    <link rel="stylesheet" href="/user/assets/css/style.css">
    <%--    Link dùng font chữ roboto--%>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">

    <style>
        *{
            font-family: 'Roboto', sans-serif !important;
        }
    </style>
</head>

<body>


<div class="page-wrapper">
    <header class="header">
        <div class="header-top">
            <div class="container">
                <div class="header-left">

                </div><!-- End .header-left -->

                <div class="header-right">
                    <ul class="top-menu">
                        <li>
                            <a href="#">Links</a>
                            <ul>
                                <li><a href="tel:#"><i class="icon-phone"></i>Gọi điện: +0123 456 789</a></li>
                                <li><a href="about.html">Về chúng tôi</a></li>
                                <li><a href="#signin-modal" data-toggle="modal"><i class="icon-user"></i>Đăng nhập</a>
                                </li>
                            </ul>
                        </li>
                    </ul><!-- End .top-menu -->
                </div><!-- End .header-right -->
            </div><!-- End .container -->
        </div><!-- End .header-top -->

        <div class="header-middle sticky-header">
            <div class="container">
                <div class="header-left">
                    <button class="mobile-menu-toggler">
                        <span class="sr-only">Toggle mobile menu</span>
                        <i class="icon-bars"></i>
                    </button>

                    <a href="index.html" class="logo">
                        <img src="/user/assets/images/logo-black.png" alt="Molla Logo" width="110" height="45">
                    </a>

                    <nav class="main-nav" style="margin-left: 270px; font-size: 30px important!;">
                        <ul class="menu sf-arrows">
                            <li class="megamenu-container ">
                                <a href="/gio-hang/view-trangChu2"><b>Trang chủ</b></a>
                            </li>
                            <li style="margin-left: -20px;">
                                <a href="product.html" class="sf-with-ul"><b>Giày nam</b></a>

                                <div class="megamenu megamenu-sm">
                                    <div class="row no-gutters">
                                        <div class="col-md-6">
                                            <div class="menu-col">
                                                <div class="menu-title"><b>Giày dành cho nam</b></div>
                                                <!-- End .menu-title -->
                                                <ul>
                                                    <li><a href="product.html">Giày chạy bộ</a></li>
                                                    <li><a href="product-centered.html">Giày thể thao</a></li>
                                                    <li><a href="product-extended.html"><span>Giày đi chơi<span
                                                            class="tip tip-new">New</span></span></a></li>

                                                </ul>
                                            </div><!-- End .menu-col -->
                                        </div><!-- End .col-md-6 -->

                                        <div class="col-md-6">
                                            <div class="banner banner-overlay">
                                                <figure class="slide-image">
                                                    <picture>
                                                        <source media="(max-width: 480px)"
                                                                srcset="/user/assets/images/slider/banner-quang-cao-giay-6-768x426.png">
                                                        <img src="/user/assets/images/banners/giaybn.jpg"
                                                             alt="Image Desc">
                                                    </picture>
                                                </figure>
                                            </div><!-- End .banner -->
                                        </div><!-- End .col-md-6 -->
                                    </div><!-- End .row -->
                                </div><!-- End .megamenu megamenu-sm -->
                            </li>
                            <li>
                                <a href="#" class="sf-with-ul"><b>Giày nữ</b></a>

                                <div class="megamenu megamenu-sm">
                                    <div class="row no-gutters">
                                        <div class="col-md-6">
                                            <div class="menu-col">
                                                <div class="menu-title"><b>Giày dành cho nữ</b></div>
                                                <!-- End .menu-title -->
                                                <ul>
                                                    <li><a href="product.html">Giày chạy bộ</a></li>
                                                    <li><a href="product-centered.html">Giày thể thao</a></li>
                                                    <li><a href="product-extended.html"><span>Giày đi chơi<span
                                                            class="tip tip-new">New</span></span></a></li>

                                                </ul>
                                            </div><!-- End .menu-col -->
                                        </div><!-- End .col-md-6 -->

                                        <div class="col-md-6">
                                            <div class="banner banner-overlay">
                                                <a href="category.html">
                                                    <img src="/user/assets/images/banners/banner6.png"
                                                         alt="Banner">

                                                    <div class="banner-content banner-content-bottom"
                                                         style="margin-top: 10px;">
                                                        <div class="banner-title text-white">Mẫu
                                                            mới<br><span><strong>Xuân 2024</strong></span></div>
                                                        <!-- End .banner-title -->
                                                    </div><!-- End .banner-content -->
                                                </a>
                                            </div><!-- End .banner -->
                                        </div><!-- End .col-md-6 -->
                                    </div><!-- End .row -->
                                </div><!-- End .megamenu megamenu-sm -->
                            </li>

                        </ul><!-- End .menu -->
                    </nav><!-- End .main-nav -->
                </div><!-- End .header-left -->

                <div class="header-right">
                    <div class="header-search">
                        <a href="#" class="search-toggle" role="button" title="Tìm kiếm sản phẩm"><i
                                class="icon-search"></i></a>
                        <form action="#" method="get">
                            <div class="header-search-wrapper" >
                                <label for="q" class="sr-only">Search</label>
                                <input type="search" class="form-control" name="q" id="q" placeholder="Tìm kiếm..."
                                       required>
                            </div><!-- End .header-search-wrapper -->
                        </form>
                    </div><!-- End .header-search -->

                    <div class="dropdown cart-dropdown">
                        <a href="/gio-hang/view-gio" class="dropdown-toggle" role="button" >
                            <i class="icon-shopping-cart"></i>
                            <span class="cart-count "  id="totalCartProductsId">
                                ${totalCartProducts>0?totalCartProducts:0}
                            </span>
                        </a>

                    </div><!-- End .cart-dropdown -->
                </div><!-- End .header-right -->
            </div><!-- End .container -->
        </div><!-- End .header-middle -->
    </header><!-- End .header -->

    <main class="main">
        <div class="page-header text-center" style="background-image: url('/user/assets/images/page-header-bg.jpg')">
            <div class="container">
                <h1 class="page-title">Giỏ hàng <span>của bạn</span></h1>
            </div><!-- End .container -->
        </div><!-- End .page-header -->
        <nav aria-label="breadcrumb" class="breadcrumb-nav">
            <div class="container">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="/gio-hang/view-trangChu2">Home</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Giỏ hàng</li>
                </ol>
            </div><!-- End .container -->
        </nav><!-- End .breadcrumb-nav -->

        <div class="page-content">
            <div class="cart">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">

                            <style>
                                table tr th,td {
                                    color: black  !important;
                                    font-size: 16px !important;
                                }
                            </style>
                            <table class="table table-hover" >
                                <thead>
                                <tr >
                                    <th style="font-size: 18px !important;"><b>Chọn mua</b></th>
                                    <th>Ảnh</th>
                                    <th>Tên giày</th>
                                    <th>Size giày</th>
                                    <th>Màu sắc</th>
                                    <th>Giá bán</th>
                                    <th>Số lượng</th>
                                    <th>Tổng tiền</th>
                                    <th>Xóa</th>
                                </tr>
                                </thead>

                                <tbody>
                                <c:forEach items="${sanPhamTrongGio}" var="sanPhamTrongGio">

                                    <tr>
                                        <td>
                                            <input type="checkbox" id="${sanPhamTrongGio.idSanPhamCT}" onchange="kiemTraDuocChonKhong('${sanPhamTrongGio.idSanPhamCT}','${sanPhamTrongGio.soLuong}');"   ${sanPhamTrongGio.numberCheck==1?'checked':''}  value="${sanPhamTrongGio.idSanPhamCT}" class="form-control" style="height: 25px; width: 25px;">

                                        </td>
                                        <td class="product-col">
                                            <a href="/giay/view-chiTietSanPham/${sanPhamTrongGio.idSanPhamCT}">
                                                <img src="${sanPhamTrongGio.hinhAnh}" style="width: 100px;"/>
                                            </a>
                                        </td>
                                        <td>
                                            <h3 class="product-title">
                                                <a href="/giay/view-chiTietSanPham/${sanPhamTrongGio.idSanPhamCT}">

                                                        ${sanPhamTrongGio.sanPham.ten}
                                                </a>
                                            </h3><!-- End .product-title -->
                                        </td>
                                        <td class="price-col">
                                                ${sanPhamTrongGio.kichCo.ten}
                                        </td>
                                        <td class="price-col" >
                                                ${sanPhamTrongGio.mauSac.ten}
                                        </td>
                                        <td class="price-col">
                                            <fmt:formatNumber type = "number"
                                                              maxFractionDigits = "0" value = "${sanPhamTrongGio.gia}" />
                                        </td>
                                        <td class="quantity-col">
                                            <div class="cart-product-quantity">
                                                <input type="number"  value="${sanPhamTrongGio.soLuong}" min="0" step="1"
                                                       onchange="changeNumberProduct('${sanPhamTrongGio.idSanPhamCT}',this.value)" />

                                            </div>
                                        </td>

                                        <td class=" total-col " >
                                            <fmt:formatNumber  type = "number"
                                                               maxFractionDigits = "0" value="${sanPhamTrongGio.soLuong*sanPhamTrongGio.gia}" />

                                        </td>
                                        <td class="remove-col">
                                            <a href="/gio-hang/xoa/${sanPhamTrongGio.idSanPhamCT}" onclick="return confirm('Bạn chắc chắn muốn xóa sản phẩm này khỏi giỏ hàng ?') ? true : false;"
                                               class="btn-remove"><i class="icon-close" style="font-size: 4rem;"></i> </a></td>

                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table><!-- End .table table-wishlist -->


                            <div class="  cart-bottom">
                                <h5>Tổng tiền tất cả sản phẩm: </h5>
                                <h4 id="totalPriceInCart" style="font-size: large; color: black; margin-left: 10px;"><fmt:formatNumber type = "number" maxFractionDigits = "0" value = "${totalPriceResult}" /></h4> <h5 style="margin-left: 10px;">VNĐ</h5>

                            </div><!-- End .cart-bottom -->
                        </div><!-- End .col-lg-9 -->
                        <aside class="col-lg-12">
                            <div class="summary summary-cart">
                                <h3 class="summary-title">Đơn hàng của bạn</h3><!-- End .summary-title -->

                                <%--                                <div class="cart-discount">--%>
                                <%--                                    <form action="#">--%>
                                <%--                                        <div class="input-group p-4">--%>
                                <%--                                            <input type="text" class="form-control p-4" required placeholder="Nhập mã giảm giá bạn có">--%>
                                <%--                                            <div class="input-group-append">--%>
                                <%--                                                <button class="btn btn-outline-primary-2 p-4" type="submit">Áp dụng</button>--%>
                                <%--                                            </div><!-- .End .input-group-append -->--%>
                                <%--                                        </div><!-- End .input-group -->--%>
                                <%--                                    </form>--%>
                                <%--                                </div><!-- End .cart-discount -->--%>

                                <table class="table table-summary">
                                    <tbody>
                                    <tr class="summary-subtotal">
                                        <td>Tổng giá trị đơn hàng</td>
                                        <td id="totalPriceInCartThanhToan" >
                                            <fmt:formatNumber type = "number"
                                                              maxFractionDigits = "0" value = "${totalPriceCartThanhToan>0?totalPriceCartThanhToan:0}" />

                                        </td>
                                    </tr><!-- End .summary-subtotal -->
                                    <%--                                    <tr class="summary-subtotal">--%>
                                    <%--                                        <td>Tiền được giảm</td>--%>
                                    <%--                                        <td>0</td>--%>
                                    <%--                                    </tr><!-- End .summary-subtotal -->--%>


                                    <%--                                    <tr class="summary-total">--%>
                                    <%--                                        <td>Tiền cần thanh toán:</td>--%>
                                    <%--                                        <td>--%>
                                    <%--                                            <fmt:formatNumber type = "number"--%>
                                    <%--                                                              maxFractionDigits = "0" value = "${totalPriceCartThanhToan>0?totalPriceCartThanhToan:0}" />--%>

                                    <%--                                        </td>--%>
                                    <%--                                    </tr><!-- End .summary-total -->--%>
                                    </tbody>
                                </table><!-- End .table table-summary -->

                                <a onclick="return handleClick();" href="/gio-hang/view-thanhToan" class="btn btn-outline-primary-2 btn-order btn-block" >Thanh toán</a>
                            </div><!-- End .summary -->

                            <a href="/gio-hang/view-trangChu2" class="btn btn-outline-dark-2 btn-block mb-3"><span>Tiếp tục mua sắm</span><i class="icon-refresh"></i></a>
                        </aside><!-- End .col-lg-3 -->
                    </div><!-- End .row -->
                </div><!-- End .container -->
            </div><!-- End .cart -->
        </div><!-- End .page-content -->
    </main><!-- End .main -->

    <footer class="footer">
        <div class="footer-middle">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-lg-4 " style="justify-content: center;">
                        <div class="widget widget-about">
                            <img src="/user/assets/images/logo-black.png" class="footer-logo" alt="Footer Logo" width="105" height="25" style="margin-left: 45px;">
                            <p>
                                Chúng tôi mong rằng bạn sẽ có trải nghiệm mua hàng tiện lợi, tiết kiệm thời gian. Chúc bạn mua sắm vui vẻ ^^
                            </p>
                            <div class="social-icons">
                                <a href="#" class="social-icon" target="_blank" title="Facebook"><i class="icon-facebook-f"></i></a>
                                <a href="#" class="social-icon" target="_blank" title="Twitter"><i class="icon-twitter"></i></a>
                                <a href="#" class="social-icon" target="_blank" title="Instagram"><i class="icon-instagram"></i></a>
                                <a href="#" class="social-icon" target="_blank" title="Youtube"><i class="icon-youtube"></i></a>
                                <a href="#" class="social-icon" target="_blank" title="Pinterest"><i class="icon-pinterest"></i></a>
                            </div><!-- End .soial-icons -->
                        </div><!-- End .widget about-widget -->
                    </div><!-- End .col-sm-6 col-lg-3 -->

                    <div class="col-sm-6 col-lg-3">
                        <div class="widget">
                            <h4 class="widget-title">Dịch vụ khách hàng</h4><!-- End .widget-title -->

                            <ul class="widget-list">
                                <li><a href="#">Phương thức thanh tóa</a></li>
                                <li><a href="#">Đổi trả</a></li>
                                <li><a href="#">Ship đơn hàng</a></li>
                                <li><a href="#">Chính sách</a></li>
                            </ul><!-- End .widget-list -->
                        </div><!-- End .widget -->
                    </div><!-- End .col-sm-6 col-lg-3 -->

                    <div class="col-sm-6 col-lg-3">
                        <div class="widget">
                            <h4 class="widget-title">Tài khoản</h4><!-- End .widget-title -->

                            <ul class="widget-list">
                                <li><a href="#">Đăng nhập</a></li>
                                <li><a href="cart.html">Xem giỏ hàng</a></li>
                                <li><a href="#">Giúp đỡ</a></li>
                            </ul><!-- End .widget-list -->
                        </div><!-- End .widget -->

                    </div><!-- End .col-sm-6 col-lg-3 -->

                    <div class="col-sm-6 col-lg-3" style="margin-left: -100px;">
                        <div class="widget">
                            <h4 class="widget-title">Chúng tôi</h4><!-- End .widget-title -->

                            <ul class="widget-list">
                                <li><a href="about.html">Về cửa hàng NiceSport</a></li>
                            </ul><!-- End .widget-list -->
                        </div><!-- End .widget -->

                    </div><!-- End .col-sm-6 col-lg-3 -->
                </div><!-- End .row -->
            </div><!-- End .container -->
        </div><!-- End .footer-middle -->

        <div class="footer-bottom">
            <div class="container">
                <p class="footer-copyright">Edit © 2024 Nice Sport. Design by team SD-09.</p><!-- End .footer-copyright -->
                <figure class="footer-payments">
                    <img src="/user/assets/images/payments.png" alt="Payment methods" width="272" height="20">
                </figure><!-- End .footer-payments -->
            </div><!-- End .container -->
        </div><!-- End .footer-bottom -->
    </footer><!-- End .footer -->


</div><!-- End .page-wrapper -->
<button id="scroll-top" title="Back to Top"><i class="icon-arrow-up"></i></button>

<!-- Mobile Menu -->
<div class="mobile-menu-overlay"></div><!-- End .mobil-menu-overlay -->

<div class="mobile-menu-container">
    <div class="mobile-menu-wrapper">
        <span class="mobile-menu-close"><i class="icon-close"></i></span>

        <form action="#" method="get" class="mobile-search">
            <label for="mobile-search" class="sr-only">Search</label>
            <input type="search" class="form-control" name="mobile-search" id="mobile-search" placeholder="Search in..." required>
            <button class="btn btn-primary" type="submit"><i class="icon-search"></i></button>
        </form>

        <nav class="mobile-nav">
            <ul class="mobile-menu">
                <li class="active">
                    <a href="/gio-hang/view-trangChu2">Home</a>

                </li>
                <li>
                    <a href="category.html">Shop</a>
                </li>
                <li>
                    <a href="product.html" class="sf-with-ul">Product</a>
                    <ul>
                        <li><a href="product.html">Tất cả sản phẩm</a></li>
                        <li><a href="product-centered.html">Giày nữ</a></li>
                        <li><a href="product-extended.html"><span>Giày nam<span class="tip tip-new">New</span></span></a></li>
                        <li><a href="product-gallery.html">Unisex</a></li>
                    </ul>
                </li>

            </ul>
        </nav><!-- End .mobile-nav -->

        <div class="social-icons">
            <a href="#" class="social-icon" target="_blank" title="Facebook"><i class="icon-facebook-f"></i></a>
            <a href="#" class="social-icon" target="_blank" title="Twitter"><i class="icon-twitter"></i></a>
            <a href="#" class="social-icon" target="_blank" title="Instagram"><i class="icon-instagram"></i></a>
            <a href="#" class="social-icon" target="_blank" title="Youtube"><i class="icon-youtube"></i></a>
        </div><!-- End .social-icons -->
    </div><!-- End .mobile-menu-wrapper -->
</div><!-- End .mobile-menu-container -->

<!-- Sign in / Register Modal -->
<div class="modal fade" id="signin-modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true"><i class="icon-close"></i></span>
                </button>

                <div class="form-box">
                    <div class="form-tab">
                        <ul class="nav nav-pills nav-fill" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" id="signin-tab" data-toggle="tab" href="#signin" role="tab" aria-controls="signin" aria-selected="true">Sign In</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="register-tab" data-toggle="tab" href="#register" role="tab" aria-controls="register" aria-selected="false">Register</a>
                            </li>
                        </ul>
                        <div class="tab-content" id="tab-content-5">
                            <div class="tab-pane fade show active" id="signin" role="tabpanel" aria-labelledby="signin-tab">
                                <form action="#">
                                    <div class="form-group">
                                        <label for="singin-email">Username or email address *</label>
                                        <input type="text" class="form-control" id="singin-email" name="singin-email" required>
                                    </div><!-- End .form-group -->

                                    <div class="form-group">
                                        <label for="singin-password">Password *</label>
                                        <input type="password" class="form-control" id="singin-password" name="singin-password" required>
                                    </div><!-- End .form-group -->

                                    <div class="form-footer">
                                        <button type="submit" class="btn btn-outline-primary-2">
                                            <span>LOG IN</span>
                                            <i class="icon-long-arrow-right"></i>
                                        </button>

                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="signin-remember">
                                            <label class="custom-control-label" for="signin-remember">Remember Me</label>
                                        </div><!-- End .custom-checkbox -->

                                        <a href="#" class="forgot-link">Forgot Your Password?</a>
                                    </div><!-- End .form-footer -->
                                </form>
                                <div class="form-choice">
                                    <p class="text-center">or sign in with</p>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <a href="#" class="btn btn-login btn-g">
                                                <i class="icon-google"></i>
                                                Login With Google
                                            </a>
                                        </div><!-- End .col-6 -->
                                        <div class="col-sm-6">
                                            <a href="#" class="btn btn-login btn-f">
                                                <i class="icon-facebook-f"></i>
                                                Login With Facebook
                                            </a>
                                        </div><!-- End .col-6 -->
                                    </div><!-- End .row -->
                                </div><!-- End .form-choice -->
                            </div><!-- .End .tab-pane -->
                            <div class="tab-pane fade" id="register" role="tabpanel" aria-labelledby="register-tab">
                                <form action="#">
                                    <div class="form-group">
                                        <label for="register-email">Your email address *</label>
                                        <input type="email" class="form-control" id="register-email" name="register-email" required>
                                    </div><!-- End .form-group -->

                                    <div class="form-group">
                                        <label for="register-password">Password *</label>
                                        <input type="password" class="form-control" id="register-password" name="register-password" required>
                                    </div><!-- End .form-group -->

                                    <div class="form-footer">
                                        <button type="submit" class="btn btn-outline-primary-2">
                                            <span>SIGN UP</span>
                                            <i class="icon-long-arrow-right"></i>
                                        </button>

                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="register-policy" required>
                                            <label class="custom-control-label" for="register-policy">I agree to the <a href="#">privacy policy</a> *</label>
                                        </div><!-- End .custom-checkbox -->
                                    </div><!-- End .form-footer -->
                                </form>
                                <div class="form-choice">
                                    <p class="text-center">or sign in with</p>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <a href="#" class="btn btn-login btn-g">
                                                <i class="icon-google"></i>
                                                Login With Google
                                            </a>
                                        </div><!-- End .col-6 -->
                                        <div class="col-sm-6">
                                            <a href="#" class="btn btn-login  btn-f">
                                                <i class="icon-facebook-f"></i>
                                                Login With Facebook
                                            </a>
                                        </div><!-- End .col-6 -->
                                    </div><!-- End .row -->
                                </div><!-- End .form-choice -->
                            </div><!-- .End .tab-pane -->
                        </div><!-- End .tab-content -->
                    </div><!-- End .form-tab -->
                </div><!-- End .form-box -->
            </div><!-- End .modal-body -->
        </div><!-- End .modal-content -->
    </div><!-- End .modal-dialog -->
</div><!-- End .modal -->

<c:if test="${gioHangRong==true}">
    alert("Giỏ hàng cua bạn không có gì để thực hiện thanh toán");
</c:if>

<!-- Plugins JS File -->
<script src="/user/assets/js/jquery.min.js"></script>
<script src="/user/assets/js/bootstrap.bundle.min.js"></script>
<script src="/user/assets/js/jquery.hoverIntent.min.js"></script>
<script src="/user/assets/js/jquery.waypoints.min.js"></script>
<script src="/user/assets/js/superfish.min.js"></script>
<script src="/user/assets/js/owl.carousel.min.js"></script>
<script src="/user/assets/js/bootstrap-input-spinner.js"></script>
<!-- Main JS File -->
<script src="/user/assets/js/main.js"></script>

<script>

    // làm cách nào để lấy được xem sản phẩm đó có được tích hay không ?
    // nếu được tích - truyền number = +1 , lấy theo id, lấy theo giá sản phẩm, số lượng nữa
    // nếu ko được tích - truyền number = -1, để thực hiện + thêm hoặc xóa đi

    // Hàm để gửi dữ liệu về server để lưu vào session
    function changeNumberProduct(idSanPhamCT, soLuong) {
        // console.log("id sản phẩm:" + idSanPhamCT + "số lượng sản phẩm: " + soLuong);
        // /gio-hang/view-gio
        $.ajax({
            type: "POST",
            url: "/gio-hang/capNhatSoLuongSPCT", // Đường dẫn đến endpoint xử lý yêu cầu Ajax
            data: JSON.stringify({ idSanPhamCT: idSanPhamCT, soLuong: soLuong }),
            contentType: "application/json",
            success : function(jsonResult) {
                console.log('Xử lý xong cập nhật số lượng xử lý bên server');

                / alert(jsonResult.code + ": " + jsonResult.message); /
                let totalProducts = jsonResult.totalCartProducts;
                let totalPrice = jsonResult.totalPriceResult;

                $("#totalCartProductsId").html(totalProducts);
                $("#totalPriceInCart").html(totalPrice);
                // console.log("totalPriceInCart: " + totalPriceInCart);
                // console.log("totalPrice: " + totalPrice);

                let soLuongMuaVuotQua = jsonResult.soLuongMuaVuotQua;
                if(soLuongMuaVuotQua===true){
                    alert("Số lượng trong kho không đủ, vui lòng chọn sản phẩm khác hoặc liên hệ với chúng tôi để đặt hàng sớm nhất.");
                }

                window.location.href = "/gio-hang/view-gio";
                // window.location.reload();
            },
            error: function(xhr, status, error) {
                // Xử lý lỗi nếu có
                console.error(xhr.responseText);
            }
        });
    }
</script>

<script type="text/javascript">
    // name of checkbox luaChonSanPhamMua

    kiemTraDuocChonKhong = function (idSanPhamCT, soLuong){
        var checkBoxLuaChon = document.getElementById(idSanPhamCT);
        var numberCheck = 0;
        if(checkBoxLuaChon.checked){
            console.log("id sản phẩm " + idSanPhamCT + " được chọn");
            chonSanPhamThanhToan(idSanPhamCT, soLuong, 1);
        }else{
            console.log("id sản phẩm " + idSanPhamCT + " không được chọn");
            chonSanPhamThanhToan(idSanPhamCT, soLuong, 0);
        }

        // window.location.href = "";
        // window.location.reload();
    }

    chonSanPhamThanhToan = function(idSanPhamCT, soLuong, numberCheck) {
        // console.log("Click vào function addToCart");
        let data = {
            idSanPhamCT: idSanPhamCT, //lay theo id
            soLuong: soLuong,
            numberCheck: numberCheck
        };

        //$ === jQuery
        jQuery.ajax({
            url : "/gio-hang/add-to-cartThanhToan",
            type : "POST",
            contentType: "application/json",
            data : JSON.stringify(data),
            dataType : "json", //Kieu du lieu tra ve tu controller la json

            success : function(jsonResult) {
                let totalPrice = jsonResult.totalPriceCartThanhToan;
                $("#totalPriceInCartThanhToan").html(totalPrice);

                // window.location.href = "/gio-hang/view-gio";
            },

            error : function(jqXhr, textStatus, errorMessage) {
                //alert(jsonResult.code + ': Luu thanh cong...!')
            }

        });
    }


    function handleClick() {
        kiemTraSoLuongSanPhamthemVaoGio();
        return false;
    }

    function kiemTraSoLuongSanPhamthemVaoGio() {
        jQuery.ajax({
            url : "/gio-hang/kiemTraSoLuongSPTrongGio",
            type : "GET",
            contentType: "application/json",
            data : JSON.stringify(),
            dataType : "json",

            success : function(jsonResult) {
                let result = jsonResult.checkResult;
                if(result){
                    alert("Giỏ hàng bạn đang rỗng nên không thể thực hiện thanh toán");
                }else {
                    // Nếu giỏ hàng không rỗng, chuyển hướng đến trang thanh toán
                    window.location.href = "/gio-hang/view-thanhToan";
                }
            },

            error : function(jqXhr, textStatus, errorMessage) {
            }

        });
    }
</script>


</body>


<!-- molla/cart.html  22 Nov 2019 09:55:06 GMT -->
</html>