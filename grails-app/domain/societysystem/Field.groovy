package societysystem
import societysystem.Society

class Field {

    int id
    String name
    int value



    static constraints = {
        name unique: true
    }
}
