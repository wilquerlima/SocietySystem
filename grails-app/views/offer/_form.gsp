<%@ page import="societysystem.Offer" %>



<div class="fieldcontain ${hasErrors(bean: offerInstance, field: 'activated', 'error')} ">
	<label for="activated">
		<g:message code="offer.activated.label" default="Activated" />
		
	</label>
	<g:checkBox name="activated" value="${offerInstance?.activated}" />

</div>

<div class="fieldcontain ${hasErrors(bean: offerInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="offer.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${offerInstance?.description}"/>

</div>

