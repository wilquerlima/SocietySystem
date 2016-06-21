package societysystem



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class HorarioController {

    static allowedMethods = [ update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Horario.list(params), model:[horarioInstanceCount: Horario.count()]
    }

    def select(Long id){
        def horario= Horario.get(id)
        if(!horario){
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'horario.label', default: 'Horario'), id])
            redirect(action: "index")
            return
        }
            horario.selectEscolha()
        if (!horario.save(flush: true)) {
            flash.message = "Horário não pode ser reservado! Problema interno na gravação!\n" + horario.errors
        }
        redirect(action: "index")
    }
    def book(){
        def horario = Horario.findByOcupado(false)
        if (horario != null) {
            horario.select()
            horario.save(flush:true)
            flash.message = "Horario reservado"
        } else {
            flash.message = "Horario indisponível"
        }
        redirect(action: "index")

    }


    def show(Horario horarioInstance) {
        respond horarioInstance
    }

    def create() {
        respond new Horario(params)
    }
    @Transactional
    def save() {
        def horarioInstance = new Horario(params)
        if (!horarioInstance.save(flush: true)) {
            render(view: "create", model: [horarioInstance: horarioInstance])
            return
        }
        flash.message = message(code: 'default.created.message', args: [message(code: 'horario.label', default: 'Horario'), horarioInstance.id])
        redirect(action: "show", id: horarioInstance.id)
    }

    @Transactional
    def savee(Horario horarioInstance) {
        if (horarioInstance == null) {
            notFound()
            return
        }

        if (horarioInstance.hasErrors()) {
            respond horarioInstance.errors, view:'create'
            return
        }

        horarioInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'horario.label', default: 'Horario'), horarioInstance.id])
                redirect horarioInstance
            }
            '*' { respond horarioInstance, [status: CREATED] }
        }
    }

    def edit(Horario horarioInstance) {
        respond horarioInstance
    }

    @Transactional
    def update(Horario horarioInstance) {
        if (horarioInstance == null) {
            notFound()
            return
        }

        if (horarioInstance.hasErrors()) {
            respond horarioInstance.errors, view:'edit'
            return
        }

        horarioInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Horario.label', default: 'Horario'), horarioInstance.id])
                redirect horarioInstance
            }
            '*'{ respond horarioInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Horario horarioInstance) {

        if (horarioInstance == null) {
            notFound()
            return
        }

        horarioInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Horario.label', default: 'Horario'), horarioInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'horario.label', default: 'Horario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
