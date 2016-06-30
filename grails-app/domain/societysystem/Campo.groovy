package societysystem

class Campo {
    String nome
    Double valor
    static hasMany = [horarios:Horario]
    Campo(){
        horarios=[]
    }
    static constraints = {
        nome blank: false
    }
}
