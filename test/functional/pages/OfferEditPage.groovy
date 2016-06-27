package pages

import geb.Page

/**
 * Created by USER on 26/06/2016.
 */
class OfferEditPage extends Page {
    static url = "/SocietySystem/offer/show/1"

    static at = {
        title ==~/Ver Offer/
    }

    boolean deleteOffer(){
        $("input", name: "delete").click()
    }
}
