<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Quản lý nhân viên </title>
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
<%--                                <li><a href="#">Quản lý nhân viên</a></li>--%>
<%--                            </ol>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
            </div>
        </div>
    </div>

    <div class="content" style="margin-top: 0px;">
        <div class="animated fadeIn">
            <div class="card col-lg-12">
                <div class="card-header">
                    <div class="row">
                        <div class="col-lg-9">
                            <strong class="card-title" ><h3>Danh sách nhân viên</h3></strong>
                        </div>
                        <div class="col-lg-3">
                            <a href="#formThemMoiNhanVien" class="btn btn-primary" > <i class="menu-icon fa fa-plus"></i> Thêm mới nhân viên </a>
                        </div>
                    </div>
                    <br>
                    <form action="/nhan-vien/hien-thi" method="get">
                        <div class="row d-flex" style=" margin-left: 3px;">
                            <input  class="form-control col-lg-4" id="textsearch" name="textsearch" type="text" placeholder="Nhập nội dung tìm kiếm" >
                            <span style="margin: 0px 5px;"></span>
                            <button class="btn btn-secondary" type="submit" > <i class="menu-icon fa  fa-search"></i> Tìm kiếm</button>
                        </div>
                    </form>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover no-wrap">
                            <thead>
                            <tr style="text-align: center;">
                                <th scope="col">ID</th>
                                <th scope="col">Họ & Tên</th>
                                <th scope="col">Giới tính</th>
                                <th scope="col">Tài khoản</th>
                                <th scope="col">Loại NV</th>
                                <th scope="col">SĐT</th>
                                <th scope="col">Ngày sinh</th>
                                <th scope="col">Địa chỉ</th>
                                <th scope="col">Trạng thái</th>
                                <th scope="col" colspan="2" >Tác động</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${dsNhanVien}" var="nhanVien" varStatus="nhanvien">
                                <tr>
                                    <th scope="row">${nhanvien.index + 1}</th>
                                    <td > ${nhanVien.hoVaTen}</td>
                                    <td > ${nhanVien.gioiTinh==0?"Nam":"Nữ"}</td>
                                    <td > ${nhanVien.taiKhoan}</td>
                                    <td > ${nhanVien.chucVu.ten}</td>
                                    <td > ${nhanVien.sdt}</td>
                                    <td >
                                        <fmt:formatDate value="${nhanVien.ngaySinh}" pattern="dd-MM-yyyy"/>
                                    </td>
                                    <td > ${nhanVien.diaChi}</td>
                                    <td >${nhanVien.trangThai==1?'Hoạt động':'Ngưng hoạt động'}</td>
                                    <td > <a href="/nhan-vien/view-sua/${nhanVien.id}" class="btn btn-success">Xem <i class="menu-icon fa fa-pencil-square-o" ></i></a> </td>
                                    <td > <a href="/nhan-vien/xoa/${nhanVien.id}" class="btn btn-warning"
                                             onclick="return confirm('Bạn chắc chắn muốn xóa nhân viên ${nhanVien.hoVaTen} ?')"><i class="menu-icon fa fa-trash-o"></i> Xóa </a> </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="row" style="margin-top: 20px;">
                        <div class="col-lg-4">
                        </div>
                        <div class="col-lg-8"  style="text-align: center;">
                            <nav aria-label="...">
                                <c:if test="${totalPage>0}">
                                    <ul class="pagination justify-content-end">
                                        <c:if test="${pageChoosedNumber > 0}">
                                            <li class="page-item">
                                                <a class="page-link" href="/nhan-vien/hien-thi?${pageChoosedNumber-1}" tabindex="-1" aria-disabled="true">Previous</a>
                                            </li>
                                        </c:if>

                                        <c:forEach begin="0" end="${totalPage - 1}" varStatus="loop">
                                            <c:choose>
                                                <c:when test="${pageChoosedNumber==loop.index}">
                                                    <li class="page-item active" aria-current="page" >
                                                        <a name="page" class="page-link"   href="/nhan-vien/hien-thi?page=${loop.index}">${loop.index + 1}</a>
                                                    </li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li class="page-item" aria-current="page">
                                                        <a name="page" class="page-link" href="/nhan-vien/hien-thi?page=${loop.index}">${loop.index + 1}</a>
                                                    </li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                        <c:if test= "${pageChoosedNumber < (totalPage-1)}">
                                            <li class="page-item">
                                                <a class="page-link" href="/nhan-vien/hien-thi?page=${pageChoosedNumber + 1}">Next</a>
                                            </li>
                                        </c:if>

                                    </ul>
                                </c:if>
                            </nav>
                        </div>
                    </div>

                    <span id="formThemMoiNhanVien" style="margin-top: -40px; margin-bottom: 40px;"></span>

                </div>
            </div>
        </div><!-- .animated -->
    </div><!-- .content -->




    <div class="content" style="margin-top: -50px;" >
        <div class="animated fadeIn">
            <div class="card col-lg-12">
                <div class="card-header" >
                    <div>
                        <strong class="card-title"  ><h3>Thêm mới nhân viên</h3></strong>
                    </div>

                </div>
                <div class="card-body">
                    <form:form action="/admin/nhan-vien/them" method="post" modelAttribute="nhanVien" class="row">
                        <div class="col-lg-6" >
                            Tên nhân viên (<i class="fa fa-asterisk" style="color: red;"></i>)
                            <form:input path="hoVaTen" name="hoVaTen" type="text" class="form-control" />
                        </div>
                        <div class="col-lg-6" >
                            Giới tính (<i class="fa fa-asterisk" style="color: red;"></i>)<br>
                            <div style="margin-top: 5px;">
                                <form:radiobutton path="gioiTinh" name="gioiTinh" value="1" checked="true"/> Nữ
                                <form:radiobutton path="gioiTinh"  name="gioiTinh" value="0" style="margin-left: 20px;"/> Nam <br>
                            </div>
                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            <span>Tên tài khoản  (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                            <form:input path="taiKhoan" name="taiKhoan" type="text" class="form-control"  />
                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            <span>Mật khẩu  (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                            <form:input path="matKhau" name="matKhau" type="text" class="form-control" />
                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            Loại nhân viên (<i class="fa fa-asterisk" style="color: red;"></i>)
                            <form:select path="chucVu" name="IdChucVu" class="form-control">
                                <c:forEach items="${dsChucVu}" var="chucVu" varStatus="chucvu">
                                    <form:option value="${chucVu.id}">${chucVu.ten}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>

                        <div class="col-lg-6" style="margin-top: 20px;">
                            Ngày sinh (<i class="fa fa-asterisk" style="color: red;"></i>)
                            <form:input path="ngaySinh" name="ngaySinh" type="date" class="form-control"/>
                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            Email (<i class="fa fa-asterisk" style="color: red;"></i>)
                            <form:input path="email" name="email" type="text" class="form-control" />
                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            Số điện thoại (<i class="fa fa-asterisk" style="color: red;"></i>)
                            <form:input path="sdt" name="sdt" type="text" class="form-control" />
                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            <span> Địa chỉ  (<i class="fa fa-asterisk" style="color: red;"></i>)</span> <br>
                            <form:textarea path="" name="diaChi" rows="4" cols="50" class="form-control"></form:textarea>
                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            <span>Trạng thái</span>
                            <br>
                            <form:radiobutton path="trangThai"  value="1" checked="true" />    Hoạt động
                            <form:radiobutton path="trangThai"  value="0" style="margin-left:20px;"/>    Ngưng hoạt động
                        </div>
                        <div class="col-lg-8"></div>
                        <div class="col-lg-4 ml-auto" style="margin-top: 20px;">
                            <button class="btn btn-primary"> <i class="menu-icon fa fa-plus"></i> Thêm mới </button>
                            <a href="/nhan-vien/hien-thi" class="btn btn-secondary" style="margin-left: 10px;"> <i class="menu-icon fa fa-undo"></i> Quay lại</a>
                        </div>
                    </form:form>

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
    document.getElementById('dateToday').valueAsDate = new Date();


    function myValidationFormBeforeAdd(){
        console.log("Chạy vào validation");
        let muiGiay = document.getElementById("tenMuiGiay").value;
        let maMuiGiay = document.getElementById("maMuiGiay").value;
        let check=true;

        // kiểm tra mã mũi giày có được nhập không ?
        if(maMuiGiay===null || maMuiGiay.trim()===""){
            document.getElementById("messagemaMuiGiay").innerHTML = "Vui lòng nhập mã";
            return  false;
        }else{
            document.getElementById("messagemaMuiGiay").innerHTML = "";
        }

        // kiem tra size giay - rong, null, ko phai so, trung du lieu
        if(muiGiay===null || muiGiay.trim()===""){
            document.getElementById("messagetenMuiGiay").innerHTML = "Vui lòng nhập mũi giày";
            return  false;
        }else{
            document.getElementById("messagetenMuiGiay").innerHTML = "";
        }

        alert("Dữ liệu bạn nhập hợp lệ, dữ liệu sẽ được cập nhật vào database");

        return check;
    }

</script>

</body>
</html>
