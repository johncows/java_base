<%--
  Created by IntelliJ IDEA.
  User: ROOT
  Date: 2019/2/22
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>

        <form action="register.action" method="post" enctype="multipart/form-data">
            姓名<input name="name" type="text"/><br>
            密码<input name="password" type="password"/><br>
            照片<input name="image" type="file" >
            <input type="submit" name="提交">
        </form>

</body>
</html>
