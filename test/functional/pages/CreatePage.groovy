package pages

import geb.Page

/**
 * Created by USER on 30/05/2016.
 */
class CreatePage extends Page{

    static url = "/SocietySystem/offer/create"

    static at = {
        title ==~ /Criar Offer/

    }

    boolean createAndActivate(String description){
        $("form").description = description
        $("form").activated = true
        $("input", name: "create").click()
    }

    boolean createOffer(String description) {
        $("form").description = description
        $("input", name: "create").click()
    }



}