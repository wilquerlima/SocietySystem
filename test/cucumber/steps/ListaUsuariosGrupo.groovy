package steps

import cucumber.api.PendingException

import static cucumber.api.groovy.EN.*


Given(~/^"([^"]*)" is the name of existent a group$/) {
    String group ->

}

And(~/^"([^"]*)" has users$/) { String arg1 ->

}

When(~/^I try to mark the user of id "([^"]*)" as present at game$/) { String arg1 ->
}

Then(~/^The system add "([^"]*)" as present$/) { String arg1 ->

}


Given(~/^The user of id "([^"]*)" belongs to the group "([^"]*)"$/) {
    String cpf, String group ->

}

When(~/^I try to check his frequency at the group "time' plays$/) { ->

}

Then(~/^It is shown a list with his frequency at each game$/) { ->

}