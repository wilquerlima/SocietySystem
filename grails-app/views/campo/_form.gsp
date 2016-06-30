<%@ pages import="societysystem.Campo" %>



<div class="fieldcontain ${hasErrors(bean: campoInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="campo.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${campoInstance?.nome}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: campoInstance, field: 'horarios', 'error')} ">
	<label for="horarios">
		<g:message code="campo.horarios.label" default="Horarios" />
		
	</label>
	<g:select name="horarios" from="${societysystem.Horario.list()}" multiple="multiple" optionKey="id" size="5" value="${campoInstance?.horarios*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: campoInstance, field: 'valor', 'error')} required">
	<label for="valor">
		<g:message code="campo.valor.label" default="Valor" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="valor" value="${fieldValue(bean: campoInstance, field: 'valor')}" required=""/>

</div>

