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
        respond societyInstance, model: [maxProfit: returnProfit(societyInstance.getNome())]

    static allowedMethods = [update: "PUT", delete: "DELETE"]

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [societyInstanceList: Society.list(params),
         societyInstanceTotal: Society.count()]
    }

    def overview(Integer max){
        list(max)
    }

    def checkAvailable(Society soc){
        def check = false
        soc.schedules.each{
            if (it.isAvailable){
                check = true
            }
        }
        return check
    }

    /*def showAll(Society societyInstance) {
        if (societyInstance.schedules.findByIsAvaliable(true) != null){
            respond societyInstance
        } else {
            respond null
        }
    }
    */

    def createe(){
        Society soc = new Society(params)
        soc.schedules.each {
            if (it.isAvaliable){
                soc.available = true
            }
        }
        soc.save()
        respond soc

    }

    def create() {
        respond new Society(params)
    }


    def addSchedule(Society societyInstance, String time){
        if (societyInstance == null) {
            notFound()
            return
        }
        Schedule sch = new Schedule(time : time, isAvaliable : true)
        societyInstance.schedules.add(sch)
        societyInstance.available = true
        return

    }




    @Transactional
    def save(Society societyInstance) {
        if (societyInstance == null) {
            notFound()
            return
        }

        if (societyInstance.hasErrors()) {

            respond societyInstance.errors, view:'create'
            return
        }
        societyInstance.schedules.each {
            if (it.isAvaliable){
                societyInstance.available = true
            }
        }
        societyInstance.save flush:true


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

            respond societyInstance.errors, view:'edit'
            return
        }

        societyInstance.save flush:true


        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Society.label', default: 'Society'), societyInstance.id])
                redirect societyInstance
            }

            '*'{ respond societyInstance, [status: OK] }

        }
    }

    @Transactional
    def delete(Society societyInstance) {

        if (societyInstance == null) {
            notFound()
            return
        }


        societyInstance.delete flush:true


        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Society.label', default: 'Society'), societyInstance.id])

                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }

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

    def addField(Society societyInstance){
        respond societyInstance
    }

    /*Add a field to a Society Instance from AddField View
    * And then returns to "Society/Show"
    * */
    def addFieldToSociety(Society societyInstance){
        def f1 = Field.findByName(params.fieldName)
        societyInstance.addToFields(f1)
        societyInstance.save(flush: true)
        render(view: 'show')
    }

    /*
    * Return the profit a society given a society's name
    * */
    def returnProfit(String name){
        int value = 0
        Society s = Society.findByNome(name)
        s.fields.each {
                value += it.value
        }
        return value
    }

    def returnBookedProfit(String name){
        int value = 0
        Society s = Society.findByNome(name)
        s.fields.each {
            if (it.booked) {
                value += it.value
            }
        }
        return value
    }

    def result(){
        render (view:"common/result")

    }
}
