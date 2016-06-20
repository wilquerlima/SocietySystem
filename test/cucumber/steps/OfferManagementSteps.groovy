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

def createOffer(String description, OfferController controller) {
    Offer off = new Offer(description: description, activated: false)
    controller.save(off)
    controller.response.reset()
}

def createAndActivate(String offerDesc, OfferController control) {
    createOffer(offerDesc, control)
    control.select(Offer.findByDescription(offerDesc).id)
    control.response.reset()
}

boolean offerIsActivated(String offerDesc){
    Offer c = Offer.findByDescription(offerDesc)
    return c.activated
}

def deleteOffer(String offerDesc, OfferController control){
    Offer temp = Offer.findByDescription(offerDesc)
    if( temp != null){
        if(temp.activated == true){
            return
        } else {
            control.delete(temp)
        }
    } else {
        return
    }
}

Given (~'^The offer "([^"]*)" is already created and activated$'){ String offerDesc ->
    def control = new OfferController()
    createAndActivate(offerDesc, control)
    assert Offer.findByDescription(offerDesc) != null

}

When(~'^I try to delete the offer "([^"]*)"$'){ String offerDesc ->
    def control = new OfferController()
    deleteOffer(offerDesc, control)

}

Then(~'^The system will not delete the offer "([^"]*)"$'){ String offerDesc ->
    assert Offer.findByDescription(offerDesc) != null

}



