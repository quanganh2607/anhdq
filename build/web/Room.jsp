<%-- 
    Document   : Room
    Created on : Sep 28, 2024, 10:01:06 AM
    Author     : anhdq
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Room Search</title>
</head>
<body>
    <h2>Room List</h2>

    <form method="post" action="Room">
        <label for="motelId">Motel:</label>
        <input type="text" id="motelId" name="motelId" placeholder="Enter Motel ID">
        <label for="typeId">Room Type:</label>
        <input type="text" id="typeName" name="typeName" placeholder="Enter Room Type Name">
        <button type="submit">Search</button>
    </form>
    <table border="1">
        <thead>
            <tr>
                <th>Room ID</th>
                <th>Motel Name</th>
                <th>Room Type</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="room" items="${requestScope.rooms}">
            <tr>
                <td>${room.roomId}</td>
                <td>${room.getMotelName()}</td>
                <td>${room.getRoomTypeName()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>

