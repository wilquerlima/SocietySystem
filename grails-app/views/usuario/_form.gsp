<%@ page import="societysystem.Usuario" %>



<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'cpf', 'error')} required">
	<label for="cpf">
		<g:message code="usuario.cpf.label" default="Cpf" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="cpf" required="" value="${usuarioInstance?.cpf}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="usuario.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${usuarioInstance?.nome}"/>

</div>

