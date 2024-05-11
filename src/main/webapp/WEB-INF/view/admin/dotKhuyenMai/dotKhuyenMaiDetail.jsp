<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
          integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>

    <title>Quản lý đợt giảm giá</title>
    <style>

        /* Disable horizontal scrollbar */
        /*body, html {*/
        /*    overflow-x: hidden;*/
        /*    width: 100%;*/
        /*}*/

        /*!* Set maximum width for content *!*/
        /*.container {*/
        /*    max-width: 1200px; !* Adjust this value as needed *!*/
        /*    margin: 0 auto; !* Center content horizontally *!*/
        /*    padding: 20px; !* Add some padding around content *!*/
        /*}*/

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        input.form-input {
            width: 360%;
            border-radius: 6px;
            outline: none;
            border: 1px solid #1a1818;
            padding: 5px 10px;
        }

        label {
            width: 120px;
            margin-right: 5px;
        }

        .pagination-container {
            position: absolute;
            right: 0;
            margin-right: 100px; /* Khoảng cách so với bên phải */
        }

        .pagination-container ul {
            margin: 0;
            padding: 0;
            list-style: none;
        }

        .pagination-container li {
            display: inline-block;
            margin-left: 5px; /* Khoảng cách giữa các nút phân trang */
        }

        .pagination-container a {
            display: inline-block;
            padding: 5px 10px;
            border: 1px solid #ccc;
            text-decoration: none;
            color: #333;
        }

        .pagination-container a:hover {
            background-color: #f0f0f0;
        }

        .pagination-container .active a {
            background-color: #007bff;
            color: #fff;
            border-color: #007bff;
        }

        .custom-table {
            padding: 30px;
            margin-top: 15px;
            width: 95%;
            margin-left: 30px;
        }

    </style>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

<div style="display: flex; align-items: center;margin-top: 20px; margin-left: 20px;">
    <div style="margin: 10px;">
        <i class="fa-solid fa-filter" style="transform: scale(1.3,1.3);"></i>
    </div>
    <div>
        <h3 style="margin-top: 4px;">Bộ lọc</h3>
    </div>
</div>
<p style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid rgba(0, 0, 0, 0.1);"></p>

<div>
    <sf:form action="/dot-khuyen-mai/sua/${dotKhuyenMai.id}" method="post" modelAttribute="dotKhuyenMai" class="row">
    <!-- Phần xem chi tiết mã -->
    <div style="display: flex; justify-content: space-around;background-color: azure;">
        <div class="col-3"
             style="border: 1px solid #CCC;padding: 20px;border-radius: 14px;width: 30% !important; margin-top: 20px; margin-left:20px;">
            <h4 style="text-align: center;margin-right: 10px;">Thêm đợt giảm giá</h4><br>
            <div style="margin-left: 20px;">
                <div class="col-3 mb-4">
                    <label for="maKhuyenMai">Mã Khuyến Mại:</label>
                    <sf:input path="ma" type="text" id="maKhuyenMai" class="form-input"/>
                    <sf:errors path="ma" cssClass="text-danger"/>
                    <c:if test="${trungMa==true}">
                        <p class="text-danger">Mã chất liệu đã có trong hệ thống, vui lòng nhập mã mới</p>
                    </c:if>
                </div>

                <div class="col-3 mb-4">
                    <label for="tenKhuyenMai">Tên Khuyến Mại:</label>
                    <sf:input path="ten" id="tenKhuyenMai" type="text" class="form-input"/>
                    <sf:errors path="ten" cssClass="text-danger"/>
                    <c:if test="${trungTen==true}">
                        <p class="text-danger">Loại chất liệu đã có trong hệ thống, vui lòng nhập tên mới</p>
                    </c:if>
                </div>

                <div class="col-3 mb-4">
                    <label for="giaTriGiam">Giá Trị Giảm:</label>
                    <sf:input path="giaTriGiam" type="number" class="form-input"/>
                    <sf:errors path="giaTriGiam" cssClass="text-danger"/>
                </div>
                <div class="col-3 mb-4">
                    <label for="ngayBatDau">Ngày bắt đầu:</label>
                    <sf:input path="ngayBatDau" name="ngayBatDau" type="datetime-local" class="form-input"
                              required="required"/>
                    <sf:errors path="ngayBatDau" cssClass="text-danger"/>
                    <c:if test="${not empty errors and errors.getFieldError('ngayBatDau')}">
                        <p class="text-danger">${errors.getFieldError('ngayBatDau').defaultMessage}</p>
                    </c:if>
                </div>
                <div class="col-3 mb-4">
                    <label for="ngayKetThuc">Ngày kết thúc:</label>
                    <sf:input path="ngayKetThuc" name="ngayKetThuc" type="datetime-local" class="form-input"
                              required="required"/>
                    <sf:errors path="ngayKetThuc" cssClass="text-danger"/>
                    <c:if test="${not empty errors and errors.getFieldError('ngayKetThuc')}">
                        <p class="text-danger">${errors.getFieldError('ngayKetThuc').defaultMessage}</p>
                    </c:if>
                </div>


                <div style="text-align: left; margin-left: 100px;">
                    <button type="submit" class="btn btn-primary">Áp dụng</button>
                </div>
            </div>
        </div>

        <!--phần hiển thị list sản phẩm-->
        <div class="col-9"
             style="margin-top: 20px; width: 60% !important; margin-left: 30px; border: 1px solid #ccc; border-radius: 14px;">
            <div style="display: flex; align-items: center; margin-top: 20px; margin-left: 20px;">
                <div style="margin: 10px;">
                    <i class="fa-solid fa-list" style="transform: scale(1.3,1.3);"></i>
                </div>
                <div>
                    <h3 style="margin-top: 4px;">Sản phẩm được áp dụng</h3>
                </div>
            </div>
            <table class="table table-bordered custom-table">
                <thead>
                <tr>
                    <th style="text-align: center; color: red; background-color: aqua;">STT</th>
                    <th style="text-align: center; color: red; background-color: aqua;">Mã sản phẩm</th>
                    <th style="text-align: center; color: red; background-color: aqua;">Tên sản phẩm</th>
                    <th style="text-align: center; color: red; background-color: aqua;">Trạng thái</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${sanPhamApDung}" var="sanPham" varStatus="sanpham">
                    <tr>
                        <td>${sanpham.index + 1}</td>
                        <td>${sanPham.ma}</td>
                        <td>${sanPham.ten}</td>
                        <td>${sanPham.trangThai == 1 ? 'Hoạt động' : 'Ngưng hoạt động'}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        </sf:form>
</body>
<script>
    // Đoạn mã JavaScript để cập nhật thông tin sản phẩm được chọn vào trường hidden
    function updateSelectedProducts() {
        var selectedProducts = [];
        // Lấy danh sách các checkbox sản phẩm được chọn
        var checkboxes = document.querySelectorAll('input[type="checkbox"][name="selectedSanPhamIds"]');
        checkboxes.forEach(function (checkbox) {
            if (checkbox.checked) {
                selectedProducts.push(checkbox.value);
            }
        });
        // Cập nhật giá trị của trường hidden
        document.getElementById("ppppp").value = JSON.stringify(selectedProducts);
    }
</script>
</html>
