<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>社員情報更新</title>
    </head>
    <body>
        <form action="./insertConfirm" method="post">
            氏名：<input type="text" name="name"><br>
            入社年月日：<input type="text" name="joinedDate"><br>
            部署：
            <select name="deptId">
                <c:forEach items="${models.departmentList}" var="dept">
                    <option value="${dept.deptId}" label="${dept.name}">
                </c:forEach>
            </select>
            <input type="submit" value="新規作成">
        </form>
    </body>
</html>
