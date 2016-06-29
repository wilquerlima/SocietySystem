<%@ page import="societysystem.Society" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'society.label', default: 'Society')}" />
    <title><g:message code="Search results" args="[entityName]" /></title>
</head>
<body>
<a href="#list-vaga" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
        <!-- <li><g:link action="index">Book</g:link></li> -->
    </ul>
</div>
<div id="list-society" class="content scaffold-list" role="main">
    <h1>Overview</h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>
        </tr>
        </thead>
        <tbody>
        <g:each in="${societyInstanceList}" status="i" var="societyInstance">
            <tr class="${societyInstance.available == true ? 'green' : 'red'}">
                <td><g:link action="show" id="${societyInstance.id}">${fieldValue(bean: societyInstance, field: "name")}</g:link></td>
                <td>${fieldValue(bean: societyInstance, field: "available")}</td>
            </tr>
        </g:each>
        </tbody>
    </table>
    <div class="pagination">
        <g:paginate total="${societyInstanceCount ?: 0}" />
    </div>
</div>
</body>
</html>