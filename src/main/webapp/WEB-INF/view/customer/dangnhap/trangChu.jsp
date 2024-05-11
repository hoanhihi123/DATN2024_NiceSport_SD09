<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
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
                                    <li><a href="tel:#"><i class="icon-phone"></i>Gọi điện: 0826 22 2003</a></li>
                                    <li><a href="about.html">Về chúng tôi</a></li>
                                    <li><p>Xin chào ${sessionScope.ten}</p></li>
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
                                <li class="megamenu-container active">
                                    <a href="index.html"><b>Trang chủ</b></a>
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
                            <a href="#" class="search-toggle" role="button" title="Search"><i
                                    class="icon-search"></i></a>
                            <form action="#" method="get">
                                <div class="header-search-wrapper">
                                    <label for="q" class="sr-only">Search</label>
                                    <input type="search" class="form-control" name="q" id="q" placeholder="Search in..."
                                           required>
                                </div><!-- End .header-search-wrapper -->
                            </form>
                        </div><!-- End .header-search -->

                        <div class="dropdown cart-dropdown">
                            <a href="#" class="dropdown-toggle" role="button" data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false" data-display="static">
                                <i class="icon-shopping-cart"></i>
                                <span class="cart-count">2</span>
                            </a>

                            <div class="dropdown-menu dropdown-menu-right">
                                <div class="dropdown-cart-products">



                                </div><!-- End .cart-product -->

                                <div class="dropdown-cart-total">
                                    <span>Thanh toán</span>

                                    <span class="cart-total-price">$160.00</span>
                                </div><!-- End .dropdown-cart-total -->

                                <div class="dropdown-cart-action">
                                    <a href="cart.html" class="btn btn-primary">View Cart</a>
                                    <a href="checkout.html" class="btn btn-outline-primary-2"><span>Checkout</span><i
                                            class="icon-long-arrow-right"></i></a>
                                </div><!-- End .dropdown-cart-total -->
                            </div><!-- End .dropdown-menu -->
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
                    <h2 class="title-lg">Giày nam bán chạy</h2><!-- End .title -->

                    <ul class="nav nav-pills justify-content-center" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="trendy-all-link" data-toggle="tab" href="#trendy-all-tab"
                               role="tab" aria-controls="trendy-all-tab" aria-selected="true">Sneaker</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="trendy-fur-link" data-toggle="tab" href="#trendy-fur-tab" role="tab"
                               aria-controls="trendy-fur-tab" aria-selected="false">Chạy bộ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="trendy-decor-link" data-toggle="tab" href="#trendy-decor-tab"
                               role="tab" aria-controls="trendy-decor-tab" aria-selected="false">Thể thao</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="trendy-light-link" data-toggle="tab" href="#trendy-light-tab"
                               role="tab" aria-controls="trendy-light-tab" aria-selected="false">Đá bóng</a>
                        </li>
                    </ul>
                </div><!-- End .heading -->

                <div class="tab-content tab-content-carousel">
                    <div class="tab-pane p-0 fade show active" id="trendy-all-tab" role="tabpanel"
                         aria-labelledby="trendy-all-link">
                        <div class="products mb-3">
                            <div class="row justify-content-center">
                                <div class="col-6 col-md-4 col-lg-4 col-xl-3">
                                    <div class="product product-7 text-center">
                                        <figure class="product-media">
                                            <span class="product-label label-new">New</span>
                                            <a href="product.html">
                                                <img src="/user/assets/imagesgiay/giay11.jpg" alt="Product image" class="product-image">
                                            </a>

                                            <div class="product-action-vertical">
                                                <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>
                                            </div><!-- End .product-action-vertical -->

                                            <div class="product-action">
                                                <a href="#" class="btn-product btn-cart"><span>Thêm vào giỏ</span></a>
                                                <a href="#" class="btn-product btn-cart"><span>Mua ngay nào</span></a>
                                            </div><!-- End .product-action -->
                                        </figure><!-- End .product-media -->

                                        <div class="product-body">
                                            <div class="product-cat">

                                            </div><!-- End .product-cat -->
                                            <h3 class="product-title"><a href="product.html">Giày Nike</a></h3><!-- End .product-title -->
                                            <div class="product-price">
                                                600.000 VNĐ
                                            </div><!-- End .product-price -->
                                            <div class="ratings-container">

                                            </div><!-- End .rating-container -->

                                            <div class="product-nav product-nav-thumbs">
                                                <a href="#" class="active">
                                                    <img src="/user/assets/imagesgiay/giay11.jpg" alt="product desc">
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

                                <div class="col-6 col-md-4 col-lg-4 col-xl-3">
                                    <div class="product product-7 text-center">
                                        <figure class="product-media">
                                            <span class="product-label label-new">New</span>
                                            <a href="product.html">
                                                <img src="/user/assets/imagesgiay/giay12.jpg" alt="Product image" class="product-image">
                                            </a>

                                            <div class="product-action-vertical">
                                                <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>
                                            </div><!-- End .product-action-vertical -->

                                            <div class="product-action">
                                                <a href="#" class="btn-product btn-cart"><span>Thêm vào giỏ</span></a>
                                                <a href="#" class="btn-product btn-cart"><span>Mua ngay nào</span></a>
                                            </div><!-- End .product-action -->
                                        </figure><!-- End .product-media -->

                                        <div class="product-body">
                                            <div class="product-cat">

                                            </div><!-- End .product-cat -->
                                            <h3 class="product-title"><a href="product.html">Giày Nike</a></h3><!-- End .product-title -->
                                            <div class="product-price">
                                                600.000 VNĐ
                                            </div><!-- End .product-price -->
                                            <div class="ratings-container">

                                            </div><!-- End .rating-container -->

                                            <div class="product-nav product-nav-thumbs">
                                                <a href="#" class="active">
                                                    <img src="/user/assets/imagesgiay/giay12.jpg" alt="product desc">
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

                                <div class="col-6 col-md-4 col-lg-4 col-xl-3">
                                    <div class="product product-7 text-center">
                                        <figure class="product-media">
                                            <span class="product-label label-new">New</span>
                                            <a href="product.html">
                                                <img src="/user/assets/imagesgiay/giay13.jpg" alt="Product image" class="product-image">
                                            </a>

                                            <div class="product-action-vertical">
                                                <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>
                                            </div><!-- End .product-action-vertical -->

                                            <div class="product-action">
                                                <a href="#" class="btn-product btn-cart"><span>Thêm vào giỏ</span></a>
                                                <a href="#" class="btn-product btn-cart"><span>Mua ngay nào</span></a>
                                            </div><!-- End .product-action -->
                                        </figure><!-- End .product-media -->

                                        <div class="product-body">
                                            <div class="product-cat">

                                            </div><!-- End .product-cat -->
                                            <h3 class="product-title"><a href="product.html">Giày Nike</a></h3><!-- End .product-title -->
                                            <div class="product-price">
                                                600.000 VNĐ
                                            </div><!-- End .product-price -->
                                            <div class="ratings-container">

                                            </div><!-- End .rating-container -->

                                            <div class="product-nav product-nav-thumbs">
                                                <a href="#" class="active">
                                                    <img src="/user/assets/imagesgiay/giay13.jpg" alt="product desc">
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

                                <div class="col-6 col-md-4 col-lg-4 col-xl-3">
                                    <div class="product product-7 text-center">
                                        <figure class="product-media">
                                            <span class="product-label label-new">New</span>
                                            <a href="product.html">
                                                <img src="/user/assets/imagesgiay/giay15.jpg" alt="Product image" class="product-image">
                                            </a>

                                            <div class="product-action-vertical">
                                                <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>
                                            </div><!-- End .product-action-vertical -->

                                            <div class="product-action">
                                                <a href="#" class="btn-product btn-cart"><span>Thêm vào giỏ</span></a>
                                                <a href="#" class="btn-product btn-cart"><span>Mua ngay nào</span></a>
                                            </div><!-- End .product-action -->
                                        </figure><!-- End .product-media -->

                                        <div class="product-body">
                                            <div class="product-cat">

                                            </div><!-- End .product-cat -->
                                            <h3 class="product-title"><a href="product.html">Giày Nike</a></h3><!-- End .product-title -->
                                            <div class="product-price">
                                                600.000 VNĐ
                                            </div><!-- End .product-price -->
                                            <div class="ratings-container">

                                            </div><!-- End .rating-container -->

                                            <div class="product-nav product-nav-thumbs">
                                                <a href="#" class="active">
                                                    <img src="/user/assets/imagesgiay/giay15.jpg" alt="product desc">
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

                                <div class="col-6 col-md-4 col-lg-4 col-xl-3">
                                    <div class="product product-7 text-center">
                                        <figure class="product-media">
                                            <span class="product-label label-new">New</span>
                                            <a href="product.html">
                                                <img src="/user/assets/imagesgiay/giay10.jpg" alt="Product image" class="product-image">
                                            </a>

                                            <div class="product-action-vertical">
                                                <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>
                                            </div><!-- End .product-action-vertical -->

                                            <div class="product-action">
                                                <a href="#" class="btn-product btn-cart"><span>Thêm vào giỏ</span></a>
                                                <a href="#" class="btn-product btn-cart"><span>Mua ngay nào</span></a>
                                            </div><!-- End .product-action -->
                                        </figure><!-- End .product-media -->

                                        <div class="product-body">
                                            <div class="product-cat">

                                            </div><!-- End .product-cat -->
                                            <h3 class="product-title"><a href="product.html">Giày Nike</a></h3><!-- End .product-title -->
                                            <div class="product-price">
                                                600.000 VNĐ
                                            </div><!-- End .product-price -->
                                            <div class="ratings-container">

                                            </div><!-- End .rating-container -->

                                            <div class="product-nav product-nav-thumbs">
                                                <a href="#" class="active">
                                                    <img src="/user/assets/imagesgiay/giay10.jpg" alt="product desc">
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

                                <div class="col-6 col-md-4 col-lg-4 col-xl-3">
                                    <div class="product product-7 text-center">
                                        <figure class="product-media">
                                            <span class="product-label label-new">New</span>
                                            <a href="product.html">
                                                <img src="/user/assets/imagesgiay/giay17.jpg" alt="Product image" class="product-image">
                                            </a>

                                            <div class="product-action-vertical">
                                                <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>
                                            </div><!-- End .product-action-vertical -->

                                            <div class="product-action">
                                                <a href="#" class="btn-product btn-cart"><span>Thêm vào giỏ</span></a>
                                                <a href="#" class="btn-product btn-cart"><span>Mua ngay nào</span></a>
                                            </div><!-- End .product-action -->
                                        </figure><!-- End .product-media -->

                                        <div class="product-body">
                                            <div class="product-cat">

                                            </div><!-- End .product-cat -->
                                            <h3 class="product-title"><a href="product.html">Giày Nike</a></h3><!-- End .product-title -->
                                            <div class="product-price">
                                                600.000 VNĐ
                                            </div><!-- End .product-price -->
                                            <div class="ratings-container">

                                            </div><!-- End .rating-container -->

                                            <div class="product-nav product-nav-thumbs">
                                                <a href="#" class="active">
                                                    <img src="/user/assets/imagesgiay/giay17.jpg" alt="product desc">
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

                                <div class="col-6 col-md-4 col-lg-4 col-xl-3">
                                    <div class="product product-7 text-center">
                                        <figure class="product-media">
                                            <span class="product-label label-new">New</span>
                                            <a href="product.html">
                                                <img src="/user/assets/imagesgiay/giay18.jpg" alt="Product image" class="product-image">
                                            </a>

                                            <div class="product-action-vertical">
                                                <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>
                                            </div><!-- End .product-action-vertical -->

                                            <div class="product-action">
                                                <a href="#" class="btn-product btn-cart"><span>Thêm vào giỏ</span></a>
                                                <a href="#" class="btn-product btn-cart"><span>Mua ngay nào</span></a>
                                            </div><!-- End .product-action -->
                                        </figure><!-- End .product-media -->

                                        <div class="product-body">
                                            <div class="product-cat">

                                            </div><!-- End .product-cat -->
                                            <h3 class="product-title"><a href="product.html">Giày Nike</a></h3><!-- End .product-title -->
                                            <div class="product-price">
                                                600.000 VNĐ
                                            </div><!-- End .product-price -->
                                            <div class="ratings-container">

                                            </div><!-- End .rating-container -->

                                            <div class="product-nav product-nav-thumbs">
                                                <a href="#" class="active">
                                                    <img src="/user/assets/imagesgiay/giay18.jpg" alt="product desc">
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

                                <div class="col-6 col-md-4 col-lg-4 col-xl-3">
                                    <div class="product product-7 text-center">
                                        <figure class="product-media">
                                            <span class="product-label label-new">New</span>
                                            <a href="product.html">
                                                <img src="/user/assets/imagesgiay/giay19.jpg" alt="Product image" class="product-image">
                                            </a>

                                            <div class="product-action-vertical">
                                                <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>
                                            </div><!-- End .product-action-vertical -->

                                            <div class="product-action">
                                                <a href="#" class="btn-product btn-cart"><span>Thêm vào giỏ</span></a>
                                                <a href="#" class="btn-product btn-cart"><span>Mua ngay nào</span></a>
                                            </div><!-- End .product-action -->
                                        </figure><!-- End .product-media -->

                                        <div class="product-body">
                                            <div class="product-cat">

                                            </div><!-- End .product-cat -->
                                            <h3 class="product-title"><a href="product.html">Giày Nike</a></h3><!-- End .product-title -->
                                            <div class="product-price">
                                                600.000 VNĐ
                                            </div><!-- End .product-price -->
                                            <div class="ratings-container">

                                            </div><!-- End .rating-container -->

                                            <div class="product-nav product-nav-thumbs">
                                                <a href="#" class="active">
                                                    <img src="/user/assets/imagesgiay/giay19.jpg" alt="product desc">
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








                            </div><!-- End .row -->
                        </div><!-- End .products -->

                    </div><!-- .End .tab-pane -->
                    <div class="tab-pane p-0 fade" id="trendy-fur-tab" role="tabpanel"
                         aria-labelledby="trendy-fur-link">
                        <div class="owl-carousel owl-simple carousel-equal-height carousel-with-shadow"
                             data-toggle="owl" data-owl-options='{
                                "nav": false,
                                "dots": true,
                                "margin": 20,
                                "loop": false,
                                "responsive": {
                                    "0": {
                                        "items":2
                                    },
                                    "480": {
                                        "items":2
                                    },
                                    "768": {
                                        "items":3
                                    },
                                    "992": {
                                        "items":4
                                    },
                                    "1200": {
                                        "items":4,
                                        "nav": true,
                                        "dots": false
                                    }
                                }
                            }'>
                            <div class="product product-7 text-center">
                                <figure class="product-media">
                                    <span class="product-label label-new">New</span>
                                    <a href="product.html">
                                        <img src="/user/assets/imagesgiay/giay12.jpg" alt="Product image" class="product-image">
                                    </a>

                                    <div class="product-action-vertical">
                                        <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>
                                    </div><!-- End .product-action-vertical -->

                                    <div class="product-action">
                                        <a href="#" class="btn-product btn-cart"><span>Thêm vào giỏ</span></a>
                                        <a href="#" class="btn-product btn-cart"><span>Mua ngay nào</span></a>
                                    </div><!-- End .product-action -->
                                </figure><!-- End .product-media -->

                                <div class="product-body">
                                    <div class="product-cat">

                                    </div><!-- End .product-cat -->
                                    <h3 class="product-title"><a href="product.html">Giày Nike</a></h3><!-- End .product-title -->
                                    <div class="product-price">
                                        600.000 VNĐ
                                    </div><!-- End .product-price -->
                                    <div class="ratings-container">

                                    </div><!-- End .rating-container -->

                                    <div class="product-nav product-nav-thumbs">
                                        <a href="#" class="active">
                                            <img src="/user/assets/imagesgiay/giay12.jpg" alt="product desc">
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

                            <div class="product product-7 text-center">
                                <figure class="product-media">
                                    <span class="product-label label-new">New</span>
                                    <a href="product.html">
                                        <img src="/user/assets/imagesgiay/giay12.jpg" alt="Product image" class="product-image">
                                    </a>

                                    <div class="product-action-vertical">
                                        <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>
                                    </div><!-- End .product-action-vertical -->

                                    <div class="product-action">
                                        <a href="#" class="btn-product btn-cart"><span>Thêm vào giỏ</span></a>
                                        <a href="#" class="btn-product btn-cart"><span>Mua ngay nào</span></a>
                                    </div><!-- End .product-action -->
                                </figure><!-- End .product-media -->

                                <div class="product-body">
                                    <div class="product-cat">

                                    </div><!-- End .product-cat -->
                                    <h3 class="product-title"><a href="product.html">Giày Nike</a></h3><!-- End .product-title -->
                                    <div class="product-price">
                                        600.000 VNĐ
                                    </div><!-- End .product-price -->
                                    <div class="ratings-container">

                                    </div><!-- End .rating-container -->

                                    <div class="product-nav product-nav-thumbs">
                                        <a href="#" class="active">
                                            <img src="/user/assets/imagesgiay/giay12.jpg" alt="product desc">
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
                        </div><!-- End .owl-carousel -->
                    </div><!-- .End .tab-pane -->
                    <div class="tab-pane p-0 fade" id="trendy-decor-tab" role="tabpanel"
                         aria-labelledby="trendy-decor-link">
                        <div class="owl-carousel owl-simple carousel-equal-height carousel-with-shadow"
                             data-toggle="owl" data-owl-options='{
                                "nav": false,
                                "dots": true,
                                "margin": 20,
                                "loop": false,
                                "responsive": {
                                    "0": {
                                        "items":2
                                    },
                                    "480": {
                                        "items":2
                                    },
                                    "768": {
                                        "items":3
                                    },
                                    "992": {
                                        "items":4
                                    },
                                    "1200": {
                                        "items":4,
                                        "nav": true,
                                        "dots": false
                                    }
                                }
                            }'>
                            <div class="product product-7 text-center">
                                <figure class="product-media">
                                    <span class="product-label label-new">New</span>
                                    <a href="product.html">
                                        <img src="/user/assets/imagesgiay/giay12.jpg" alt="Product image" class="product-image">
                                    </a>

                                    <div class="product-action-vertical">
                                        <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>
                                    </div><!-- End .product-action-vertical -->

                                    <div class="product-action">
                                        <a href="#" class="btn-product btn-cart"><span>Thêm vào giỏ</span></a>
                                        <a href="#" class="btn-product btn-cart"><span>Mua ngay nào</span></a>
                                    </div><!-- End .product-action -->
                                </figure><!-- End .product-media -->

                                <div class="product-body">
                                    <div class="product-cat">

                                    </div><!-- End .product-cat -->
                                    <h3 class="product-title"><a href="product.html">Giày Nike</a></h3><!-- End .product-title -->
                                    <div class="product-price">
                                        600.000 VNĐ
                                    </div><!-- End .product-price -->
                                    <div class="ratings-container">

                                    </div><!-- End .rating-container -->

                                    <div class="product-nav product-nav-thumbs">
                                        <a href="#" class="active">
                                            <img src="/user/assets/imagesgiay/giay12.jpg" alt="product desc">
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
                            <div class="product product-7 text-center">
                                <figure class="product-media">
                                    <span class="product-label label-new">New</span>
                                    <a href="product.html">
                                        <img src="/user/assets/imagesgiay/giay12.jpg" alt="Product image" class="product-image">
                                    </a>

                                    <div class="product-action-vertical">
                                        <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>
                                    </div><!-- End .product-action-vertical -->

                                    <div class="product-action">
                                        <a href="#" class="btn-product btn-cart"><span>Thêm vào giỏ</span></a>
                                        <a href="#" class="btn-product btn-cart"><span>Mua ngay nào</span></a>
                                    </div><!-- End .product-action -->
                                </figure><!-- End .product-media -->

                                <div class="product-body">
                                    <div class="product-cat">

                                    </div><!-- End .product-cat -->
                                    <h3 class="product-title"><a href="product.html">Giày Nike</a></h3><!-- End .product-title -->
                                    <div class="product-price">
                                        600.000 VNĐ
                                    </div><!-- End .product-price -->
                                    <div class="ratings-container">

                                    </div><!-- End .rating-container -->

                                    <div class="product-nav product-nav-thumbs">
                                        <a href="#" class="active">
                                            <img src="/user/assets/imagesgiay/giay12.jpg" alt="product desc">
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
                        </div><!-- End .owl-carousel -->
                    </div><!-- .End .tab-pane -->

                    <div class="tab-pane p-0 fade" id="trendy-light-tab" role="tabpanel"
                         aria-labelledby="trendy-light-link">
                        <div class="owl-carousel owl-simple carousel-equal-height carousel-with-shadow"
                             data-toggle="owl" data-owl-options='{
                                "nav": false,
                                "dots": true,
                                "margin": 20,
                                "loop": false,
                                "responsive": {
                                    "0": {
                                        "items":2
                                    },
                                    "480": {
                                        "items":2
                                    },
                                    "768": {
                                        "items":3
                                    },
                                    "992": {
                                        "items":4
                                    },
                                    "1200": {
                                        "items":4,
                                        "nav": true,
                                        "dots": false
                                    }
                                }
                            }'>
                            <div class="product product-7 text-center">
                                <figure class="product-media">
                                    <span class="product-label label-new">New</span>
                                    <a href="product.html">
                                        <img src="/user/assets/imagesgiay/giay12.jpg" alt="Product image" class="product-image">
                                    </a>

                                    <div class="product-action-vertical">
                                        <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>
                                    </div><!-- End .product-action-vertical -->

                                    <div class="product-action">
                                        <a href="#" class="btn-product btn-cart"><span>Thêm vào giỏ</span></a>
                                        <a href="#" class="btn-product btn-cart"><span>Mua ngay nào</span></a>
                                    </div><!-- End .product-action -->
                                </figure><!-- End .product-media -->

                                <div class="product-body">
                                    <div class="product-cat">

                                    </div><!-- End .product-cat -->
                                    <h3 class="product-title"><a href="product.html">Giày Nike</a></h3><!-- End .product-title -->
                                    <div class="product-price">
                                        600.000 VNĐ
                                    </div><!-- End .product-price -->
                                    <div class="ratings-container">

                                    </div><!-- End .rating-container -->

                                    <div class="product-nav product-nav-thumbs">
                                        <a href="#" class="active">
                                            <img src="/user/assets/imagesgiay/giay12.jpg" alt="product desc">
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
                            <div class="product product-7 text-center">
                                <figure class="product-media">
                                    <span class="product-label label-new">New</span>
                                    <a href="product.html">
                                        <img src="/user/assets/imagesgiay/giay12.jpg" alt="Product image" class="product-image">
                                    </a>

                                    <div class="product-action-vertical">
                                        <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>
                                    </div><!-- End .product-action-vertical -->

                                    <div class="product-action">
                                        <a href="#" class="btn-product btn-cart"><span>Thêm vào giỏ</span></a>
                                        <a href="#" class="btn-product btn-cart"><span>Mua ngay nào</span></a>
                                    </div><!-- End .product-action -->
                                </figure><!-- End .product-media -->

                                <div class="product-body">
                                    <div class="product-cat">

                                    </div><!-- End .product-cat -->
                                    <h3 class="product-title"><a href="product.html">Giày Nike</a></h3><!-- End .product-title -->
                                    <div class="product-price">
                                        600.000 VNĐ
                                    </div><!-- End .product-price -->
                                    <div class="ratings-container">

                                    </div><!-- End .rating-container -->

                                    <div class="product-nav product-nav-thumbs">
                                        <a href="#" class="active">
                                            <img src="/user/assets/imagesgiay/giay12.jpg" alt="product desc">
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
                        </div><!-- End .owl-carousel -->
                    </div><!-- .End .tab-pane -->
                </div><!-- End .tab-content -->

            </div><!-- End .container -->
            <div class="container">
                <div class="heading heading-center mb-3">
                    <h2 class="title-lg">Giày nữ bán chạy</h2><!-- End .title -->

                    <ul class="nav nav-pills justify-content-center" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="trendy-all-link" data-toggle="tab" href="#trendy-all-tab"
                               role="tab" aria-controls="trendy-all-tab" aria-selected="true">Sneaker</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="trendy-fur-link" data-toggle="tab" href="#trendy-fur-tab" role="tab"
                               aria-controls="trendy-fur-tab" aria-selected="false">Chạy bộ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="trendy-decor-link" data-toggle="tab" href="#trendy-decor-tab"
                               role="tab" aria-controls="trendy-decor-tab" aria-selected="false">Thể thao</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="trendy-light-link" data-toggle="tab" href="#trendy-light-tab"
                               role="tab" aria-controls="trendy-light-tab" aria-selected="false">Đá bóng</a>
                        </li>
                    </ul>
                </div><!-- End .heading -->

                <div class="tab-content tab-content-carousel">
                    <div class="tab-pane p-0 fade show active" id="trendy-all-tab" role="tabpanel"
                         aria-labelledby="trendy-all-link">
                        <div class="products mb-3">
                            <div class="row justify-content-center">
                                <div class="col-6 col-md-4 col-lg-4 col-xl-3">
                                    <div class="product product-7 text-center">
                                        <figure class="product-media">
                                            <span class="product-label label-new">New</span>
                                            <a href="product.html">
                                                <img src="/user/assets/imagesgiay/giay11.jpg" alt="Product image" class="product-image">
                                            </a>

                                            <div class="product-action-vertical">
                                                <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>
                                            </div><!-- End .product-action-vertical -->

                                            <div class="product-action">
                                                <a href="#" class="btn-product btn-cart"><span>Thêm vào giỏ</span></a>
                                                <a href="#" class="btn-product btn-cart"><span>Mua ngay nào</span></a>
                                            </div><!-- End .product-action -->
                                        </figure><!-- End .product-media -->

                                        <div class="product-body">
                                            <div class="product-cat">

                                            </div><!-- End .product-cat -->
                                            <h3 class="product-title"><a href="product.html">Giày Nike</a></h3><!-- End .product-title -->
                                            <div class="product-price">
                                                600.000 VNĐ
                                            </div><!-- End .product-price -->
                                            <div class="ratings-container">

                                            </div><!-- End .rating-container -->

                                            <div class="product-nav product-nav-thumbs">
                                                <a href="#" class="active">
                                                    <img src="/user/assets/imagesgiay/giay11.jpg" alt="product desc">
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

                                <div class="col-6 col-md-4 col-lg-4 col-xl-3">
                                    <div class="product product-7 text-center">
                                        <figure class="product-media">
                                            <span class="product-label label-new">New</span>
                                            <a href="product.html">
                                                <img src="/user/assets/imagesgiay/giay12.jpg" alt="Product image" class="product-image">
                                            </a>

                                            <div class="product-action-vertical">
                                                <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>
                                            </div><!-- End .product-action-vertical -->

                                            <div class="product-action">
                                                <a href="#" class="btn-product btn-cart"><span>Thêm vào giỏ</span></a>
                                                <a href="#" class="btn-product btn-cart"><span>Mua ngay nào</span></a>
                                            </div><!-- End .product-action -->
                                        </figure><!-- End .product-media -->

                                        <div class="product-body">
                                            <div class="product-cat">

                                            </div><!-- End .product-cat -->
                                            <h3 class="product-title"><a href="product.html">Giày Nike</a></h3><!-- End .product-title -->
                                            <div class="product-price">
                                                600.000 VNĐ
                                            </div><!-- End .product-price -->
                                            <div class="ratings-container">

                                            </div><!-- End .rating-container -->

                                            <div class="product-nav product-nav-thumbs">
                                                <a href="#" class="active">
                                                    <img src="/user/assets/imagesgiay/giay12.jpg" alt="product desc">
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

                                <div class="col-6 col-md-4 col-lg-4 col-xl-3">
                                    <div class="product product-7 text-center">
                                        <figure class="product-media">
                                            <span class="product-label label-new">New</span>
                                            <a href="product.html">
                                                <img src="/user/assets/imagesgiay/giay13.jpg" alt="Product image" class="product-image">
                                            </a>

                                            <div class="product-action-vertical">
                                                <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>
                                            </div><!-- End .product-action-vertical -->

                                            <div class="product-action">
                                                <a href="#" class="btn-product btn-cart"><span>Thêm vào giỏ</span></a>
                                                <a href="#" class="btn-product btn-cart"><span>Mua ngay nào</span></a>
                                            </div><!-- End .product-action -->
                                        </figure><!-- End .product-media -->

                                        <div class="product-body">
                                            <div class="product-cat">

                                            </div><!-- End .product-cat -->
                                            <h3 class="product-title"><a href="product.html">Giày Nike</a></h3><!-- End .product-title -->
                                            <div class="product-price">
                                                600.000 VNĐ
                                            </div><!-- End .product-price -->
                                            <div class="ratings-container">

                                            </div><!-- End .rating-container -->

                                            <div class="product-nav product-nav-thumbs">
                                                <a href="#" class="active">
                                                    <img src="/user/assets/imagesgiay/giay13.jpg" alt="product desc">
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

                                <div class="col-6 col-md-4 col-lg-4 col-xl-3">
                                    <div class="product product-7 text-center">
                                        <figure class="product-media">
                                            <span class="product-label label-new">New</span>
                                            <a href="product.html">
                                                <img src="/user/assets/imagesgiay/giay15.jpg" alt="Product image" class="product-image">
                                            </a>

                                            <div class="product-action-vertical">
                                                <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>
                                            </div><!-- End .product-action-vertical -->

                                            <div class="product-action">
                                                <a href="#" class="btn-product btn-cart"><span>Thêm vào giỏ</span></a>
                                                <a href="#" class="btn-product btn-cart"><span>Mua ngay nào</span></a>
                                            </div><!-- End .product-action -->
                                        </figure><!-- End .product-media -->

                                        <div class="product-body">
                                            <div class="product-cat">

                                            </div><!-- End .product-cat -->
                                            <h3 class="product-title"><a href="product.html">Giày Nike</a></h3><!-- End .product-title -->
                                            <div class="product-price">
                                                600.000 VNĐ
                                            </div><!-- End .product-price -->
                                            <div class="ratings-container">

                                            </div><!-- End .rating-container -->

                                            <div class="product-nav product-nav-thumbs">
                                                <a href="#" class="active">
                                                    <img src="/user/assets/imagesgiay/giay15.jpg" alt="product desc">
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

                                <div class="col-6 col-md-4 col-lg-4 col-xl-3">
                                    <div class="product product-7 text-center">
                                        <figure class="product-media">
                                            <span class="product-label label-new">New</span>
                                            <a href="product.html">
                                                <img src="/user/assets/imagesgiay/giay10.jpg" alt="Product image" class="product-image">
                                            </a>

                                            <div class="product-action-vertical">
                                                <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>
                                            </div><!-- End .product-action-vertical -->

                                            <div class="product-action">
                                                <a href="#" class="btn-product btn-cart"><span>Thêm vào giỏ</span></a>
                                                <a href="#" class="btn-product btn-cart"><span>Mua ngay nào</span></a>
                                            </div><!-- End .product-action -->
                                        </figure><!-- End .product-media -->

                                        <div class="product-body">
                                            <div class="product-cat">

                                            </div><!-- End .product-cat -->
                                            <h3 class="product-title"><a href="product.html">Giày Nike</a></h3><!-- End .product-title -->
                                            <div class="product-price">
                                                600.000 VNĐ
                                            </div><!-- End .product-price -->
                                            <div class="ratings-container">

                                            </div><!-- End .rating-container -->

                                            <div class="product-nav product-nav-thumbs">
                                                <a href="#" class="active">
                                                    <img src="/user/assets/imagesgiay/giay10.jpg" alt="product desc">
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

                                <div class="col-6 col-md-4 col-lg-4 col-xl-3">
                                    <div class="product product-7 text-center">
                                        <figure class="product-media">
                                            <span class="product-label label-new">New</span>
                                            <a href="product.html">
                                                <img src="/user/assets/imagesgiay/giay17.jpg" alt="Product image" class="product-image">
                                            </a>

                                            <div class="product-action-vertical">
                                                <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>
                                            </div><!-- End .product-action-vertical -->

                                            <div class="product-action">
                                                <a href="#" class="btn-product btn-cart"><span>Thêm vào giỏ</span></a>
                                                <a href="#" class="btn-product btn-cart"><span>Mua ngay nào</span></a>
                                            </div><!-- End .product-action -->
                                        </figure><!-- End .product-media -->

                                        <div class="product-body">
                                            <div class="product-cat">

                                            </div><!-- End .product-cat -->
                                            <h3 class="product-title"><a href="product.html">Giày Nike</a></h3><!-- End .product-title -->
                                            <div class="product-price">
                                                600.000 VNĐ
                                            </div><!-- End .product-price -->
                                            <div class="ratings-container">

                                            </div><!-- End .rating-container -->

                                            <div class="product-nav product-nav-thumbs">
                                                <a href="#" class="active">
                                                    <img src="/user/assets/imagesgiay/giay17.jpg" alt="product desc">
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

                                <div class="col-6 col-md-4 col-lg-4 col-xl-3">
                                    <div class="product product-7 text-center">
                                        <figure class="product-media">
                                            <span class="product-label label-new">New</span>
                                            <a href="product.html">
                                                <img src="/user/assets/imagesgiay/giay18.jpg" alt="Product image" class="product-image">
                                            </a>

                                            <div class="product-action-vertical">
                                                <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>
                                            </div><!-- End .product-action-vertical -->

                                            <div class="product-action">
                                                <a href="#" class="btn-product btn-cart"><span>Thêm vào giỏ</span></a>
                                                <a href="#" class="btn-product btn-cart"><span>Mua ngay nào</span></a>
                                            </div><!-- End .product-action -->
                                        </figure><!-- End .product-media -->

                                        <div class="product-body">
                                            <div class="product-cat">

                                            </div><!-- End .product-cat -->
                                            <h3 class="product-title"><a href="product.html">Giày Nike</a></h3><!-- End .product-title -->
                                            <div class="product-price">
                                                600.000 VNĐ
                                            </div><!-- End .product-price -->
                                            <div class="ratings-container">

                                            </div><!-- End .rating-container -->

                                            <div class="product-nav product-nav-thumbs">
                                                <a href="#" class="active">
                                                    <img src="/user/assets/imagesgiay/giay18.jpg" alt="product desc">
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

                                <div class="col-6 col-md-4 col-lg-4 col-xl-3">
                                    <div class="product product-7 text-center">
                                        <figure class="product-media">
                                            <span class="product-label label-new">New</span>
                                            <a href="product.html">
                                                <img src="/user/assets/imagesgiay/giay19.jpg" alt="Product image" class="product-image">
                                            </a>

                                            <div class="product-action-vertical">
                                                <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>
                                            </div><!-- End .product-action-vertical -->

                                            <div class="product-action">
                                                <a href="#" class="btn-product btn-cart"><span>Thêm vào giỏ</span></a>
                                                <a href="#" class="btn-product btn-cart"><span>Mua ngay nào</span></a>
                                            </div><!-- End .product-action -->
                                        </figure><!-- End .product-media -->

                                        <div class="product-body">
                                            <div class="product-cat">

                                            </div><!-- End .product-cat -->
                                            <h3 class="product-title"><a href="product.html">Giày Nike</a></h3><!-- End .product-title -->
                                            <div class="product-price">
                                                600.000 VNĐ
                                            </div><!-- End .product-price -->
                                            <div class="ratings-container">

                                            </div><!-- End .rating-container -->

                                            <div class="product-nav product-nav-thumbs">
                                                <a href="#" class="active">
                                                    <img src="/user/assets/imagesgiay/giay19.jpg" alt="product desc">
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








                            </div><!-- End .row -->
                        </div><!-- End .products -->

                    </div><!-- .End .tab-pane -->
                    <div class="tab-pane p-0 fade" id="trendy-fur-tab" role="tabpanel"
                         aria-labelledby="trendy-fur-link">
                        <div class="owl-carousel owl-simple carousel-equal-height carousel-with-shadow"
                             data-toggle="owl" data-owl-options='{
                                "nav": false,
                                "dots": true,
                                "margin": 20,
                                "loop": false,
                                "responsive": {
                                    "0": {
                                        "items":2
                                    },
                                    "480": {
                                        "items":2
                                    },
                                    "768": {
                                        "items":3
                                    },
                                    "992": {
                                        "items":4
                                    },
                                    "1200": {
                                        "items":4,
                                        "nav": true,
                                        "dots": false
                                    }
                                }
                            }'>
                            <div class="product product-11 text-center">
                                <figure class="product-media">
                                    <span class="product-label label-new">NEW</span>
                                    <a href="product.html">
                                        <img src="/user/assets/images/demos/demo-2/products/product-3-1.jpg"
                                             alt="Product image" class="product-image">
                                        <img src="/user/assets/images/demos/demo-2/products/product-3-2.jpg"
                                             alt="Product image" class="product-image-hover">
                                    </a>

                                    <div class="product-action-vertical">
                                        <a href="#" class="btn-product-icon btn-wishlist"><span>add to
                                                wishlist</span></a>
                                    </div><!-- End .product-action-vertical -->

                                </figure><!-- End .product-media -->

                                <div class="product-body">
                                    <h3 class="product-title"><a href="product.html">Flow Slim Armchair</a></h3>
                                    <!-- End .product-title -->
                                    <div class="product-price">
                                        $970,00
                                    </div><!-- End .product-price -->
                                </div><!-- End .product-body -->
                                <div class="product-action">
                                    <a href="#" class="btn-product btn-cart"><span>add to cart</span></a>
                                </div><!-- End .product-action -->
                            </div><!-- End .product -->

                            <div class="product product-7 text-center">
                                <figure class="product-media">
                                    <span class="product-label label-new">New</span>
                                    <a href="product.html">
                                        <img src="/user/assets/imagesgiay/giay11.jpg" alt="Product image" class="product-image">
                                    </a>

                                    <div class="product-action-vertical">
                                        <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>
                                    </div><!-- End .product-action-vertical -->

                                    <div class="product-action">
                                        <a href="#" class="btn-product btn-cart"><span>Thêm giỏ</span></a>
                                        <a href="#" class="btn-product btn-cart"><span>Mua ngay</span></a>
                                    </div><!-- End .product-action -->
                                </figure><!-- End .product-media -->

                                <div class="product-body">
                                    <div class="product-cat">

                                    </div><!-- End .product-cat -->
                                    <h3 class="product-title"><a href="product.html">Giày Nike</a></h3><!-- End .product-title -->
                                    <div class="product-price">
                                        600.000 VNĐ
                                    </div><!-- End .product-price -->
                                    <div class="ratings-container">

                                    </div><!-- End .rating-container -->

                                    <div class="product-nav product-nav-thumbs">
                                        <a href="#" class="active">
                                            <img src="/user/assets/imagesgiay/giay11.jpg" alt="product desc">
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
                        </div><!-- End .owl-carousel -->
                    </div><!-- .End .tab-pane -->
                    <div class="tab-pane p-0 fade" id="trendy-decor-tab" role="tabpanel"
                         aria-labelledby="trendy-decor-link">
                        <div class="owl-carousel owl-simple carousel-equal-height carousel-with-shadow"
                             data-toggle="owl" data-owl-options='{
                                "nav": false,
                                "dots": true,
                                "margin": 20,
                                "loop": false,
                                "responsive": {
                                    "0": {
                                        "items":2
                                    },
                                    "480": {
                                        "items":2
                                    },
                                    "768": {
                                        "items":3
                                    },
                                    "992": {
                                        "items":4
                                    },
                                    "1200": {
                                        "items":4,
                                        "nav": true,
                                        "dots": false
                                    }
                                }
                            }'>
                            <div class="product product-7 text-center">
                                <figure class="product-media">
                                    <span class="product-label label-new">New</span>
                                    <a href="product.html">
                                        <img src="/user/assets/imagesgiay/giay11.jpg" alt="Product image" class="product-image">
                                    </a>

                                    <div class="product-action-vertical">
                                        <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>
                                    </div><!-- End .product-action-vertical -->

                                    <div class="product-action">
                                        <a href="#" class="btn-product btn-cart"><span>Thêm giỏ</span></a>
                                        <a href="#" class="btn-product btn-cart"><span>Mua ngay</span></a>
                                    </div><!-- End .product-action -->
                                </figure><!-- End .product-media -->

                                <div class="product-body">
                                    <div class="product-cat">

                                    </div><!-- End .product-cat -->
                                    <h3 class="product-title"><a href="product.html">Giày Nike</a></h3><!-- End .product-title -->
                                    <div class="product-price">
                                        600.000 VNĐ
                                    </div><!-- End .product-price -->
                                    <div class="ratings-container">

                                    </div><!-- End .rating-container -->

                                    <div class="product-nav product-nav-thumbs">
                                        <a href="#" class="active">
                                            <img src="/user/assets/imagesgiay/giay11.jpg" alt="product desc">
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
                            <div class="product product-7 text-center">
                                <figure class="product-media">
                                    <span class="product-label label-new">New</span>
                                    <a href="product.html">
                                        <img src="/user/assets/imagesgiay/giay11.jpg" alt="Product image" class="product-image">
                                    </a>

                                    <div class="product-action-vertical">
                                        <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>
                                    </div><!-- End .product-action-vertical -->

                                    <div class="product-action">
                                        <a href="#" class="btn-product btn-cart"><span>Thêm giỏ</span></a>
                                        <a href="#" class="btn-product btn-cart"><span>Mua ngay</span></a>
                                    </div><!-- End .product-action -->
                                </figure><!-- End .product-media -->

                                <div class="product-body">
                                    <div class="product-cat">

                                    </div><!-- End .product-cat -->
                                    <h3 class="product-title"><a href="product.html">Giày Nike</a></h3><!-- End .product-title -->
                                    <div class="product-price">
                                        600.000 VNĐ
                                    </div><!-- End .product-price -->
                                    <div class="ratings-container">

                                    </div><!-- End .rating-container -->

                                    <div class="product-nav product-nav-thumbs">
                                        <a href="#" class="active">
                                            <img src="/user/assets/imagesgiay/giay11.jpg" alt="product desc">
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
                        </div><!-- End .owl-carousel -->
                    </div><!-- .End .tab-pane -->

                    <div class="tab-pane p-0 fade" id="trendy-light-tab" role="tabpanel"
                         aria-labelledby="trendy-light-link">
                        <div class="owl-carousel owl-simple carousel-equal-height carousel-with-shadow"
                             data-toggle="owl" data-owl-options='{
                                "nav": false,
                                "dots": true,
                                "margin": 20,
                                "loop": false,
                                "responsive": {
                                    "0": {
                                        "items":2
                                    },
                                    "480": {
                                        "items":2
                                    },
                                    "768": {
                                        "items":3
                                    },
                                    "992": {
                                        "items":4
                                    },
                                    "1200": {
                                        "items":4,
                                        "nav": true,
                                        "dots": false
                                    }
                                }
                            }'>
                            <div class="product product-7 text-center">
                                <figure class="product-media">
                                    <span class="product-label label-new">New</span>
                                    <a href="product.html">
                                        <img src="/user/assets/imagesgiay/giay11.jpg" alt="Product image" class="product-image">
                                    </a>

                                    <div class="product-action-vertical">
                                        <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>
                                    </div><!-- End .product-action-vertical -->

                                    <div class="product-action">
                                        <a href="#" class="btn-product btn-cart"><span>Thêm giỏ</span></a>
                                        <a href="#" class="btn-product btn-cart"><span>Mua ngay</span></a>
                                    </div><!-- End .product-action -->
                                </figure><!-- End .product-media -->

                                <div class="product-body">
                                    <div class="product-cat">

                                    </div><!-- End .product-cat -->
                                    <h3 class="product-title"><a href="product.html">Giày Nike</a></h3><!-- End .product-title -->
                                    <div class="product-price">
                                        600.000 VNĐ
                                    </div><!-- End .product-price -->
                                    <div class="ratings-container">

                                    </div><!-- End .rating-container -->

                                    <div class="product-nav product-nav-thumbs">
                                        <a href="#" class="active">
                                            <img src="/user/assets/imagesgiay/giay11.jpg" alt="product desc">
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
                            <div class="product product-7 text-center">
                                <figure class="product-media">
                                    <span class="product-label label-new">New</span>
                                    <a href="product.html">
                                        <img src="/user/assets/imagesgiay/giay11.jpg" alt="Product image" class="product-image">
                                    </a>

                                    <div class="product-action-vertical">
                                        <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>Thêm vào yêu thích</span></a>
                                    </div><!-- End .product-action-vertical -->

                                    <div class="product-action">
                                        <a href="#" class="btn-product btn-cart"><span>Thêm giỏ</span></a>
                                        <a href="#" class="btn-product btn-cart"><span>Mua ngay</span></a>
                                    </div><!-- End .product-action -->
                                </figure><!-- End .product-media -->

                                <div class="product-body">
                                    <div class="product-cat">

                                    </div><!-- End .product-cat -->
                                    <h3 class="product-title"><a href="product.html">Giày Nike</a></h3><!-- End .product-title -->
                                    <div class="product-price">
                                        600.000 VNĐ
                                    </div><!-- End .product-price -->
                                    <div class="ratings-container">

                                    </div><!-- End .rating-container -->

                                    <div class="product-nav product-nav-thumbs">
                                        <a href="#" class="active">
                                            <img src="/user/assets/imagesgiay/giay11.jpg" alt="product desc">
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
                        </div><!-- End .owl-carousel -->
                    </div><!-- .End .tab-pane -->
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

    <!-- <div class="container newsletter-popup-container mfp-hide" id="newsletter-popup-form">
         <div class="row justify-content-center">
            <div class="col-10">
                <div class="row no-gutters bg-white newsletter-popup-content">
                    <div class="col-xl-3-5col col-lg-7 banner-content-wrap">
                        <div class="banner-content text-center">
                            <img src="/user/assets/images/popup/newsletter/logo.png" class="logo" alt="logo" width="60"
                                height="15">
                            <h2 class="banner-title">get <span>25<light>%</light></span> off</h2>
                            <p>Subscribe to the Molla eCommerce newsletter to receive timely updates from your favorite
                                products.</p>
                            <form action="#">
                                <div class="input-group input-group-round">
                                    <input type="email" class="form-control form-control-white"
                                        placeholder="Your Email Address" aria-label="Email Adress" required>
                                    <div class="input-group-append">
                                        <button class="btn" type="submit"><span>go</span></button>
                                    </div>
                                </div>
                            </form>
                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="register-policy-2" required>
                                <label class="custom-control-label" for="register-policy-2">Do not show this popup
                                    again</label>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-2-5col col-lg-5 ">
                        <img src="/user/assets/images/popup/newsletter/img-1.jpg" class="newsletter-img" alt="newsletter">
                    </div>
                </div>
            </div>
        </div> -->
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


<!-- molla/index-2.html  22 Nov 2019 09:55:42 GMT -->

</html>