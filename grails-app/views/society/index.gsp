
<%@ page import="societysystem.Society" %>
<!DOCTYPE html>
<html>

<head>
	<meta name="layout" content="main">
	<g:set var="entityName" value="${message(code: 'society.label', default: 'Society')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<a href="#list-society" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
	<ul>
		<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
		<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
		<li><g:link class="show" action="overview"><g:message code="Search available societies" args="[entityName]" /></g:link></li>
	</ul>
</div>
<div id="list-society" class="content scaffold-list" role="main">
	<h1><g:message code="default.list.label" args="[entityName]" /></h1>
	<g:if test="${flash.message}">
		<div class="message" role="status">${flash.message}</div>
	</g:if>
	<table>
		<thead>
		<tr>

			<g:sortableColumn property="name" title="${message(code: 'society.name.label', default: 'Name')}" />

		</tr>
		</thead>
		<tbody>
		<g:each in="${societyInstanceList}" status="i" var="societyInstance">
			<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
				<td><g:link action="overview" id="${societyInstance.id}">${fieldValue(bean: societyInstance, field: "name")}</g:link></td>
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
