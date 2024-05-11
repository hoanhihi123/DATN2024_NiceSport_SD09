<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Quản lý địa chỉ </title>
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


    <div class="content" style="margin-top: 0px;">
        <div class="animated fadeIn">
            <div class="card col-lg-12">
                <div class="card-header">
                    <div class="row">
                        <div class="col-lg-9">
                            <strong class="card-title" ><h3>Danh sách địa chỉ</h3></strong>
                        </div>
                        <div class="col-lg-3">
                            <a href="#formThemMoiDiaChi" class="btn btn-primary" > <i class="menu-icon fa fa-plus"></i> Thêm mới địa chỉ </a>
                        </div>
                    </div>
                    <br>
                    <form action="/dia-chi/hien-thi" method="get">
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
                                <th scope="col">STT</th>
                                <th scope="col">Tên khách hàng</th>
                                <th scope="col">Mã</th>
                                <th scope="col">Tên địa chỉ</th>
                                <th scope="col">Mô tả</th>
                                <th scope="col">Thành phố</th>
                                <th scope="col">Huyện</th>
                                <th scope="col">Xã</th>
                                <th scope="col">Trạng thái</th>
                                <th scope="col" colspan="2" >Tác động</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${dsDiaChi}" var="diaChi" varStatus="diachi">
                                <tr>
                                    <th scope="row">${diachi.index + 1}</th>
                                    <td > ${diaChi.khachHang.ten}</td>
                                    <td > ${diaChi.ma}</td>
                                    <td > ${diaChi.ten}</td>
                                    <td > ${diaChi.moTa}</td>
                                    <td > ${diaChi.thanhPho}</td>
                                    <td > ${diaChi.huyen}</td>
                                    <td > ${diaChi.xa}</td>
                                    <td >${diaChi.trangThai==1?'Hoạt động':'Ngưng hoạt động'}</td>
                                    <td > <a href="/dia-chi/view-sua/${diaChi.id}" class="btn btn-success">Xem <i class="menu-icon fa fa-pencil-square-o" ></i></a> </td>
                                    <td > <a href="/dia-chi/xoa/${diaChi.id}" class="btn btn-warning"
                                             onclick="return confirm('Bạn chắc chắn muốn xóa nhân viên ${diaChi.ten} ?')"><i class="menu-icon fa fa-trash-o"></i> Xóa </a> </td>
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
                                                <a class="page-link" href="/dia-chi/hien-thi?${pageChoosedNumber-1}" tabindex="-1" aria-disabled="true">Previous</a>
                                            </li>
                                        </c:if>

                                        <c:forEach begin="0" end="${totalPage - 1}" varStatus="loop">
                                            <c:choose>
                                                <c:when test="${pageChoosedNumber==loop.index}">
                                                    <li class="page-item active" aria-current="page" >
                                                        <a name="page" class="page-link"   href="/dia-chi/hien-thi?page=${loop.index}">${loop.index + 1}</a>
                                                    </li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li class="page-item" aria-current="page">
                                                        <a name="page" class="page-link" href="/dia-chi/hien-thi?page=${loop.index}">${loop.index + 1}</a>
                                                    </li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                        <c:if test= "${pageChoosedNumber < (totalPage-1)}">
                                            <li class="page-item">
                                                <a class="page-link" href="/dia-chi/hien-thi?page=${pageChoosedNumber + 1}">Next</a>
                                            </li>
                                        </c:if>

                                    </ul>
                                </c:if>
                            </nav>
                        </div>
                    </div>

                    <span id="formThemMoiDiaChi" style="margin-top: -40px; margin-bottom: 40px;"></span>

                </div>
            </div>
        </div><!-- .animated -->
    </div><!-- .content -->

    <div class="content" style="margin-top: -50px;" >
        <div class="animated fadeIn">
            <div class="card col-lg-12">
                <div class="card-header" >
                    <div>
                        <strong class="card-title"  ><h3>Thêm mới địa chỉ</h3></strong>
                    </div>
                </div>
                <div class="card-body">
                    <form:form action="/dia-chi/them" method="post" modelAttribute="diaChi" class="row">
                        <div class="col-lg-6" style="margin-top: 20px;">
                            Tên khách hàng (<i class="fa fa-asterisk" style="color: red;"></i>)
                            <form:select path="khachHang" name="IdKhachHang" class="form-control">
                                <c:forEach items="${dsKhachHang}" var="khachHang" varStatus="khachhang">
                                    <form:option value="${khachHang.id}">${khachHang.ten}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            Mã địa chỉ (<i class="fa fa-asterisk" style="color: red;"></i>)
                            <form:input path="ma" name="ma" type="text" class="form-control" />
                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            Tên địa chỉ (<i class="fa fa-asterisk" style="color: red;"></i>)
                            <form:input path="ten" name="ten" type="text" class="form-control" />
                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            <span>Mô Tả  (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                            <form:input path="moTa" name="moTa" type="text" class="form-control" />
                        </div>

                        <div class="col-lg-6" style="margin-top: 20px;">
                            Thành Phố (<i class="fa fa-asterisk" style="color: red;"></i>)
                            <form:input path="thanhPho" name="thanhPho" type="text" class="form-control"/>
                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            Huyện (<i class="fa fa-asterisk" style="color: red;"></i>)
                            <form:input path="huyen" name="huyen" type="text" class="form-control" />
                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            Xã (<i class="fa fa-asterisk" style="color: red;"></i>)
                            <form:input path="xa" name="xa" type="text" class="form-control" />
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
                            <a href="/dia-chi/hien-thi" class="btn btn-secondary" style="margin-left: 10px;"> <i class="menu-icon fa fa-undo"></i> Quay lại</a>
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
