package societysystem
import societysystem.Society

class Field {

    String name
    int value
    boolean booked


    static constraints = {
        name unique: true
    }
}
