package support


import societysystem.Offer
import geb.Browser
import geb.binding.BindingUpdater
import org.codehaus.groovy.grails.test.support.GrailsTestRequestEnvironmentInterceptor
import societysystem.Offer


import static cucumber.api.groovy.Hooks.*

Before () {
    bindingUpdater = new BindingUpdater(binding, new Browser())
    bindingUpdater.initialize()
    scenarioInterceptor = new GrailsTestRequestEnvironmentInterceptor (appCtx)
    scenarioInterceptor.init ()
}

After () {

    Offer.list().each { offer ->
        offer.delete(flush:true)
    }

    scenarioInterceptor.destroy ()
    bindingUpdater.remove ()
}