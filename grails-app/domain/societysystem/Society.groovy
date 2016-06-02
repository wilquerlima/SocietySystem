package societysystem

class Society {

    String nome
    Integer code

    static hasMany = [
            fields: Field
    ]

    static constraints = {

    }
}
