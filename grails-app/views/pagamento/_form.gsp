<%@ pages import="societysystem.Pagamento" %>



<div class="fieldcontain ${hasErrors(bean: pagamentoInstance, field: 'valor', 'error')} required">
	<label for="valor">
		<g:message code="pagamento.valor.label" default="Valor" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="valor" value="${fieldValue(bean: pagamentoInstance, field: 'valor')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: pagamentoInstance, field: 'numeroCartao', 'error')} required">
	<label for="numeroCartao">
		<g:message code="pagamento.numeroCartao.label" default="Numero Cartao" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="numeroCartao" required="" value="${pagamentoInstance?.numeroCartao}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pagamentoInstance, field: 'nomeCartao', 'error')} required">
	<label for="nomeCartao">
		<g:message code="pagamento.nomeCartao.label" default="Nome Cartao" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nomeCartao" required="" value="${pagamentoInstance?.nomeCartao}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pagamentoInstance, field: 'codigoSeg', 'error')} required">
	<label for="codigoSeg">
		<g:message code="pagamento.codigoSeg.label" default="Codigo Seg" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="codigoSeg" required="" value="${pagamentoInstance?.codigoSeg}"/>

</div>


