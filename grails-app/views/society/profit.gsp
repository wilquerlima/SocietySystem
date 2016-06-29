<%--
  Created by IntelliJ IDEA.
  User: felip_000
  Date: 05/31/16
  Time: 1:56 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>O society  tem alguns detalhes</title>
</head>

<body>
    <g:each in="${fields}" var="field" status="i">
       <p> ${field.value} </p>
    </g:each>
    <a action="index">Volta para Index</a>
</body>
</html>