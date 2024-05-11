<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html lang="en">


<!-- molla/index-2.html  22 Nov 2019 09:55:32 GMT -->

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Trang chủ</title>
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
    <link rel="stylesheet" href="/user/assets/css/plugins/owl-carousel/owl.carousel.css">
    <link rel="stylesheet" href="/user/assets/css/plugins/magnific-popup/magnific-popup.css">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>

    <!-- Main CSS File -->
    <link rel="stylesheet" href="/user/assets/css/style.css">
    <style>
        * {
            font-family: 'Roboto', sans-serif !important;
        }
    </style>
</head>

<body>
<div class="container">
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
                                <li class="megamenu-container active">
                                    <a href="/gio-hang/view-trangChu2"><b>Trang chủ</b></a>
                                </li>
                                <li style="margin-left: -20px;">
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

        <main class="main ">
            <!-- banner show slide -->
            <div class="row justify-content-center align-items-center">
                <div id="carouselExampleCaptions" class="col-lg-12 carousel slide" data-bs-ride="carousel">
                    <div class="carousel-indicators">
                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0"
                                class="active" aria-current="true" aria-label="Slide 1"></button>
                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"
                                aria-label="Slide 2"></button>
                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"
                                aria-label="Slide 3"></button>
                    </div>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="/user/assets/images/banners/banner6.png" class="d-block w-100 h-50" alt="...">
                            <div class="carousel-caption d-none d-md-block ">
                                <!-- <h5
                                    style="margin-top: -400px; margin-left: 300px; text-shadow: 4px 4px 8px black; font-size: 60px; color: yellow;">
                                    </h5>
                                <p
                                    style=" margin-left: 300px; text-shadow: 4px 4px 8px black; font-size: 50px; color: yellow;">
                                    Nike đồng hành cùng bạn</p> -->
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="/user/assets/images/banners/banner5.jpg" class="d-block w-100 h-50" alt="...">
                            <div class="carousel-caption d-none d-md-block">

                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="/user/assets/images/banners/banner5.jpg" class="d-block w-100 h-50" alt="...">
                            <div class="carousel-caption d-none d-md-block">

                            </div>
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions"
                            data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions"
                            data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </div>
            <!--/ banner show slide -->

            <div class="mb-6"></div><!-- End .mb-6 -->

            <div class="container">
                <div class="heading heading-center mb-3">
                    <h2 class="title-lg">Giày nam giá tốt</h2><!-- End .title -->

                </div><!-- End .heading -->

                <div class="tab-content tab-content-carousel">
                    <%--                        <div class="tab-pane p-0 fade show active" id="${dsLoaiSPtrongSPCT.id}" role="tabpanel">--%>
                    <div class="products mb-3">
                        <div class="row justify-content-center">
                            <c:forEach items="${dsSanPham}" var="sanPhamChiTiet">
                                <%--                                        <c:forEach items="${dsLoaiSP_trongSanPhamCT}" var="loaiSanPham">--%>
                                <c:if   test="${sanPhamChiTiet.danhMuc.ten == 'Nam'}">
                                    <div class="col-6 col-md-4 col-lg-4 col-xl-3">
                                        <div class="product product-7 text-center">
                                            <figure class="product-media">
                                                <c:if test="${sanPhamChiTiet.giaTriGiam>0}">
                                                            <span class="product-label label-new">
                                                                <fmt:formatNumber type="number" value="${Math.floor((((sanPhamChiTiet.giaTriSanPham - sanPhamChiTiet.giaTriGiam) / sanPhamChiTiet.giaTriSanPham) * 100))}" /> %
                                                             </span>
                                                </c:if>

                                                <a href="/giay/view-chiTietSanPham/${sanPhamChiTiet.id}">
                                                    <img src="${pageContext.request.contextPath}${sanPhamChiTiet.hinhAnh}" alt="Product image" class="product-image">
                                                </a>

                                                <div class="product-action">
<%--                                                    <a href="#" class="btn-product btn-cart" onclick="addToCart('${sanPhamChiTiet.id}', 1);"><span>Thêm vào giỏ</span></a>--%>
<%--                                                    <a href="#" class="btn-product btn-cart" onclick="muaNgay('${sanPhamChiTiet.id}', 1);"><span>Mua ngay</span></a>--%>
                                                    <a href="/giay/view-chiTietSanPham/${sanPhamChiTiet.id}" class="btn-product" ><span>Xem chi tiết</span></a>

                                                </div><!-- End .product-action -->
                                            </figure><!-- End .product-media -->

                                            <div class="product-body">
                                                <div class="product-cat">

                                                </div><!-- End .product-cat -->
                                                    <%--                                                        <p>id sản phẩm : ${sanPhamChiTiet.id}</p>--%>
                                                <h3 class="product-title"><a href="/giay/view-chiTietSanPham/${sanPhamChiTiet.id}">${sanPhamChiTiet.sanPham.ten}  ${sanPhamChiTiet.mauSac.ten}  ${sanPhamChiTiet.muiGiay.ten} ${sanPhamChiTiet.deGiay.ten} </a></h3><!-- End .product-title -->

                                                <div class="product-price" style="margin-top: 5px;">
                                                    <c:if test="${sanPhamChiTiet.giaTriGiam > 0}">
                                                        <s style="color: black !important;">

                                                            <fmt:formatNumber type = "number"
                                                                              maxFractionDigits = "0" value = "${sanPhamChiTiet.giaTriSanPham}" />
                                                        </s>

                                                        <span style="margin: 0px 5px; color: black;"><b>-</b></span>
                                                        <b style="color: red;">
                                                            <fmt:formatNumber type = "number"
                                                                              maxFractionDigits = "0" value = "${sanPhamChiTiet.giaTriGiam}" /> vnđ
                                                        </b>
                                                    </c:if>
                                                    <c:if test="${sanPhamChiTiet.giaTriGiam == 0 || sanPhamChiTiet.giaTriGiam ==null }">
                                                        <b style="color: red;" style="margin-top: 100px;">
                                                            <fmt:formatNumber type = "number"
                                                                              maxFractionDigits = "0" value = "${sanPhamChiTiet.giaTriSanPham}" /> vnđ
                                                        </b>
                                                    </c:if>

                                                </div><!-- End .product-price -->

                                                <div class="ratings-container">

                                                </div><!-- End .rating-container -->

                                                <div class="product-nav product-nav-thumbs">
                                                    <a href="/giay/view-chiTietSanPham/${sanPhamChiTiet.id}" class="active">
                                                        <img src="${pageContext.servletContext.contextPath}${sanPhamChiTiet.hinhAnh}" alt="product desc">a
                                                    </a>
                                                </div>
                                            </div><!-- End .product-body -->
                                        </div><!-- End .product -->
                                    </div><!-- End .col-sm-6 col-lg-4 col-xl-3 -->
                                </c:if>
                                <%--                                        </c:forEach>--%>
                            </c:forEach>

                        </div><!-- End .row -->
                    </div><!-- End .products -->

                    <%--                        </div><!-- .End .tab-pane -->--%>

                </div><!-- End .tab-content -->

            </div><!-- End .container -->

            <div class="container">
                <div class="heading heading-center mb-3">
                    <h2 class="title-lg">Giày nữ giá tốt</h2><!-- End .title -->

                </div><!-- End .heading -->

                <div class="tab-content tab-content-carousel">
                    <%--                        <div class="tab-pane p-0 fade show active" id="${dsLoaiSPtrongSPCT.id}" role="tabpanel">--%>
                    <div class="products mb-3">
                        <div class="row justify-content-center">
                            <c:forEach items="${dsSanPham}" var="sanPhamChiTiet">
                                <%--                                        <c:forEach items="${dsLoaiSP_trongSanPhamCT}" var="loaiSanPham">--%>
                                <c:if   test="${sanPhamChiTiet.danhMuc.ten == 'Nữ'}">
                                    <div class="col-6 col-md-4 col-lg-4 col-xl-3">
                                        <div class="product product-7 text-center">
                                            <figure class="product-media">
                                                <c:if test="${sanPhamChiTiet.giaTriGiam>0}">
                                                            <span class="product-label label-new">
                                                                <fmt:formatNumber type="number" value="${Math.floor((((sanPhamChiTiet.giaTriSanPham - sanPhamChiTiet.giaTriGiam) / sanPhamChiTiet.giaTriSanPham) * 100))}" /> %
                                                             </span>
                                                </c:if>
                                                <a href="/giay/view-chiTietSanPham/${sanPhamChiTiet.id}">
                                                    <img src="${pageContext.request.contextPath}${sanPhamChiTiet.hinhAnh}" alt="Product image" class="product-image">
                                                </a>

                                                    <%--                                                <div class="product-action-vertical">--%>
                                                    <%--                                                    <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>--%>
                                                    <%--                                                </div>--%>
                                                <!-- End .product-action-vertical -->

                                                <div class="product-action">
                                                    <a href="#" class="btn-product btn-cart" onclick="addToCart('${sanPhamChiTiet.id}', 1);"><span>Thêm vào giỏ</span></a>
                                                    <a href="#" class="btn-product btn-cart" onclick="muaNgay('${sanPhamChiTiet.id}', 1);"><span>Mua ngay</span></a>
                                                </div><!-- End .product-action -->
                                            </figure><!-- End .product-media -->

                                            <div class="product-body">
                                                <div class="product-cat">

                                                </div><!-- End .product-cat -->
                                                    <%--                                                <p>id sản phẩm : ${sanPhamChiTiet.id}</p>--%>
                                                <h3 class="product-title"><a href="/giay/view-chiTietSanPham/${sanPhamChiTiet.id}">${sanPhamChiTiet.sanPham.ten}  ${sanPhamChiTiet.mauSac.ten}  ${sanPhamChiTiet.muiGiay.ten} ${sanPhamChiTiet.deGiay.ten} </a></h3><!-- End .product-title -->

                                                <div class="product-price" style="margin-top: 5px;">
                                                    <c:if test="${sanPhamChiTiet.giaTriGiam > 0}">
                                                        <s style="color: black !important;">

                                                            <fmt:formatNumber type = "number"
                                                                              maxFractionDigits = "0" value = "${sanPhamChiTiet.giaTriSanPham}" />
                                                        </s>

                                                        <span style="margin: 0px 5px; color: black;"><b>-</b></span>
                                                        <b style="color: red;">
                                                            <fmt:formatNumber type = "number"
                                                                              maxFractionDigits = "0" value = "${sanPhamChiTiet.giaTriGiam}" /> vnđ
                                                        </b>
                                                    </c:if>
                                                    <c:if test="${sanPhamChiTiet.giaTriGiam == 0 || sanPhamChiTiet.giaTriGiam ==null }">
                                                        <b style="color: red;" style="margin-top: 100px;">
                                                            <fmt:formatNumber type = "number"
                                                                              maxFractionDigits = "0" value = "${sanPhamChiTiet.giaTriSanPham}" /> vnđ
                                                        </b>
                                                    </c:if>

                                                </div><!-- End .product-price -->


                                                <div class="ratings-container">

                                                </div><!-- End .rating-container -->

                                                <div class="product-nav product-nav-thumbs">
                                                    <a href="/giay/view-chiTietSanPham/${sanPhamChiTiet.id}" class="active">
                                                        <img src="${pageContext.request.contextPath}${sanPhamChiTiet.hinhAnh}" alt="product desc">
                                                    </a>
                                                    <!-- <a href="#">
                                                        <img src="/user/assets/imagesgiay/giay11-2.jpg" alt="product desc">
                                                    </a>

                                                    <a href="#">
                                                        <img src="/user/assets/images/products/product-4-3-thumb.jpg" alt="product desc">
                                                    </a> -->
                                                </div>
                                            </div><!-- End .product-body -->
                                        </div><!-- End .product -->
                                    </div><!-- End .col-sm-6 col-lg-4 col-xl-3 -->
                                </c:if>
                                <%--                                        </c:forEach>--%>
                            </c:forEach>

                        </div><!-- End .row -->
                    </div><!-- End .products -->

                    <%--                        </div><!-- .End .tab-pane -->--%>

                </div><!-- End .tab-content -->

            </div><!-- End .container -->

            <div class="container">
                <div class="heading heading-center mb-3">
                    <h2 class="title-lg">Giày unisex giá tốt</h2><!-- End .title -->

                </div><!-- End .heading -->

                <div class="tab-content tab-content-carousel">
                    <%--                        <div class="tab-pane p-0 fade show active" id="${dsLoaiSPtrongSPCT.id}" role="tabpanel">--%>
                    <div class="products mb-3">
                        <div class="row justify-content-center">
                            <c:forEach items="${dsSanPham}" var="sanPhamChiTiet">
                                <%--                                        <c:forEach items="${dsLoaiSP_trongSanPhamCT}" var="loaiSanPham">--%>
                                <c:if   test="${sanPhamChiTiet.danhMuc.ten == 'Unisex'}">
                                    <div class="col-6 col-md-4 col-lg-4 col-xl-3">
                                        <div class="product product-7 text-center">
                                            <figure class="product-media">
                                                <c:if test="${sanPhamChiTiet.giaTriGiam>0}">
                                                        <span class="product-label label-new">
                                                            <fmt:formatNumber type="number" value="${Math.floor((((sanPhamChiTiet.giaTriSanPham - sanPhamChiTiet.giaTriGiam) / sanPhamChiTiet.giaTriSanPham) * 100))}" /> %
                                                         </span>
                                                </c:if>
                                                <a href="/giay/view-chiTietSanPham/${sanPhamChiTiet.id}">
                                                    <img src="${pageContext.request.contextPath}${sanPhamChiTiet.hinhAnh}" alt="Product image" class="product-image">
                                                </a>

                                                <div class="product-action-vertical">
                                                    <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>
                                                </div><!-- End .product-action-vertical -->

                                                <div class="product-action">
                                                    <a href="#" class="btn-product btn-cart" onclick="addToCart('${sanPhamChiTiet.id}', 1);"><span>Thêm vào giỏ</span></a>
                                                    <a href="#" class="btn-product btn-cart" onclick="muaNgay('${sanPhamChiTiet.id}', 1);"><span>Mua ngay</span></a>
                                                </div><!-- End .product-action -->
                                            </figure><!-- End .product-media -->

                                            <div class="product-body">
                                                <div class="product-cat">

                                                </div><!-- End .product-cat -->
                                                    <%--                                                <p>id sản phẩm : ${sanPhamChiTiet.id}</p>--%>
                                                <h3 class="product-title"><a href="/giay/view-chiTietSanPham/${sanPhamChiTiet.id}">${sanPhamChiTiet.sanPham.ten}  ${sanPhamChiTiet.mauSac.ten}  ${sanPhamChiTiet.muiGiay.ten} ${sanPhamChiTiet.deGiay.ten} </a></h3><!-- End .product-title -->

                                                <div class="product-price" style="margin-top: 5px;">
                                                    <c:if test="${sanPhamChiTiet.giaTriGiam > 0}">
                                                        <s style="color: black !important;">

                                                            <fmt:formatNumber type = "number"
                                                                              maxFractionDigits = "0" value = "${sanPhamChiTiet.giaTriSanPham}" />
                                                        </s>

                                                        <span style="margin: 0px 5px; color: black;"><b>-</b></span>
                                                        <b style="color: red;">
                                                            <fmt:formatNumber type = "number"
                                                                              maxFractionDigits = "0" value = "${sanPhamChiTiet.giaTriGiam}" /> vnđ
                                                        </b>
                                                    </c:if>
                                                    <c:if test="${sanPhamChiTiet.giaTriGiam == 0 || sanPhamChiTiet.giaTriGiam ==null }">
                                                        <b style="color: red;" style="margin-top: 100px;">
                                                            <fmt:formatNumber type = "number"
                                                                              maxFractionDigits = "0" value = "${sanPhamChiTiet.giaTriSanPham}" /> vnđ
                                                        </b>
                                                    </c:if>

                                                </div><!-- End .product-price -->

                                                <div class="ratings-container">

                                                </div><!-- End .rating-container -->

                                                <div class="product-nav product-nav-thumbs">
                                                    <a href="/giay/view-chiTietSanPham/${sanPhamChiTiet.id}" class="active">
                                                        <img src="${sanPhamChiTiet.hinhAnh}" alt="product desc">
                                                    </a>
                                                    <!-- <a href="#">
                                                        <img src="/user/assets/imagesgiay/giay11-2.jpg" alt="product desc">
                                                    </a>

                                                    <a href="#">
                                                        <img src="/user/assets/images/products/product-4-3-thumb.jpg" alt="product desc">
                                                    </a> -->
                                                </div>
                                            </div><!-- End .product-body -->
                                        </div><!-- End .product -->
                                    </div><!-- End .col-sm-6 col-lg-4 col-xl-3 -->
                                </c:if>
                                <%--                                        </c:forEach>--%>
                            </c:forEach>

                        </div><!-- End .row -->
                    </div><!-- End .products -->

                    <%--                        </div><!-- .End .tab-pane -->--%>

                </div><!-- End .tab-content -->

            </div><!-- End .container -->

            <div class="mb-5"></div><!-- End .mb-6 -->


            <div class="container">
                <hr>
                <div class="row justify-content-center">
                    <div class="col-lg-4 col-sm-6">
                        <div class="icon-box icon-box-card text-center">
                            <span class="icon-box-icon">
                                <i class="icon-rocket"></i>
                            </span>
                            <div class="icon-box-content">
                                <h3 class="icon-box-title">Thanh toán & Giao hàng</h3><!-- End .icon-box-title -->
                                <p>Giao hàng miễn phí cho đơn hàng trên 1 triệu</p>
                            </div><!-- End .icon-box-content -->
                        </div><!-- End .icon-box -->
                    </div><!-- End .col-lg-4 col-sm-6 -->

                    <div class="col-lg-4 col-sm-6">
                        <div class="icon-box icon-box-card text-center">
                            <span class="icon-box-icon">
                                <i class="icon-rotate-left"></i>
                            </span>
                            <div class="icon-box-content">
                                <h3 class="icon-box-title">Trả hàng & Hoàn tiền</h3><!-- End .icon-box-title -->
                                <p>Đảm bảo hoàn tiền 100% miễn phí</p>
                            </div><!-- End .icon-box-content -->
                        </div><!-- End .icon-box -->
                    </div><!-- End .col-lg-4 col-sm-6 -->

                    <div class="col-lg-4 col-sm-6">
                        <div class="icon-box icon-box-card text-center">
                            <span class="icon-box-icon">
                                <i class="icon-life-ring"></i>
                            </span>
                            <div class="icon-box-content">
                                <h3 class="icon-box-title">Hỗ trợ khách hàng</h3><!-- End .icon-box-title -->
                                <p>Luôn phản hồi trực tuyến 24/7</p>
                            </div><!-- End .icon-box-content -->
                        </div><!-- End .icon-box -->
                    </div><!-- End .col-lg-4 col-sm-6 -->
                </div><!-- End .row -->

                <div class="mb-2"></div><!-- End .mb-2 -->
            </div><!-- End .container -->


        </main><!-- End .main -->

        <footer class="footer">
            <div class="footer-middle">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6 col-lg-4 " style="justify-content: center;">
                            <div class="widget widget-about">
                                <img src="/user/assets/images/logo-black.png" class="footer-logo" alt="Footer Logo"
                                     width="100" height="25" style="margin-left: 45px;">
                                <p>
                                    Chúng tôi mong rằng bạn sẽ có trải nghiệm mua hàng tiện lợi, tiết kiệm thời gian.
                                    Chúc bạn mua sắm vui vẻ ^^
                                </p>
                                <div class="social-icons">
                                    <a href="#" class="social-icon" target="_blank" title="Facebook"><i
                                            class="icon-facebook-f"></i></a>
                                    <a href="#" class="social-icon" target="_blank" title="Twitter"><i
                                            class="icon-twitter"></i></a>
                                    <a href="#" class="social-icon" target="_blank" title="Instagram"><i
                                            class="icon-instagram"></i></a>
                                    <a href="#" class="social-icon" target="_blank" title="Youtube"><i
                                            class="icon-youtube"></i></a>
                                    <a href="#" class="social-icon" target="_blank" title="Pinterest"><i
                                            class="icon-pinterest"></i></a>
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
                    <p class="footer-copyright">Edit © 2024 Nice Sport. Design by team SD-09.</p>
                    <!-- End .footer-copyright -->
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
                <input type="search" class="form-control" name="mobile-search" id="mobile-search"
                       placeholder="Search in..." required>
                <button class="btn btn-primary" type="submit"><i class="icon-search"></i></button>
            </form>

            <nav class="mobile-nav">
                <ul class="mobile-menu">
                    <li class="active">
                        <a href="index.html">Home</a>

                        <ul>

                            <li><a href="index-2.html">02 - furniture store</a></li>

                        </ul>
                    </li>
                    <li>
                        <a href="category.html">Shop</a>
                        <ul>
                            <li><a href="category-list.html">Shop List</a></li>
                            <li><a href="category-2cols.html">Shop Grid 2 Columns</a></li>
                            <li><a href="category.html">Shop Grid 3 Columns</a></li>
                            <li><a href="category-4cols.html">Shop Grid 4 Columns</a></li>
                            <li><a href="category-boxed.html"><span>Shop Boxed No Sidebar<span
                                    class="tip tip-hot">Hot</span></span></a></li>
                            <li><a href="category-fullwidth.html">Shop Fullwidth No Sidebar</a></li>
                            <li><a href="product-category-boxed.html">Product Category Boxed</a></li>
                            <li><a href="product-category-fullwidth.html"><span>Product Category Fullwidth<span
                                    class="tip tip-new">New</span></span></a></li>
                            <li><a href="cart.html">Cart</a></li>
                            <li><a href="checkout.html">Checkout</a></li>
                            <li><a href="wishlist.html">Wishlist</a></li>
                            <li><a href="#">Lookbook</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="product.html" class="sf-with-ul">Product</a>
                        <ul>
                            <li><a href="product.html">Default</a></li>
                            <li><a href="product-centered.html">Centered</a></li>
                            <li><a href="product-extended.html"><span>Extended Info<span
                                    class="tip tip-new">New</span></span></a></li>
                            <li><a href="product-gallery.html">Gallery</a></li>
                            <li><a href="product-sticky.html">Sticky Info</a></li>
                            <li><a href="product-sidebar.html">Boxed With Sidebar</a></li>
                            <li><a href="product-fullwidth.html">Full Width</a></li>
                            <li><a href="product-masonry.html">Masonry Sticky Info</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">Pages</a>
                        <ul>
                            <li>
                                <a href="about.html">About</a>

                                <ul>
                                    <li><a href="about.html">About 01</a></li>
                                    <li><a href="about-2.html">About 02</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="contact.html">Contact</a>

                                <ul>
                                    <li><a href="contact.html">Contact 01</a></li>
                                    <li><a href="contact-2.html">Contact 02</a></li>
                                </ul>
                            </li>
                            <li><a href="login.html">Login</a></li>
                            <li><a href="faq.html">FAQs</a></li>
                            <li><a href="404.html">Error 404</a></li>
                            <li><a href="coming-soon.html">Coming Soon</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="blog.html">Blog</a>

                        <ul>
                            <li><a href="blog.html">Classic</a></li>
                            <li><a href="blog-listing.html">Listing</a></li>
                            <li>
                                <a href="#">Grid</a>
                                <ul>
                                    <li><a href="blog-grid-2cols.html">Grid 2 columns</a></li>
                                    <li><a href="blog-grid-3cols.html">Grid 3 columns</a></li>
                                    <li><a href="blog-grid-4cols.html">Grid 4 columns</a></li>
                                    <li><a href="blog-grid-sidebar.html">Grid sidebar</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">Masonry</a>
                                <ul>
                                    <li><a href="blog-masonry-2cols.html">Masonry 2 columns</a></li>
                                    <li><a href="blog-masonry-3cols.html">Masonry 3 columns</a></li>
                                    <li><a href="blog-masonry-4cols.html">Masonry 4 columns</a></li>
                                    <li><a href="blog-masonry-sidebar.html">Masonry sidebar</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">Mask</a>
                                <ul>
                                    <li><a href="blog-mask-grid.html">Blog mask grid</a></li>
                                    <li><a href="blog-mask-masonry.html">Blog mask masonry</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">Single Post</a>
                                <ul>
                                    <li><a href="single.html">Default with sidebar</a></li>
                                    <li><a href="single-fullwidth.html">Fullwidth no sidebar</a></li>
                                    <li><a href="single-fullwidth-sidebar.html">Fullwidth with sidebar</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="elements-list.html">Elements</a>
                        <ul>
                            <li><a href="elements-products.html">Products</a></li>
                            <li><a href="elements-typography.html">Typography</a></li>
                            <li><a href="elements-titles.html">Titles</a></li>
                            <li><a href="elements-banners.html">Banners</a></li>
                            <li><a href="elements-product-category.html">Product Category</a></li>
                            <li><a href="elements-video-banners.html">Video Banners</a></li>
                            <li><a href="elements-buttons.html">Buttons</a></li>
                            <li><a href="elements-accordions.html">Accordions</a></li>
                            <li><a href="elements-tabs.html">Tabs</a></li>
                            <li><a href="elements-testimonials.html">Testimonials</a></li>
                            <li><a href="elements-blog-posts.html">Blog Posts</a></li>
                            <li><a href="elements-portfolio.html">Portfolio</a></li>
                            <li><a href="elements-cta.html">Call to Action</a></li>
                            <li><a href="elements-icon-boxes.html">Icon Boxes</a></li>
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
                                    <a class="nav-link active" id="signin-tab" data-toggle="tab" href="#signin"
                                       role="tab" aria-controls="signin" aria-selected="true">Sign In</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="register-tab" data-toggle="tab" href="#register" role="tab"
                                       aria-controls="register" aria-selected="false">Register</a>
                                </li>
                            </ul>
                            <div class="tab-content" id="tab-content-5">
                                <div class="tab-pane fade show active" id="signin" role="tabpanel"
                                     aria-labelledby="signin-tab">
                                    <form action="#">
                                        <div class="form-group">
                                            <label for="singin-email">Username or email address *</label>
                                            <input type="text" class="form-control" id="singin-email"
                                                   name="singin-email" required>
                                        </div><!-- End .form-group -->

                                        <div class="form-group">
                                            <label for="singin-password">Password *</label>
                                            <input type="password" class="form-control" id="singin-password"
                                                   name="singin-password" required>
                                        </div><!-- End .form-group -->

                                        <div class="form-footer">
                                            <button type="submit" class="btn btn-outline-primary-2">
                                                <span>LOG IN</span>
                                                <i class="icon-long-arrow-right"></i>
                                            </button>

                                            <div class="custom-control custom-checkbox">
                                                <input type="checkbox" class="custom-control-input"
                                                       id="signin-remember">
                                                <label class="custom-control-label" for="signin-remember">Remember
                                                    Me</label>
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
                                            <input type="email" class="form-control" id="register-email"
                                                   name="register-email" required>
                                        </div><!-- End .form-group -->

                                        <div class="form-group">
                                            <label for="register-password">Password *</label>
                                            <input type="password" class="form-control" id="register-password"
                                                   name="register-password" required>
                                        </div><!-- End .form-group -->

                                        <div class="form-footer">
                                            <button type="submit" class="btn btn-outline-primary-2">
                                                <span>SIGN UP</span>
                                                <i class="icon-long-arrow-right"></i>
                                            </button>

                                            <div class="custom-control custom-checkbox">
                                                <input type="checkbox" class="custom-control-input" id="register-policy"
                                                       required>
                                                <label class="custom-control-label" for="register-policy">I agree to the
                                                    <a href="#">privacy policy</a> *</label>
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

    <input type="number" id="totalAllProduct_InCart" hidden>

</div>
</div>
<!-- Plugins JS File -->
<script src="/user/assets/js/jquery.min.js"></script>
<script src="/user/assets/js/bootstrap.bundle.min.js"></script>
<script src="/user/assets/js/jquery.hoverIntent.min.js"></script>
<script src="/user/assets/js/jquery.waypoints.min.js"></script>
<script src="/user/assets/js/superfish.min.js"></script>
<script src="/user/assets/js/owl.carousel.min.js"></script>
<script src="/user/assets/js/jquery.magnific-popup.min.js"></script>
<!-- Main JS File -->
<script src="/user/assets/js/main.js"></script>
</body>

<script type="text/javascript">

    // document.addEventListener("DOMContentLoaded", function() {
    //     console.log("Đây là hàm khởi chạy");
    //     localStorage.removeItem("dsSanPhamDuocThemVaoGio");
    //
    //     // set luôn phần totalProductInCart
    //     // lấy ra idCart , lấy ra ds sản phẩm được thêm vào local
    //     // set tổng số lượng danh sách trong local vào idCart thông qua hàm set giá trị
    //     // lấy ra danh sach sản phẩm được chọn vào giỏ - ở localstore
    //     var dsSanPhamTrongGioJSON = localStorage.getItem("dsSanPhamDuocThemVaoGio");
    //     console.log("Danh sách sản phẩm giỏ trong - local : " + dsSanPhamTrongGioJSON);
    //
    //     var dsSanPhamTrongGioCurrent;
    //     if (dsSanPhamTrongGioJSON) {
    //         // Chuyển đổi kiểu dữ liệu của danh sách JSON => array
    //         dsSanPhamTrongGioCurrent = JSON.parse(dsSanPhamTrongGioJSON);
    //         // var innerArray = dsSanPhamTrongGioCurrent[0];
    //         // console.log("Số lượng phần tử trong mảng con: " + innerArray.length);
    //         // var soLuongSPTrongGio = innerArray.length;
    //
    //         // Parse chuỗi JSON thành mảng JavaScript
    //         var parsedArray = JSON.parse(dsSanPhamTrongGioJSON);
    //
    //         // Lấy số lượng phần tử trong mảng
    //         var count = parsedArray.length;
    //
    //         console.log("Số lượng phần tử trong mảng là: " + count);
    //
    //         updateValueTongSoLuongSPTrongGioHang(count);
    //     } else {
    //         dsSanPhamTrongGioCurrent = [];
    //         updateValueTongSoLuongSPTrongGioHang(0);
    //     }
    //
    //     // console.log("ds san pham current : " + dsSanPhamTrongGioCurrent.length);
    //
    // });


    addToCart = function(idSanPhamCT, soLuong) {
        // console.log("Click vào function addToCart");

        // kiểm tra dữ liệu , lấy số lượng thêm + tổng số lượng sản phẩm trong giỏ ( có vượt quá 10 không ? )
        // tổng số lượng trong giỏ => chưa có cách nào lấy được


        var tongSoLuongSanPhamTrongGio = 0;

        layTongSoLuongSanPhamTrongGio()
            .then(function(totalAllProducts) {
                tongSoLuongSanPhamTrongGio = totalAllProducts;
                console.log("Gia tri cua tongSoLuongSanPhamTrongGio : " + tongSoLuongSanPhamTrongGio);

                if((tongSoLuongSanPhamTrongGio + soLuong)>10){
                    alert(" Giỏ hàng chỉ được thêm tối đa 10 sản phẩm! \n Số lượng sản phẩm bạn vừa nhập = " + soLuong + "\n\tVui lòng dọn giỏ hàng");
                    return;
                }else{
                    let data = {
                        idSanPhamCT: idSanPhamCT, //lay theo id
                        soLuongMuaThem: soLuong
                    };

                    //$ === jQuery
                    jQuery.ajax({
                        url : "/gio-hang/add-to-cart",
                        type : "POST",
                        contentType: "application/json",
                        data : JSON.stringify(data),
                        dataType : "json", //Kieu du lieu tra ve tu controller la json

                        success : function(jsonResult) {
                            let totalProducts = jsonResult.totalCartProducts;
                            let soLuongMuaVuotQua = jsonResult.soLuongMuaVuotQua;

                            $("#totalCartProductsId").html(totalProducts);

                            if(soLuongMuaVuotQua===true){
                                let soLuongTrongGio_cuaSanPhamHienTai = jsonResult.soLuongCuaSanPhamChon_trongGioDaThem;
                                alert("Số lượng sản phẩm trong kho không đủ \nBạn đã thêm: "+soLuongTrongGio_cuaSanPhamHienTai +" sản phẩm này vào giỏ hàng");
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


    muaNgay = function(idSanPhamCT, soLuong) {
        var soLuongMua = soLuong;

        layTongSoLuongSanPhamTrongGio()
            .then(function(totalAllProducts) {
                tongSoLuongSanPhamTrongGio = totalAllProducts;
                // console.log("Gia tri cua tongSoLuongSanPhamTrongGio : " + tongSoLuongSanPhamTrongGio);

                var checkSoLuongToiDa = parseInt(tongSoLuongSanPhamTrongGio) + parseInt(soLuongMua) ;

                if(checkSoLuongToiDa>10){
                    alert(" Giỏ hàng chỉ được thêm tối đa 10 sản phẩm! \n Số lượng sản phẩm bạn vừa nhập = " + soLuongMua + "\n\tVui lòng dọn giỏ hàng");
                    return;
                }else{
                    let data = {
                        idSanPhamCT: idSanPhamCT, //lay theo id
                        soLuong: soLuong
                    };

                    //$ === jQuery
                    jQuery.ajax({
                        url : "/gio-hang/mua-ngay",
                        type : "POST",
                        contentType: "application/json",
                        data : JSON.stringify(data),
                        dataType : "json", //Kieu du lieu tra ve tu controller la json

                        success : function(jsonResult) {
                            / alert(jsonResult.code + ": " + jsonResult.message); /
                            let totalProducts = jsonResult.totalCartProducts;
                            let totalPrice = jsonResult.totalPriceResult;
                            let soLuongMuaVuotQua = jsonResult.soLuongMuaVuotQua;
                            $("#totalCartProductsId").html(totalProducts);
                            // $("#totalPriceInCart").html(totalPrice);
                            if(soLuongMuaVuotQua===true){
                                alert("Số lượng trong kho không đủ, vui lòng chọn sản phẩm khác hoặc liên hệ với chúng tôi để đặt hàng sớm nhất.");
                            }else{
                                window.location.href = "/gio-hang/view-gio";
                                // window.location.reload();
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
                    let totalAllProducts = jsonResult.totalAllProducts;
                    $("#totalAllProduct_InCart").html(totalAllProducts);
                    console.log("Tổng số lượng sản phẩm trong giỏ : " + totalAllProducts);
                    // document.getElementById("totalAllProduct_InCart").value = totalAllProducts;

                    resolve(totalAllProducts); // Trả về giá trị totalAllProducts khi thành công
                },

                error: function(jqXhr, textStatus, errorMessage) {
                    reject(errorMessage); // Trả về lỗi khi gặp lỗi
                }
            });
        });
    }
</script>

<script>
    // function luuDuLieuVaoLocalstore(){
    //     // tạo ra 1 key lưu danh sách các đối tượng
    //     // Tạo một mảng rỗng
    //     var dsSanPhamDuocThemVaoGio = [];
    //
    //     // Chuyển đổi mảng thành chuỗi JSON
    //     var dsSanPhamDuocThemVaoGioJSON = JSON.stringify(emptyArray);
    //
    //     // tạo ra 1 key lưu trạng thái đăng nhập
    //     localStorage.setItem("isLogin",false);
    //     localStorage.setItem("tongSoLuongSPTrongGio",0);
    //     // lưu danh sách sản phẩm được thêm vào giỏ vào localstore
    //     localStorage.setItem("dsSanPhamDuocThemVaoGio", dsSanPhamDuocThemVaoGioJSON);
    //
    //
    //     // khi thêm sản phẩm vào giỏ
    //     // khi mua ngay
    //     // số lượng sản phẩm hiển thị trên giỏ
    //
    // }
    //
    // function updateValueTongSoLuongSPTrongGioHang(soLuongSanPhamTrongGio){
    //
    //     var soLuongSPTrongGio = soLuongSanPhamTrongGio;
    //
    //     document.getElementById("totalCartProductsId").innerText = soLuongSPTrongGio;
    //
    //     localStorage.setItem("tongSoLuongSPTrongGio",soLuongSPTrongGio);
    //
    //     console.log("Số lượng sp trong giỏ : " + soLuongSPTrongGio);
    // }


</script>
</html>