package societysystem



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class GrupoController {

    static allowedMethods = [update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Grupo.list(params), model:[grupoInstanceCount: Grupo.count()]
    }

    def show(Grupo grupoInstance) {
        respond grupoInstance
    }

    def create() {
        respond new Grupo(params)
    }

    def criarGrupo(String nome, int id){
        def grupo = new Grupo( id:id, nome:nome)
        grupo.save(flush:true)

    }

    @Transactional
    def save() {
        Grupo grupoInstance = new Grupo(params)

        if (!grupoInstance.save(flush: true)) {
            render(view: "create", model: [grupoInstance: grupoInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'default.list.label', default: 'grupo'), grupoInstance.id])
        redirect(action: "show", id: grupoInstance.id)
    }

    def edit(Grupo grupoInstance) {
        respond grupoInstance
    }

    @Transactional
    def update(Grupo grupoInstance) {
        if (grupoInstance == null) {
            notFound()
            return
        }

        if (grupoInstance.hasErrors()) {
            respond grupoInstance.errors, view:'edit'
            return
        }

        grupoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Grupo.label', default: 'Grupo'), grupoInstance.id])
                redirect grupoInstance
            }
            '*'{ respond grupoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Grupo grupoInstance) {

        if (grupoInstance == null) {
            notFound()
            return
        }

        grupoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Grupo.label', default: 'Grupo'), grupoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'grupo.label', default: 'Grupo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
