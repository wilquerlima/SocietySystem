package steps

import pages.SocietySettingsPage

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

Given(~'^The offer "([^"]*)" with id "([^"]*)" exists$'){String description, id ->
    def controller = new OfferController()
    createOffer(description, id, controller)

}

And(~'^I am at the "Offer activation" page$'){
    to OfferActivationPage
    at OfferActivationPage
}

When(~'^i choose the offer "([^"]*)"$') { String offerDesc ->
    at OfferActivationPage
    page.chooseOffer(offerDesc)
}

Then(~'^The offer "([^"]*)" is set as activated$'){ String offerDesc ->
    at OfferActivationPage
    assert page.offerIsActivated(offerDesc)
}