package support

import societysystem.Horario

import societysystem.Pagamento
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
    Horario.list().each { horario ->
        horario.delete(flush:true)
    }
    Pagamento.list().each { pagamento ->
        pagamento.delete(flush:true)
    }
    scenarioInterceptor.destroy ()
    bindingUpdater.remove ()
}