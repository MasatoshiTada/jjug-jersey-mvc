<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>社員検索システム</title>
    </head>
    <body>
        <h1>例外画面</h1>
        <%-- TODO: errorTypeとmessageがブラウザ上に表示されない --%>
        <p><c:out value="${exceptionDto.errorType}"/></p>
        <c:forEach items="${exceptionDto.messages}" var="message">
            <p><c:out value="${message}"/></p>
        </c:forEach>
    </body>
</html>
