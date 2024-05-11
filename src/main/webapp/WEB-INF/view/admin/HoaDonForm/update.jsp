<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    <title>HoaDon</title>
</head>
<body class="container">
<form:form modelAttribute="hoaDon" action="/hoa-don/update/${hoaDon.id}" method="post">

    <div class="form-group">
        <label>Mã</label>
        <form:input path="ma" cssClass="form-control" readonly="true" value="${hoaDon.ma}" />
    </div>


    <div class="form-group">
        <label>Ngày mua</label>
        <form:input path="ngayMua" type="date" cssClass="form-control"  readonly="true" value="${hoaDon.ngayMua}"/>
    </div>
    <div class="form-group">
        <label>Ngày mua</label>
        <form:input path="ngayThanhToan" type="date" cssClass="form-control"  readonly="true" value="${hoaDon.ngayThanhToan}"/>
    </div>

    <div class="form-group">
        <label>Tổng tiền thanh toán</label>
        <form:input path="tongTienThanhToan" cssClass="form-control" readonly="true" value="${hoaDon.tongTienThanhToan}" />
    </div>
    <div class="form-group">
        <label>Tên khách hàng</label>
        <form:input path="tenKH" cssClass="form-control" readonly="true" value="${hoaDon.tenKH}" />
    </div>
    <div class="form-group">
        <label>Địa chỉ</label>
        <form:input path="diaChi" cssClass="form-control" readonly="true" value="${hoaDon.diaChi}" />
    </div>
    <div class="form-group">
        <label>Số điện thoại</label>
        <form:input path="soDT" cssClass="form-control" readonly="true" value="${hoaDon.soDT}" />
    </div>

    <div class="form-group">
        <label>Hình thức thanh toán</label>
        <form:input path="hinhThucTT" cssClass="form-control"  value="${hoaDon.hinhThucTT == 1 ? 'Tại quầy':'Online'}" />
    </div>
    <%--    <div class="form-group">--%>
    <%--        <label>Trạng thái</label>--%>
    <%--        <form:radiobutton path="trangThai"  readonly="true" value="1"/>Đã thanh toán--%>
    <%--        <form:radiobutton path="trangThai"  readonly="true" value="0"/>Chờ thanh toán--%>
    <%--    </div>--%>
    <div class="form-group">
        <label>Trạng thái</label>
        <form:input path="trangThai" cssClass="form-control" readonly="true"   value="${hoaDon.trangThai}"  />
    </div>

    <button type="submit" class="btn btn-primary">Update</button>
</form:form>
</body>
</html>