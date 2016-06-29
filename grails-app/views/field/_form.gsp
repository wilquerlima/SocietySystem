<%@ page import="societysystem.Field" %>



<div class="fieldcontain ${hasErrors(bean: fieldInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="field.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${fieldInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: fieldInstance, field: 'value', 'error')} required">
	<label for="value">
		<g:message code="field.value.label" default="Value" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="value" type="number" value="${fieldInstance.value}" required=""/>

</div>

