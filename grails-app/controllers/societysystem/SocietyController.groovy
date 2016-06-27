package societysystem



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SocietyController {

    static allowedMethods = [update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Society.list(params), model:[societyInstanceCount: Society.count()]
    }

    def show(Society societyInstance) {
        respond societyInstance
    }

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
            '*'{ render status: NOT_FOUND }
        }
    }
}
