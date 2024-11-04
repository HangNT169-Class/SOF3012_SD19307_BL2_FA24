<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="">
    Tên: <input name="ten"/>
    <button type="submit">Search</button>
</form>
<br/>
<button><a href="">Add Cate</a></button>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Cate Code</th>
        <th>Cate name</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <%-- KHI SUA CODE JSP => UPDATE...   --%>
    <%--  Chi dung ${} => cac gia tri duoc lay tu servlet truyen sang    --%>
    <c:forEach items="${a1}" var="cate" varStatus="i">
        <tr>
            <td>${i.index}</td>
            <td>${cate.id1}</td>
            <td>${cate.categoryCode}</td>
            <td>${cate.categoryName}</td>
            <td>
                <%-- Cach truyen gia tri tren url
                    Vs TS1 => dung dau ?
                    VS TS2 tro di => dung dau &
                 --%>
                <a href="/category/delete?a2=${cate.id1}">Delete</a>
                <a href="/category/view-update?b=${cate.id1}">Update</a>
                <a href="/category/detail?id=${cate.id1}">Detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
