<%@ page import="com.example.duantn.model.ChiTietSanPham" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html lang="en">


<!-- molla/product-centered.html  22 Nov 2019 10:03:13 GMT -->
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Nice Store</title>
    <meta name="keywords" content="HTML5 Template">
    <meta name="description" content="Molla - Bootstrap eCommerce Template">
    <meta name="author" content="p-themes">
    <!-- Favicon -->
    <link rel="apple-touch-icon" sizes="180x180" href="/user/assets/images/icons/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/user/assets/images/logogiay.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/user/assets/images/logogiay.png">
    <link rel="manifest" href="/user/assets/images/icons/site.html">
    <link rel="mask-icon" href="/user/assets/images/icons/safari-pinned-tab.svg" color="#666666">
    <link rel="shortcut icon" href="/user/assets/images/logogiay.png">
    <meta name="apple-mobile-web-app-title" content="Molla">
    <meta name="application-name" content="Molla">
    <meta name="msapplication-TileColor" content="#cc9966">
    <meta name="msapplication-config" content="/user/assets/images/icons/browserconfig.xml">
    <meta name="theme-color" content="#ffffff">
    <!-- Plugins CSS File -->
    <link rel="stylesheet" href="/user/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/user/assets/css/plugins/owl-carousel/owl.carousel.css">
    <link rel="stylesheet" href="/user/assets/css/plugins/magnific-popup/magnific-popup.css">
    <!-- Main CSS File -->
    <link rel="stylesheet" href="/user/assets/css/style.css">
    <link rel="stylesheet" href="/user/assets/css/plugins/nouislider/nouislider.css">
    <%--    Link Jquery--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


    <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"> -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <style>
        * {
            font-family: 'Roboto', sans-serif !important;
        }
    </style>
</head>
<!-- molla/product-centered.html  22 Nov 2019 10:03:13 GMT -->

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

                    <nav class="main-nav" style="margin-left: 360px; font-size: 30px important!;">
                        <ul class="menu sf-arrows">
                            <li class="megamenu-container ">
                                <a href="/gio-hang/view-trangChu2"><b>Trang chủ</b></a>
                            </li>
                            <li style="margin-left: -20px;" class="active">
                                <a href="/gio-hang/view-xemToanBoSanPham" class=""><b>Xem giày</b></a>
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

                        <%--                            <div class="dropdown-menu dropdown-menu-right">--%>
                        <%--                                <div class="dropdown-cart-products">--%>



                        <%--                                </div><!-- End .cart-product -->--%>

                        <%--                                <div class="dropdown-cart-total">--%>
                        <%--                                    <span>Thanh toán</span>--%>

                        <%--                                    <span class="cart-total-price">$160.00</span>--%>
                        <%--                                </div><!-- End .dropdown-cart-total -->--%>

                        <%--                                <div class="dropdown-cart-action">--%>
                        <%--                                    <a href="cart.html" class="btn btn-primary">View Cart</a>--%>
                        <%--                                    <a href="checkout.html" class="btn btn-outline-primary-2"><span>Checkout</span><i--%>
                        <%--                                            class="icon-long-arrow-right"></i></a>--%>
                        <%--                                </div><!-- End .dropdown-cart-total -->--%>
                        <%--                            </div><!-- End .dropdown-menu -->--%>
                        <%--                        --%>

                    </div><!-- End .cart-dropdown -->
                </div><!-- End .header-right -->
            </div><!-- End .container -->
        </div><!-- End .header-middle -->
    </header><!-- End .header -->

    <main class="main">
        <nav aria-label="breadcrumb" class="breadcrumb-nav border-0 mb-0">
            <div class="container d-flex align-items-center">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.html">Trang chủ</a></li>
                    <li class="breadcrumb-item"><a href="#">${sanPhamCT.sanPham.ten}</a></li>
                    <!-- <li class="breadcrumb-item active" aria-current="page">Centered</li> -->
                </ol>


            </div><!-- End .container -->
        </nav><!-- End .breadcrumb-nav -->

        <div class="page-content">
            <div class="container">
                <div class="product-details-top mb-2">
                    <div class="row">
                        <div class="col-md-7">
                            <div class="product-gallery product-gallery-vertical">
                                <div class="row ">
                                    <figure class="product-main-image">
                                        <img id="product-zoom" src="${sanPhamCT.hinhAnh}" data-zoom-image="${sanPhamCT.hinhAnh}" alt="product image">

                                        <a href="#" id="btn-product-gallery" class="btn-product-gallery">
                                            <i class="icon-arrows"></i>
                                        </a>
                                    </figure><!-- End .product-main-image -->

                                    <div id="product-zoom-gallery" class="product-image-gallery">

                                        <c:forEach items="${dsHinhAnhGiay}" var="hinhAnhs">
                                            <a class="product-gallery-item" href="#" data-image="${hinhAnhs.duongDanAnh}" data-zoom-image="${hinhAnhs.duongDanAnh}">
                                                <img src="${hinhAnhs.duongDanAnh}" alt="product cross" style="width: 110px; height: 130px;">
                                            </a>

                                        </c:forEach>

                                    </div><!-- End .product-image-gallery -->
                                </div><!-- End .row -->
                            </div><!-- End .product-gallery -->
                        </div><!-- End .col-md-6 -->

                        <div class="col-md-5">
                            <div class="product-details  ">
                                <h1 class="product-title" style="font-size: 40px !important;">${sanPhamCT.sanPham.ten}</h1><!-- End .product-title -->

                                <div class="product-price" style="padding-bottom: 20px;">
                                    <c:if test="${sanPhamCT.giaTriGiam > 0}">
                                        <s style="color: black !important;">

                                            <fmt:formatNumber type = "number"
                                                              maxFractionDigits = "0" value = "${sanPhamCT.giaTriSanPham}" />
                                        </s>

                                        <span style="margin: 0px 5px; color: black;"><b>-</b></span>
                                        <b style="color: red;">
                                            <fmt:formatNumber type = "number"
                                                              maxFractionDigits = "0" value = "${sanPhamCT.giaTriGiam}" /> vnđ
                                        </b>
                                    </c:if>
                                    <c:if test="${sanPhamCT.giaTriGiam == 0 || sanPhamCT.giaTriGiam ==null }">
                                        <b style="color: red;" style="margin-top: 100px;">
                                            <fmt:formatNumber type = "number"
                                                              maxFractionDigits = "0" value = "${sanPhamCT.giaTriSanPham}" /> vnđ
                                        </b>
                                    </c:if>

                                </div><!-- End .product-price -->

                                <div class="details-filter-row details-row-size">
                                    <label>Màu sắc:</label>
                                    <!-- class="product-nav product-nav-thumbs" -->
                                    <div class="col-lg-12 d-flex justify-content-center align-items-center product-nav product-nav-thumbs" style="margin-left: -170px;">
                                        <c:forEach items="${dsSP_theoColor_image}" var="dsColor_image">
                                            <div class=" active" style="margin-right: 5px;">
                                                <a href="/giay/upload-sizeGiay/${sanPhamCT.sanPham.id}/${dsColor_image.mauSac.id}" >
                                                    <img src="${dsColor_image.hinhAnh}" alt="product desc" style="width: 90px;height: 70px;">
                                                </a>
                                            </div>

                                        </c:forEach>

                                    </div>
                                </div><!-- End .details-filter-row -->
                                <!-- details-row-size -->

                                <div class="details-filter-row  ">
                                    <a href="#" class="size-guide " style="margin-left: 0px; margin-top: 10px;"><i class="icon-th-list"></i>Hướng dẫn chọn size</a>
                                </div><!-- End .details-filter-row -->
                                <div>
                                    <div>
                                            <p>Chọn size giày:
                                                <c:forEach items="${dsChiTietSP_color_sp}" var="listSizeTheo_idMauSac_SanPham" >
                                                    <c:choose>
                                                        <c:when test="${sanPhamCT.kichCo.ten == listSizeTheo_idMauSac_SanPham.kichCo.ten}">
                                                            <label id="${listSizeTheo_idMauSac_SanPham.id}" style="padding: 12px; border: 1px solid #DEDEDE; border-radius: 12px; margin-left: 5px; background-color: blanchedalmond; font-size: 18px;" onclick="changeBackgroundColor(this)">
                                                                <input type="radio" checked hidden name="sizeGiayDuocChon" value="${listSizeTheo_idMauSac_SanPham.id}" onchange="laySoLuongCoSan(this.value, '${listSizeTheo_idMauSac_SanPham.id}')"/> ${listSizeTheo_idMauSac_SanPham.kichCo.ten} <br/>
                                                            </label>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <label id="${listSizeTheo_idMauSac_SanPham.id}" style="padding: 12px; border: 1px solid #DEDEDE; border-radius: 12px; margin-left: 5px; background-color: white; font-size: 18px;" onclick="changeBackgroundColor(this)">
                                                                <input type="radio" name="sizeGiayDuocChon" hidden value="${listSizeTheo_idMauSac_SanPham.id}" onchange="laySoLuongCoSan(this.value, '${listSizeTheo_idMauSac_SanPham.id}')"/> ${listSizeTheo_idMauSac_SanPham.kichCo.ten} <br/>
                                                            </label>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </c:forEach>
                                            </p>

                                            <script>
                                                function changeBackgroundColor(label) {
                                                    // Lấy tất cả các label có trong p
                                                    var labels = document.querySelectorAll('p label');

                                                    // Đặt lại màu nền cho tất cả các label
                                                    labels.forEach(function(item) {
                                                        item.style.backgroundColor = 'white'; // Xóa màu nền của label
                                                    });

                                                    // Đặt màu nền cho label được click
                                                    // Nếu radio button được chọn, thì đặt màu nền cho label
                                                    if (label.querySelector('input').checked) {
                                                        label.style.backgroundColor = 'blanchedalmond';
                                                    }
                                                }
                                            </script>

                                    </div>
                                </div>

                                <div class="product-details-action  d-flex" >
                                    <!-- <div class="details-action-col"> -->
                                    <div class="col-lg-3" style="margin-top: 10px; margin-left: -7px;">
<%--                                        <input type="number" id="soLuongMua" class="form-control fs-3" style="font-size: 16px;" value="1" min="1" step="1" data-decimals="0" required="">--%>
                                        <input type="number" id="soLuongMua" class="form-control fs-3" style="font-size: 16px;" value="1"  data-decimals="0" required="">
                                    </div>
                                    <div>
                                        <p  style="font-size: 18px; margin-top: 10px;"> <span id="soLuongSPCoSan"></span> sản phẩm có sẵn</p>
                                    </div>

                                    <!-- </div> -->
                                    <!-- End .details-action-col -->

                                    <div class="col-lg-12 d-flex" style="margin-left: -20px; margin-top: 20px;">
                                        <div class="col-lg-6 ">
                                            <a href="#" class="btn-product btn-cart" style="font-size: 25px;" onclick="addToCart();"><span><b>Thêm giỏ</b></span></a>
                                        </div>
                                        <div class="col-lg-6 ">
                                            <a href="#" class="btn-product btn-cart" style="background-color: #c96 !important; color: white; font-size: 25px;" onclick="muaNgay();"><span><b>Mua ngay</b></span></a>
                                        </div>
                                    </div>
                                </div><!-- End .product-details-action -->

                                <div style="margin-bottom: 10px;">
                                    <div class="product-cat">
                                        <span>Loại sản phẩm:</span>
                                        <a href="#">${sanPhamCT.loaiSanPham.ten}</a>
                                    </div><!-- End .product-cat -->
                                </div>
                                <div style="margin-bottom: 10px;">
                                    <div class="product-cat">
                                        <span>Thương hiệu:</span>
                                        <a href="#">${sanPhamCT.thuongHieu.ten}</a>
                                    </div><!-- End .product-cat -->
                                </div>
                                <div style="margin-bottom: 10px;">
                                    <div class="product-cat">
                                        <span>NSX:</span>
                                        <a href="#">${sanPhamCT.nsx.ten}</a>
                                    </div><!-- End .product-cat -->
                                </div>
                                <div style="margin-bottom: 10px;">
                                    <div class="product-cat">
                                        <span>Danh mục:</span>
                                        <a href="#">${sanPhamCT.danhMuc.ten}</a>
                                    </div><!-- End .product-cat -->
                                </div>
                                <div style="margin-bottom: 10px;">
                                    <div class="product-cat">
                                        <span>Chất liệu:</span>
                                        <a href="#">${sanPhamCT.chatLieu.ten}</a>
                                    </div><!-- End .product-cat -->
                                </div>
                                <div style="margin-bottom: 10px;">
                                    <div class="product-cat">
                                        <span>Mô tả:</span>
                                        <a href="#">${sanPhamCT.moTa}</a>
                                    </div><!-- End .product-cat -->
                                </div>

                                    <!-- <div class="social-icons social-icons-sm">
                                        <span class="social-label">Share:</span>
                                        <a href="#" class="social-icon" title="Facebook" target="_blank"><i class="icon-facebook-f"></i></a>
                                        <a href="#" class="social-icon" title="Twitter" target="_blank"><i class="icon-twitter"></i></a>
                                        <a href="#" class="social-icon" title="Instagram" target="_blank"><i class="icon-instagram"></i></a>
                                        <a href="#" class="social-icon" title="Pinterest" target="_blank"><i class="icon-pinterest"></i></a>
                                    </div> -->
                                </div><!-- End .product-details-footer -->
                            </div><!-- End .product-details -->
                        </div><!-- End .col-md-6 -->
                    </div><!-- End .row -->
                </div><!-- End .product-details-top -->

                <div class="product-details-tab">
                    <ul class="nav nav-pills justify-content-center" role="tablist">
                        <!-- <li class="nav-item">
                            <a class="nav-link active" id="product-desc-link" data-toggle="tab" href="#product-desc-tab" role="tab" aria-controls="product-desc-tab" aria-selected="true">Mô tả</a>
                        </li> -->
<%--                        <li class="nav-item">--%>
<%--                            <a class="nav-link" id="product-info-link" data-toggle="tab" href="#product-info-tab" role="tab" aria-controls="product-info-tab" aria-selected="false">Thông tin bổ sung</a>--%>
<%--                        </li>--%>
                        <li class="nav-item">
                            <a class="nav-link" id="product-shipping-link" data-toggle="tab" href="#product-shipping-tab" role="tab" aria-controls="product-shipping-tab" aria-selected="false">Vận chuyển &amp; Trả hàng</a>
                        </li>
                        <!-- <li class="nav-item">
                            <a class="nav-link" id="product-review-link" data-toggle="tab" href="#product-review-tab" role="tab" aria-controls="product-review-tab" aria-selected="false">Đánh giá (2)</a>
                        </li> -->
                    </ul>
                    <div class="tab-content">

<%--                        <div class="tab-pane fade" id="product-info-tab" role="tabpanel" aria-labelledby="product-info-link">--%>
<%--                            <div class="product-desc-content">--%>
<%--                                <h3>Thông tin sản phẩm</h3>--%>
<%--                                <p>Thời trang cá tính trẻ trung </p>--%>

<%--                                <h3>Chi Tiết</h3>--%>
<%--                                <ul>--%>
<%--                                    <li>Màu sắc: Trắng,Đỏ</li>--%>
<%--                                    <li>Da: Tổng hợp.</li>--%>
<%--                                    <li>Thương hiệu: Nike</li>--%>
<%--                                </ul>--%>

<%--                                <h3>Size</h3>--%>
<%--                                <p> 40-44</p>--%>
<%--                            </div><!-- End .product-desc-content -->--%>
<%--                        </div><!-- .End .tab-pane -->--%>

                        <div class="tab-pane fade" id="product-shipping-tab" role="tabpanel" aria-labelledby="product-shipping-link">
                            <div class="product-desc-content">
                                <h3>Giao hàng &amp; trả hàng</h3>
                                <p>Chúng tôi giao hàng đến hơn khắp miền. Để biết chi tiết đầy đủ về các tùy chọn giao hàng mà chúng tôi cung cấp, vui lòng xem thông tin giao hàng <br>
                                    Chúng tôi hy vọng bạn sẽ thích mọi giao dịch mua, nhưng nếu bạn cần trả lại một mặt hàng, bạn có thể làm như vậy trong vòng một tháng kể từ khi nhận. Để biết đầy đủ chi tiết về cách trả hàng, vui lòng xem</p>
                            </div><!-- End .product-desc-content -->
                        </div><!-- .End .tab-pane -->

                    </div><!-- End .tab-content -->
                </div><!-- End .product-details-tab -->

                </div><!-- End .owl-carousel -->
            </div><!-- End .container -->
        </div><!-- End .page-content -->
    </main>

    <footer class="footer">
        <div class="footer-middle">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-lg-4 " style="justify-content: center;">
                        <div class="widget widget-about">
                            <img src="/user/assets/images/logo-black.png" class="footer-logo" alt="Footer Logo" width="100" height="25" style="margin-left: 45px;">
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
    </footer>
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

<!-- Plugins JS File -->
<script src="/user/assets/js/jquery.min.js"></script>
<script src="/user/assets/js/bootstrap.bundle.min.js"></script>
<script src="/user/assets/js/jquery.hoverIntent.min.js"></script>
<script src="/user/assets/js/jquery.waypoints.min.js"></script>
<script src="/user/assets/js/superfish.min.js"></script>
<script src="/user/assets/js/owl.carousel.min.js"></script>
<script src="/user/assets/js/bootstrap-input-spinner.js"></script>
<script src="/user/assets/js/jquery.elevateZoom.min.js"></script>
<script src="/user/assets/js/bootstrap-input-spinner.js"></script>
<script src="/user/assets/js/jquery.magnific-popup.min.js"></script>
<!-- Main JS File -->
<script src="/user/assets/js/main.js"></script>
<!-- Code injected by live-server -->


<script>
    // <![CDATA[  <-- For SVG support
    if ('WebSocket' in window) {
        (function () {
            function refreshCSS() {
                var sheets = [].slice.call(document.getElementsByTagName("link"));
                var head = document.getElementsByTagName("head")[0];
                for (var i = 0; i < sheets.length; ++i) {
                    var elem = sheets[i];
                    var parent = elem.parentElement || head;
                    parent.removeChild(elem);
                    var rel = elem.rel;
                    if (elem.href && typeof rel != "string" || rel.length == 0 || rel.toLowerCase() == "stylesheet") {
                        var url = elem.href.replace(/(&|\?)_cacheOverride=\d+/, '');
                        elem.href = url + (url.indexOf('?') >= 0 ? '&' : '?') + '_cacheOverride=' + (new Date().valueOf());
                    }
                    parent.appendChild(elem);
                }
            }
            var protocol = window.location.protocol === 'http:' ? 'ws://' : 'wss://';
            var address = protocol + window.location.host + window.location.pathname + '/ws';
            var socket = new WebSocket(address);
            socket.onmessage = function (msg) {
                if (msg.data == 'reload') window.location.reload();
                else if (msg.data == 'refreshcss') refreshCSS();
            };
            if (sessionStorage && !sessionStorage.getItem('IsThisFirstTime_Log_From_LiveServer')) {
                console.log('Live reload enabled.');
                sessionStorage.setItem('IsThisFirstTime_Log_From_LiveServer', true);
            }
        })();
    }
    else {
        console.error('Upgrade your browser. This Browser is NOT supported WebSocket for Live-Reloading.');
    }
    // ]]>
</script>
<!-- Code injected by live-server -->


<script>
    // <![CDATA[  <-- For SVG support
    if ('WebSocket' in window) {
        (function () {
            function refreshCSS() {
                var sheets = [].slice.call(document.getElementsByTagName("link"));
                var head = document.getElementsByTagName("head")[0];
                for (var i = 0; i < sheets.length; ++i) {
                    var elem = sheets[i];
                    var parent = elem.parentElement || head;
                    parent.removeChild(elem);
                    var rel = elem.rel;
                    if (elem.href && typeof rel != "string" || rel.length == 0 || rel.toLowerCase() == "stylesheet") {
                        var url = elem.href.replace(/(&|\?)_cacheOverride=\d+/, '');
                        elem.href = url + (url.indexOf('?') >= 0 ? '&' : '?') + '_cacheOverride=' + (new Date().valueOf());
                    }
                    parent.appendChild(elem);
                }
            }
            var protocol = window.location.protocol === 'http:' ? 'ws://' : 'wss://';
            var address = protocol + window.location.host + window.location.pathname + '/ws';
            var socket = new WebSocket(address);
            socket.onmessage = function (msg) {
                if (msg.data == 'reload') window.location.reload();
                else if (msg.data == 'refreshcss') refreshCSS();
            };
            if (sessionStorage && !sessionStorage.getItem('IsThisFirstTime_Log_From_LiveServer')) {
                console.log('Live reload enabled.');
                sessionStorage.setItem('IsThisFirstTime_Log_From_LiveServer', true);
            }
        })();
    }
    else {
        console.error('Upgrade your browser. This Browser is NOT supported WebSocket for Live-Reloading.');
    }
     // ]]>
</script>

<script>
    function sizeGiayDuocChon_laSanPhamChiTiet_layIdSanPhamChiTietDo() {
        var radios = document.getElementsByName('sizeGiayDuocChon');
        var selectedValue = '';

        for (var i = 0; i < radios.length; i++) {
            if (radios[i].checked) {
                selectedValue = radios[i].value;
                break;
            }
        }
        return selectedValue;
    }

    document.addEventListener("DOMContentLoaded", function(event) {
        var giaTriDuocChon = sizeGiayDuocChon_laSanPhamChiTiet_layIdSanPhamChiTietDo();
        laySoLuongCoSan(giaTriDuocChon);

    });

</script>

<script type="text/javascript">
    function showHideQuantityInput(selectElement) {
        var selectedValue = selectElement.value;
        var quantityInput = document.getElementById("quantityInput");

        // Kiểm tra giá trị được chọn trong select và hiển thị/ẩn ô nhập số lượng sản phẩm tương ứng
        if (selectedValue === '' ) {
            alert("Vui lòng chọn size giày");
            quantityInput.style.display = "block"; // Hiển thị ô nhập số lượng
        } else {
            quantityInput.style.display = "none"; // Ẩn ô nhập số lượng
        }
    }

    laySoLuongCoSan = function(idSanPhamCT) {
        console.log("Click vào function laySoLuongCoSan");
        let data = {
            idSanPhamChiTiet: idSanPhamCT
        };
        //$ === jQuery
        jQuery.ajax({
            url : "/giay/laySoLuongCoSanSP",
            type : "POST",
            contentType: "application/json",
            data : JSON.stringify(data),
            dataType : "json", //Kieu du lieu tra ve tu controller la json

            success : function(jsonResult) {
                let soLuongSanPham = jsonResult.soLuongSP==null?0:jsonResult.soLuongSP;
                $("#soLuongSPCoSan").html(soLuongSanPham);
                // alert("laySoLuongCoSan thanh cong");
            },

            error : function(jqXhr, textStatus, errorMessage) {
                //alert(jsonResult.code + ': Luu thanh cong...!')
            }

        });
    }

    // thêm sản phẩm vào giỏ
    addToCart = function() {
        var tongSoLuongSanPhamTrongGio = 0;
        // console.log("Click vào function addToCart");
        let soLuongMua = document.getElementById('soLuongMua').value;
        console.log("Số lượng mua chi tiết : " + soLuongMua);

        if(parseInt(soLuongMua)<=0){
            alert("Vui lòng nhập số lượng mua > 0 ");
            return;
        }

        let idSanPhamCTDuocChon;

        // Lấy ra radio button được chọn
        var radios = document.getElementsByName('sizeGiayDuocChon');

        // Duyệt qua tất cả các radio button để kiểm tra xem cái nào được chọn
        for (var i = 0; i < radios.length; i++) {
            if (radios[i].checked) {
                // Nếu radio button được chọn, lấy giá trị và hiển thị ra console
                console.log("Đã chọn radio: " + radios[i].value );
                idSanPhamCTDuocChon = radios[i].value;
                break;
            }
        }

        layTongSoLuongSanPhamTrongGio()
            .then(function(totalAllProducts) {
                tongSoLuongSanPhamTrongGio = totalAllProducts;
                console.log("Gia tri cua tongSoLuongSanPhamTrongGio : " + tongSoLuongSanPhamTrongGio);

                var checkSoLuongToiDa = parseInt(tongSoLuongSanPhamTrongGio) + parseInt(soLuongMua) ;

                if(checkSoLuongToiDa>10){
                    alert("Giỏ hàng chỉ được thêm tối đa 10 sản phẩm! \n" + "Tổng số lượng sản phẩm trong giỏ hàng của bạn: "+ tongSoLuongSanPhamTrongGio);
                    return;
                }else{
                    let data = {
                        idSanPhamCT: idSanPhamCTDuocChon, //lay theo id
                        soLuongMuaThem: soLuongMua
                    };

                    //$ === jQuery
                    jQuery.ajax({
                        url : "/gio-hang/add-to-cart",
                        type : "POST",
                        contentType: "application/json",
                        data : JSON.stringify(data),
                        dataType : "json", //Kieu du lieu tra ve tu controller la json

                        success : function(jsonResult) {
                            let soLuongMuaVuotQua = jsonResult.soLuongMuaVuotQua;
                            let totalProducts = jsonResult.totalCartProducts;
                            let checkSoLuonagSP_conTrongKho = jsonResult.conSoLuongTrongKho;
                            let soLuongMua = jsonResult.soLuongMua;
                            let soLuongSPTrongKho = jsonResult.soLuongSPTrongKho;

                            $("#totalCartProductsId").html(totalProducts);

                            if(soLuongMua>soLuongSPTrongKho){
                                alert("Số lượng chọn mua vượt quá số lượng sản phẩm trong kho!");
                                return;
                            }
                            if(soLuongMuaVuotQua===true &&  checkSoLuonagSP_conTrongKho===true ){  // quá số lượng trong kho thêm vào giỏ
                                alert("Bạn đã thêm hết số lượng sản phẩm này vào giỏ rồi!\n Vui lòng kiểm tra giỏ hàng của bạn");
                            }else{
                                alert("Thêm sản phẩm vào giỏ thành công");
                            }
                        },

                        error : function(jqXhr, textStatus, errorMessage) {
                            //alert(jsonResult.code + ': Luu thanh cong...!')
                        }

                    });
                }
            })
            .catch(function(errorMessage) {
                console.error("Lỗi khi lấy tổng số lượng sản phẩm trong giỏ: " + errorMessage);
            });
    }

    muaNgay = function() {
        let soLuongMua = document.getElementById('soLuongMua').value;
        let idSanPhamCTDuocChon;

        if(parseInt(soLuongMua)<=0){
            alert("Vui lòng nhập số lượng mua > 0");
            return;
        }

        // Lấy ra radio button được chọn
        var radios = document.getElementsByName('sizeGiayDuocChon');

        // Duyệt qua tất cả các radio button để kiểm tra xem cái nào được chọn
        for (var i = 0; i < radios.length; i++) {
            if (radios[i].checked) {
                // Nếu radio button được chọn, lấy giá trị và hiển thị ra console
                console.log("Đã chọn radio: " + radios[i].value );
                idSanPhamCTDuocChon = radios[i].value;
                break;
            }
        }

        layTongSoLuongSanPhamTrongGio()
            .then(function(totalAllProducts) {
                tongSoLuongSanPhamTrongGio = totalAllProducts;
                console.log("Gia tri cua tongSoLuongSanPhamTrongGio : " + tongSoLuongSanPhamTrongGio);

                var checkSoLuongToiDa = parseInt(tongSoLuongSanPhamTrongGio) + parseInt(soLuongMua) ;

                if(checkSoLuongToiDa>10){
                    alert("Giỏ hàng chỉ được thêm tối đa 10 sản phẩm! \n" + "Tổng số lượng sản phẩm trong giỏ hàng của bạn: "+ tongSoLuongSanPhamTrongGio);
                    return;
                }else{
                    let data = {
                        idSanPhamCT: idSanPhamCTDuocChon, //lay theo id
                        soLuong: soLuongMua
                    };

                    //$ === jQuery
                    jQuery.ajax({
                        url : "/gio-hang/mua-ngay",
                        type : "POST",
                        contentType: "application/json",
                        data : JSON.stringify(data),
                        dataType : "json", //Kieu du lieu tra ve tu controller la json

                        success : function(jsonResult) {
                            let soLuongMuaVuotQua = jsonResult.soLuongMuaVuotQua;
                            let totalProducts = jsonResult.totalCartProducts;
                            $("#totalCartProductsId").html(totalProducts);
                            // $("#totalPriceInCart").html(totalPrice);
                            let checkSoLuonagSP_conTrongKho = jsonResult.conSoLuongTrongKho;
                            let soLuongMua = jsonResult.soLuongMua;
                            let soLuongSPTrongKho = jsonResult.soLuongSPTrongKho;

                            if(soLuongMua>soLuongSPTrongKho){
                                alert("Số lượng chọn mua vượt quá số lượng sản phẩm trong kho!");
                                return;
                            }
                            if(soLuongMuaVuotQua===true &&  checkSoLuonagSP_conTrongKho===true ){  // quá số lượng trong kho thêm vào giỏ
                                alert("Bạn đã thêm hết số lượng sản phẩm này vào giỏ rồi!\n Vui lòng kiểm tra giỏ hàng của bạn");
                            }else{
                                window.location.href = "/gio-hang/view-gio";
                            }
                        },

                        error : function(jqXhr, textStatus, errorMessage) {
                            //alert(jsonResult.code + ': Luu thanh cong...!')
                        }

                    });
                }
            })
            .catch(function(errorMessage) {
                console.error("Lỗi khi lấy tổng số lượng sản phẩm trong giỏ: " + errorMessage);
            });



    }

    function layTongSoLuongSanPhamTrongGio() {
        return new Promise(function(resolve, reject) {
            let data = {};

            jQuery.ajax({
                url: "/gio-hang/layTongSLSanPhamTrongGio",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(data),
                dataType: "json",

                success: function(jsonResult) {
                    let totalAllProducts = jsonResult.totalAllProducts===null?0:jsonResult.totalAllProducts;
                    $("#totalAllProduct_InCart").html(totalAllProducts);
                    console.log("Tổng số lượng sản phẩm trong giỏ : " + totalAllProducts);

                    resolve(totalAllProducts); // Trả về giá trị totalAllProducts khi thành công
                },

                error: function(jqXhr, textStatus, errorMessage) {
                    reject(errorMessage); // Trả về lỗi khi gặp lỗi
                }
            });
        });
    }

</script>



</body>


</html>