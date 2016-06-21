
<%@ pages import="societysystem.Pagamento" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pagamento.label', default: 'Pagamento')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-pagamento" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-pagamento" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="valor" title="${message(code: 'pagamento.valor.label', default: 'Valor')}" />
					
						<g:sortableColumn property="numeroCartao" title="${message(code: 'pagamento.numeroCartao.label', default: 'Numero Cartao')}" />
					
						<g:sortableColumn property="nomeCartao" title="${message(code: 'pagamento.nomeCartao.label', default: 'Nome Cartao')}" />
					
						<g:sortableColumn property="codigoSeg" title="${message(code: 'pagamento.codigoSeg.label', default: 'Codigo Seg')}" />
					
						<th><g:message code="pagamento.horario.label" default="Horario" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${pagamentoInstanceList}" status="i" var="pagamentoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${pagamentoInstance.id}">${fieldValue(bean: pagamentoInstance, field: "valor")}</g:link></td>
					
						<td>${fieldValue(bean: pagamentoInstance, field: "numeroCartao")}</td>
					
						<td>${fieldValue(bean: pagamentoInstance, field: "nomeCartao")}</td>
					
						<td>${fieldValue(bean: pagamentoInstance, field: "codigoSeg")}</td>
					
						<td>${fieldValue(bean: pagamentoInstance, field: "horario")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${pagamentoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
