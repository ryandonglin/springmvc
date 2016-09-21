<%--
  Created by IntelliJ IDEA.
  User: homelink
  Date: 2016/9/21
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>检索</title>
</head>

<link type="text/css" href="${pageContext.request.contextPath}/css/search.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.1.js"></script>

<body>
    <input type="text" name="search_box" id="search_box" />
    <input type="submit" value="提交" onclick="buttonClick()"/>
    <table id="result">
    </table>
</body>

<script>
    function buttonClick() {
        var contents = document.getElementById("search_box").value;
        $.ajax({
            type: "GET",
            url: "${pageContext.request.contextPath}/search/index/rest?content=" + contents,
            success: function(data) {
                data = data.substr(1, data.length-1);
                var tokens = data.split(",");
                var tbody = "";
                for (var i = 0; i < tokens.length; i++) {
                    var t = tokens[i].split(":");
                    var trClass = "";
                    if (0 == i % 2) {
                        trClass = "even";
                    } else {
                        trClass = "odd";
                    }
                    tbody += "<tr class='" + trClass + "'><td>" + t[0] + "</td><td>" + t[1] + "</td></tr>";
                }
                $("#result").append(tbody);
            }
        });
    }
</script>

</html>
