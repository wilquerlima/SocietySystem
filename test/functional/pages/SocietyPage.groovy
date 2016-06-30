package pages

import geb.Page


class SocietyPage extends Page {
    static url = "/Society/home/"
    static at = {
        title ==~ /Criar Pelada/
    }

    boolean criarPelada(pelada){
        $("form").society = pelada
        $("input", name: "create").click()
    }
}