<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>

<h2>Login</h2>
<c:if test="${not empty error}">
    <p>${error}</p>
</c:if>
<form action="/login" method="post">
    <label for="taiKhoan">Username:</label>
    <input type="text" id="taiKhoan" name="taiKhoan"><br>
    <label for="matKhau">Password:</label>
    <input type="password" id="matKhau" name="matKhau"><br>
    <input type="submit" value="Login">
</form>
<c:if test="${not empty success}">
    <p>${success}</p> <!-- Hiển thị thông báo đăng nhập thành công -->
    <p>Welcome, ${sessionScope.hoTen}</p> <!-- Hiển thị thông tin HoTen của người dùng đã đăng nhập -->
    <p><a href="/welcome">Đăng nhập thành công</a></p>
    <!-- Liên kết đến trang chào mừng -->
</c:if>

</body>
</html>
