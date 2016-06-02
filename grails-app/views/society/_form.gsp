<%@ page import="societysystem.Society" %>



<div class="fieldcontain ${hasErrors(bean: societyInstance, field: 'code', 'error')} required">
	<label for="code">
		<g:message code="society.code.label" default="Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="code" type="number" value="${societyInstance.code}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: societyInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="society.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${societyInstance?.nome}"/>

</div>

