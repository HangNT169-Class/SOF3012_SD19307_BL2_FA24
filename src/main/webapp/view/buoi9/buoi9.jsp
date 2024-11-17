<%--
  Created by IntelliJ IDEA.
  User: hangnt169
  Date: 17/11/24
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Scope Request trong JSP : ${message1}</p>
<%--Code Java trong jsp dung: <%%>--%>
<%
    // Thiet lap gia tri trong pageContext : setAttribute
    pageContext.setAttribute("message2","Scope JSP & Servlet - Page");
    // Lay gia tri tu pageContext ra : getAttribute
    String message2 = (String)pageContext.getAttribute("message2");
%>
<p>Scope Page trong JSP: ${message2}</p>
<%--Trong truc tiep jsp ma duoc forward--%>
<p>Scope Application trong JSP: ${message3}</p>
<p>Scope Session trong JSP: ${message4}</p>
<p>Scope Session trong Servlet - C2: Truyen tu servlet -> jsp: ${str1}</p>
</body>
</html>
