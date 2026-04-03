<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/23/2026
  Time: 7:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form  method="post" action="/hoa-don/update">
    <input type="hidden" name="id" value="${hd.id}"> <br>
    Mã hóa đơn: <input type="text" name="ma" value="${hd.maHd}"> <br>
    Tổng tiền hàng: <input type="number" name="tongTienHang" value="${hd.tongTienHang}"> <br>
    Tiền thừa: <input type="number" name="tienThua" value="${hd.tienThua}"> <br>
    Ghi chú: <input type="text" name="tienThua" value="${hd.tienThua}"> <br>
    Mã giao dịch: <input type="text" name="maGiaoDich" value="${hd.maGiaoDich}"> <br>
    Mã khách hàng:
    <select name="idkh">
        <c:forEach items="${list1}" var="u">
            <option value="${u.id}" label="${u.maKh}" ${hd.kh.id==u.id?"selected":""}></option>
        </c:forEach>
    </select>
    <button>Update</button>
</form>
</body>
</html>
