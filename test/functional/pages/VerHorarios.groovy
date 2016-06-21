package pages

import geb.Page

class VerHorarios extends Page {
    static url = "/SocietySystem/horario/index/"
    static at = {
        title ==~ /Horario Listagem/
    }

    boolean selecionarHorario(horario){
        $("a",text:horario).click()
    }
    boolean selecionarPagar(){
        $("input",name:"Pagar").click()
    }
}
