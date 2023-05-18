<%--
  Created by IntelliJ IDEA.
  User: 徐锐
  Date: 2023/5/15
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提交参数</title>
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("button").click(function () {
                console.log("---")
                $.ajax({
                    url: "/student/login",
                    data:{
                        name: "zhangsan",
                        male: "女",
                        email:"zhangsan@gmail.com",
                        age: 10
                    },
                    type: "post",
                    dataType: "json",
                    success: function (res) {
                        console.log(res)
                    }
                })
            })
        })
    </script>
</head>
<body>
<form action="/user/findUserByUser" method="get" >
    <div>
        <lable>姓名：</lable>
        <input type="text" name="username">
    </div>
    <div>
        <lable>性别：</lable>
        <input type="text" name="male">
    </div>
    <div>
        <button type="submit">提交</button>
    </div>
</form>

<form action="/student/add" method="post">
    <div>
        <lable>学生名：</lable>
        <input type="text" name="name">
    </div>
    <div>
        <lable>学生年龄：</lable>
        <input type="text" name="age">
    </div>
    <div>
        <lable>学生邮箱：</lable>
        <input type="text" name="email">
    </div>
    <div>
        <lable>学生性别：</lable>
        <input type="text" name="male">
    </div>
    <div>
        <button type="submit">提交</button>
    </div>
</form>
<div class="button">
    <button id="button" type="button" style="padding: 10px">
        发起ajax请求
    </button>
</div>
</body>
</html>
