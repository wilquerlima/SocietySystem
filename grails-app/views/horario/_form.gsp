<%@ pages import="societysystem.Horario" %>



<div class="fieldcontain ${hasErrors(bean: horarioInstance, field: 'dia', 'error')} required">
	<label for="dia">
		<g:message code="horario.dia.label" default="Dia" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="dia" required="" value="${horarioInstance?.dia}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: horarioInstance, field: 'horaInicial', 'error')} required">
	<label for="horaInicial">
		<g:message code="horario.horaInicial.label" default="Hora Inicial" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="horaInicial" required="" value="${horarioInstance?.horaInicial}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: horarioInstance, field: 'horaFinal', 'error')} required">
	<label for="horaFinal">
		<g:message code="horario.horaFinal.label" default="Hora Final" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="horaFinal" required="" value="${horarioInstance?.horaFinal}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: horarioInstance, field: 'ocupado', 'error')} ">
	<label for="ocupado">
		<g:message code="horario.ocupado.label" default="Ocupado" />
		
	</label>
	<g:checkBox name="ocupado" value="${horarioInstance?.ocupado}" />

</div>

