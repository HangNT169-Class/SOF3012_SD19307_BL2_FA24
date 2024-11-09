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
<button><a href="/category/view-add">Add Cate</a></button>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Product code</th>
        <th>Product name</th>
        <th>Price</th>
        <th>Cate Code</th>
        <th>Cate name</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${list}">
        <tr>
            <td>${product.id}</td>
            <td>${product.productCode}</td>
            <td>${product.productName}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>${product.cate.categoryCode}</td>
            <td>${product.cate.categoryName}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
