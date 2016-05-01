/**
 * Created by felip_000 on 05/01/16.
 */


import cucumber.api.PendingException
import pages.Society.SocietyList
import pages.Society.Society

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)


Given(~'^Usuario cadastrou campo com o nome ([^"]*) ao seu Society.Society $') {
    String campoNome, IDSociety -> assert SocietyManager.getSociety(IDSociety).Cadastrar(campoNome)
}

When(~"^Estou na pagina 'detalhes do campo X'") {
    to Society.Detalhe
    at Society.Detalhe
}

Then(~'^A lista de campos cadastrados o Society.Society (.*) e atualizada com o campo (.*) $'){
    throw new PendingException()
}


/*
* Scenario: Cadastrar Campo "B" a Lista de Campos de um Society.Society "C"
* */

Given(~'^eu estou na tela de cadastro de Campos de um Society.Society'){->
    to SocietyPage.CadastrarCampo
    at SocietyPage.CadastrarCampo
}

