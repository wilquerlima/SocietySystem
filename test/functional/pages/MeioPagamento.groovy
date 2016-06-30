package pages
import geb.Page

class MeioPagamento extends Page{
    static url = "/society/pessoa/pagamento"
    static at = {
        title ==~ /Meio de Pagamento/
    }
}