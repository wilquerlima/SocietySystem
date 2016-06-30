package pages

import geb.Page

class CreateHorario extends Page{

    static url = "/SocietySystem/horario/create/"

    static at = {
        title ==~ /Criar Horario/
    }
    boolean criaHorario(String dia,String ini,String fim){
        $("form").dia=dia
        $("form").horaInicial=ini
        $("form").horaFinal =fim
        $("input", name: "create").click()
    }
}
