<%--
  Created by IntelliJ IDEA.
  User: ratnesh
  Date: 13/5/17
  Time: 7:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session</title>
</head>
<body>
Testing Session:
<br> Session Atributes: ${user.userFirstName}
<br>
HttpSession Exmaple:${sessionScope.sessionViaHttpSession.firstName}
</body>
</html>
