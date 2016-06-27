package pages

import geb.Page


class IndexSocietyPage extends Page {
    static url = "/SocietySystem/society/index"

    static at = {
        title ==~/Society Listagem/
    }

    boolean gotoSearch(){
        $("input", name: "Search available societies").click()
    }
}
