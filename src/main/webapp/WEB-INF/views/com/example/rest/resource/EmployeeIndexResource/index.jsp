<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>社員検索システム</title>
    </head>
    <body>
        <h1>社員一覧</h1>

        <%-- TODO: バリデーションエラーをどう表示するか？ --%>
        <%--
        <c:if test="${not empty it}">
            <c:forEach items="${it}" var="error">
                ${error.message}<br>
            </c:forEach>
        </c:if>
        --%>
        <form action="./findByName" method="get">
            氏名キーワード：<input type="text" name="name">
            <input type="submit" value="検索">
        </form>
        <a href="./insertMain">社員を新規作成する</a>
        
        <table border="1">
            <tr><th>社員ID</th><th>氏名</th><th>入社年月日</th><th>部署ID</th><th>部署名</th><th>編集</th><th>削除</th></tr>
            <c:forEach items="${models.employeeList}" var="emp">
                <tr>
                    <td>${emp.empId}</td>
                    <td>${emp.name}</td>
                    <td>${emp.joinedDate}</td>
                    <td>${emp.department.deptId}</td>
                    <td>${emp.department.name}</td>
                    <td><a href="./editMain?empId=${emp.empId}">編集</a></td>
                    <td><a href="./deleteConfirm?empId=${emp.empId}">削除</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
