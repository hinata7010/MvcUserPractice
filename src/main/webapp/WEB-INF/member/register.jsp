<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>등록</title>
    <style>
        h1 {
            font-size: 24px;
            color: #333;
            margin-bottom: 20px;
        }
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        input[type="text"],
        input[type="date"],
        input[type="email"],
        input[type="password"]{
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 3px;
            font-size: 14px;
        }

        button[type="submit"],
        button[type="reset"] {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #ffffff;
            border: none;
            border-radius: 3px;
            font-size: 14px;
            cursor: pointer;
        }

        button[type="reset"] {
            background-color: #dc3545;
        }
    </style>
</head>
<body>
<form action="/member/register" method="post">
    <h1>회원 가입</h1>
    아이디 <input type="text" name="mid">
    비밀번호 <input type="password" name="mpw">
    이름 <input type="text" name="mname">
    이메일 <input type="email" name="email">
    <button type="submit">회원 가입</button>
    <button type="reset">초기화</button>
</form>
</body>
</html>
