<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'pessoa.label', default: 'Pessoa')}" />
    <title><g:message code="default.create.label" args="[entityName]" /></title>
</head>
<body>
<a href="#create-pessoa" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
    </ul>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
</div>

<div id="create-pessoa" class="content scaffold-create" role="main">
    <h1><g:message code="Alterar senha" args="[entityName]" /></h1>

    <g:hasErrors bean="${pessoaInstance}">
        <ul class="errors" role="alert">
            <g:eachError bean="${pessoaInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form url="[action:'alterar']" >
        <fieldset class="formAlterar">
            <g:render template="formAlterar"/>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="alterar" class="save" value="${message(code: 'Alterar')}" />
        </fieldset>
    </g:form>
</div>
<div id="addPagamento" class="content scaffold-create" role="main">
    <h1><g:message code="Adicionar forma de pagamento" args="[entityName]" /></h1>

    <g:hasErrors bean="${pessoaInstance}">
        <ul class="errors" role="alert">
            <g:eachError bean="${pessoaInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form url="[action:'pagamento']" >
        <fieldset class="buttons">
            <g:submitButton name="pagamento" class="save" value="${message(code: 'Pagamento')}" />
        </fieldset>
    </g:form>
</div>
<div id="fotoPerfil" class="content scaffold-create" role="main">
    <h1><g:message code="Foto Perfil" args="[entityName]" /></h1>

    <g:hasErrors bean="${pessoaInstance}">
        <ul class="errors" role="alert">
            <g:eachError bean="${pessoaInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>



    <g:form action="saveImage" method="post"  enctype="multipart/form-data">
        <div class="dialog">
            <div class="fieldcontain ${hasErrors(field: 'loginImage', 'error')} required">
                <label for="loginImage">
                    <g:message code="Login" default="Login" />
                    <span class="required-indicator">*</span>
                </label>
                <g:textField name="loginImage" required="" value="${loginImage}"/>
            </div>
            <table>
                <tbody>
                <tr class="prop">
                    <td valign="top" class="name">
                        <label for="arquivo"><g:message code="image.arquivo.label" default="Arquivo" /></label>
                    </td>
                    <td valign="top" class="value ${hasErrors(bean: imageInstance, field: 'arquivo', 'errors')}">
                        <input type="file" id="arquivo" name="arquivo" />
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="buttons">
            <span class="button"><g:submitButton name="saveImage" class="save" value="${message(code: 'Alterar Foto')}" /></span>
        </div>
    </g:form>
</div>

<div id="verPerfil" class="content scaffold-create" role="main">
    <h1><g:message code="Ver foto" args="[entityName]" /></h1>
    <div>
        <g:form url="[action:'viewImage']" >
            <fieldset class="buttons">
                <div class="fieldcontain ${hasErrors(field: 'loginFoto', 'error')} required">
                    <label for="loginFoto">
                        <g:message code="Login" default="Login" />
                        <span class="required-indicator">*</span>
                    </label>
                    <g:textField name="loginFoto" required="" value="${loginFoto}"/>
                </div>
                <g:submitButton name="ver" class="save" value="${message(code: 'Ver Foto')}" />
            </fieldset>
        </g:form>
    </div>
</div>
</body>
</html>
