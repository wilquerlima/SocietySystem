<%--
  Created by IntelliJ IDEA.
  User: felip_000
  Date: 06/20/16
  Time: 5:23 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>Add Field</title>
</head>

<body>
    <g:form url="[resource:societyInstance]" method="PUT" >
        <g:field type="text" name="fieldName" id="fieldName" value="Enter the name of the Field Here"/>
        <g:actionSubmit class="save" id="confirm" action="addFieldToSociety" value="Confirm" />
    </g:form>
</body>
</html>