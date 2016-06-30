package societysystem

class Horario {

    String dia
    String horaInicial
    String horaFinal
    boolean ocupado
    static constraints = {
        dia blank: false
        horaInicial blank: false
        horaFinal blank: false
    }
    def select(){
        if(ocupado==true){
           return "Horário Ocupado!"
        }
        else{
        ocupado = !ocupado
     }
    }
    def selectEscolha(){
        ocupado= !ocupado
    }
}
