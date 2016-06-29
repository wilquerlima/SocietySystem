<%--
  Created by IntelliJ IDEA.
  User: MANOEL PERGENTINO
  Date: 19/06/2016
  Time: 18:13
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><g:message code="default.create.label" args="[entityName]"  class="Photo" src="${createLink(controller:'pesoa', action:'viewImage', id:'profileInstance.photos.get(1).id')}" />
    </title>
</head>

<body>
<g:img uri="/images/icons/add.png"/>
Output: <img src="/shop/images/logo.png"/>
<!-- <img class="Photo" src="${createLink(controller:'pessoa', action:'viewImage')}" /> -->
</body>
</html>