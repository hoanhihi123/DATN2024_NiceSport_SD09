<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Quản lý lót giày</title>
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
    <link rel="stylesheet" href="/admin/admin/assets/css/cs-skin-elastic.css">
    <link rel="stylesheet" href="/admin/assets/css/style.css">

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>

    <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->

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
                    <a href="/admin/quanLySanPham/hien-thi" aria-expanded="false" >
                        <i class="menu-icon fa fa-star"></i>Quản lý sản phẩm
                    </a>
                    <%--                    <ul class="sub-menu children dropdown-menu">--%>
                    <%--                        <li>--%>
                    <%--                            <i class="fa fa-puzzle-piece"></i>--%>
                    <%--                            <a href="ui-buttons.html">Xuất hóa đơn</a>--%>
                    <%--                        </li>--%>
                    <%--                        <li>--%>
                    <%--                            <i class="fa fa-id-badge"></i>--%>
                    <%--                            <a href="ui-badges.html">Quản lý hóa đơn</a>--%>
                    <%--                        </li>--%>
                    <%--                    </ul>--%>
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
                <li class="active">
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
                <a class="navbar-brand" href=""><img src="/admin/images/logo.png" alt="Logo"></a>
                <a class="navbar-brand hidden" href=""><img src="/admin/images/logo2.png" alt="Logo"></a>
                <a id="menuToggle" class="menutoggle"><i class="fa fa-bars"></i></a>
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
                        <a class="nav-link" href="#"><i class="fa fa-user"></i>My Profile</a>

                        <a class="nav-link" href="#"><i class="fa fa-bell-o"></i>Notifications <span class="count">13</span></a>

                        <a class="nav-link" href="#"><i class="fa fa-cog"></i>Settings</a>

                        <a class="nav-link" href="#"><i class="fa fa-power-off"></i>Logout</a>
                    </div>
                </div>
            </div>
        </div>
    </header><!-- /header -->
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
                <%--                                <li class="active">Kiểu Dáng</li>--%>
                <%--                            </ol>--%>
                <%--                        </div>--%>
                <%--                    </div>--%>
                <%--                </div>--%>
            </div>
        </div>
    </div>


    <div class="content">


    </div><!-- .content -->

    <div class="content" style="margin-top: -55px;">
        <div class="animated fadeIn">
            <div class="card col-lg-12">
                <div class="card-header">
                    <div class="row">
                        <div class="col-lg-10">
                            <strong class="card-title" ><h3>Danh sách lót giày</h3></strong>
                        </div>
                        <div class="col-lg-10" style="margin-left: 1100px">
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                                Thêm
                            </button>

                            <!-- Modal -->
                            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Thêm Kiểu Dáng</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <form:form modelAttribute="lotGiay" action="/lot-giay/add" method="post">
                                                <div class="form-group">
                                                    <label>Mã</label>
                                                    <form:input path="ma" cssClass="form-control" />
                                                </div>

                                                <div class="form-group">
                                                    <label>Tên</label>
                                                    <form:input path="ten" cssClass="form-control" />
                                                </div>
                                                <div class="form-group">
                                                    <label>Mô tả</label>
                                                    <form:input path="moTa" cssClass="form-control" />
                                                </div>
                                                <div class="form-group">
                                                    <label>Ngày tạo</label>
                                                    <form:input path="ngayTao" type="date" cssClass="form-control" />
                                                </div>
                                                <div class="form-group">
                                                    <label>Ngày sửa</label>
                                                    <form:input path="ngaySua" type="date" cssClass="form-control" />
                                                </div>
                                                <div class="form-group">
                                                    <label>Người tạo</label>
                                                    <form:input path="nguoiTao" cssClass="form-control" />
                                                </div>
                                                <div class="form-group">
                                                    <label>Người sửa</label>
                                                    <form:input path="nguoiSua" cssClass="form-control" />
                                                </div>
                                                <div class="form-group">
                                                    <label>Trạng thái</label>
                                                    <form:radiobutton path="trangThai"  value="1"/>Còn hàng
                                                    <form:radiobutton path="trangThai"  value="0"/>Hết hàng
                                                </div>

                                                <button type="submit" class="btn btn-primary">Add</button>
                                            </form:form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>

                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                    <br>
                    <div class="row d-flex" style=" margin-left: 3px;">
                        <input  class="form-control col-lg-4" id="textsearch" name="textsearch" type="text" placeholder="Nhập nội dung tìm kiếm" >
                        <select name="" class="form-control col-lg-3" style="margin-left: 10px;">
                            <option value="">Tất cả</option>
                            <option value="">Hoạt động</option>
                            <option value="">Ngưng hoạt động</option>
                        </select>
                        <a href="" class="btn btn-secondary" style="margin-left: 10px;"> Tìm kiếm </a>
                    </div>


                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover no-wrap">
                            <thead>
                            <tr style="text-align: center;">
                                <th scope="col">STT</th>
                                <th scope="col">Mã</th>
                                <th scope="col">Tên</th>
                                <th scope="col">Mô tả</th>
                                <th scope="col">Ngày tạo</th>
                                <th scope="col">Ngày sửa</th>
                                <th scope="col">Người tạo</th>
                                <th scope="col">Người sửa </th>
                                <th scope="col">Trạng thái </th>
                                <th scope="col" colspan="2" >Hành động</th>

                            </tr>
                            </thead>
                            <tbody>

                            <c:forEach items="${listLG}" var="lg" varStatus="i">
                                <tr>
                                    <td>${i.count}</td>
                                    <td>${lg.ma}</td>
                                    <td>${lg.ten}</td>
                                    <td>${lg.moTa}</td>
                                    <td>${lg.ngayTao}</td>
                                    <td>${lg.ngaySua}</td>
                                    <td>${lg.nguoiTao}</td>
                                    <td>${lg.nguoiSua}</td>
                                    <td>${lg.trangThai == 1? "Còn hàng" :"Hết hàng"}</td>

                                    <td>  <a href="/lot-giay/detail/${lg.id}" class="btn btn-success"> <i class="menu-icon fa fa-pencil-square-o"></i></a></td>

                                    <td>
                                        <a href="/lot-giay/delete/${lg.id}" class="btn btn-warning" onclick="return confirm('Ban chac chan muon xoa  ${lg.ten}?')"><i class="menu-icon fa fa-trash-o"></i></a>
                                    </td>
                                </tr>
                            </c:forEach>


                            </tbody>
                        </table>
                    </div>
                    <div class="row" style="margin-top: 20px;">

                        <div class="col-lg-4">
                            <nav aria-label="...">
                                <ul class="pagination">
                                    <li class="page-item">
                                        <a class="page-link" href="/lot-giay/hien-thi?page=0" tabindex="-1" aria-disabled="true">Previous</a>
                                    </li>
                                    <c:forEach begin="0" end="${totalPage - 1}" varStatus="loop">
                                        <li class="page-item" aria-current="page">
                                            <a name="page" class="page-link" href="/lot-giay/hien-thi?page=${loop.index}">${loop.index + 1}</a>
                                        </li>
                                    </c:forEach>

                                    <li class="page-item">
                                        <a class="page-link" href="/lot-giay/hien-thi?page=${totalPage-1}">Next</a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div><!-- .animated -->
    </div><!-- .content -->


    <div class="clearfix"></div>

    <footer class="site-footer">
        <div class="footer-inner bg-white">
            <div class="row">
                <div class="col-sm-6">
                    NiceStore 2024
                </div>
                <div class="col-sm-6 text-right">
                    Designed by <a href="https://colorlib.com">Team SD-09</a>
                </div>
            </div>
        </div>
    </footer>

</div><!-- /#right-panel -->

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