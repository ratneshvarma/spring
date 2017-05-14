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
<br/><a href="/emp/newEmp">Add Emp</a>

<h1>Emp List:</h1>

<table border="1" >
    <tr>

        <th>Id</th><th>Name</th><th>Address</th><th colspan="2">Action</th>
    </tr>
    <c:forEach items="${empList}" var="row">
        <tr>
            <td>${row.empId}</td>
            <td>${row.empName}</td>
            <td>${row.empAddress}</td>
            <td><a href="">Delete</a></td>
            <td><a href="">Edit</a></td>

        </tr>
    </c:forEach>



</table>

</body>
</html>
