<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/pixeden-stroke-7-icon@1.2.3/pe-icon-7-stroke/dist/pe-icon-7-stroke.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.2.0/css/flag-icon.min.css">
    <link rel="stylesheet" href="/admin/assets/css/cs-skin-elastic.css">
    <link rel="stylesheet" href="/admin/assets/css/style.css">

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>

    <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->
    <style>
        .messageError {
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
                <%--                                <li class="active">Khách hàng</li>--%>
                <%--                            </ol>--%>
                <%--                        </div>--%>
                <%--                    </div>--%>
                <%--                </div>--%>
            </div>
        </div>
    </div>

    <div class="content">
        <div class="animated fadeIn">
            <div class="card col-lg-12">
                <div class="card-header">
                    <div>
                        <strong class="card-title"><h3>Thêm mới nhân viên</h3></strong>
                    </div>

                </div>
                <div class="card-body">
                    <sf:form action="/nhan-vien/them" method="post" modelAttribute="nhanVien" class="row">
                        <div class="col-lg-6">
                            <span>Mã (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                            <sf:input path="ma" type="text" style="margin-top: 5px;" class="form-control"/>
                            <sf:errors path="ma" cssClass="text-danger"/>
                            <c:if test="${trungMa==true}">
                                <p class="text-danger">Mã nhân viên đã có trong hệ thống, vui lòng nhập mã mới</p>
                            </c:if>

                        </div>
                        <div class="col-lg-6">
                            <span>Tên nhân viên(<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                            <sf:input path="hoVaTen" type="text" style="margin-top: 5px;" class="form-control"/>
                            <sf:errors path="hoVaTen" cssClass="text-danger"/>
                            <c:if test="${trungTen==true}">
                                <p class="text-danger">Tên nhân viên đã có trong hệ thống, vui lòng nhập tên mới</p>
                            </c:if>
                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            <span>Giới tính (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                            <sf:radiobutton path="gioiTinh" name="gioiTinh" value="1" checked="true"/> Nam
                            <sf:radiobutton path="gioiTinh" name="gioiTinh" value="0" style="margin-left: 20px"/> Nữ


                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            <span>Tên tài khoản (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                            <sf:input id="taiKhoan" path="taiKhoan" style="margin-top: 5px;" type="text" class="form-control"/>
                            <sf:errors path="taiKhoan"  cssClass="text-danger"/>
                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            <span>Mật khẩu (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                            <sf:input id="matKhau" path="matKhau" style="margin-top: 5px;" type="text" class="form-control"/>
                            <sf:errors path="matKhau"  cssClass="text-danger"/>
                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            <span>Loại nhân viên(<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                           <sf:select path="chucVu.id" name="IdChucVu" class="form-control">
                               <c:forEach items="${dsChucVu}" var="chucVu" varStatus="chucvu">
                                   <sf:option value="${chucVu.id}">${chucVu.ten}</sf:option>
                               </c:forEach>
                           </sf:select>
                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            <span>Ngày sinh (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                            <sf:input id="ngaySinh" path="ngaySinh" style="margin-top: 5px;" type="date" class="form-control"/>
                            <sf:errors path="ngaySinh"  cssClass="text-danger"/>

                        </div>
<%--                        <div class="col-lg-6" style="margin-top: 20px;">--%>
<%--                            <span>Email (<i class="fa fa-asterisk" style="color: red;"></i>)</span>--%>
<%--                            <sf:input id="email" path="email" style="margin-top: 5px;" type="text"--%>
<%--                                      class="form-control"/>--%>
<%--                            <sf:errors path="email" cssClass="text-danger"/>--%>
<%--                            <div th:if =  th:errors="*{email}" class="invalid-feedback"></div>--%>

<%--                        </div>--%>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            <span>Số điện thoại (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                            <sf:input id="sdt" path="sdt" style="margin-top: 5px;" type="text" class="form-control"/>
                            <sf:errors path="sdt"  cssClass="text-danger"/>
                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            <span>Địa chỉ (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                            <sf:textarea id="diaChi" path="diaChi" style="margin-top: 5px;" type="text" class="form-control"/>
                            <sf:errors path="diaChi"  cssClass="text-danger"/>
                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            <span>Trạng thái (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                            <sf:radiobutton path="trangThai" name="trangThai" value="1" checked="true"/> Hoạt động
                            <sf:radiobutton path="trangThai" name="trangThai" value="0" style="margin-left: 20px"/>  Ngừng hoạt động
                        </div>

                        <div class="col-lg-8" style="margin-top: 20px;">
                            <c:if test="${messageSuccess==true}">
                                <%--                                style="z-index: 9999; position: fixed; top: 10px; right: 10px; width: 350px;"--%>
                                <div id="messageAlertSuccess" class="alert alert-primary alert-dismissible "
                                     style="width: 300px;">

                                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                                    <i class="menu-icon fa fa-check"></i> Thêm mới dữ liệu thành công!
                                </div>

                                <script>
                                    // Lấy thẻ alert
                                    var alert = document.getElementById('messageAlertSuccess');

                                    // Ẩn thẻ alert sau 3 giây
                                    setTimeout(function () {
                                        alert.style.display = 'none';
                                    }, 3000); // 3000 milliseconds tương ứng với 3 giây
                                </script>
                            </c:if>
                        </div>
                        <div class="col-lg-4" style="margin-top: 20px; ">
                            <button class="btn btn-success"><i class="menu-icon fa fa-plus"></i> </a> Thêm mới</button>
                            <a href="/nhan-vien/hien-thi" class="btn btn-secondary" style="margin-left: 10px;"> <i
                                    class="menu-icon fa fa-undo"></i> Quay lại</a>
                        </div>
                    </sf:form>
                </div>
            </div>
        </div><!-- .animated -->
    </div><!-- .content -->

    <div class="content" style="margin-top: -55px;">
        <div class="animated fadeIn">
            <div class="card col-lg-12">
                <div class="card-header">
                    <div class="row">
                        <div class="col-lg-10">
                            <strong class="card-title"><h3>Danh sách nhân viên</h3></strong>
                        </div>
                    </div>
                    <br>
                    <form action="/nhan-vien/hien-thi" method="get">
                        <div class="row d-flex" style=" margin-left: 3px;">
                            <input class="form-control col-lg-4" id="textsearch" name="textsearch" type="text"
                                   placeholder="(Tìm kiếm theo mã, tên)">
                            <span style="margin: 0px 5px;"></span>
                            <button class="btn btn-secondary" type="submit"><i class="menu-icon fa fa-search"></i>
                                Tìm kiếm
                            </button>
                        </div>
                    </form>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover no-wrap">
                            <thead>
                            <tr style="text-align: center;">
                                <th scope="col">STT</th>
                                <th scope="col">Mã</th>
                                <th scope="col">Họ & Tên</th>
                                <th scope="col">Giới tính</th>
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
                                    <td > ${nhanVien.ma}</td>
                                    <td > ${nhanVien.hoVaTen}</td>
                                    <td > ${nhanVien.gioiTinh==0?"Nữ":"Nam"}</td>
                                    <td > ${nhanVien.chucVu.ten}</td>
                                    <td > ${nhanVien.sdt}</td>
<%--                                    <td > ${nhanVien.ngaySinh}</td>--%>
                                    <td >
                                        <fmt:formatDate value="${nhanVien.ngaySinh}" pattern="yyyy-MM-dd"/>
                                    </td>
                                    <td > ${nhanVien.diaChi}</td>
                                    <td >${nhanVien.trangThai==1?'Hoạt động':'Ngừng hoạt động'}</td>
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
                        <div class="col-lg-8" style="text-align: center;">
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


    function myValidationFormBeforeAdd() {
        console.log("Chạy vào validation");
        let tenNhanVien = document.getElementById("tenNhanVien").value;
        let maNhanVien = document.getElementById("maNhanVien").value;
        let check = true;

        // kiểm tra mã khách hàng có được nhập không ?
        if (maNhanVien === null || maNhanVien.trim() === "") {
            document.getElementById("messagemaNhanVien").innerHTML = "Vui lòng nhập mã nhân viên";
            return false;
        } else {
            document.getElementById("messagemaNhanVien").innerHTML = "";
        }

        // kiem tra ten khach, null, ko phai so, trung du lieu
        if (tenNhanVien === null || tenNhanVien.trim() === "") {
            document.getElementById("messagetenNhanVien").innerHTML = "Vui lòng nhập tên nhân viên";
            return false;
        } else {
            document.getElementById("messagetenNhanVien").innerHTML = "";
        }

        alert("Dữ liệu bạn nhập hợp lệ, dữ liệu sẽ được cập nhật vào database");

        return check;
    }
</script>
</body>
</html>
