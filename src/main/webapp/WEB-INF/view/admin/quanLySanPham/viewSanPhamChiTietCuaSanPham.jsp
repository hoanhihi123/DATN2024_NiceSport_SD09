<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!doctype html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Xem chi tiết sản phẩm </title>
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
        .messageError{
            color: red;
        }
    </style>
</head>
<body>
<!-- Left Panel -->
<jsp:include page="/WEB-INF/view/admin/layout/left_menu_admin.jsp"></jsp:include>
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
<%--                                <li class="active">Xem chi tiết sản phẩm</li>--%>
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
                    <div class="row">
                        <div class="col-lg-10">
                            <strong class="card-title" ><h3>Danh sách chi tiết sản phẩm</h3></strong>
                        </div>
                        <div class="col-lg-2">
                            <a href="/admin/quanLySanPham/hien-thi" class="btn btn-secondary"> <i class="menu-icon fa fa-undo"></i> Quay lại</a>
                        </div>
                        <form class="row"  style="margin-left: 10px;" action="/admin/quanLySanPham/viewSanPhamChiTiet/${idSanPham}" method="get">
                                <div class="col-lg-8" style="margin-top: 10px; ">
                                    <span>Lọc trạng thái sản phẩm:</span>
                                    <select name="searchTrangThaiSPCT" id="searchTrangThaiSPCT" class="form-control" style="margin-top:10px; display: inline-block;">
                                        <option value="">Tất cả</option>
                                        <option value="1">Hoạt động</option>
                                        <option value="0">Ngừng hoạt động</option>
                                    </select>
                                </div>
                                <div class="col-lg-3" style="margin-top: 43px; ">
                                    <button class="form-control btn btn-primary" >Lọc</button>
                                </div>
                        </form>
                    </div>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                            <table class="table table-bordered table-hover no-wrap">
                                <thead>
                                <tr style="text-align: center;">
                                    <th scope="col">ID</th>
                                    <th scope="col">Ảnh</th>
                                    <th scope="col">Tên</th>
                                    <th scope="col">Size - màu sắc</th>
                                    <th scope="col">Đơn giá</th>
                                    <th scope="col">Số lượng</th>
                                    <th scope="col">Trạng thái</th>
                                    <th scope="col" colspan="2" >Tác động</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${dsSanPham}" var="sanPhamCT" varStatus="sanpham">
                                    <tr>
                                        <th scope="row">${sanpham.index +1}</th>
                                        <td >
                                            <img width='80px' height="80px" src="${sanPhamCT.hinhAnh}" alt=''>
                                        </td>
                                        <td > ${sanPhamCT.sanPham.ten}</td>
                                        <td > Size: ${sanPhamCT.kichCo.ten} - Màu:${sanPhamCT.mauSac.ten}</td>
                                        <td >
                                            <c:choose>
                                                <c:when test="${sanPhamCT.giaTriGiam > 0}">
                                                    <s>${sanPhamCT.giaTriSanPham}</s> -
                                                    <b>${sanPhamCT.giaTriGiam}</b>
                                                </c:when>
                                                <c:otherwise>
                                                    <b>${sanPhamCT.giaTriSanPham}</b>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td > ${sanPhamCT.soLuong}</td>
                                        <td > ${sanPhamCT.trangThai == 1 ? 'Hoạt động': 'Ngưng hoạt động'}</td>
                                        <td > <a href="/admin/quanLySanPham/viewSuaSanPhamChiTiet/${sanPhamCT.id}" class="btn btn-success">Xem <i class="menu-icon fa fa-pencil-square-o"></i></a> </td>
                                        <td > <a href="/admin/quanLySanPham/xoaSanPhamChiTiet/${sanPhamCT.id}" class="btn btn-warning"
                                                 onclick="return confirm('Bạn chắc chắn muốn xóa sản phẩm chi tiết này ?')"> <i class="menu-icon fa fa-trash-o"></i> Xóa</a> </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
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
    // Sử dụng JavaScript để đặt giá trị của trường ngày thành ngày hôm nay
    // document.getElementById('dateToday').valueAsDate = new Date();



</script>

</body>
</html>
