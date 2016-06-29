<%@ page import="societysystem.Pessoa" %>

<div class="fieldcontain ${hasErrors(field: 'login', 'error')} required">
    <label for="login">
        <g:message code="Login" default="Login" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="login" required="" value="${login}"/>

</div>

<div class="fieldcontain ${hasErrors(field: 'senhaAtual', 'error')} required">
    <label for="senhaAtual">
        <g:message code="Senha atual" default="Senha atual" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="senhaAtual" required="" value="${senhaAtual}"/>

</div>

<div class="fieldcontain ${hasErrors(field: 'senhaNova', 'error')} required">
    <label for="senhaNova">
        <g:message code="Senha nova" default="Senha nova" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="senhaNova" required="" value="${senhaNova}"/>

</div>
