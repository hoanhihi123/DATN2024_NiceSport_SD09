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

    <title>Quản lý đợt khuyến mại</title>
    <style>

        Disable horizontal scrollbar
        body, html {
            overflow-x: hidden;
            width: 100%;
        }

        /* Set maximum width for content */
        .container {
            max-width: 1200px; /* Adjust this value as needed */
            margin: 0 auto; /* Center content horizontally */
            padding: 20px; /* Add some padding around content */
        }

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
<%--<div class="card-header" style="margin-right: 20px;">--%>
<%--    <div class="row">--%>
<%--        <div class="col-lg-6">--%>
<%--            <form action="/dot-khuyen-mai/san-pham" method="get">--%>
<%--                <div class="form-group">--%>
<%--                    <input class="form-control" id="textsearch" name="textsearch" type="text"--%>
<%--                           placeholder="(nhập tên sản phẩm)">--%>
<%--                </div>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<p style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid rgba(0, 0, 0, 0.1);"></p>


<div>
    <form action="/dot-khuyen-mai/them" method="post" modelAttribute="dotKhuyenMai">
        <div style="display: flex; justify-content: space-around;background-color: azure;">
            <div class="col-3"
                 style="border: 1px solid #CCC;padding: 20px;border-radius: 14px;width: 30% !important; margin-top: 20px; margin-left:20px;">
                <h4 style="text-align: center;margin-right: 10px;">Thêm đợt khuyến mại</h4><br>
                <div style="margin-left: 20px;">
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
                    <div class="form-group">
                        <label for="giaTriGiam">Giá trị giảm:</label>
                        <input type="number" class="form-control" id="giaTriGiam" name="giaTriGiam" required>
                    </div>
                    <div class="form-group">
                        <label for="ngayBatDau">Ngày bắt đầu:</label>
                        <input type="datetime-local" class="form-control" id="ngayBatDau" name="ngayBatDau" required>
                    </div>
                    <div class="form-group">
                        <label for="ngayKetThuc">Ngày kết thúc:</label>
                        <input type="datetime-local" class="form-control" id="ngayKetThuc" name="ngayKetThuc" required>
                    </div>
                    <div class="form-group">
                        <label for="trangThai1">Trạng thái:</label>
                        <br>
                        <input type="radio" id="trangThai1"  name="trangThai" value="1" checked="true"/> Hoạt động
                        <input type="radio" id="trangThai1"  name="trangThai" value="0" /> Ngưng hoạt động
                        <%--                        <sf:radiobutton path="trangThai" value="0"/> Ngưng hoạt động--%>
                        <%--                        <sf:errors path="trangThai" cssClass="text-danger"/>--%>
                    </div>
                    <%--                    <div class="form-group">--%>
                    <%--                        <label for="selectedProducts">Ngày kết thúc:</label>--%>
                    <%--                        <input type="text" class="form-control" id="selectedProducts" name="selectedProducts" required>--%>
                    <%--                </div>--%>
                    <%--                    <input type="hidden" id="selectedProducts" name="selectedProducts[]" />--%>
                    <div class="form-group hidden-selected-products">
                    </div>
                    <div style="text-align: right; margin-top: 20px;">
                        <button type="button" class="btn btn-primary" onclick="submitForm()">Áp dụng</button>
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
                        <h3 style="margin-top: 4px;">Sản phẩm</h3>
                    </div>
                </div>

                <table class="table table-bordered custom-table">
                    <thead>
                    <tr>
                        <th style="text-align: center; color: red; background-color: aqua;"></th>
                        <th style="text-align: center; color: red; background-color: aqua;">STT</th>
                        <th style="text-align: center; color: red; background-color: aqua;">Mã sản phẩm</th>
                        <th style="text-align: center; color: red; background-color: aqua;">Tên sản phẩm</th>
                        <th style="text-align: center; color: red; background-color: aqua;">Trạng thái</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${dsSanPham}" var="sanPham" varStatus="sp">
                        <tr>
                            <td style="text-align: center;">
                                <input type="checkbox" name="selectedSanPhamIds" value="${sanPham.id}" onclick="updateSelectedProducts()">
                            </td>
                            <th scope="row">${sp.index + 1}</th>
                            <td>${sanPham.ma}</td>
                            <td>${sanPham.ten}</td>
                            <td>${sanPham.trangThai == 1 ? 'Hoạt động' : 'Ngưng hoạt động'}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
<%--                <div id="listSP" aria-hidden="true">--%>
<%--                    <p id="totalPages">${dsSanPham.size()}</p>--%>
<%--                    <p id="currentPage">0</p>--%>
<%--                    <c:forEach items="${dsSanPham}" var="sanPham" varStatus="sp">--%>
<%--                        <p>${sanPham.ma}-${sanPham.ten}-${sanPham.trangThai}</p>--%>
<%--&lt;%&ndash;                        <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <td style="text-align: center;">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <input type="checkbox" name="selectedSanPhamIds" value="${sanPham.id}" onclick="updateSelectedProducts()">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <th scope="row">${sp.index + 1}</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <td>${sanPham.ma}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <td>${sanPham.ten}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <td>${sanPham.trangThai == 1 ? 'Hoạt động' : 'Ngưng hoạt động'}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </tr>&ndash;%&gt;--%>
<%--                    </c:forEach>--%>
<%--                </div>--%>
                <div class="pagination-container">
                    <ul class="pagination">
                        <c:if test="${totalPages > 1}">
                            <c:if test="${currentPage > 0}">
                                <li class="page-item">
                                    <a class="page-link" href="/dot-khuyen-mai/view-add?page=${currentPage - 1}" tabindex="-1" aria-disabled="true">Previous</a>
                                </li>
                            </c:if>
                            <c:forEach begin="0" end="${totalPages - 1}" varStatus="i">
                                <c:choose>
                                    <c:when test="${currentPage == i.index}">
                                        <li class="page-item active" aria-current="page">
                                            <a class="page-link" href="/dot-khuyen-mai/view-add?page=${i.index}">${i.index + 1}</a>
                                        </li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="page-item" aria-current="page">
                                            <a class="page-link" href="/dot-khuyen-mai/view-add?page=${i.index}">${i.index + 1}</a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                            <c:if test="${currentPage < totalPages - 1}">
                                <li class="page-item">
                                    <a class="page-link" href="/dot-khuyen-mai/view-add?page=${currentPage + 1}">Next</a>
                                </li>
                            </c:if>
                        </c:if>
                    </ul>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
<script>
    var selectedProducts = [];
    // const listSP = document.getElementById("listSP").getAttribute("data-sp");
    // const totalPages = document.getElementById("totalPages").textContent;
    // const currentPage = document.getElementById("currentPage").textContent;
    // const pagination = document.querySelector(".pagination");
    // pagination.empty();
    // if (totalPages > 1) {
    //     if (currentPage > 0) {
    //         const prevBtn = document.createElement("<li class='page-item' tabindex='-1' aria-disabled='true'>Previous</li>");
    //         pagination.appendChild(prevBtn);
    //     }
    //     if (currentPage > totalPages) {
    //         const nextBtn = document.createElement("<li class='page-item' tabindex='-1' aria-disabled='true'>Next</li>");
    //         pagination.appendChild(nextBtn);
    //     }
    // }
    function updateSelectedProducts() {
        var checkboxes = document.querySelectorAll('input[type="checkbox"][name="selectedSanPhamIds"]');
        var hiddenSelectedWrapper = document.querySelector(".hidden-selected-products");
        checkboxes.forEach(function (checkbox) {
            console.log('checkbox === ', checkbox, checkbox.checked);
            const checkBoxValue = checkbox.getAttribute("value");
            if (checkbox.checked && !selectedProducts.includes(checkBoxValue)) {
                const hiddenInput = document.createElement("input");
                hiddenInput.setAttribute("type", "text");
                hiddenInput.hidden = true;
                hiddenInput.setAttribute("name", "selectedProducts[]");
                hiddenInput.setAttribute("value", checkBoxValue);

                hiddenSelectedWrapper.appendChild(hiddenInput);
                console.log("selectedProducts", selectedProducts);
                selectedProducts.push(checkBoxValue);
            }
        });
        // document.getElementById("selectedProducts").setAttribute("value", selectedProducts);
    }

    function submitForm() {
        // Cập nhật danh sách sản phẩm được chọn
        updateSelectedProducts();
        // Gửi form
        document.querySelector('form').submit();
    }
</script>

</html>
