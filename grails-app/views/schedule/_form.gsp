<%@ page import="societysystem.Schedule" %>



<div class="fieldcontain ${hasErrors(bean: scheduleInstance, field: 'isAvaliable', 'error')} ">
	<label for="isAvaliable">
		<g:message code="schedule.isAvaliable.label" default="Is Avaliable" />
		
	</label>
	<g:checkBox name="isAvaliable" value="${scheduleInstance?.isAvaliable}" />

</div>

<div class="fieldcontain ${hasErrors(bean: scheduleInstance, field: 'time', 'error')} required">
	<label for="time">
		<g:message code="schedule.time.label" default="Time" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="time" required="" value="${scheduleInstance?.time}"/>

</div>

