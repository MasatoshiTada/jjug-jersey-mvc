<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>社員検索システム</title>
    </head>
    <body>
        <h1>バリデーションエラー</h1>

        <c:if test="${not empty it}">
            <c:forEach items="${it}" var="error">
                ${error.message}<br>
            </c:forEach>
        </c:if>
    </body>
</html>
