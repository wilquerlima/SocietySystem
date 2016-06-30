package pages


import geb.Page

/**
 * Created by felip_000 on 05/29/16.
 */
class RegisterFieldPage extends Page{
    static url = "/SocietySystem/field/create"

    static at = {
        title ==~ /Create Field/
    }

    static content = {
        nameField {$('input', id:'name')}
        submit {$('input', id:'create')}

    }


}
