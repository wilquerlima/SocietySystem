package pages

import geb.Page

/**
 * Created by Otávio Vera Cruz on 21/06/2016.
 */
class CriarCampo extends Page{
    static url = "/SocietySystem/campo/create/"
    static at = {
        title ==~ /Criar Campo/
    }
    boolean criarCampo(String nome,String valor){
        $("form").nome=nome
        $("form").valor=valor
        $("input",text:"create").click()
    }
}
