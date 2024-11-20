<%--
  Created by IntelliJ IDEA.
  User: hangnt169
  Date: 20/11/24
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Ajax demo</h1>
<button onclick="hienThiData()">Click hien thi gia tri</button>
<div id="result"></div>
</body>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
        crossorigin="anonymous"></script>
<script>
    function hienThiData() {
        $.ajax({
            url: "/api/ajax/demo", // Lay tu value => Servlet
            type: "GET",
            dataType: "json",
            success: function (response) {
                console.log(response)
                document.getElementById("result").innerHTML =
                    'MSSV:' + response.massv + 'Ten: ' + response.ten
                    + 'Tuoi:' + response.tuoi + 'Nganh hoc:' + response.nganhHoc
            },
            error: function () {
                document.getElementById("result").innerHTML = "Loi roi"
            }
        })
    }
</script>
</html>
