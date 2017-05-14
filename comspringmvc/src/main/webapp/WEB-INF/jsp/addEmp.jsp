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
    <title>Add New Emp</title>
</head>
<body>
<form:form action="/emp/saveEmp" method="post" modelAttribute="emp" >
    <table border="1">
        <tr>
            <td>Emp Id:</td><td> <form:input path="empId"/> </td>
        </tr>
        <tr>
            <td>Emp Name:</td><td><form:input path="empName"/>  </td>
        </tr>
        <tr>
            <td>Address:</td><td><form:input path="empAddress"/>  </td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="Add"/></td>
        </tr>

    </table>
</form:form>
</body>
</html>
