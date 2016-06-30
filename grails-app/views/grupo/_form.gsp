<%@ page import="societysystem.Grupo" %>



<div class="fieldcontain ${hasErrors(bean: grupoInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="grupo.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${grupoInstance?.nome}"/>

</div>

