<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!doctype html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Sửa sản phẩm chi tiết </title>
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

    <%--    thư viện dùng select picker multiple  --%>
    <%--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>--%>
    <%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">--%>
    <%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.8.1/css/bootstrap-select.css">--%>
    <%--    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.8.1/js/bootstrap-select.js"></script>--%>
    <%--    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>--%>
    <%--    thư viện dùng select picker multiple  --%>

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    <%-- import axios     --%>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>



    <%--    Khai bao thu vien jquery--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


    <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->
    <style>
        .messageError{
            color: red;
        }
    </style>
</head>
<body>
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
                <li class="menu-title">Quản lý hóa đơn</li>
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
                <li>
                    <a href="/hoa-don/hien-thi" aria-expanded="false">
                        <i class="menu-icon fa fa-print"></i>Quản lý hóa đơn
                    </a>
                <li class="active">
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

<!-- /Left Panel -->

<!-- Right Panel -->

<div id="right-panel" class="right-panel">
    <!-- Header-->
    <jsp:include page="/WEB-INF/view/admin/layout/header_admin.jsp"></jsp:include>
    <!-- Header-->

    <div class="breadcrumbs">
        <div class="breadcrumbs-inner">
            <div class="row m-0">
<%--                <div class="col-sm-4">--%>
<%--                    <div class="page-header float-left">--%>
<%--                        <div class="page-title">--%>
<%--                            <h1>Dashboard</h1>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="col-sm-8">--%>
<%--                    <div class="page-header float-right">--%>
<%--                        <div class="page-title">--%>
<%--                            <ol class="breadcrumb text-right">--%>
<%--                                <li><a href="#">Dashboard</a></li>--%>
<%--                                <li><a href="#">Quản lý giày</a></li>--%>
<%--                                <li class="active">Sửa thông tin giày</li>--%>
<%--                            </ol>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
            </div>
        </div>
    </div>

    <div class="content" >
        <div class="animated fadeIn">
            <div class="card col-lg-12">
                <div class="card-header">
                    <div>
                        <strong class="card-title" ><h3>Sửa thông tin giày</h3></strong>
                    </div>
                </div>
                <div class="card-body">
                    <sf:form  class="row"  action="/admin/quanLySanPham/suaSanPhamChiTiet" method="post" enctype="multipart/form-data" modelAttribute="sanPhamChiTiet"   onsubmit=" return suaThongTinGiayChiTiet();" >
                        <sf:input path="id" type="text" id="id" name="id" class="form-control" style="display: none;" />

                        <div class="col-lg-10">
                                <span>Tên giày (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                                <sf:select path="sanPham" name="idSanPham" id="danhSachTenGiay" class="form-control" onchange="resetCheckTenGiay()">
    <%--                                <sf:option value="">Chọn tên giày</sf:option>--%>
                                    <sf:options items="${dsTenSanPham }" itemValue="id" itemLabel="ten" ></sf:options>
                                </sf:select>
                                <span id="checkTenGiay" style="color: red;"></span>
                            </div>
                            <div class="col-lg-2" style="margin-top: 23px;">
                                <a href="#" class="btn btn-success" data-toggle="modal" data-target="#themTenGiayMoi"  style="margin-left: -10px;">
                                    <i class="menu-icon fa fa-plus" style="margin-right: 5px;  "></i> Thêm</a>
                            </div>

                            <div class="col-lg-3" style="margin-top: 20px;">
                                <span>Thương hiệu (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                                <sf:select path="thuongHieu"  name="idThuongHieu" id="danhSachThuongHieu" class="form-control" onchange="resetCheckThuongHieu()">
                                <sf:options items="${dsTenThuongHieu }" itemValue="id" itemLabel="ten" ></sf:options>
                                </sf:select>
                                <span id="checkThuongHieu" style="color: red;"></span>
                            </div>
                            <div class="col-lg-3" style="margin-top: 20px;">
                                <span>Nhà sản xuất (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                                <sf:select path="nsx" name="idNSX" id="danhSachNSX" class="form-control" onchange="resetCheckNSX()">
                                    <sf:options items="${dsTenNSX }" itemValue="id" itemLabel="ten" ></sf:options>
                                </sf:select>
                                <span id="checkNSX" style="color: red;"></span>
                            </div>


                            <div class="col-lg-3" style="margin-top: 20px;">
                                <span>Danh mục (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                                <sf:select path="danhMuc" name="idDanhMuc" id="danhSachDanhMuc" class="form-control" onchange="resetCheckDanhMuc()">
                                    <sf:options items="${dsTenDanhMuc }" itemValue="id" itemLabel="ten" ></sf:options>
                                </sf:select>
                                <span id="checkDanhMuc" style="color: red;"></span>
                            </div>

                            <div class="col-lg-3" style="margin-top: 20px;">
                                <span>Loại sản phẩm (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                                <sf:select path="loaiSanPham" name="idLoaiSanPham" id="danhSachLoaiSanPham" class="form-control" onchange="resetCheckLoaiSanPham()">
                                    <sf:options items="${dsTenLoaiSanPham }" itemValue="id" itemLabel="ten" ></sf:options>
                                </sf:select>
                                <span id="checkLoaiSP" style="color: red;"></span>
                            </div>

                            <div class="col-lg-3" style="margin-top: 20px;">
                                <span>Kiểu dáng (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                                <sf:select path="kieuDang" name="idKieuDang" id="danhSachKieuDang" class="form-control" onchange="resetCheckKieuDang()">
                                    <sf:options items="${dsTenKieuDang }" itemValue="id" itemLabel="ten" ></sf:options>
                                </sf:select>
                                <span id="checkKieuDang" style="color: red;"></span>
                            </div>

                            <div class="col-lg-3" style="margin-top: 20px;">
                                <span>Chất liệu (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                                <sf:select path="chatLieu" name="idChatLieu" id="danhSachChatLieu" class="form-control" onchange="resetCheckChatLieu()">
                                    <sf:options items="${dsTenChatLieu }" itemValue="id" itemLabel="ten" ></sf:options>
                                </sf:select>
                                <span id="checkChatLieu" style="color: red;"></span>
                            </div>

                            <div class="col-lg-3" style="margin-top: 20px;">
                                <span>Mũi giày (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                                <sf:select path="muiGiay" name="idMuiGiay" id="danhSachMuiGiay" class="form-control" onchange="resetCheckMuiGiay()">
                                    <sf:options items="${dsTenMuiGiay }" itemValue="id" itemLabel="ten" ></sf:options>
                                </sf:select>
                                <span id="checkMuiGiay" style="color: red;"></span>
                            </div>
                            <div class="col-lg-3" style="margin-top: 20px;">
                                <span>Dây giày (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                                <sf:select path="dayGiay" name="idDayGiay" id="danhSachDayGiay" class="form-control" onchange="resetCheckDayGiay()">
                                    <sf:options items="${dsTenDayGiay }" itemValue="id" itemLabel="ten" ></sf:options>
                                </sf:select>
                                <span id="checkDayGiay" style="color: red;"></span>
                            </div>
                            <div class="col-lg-3" style="margin-top: 20px;">
                                <span>Đế giày (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                                <sf:select path="deGiay" name="idDeGiay" id="danhSachDeGiay" class="form-control" onchange="resetCheckDeGiay()">
                                    <sf:options items="${dsTenDeGiay }" itemValue="id" itemLabel="ten" ></sf:options>
                                </sf:select>
                                <span id="checkDeGiay" style="color: red;"></span>
                            </div>
                            <div class="col-lg-3" style="margin-top: 20px;">
                                <span>Lót giày (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                                <sf:select path="lotGiay" name="idLotGiay" id="danhSachLotGiay" class="form-control" onchange="resetCheckLotGiay()">
                                    <sf:options items="${dsTenLotGiay }" itemValue="id" itemLabel="ten" ></sf:options>
                                </sf:select>
                                <span id="checkLotGiay" style="color: red;"></span>
                            </div>
                            <div class="col-lg-3" style="margin-top: 20px;">
                                <span>Màu sắc (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                                <sf:select path="mauSac" name="idMauSac" id="danhSachMauSac" class="form-control" onchange="resetCheckMauSac()">
                                    <sf:options items="${dsTenMauSac }" itemValue="id" itemLabel="ten" ></sf:options>
                                </sf:select>
                                <span id="checkMauSac" style="color: red;"></span>
                            </div>
                            <div class="col-lg-3" style="margin-top: 20px;">
                                <span>Size giày (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                                <sf:select path="kichCo" name="idSizeGiay" id="danhSachSizeGiay" class="form-control" onchange="resetCheckSizeGiay()">
                                    <sf:options items="${dsTenKichCo }" itemValue="id" itemLabel="ten" ></sf:options>
                                </sf:select>
                                <span id="checkSizeGiay" style="color: red;"></span>
                            </div>

                            <div class="col-lg-3" style="margin-top: 20px;">
                                <span>Số lượng  (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                                <sf:input path="soLuong" type="number" id="soLuong" name="soLuong" class="form-control" />
                                <span id="checkSoLuong" style="color: red;"></span>
                            </div>

                            <div class="col-lg-3" style="margin-top: 20px;">
                                <span>Khối lượng  (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                                <sf:input path="khoiLuong" type="number" id="khoiLuong" name="khoiLuong" class="form-control"/>
                                <span id="checkKhoiLuong" style="color: red;"></span>
                            </div>

                            <div class="col-lg-6" style="margin-top: 20px;">
                                <span>Giá bán  (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                                <sf:input path="giaTriSanPham" type="number" id="giaTriSanPham" name="giaTriSanPham" class="form-control" />
                                <span id="checkGiaTriSanPham" style="color: red;"></span>
                            </div>

                            <div class="col-lg-6" style="margin-top: 20px;">
                                <span>Mô tả </span>
                                <sf:textarea path="moTa" id="moTa" rows="3" cols="50" class="form-control" style="margin-top: 5px;" name="moTa" onchange="resetCheckMoTa()" />
<%--                                <span id="checkMoTa" style="color: red;"></span>--%>
                            </div>
                            <div class="col-lg-6" style="margin-top: 20px;">
                                <span style="margin-bottom: 15px;">Trạng thái : </span> <br>
                                <sf:checkbox path="trangThai" id="hoatDong" name="trangThai" value="1"  style="transform: scale(1.6); margin-right: 5px;"></sf:checkbox>
                                Hoạt động ?
<%--                                <br><span id="checkHoatDong" style="color: red;" ></span>--%>
                            </div>

                            <div class="col-lg-6" style="margin-top: 20px;">
                                <span>Chọn 1 ảnh chính (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                                <br>
                                <span id="checkChonAnhChinh" style="color: red;" ></span>
                                <input type="file"  name="duongDanAnhChinh" id="chonMotAnhChinh"  style="margin-right: 5px;"/>
                                <img id="previewImage" src="#" style="margin-top: 10px; width: 300px; height: 300px;" >
                            </div>
                            <div class="col-lg-6" style="margin-top: 20px;">
                                <span>Chọn 1-5 ảnh sản phẩm (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                                <br>
                                <span id="checkChonAnhPhu" style="color: red;" ></span>
                                <input  type="file" id="anhSanPhamCon"  name="duongDanAnhCon"   style="margin-right: 5px;" multiple onchange="eventChangeChooseHinhAnhCon();">

                                <div id="danhSachHinhAnhConDuocChon"></div>
                            </div>

                            <div class="col-lg-12 d-flex justify-content-end" style="margin-top: 20px; ">
                                <button class="btn btn-primary">
                                    <i class="menu-icon fa fa-pencil-square-o"></i> Sửa
                                </button>

                                <a href="/admin/quanLySanPham/viewSanPhamChiTiet/${sanPhamChiTiet.sanPham.id}" class="btn btn-secondary" style="margin-left: 10px;">
                                    <i class="menu-icon fa fa-undo"></i> Quay lại
                                </a>
                            </div>

                        <input type="text" name="idSanPhamChiTiet" hidden value="${sanPhamChiTiet.id}">
                    </sf:form>

                    <div class="container">
                        <div class="modal fade" id="themTenGiayMoi" tabindex="-1" role="dialog"
                             aria-labelledby="createDiscountModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document" style="max-width: 550px;">
                                <div class="modal-content" >
                                    <div class="modal-header">
                                        <h4 class="modal-title" id="createDiscountModalLabel" style="  margin-left: 10px; font-size: 25px;"><b>Thêm mới sản phẩm</b></h4>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="font-size: 50px; margin-top: -70px;" >
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <div class="content" >
                                            <div class="animated fadeIn row">
                                                <div class="card col-lg-12">
                                                    <div class="card-header"  style="background-color: #F7F7F7; padding-bottom: 20px;">
                                                        <h3>Thêm mới sản phẩm</h3>
                                                    </div>
                                                    <div class="card-body" style="" class="row">
                                                        <form action="" >
                                                            <div class="col-lg-12">
                                                                <%--                                                                <span></span>--%>
                                                                <input type="text" class="form-control" placeholder="Nhập tên sản phẩm mới" >
                                                            </div>
                                                            <div class="col-lg-12 justify-content-end" style="margin-top: 15px;">
                                                                <button class="form-control btn btn-primary" style="margin-top: 24px;">Thêm mới</button>

                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div><!-- .animated -->
                                        </div><!-- .content -->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div><!-- .animated -->
    </div><!-- .content -->




    <div class="clearfix"></div>

    <!-- footer -->
    <jsp:include page="/WEB-INF/view/admin/layout/footer.jsp"></jsp:include>
    <!--/ footer -->




</div><!-- /#right-panel -->

<!-- Right Panel -->

<!-- Scripts -->



<script src="https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
<script src="/admin/assets/js/main.js"></script>

<script>

    // hàm thực hiện mỗi lần load trang sẽ thực hiện các hàm bên trong
    document.addEventListener("DOMContentLoaded", function() {


    });



    function fetchData_danhSachSanPhamCT(dsMauSacDaChon, dsSanPhamSauThemDB){
        var dsMauSac = dsMauSacDaChon;
        var dsSanPhamDaThem = dsSanPhamSauThemDB;

        // Xóa nội dung của phần tử có id là "danhSachSanPhamThemMoi"
        $("#danhSachSanPhamThemMoi").empty();

        // Lặp qua danh sách màu sắc trả về từ server
        dsMauSac.forEach(function (mauSac) {
            // Tạo phần tử div
            var div = $('<div>', {
                style: 'margin-top: 20px;'
            });
            // Tạo phần tử h4 trong div
            var h4 = $('<h4><b># Danh sách sản phẩm cùng loại màu: ' + mauSac.ten + '</b></h4>');
            div.append(h4);

            // Tạo phần tử table trong div
            var table = $('<table>', {
                class: 'table table-bordered table-hover no-wrap'
            });
            // Tạo phần tử thead trong table
            var thead = $('<thead><tr style="text-align: center;"><th scope="col">STT</th><th scope="col">Tên sản phẩm</th><th scope="col">Màu sắc</th><th scope="col">Số lượng</th><th scope="col">Đơn giá</th><th scope="col">Cân nặng</th><th scope="col">Danh mục</th><th scope="col">Thương hiệu</th><th scope="col">Thao tác</th><th scope="col">Ảnh</th></tr></thead>');
            table.append(thead);

            // Tạo phần tử tbody trong table
            var tbodyId = "tbody_" + mauSac.id; // Tạo id cho tbody
            var tbody = $('<tbody>', { id: tbodyId }); // Gán id cho tbody
            // Lặp qua danh sách sản phẩm đã thêm mới
            dsSanPhamDaThem.forEach(function (sanPhamCT, index) {
                // Kiểm tra nếu sản phẩm có màu sắc tương ứng với màu đang xét
                if (sanPhamCT.mauSac.id.toString() === mauSac.id.toString()) {
                    // console.log("mau sac id " + mauSac.id.toString());
                    // console.log("mau sac o sanPhamCT " + sanPhamCT.mauSac.id.toString());

                    // Tạo hàng mới trong tbody
                    var tr = $('<tr style="text-align: center;">');
                    tr.append('<td>' + (index + 1) + '</td>');
                    tr.append('<td>' + sanPhamCT.sanPham.ten + '</td>');
                    tr.append('<td>' + sanPhamCT.mauSac.ten + '</td>');
                    tr.append('<td>' + sanPhamCT.soLuong + '</td>');
                    tr.append('<td>' + sanPhamCT.giaTriSanPham + '</td>');
                    tr.append('<td>' + sanPhamCT.khoiLuong + '</td>');
                    tr.append('<td>' + sanPhamCT.danhMuc.ten + '</td>');
                    tr.append('<td>' + sanPhamCT.thuongHieu.ten + '</td>');
                    tr.append('<td><a href="/san-pham/xoa/' + sanPhamCT.id + '" class="btn btn-warning" onclick="return confirm(\'Bạn chắc chắn muốn xóa sản phẩm ?\')"> <i class="menu-icon fa fa-trash-o"></i> Xóa</a></td>');
                    tr.append('<td>' + sanPhamCT.anh + '</td>');
                    tbody.append(tr);
                }
            });

            table.append(tbody);
            div.append(table);

            // Thêm div vào trong #danhSachSanPhamThemMoi
            $("#danhSachSanPhamThemMoi").append(div);
        });
    }

    var duongDanTuyetDoiAnhChinh = "";

    // Lắng nghe sự kiện change của input type file để lưu đường dẫn ảnh vào biến toàn cục
    var chonMotAnhChinh = document.getElementById("chonMotAnhChinh");
    chonMotAnhChinh.addEventListener('change', function(event) {
        var file = event.target.files[0]; // Lấy ra tệp ảnh đã chọn

        if (file) {
            // Lấy đường dẫn tuyệt đối của tệp ảnh và lưu vào biến toàn cục
            duongDanTuyetDoiAnhChinh = URL.createObjectURL(file);
            console.log('Đường dẫn tuyệt đối của tệp ảnh:', duongDanTuyetDoiAnhChinh);
        }
    });
    function suaThongTinGiayChiTiet() {
        var chonTenGiay = document.getElementById("danhSachTenGiay").value;
        var chonThuongHieu = document.getElementById("danhSachThuongHieu").value;
        var chonNSX = document.getElementById("danhSachNSX").value;
        var chonDanhMuc = document.getElementById("danhSachDanhMuc").value;
        var chonLoaiSP = document.getElementById("danhSachLoaiSanPham").value;
        var chonKieuDang = document.getElementById("danhSachKieuDang").value;
        var chonChatLieu = document.getElementById("danhSachChatLieu").value;
        var chonMuiGiay = document.getElementById("danhSachMuiGiay").value;
        var chonDayGiay = document.getElementById("danhSachDayGiay").value;
        var chonDeGiay = document.getElementById("danhSachDeGiay").value;
        var chonLotGiay = document.getElementById("danhSachLotGiay").value;

        var nhapKhoiLuong = document.getElementById("khoiLuong").value;
        var nhapGiaBan = document.getElementById("giaTriSanPham").value;
        var nhapSoLuong = document.getElementById("soLuong").value;


        var nhapMoTa = document.getElementById("moTa").value;
        var trangThai = document.getElementsByName("trangThai");


        // Biến để lưu giá trị của radio button được chọn
        var trangThaiDuocChon = "";

        // Lặp qua tất cả các radio buttons
        trangThai.forEach(function (radio) {
            // Kiểm tra xem radio button nào được chọn
            if (radio.checked) {
                // Lấy giá trị của radio button được chọn
                trangThaiDuocChon = radio.value;
            }
        });

        // if (trangThaiDuocChon === "" || !trangThaiDuocChon) {
        //     document.getElementById("checkHoatDong").innerText = "Vui lòng chọn trạng thái sản phẩm";
        //     checkValidate = false;
        // } else {
        //     document.getElementById("checkHoatDong").innerText = "";
        // }


        var chonMauSac = document.getElementById("danhSachMauSac").value;
        var chonSizeGiay = document.getElementById("danhSachSizeGiay").value;


        var checkValidate = true;
        // var anhChinhDuocChon = document.getElementById("chonMotAnhChinh");
        //
        // if (anhChinhDuocChon.files.length === 0) {
        //     document.getElementById("checkChonAnhChinh").innerText = "Vui lòng chọn 1 ảnh chính cho giày";
        //     checkValidate = false;
        // } else {
        //     document.getElementById("checkChonAnhChinh").innerText = "";
        // }

        // var cacAnhConDuocChon = document.getElementById("anhSanPhamCon");
        // if (cacAnhConDuocChon.files.length === 0) {
        //     document.getElementById("checkChonAnhPhu").innerText = "Vui lòng chọn từ 1-5 ảnh cho sản phẩm";
        //     checkValidate = false;
        // } else {
        //     document.getElementById("checkChonAnhPhu").innerText = "";
        // }

        if (chonTenGiay === "" || !chonTenGiay) {
            document.getElementById("checkTenGiay").innerText = "Vui lòng chọn tên giày";
            checkValidate = false;
        } else {
            document.getElementById("checkTenGiay").innerText = "";
        }

        if (chonThuongHieu === "" || !chonThuongHieu) {
            document.getElementById("checkThuongHieu").innerText = "Vui lòng chọn thương hiệu";
            checkValidate = false;
        } else {
            document.getElementById("checkThuongHieu").innerText = "";
        }

        if (chonNSX === "" || !chonNSX) {
            document.getElementById("checkNSX").innerText = "Vui lòng chọn nhà sản xuất";
            checkValidate = false;
        } else {
            document.getElementById("checkNSX").innerText = "";
        }

        if (chonDanhMuc === "" || !chonDanhMuc) {
            document.getElementById("checkDanhMuc").innerText = "Vui lòng chọn danh mục";
            checkValidate = false;
        } else {
            document.getElementById("checkDanhMuc").innerText = "";
        }

        if (chonLoaiSP === "" || !chonLoaiSP) {
            document.getElementById("checkLoaiSP").innerText = "Vui lòng chọn loại sản phẩm";
            checkValidate = false;
        } else {
            document.getElementById("checkLoaiSP").innerText = "";
        }

        if (chonKieuDang === "" || !chonKieuDang) {
            document.getElementById("checkKieuDang").innerText = "Vui lòng chọn kiểu dáng";
            checkValidate = false;
        } else {
            document.getElementById("checkKieuDang").innerText = "";
        }

        if (chonChatLieu === "" || !chonChatLieu) {
            document.getElementById("checkChatLieu").innerText = "Vui lòng chọn chất liệu";
            checkValidate = false;
        } else {
            document.getElementById("checkChatLieu").innerText = "";
        }

        if (chonMuiGiay === "" || !chonMuiGiay) {
            document.getElementById("checkMuiGiay").innerText = "Vui lòng chọn mũi giày";
            checkValidate = false;
        } else {
            document.getElementById("checkMuiGiay").innerText = "";
        }

        if (chonDayGiay === "" || !chonDayGiay) {
            document.getElementById("checkDayGiay").innerText = "Vui lòng chọn dây giày";
            checkValidate = false;
        } else {
            document.getElementById("checkDayGiay").innerText = "";
        }

        if (chonDeGiay === "" || !chonDeGiay) {
            document.getElementById("checkDeGiay").innerText = "Vui lòng chọn đế giày";
            checkValidate = false;
        } else {
            document.getElementById("checkDeGiay").innerText = "";
        }

        if (chonLotGiay === "" || !chonLotGiay) {
            document.getElementById("checkLotGiay").innerText = "Vui lòng chọn lót giày";
            checkValidate = false;
        } else {
            document.getElementById("checkLotGiay").innerText = "";
        }


        if (chonMauSac === "" || !chonMauSac) {
            document.getElementById("checkMauSac").innerText = "Vui lòng chọn màu sắc";
            checkValidate = false;
        } else {
            document.getElementById("checkMauSac").innerText = "";
        }

        if (chonSizeGiay === "" || !chonSizeGiay) {
            document.getElementById("checkSizeGiay").innerText = "Vui lòng chọn size giày";
            checkValidate = false;
        } else {
            document.getElementById("checkSizeGiay").innerText = "";
        }

        // if (nhapMoTa === "" || !nhapMoTa) {
        //     document.getElementById("checkMoTa").innerText = "Vui lòng nhập mô tả";
        //     checkValidate = false;
        // } else {
        //     document.getElementById("checkMoTa").innerText = "";
        // }

        // var nhapKhoiLuong = document.getElementById("khoiLuong").value;
        // var nhapGiaBan = document.getElementById("giaTriSanPham").value;
        // var nhapSoLuong = document.getElementById("soLuong").value;

        if (nhapKhoiLuong === "" || !nhapKhoiLuong || nhapKhoiLuong < 200) {
            document.getElementById("checkKhoiLuong").innerText = "Vui lòng nhập khối lượng với giá trị ít nhất 200gram";
            checkValidate = false;
        } else {
            document.getElementById("checkKhoiLuong").innerText = "";
        }


        if (nhapGiaBan === "" || !nhapGiaBan || nhapGiaBan < 100000 || !isNumberWithCommas(nhapGiaBan)) {
            console.log("Gia bán : " + nhapGiaBan);
            document.getElementById("checkGiaTriSanPham").innerText = "Vui lòng chỉ nhập giá trị số, và giá bán ít nhất 100.000vnđ";
            checkValidate = false;
        } else {
            document.getElementById("checkGiaTriSanPham").innerText = "";
        }

        if (nhapSoLuong === "" || !nhapSoLuong || nhapSoLuong < 1) {
            document.getElementById("checkSoLuong").innerText = "Vui lòng nhập số lượng với giá trị > 0";
            checkValidate = false;
        } else {
            document.getElementById("checkSoLuong").innerText = "";
        }

        // console.log("Trạng thái được chọn : " + trangThaiDuocChon);


        if (!checkValidate) {
            return false;
        }

    }

    function isNumberWithCommas(str) {
        // Xác định biểu thức chính quy để kiểm tra chuỗi có phải là số hay không
        var numberPattern = /^[+-]?\d+(,\d+)*(\.\d+)?$/;
        return numberPattern.test(str);
    }

    function resetCheckTenGiay() {
        document.getElementById("checkTenGiay").innerText= "";
    }

    function resetCheckThuongHieu() {
        document.getElementById("checkThuongHieu").innerText= "";
    }

    function resetCheckNSX() {
        document.getElementById("checkNSX").innerText= "";
    }

    function resetCheckDanhMuc() {
        document.getElementById("checkDanhMuc").innerText= "";
    }

    function resetCheckLoaiSanPham() {
        document.getElementById("checkLoaiSP").innerText= "";
    }

    function resetCheckKieuDang() {
        document.getElementById("checkKieuDang").innerText= "";
    }

    function resetCheckChatLieu() {
        document.getElementById("checkChatLieu").innerText= "";
    }

    function resetCheckMuiGiay() {
        document.getElementById("checkMuiGiay").innerText= "";
    }

    function resetCheckDayGiay() {
        document.getElementById("checkDayGiay").innerText= "";
    }

    function resetCheckDeGiay() {
        document.getElementById("checkDeGiay").innerText= "";
    }

    function resetCheckLotGiay() {
        document.getElementById("checkLotGiay").innerText= "";
    }

    function resetCheckMoTa() {
        document.getElementById("checkMoTa").innerText= "";
    }

    function resetCheckMauSac() {
        document.getElementById("checkMauSac").innerText= "";
    }

    function resetCheckSizeGiay() {
        document.getElementById("checkSizeGiay").innerText= "";
    }

    function eventChangeChooseHinhAnhCon(){}


    // Lắng nghe sự kiện khi người dùng chọn file ảnh chính
    document.getElementById('chonMotAnhChinh').addEventListener('change', function() {
        // Lấy ra danh sách các tệp đã chọn
        var files = this.files;

        // Kiểm tra xem có tệp nào được chọn không
        // if (files.length === 0) {
        //     document.getElementById("checkChonAnhChinh").innerText = "Vui lòng chọn ảnh chính cho sản phẩm";
        //     alert('Vui lòng chọn ảnh chính cho sản phẩm');
        //
        //     // Set đường dẫn của ảnh thành rỗng
        //     document.getElementById('previewImage').src = '';
        // } else {
            document.getElementById("checkChonAnhChinh").innerText = "";

            // Có ít nhất một tệp được chọn

            // Lấy tệp đầu tiên từ danh sách
            var file = files[0];

            // Tạo đối tượng FileReader để đọc tệp
            var reader = new FileReader();

            // Xử lý sự kiện khi FileReader hoàn thành việc đọc
            reader.onload = function(event) {
                // Lấy đường dẫn hình ảnh từ FileReader và gán cho thuộc tính src của thẻ <img>
                document.getElementById('previewImage').src = event.target.result;
            };

            // Đọc tệp dưới dạng URL dữ liệu (data URL)
            reader.readAsDataURL(file);

        // }
    });


    // sự kiện hiển thị các hình ảnh sản phẩm đã chọn trước đó
    document.getElementById('anhSanPhamCon').addEventListener('change', function() {
        // Xóa danh sách các tệp hình ảnh đã chọn trước đó
        document.getElementById('danhSachHinhAnhConDuocChon').innerHTML = '';

        // Lấy ra danh sách các tệp đã chọn
        var files = this.files;

        // Kiểm tra xem có tệp nào được chọn không
        // if (files.length === 0) {
        //     // Không có tệp nào được chọn
        //     document.getElementById("checkChonAnhPhu").innerText= "Vui lòng chọn từ 1-5 ảnh cho sản phẩm chi tiết";
        //     alert('Vui lòng chọn từ 1-5 ảnh cho sản phẩm chi tiết');
        //
        //     // Xóa toàn bộ nội dung bên trong phần tử danhSachHinhAnhConDuocChon
        //     document.getElementById('danhSachHinhAnhConDuocChon').innerHTML = '';
        //
        //     return;
        // }
        document.getElementById("checkChonAnhPhu").innerText="";

        // Kiểm tra số lượng tệp đã chọn
        if (files.length > 5) {
            document.getElementById("checkChonAnhPhu").innerText="Vui lòng chọn lại ảnh với số lượng tối đa 5 ảnh";
            alert('Bạn chỉ có thể chọn tối đa 5 ảnh.');
            this.value = ''; // Xóa các tệp đã chọn để ngăn chọn quá số lượng quy định

            // Xóa toàn bộ nội dung bên trong phần tử danhSachHinhAnhConDuocChon
            document.getElementById('danhSachHinhAnhConDuocChon').innerHTML = '';
            return;
        }

        document.getElementById("checkChonAnhPhu").innerText="";

        // Lặp qua từng tệp và hiển thị ảnh trên giao diện
        for (var i = 0; i < files.length; i++) {
            var reader = new FileReader();

            reader.onload = function(event) {
                var img = document.createElement('img');
                img.src = event.target.result;
                img.classList.add('hinhAnhCon');

                img.width = 100;
                img.height = 100;
                img.style.marginRight = '10px';
                img.style.marginTop = '10px';
                document.getElementById('danhSachHinhAnhConDuocChon').appendChild(img);
            };

            reader.readAsDataURL(files[i]);
        }
    });


</script>

</body>
</html>

