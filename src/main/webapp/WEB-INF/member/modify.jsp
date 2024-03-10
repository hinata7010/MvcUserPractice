<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Todo List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        h1 {
            font-size: 24px;
            color: #333;
            margin-bottom: 20px;
        }

        input[type="number"],
        input[type="text"],
        input[type="date"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
        }

        input[type="checkbox"] {
            margin-right: 10px;
        }

        button[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            margin-bottom: 5px;
        }

        button[type="submit"]:hover {
            margin-right: 20px;
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>회원 정보 수정</h1>
    <form action="/member/modify" method="post" accept-charset="UTF-8">
        <input type="text" name="mid" value="${dto.mid}" readonly>
        <br>
        <input type="text" name="mpw" value="${dto.mpw}">
        <br>
        <input type="text" name="mname" value="${dto.mname}">
        <br>
        <input type="text" name="email" value="${dto.email}">
        <br>
        <button type="submit">수정하기</button>
    </form>
</div>
</body>
</html>
