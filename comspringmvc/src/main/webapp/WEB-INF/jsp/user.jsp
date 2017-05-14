<%--
  Created by IntelliJ IDEA.
  User: ratnesh
  Date: 13/5/17
  Time: 6:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<p>

<b>Hi ${user.userFirstName}</b>, Welcome to Home.
<p></p>
<a href="/session-check">Session Test</a>
<p></p>
HttpSession Exmaple(session will create when /index use):${ sessionScope.sessionViaHttpSession.firstName}
<br/><a href="/user/newUser">Add User</a>
<p align="center">${message}</p>
<h1>User List:</h1>
${success}
<table border="1" >
    <tr>

        <th>Id</th><th>First Name</th><th>Last Name</th><th>Age</th><th colspan="2">Action</th>
    </tr>
<c:forEach items="${userList}" var="row">
    <tr>
        <td>${row.userId}</td>
        <td>${row.userFirstName}</td>
        <td>${row.userLastName}</td>
        <td>${row.userAge}</td>
        <td><a href="/user/deleteUser?userId=${row.userId}">Delete</a></td>
        <td><a href="/user/updateUser?userId=${row.userId}">Edit</a></td>

    </tr>
</c:forEach>



</table>

</body>
</html>
