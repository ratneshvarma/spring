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
    <title>Update Emp</title>
</head>
<body>
<form:form action="/emp/empUpdateSave" method="post" modelAttribute="emp" >
    <table border="1" align="center">
        <tr>
            <td>Emp Id:</td><td> <form:input path="empId" value="${emp.empId}" readonly="true"/> </td>
        </tr>
        <tr>
            <td>Emp Name:</td><td><form:input path="empName" value="${emp.empName}"/>  </td>
        </tr>
        <tr>
            <td>Address:</td><td><form:input path="empAddress" value="${emp.empAddress}"/>  </td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="Update"/></td>
        </tr>

    </table>
</form:form>
</body>
</html>
