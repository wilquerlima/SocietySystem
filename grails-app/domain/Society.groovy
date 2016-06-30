/**
 * Created by PC-wilquer on 15/06/2016.
 */
class Society {

    String pelada
    Date dataHoje

    static constraints = {
        pelada blank: false
        dataHoje nullable: true
    }


}
