
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!doctype html>

<html class="no-js" lang="">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Quản lý hoá đơn</title>
    <meta name="description" content="Ela Admin - HTML5 Admin Template">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="https://i.imgur.com/QRAUqs9.png">
    <link rel="shortcut icon" href="https://i.imgur.com/QRAUqs9.png">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/normalize.css@8.0.0/normalize.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/pixeden-stroke-7-icon@1.2.3/pe-icon-7-stroke/dist/pe-icon-7-stroke.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.2.0/css/flag-icon.min.css">
    <link rel="stylesheet" href="/admin/assets/css/cs-skin-elastic.css">
    <link rel="stylesheet" href="/admin/assets/css/style.css">

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>

    <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->
    <style>
        .form-filter {
            padding: 0 20px;
        }

        .form-filter .form-group {
            padding: 0 !important;
        }

        .form-group label {
            min-width: 100px;
            justify-content: unset;
        }

        .form-group input, .form-group select {
            min-width: 200px;
        }

        .form-group.col-sm-5 label {
            width: 200px;
        }

        .form-group.col-sm-5 input, .form-group.col-sm-5 select {
            width: calc(100% - 230px);
        }

        td {
            text-align: center;
        }
    </style>
</head>
<body class="container-sm">


<!-- Left Panel -->
<aside id="left-panel" class="left-panel ">
    <nav class="navbar navbar-expand-sm navbar-default">
        <div id="main-menu" class="main-menu collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <%--                <li class="">--%>
                <%--                    <a href="dashboard_2.html">--%>
                <%--                        <i class="menu-icon fa fa-laptop"></i>Dashboard--%>
                <%--                    </a>--%>
                <%--                </li>--%>
                <li class="menu-title ">Quản lý hóa đơn</li>
                <!-- /.menu-title -->
                <%--                <li class="menu-item-has-children dropdown ">--%>
                <%--                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
                <%--                        <i class="menu-icon fa fa-cogs"></i>Quản lý thuộc tính--%>
                <%--                    </a>--%>
                <%--                    <ul class="sub-menu children dropdown-menu">--%>
                <%--                        <li>--%>
                <%--                            <i class="fa fa-puzzle-piece"></i>--%>
                <%--                            <a href="/san-pham/hien-thi">Sản phẩm</a>--%>
                <%--                        </li>--%>
                <%--                        <li>--%>
                <%--                            <i class="fa fa-gear"></i>--%>
                <%--                            <a href="/chat-lieu/hien-thi">Chất liệu</a>--%>
                <%--                        </li>--%>
                <%--                        <li>--%>
                <%--                            <i class="fa fa-eraser"></i>--%>
                <%--                            <a href="/mau-sac/hien-thi">Màu sắc</a>--%>
                <%--                        </li>--%>
                <%--                        <li>--%>
                <%--                            <i class="fa fa-id-badge"></i>--%>
                <%--                            <a href="/thuong-hieu/hien-thi">Thương hiệu</a>--%>
                <%--                        </li>--%>
                <%--                        <li>--%>
                <%--                            <i class="fa fa-arrows-h"></i>--%>
                <%--                            <a href="/kich-thuoc/hien-thi">Kích cỡ</a>--%>
                <%--                        </li>--%>
                <%--                        <li>--%>
                <%--                            <i class="fa fa-inbox"></i>--%>
                <%--                            <a href="/kieu-dang/hien-thi">Kiểu dáng</a>--%>
                <%--                        </li>--%>
                <%--                        <li>--%>
                <%--                            <i class="fa fa-suitcase"></i>--%>
                <%--                            <a href="/nha-sx/hien-thi">NSX</a>--%>
                <%--                        </li>--%>
                <%--                    </ul>--%>

                <%--                </li>--%>
                <li  class="active">
                    <a href="/hoa-don/hien-thi" aria-expanded="false">
                        <i class="menu-icon fa fa-print"></i>Quản lý hóa đơn
                    </a>
                <li>
                    <a href="/admin/quanLySanPham/hien-thi" aria-expanded="false" >
                        <i class="menu-icon fa fa-star"></i>Quản lý sản phẩm
                    </a>
                </li>

                </li>
                <%--                <li class="">--%>
                <%--                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
                <%--                        <i class="menu-icon fa fa-leaf"></i>Quản lý khuyến mãi--%>
                <%--                    </a>--%>
                <%--                </li>--%>
                <li class="menu-item-has-children dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-leaf" ></i>Quản lý khuyến mãi</a>
                    <ul class="sub-menu children dropdown-menu">
                        <li><i class="fa fa-puzzle-piece"></i><a href="/dot-khuyen-mai/hien-thi">Đợt khuyến mãi</a></li>
                        <li><i class="fa fa-id-badge"></i><a href="/phieu-giam-gia/hien-thi">Phiếu giảm giá</a></li>
                    </ul>
                </li>
                <li class="menu-item-has-children dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="menu-icon fa fa-puzzle-piece"></i>Quản lý thuộc tính
                    </a>
                    <ul class="sub-menu children dropdown-menu">
                        <li class="">
                            <a href="/thuong-hieu/hien-thi">
                                <i class="fa fa-id-badge"></i> Thương hiệu
                            </a>
                        </li>
                        <li class="">
                            <a href="/nha-sx/hien-thi">
                                <i class="fa fa-suitcase"></i> Nhà sản xuất
                            </a>
                        </li>
                        <li class="">
                            <a href="/danh-muc/hien-thi">
                                <i class="fa fa-building-o"></i> Danh mục
                            </a>
                        </li>
                        <li class="">
                            <a href="/loai-sp/hien-thi">
                                <i class="fa fa-sun-o"></i> Loại sản phẩm
                            </a>
                        </li>
                        <li class="">
                            <a href="/kieu-dang/hien-thi">
                                <i class="fa fa-inbox"></i> Kiểu dáng
                            </a>
                        </li>
                        <li class="">
                            <a href="/chat-lieu/hien-thi">
                                <i class="fa  fa-beer"></i> Chất liệu
                            </a>
                        </li>
                        <li class="">
                            <a href="/mui-giay/hien-thi">
                                <i class="fa fa-cog"></i> Mũi giày
                            </a>
                        </li>
                        <li class="">
                            <a href="/day-giay/hien-thi">
                                <i class="fa fa-bars"></i> Dây giày
                            </a>
                        </li>
                        <li class="">
                            <a href="/de-giay/hien-thi">
                                <i class="fa fa-sort-desc"></i> Đế giày
                            </a>
                        </li>
                        <li class="">
                            <a href="/lot-giay/hien-thi">
                                <i class="fa  fa-road "></i> Lót giày
                            </a>
                        </li>
                        <li class="">
                            <a href="/mau-sac/hien-thi">
                                <i class="fa fa-eraser"></i> Màu sắc
                            </a>
                        </li>
                        <li class="">
                            <a href="/kich-thuoc/hien-thi">
                                <i class="fa fa-arrows-h"></i> Size giày
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="menu-title ">Thống kê</li>
                <!-- /.menu-title -->
                <li >
                    <a href="/thong-ke" aria-expanded="false"> <i class="menu-icon fa fa-bar-chart-o"></i>Thống kê doanh thu</a>
                </li>
                <%--                <li class="menu-item-has-children dropdown">--%>
                <%--                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
                <%--                        <i class="menu-icon fa fa-bar-chart-o"></i>Thống kê doanh thu--%>
                <%--                    </a>--%>
                <%--                    <ul class="sub-menu children dropdown-menu">--%>
                <%--                        <li>--%>
                <%--                            <i class="fa fa-puzzle-piece"></i>--%>
                <%--                            <a href="ui-buttons.html">Hàng ngày</a>--%>
                <%--                        </li>--%>
                <%--                        <li>--%>
                <%--                            <i class="fa fa-id-badge"></i>--%>
                <%--                            <a href="ui-badges.html">Hàng tháng</a>--%>
                <%--                        </li>--%>
                <%--                        <li>--%>
                <%--                            <i class="fa fa-bars"></i>--%>
                <%--                            <a href="ui-tabs.html">Hàng năm</a>--%>
                <%--                        </li>--%>
                <%--                    </ul>--%>
                <%--                </li>--%>
                <li class="menu-title">Bán hàng</li>
                <!-- /.menu-title -->
                <li >
                    <a href="/ban-hang/view">
                        <i class="menu-icon fa fa-file-text-o"></i>Bán hàng tại quầy
                    </a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </nav>
</aside>

<!-- /#left-panel -->

<!-- Left Panel -->

<!-- Right Panel -->

<div id="right-panel" class="right-panel">

    <!-- Header-->
    <header id="header" class="header">
        <div class="top-left">
            <div class="navbar-header">
                <a class="navbar-brand" href="">
                    <img src="/admin/images/logo.png" alt="Logo">
                </a>
                <a class="navbar-brand hidden" href="">
                    <img src="/admin/images/logo2.png" alt="Logo">
                </a>
                <a id="menuToggle" class="menutoggle">
                    <i class="fa fa-bars"></i>
                </a>
            </div>
        </div>
        <div class="top-right">
            <div class="header-menu">
                <div class="header-left">
                    <div class="for-message" style="margin-top: 15px;">
                        <p>Tên người dùng</p>
                    </div>
                </div>

                <div class="user-area dropdown float-right">
                    <a href="#" class="dropdown-toggle active" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <img class="user-avatar rounded-circle" src="/admin/images/admin.jpg" alt="User Avatar">
                    </a>

                    <div class="user-menu dropdown-menu">
                        <a class="nav-link" href="#">
                            <i class="fa fa-user"></i>My Profile
                        </a>

                        <a class="nav-link" href="#">
                            <i class="fa fa-bell-o"></i>Notifications <span class="count">13</span>
                        </a>

                        <a class="nav-link" href="#">
                            <i class="fa fa-cog"></i>Settings
                        </a>

                        <a class="nav-link" href="#">
                            <i class="fa fa-power-off"></i>Logout
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- /header -->
    <!-- Header-->




    <div class="content">

        <div class="card col-lg-12">
            <div class="card-header">
                <div class="col-lg-10">
                    <strong class="card-title"><h2>Bộ lọc</h2></strong>
                    <hr>
                </div>
                <div class="row">
                    <form method="get" action="/hoa-don/hien-thi" class="form-inline form-filter">
                        <div class="col-sm-5 form-group mb-2">
                            <label for="keyword" class="mr-2">Tìm kiếm mã:</label>
                            <input type="search" name="keyword" id="keyword" class="form-control" placeholder="Tìm kiếm mã..." />
                        </div>
                        <div class="col-sm-3 form-group mr-4 mb-2">
                            <label for="start_date" class="mr-2">Từ ngày:</label>
                            <input type="date" name="start_date" id="start_date" class="form-control" />
                        </div>
                        <div class="col-sm-3 form-group mb-2">
                            <label for="end_date" class="mr-2">Đến ngày:</label>
                            <input type="date" name="end_date" id="end_date" class="form-control" />
                        </div>
                        <div class="col-sm-5 form-group mb-2">
                            <label for="payment_method" class="mr-2">Hình thức thanh toán:</label> <select name="payment_method" id="payment_method" class="form-control">
                            <option value="">-- Chọn hình thức --</option>
                            <option value="1">Tiền mặt</option>
                            <option value="2">Chuyển khoản ngân hàng</option>
                            <option value="3">Thanh toán khi nhận hàng</option>
                        </select>
                        </div>
                        <div class="col-sm-3 form-group mr-4 mb-2">
                            <label for="status" class="mr-2">Trạng thái:</label> <select name="status" id="status" class="form-control">
                            <option value="">-- Chọn trạng thái --</option>
                            <option value="1">Chờ xác nhận</option>
                            <option value="2">Chờ lấy hàng</option>
                            <option value="3">Đang giao</option>
                            <option value="4">Thành công</option>
                            <option value="5">Hủy</option>
                        </select>
                        </div>
                        <button type="submit" class="btn btn-primary mb-2">Tìm kiếm</button>
                    </form>

                </div>
            </div>
        </div>
    </div>
    <!-- .content -->

    <div class="content" style="margin-top: -50px;">
        <div class="animated fadeIn">

            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered table-hover no-wrap">
                        <thead>
                        <tr style="text-align: center;">
                            <th scope="col">Mã</th>
                            <th scope="col">Ngày mua</th>
                            <th scope="col">Tên khách hàng</th>
                            <th scope="col">Địa chỉ</th>
                            <th scope="col">Loại hóa đơn</th>
                            <th scope="col">Hình thức thanh toán</th>
                            <th scope="col">Tổng tiền</th>
                            <th scope="col">Trạng thái</th>
                            <th scope="col" colspan="2">Hành động</th>

                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${listHD.content}" var="hd">
                            <tr>
                                <td>${hd.ma}</td>
                                <td>${hd.ngayMua}</td>
                                <td>${hd.tenKH}</td>
                                <td>${hd.diaChi}</td>
                                <td>${hd.loaiHoaDon == "1" ? 'Tại quầy':'Online'}</td>
                                <td>${hd.loaiHoaDon == "1" ? "Tiền mặt" : (hd.hinhThucTT  == "3" ? 'Thanh toán khi nhận hàng' : 'Thanh toán chuyển khoản qua VNPay')}</td>
                                    <%--                                <td>${hd.tongTienThanhToan}</td>--%>
                                <td><fmt:formatNumber value="${hd.tongTienThanhToan}" pattern="#,##0"/></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${hd.trangThai == 1}">Chờ xác nhận</c:when>
                                        <c:when test="${hd.trangThai == 2}">Chờ lấy hàng</c:when>
                                        <c:when test="${hd.trangThai == 3}">Đang giao</c:when>
                                        <c:when test="${hd.trangThai == 4}">${hd.loaiHoaDon == "1" ? 'Đã thanh toán' : 'Đã giao hàng thành công'}</c:when>
                                        <c:when test="${hd.trangThai == 5}">Hủy</c:when>
                                        <c:otherwise>Đã giao hàng</c:otherwise>
                                    </c:choose>
                                </td>

                                <td>
                                    <a href="/hoa-donct/detail/${hd.id}" class="btn btn-success">
                                        <i class="menu-icon fa fa-pencil-square-o"></i>
                                    </a>
                                </td>


                            </tr>
                        </c:forEach>


                        </tbody>
                    </table>
                </div>

                <div class="row" style="margin-top: 20px;">
                    <div class="col-lg-4"></div>
                    <div class="col-lg-8 text-lg-end"> <!-- Thay thế text-align: right bằng lớp text-lg-end của Bootstrap 5 -->
                        <nav aria-label="Page navigation example">
                            <ul class="pagination">
                                <c:forEach begin="1" end="${listHD.totalPages}" varStatus="loop">
                                    <li class="page-item">
                                        <a class="page-link" href="/hoa-don/hien-thi?page=${loop.begin + loop.count -2}"> ${loop.begin + loop.count - 1} </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </nav>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <!-- .animated -->
</div>
<!-- .content -->


<div class="clearfix"></div>

<footer class="site-footer">
    <div class="footer-inner bg-white">
        <div class="row">
            <div class="col-sm-6">NiceStore 2024</div>
            <div class="col-sm-6 text-right">
                Designed by
                <a href="https://colorlib.com">Team SD-09</a>
            </div>
        </div>
    </div>
</footer>

</div>
<!-- /#right-panel -->

<!-- Right Panel -->

<!-- Scripts -->
<script src="https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
<script src="/admin/assets/js/main.js"></script>

<script>
    // Sử dụng JavaScript để đặt giá trị của trường ngày thành ngày hôm nay
    document.getElementById('dateToday').valueAsDate = new Date();
</script>

</body>
</html>