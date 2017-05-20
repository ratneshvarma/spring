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
<br/>
<p bgcolor="pink"/>
<p align="center"><font color="#5f9ea0"> <b> ${message}</b> </font></p>
<table border="1" align="center" >
    <tr><td colspan="5"> <center> <h2>Emp List</h2></center></td></tr>

    <tr>

        <th>Id</th><th>Name</th><th>Address</th><th colspan="2">Action</th>
    </tr>
    <c:forEach items="${empList}" var="row">
        <tr>
            <td>${row.empId}</td>
            <td>${row.empName}</td>
            <td>${row.empAddress}</td>
            <td><a href="/emp/deleteEmp?empId=${row.empId}">Delete</a></td>
            <td><a href="/emp/updateEmp?empId=${row.empId}">Edit</a></td>

        </tr>
    </c:forEach>
        <tr><td colspan="5"> <center> <a href="/emp/newEmp"><h3> Add Emp</h3></a></center></td></tr>




</table>

</body>
</html>
