
<%@ pages import="societysystem.Pagamento" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'pagamento.label', default: 'Pagamento')}" />

    <title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
<a href="#show-pagamento" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link controller="horario" class="list" action="index">Horários Disponíveis</g:link></li>
        <li><g:link class="list" action="index">Reservas Realizadas</g:link></li>

    </ul>
</div>
<div id="show-pagamento" class="content scaffold-show" role="main">
    <h1>Pagamento Realizado com Sucesso!</h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>

</div>
</body>
</html>
