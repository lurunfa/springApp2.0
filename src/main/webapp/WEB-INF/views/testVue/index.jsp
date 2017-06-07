<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <script src="resources/common/jquery/jquery-3.2.1.js"></script>
    <script src="resources/common/vue/vue.js"></script>
</head>
<body>
<div id="app">
    {{message}}
</div>
</body>
<script>
    var app = new Vue({
        el: '#app',
        data: {
            message: "hello world!"
        }
    })
</script>
</html>
