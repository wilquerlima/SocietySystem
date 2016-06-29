package pages

import geb.Page

/**
 * Created by USER on 21/05/2016.
 */
class OfferActivationPage extends Page{
    static url = "/SocietySystem/offer/index"

    static at =  {
        title ==~ /Offer Listagem/
    }

    boolean createOffer(offerDescription) {
        $("form").description = offerDescription
        $("input", name: "create").click()
    }

    def chooseOffer(offerDesc) {
        $("a",text: offerDesc).click()
    }

    boolean offerIsActivated(String offerDesc){
        $("tr", class: "green").has("a",text: offerDesc)
    }

    boolean check(String description){
        $("tr", class: "green").has("a",text: description)
    }


}