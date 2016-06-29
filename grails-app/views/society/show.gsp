
<%@ page import="societysystem.Society" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'society.label', default: 'Society')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-society" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-society" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list society">
			

				<g:if test="${societyInstance?.code}">
				<li class="fieldcontain">
					<span id="code-label" class="property-label"><g:message code="society.code.label" default="Code" /></span>
					
						<span class="property-value" aria-labelledby="code-label"><g:fieldValue bean="${societyInstance}" field="code"/></span>

				<g:if test="${societyInstance?.available}">
				<li class="fieldcontain">
					<span id="available-label" class="property-label"><g:message code="society.available.label" default="Available" /></span>
					
						<span class="property-value" aria-labelledby="available-label"><g:formatBoolean boolean="${societyInstance?.available}" /></span>

					
				</li>
				</g:if>
			


				<g:if test="${societyInstance?.fields}">
					<li class="fieldcontain">
						<span class="property-label" >Profit</span>
						<span class="property-value" id="maxProfit">${maxProfit}</span>
					</li>

				<g:if test="${societyInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="society.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${societyInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${societyInstance?.schedules}">
				<li class="fieldcontain">
					<span id="schedules-label" class="property-label"><g:message code="society.schedules.label" default="Schedules" /></span>
					
						<g:each in="${societyInstance.schedules}" var="s">
						<span class="property-value" aria-labelledby="schedules-label"><g:link controller="schedule" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>

				</g:if>
			
			</ol>
			<g:form url="[resource:societyInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${societyInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />

					<g:link class="addfield" action="addField" resource="${societyInstance}">Add Field</g:link>

				</fieldset>
			</g:form>
		</div>
	</body>
</html>
