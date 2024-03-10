<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
        }

        h1 {
            color: #007bff;
            font-size: 28px;
            text-align: center;
            margin-bottom: 20px;
        }

        form {
            text-align: center;
            margin-top: 20px;
        }

        input[type="text"] {
            width: 200px;
            padding: 10px;
            margin: 5px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        button[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
        }

        button[type="submit"]:hover {
            background-color: #0056b3;
        }

        .error-message {
            color: red;
            font-size: 14px;
        }
    </style>
</head>
<body>
<c:if test="${param.result == 'error'}">
    <div class="error-message">
        <h1>로그인 에러입니다. 다시 시도하세요!</h1>
    </div>
</c:if>
<form action="/login" method="post">
    <input type="text" name="mid" placeholder="아이디">
    <br>
    <input type="text" name="mpw" placeholder="비밀번호">
    <br>
    <button type="submit">LOGIN</button>
    <button type="submit" formaction="/member/register" formmethod="get">회원가입</button>
</form>
</body>
</html>
