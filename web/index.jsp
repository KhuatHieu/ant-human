<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Humans</title>
    </head>
    <body>
        <h1>List Humans</h1>
        <div>
            <table border="1">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>DDB</th>
                        <th>Gender</th>
                        <th>Type</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${humans}" var="human">
                        <tr>
                            <td>${human.humanname}</td>
                            <td>${human.humandob}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${human.humangender}">
                                        <img src="male.png" alt="Male" style="width:25px;height:25px;">
                                    </c:when>
                                    <c:otherwise>
                                        <img src="female.png" alt="Female" style="width:25px;height:25px;">
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>${human.typename}</td>
                            <td>
                                <a href="./edit?id=${human.humanid}">
                                    <button>Edit</button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="./create">
                <button>Create</button>
            </a>
        </div>
    </body>
</html>
