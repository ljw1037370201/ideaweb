<%--
  Created by IntelliJ IDEA.
  User: yanhk
  Date: 2019/2/25
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <form action="/servlet/MyServlet" method="post">
        账号：<input type="text" name="username" required="required"/>
        密码:<input type="password" name="userpass" required="required"/>
        <button type="submit"\>提交</button>
    </form>
</body>
</html>
