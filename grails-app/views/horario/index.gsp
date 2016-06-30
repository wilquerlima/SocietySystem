
<%@ pages import="societysystem.Horario" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'horario.label', default: 'Horario')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-horario" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-horario" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
						<g:sortableColumn property="dia" title="${message(code: 'horario.dia.label', default: 'Dia')}" />
					
						<g:sortableColumn property="horaInicial" title="${message(code: 'horario.horaInicial.label', default: 'Hora Inicial')}" />
					
						<g:sortableColumn property="horaFinal" title="${message(code: 'horario.horaFinal.label', default: 'Hora Final')}" />
					
						<g:sortableColumn property="ocupado" title="${message(code: 'horario.ocupado.label', default: 'Ocupado')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${horarioInstanceList}" status="i" var="horarioInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td >${fieldValue(bean: horarioInstance, field: "dia")}</td>
					
						<td ><g:link action="select" id="${horarioInstance.id}">${fieldValue(bean: horarioInstance, field: "horaInicial")}</g:link></td>
					
						<td>${fieldValue(bean: horarioInstance, field: "horaFinal")}</td>
					
						<td><g:formatBoolean boolean="${horarioInstance.ocupado}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<ul>
					<li><g:link class="list-view" controller="pagamento" action="pagamento">Pagar</g:link></li>
					<li><g:link class="list-view" controller="campo" action="index">Voltar</g:link></li>
				</ul>
				<g:paginate total="${horarioInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
