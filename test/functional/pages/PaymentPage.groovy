package pages

import geb.Page

class PaymentPage extends Page {

    static url="/SocietySystem/pagamento/pagamento/"
    static at ={
        title ==~ /Pagamento/
    }
    boolean fazerPagamento(String valor,String numeroCartao,String nomeCartao,String codigoSeg){

        $("form").valor=valor
        $("form").numeroCartao=numeroCartao
        $("form").nomeCartao=nomeCartao
        $("form").codigoSeg=codigoSeg
        $("input", name: "create").click()
    }

}
