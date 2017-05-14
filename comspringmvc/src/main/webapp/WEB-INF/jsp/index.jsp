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
<html>
<head>
    <title>Spring MVC</title>
</head>
<br>
Hi ${employee.firstName}&nbsp;&nbsp;${employee.lastName}
</br>&nbsp;&nbsp;&nbsp;&nbsp;
Welcome to Spring MVC World!
<br>
<br/>
<br/><a href="/user/userList"> <h3>User List </h3></a>
<br/>
<h3><a href="/emp/empList"> Emp List</a></h3>


<br>
<br>

<ul>
    Country List:
    <c:forEach items="${employee.country}" var="value">
        <li><c:out value="${value}"/></li>
    </c:forEach>
</ul>
<ul>
    Map List:
    <c:forEach items="${employee.userList}" var="value">
        <li><c:out value="${value.value}"/></li>
    </c:forEach>
</ul>

Session Available Here: ${user.userFirstName}
HttpSession Exmaple:${sessionScope.sessionViaHttpSession.firstName}

</body>
</html>
