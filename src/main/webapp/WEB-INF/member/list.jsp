<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>TodoList</title>
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

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        a {
            text-decoration: none;
            color: #007bff;
            margin-right: 10px;
        }

        .finished-true {
            color: green;
        }

        .finished-false {
            color: red;
        }
    </style>
</head>
<body>
<h1>List Page</h1>
<table>
    <thead>
    <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>이메일</th>
        <th>수정</th>
        <th>삭제</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="dto" items="${dtoList}">
        <tr>
            <td>${dto.mid}</td>
            <td>${dto.mname}</td>
            <td>${dto.email}</td>
            <td><a href="/member/modify?mid=${dto.mid}">수정</a></td>
            <td><a href="/member/remove?mid=${dto.mid}">삭제</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form action="/logout" method="post">
    <button>LOGOUT</button>
</form>
</body>
</html>
