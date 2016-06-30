package support

import societysystem.*


import geb.Browser
import geb.binding.BindingUpdater
import org.codehaus.groovy.grails.test.support.GrailsTestRequestEnvironmentInterceptor

import static cucumber.api.groovy.Hooks.*


def bindingUpdater
def scenarioInterceptor


Before () {
    bindingUpdater = new BindingUpdater(binding, new Browser())
    bindingUpdater.initialize()
    scenarioInterceptor = new GrailsTestRequestEnvironmentInterceptor (appCtx)
    scenarioInterceptor.init ()
}

After () {


    Grupo.list().each { grupo ->
        grupo.delete(flush:true)
    }
    Usuario.list().each{
        usuario ->
            usuario.delete(flush:true)
    }


    Pessoa.list().each { pessoa ->
        Pessoa.delete(flush:true)
    }


    Offer.list().each { offer ->
        offer.delete(flush:true)
    }



    Horario.list().each { horario ->
        horario.delete(flush:true)
    }
    Pagamento.list().each { pagamento ->
        pagamento.delete(flush:true)
    }

    scenarioInterceptor.destroy ()
    bindingUpdater.remove ()
}