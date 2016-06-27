package pages

import geb.Page

/**
 * Created by USER on 21/06/2016.
 */
class SearchSocietiesPage extends Page {
    static url = "/SocietySystem/society/overview"

    static at = {
        title ==~ /Search results/
    }

    boolean socIsAvailable(name) {
        $("tr", class: "green").has("a",text: name)
    }
}
