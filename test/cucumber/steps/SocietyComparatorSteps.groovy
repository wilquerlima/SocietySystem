package steps

import org.springframework.scheduling.annotation.Schedules
import pages.CreateSchedulePage
import pages.CreateSocietyPage
import pages.IndexSocietyPage
import pages.SearchSocietiesPage
import pages.SocietyComparatorPage
import societysystem.Society
import societysystem.SocietyController
import societysystem.Schedule
import societysystem.ScheduleController

import java.lang.reflect.Array

import static cucumber.api.groovy.EN.*


this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

def societyList

Given(~'^The societies "([^"]*)", "([^"]*)" and "([^"]*)" are created$'){ String s1, s2, s3 ->
    def control = new SocietyController()
    createSociety(s1, control)
    createSociety(s2, control)
    createSociety(s3, control)
}

And(~'^"([^"]*)" and "([^"]*)" are avaliable at "([^"]*)"$') { String s1, s2, time ->
    def control = new SocietyController()
    createSchedule(s1, time, control)
    createSchedule(s2, time, control)

}

When(~'^I try to search the avaliable societies at "([^"]*)"$') { String time ->
    lookForSocieties(time)

}

Then(~'^The societies "([^"]*)" and "([^"]*)" will be returned$') { String s1, s2 ->
    Society soc1 = Society.findByName(s1)
    Society soc2 = Society.findByName(s2)
    assert isReturned(soc1) == true
    assert isReturned(soc2) == true

}

def createSociety(String name, SocietyController controller){
    Society soc = new Society(name: name)
    controller.save(soc)
    controller.response.reset()
}

def createSchedule(String name, String time, SocietyController controller) {
    Society soc = Society.findByName(name)
    if (soc != null){
        controller.addSchedule(soc, time)
    }
}

def lookForSocieties(String time){
    def sch = Schedule.findByTime(time)
    societyList = Society.findAllBySchedules(sch)
}

def isReturned(Society societyInstance){

    if(societyList.getAt(societyInstance.name) != null){
        return true
    }
    return false
}

Given(~'^The societies "([^"]*)" and "([^"]*)" are already created and avaliable at "([^"]*)"$') { String s1, s2, time ->
    def schedule = new Schedule(time: time, isAvaliable: true)
    Boolean av = true
    to CreateSchedulePage
    at CreateSchedulePage
    page.createSchedule(time, av)
    to CreateSocietyPage
    at CreateSocietyPage
    page.createSociety(s1, schedule)
    to CreateSocietyPage
    at CreateSocietyPage
    page.createSociety(s2, schedule)
    to IndexSocietyPage
}

And(~/^I am at Society comparator page$/) { ->
    to IndexSocietyPage
    at IndexSocietyPage
}

When(~/^try to look at avaliable societies$/) { ->
    at IndexSocietyPage
    page.gotoSearch()
}


Then(~/^The societies "(.*?)" and "(.*?)" will appear$/) { String s1, String s2 ->
    to SearchSocietiesPage
    at SearchSocietiesPage
    assert page.socIsAvailable(s1) == true
    assert page.socIsAvailable(s2) == true
}
