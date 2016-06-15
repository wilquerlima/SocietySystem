package societysystem

class Grupo {

    int id
    String nome

    static hasMany = [usuarios: Usuario]

    Grupo()
    {
        usuarios = []
    }

    static constraints = {
    }
}
