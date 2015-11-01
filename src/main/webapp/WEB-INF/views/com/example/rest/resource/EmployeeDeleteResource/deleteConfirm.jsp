<%-- 
    Document   : deleteConfirm
    Created on : 2015/11/01, 15:54:04
    Author     : tada
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>社員情報削除</title>
    </head>
    <body>
        <h1>社員情報削除</h1>
        <p>この社員情報を削除しますか？</p>
        社員ID：<c:out escapeXml="true" value="${it.empId}"/><br>
        氏名：<c:out escapeXml="true" value="${it.name}"/><br>
        入社年月日：<c:out escapeXml="true" value="${it.joinedDate}"/><br>
        部署：<c:out escapeXml="true" value="${it.department.name}"/><br>
        <form action="./index" method="get">
            <input type="submit" value="戻る">
        </form>
        <form action="./delete" method="post">
            <input type="hidden" name="empId" value="${it.empId}">
            <input type="submit" value="削除">
        </form>
    </body>
</html>
