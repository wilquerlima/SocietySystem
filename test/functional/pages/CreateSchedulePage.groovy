package pages

import geb.Page

/**
 * Created by USER on 17/06/2016.
 */
class CreateSchedulePage extends Page {
    static url = "/SocietySystem/schedule/create"

    static at = {
        title ==~ /Criar Schedule/
    }

    boolean createSchedule(String time, Boolean av){
        $("form").isAvaliable = av
        $("form").time = time
        $("input", name: "create").click()
    }
}
