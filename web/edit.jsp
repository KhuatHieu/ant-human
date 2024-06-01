<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>${human != null ? 'Edit' : 'Create'} Human</title>
    </head>
    <body>
        <h1>${human != null ? 'Edit' : 'Create'} Human</h1>
        <form action="${human != null ? 'edit' : 'create'}" method="post">
            <c:if test="${human != null}">
                <input type="hidden" name="humanid" value="${human.humanid}">
            </c:if>
            <label for="humanname">Name:</label>
            <input type="text" id="humanname" name="humanname" value="${human != null ? human.humanname : ''}" required><br>
            <label for="humandob">Date of Birth:</label>
            <input type="date" id="humandob" name="humandob" value="${human != null ? human.humandob : ''}" required><br>
            <label for="humangender">Gender:</label>
            <select id="humangender" name="humangender" required>
                <option value="true" ${human != null && human.humangender ? 'selected' : ''}>Male</option>
                <option value="false" ${human != null && !human.humangender ? 'selected' : ''}>Female</option>
            </select><br>
            <label for="typeid">Type:</label>
            <select id="typeid" name="typeid" required>
                <c:forEach items="${humanTypes}" var="type">
                    <option value="${type.typeid}" ${human != null && type.typeid == human.typeid ? 'selected' : ''}>${type.typename}</option>
                </c:forEach>
            </select><br>            
            <button type="submit">${human != null ? 'Update' : 'Create'}</button>
        </form>
    </body>
</html>
