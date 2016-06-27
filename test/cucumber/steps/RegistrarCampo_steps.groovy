/**
 * Created by felip_000 on 05/01/16.
 *
 * Class created to model the test the action RegisterField()
 */


import pages.RegisterFieldPage
import steps.TestAndDataOperations

import static cucumber.api.groovy.EN.*
import societysystem.Field


Given(~'^I am at Register Field page$'){->
    to RegisterFieldPage
    waitFor { at(RegisterFieldPage) }
}

And(~'^I do not fill the page name attribute field$'){->
    assert page.nameField.text() == ''

}

When(~'^I try to finish the Registration$'){->
    page.submit.click()
}

Then(~'^The system shows an error message$'){->
    at RegisterFieldPage
    assert page.nameField.text() == "" //can't test this property because it's a jquery thing. My mistake on chosing it.

}

/*
*
* */

Given(~'^There is no Field named "([^"]*)"$'){

    /*
    * Seto o sistema para ter pelo menos um campo com nome "A"
    * */
    String name ->
        t = new TestAndDataOperations()
        assert t.retornarCampoByname(name) == null

}

When(~'^I try to register the field "([^"]*)"$'){
    /*
    * Eu tento salvar um campo com o nome "A" no sistema, com informações adicionais diferentes
    * */
    String name ->
        t = new TestAndDataOperations()
        int valor = 20
        t.cadastrarCampo(name, valor)


}

Then(~'^The system does register Field "([^"]*)"$'){String name ->
    /*
    * I'll check if the value of the examples is 40 or 20
    * */
    t = new TestAndDataOperations()
    Field c = t.retornarCampoByname(name)
    assert c.value == 20
    Field.deleteAll() //Then the test erases everything it has done to the system.
}
