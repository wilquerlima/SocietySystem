<%@ page import="societysystem.Pessoa" %>



<div class="fieldcontain ${hasErrors(bean: pessoaInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="pessoa.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${pessoaInstance?.nome}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pessoaInstance, field: 'senha', 'error')} required">
	<label for="senha">
		<g:message code="pessoa.senha.label" default="Senha" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="senha" required="" value="${pessoaInstance?.senha}"/>
</div>

