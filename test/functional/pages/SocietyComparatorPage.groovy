package pages

import geb.Page

/**
 * Created by USER on 17/06/2016.
 */
class SocietyComparatorPage extends Page {
    static url = "SocietySystem/society/search"

    static at = {
        title ==~ /Society search/
    }

    boolean addSchedule
}
