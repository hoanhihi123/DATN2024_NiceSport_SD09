<!doctype html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]> <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]> <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="">
<!--<![endif]-->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Quản lý hóa đơn</title>
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
    <div class="content" style="margin-top: 50px;">
        <div class="animated fadeIn">
            <div class="card col-lg-12">
                <div class="card-header">
                    <div class="row">
                        <div class="col-lg-10">
                            <strong class="card-title"><h3>Chi tiết hóa đơn</h3></strong>
                            <hr>
                        </div>
                    </div>
                </div>
                <br>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="orderId">Mã hóa đơn</label>
                            <input type="text" class="form-control" id="orderId" readonly="true">
                        </div>
                        <div class="form-group">
                            <label for="customerName">Tên khách hàng</label>
                            <input type="text" class="form-control" id="customerName" readonly="true">
                        </div>
                        <div class="form-group">
                            <label for="address">Địa chỉ</label>
                            <input type="text" class="form-control" id="address" readonly="true">
                        </div>
                        <div class="form-group">
                            <label for="phone">Số điện thoại</label>
                            <input type="text" class="form-control" id="phone" readonly="true">
                        </div>
                        <div class="form-group">
                            <label for="orderDate">Ngày mua</label>
                            <input type="date" class="form-control" id="orderDate" readonly="true">
                        </div>
                        <div class="form-group">
                            <label for="payDate">Ngày thanh toán</label>
                            <input type="date" class="form-control" id="payDate" readonly="true">
                        </div>
                        <div class="form-group">
                            <label for="chargeShip">Phí ship</label>
                            <input type="text" class="form-control" id="chargeShip" readonly="true">
                        </div>
                        <div class="form-group">
                            <label for="totalMoney">Tổng tiền</label>
                            <input type="text" class="form-control" id="totalMoney" readonly="true">
                        </div>

                        <div class="container mt- pl-0">
                            <form action="/hoa-don/update/trangthai" method="POST">
                                <div class="mb-3">
                                    <label for="trangThai" class="form-label">Trạng thái:</label>
                                    <%--                                    <input type="text" id="trangThaiHienThi" readonly="true" />--%>
                                    <%--                                    <input type="hidden" id="trangThai" name="trangThai" readonly="true" />--%>
                                    <select id="trangThai" name="trangThai" class="form-select" onchange="changeStatus()">
                                        <%--                                    <option value="1">Chờ xác nhận</option>--%>
                                        <%--                                    <option value="2">Chờ lấy hàng</option>--%>
                                        <%--                                    <option value="3">Đang giao</option>--%>
                                        <%--                                    <option value="4" id="trangThaiThanhCong">${hd.loaiHoaDon == "1" ? 'Đã thanh toán':'Đã giao hàng thành công'}</option>--%>
                                        <%--                                    <option value="5">Hủy</option>--%>
                                        <!--Thêm các tùy chọn khác nếu cần-->
                                    </select>
                                </div>
                                <div class="mb-3" id="reasonField" style="display: none;">
                                    <label for="lyDoHuy" class="form-label">Lý do hủy:</label>
                                    <textarea class="form-control" id="lyDoHuy" name="lyDoHuy" rows="3"></textarea>
                                </div>
                                <!--Thêm trường ẩn chứa ID của hóa đơn để xác định hóa đơn nào đang được cập nhật-->
                                <input type="hidden" name="hoadonId" value="id_cua_hoa_don" id="hoadonId">
                                <!--Bạn cần thay id_cua_hoa_don bằng giá trị thực tế của ID hóa đơn được cập nhật-->
                                <div>
                                    <button type="submit" class="btn btn-primary" id="btnCapnhat">Xác nhận</button>
                                    <%--                                    <button type="button" class="btn btn-primary" id="btnCancel" onclick="cancelStatus()">Hủy</button>--%>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>STT</th>
                            <th>Tên sản phẩm</th>
                            <th>Số lượng</th>
                            <th>Giá</th>
                            <th>Thành tiền</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${orderDetailList}" var="orderDetail" varStatus="loop">
                        <tr>
                            <td>${loop.index + 1}</td>
                            <td>${orderDetail.chiTietSanPham.sanPham.ten}</td>
                            <td>${orderDetail.soLuong}</td>
<%--                            <td>${orderDetail.giaGocSP} - ${orderDetail.giaSauGiam}</td>--%>
                            <td>
                                <script>
                                    var giaTriSanPham = ${orderDetail.giaGocSP};
                                    var giaTriGiam = ${orderDetail.giaSauGiam >= 0 ? orderDetail.giaSauGiam : 0};

                                    var formatted_giaGiam = new Intl.NumberFormat('vi-VN', { maximumFractionDigits: 0 }).format(giaTriGiam);
                                    var formatted_giaGoc = new Intl.NumberFormat('vi-VN', { maximumFractionDigits: 0 }).format(giaTriSanPham);

                                    if (giaTriGiam > 0) {
                                        document.write("<del>" + formatted_giaGoc + "</del> - <b>" + formatted_giaGiam + "</b>");
                                    } else {
                                        document.write(formatted_giaGoc);
                                    }
                                </script>
                            </td>


                        <%--                            <td>${orderDetail.totalMoney}</td>--%>
                            <td><fmt:formatNumber value="${orderDetail.donGia}" pattern="#,##0"/></td>

                        </tr>
                        </c:forEach>
                    </table>

                </div>
                <div class="row" style="margin-top: 20px;">
                    <div class="col-lg-4"></div>
                    <div class="col-lg-8" style="text-align: center;">
                        <nav aria-label="...">
                            <c:if test="${totalPage>0}">
                                <ul class="pagination justify-content-end">
                                    <li class="page-item">
                                        <a class="page-link" href="/hoa-don/hien-thi?page=0" tabindex="-1" aria-disabled="true">Previous</a>
                                    </li>
                                    <c:forEach begin="0" end="${totalPage - 1}" varStatus="loop">
                                        <c:choose>
                                            <c:when test="${pageChoosedNumber==loop.index}">
                                                <li class="page-item active" aria-current="page">
                                                    <a name="page" class="page-link" href="/hoa-don/hien-thi?page=${loop.index}">${loop.index + 1}</a>
                                                </li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="page-item" aria-current="page">
                                                    <a name="page" class="page-link" href="/hoa-don/hien-thi?page=${loop.index}">${loop.index + 1}</a>
                                                </li>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                    <li class="page-item">
                                        <a class="page-link" href="/hoa-don/hien-thi?page=${totalPage-1}">Next</a>
                                    </li>
                                </ul>
                            </c:if>
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
    function changeStatus() {
        var selectBox = document.getElementById("trangThai");
        var selectedValue = selectBox.options[selectBox.selectedIndex].value;
        if (selectedValue == "5") {
            showReason();
        } else {
            hideReason();
        }
    }

    function showReason() {
        var reasonField = document.getElementById("reasonField");
        reasonField.style.display = "block";
    }

    function hideReason() {
        var reasonField = document.getElementById("reasonField");
        reasonField.style.display = "none";
    }
    const currentURL = window.location.href;
    const regex = /\/detail\/([^\/]+)/;
    const match = currentURL.match(regex);
    const id = match ? match[1] : null;
    const apiUrl = `http://localhost:8080/api/v2/order/${id}`;
    fetch(apiUrl)
        .then(response => response.json())
        .then(data => {
            console.log('data', data);
            // const fieldTrangThaiHienThi = document.getElementById('trangThaiHienThi');
            // const fieldTrangThai = document.getElementById('trangThai');
            const currentTrangThai = data?.trangThai;
            const selectBox = document.getElementById("trangThai");
            selectBox.innerHTML = '';

            if (currentTrangThai === "1") {
                const fieldWaiting = document.createElement("option");
                const fieldCancel = document.createElement("option");
                fieldWaiting.setAttribute("value", "2");
                fieldWaiting.innerHTML = "Chờ lấy hàng";
                fieldCancel.setAttribute("value", "5");
                fieldCancel.innerHTML = "Hủy";

                selectBox.appendChild(fieldWaiting);
                selectBox.appendChild(fieldCancel);
            } else if (currentTrangThai === "2") {
                const fieldDelivery = document.createElement("option");
                fieldDelivery.setAttribute("value", "3");
                fieldDelivery.innerHTML = "Đang giao";
                selectBox.appendChild(fieldDelivery);
            } else if (currentTrangThai === "3") {
                console.log('curr', currentTrangThai)
                const fieldSuccess = document.createElement("option");
                const fieldCancel = document.createElement("option");
                fieldSuccess.setAttribute("value", "4");
                fieldSuccess.innerHTML = "Đã giao hàng thành công";
                fieldCancel.setAttribute("value", "5");
                fieldCancel.innerHTML = "Hủy";

                selectBox.appendChild(fieldSuccess);
                selectBox.appendChild(fieldCancel);
            } else if (currentTrangThai === "4") {
                if (data?.loaiHoaDon === "1") {
                    const fieldSuccess = document.createElement("option");
                    fieldSuccess.setAttribute("value", "4");
                    fieldSuccess.innerHTML = "Đã thanh toán";
                    selectBox.appendChild(fieldSuccess);
                } else {
                    const fieldSuccess = document.createElement("option");
                    fieldSuccess.setAttribute("value", "4");
                    fieldSuccess.innerHTML = "Đã giao hàng thành công";
                    selectBox.appendChild(fieldSuccess);
                }
            } else {
                const fieldCancel = document.createElement("option");
                fieldCancel.setAttribute("value", "5");
                fieldCancel.innerHTML = "Hủy";
                selectBox.appendChild(fieldCancel);
            }

            if(data?.loaiHoaDon == 1){
                document.getElementById("trangThai").disabled = true;
                document.getElementById("btnCapnhat").disabled = true;
            } else if (data?.trangThai === "4") {
                document.getElementById("trangThai").disabled = true;
                document.getElementById("btnCapnhat").style.display = "none";
            }

            if(data?.trangThai == 5){
                showReason();
                document.getElementById("trangThai").disabled = true;
                document.getElementById("btnCapnhat").style.display = "none";
                document.getElementById('lyDoHuy').disabled = true;

            }
            document.getElementById('lyDoHuy').value = data?.lyDoHuy;
            console.log('hello', data);
            document.getElementById('hoadonId').value = data?.id;
            document.getElementById('orderId').value = data?.id;
            document.getElementById('orderDate').value = new Date(data?.ngayMua).toISOString().split('T')[0];
            document.getElementById('payDate').value = new Date(data?.ngayThanhToan).toISOString().split('T')[0];
            document.getElementById('chargeShip').value = data?.tienVanChuyen.toLocaleString();
            document.getElementById('totalMoney').value = data?.tongTienThanhToan.toLocaleString();
            document.getElementById('customerName').value = data?.tenKH;
            document.getElementById('address').value = data?.diaChi;
            document.getElementById('phone').value = data?.soDT;
            // document.getElementById('payment').value = data?.hinhThucTT || "1";
        })
</script>

</body>
</html>