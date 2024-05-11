`
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!doctype html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Quản lý giảm giá </title>
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

    <%--    <div class="breadcrumbs">--%>
    <%--        <div class="breadcrumbs-inner">--%>
    <%--            <div class="row m-0">--%>
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
    <%--                                <li class="active">Chất liệu</li>--%>
    <%--                            </ol>--%>
    <%--                        </div>--%>
    <%--                    </div>--%>
    <%--                </div>--%>
    <%--            </div>--%>
    <%--        </div>--%>
    <%--    </div>--%>

    <div class="content">
        <div class="animated fadeIn">
            <div class="card col-lg-12">
                <div class="card-header">
                    <div>
                        <strong class="card-title"><h3>Thêm mới giảm giá</h3></strong>
                    </div>

                </div>
                <div class="card-body">
                    <form action="/giam-gia/hien-thi" method="get">
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
            </div>
        </div><!-- .animated -->
    </div><!-- .content -->

    <div class="content" >
        <div class="animated fadeIn">
            <div class="card col-lg-12">
                <div class="card-header">
                    <div class="row">
                        <div class="col-lg-10">
                            <strong class="card-title"><h3>Danh sách giảm giá</h3></strong>
                        </div>
                    </div>

                    <div>
                        <div style="text-align: right; margin-right: 100px; margin-top: 3px;">
                            <button type="button" class="btn btn-success" data-toggle="modal"
                                    data-target="#createDiscountModal">Thêm mã giảm giá
                            </button>
                        </div>
                    </div>

                    <div class="modal fade" id="createDiscountModal" tabindex="-1" role="dialog"
                         aria-labelledby="createDiscountModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title" id="createDiscountModalLabel">Thêm mã giảm giá</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form action="/giam-gia/them" method="post" modelAttribute="giamGia">
                                        <div class="form-group">
                                            <label for="maKhuyenMai">Mã giảm giá:</label>
                                            <input type="text" class="form-control" id="maKhuyenMai" name="ma" required>
                                            <c:if test="${!empty trungMa}">
                                                <p class="text-danger">Mã giảm giá đã tồn tại. Vui lòng chọn mã khác.</p>
                                            </c:if>
                                        </div>
                                        <div class="form-group">
                                            <label for="tenKhuyenMai">Tên giảm giá:</label>
                                            <input type="text" class="form-control" id="tenKhuyenMai" name="ten" required>
                                            <c:if test="${!empty trungTen}">
                                                <p class="text-danger">Tên giảm giá đã tồn tại. Vui lòng chọn tên khác.</p>
                                            </c:if>
                                        </div>
<%--                                        <div class="form-group">--%>
<%--                                            <label for="selectSanPham">Tên sản phẩm:</label>--%>
<%--                                            <select class="form-control" id="selectSanPham" name="idSanPham" required>--%>
<%--                                                <c:forEach items="${dsSanPham}" var="sanPham">--%>
<%--                                                    <option value="${sanPham.id}">${sanPham.ten}</option>--%>
<%--                                                </c:forEach>--%>
<%--                                            </select>--%>
<%--                                        </div>--%>

                                        <div class="form-group">
                                            <label for="giaTriGiam">Giá trị giảm:</label>
                                            <input type="number" class="form-control" id="giaTriGiam" name="giaTriGiam" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="ngayBatDau">Ngày bắt đầu:</label>
                                            <input type="date" class="form-control" id="ngayBatDau" name="ngayBatDau" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="ngayKetThuc">Ngày kết thúc:</label>
                                            <input type="date" class="form-control" id="ngayKetThuc" name="ngayKetThuc" required>
                                        </div>
                                        <div style="text-align: right;">
                                            <button type="submit" class="btn btn-primary">Áp dụng</button>
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered table-hover no-wrap">
                    <thead>
                    <tr style="text-align: center;">
                        <th scope="col">STT</th>
                        <th scope="col">Mã</th>
                        <th scope="col">Tên giảm giá</th>
<%--                        <th scope="col">Tên sản phẩm</th>--%>
                        <th scope="col">Giá trị giảm</th>
                        <th scope="col">Ngày bắt đầu</th>
                        <th scope="col">Ngày kết thúc</th>
                        <th scope="col">Trạng thái</th>
                        <th scope="col" colspan="2">Tác động</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${dsGiamGia}" var="giamGia" varStatus="giamgia">
                        <tr>
                            <th scope="row">${giamgia.index +1}</th>
                            <td> ${giamGia.ma}</td>
                            <td> ${giamGia.ten}</td>
<%--                            <td> ${giamGia.idSanPham.ten}</td>--%>
                            <td> ${giamGia.giaTriGiam}</td>
                            <td> ${giamGia.ngayBatDau}</td>
                            <td> ${giamGia.ngayKetThuc}</td>
                            <td> ${giamGia.trangThai == 1 ? 'Hoạt động': 'Ngưng hoạt động'}</td>
                            <td><a href="/giam-gia/view-sua/${giamGia.id}" class="btn btn-success"> Xem <i
                                    class="menu-icon fa fa-pencil-square-o"></i> </a></td>
                            <td><a href="/giam-gia/xoa/${giamGia.id}" class="btn btn-warning"
                                   onclick="return confirm('Bạn chắc chắn muốn xóa  ${giamGia.ten} ?')">
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
                                        <a class="page-link" href="/giam-gia/hien-thi?${pageChoosedNumber-1}"
                                           tabindex="-1" aria-disabled="true">Previous</a>
                                    </li>
                                </c:if>

                                <c:forEach begin="0" end="${totalPage - 1}" varStatus="loop">
                                    <c:choose>
                                        <c:when test="${pageChoosedNumber==loop.index}">
                                            <li class="page-item active" aria-current="page">
                                                <a name="page" class="page-link"
                                                   href="/giam-gia/hien-thi?page=${loop.index}">${loop.index + 1}</a>
                                            </li>
                                        </c:when>
                                        <c:otherwise>
                                            <li class="page-item" aria-current="page">
                                                <a name="page" class="page-link"
                                                   href="/giam-gia/hien-thi?page=${loop.index}">${loop.index + 1}</a>
                                            </li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                                <c:if test="${pageChoosedNumber < (totalPage-1)}">
                                    <li class="page-item">
                                        <a class="page-link"
                                           href="/giam-gia/hien-thi?page=${pageChoosedNumber+1}">Next</a>
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
    function submitForm() {
        var ma = document.getElementById("maKhuyenMai").value;
        var ten = document.getElementById("tenKhuyenMai").value;

        // Kiểm tra xem mã và tên có trống không
        if (ma.trim() === "") {
            document.getElementById("maError").innerText = "Mã không được để trống";
            return;
        } else {
            document.getElementById("maError").innerText = "";
        }

        if (ten.trim() === "") {
            document.getElementById("tenError").innerText = "Tên không được để trống";
            return;
        } else {
            document.getElementById("tenError").innerText = "";
        }

        // Kiểm tra trùng lặp với mã và tên đã tồn tại
        // Gửi yêu cầu Ajax để kiểm tra trùng lặp và xử lý kết quả

        // Nếu không có lỗi, gửi yêu cầu lên server
        document.getElementById("form").submit();
    }
</script>

</body>
</html>
