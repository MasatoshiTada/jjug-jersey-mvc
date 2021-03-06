<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>社員情報新規追加（確認）</title>
    </head>
    <body>
        <h1>この社員情報の追加を確定しますか？</h1>
        社員ID：（自動採番されます）<br>
        氏名：<c:out escapeXml="true" value="${models.employee.name}"/><br>
        入社年月日：<c:out escapeXml="true" value="${models.employee.joinedDate}"/><br>
        部署：<c:out escapeXml="true" value="${models.employee.deptId}"/><br>
        <form action="./insertMain" method="get">
            <input type="submit" value="戻る">
        </form>
        <form action="./insertComplete" method="post">
            <input type="hidden" name="name" value="${models.employee.name}">
            <input type="hidden" name="joinedDate" value="${models.employee.joinedDate}">
            <input type="hidden" name="deptId" value="${models.employee.deptId}">
            <input type="submit" value="確定">
        </form>
    </body>
</html>
