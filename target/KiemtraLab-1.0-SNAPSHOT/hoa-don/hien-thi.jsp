<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/23/2026
  Time: 7:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form method="get" action="/hoa-don/search">
    Mã khách hàng: <input type="text" name="keyword" placeholder="Nhập mã hóa đơn">
    <button>Search</button>
</form>
<table style="border-collapse: collapse" border="2">
    <thead>
    <tr>
        <th>Mã hóa đơn</th>
        <th>Tổng tiền hàng</th>
        <th>Tiền thừa</th>
        <th>Ghi chú</th>
        <th>Mã giao dịch</th>
        <th>Mã khách hàng</th>
        <th>Tên khách hàng</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="u">
        <tr>
            <td>${u.maHd}</td>
            <td>${u.tongTienHang}</td>
            <td>${u.tienThua}</td>
            <td>${u.ghiChu}</td>
            <td>${u.maGiaoDich}</td>
            <td>${u.kh.maKh}</td>
            <td>${u.kh.tenKh}</td>
            <td>
                <a href="/hoa-don/delete?id=${u.id}">Delete</a>
                <a href="/hoa-don/view-update?id=${u.id}">Update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
