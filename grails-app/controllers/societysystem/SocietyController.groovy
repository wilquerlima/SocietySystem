package societysystem


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SocietyController {

    static allowedMethods = [ update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Society.list(params), model: [societyInstanceCount: Society.count()]
    }

    def show(Society societyInstance) {
        respond societyInstance
    }

    def create() {
        respond new Society(params)
    }

    @Transactional
    def save(Society societyInstance) {
        if (societyInstance == null) {
            notFound()
            return
        }

        if (societyInstance.hasErrors()) {
            respond societyInstance.errors, view: 'create'
            return
        }

        societyInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'society.label', default: 'Society'), societyInstance.id])
                redirect societyInstance
            }
            '*' { respond societyInstance, [status: CREATED] }
        }
    }

    def edit(Society societyInstance) {
        respond societyInstance
    }

    @Transactional
    def update(Society societyInstance) {
        if (societyInstance == null) {
            notFound()
            return
        }

        if (societyInstance.hasErrors()) {
            respond societyInstance.errors, view: 'edit'
            return
        }

        societyInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Society.label', default: 'Society'), societyInstance.id])
                redirect societyInstance
            }
            '*' { respond societyInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Society societyInstance) {

        if (societyInstance == null) {
            notFound()
            return
        }

        societyInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Society.label', default: 'Society'), societyInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'society.label', default: 'Society'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }

    //Este metodo retorna a soma dos valores de todos os Fields que foram agendados somados
    def sumFields(){
        Society c = Society.get(params.id)
        int sum = 0
        c.fields.each {
            sum += it.value
        }
        render (view:'profit',[fields: c.getFields()])
    }

    def result(){
        render (view:"common/result")
    }
}
