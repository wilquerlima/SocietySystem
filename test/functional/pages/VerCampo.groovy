package pages

import geb.Page

/**
 * Created by Otávio Vera Cruz on 21/06/2016.
 */
class VerCampo extends Page{
    static url = "/SocietySystem/campo/index/"
    static at = {
        title==~/Campo Listagem/
    }
    boolean selecionarCampo(nome){
        $("a",text:nome).click()
    }
}
