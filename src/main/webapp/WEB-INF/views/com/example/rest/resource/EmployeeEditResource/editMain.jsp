<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>社員情報更新</title>
    </head>
    <body>
        <h1>作成中...</h1>
        <%--
        <form action="./editConfirm" method="post">
            社員ID：<c:out escapeXml="true" value="${models.employee.empId}"/><br>
            <input type="hidden" name="empId" value="${models.employee.empId}">
            氏名：<input type="text" name="name" value="${models.employee.name}"><br>
            入社年月日：<input type="text" name="joinedDate" value="${models.employee.joinedDate}"><br>
            部署：
            <select name="deptId">
                <c:forEach items="${models.departmentList}" var="dept">
                    <option value="${dept.deptId}" label="${dept.name}">
                </c:forEach>
            </select>
            <input type="submit" value="更新">
        </form>
        --%>
    </body>
</html>
