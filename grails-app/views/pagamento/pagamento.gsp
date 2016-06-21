
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'pagamento.label', default: 'Pagamento')}" />
    <title><g:message code="Pagamento" args="[entityName]" /></title>
</head>
<body>
<a href="#create-pagamento" class="skip" tabindex="-1"><g:message code="" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>

    </ul>
</div>
<div id="list-pagamento" class="content scaffold-list" role="main">
    <h1>Preencha os campos abaixo</h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:form url="[resource:pagamentoInstance, action:'concluir']" >
        <fieldset class="form">
            <g:render template="form"/>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="concluir"  value="${message(code: 'concluir', default: 'Concluir')}" />
        </fieldset>
    </g:form>

    <div class="pagination">
        <g:paginate total="${pagamentoInstanceCount ?: 0}" />
    </div>
</div>
</body>
</html>

