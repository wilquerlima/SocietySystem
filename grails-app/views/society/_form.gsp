<%@ page import="societysystem.Society" %>




<div class="fieldcontain ${hasErrors(bean: societyInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="society.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${societyInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: societyInstance, field: 'schedules', 'error')} ">
	<label for="schedules">
		<g:message code="society.schedules.label" default="Schedules" />

	</label>
	<g:select  optionValue="time" name="schedules" from="${societysystem.Schedule.list()}" multiple="multiple" optionKey="id" size="5" value="${societyInstance?.schedules*.id}" class="many-to-many"/>


</div>

