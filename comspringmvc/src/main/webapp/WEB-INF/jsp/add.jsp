<%--
  Created by IntelliJ IDEA.
  User: ratnesh
  Date: 8/5/17
  Time: 12:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <title>Add New User</title>
</head>
<body>
<form:form action="/user/add" method="post" modelAttribute="user" >
<table border="1" align="center">
    <tr>
        <td>User Id:</td><td> <form:input path="userId"/> </td>
    </tr>
    <tr>
        <td>First Name:</td><td><form:input path="userFirstName"/>  </td>
    </tr>
    <tr>
        <td>Last Name:</td><td><form:input path="userLastName"/>  </td>
    </tr>
    <tr>
        <td>Age:</td><td><form:input path="userAge"/> </td>
    </tr>
    <tr>
        <td colspan="2"><input type="submit" value="Add"/></td>
    </tr>

</table>
</form:form>
</body>
</html>
