package societysystem

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ImageController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Image.list(params), model:[imageInstanceCount: Image.count()]
    }

    def show(Image imageInstance) {
        respond imageInstance
    }

    def create() {
        respond new Image(params)
    }


    @Transactional
    def save(Image imageInstance) {
        //def imageInstance = new Image(params)

        if (imageInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'image.label', default: 'Image'), imageInstance.id])}"

            upload(imageInstance)
            return
            //redirect(action: "show", id: imageInstance.id)
        }
        else {
            return
            //render(view: "create", model: [imageInstance: imageInstance])
        }
    }

    def upload = { Image imageInstance ->

        def nomeOriginal = params.arquivo.originalFilename
        imageInstance.arquivo = nomeOriginal
        String fotoPerfil = imageInstance.getPessoa().getNome()

        def f = request.getFile("arquivo")

        if(!f.empty){
            // CONFIGURAR O CAMINHO CORRETO
            f.transferTo(new File("C:\\Users\\MANOEL PERGENTINO\\Documents\\Ciência da Computação\\Engenharia de Software\\SocietySystem\\Society\\SocietySystem\\${fotoPerfil}.jpg"))
        }else{
            flash.message = "não foi possível transferir o arquivo"
        }
    }
    def edit(Image imageInstance) {
        respond imageInstance
    }

    @Transactional
    def update(Image imageInstance) {
        if (imageInstance == null) {
            notFound()
            return
        }

        if (imageInstance.hasErrors()) {
            respond imageInstance.errors, view:'edit'
            return
        }

        imageInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Image.label', default: 'Image'), imageInstance.id])
                redirect imageInstance
            }
            '*'{ respond imageInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Image imageInstance) {

        if (imageInstance == null) {
            notFound()
            return
        }

        imageInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Image.label', default: 'Image'), imageInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'image.label', default: 'Image'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
