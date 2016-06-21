/**
 * Created by felip_000 on 06/16/16.
 */


import pages.SocietyAddFieldPage
import steps.TestAndDataOperations

import static cucumber.api.groovy.EN.*
import societysystem.Field
import societysystem.Society

Given(~'^I am at the Society Show Page$'){->
    to SocietyDetailPage
    at SocietyDetailPage
}

When(~'^I look for the field at the Profit Value$'){->}

Then(~'^The sum of all Booked Fields values summed is shown$'){->}


Given(~'^I have some Fields Booked that belong to a Society "([^"]*)"$'){ String societyName ->
    Field f1 = new Field(name: 'f1', value: 40, booked: true)
    Field f2 = new Field(name: 'f2', value: 30, booked: true)
    Field f3 = new Field(name: 'f3', value: 20, booked: false)
    t = new TestAndDataOperations()
    t.cadastrarCampo(f1)
    t.cadastrarCampo(f2)
    t.cadastrarCampo(f3)
    Society s1 = new Society(nome: societyName, code: 3, fields: [])
    s1.addToFields(f1)
    s1.addToFields(f2)
    s1.addToFields(f3)
    t.saveSociety(s1)
}

When(~'^I want to see how much I am gonna make in total$'){->
    assert true
}
Then(~'^The system returns the sum of all "([^"]*)" Fields Value$'){String societyName ->
    assert t.returnProfit(societyName) == 70
}


Given(~'^I am at the Society Add Field Page of "([^"]*)"$'){ societyName ->
    def s1 = new Society(name: "s1")
    s1.save()

    to SocietyAddFieldPage
    at SocietyAddFieldPage
}

When(~'I try to add a field "([^"]*)" on society "([^"]*)"^$'){ fieldName, societyName ->
    page.nameField.text = fieldName
    page.submit.click()
}

Then(~'^"([^"]*)" now has a non empty list of fields$'){ societyName ->
    def s1 = Society.findByName("societyName")
    assert s1.fields != null
}
