<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!doctype html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Sửa thông tin địa chỉ</title>
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
<%--                                <li><a href="#">Quản lý địa chỉ</a></li>--%>
<%--                                <li class="active">Sửa thông tin địa chỉ</li>--%>
<%--                            </ol>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
            </div>
        </div>
    </div>

    <div class="content" style="margin-bottom: 50px;">
        <div class="animated fadeIn">
            <div class="card col-lg-12">
                <div class="card-header">
                    <div>
                        <strong class="card-title" ><h3>Sửa thông tin địa chỉ</h3></strong>
                    </div>

                </div>
                <div class="card-body">
                    <sf:form action="/dia-chi/sua/${diaChi.id}" method="post" modelAttribute="diaChi" class="row">
                        <div class="col-lg-6" style="margin-top: 20px;">
                            Tên khách hàng (<i class="fa fa-asterisk" style="color: red;"></i>)
                            <sf:select path="khachHang.id" name="IdKhachHang" class="form-control">
                                <c:forEach items="${dsKhachHang}" var="khachHang" varStatus="chucvu">
                                    <option <c:if test="${diaChi.khachHang.id == khachHang.id}">selected="selected"</c:if>   value="${khachHang.id}" >${khachHang.ten}</option>
                                </c:forEach>
                            </sf:select>
                            <sf:errors path="khachHang.id" cssClass="text-danger" />
                        </div>

                        <div class="col-lg-6" style="margin-top: 20px;">
                            Mã địa chỉ (<i class="fa fa-asterisk" style="color: red;"></i>)
                            <sf:input path="ma" name="ma" type="text" class="form-control" />
                            <sf:errors path="ma" cssClass="text-danger" />

                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            Tên địa chỉ (<i class="fa fa-asterisk" style="color: red;"></i>)
                            <sf:input path="ten" name="ten" type="text" class="form-control" />
                            <sf:errors path="ten" cssClass="text-danger" />
                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            Mô tả (<i class="fa fa-asterisk" style="color: red;"></i>)
                            <sf:input path="moTa" name="moTa" type="text" class="form-control" />
                            <sf:errors path="moTa" cssClass="text-danger" />
                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            Thành Phố (<i class="fa fa-asterisk" style="color: red;"></i>)
                            <sf:input path="thanhPho" name="thanhPho" type="text" class="form-control" />
                            <sf:errors path="thanhPho" cssClass="text-danger" />
                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            Huyện (<i class="fa fa-asterisk" style="color: red;"></i>)
                            <sf:input path="huyen" name="huyen" type="text" class="form-control" />
                            <sf:errors path="huyen" cssClass="text-danger" />
                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            Xã (<i class="fa fa-asterisk" style="color: red;"></i>)
                            <sf:input path="xa" name="xa" type="text" class="form-control" />
                            <sf:errors path="xa" cssClass="text-danger" />
                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            <span>Trạng thái</span>
                            <br>
                            <sf:radiobutton path="trangThai"  value="1" checked="true" />    Hoạt động
                            <sf:radiobutton path="trangThai"  value="0" style="margin-left:20px;"/>    Ngưng hoạt động
                            <sf:errors path="trangThai" cssClass="text-danger" />
                        </div>

                        <div class="col-lg-9" style="margin-top: 20px;"  >
                            <c:if test="${messageSuccess==true}">
                                <div id="messageAlertSuccess" class="alert alert-primary alert-dismissible "  style="width: 300px;" >

                                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                                    <i class="menu-icon fa fa-check"></i> Sửa dữ liệu thành công !
                                </div>

                                <script>
                                    // Lấy thẻ alert
                                    var alert = document.getElementById('messageAlertSuccess');

                                    // Ẩn thẻ alert sau 3 giây
                                    setTimeout(function() {
                                        alert.style.display = 'none';
                                    }, 3000); // 3000 milliseconds tương ứng với 3 giây
                                </script>
                            </c:if>
                        </div>
                        <div class="col-lg-3 ml-auto" style="margin-top: 20px;">
                            <button class="btn btn-success" > <i class="menu-icon fa fa-pencil-square-o"></i></a>  Sửa </button>
                            <a href="/dia-chi/hien-thi" class="btn btn-secondary"> <i class="menu-icon fa fa-undo"></i> Quay lại</a>
                        </div>
                    </sf:form>

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
