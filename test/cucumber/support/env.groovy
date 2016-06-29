package support


import societysystem.*
import geb.Browser
import geb.binding.BindingUpdater
import org.codehaus.groovy.grails.test.support.GrailsTestRequestEnvironmentInterceptor


import static cucumber.api.groovy.Hooks.*

Before () {
    bindingUpdater = new BindingUpdater(binding, new Browser())
    bindingUpdater.initialize()
    scenarioInterceptor = new GrailsTestRequestEnvironmentInterceptor (appCtx)
    scenarioInterceptor.init ()
}

After () {

    Pessoa.list().each { pessoa ->
        Pessoa.delete(flush:true)
    }


    Offer.list().each { offer ->
        offer.delete(flush:true)
    }


    scenarioInterceptor.destroy ()
    bindingUpdater.remove ()
}