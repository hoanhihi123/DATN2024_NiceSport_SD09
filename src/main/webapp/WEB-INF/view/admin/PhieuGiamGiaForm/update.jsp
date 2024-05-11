<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    <title>PhieuGiamGia</title>
</head>
<body class="container">
<form:form modelAttribute="phieuGiam" action="/phieu-giam-gia/update/${phieuGiam.id}" method="post">

    <div class="form-group">
        <label>Ma</label>
        <form:input path="ma" cssClass="form-control" value="${phieuGiam.ma}" />
    </div>

    <div class="form-group">
        <label>TenPhieu</label>
        <form:input path="tenPhieu" cssClass="form-control" value="${phieuGiam.tenPhieu}" />
    </div>
    <div class="form-group">
        <label>GiaTriGiam</label>
        <form:input path="giaTriGiam" type="number" cssClass="form-control" value="${phieuGiam.giaTriGiam}" />
    </div>
    <div class="form-group">
        <label>HinhThucGiam</label>
        <form:input path="hinhThucGiam" cssClass="form-control" value="${phieuGiam.hinhThucGiam}" />
    </div>
    <div class="form-group">
        <label>DieuKienGiam</label>
        <form:input path="dieuKienGiam" cssClass="form-control" value="${phieuGiam.dieuKienGiam}" />
    </div>
    <div class="form-group">
        <label>XetDK</label>
        <form:input path="giaTienXetDieuKien" type="number" cssClass="form-control" value="${phieuGiam.giaTienXetDieuKien}" />
    </div>
    <div class="form-group">
        <label>NgayBD</label>
        <form:input path="ngayBatDau" type="date" cssClass="form-control" value="${phieuGiam.ngayBatDau}" />
    </div>
    <div class="form-group">
        <label>NgayKT</label>
        <form:input path="ngayKetThuc" type="date" cssClass="form-control" value="${phieuGiam.ngayKetThuc}" />
    </div>
    <div class="form-group">
        <label>NgayTao</label>
        <form:input path="ngayTao" type="date" cssClass="form-control" value="${phieuGiam.ngayTao}" />
    </div>
    <div class="form-group">
        <label>NgaySua</label>
        <form:input path="ngaySua" type="date" cssClass="form-control" value="${phieuGiam.ngaySua}" />
    </div>
    <div class="form-group">
        <label>NguoiTao</label>
        <form:input path="nguoiTao" cssClass="form-control" value="${phieuGiam.nguoiTao}" />
    </div>
    <div class="form-group">
        <label>NguoiSua</label>
        <form:input path="nguoiSua" cssClass="form-control" value="${phieuGiam.nguoiSua}" />
    </div>
    <div class="form-group">
        <label>TrangThai</label>
        <form:radiobutton path="trangThai"  value="1"/>Con hang
        <form:radiobutton path="trangThai"  value="0"/>Het hang
    </div>

    <button type="submit" class="btn btn-primary">Update</button>
</form:form>
</body>
</html>
