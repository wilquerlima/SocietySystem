package societysystem



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class OfferController {

    static allowedMethods = [update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Offer.list(params), model:[offerInstanceCount: Offer.count()]
    }

    def book() {
        def offer = Offer.findByActivated(false)
        if (offer != null) {
            offer.select()
            offer.save(flush:true)
            flash.message = "Offer activated"
        } else {
            flash.message = "Offer already activated"
        }
        redirect(action: "index")
    }

    def show(Offer offerInstance) {
        respond offerInstance
    }

    def create() {
        respond new Offer(params)
    }

    @Transactional
    def save(Offer offerInstance) {
        if (offerInstance == null) {
            notFound()
            return
        }

        if (offerInstance.hasErrors()) {
            respond offerInstance.errors, view:'create'
            return
        }

        offerInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'offer.label', default: 'Offer'), offerInstance.id])
                redirect offerInstance
            }
            '*' { respond offerInstance, [status: CREATED] }
        }
    }

    def edit(Offer offerInstance) {
        respond offerInstance
    }

    @Transactional
    def update(Offer offerInstance) {
        if (offerInstance == null) {
            notFound()
            return
        }

        if (offerInstance.hasErrors()) {
            respond offerInstance.errors, view:'edit'
            return
        }

        offerInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Offer.label', default: 'Offer'), offerInstance.id])
                redirect offerInstance
            }
            '*'{ respond offerInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Offer offerInstance) {

        if (offerInstance == null) {
            notFound()
            return
        }

        offerInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Offer.label', default: 'Offer'), offerInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'offer.label', default: 'Offer'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
