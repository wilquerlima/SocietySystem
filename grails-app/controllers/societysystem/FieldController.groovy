package societysystem


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class FieldController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Field.list(params), model: [fieldInstanceCount: Field.count()]
    }

    def show(Field fieldInstance) {
        respond fieldInstance
    }

    def create() {
        respond new Field(params)
    }

    @Transactional
    def save(Field fieldInstance) {
        if (fieldInstance == null) {
            notFound()
            return
        }

        if (fieldInstance.hasErrors()) {
            respond fieldInstance.errors, view: 'create'
            return
        }

        fieldInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'field.label', default: 'Field'), fieldInstance.id])
                redirect fieldInstance
            }
            '*' { respond fieldInstance, [status: CREATED] }
        }
    }

    def edit(Field fieldInstance) {
        respond fieldInstance
    }

    @Transactional
    def update(Field fieldInstance) {
        if (fieldInstance == null) {
            notFound()
            return
        }

        if (fieldInstance.hasErrors()) {
            respond fieldInstance.errors, view: 'edit'
            return
        }

        fieldInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Field.label', default: 'Field'), fieldInstance.id])
                redirect fieldInstance
            }
            '*' { respond fieldInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Field fieldInstance) {

        if (fieldInstance == null) {
            notFound()
            return
        }

        fieldInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Field.label', default: 'Field'), fieldInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'field.label', default: 'Field'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }

    def saveField(Field field){
        if(Field.findByName(field.getName()) == null)
            field.save()
    }

    def details(){
        render view: "details", model: [ field: Field.get(params.id)]
    }


}
