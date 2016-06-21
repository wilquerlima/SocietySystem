package steps

import pages.Confirm
import pages.CreateHorario
import pages.CriarCampo
import pages.PaymentPage
import pages.VerCampo
import pages.VerHorarios
import societysystem.Horario
import societysystem.HorarioController

import static cucumber.api.groovy.EN.*

ocupadas = false


Given(~/^I have already chosen the available schedule "([^"]*)","([^"]*)","([^"]*)" at field "([^"]*)"$/) {String dia,String ini,String fim,String field ->
    to CreateHorario
    at CreateHorario
    page.criaHorario(dia,ini,fim)
    to CriarCampo
    at CriarCampo
    page.criarCampo(field,"100")
    to VerCampo
    at VerCampo
    page.selecionarCampo(field)
    to VerHorarios
    at VerHorarios
    page.selecionarHorario(ini)
    page.selecionarPagar()
}
When(~/^I fill the fields with "([^"]*)","([^"]*)","([^"]*)" and "([^"]*)"$/) { String valor, String num, String nome,String cod ->
    to PaymentPage
    at PaymentPage
    page.fazerPagamento(valor,num,nome,cod)
}
Then(~/^a confirmation message is displayed$/) { ->
    to Confirm
    at Confirm
}


def criarEReservarHorario(String dia,String ini,String fim, HorarioController controlador) {
    criarHorario(dia,ini,fim, controlador)
    controlador.select(Horario.findByHoraInicial(ini).id)
    controlador.response.reset()
}

def criarHorario(String dia,String ini,String fim, HorarioController controlador) {
    controlador.params << [dia: dia,horaInicial:ini,horaFinal:fim, ocupado: false]
    controlador.save()
    controlador.response.reset()
}

boolean todasOcupadas(horarios) {
    boolean r = true
     horarios.each { horario ->
        r = r && horario.ocupado
    }
    return r
}

Given(~/^that all the schedules are occupied$/) { ->
    def controlador=new HorarioController()
    criarEReservarHorario("12/06/2016","17:00","18:00",controlador)
    criarEReservarHorario("12/06/2016","18:01","19:00",controlador)
    criarEReservarHorario("12/06/2016","19:01","20:00",controlador)
    assert Horario.findByOcupado(false)==null

}

When(~/^I try to reservate an schedule$/) { ->
    ocupadas=todasOcupadas(Horario.list())
    def controlador = new HorarioController()
    controlador.book()

}
Then(~/^The system makes no reservation$/) { ->
    assert ocupadas == todasOcupadas(Horario.list())
}

Given(~/^some schedules are not occupied$/) { ->
    def controlador = new HorarioController()
    criarEReservarHorario("12/06/2016","15:00","16:00",controlador)
    criarEReservarHorario("12/06/2016","16:01","17:00",controlador)
    criarHorario("12/06/2016","17:01","18:00",controlador)
}
Then(~/^The system makes a reservation$/) { ->
    assert (!ocupadas)==todasOcupadas(Horario.list())
}