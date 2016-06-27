package societysystem

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PessoaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Pessoa.list(params), model:[pessoaInstanceCount: Pessoa.count()]
    }

    def show(Pessoa pessoaInstance) {
        respond pessoaInstance
    }

    def create() {
        respond new Pessoa(params)
    }

    def gerenciamento(){
        render(view:"gerenciamento")

    }

    def saveImage(){
        Pessoa p =Pessoa.findByNome(params.loginImage)
        if(p!=null){
            ImageController controladorImg = new ImageController()
            //Image img = new Image(params)
            //controladorImg.upload()
            def img = new Image(arquivo: params.arquivo.bytes)

            img.setPessoa(p)
            p.setImagem(img)
            controladorImg.save(img)
            controlador.response.reset()


            //depois atribuir img a pessoa p
            //p.setImagem(img)
            flash.message = message(code: 'default.created.message', args: [message(code: 'pessoa.label', default: 'Foto alterada'),])
            //redirect action: "gerenciamento", method: "GET"
            //render(view:"gerenciamento")
        }else{
            flash.message = message(code: 'default.created.message', args: [message(code: 'pessoa.label', default: 'Login incorreto'),])

        }
            redirect action: "gerenciamento", method: "GET"


    }

    @Transactional
    def save(Pessoa pessoaInstance) {
        if (pessoaInstance == null) {
            notFound()
            return
        }

        if (pessoaInstance.hasErrors()) {
            respond pessoaInstance.errors, view:'create'
            return
        }
        /*
       if(pessoaInstance.getImagem()==null){
            File file = new File('C:\\Users\\MANOEL PERGENTINO\\Documents\\Ciência da Computação\\Engenharia de Software\\SocietySystem\\Society\\SocietySystem\\myFile.jpg')

            Image imagem = [myFile: file.getBytes(), pessoa: pessoaInstance]
            ImageController control adorImagem = new ImageController()
            controladorImagem.save(imagem)

        }
        */
        pessoaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pessoa.label', default: 'Pessoa'), pessoaInstance.id])
                redirect pessoaInstance
            }
            '*' { respond pessoaInstance, [status: CREATED] }
        }
    }


    def viewImage() {
        Pessoa p = Pessoa.findByNome(params.loginFoto)
        if(p!=null){
            Image i = p.getImagem()
            if(i!=null){
                byte[] image = i.arquivo
                response.outputStream << image
                //render(view:"verFoto")
            }else{
                flash.message = message(code: 'default.created.message', args: [message(code: 'pessoa.label', default: 'Usuario nao tem foto'),])
                //redirect action: "gerenciamento", method: "GET"
            }
        }else{
            flash.message = message(code: 'default.created.message', args: [message(code: 'pessoa.label', default: 'Login incorreto'),])

        }
        redirect action: "gerenciamento", method: "GET"


    }

    @Transactional
    def alterar(){
        Pessoa p = Pessoa.findByNome(params.login)
        flash:true

        if(p != null){
            if(p.getSenha().equals(params.senhaAtual)) {
                p.setSenha(params.senhaNova)

                flash.message = message(code: 'default.created.message', args: [message(code: 'pessoa.label', default: 'Senha alterada'),])
                redirect action: "gerenciamento", method: "GET"
            }else{
                flash.message = message(code: 'default.created.message', args: [message(code: 'pessoa.label', default: 'Senha atual errada'),])
                redirect action: "gerenciamento", method: "GET"
                //ERRO SENHA ERRADA
            }
        }else{
            flash.message = message(code: 'default.created.message', args: [message(code: 'pessoa.label', default: 'Login invalido'),])
            redirect action: "gerenciamento", method: "GET"
            //ERRO USUARIO NAO EXISTE
        }
    }

    def pagamento(){
        //A VIEW PAGAMENTO ESTA COM O MESMO CODIGO DE CRIAR PESSOA, OTAVIO JA CRIOU A VIEW CORRETA, BASTA APENAS COLOCAR A VERSAO DELE
        render(view:"pagamento")
    }

    def edit(Pessoa pessoaInstance) {
        respond pessoaInstance
    }

    @Transactional
    def update(Pessoa pessoaInstance) {
        if (pessoaInstance == null) {
            notFound()
            return
        }

        if (pessoaInstance.hasErrors()) {
            respond pessoaInstance.errors, view:'edit'
            return
        }

        pessoaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Pessoa.label', default: 'Pessoa'), pessoaInstance.id])
                redirect pessoaInstance
            }
            '*'{ respond pessoaInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Pessoa pessoaInstance) {

        if (pessoaInstance == null) {
            notFound()
            return
        }

        pessoaInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Pessoa.label', default: 'Pessoa'), pessoaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pessoa.label', default: 'Pessoa'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
