package societysystem

class Pagamento {
    Double valor
    String numeroCartao,nomeCartao,codigoSeg
    Horario horario

    static constraints = {
        valor nullable: false
        numeroCartao blank: false
        nomeCartao blank: false
        codigoSeg blank: false
        horario nullable: false

    }
    def registro(Horario horario1){
        def horario=horario1

    }

}
