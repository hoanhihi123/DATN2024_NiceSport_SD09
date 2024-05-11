<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!doctype html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Quản lý dây giày </title>
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
<%--                                <li class="active">Dây Giày</li>--%>
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
                        <strong class="card-title"><h3>Thêm mới dây giày</h3></strong>
                    </div>

                </div>
                <div class="card-body">
                    <sf:form action="/day-giay/them" method="post" modelAttribute="dayGiay" class="row">
                        <div class="col-lg-6">
                            <span>Mã (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                            <sf:input path="ma" type="text" style="margin-top: 5px;" class="form-control"/>
                            <sf:errors path="ma" cssClass="text-danger"/>
                            <c:if test="${trungMa==true}">
                                <p class="text-danger">Mã dây giày đã có trong hệ thống, vui lòng nhập mã mới</p>
                            </c:if>
                        </div>
                        <div class="col-lg-6">
                            <span>Tên dây giày(<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                            <sf:input path="ten" type="text" style="margin-top: 5px;" class="form-control"/>
                            <sf:errors path="ten" cssClass="text-danger"/>
                            <c:if test="${trungTen==true}">
                                <p class="text-danger">Tên chức vụ đã có trong hệ thống, vui lòng nhập tên mới</p>
                            </c:if>
                        </div>
                                                <div class="col-lg-6" style="margin-top: 20px;">
                                                    <span>Mô tả (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                                                    <sf:input id="moTa" path="moTa" style="margin-top: 5px;" type="text" class="form-control"/>
                                                    <sf:errors path="moTa" cssClass="text-danger"/>

                                                </div>

                        <div class="col-lg-6" style="margin-top: 20px;">
                            <span>Trạng thái (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                            <br>
                            <sf:radiobutton path="trangThai" value="1" checked="true"/> Hoạt động
                            <sf:radiobutton path="trangThai" value="0"/> Ngưng hoạt động
                            <sf:errors path="trangThai" cssClass="text-danger"/>

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
                            <a href="/day-giay/hien-thi" class="btn btn-secondary" style="margin-left: 10px;"> <i
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
                            <strong class="card-title"><h3>Danh sách dây giày</h3></strong>
                        </div>
                    </div>
                    <br>
                    <form action="/day-giay/hien-thi" method="get">
                        <div class="row d-flex" style=" margin-left: 3px;">
                            <input class="form-control col-lg-4" id="textsearch" name="textsearch" type="text"
                                   placeholder="(Tìm kiếm theo tên, mô tả)">
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
                                <%--                                <th scope="col">ID</th>--%>
                                <th scope="col">STT</th>
                                <th scope="col">Mã</th>
                                <th scope="col">Tên</th>
                                    <th scope="col">Mô tả</th>
                                <th scope="col">Ngày tạo</th>
                                <th scope="col">Ngày sửa</th>
                                <th scope="col">Trạng thái</th>
                                <th scope="col" colspan="2">Tác động</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${dsDayGiay}" var="dayGiay" varStatus="daygiay">
                                <tr>
                                    <th scope="row">${daygiay.index +1}</th>
                                    <td> ${dayGiay.ma}</td>
                                    <td> ${dayGiay.ten}</td>
                                    <td> ${dayGiay.moTa}</td>
                                    <td> ${dayGiay.ngayTao}</td>
                                    <td> ${dayGiay.ngaySua}</td>
                                    <td> ${dayGiay.trangThai == 1 ? 'Hoạt động': 'Ngưng hoạt động'}</td>
                                    <td><a href="/day-giay/view-sua/${dayGiay.id}" class="btn btn-success"> Xem <i
                                            class="menu-icon fa fa-pencil-square-o"></i> </a></td>
                                    <td><a href="/day-giay/xoa/${dayGiay.id}" class="btn btn-warning"
                                           onclick="return confirm('Bạn chắc chắn muốn xóa chức vụ ${dayGiay.ten} ?')">
                                        <i class="menu-icon fa fa-trash-o"></i> Xóa</a></td>
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
                                                <a class="page-link" href="/day-giay/hien-thi?${pageChoosedNumber-1}"
                                                   tabindex="-1" aria-disabled="true">Previous</a>
                                            </li>
                                        </c:if>

                                        <c:forEach begin="0" end="${totalPage - 1}" varStatus="loop">
                                            <c:choose>
                                                <c:when test="${pageChoosedNumber==loop.index}">
                                                    <li class="page-item active" aria-current="page">
                                                        <a name="page" class="page-link"
                                                           href="/day-giay/hien-thi?page=${loop.index}">${loop.index + 1}</a>
                                                    </li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li class="page-item" aria-current="page">
                                                        <a name="page" class="page-link"
                                                           href="/day-giay/hien-thi?page=${loop.index}">${loop.index + 1}</a>
                                                    </li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                        <c:if test="${pageChoosedNumber < (totalPage-1)}">
                                            <li class="page-item">
                                                <a class="page-link"
                                                   href="/day-giay/hien-thi?page=${pageChoosedNumber+1}">Next</a>
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
        let tenDayGiay = document.getElementById("tenDayGiay").value;
        let maDayGiay = document.getElementById("maDayGiay").value;
        let check = true;

        // kiểm tra mã chất liệu có được nhập không ?
        if (maDayGiay === null || maDayGiay.trim() === "") {
            document.getElementById("messagemaDayGiay").innerHTML = "Vui lòng nhập mã";
            return false;
        } else {
            document.getElementById("messagemaDayGiay").innerHTML = "";
        }

        // kiem tra size giay - rong, null, ko phai so, trung du lieu
        if (tenDayGiay === null || tenDayGiay.trim() === "") {
            document.getElementById("messagemaDayGiay").innerHTML = "Vui lòng nhập dây giày";
            return false;
        } else {
            document.getElementById("messagemaDayGiay").innerHTML = "";
        }

        alert("Dữ liệu bạn nhập hợp lệ, dữ liệu sẽ được cập nhật vào database");

        return check;
    }
</script>
</body>
</html>
