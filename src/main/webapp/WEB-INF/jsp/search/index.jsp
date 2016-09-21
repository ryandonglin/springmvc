<%--
  Created by IntelliJ IDEA.
  User: homelink
  Date: 2016/9/21
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>检索</title>
</head>
<link rel="stylesheet" href="
/search.css">
<!-- <script type="text/javascript" src="../js/search.js"></script> -->
<body>
    <input type="text" value="请输入检索内容" name="search_box" id="search_box" />
    <input type="submit" value="提交"/>
</body>

<script>
    function buttonClick() {
        $.ajax({
            type: "get",
            url: "",
            success: function() {

            }
        })
    }
</script>
</html>
