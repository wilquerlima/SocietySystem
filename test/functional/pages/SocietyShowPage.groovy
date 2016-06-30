package pages

import geb.Page
/**
 * Created by felip_000 on 06/21/16.
 */
public class SocietyShowPage extends Page {
    static url = "/SocietySystem/society/show/1"

    static at = {
        title ==~ /Show Society/
    }
    static content = {
        maxProfit {$('span', id: 'maxProfit')}
    }
}
