this.metaClass(cucumber.api.groovy.Hooks)
this.metaClass(cucumber.api.groovy.EN)


import Society.SocietyController
import pages.PeladaList
import pages.SocietyPage
import pages.MatchNotification

import static cucumber.api.groovy.EN.*

Given(~'^I am at the main screen$') { ->
    to SocietyPage
    at SocietyPage
}

And(~'I create 2 football match "([^"]*)", "([^"]*)"$'){ String match1,match2 ->
    to SocietyPage
    at SocietyPage
    page.criarPelada(match1)
    to SocietyPage
    at SocietyPage
    page.criarPelada(match2)
}

And(~'I have a football match on the day$'){
    to SocietyPage
    at SocietyPage
}

When(~'^I check my Pelada\'s List$') { ->
    to PeladaList
    at PeladaList
}

Then(~'^A notification message shows that there is a football match on the day$') {  ->
    to MatchNotification
    at MatchNotification
}


def criarPelada(String descricao, Date hora ,SocietyController controlador) {
    controlador.params << [pelada: descricao, dataHoje: hora]
    controlador.save()
    controlador.response.reset()
}

Given(~'^The system has a registered Society with name "([^"]*)" and date "([^"]*)"$') { String nomePelada, Date hora->
    def controlador = new SocietyController()
    criarPelada(nomePelada,hora,controlador)
}

When(~'^I try to save a Society with name "([^"]*)" and date "([^"]*)"$') { String nomePelada, Date hora ->
    def controlador = new SocietyController()
    criarPelada(nomePelada, hora, controlador)
}

Then(~'^The system does not allow$') {  ->
    def controlador = new SocietyController()

}