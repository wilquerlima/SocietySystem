package societysystem

class Usuario {

    String nome
    String cpf
    boolean isOwner
    int idGrupo

    static belongsTo = [grupo: Grupo]
    static hasOne = [grupo: Grupo]


    static constraints = {
        grupo nullable: true
    }
}