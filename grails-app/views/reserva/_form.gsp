<%@ page import="societysystem.Reserva" %>



<div class="fieldcontain ${hasErrors(bean: reservaInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="reserva.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${reservaInstance?.nome}"/>

</div>

