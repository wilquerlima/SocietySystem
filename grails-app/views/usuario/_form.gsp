<%@ page import="societysystem.Usuario" %>



<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'cpf', 'error')} required">
	<label for="cpf">
		<g:message code="usuario.cpf.label" default="Cpf" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="cpf" required="" value="${usuarioInstance?.cpf}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'idGrupo', 'error')} required">
	<label for="idGrupo">
		<g:message code="usuario.idGrupo.label" default="Id Grupo" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="idGrupo" type="number" value="${usuarioInstance.idGrupo}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'isOwner', 'error')} ">
	<label for="isOwner">
		<g:message code="usuario.isOwner.label" default="Is Owner" />
		
	</label>
	<g:checkBox name="isOwner" value="${usuarioInstance?.isOwner}" />

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="usuario.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${usuarioInstance?.nome}"/>

</div>

