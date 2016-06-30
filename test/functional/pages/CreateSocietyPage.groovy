package pages

import geb.Page
import societysystem.Schedule

/**
 * Created by USER on 16/06/2016.
 */
class CreateSocietyPage extends Page {
    static url = "/SocietySystem/society/create"

    static at = {
        title ==~ /Criar Society/
    }

    boolean createSociety(String name, Schedule sch){
        $("form").name = name
        $("form").schedules = "20:00"
        //$("label", name: "societysystem.Schedule : 1").click()
        $("input", name: "create").click()
    }
}
