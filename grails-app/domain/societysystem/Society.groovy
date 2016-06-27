package societysystem

class Society {

    String name
    Integer code
    boolean available


    Society(){
        schedules = []
        available = false
    }

    static hasMany = [
            fields: Field,
            schedules : Schedule
    ]



    static constraints = {
        nome unique: true
    }
}

