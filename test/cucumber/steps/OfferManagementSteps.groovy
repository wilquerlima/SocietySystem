package steps

import pages.CreatePage
import pages.OfferActivationPage
import pages.SocietySettingsPage
import societysystem.Offer
import societysystem.OfferController
import static cucumber.api.groovy.EN.*

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

Given(~'^The offer "([^"]*)" is already created$'){String description ->
    to CreatePage
    at CreatePage
    page.createOffer(description)

}

And(~'^I am at "([^"]*)" page$'){ String ignore ->
    to OfferActivationPage
    at OfferActivationPage
}

When(~'^i choose the offer "([^"]*)"$') { String offerDesc ->
    at OfferActivationPage
    page.chooseOffer(offerDesc)
}

Then(~'^The offer "([^"]*)" is set as activated$'){ String offerDesc ->
    at OfferActivationPage
    assert offerIsActivated(offerDesc) == true
}

def createOffer(String description, String id, OfferController controller) {
    controller.params << [description: description, id: id, activated: false]
    controller.save()
    controller.response.reset()
}

boolean offerIsActivated(String offerDesc){
    Offer c = Offer.findByDescription(offerDesc)
    return c.activated
}

