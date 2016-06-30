
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
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-pagamento" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list pagamento">
			
				<g:if test="${pagamentoInstance?.valor}">
				<li class="fieldcontain">
					<span id="valor-label" class="property-label"><g:message code="pagamento.valor.label" default="Valor" /></span>
					
						<span class="property-value" aria-labelledby="valor-label"><g:fieldValue bean="${pagamentoInstance}" field="valor"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${pagamentoInstance?.numeroCartao}">
				<li class="fieldcontain">
					<span id="numeroCartao-label" class="property-label"><g:message code="pagamento.numeroCartao.label" default="Numero Cartao" /></span>
					
						<span class="property-value" aria-labelledby="numeroCartao-label"><g:fieldValue bean="${pagamentoInstance}" field="numeroCartao"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${pagamentoInstance?.nomeCartao}">
				<li class="fieldcontain">
					<span id="nomeCartao-label" class="property-label"><g:message code="pagamento.nomeCartao.label" default="Nome Cartao" /></span>
					
						<span class="property-value" aria-labelledby="nomeCartao-label"><g:fieldValue bean="${pagamentoInstance}" field="nomeCartao"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${pagamentoInstance?.codigoSeg}">
				<li class="fieldcontain">
					<span id="codigoSeg-label" class="property-label"><g:message code="pagamento.codigoSeg.label" default="Codigo Seg" /></span>
					
						<span class="property-value" aria-labelledby="codigoSeg-label"><g:fieldValue bean="${pagamentoInstance}" field="codigoSeg"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${pagamentoInstance?.horario}">
				<li class="fieldcontain">
					<span id="horario-label" class="property-label"><g:message code="pagamento.horario.label" default="Horario" /></span>
					
						<span class="property-value" aria-labelledby="horario-label"><g:link controller="horario" action="show" id="${pagamentoInstance?.horario?.id}">${pagamentoInstance?.horario?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:pagamentoInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${pagamentoInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
