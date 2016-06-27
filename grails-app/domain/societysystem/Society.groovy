package societysystem

class Society {

    String name
    static hasMany = [schedules : Schedule]
    boolean available
    Society(){
        schedules = []
        available = false
    }


    static constraints = {
    }
}