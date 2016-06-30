package pages

import geb.Page

/**
*  Created by Otávio Vera Cruz on 18/06/2016.
*/
class Confirm extends Page {
    static url = "/SocietySystem/pagamento/overview/"
    static at = {
        title ==~ /Ver Pagamento/
    }
}
