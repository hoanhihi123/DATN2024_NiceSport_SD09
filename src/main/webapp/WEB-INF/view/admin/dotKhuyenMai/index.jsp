<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Quản lý đợt khuyến mãi </title>
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
    <div class="content" style="margin-top: -55px;">
        <div class="animated fadeIn">
            <div class="card col-lg-12">
                <div class="card-header">
                    <div class="row">
                        <div class="col-lg-10" style="margin-top: 20px;">
                            <strong class="card-title">
                                <h3>Danh sách đợt khuyến mãi</h3>
                            </strong>
                        </div>
                    </div>
                    <br>
                    <div class="card-header">
                        <div class="row">
                            <div class="col-lg-6">
                                <form action="/dot-khuyen-mai/hien-thi" method="get">
                                    <div class="form-group">
                                        <input class="form-control" id="textsearch" name="textsearch" type="text"
                                               placeholder="(mã hoặc tên)">
                                    </div>
                                </form>
                            </div>
                            <div style="margin-right: 20px; text-align: right;">
                                <a href="/dot-khuyen-mai/view-add" class="btn btn-primary">Thêm mã giảm giá</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%--                <div class="modal fade" id="createDiscountModal" tabindex="-1" role="dialog" aria-labelledby="createDiscountModalLabel" aria-hidden="true">--%>
                <%--                    <div class="modal-dialog" role="document">--%>
                <%--                        <div class="modal-content">--%>
                <%--                            <div class="modal-header">--%>
                <%--                                <h4 class="modal-title" id="createDiscountModalLabel">Thêm mã giảm giá</h4>--%>
                <%--                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
                <%--                                    <span aria-hidden="true">&times;</span>--%>
                <%--                                </button>--%>
                <%--                            </div>--%>
                <%--                            <div class="modal-body">--%>
                <%--                                <form action="/dot-khuyen-mai/them" method="post" modelAttribute="giamGia">--%>
                <%--                                    <div class="form-group">--%>
                <%--                                        <label for="maKhuyenMai">Mã giảm giá:</label>--%>
                <%--                                        <input type="text" class="form-control" id="maKhuyenMai" name="ma" required>--%>
                <%--                                        <c:if test="${!empty trungMa}">--%>
                <%--                                            <p class="text-danger">Mã giảm giá đã tồn tại. Vui lòng chọn mã khác.</p>--%>
                <%--                                        </c:if>--%>
                <%--                                    </div>--%>
                <%--                                    <div class="form-group">--%>
                <%--                                        <label for="tenKhuyenMai">Tên giảm giá:</label>--%>
                <%--                                        <input type="text" class="form-control" id="tenKhuyenMai" name="ten" required>--%>
                <%--                                        <c:if test="${!empty trungTen}">--%>
                <%--                                            <p class="text-danger">Tên giảm giá đã tồn tại. Vui lòng chọn tên khác.</p>--%>
                <%--                                        </c:if>--%>
                <%--                                    </div>--%>
                <%--                                    <div class="form-group">--%>
                <%--                                        <label for="giaTriGiam">Giá trị giảm:</label>--%>
                <%--                                        <input type="number" class="form-control" id="giaTriGiam" name="giaTriGiam" required>--%>
                <%--                                    </div>--%>
                <%--                                    <div class="form-group">--%>
                <%--                                        <label for="ngayBatDau">Ngày bắt đầu:</label>--%>
                <%--                                        <input type="datetime-local" class="form-control" id="ngayBatDau" name="ngayBatDau" required>--%>
                <%--                                    </div>--%>
                <%--                                    <div class="form-group">--%>
                <%--                                        <label for="ngayKetThuc">Ngày kết thúc:</label>--%>
                <%--                                        <input type="datetime-local" class="form-control" id="ngayKetThuc" name="ngayKetThuc" required>--%>
                <%--                                    </div>--%>
                <%--                                    <div style="text-align: right;">--%>
                <%--                                        <button type="submit" class="btn btn-primary">Áp dụng</button>--%>
                <%--                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>--%>
                <%--                                    </div>--%>
                <%--                                </form>--%>
                <%--                            </div>--%>
                <%--                        </div>--%>
                <%--                    </div>--%>
                <%--                </div>--%>

                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover no-wrap">
                            <thead>
                            <tr style="text-align: center;">
                                <th scope="col">STT</th>
                                <th scope="col">Mã</th>
                                <th scope="col">Tên giảm giá</th>
                                <th scope="col">Giá trị giảm</th>
                                <th scope="col">Ngày bắt đầu</th>
                                <th scope="col">Ngày kết thúc</th>
                                <th scope="col">Trạng thái</th>
                                <th scope="col" colspan="2">Tác động</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${dsDotKhuyenMai}" var="dotKhuyenMai" varStatus="km">
                                <tr>
                                    <th scope="row">${km.index +1}</th>
                                    <td>${dotKhuyenMai.ma}</td>
                                    <td>${dotKhuyenMai.ten}</td>
                                    <td><fmt:formatNumber value="${dotKhuyenMai.giaTriGiam}" pattern="#,##0"/></td>
                                    <td><fmt:formatDate value="${dotKhuyenMai.ngayBatDau}"
                                                        pattern="dd/MM/yyyy HH:mm:ss"/></td>
                                    <td><fmt:formatDate value="${dotKhuyenMai.ngayKetThuc}"
                                                        pattern="dd/MM/yyyy HH:mm:ss"/></td>
                                    <td>${dotKhuyenMai.trangThai == 1 ? 'Hoạt động' : 'Ngưng hoạt động'}</td>
                                    <td><a href="/dot-khuyen-mai/view-sua/${dotKhuyenMai.id}" class="btn btn-success"> Xem <i
                                            class="menu-icon fa fa-pencil-square-o"></i> </a></td>
                                    <td><a href="/dot-khuyen-mai/xoa/${dotKhuyenMai.id}" class="btn btn-warning"
                                           onclick="return confirm('Bạn chắc chắn muốn xóa  ${dotKhuyenMai.ma} ?')">
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
                                                <a class="page-link"
                                                   href="/dot-khuyen-mai/hien-thi?${pageChoosedNumber-1}"
                                                   tabindex="-1" aria-disabled="true">Previous</a>
                                            </li>
                                        </c:if>
                                        <c:forEach begin="0" end="${totalPage - 1}" varStatus="loop">
                                            <c:choose>
                                                <c:when test="${pageChoosedNumber==loop.index}">
                                                    <li class="page-item active" aria-current="page">
                                                        <a name="page" class="page-link"
                                                           href="/dot-khuyen-mai/hien-thi?page=${loop.index}">${loop.index + 1}</a>
                                                    </li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li class="page-item" aria-current="page">
                                                        <a name="page" class="page-link"
                                                           href="/dot-khuyen-mai/hien-thi?page=${loop.index}">${loop.index + 1}</a>
                                                    </li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                        <c:if test="${pageChoosedNumber < (totalPage-1)}">
                                            <li class="page-item">
                                                <a class="page-link"
                                                   href="/dot-khuyen-mai/hien-thi?page=${pageChoosedNumber+1}">Next</a>
                                            </li>
                                        </c:if>
                                    </ul>
                                </c:if>
                            </nav>
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
        document.addEventListener('DOMContentLoaded', function() {
            document.querySelector('form').addEventListener('submit', function(event) {
                // Lấy ra các trường input ngày giờ
                const ngayBatDauInput = document.getElementById('ngayBatDau');
                const ngayKetThucInput = document.getElementById('ngayKetThuc');

                // Kiểm tra xem trường ngày giờ có giá trị không rỗng
                if (ngayBatDauInput.value && ngayKetThucInput.value) {
                    // Tạo đối tượng Date từ chuỗi đầu vào
                    const ngayBatDauDate = new Date(ngayBatDauInput.value);
                    const ngayKetThucDate = new Date(ngayKetThucInput.value);

                    // Định dạng ngày giờ thành chuỗi dạng yyyy-MM-ddTHH:mm:ss
                    ngayBatDauInput.value = formatDateToISOString(ngayBatDauDate);
                    ngayKetThucInput.value = formatDateToISOString(ngayKetThucDate);
                }
            });
        });

        // Hàm để định dạng ngày giờ thành chuỗi dạng yyyy-MM-ddTHH:mm:ss
        function formatDateToISOString(date) {
            const year = date.getFullYear();
            const month = (date.getMonth() + 1).toString().padStart(2, '0');
            const day = date.getDate().toString().padStart(2, '0');
            const hours = date.getHours().toString().padStart(2, '0');
            const minutes = date.getMinutes().toString().padStart(2, '0');
            const seconds = date.getSeconds().toString().padStart(2, '0');
            return `${year}-${month}-${day}T${hours}:${minutes}:${seconds}`;
        }

    </script>
</body>

</html>
