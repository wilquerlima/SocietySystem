
<%@ pages import="societysystem.Horario" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'horario.label', default: 'Horario')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-horario" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-horario" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list horario">
			
				<g:if test="${horarioInstance?.dia}">
				<li class="fieldcontain">
					<span id="dia-label" class="property-label"><g:message code="horario.dia.label" default="Dia" /></span>
					
						<span class="property-value" aria-labelledby="dia-label"><g:fieldValue bean="${horarioInstance}" field="dia"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${horarioInstance?.horaInicial}">
				<li class="fieldcontain">
					<span id="horaInicial-label" class="property-label"><g:message code="horario.horaInicial.label" default="Hora Inicial" /></span>
					
						<span class="property-value" aria-labelledby="horaInicial-label"><g:fieldValue bean="${horarioInstance}" field="horaInicial"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${horarioInstance?.horaFinal}">
				<li class="fieldcontain">
					<span id="horaFinal-label" class="property-label"><g:message code="horario.horaFinal.label" default="Hora Final" /></span>
					
						<span class="property-value" aria-labelledby="horaFinal-label"><g:fieldValue bean="${horarioInstance}" field="horaFinal"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${horarioInstance?.ocupado}">
				<li class="fieldcontain">
					<span id="ocupado-label" class="property-label"><g:message code="horario.ocupado.label" default="Ocupado" /></span>
					
						<span class="property-value" aria-labelledby="ocupado-label"><g:formatBoolean boolean="${horarioInstance?.ocupado}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:horarioInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${horarioInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
