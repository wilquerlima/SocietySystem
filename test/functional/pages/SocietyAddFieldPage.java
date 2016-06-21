package pages;

import geb.Page

/**
 * Created by felip_000 on 06/20/16.
 */
public class SocietyAddFieldPage extends Page{
    static url = "/SocietySystem/society/addField"

    static at = {
        title ==~ /Add Field/
    }

    static content = {
        nameField {$('input', id:'fieldName')}
        submit {$('input', id:'confirm')}

    }
}
