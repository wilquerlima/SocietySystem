package pages

import geb.Page

class PeladaList extends Page{
    static url = "/Society/List"
    static at = {
        title ==~ /Lista Pelada/
    }
}
