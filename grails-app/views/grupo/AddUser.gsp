<%@ page import="societysystem.Grupo" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'grupo.label', default: 'Grupo')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<a href="#list-grupo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
    </ul>
</div>
<div id="list-usuario" class="content scaffold-list" role="main">
    <h1><g:message code="Usuarios listagem" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="cpf" title="${message(code: 'usuario.cpf.label', default: 'Cpf')}" />

            <g:sortableColumn property="idGrupo" title="${message(code: 'usuario.idGrupo.label', default: 'Id Grupo')}" />

            <g:sortableColumn property="isOwner" title="${message(code: 'usuario.isOwner.label', default: 'Is Owner')}" />

            <g:sortableColumn property="nome" title="${message(code: 'usuario.nome.label', default: 'Nome')}" />

        </tr>
        </thead>
        <tbody>
        <g:each in="${usuarios}" status="i" var="usuarioInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="addToGroup"  params="grupoInstance" id="${usuarioInstance.id}">${fieldValue(bean: usuarioInstance, field: "cpf")}</g:link></td>

                <td>${fieldValue(bean: usuarioInstance, field: "idGrupo")}</td>

                <td><g:formatBoolean boolean="${usuarioInstance.isOwner}" /></td>

                <td>${fieldValue(bean: usuarioInstance, field: "nome")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>
    <div class="pagination">
        <g:paginate total="${usuarios ?: 0}" />
    </div>
</div>
</body>
</html>
