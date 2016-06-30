package societysystem

class Pessoa {
    String nome
    String senha
    //Image imagem
    static hasOne = [imagem: Image]

    static constraints = {
     imagem nullable: true, blank: true
        // imagem default : ""
    }
}
