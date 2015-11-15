<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>社員検索システム</title>
        <link rel="stylesheet" href="../../css/style.css">
    </head>
    <body>
        <h1>社員一覧</h1>
        
        <%-- バリデーションエラー時のメッセージを表示 --%>
        <c:if test="${modelUtil.isValidationError(it)}">
            <ul class="error">
                <c:forEach items="${it}" var="error">
                    <li><c:out value="${error.message}"/></li>
                </c:forEach>
            </ul>
        </c:if>
        
        <%-- 例外発生時のメッセージを表示 --%>
        <c:if test="${modelUtil.isException(it)}">
            <p class="error"><c:out value="${it.message}"/></p>
        </c:if>
        
        <form action="./findByName" method="get">
            氏名キーワード：<input type="text" name="name">
            <input type="submit" value="検索">
        </form>
        <a href="./insertMain">社員を新規作成する</a>
        
        <table border="1">
            <tr><th>社員ID</th><th>氏名</th><th>入社年月日</th><th>部署ID</th><th>部署名</th><th>編集</th><th>削除</th></tr>
            <c:if test="${modelUtil.isNotError(it)}">
                <c:forEach items="${employeeListDto.employeeList}" var="emp">
                <tr>
                    <td><c:out value="${emp.empId}"/></td>
                    <td><c:out value="${emp.name}"/></td>
                    <td><c:out value="${emp.joinedDate}"/></td>
                    <td><c:out value="${emp.department.deptId}"/></td>
                    <td><c:out value="${emp.department.name}"/></td>
                    <td><a href="./editMain?empId=${emp.empId}">編集</a></td>
                    <td><a href="./deleteConfirm?empId=${emp.empId}">削除</a></td>
                </tr>
                </c:forEach>
            </c:if>
        </table>
        <form action="./throwRuntimeException" method="get">
            <input type="submit" value="実行時例外">
        </form>
        <form action="./throwIOException" method="get">
            <input type="submit" value="入出力例外">
        </form>
        
    </body>
</html>
