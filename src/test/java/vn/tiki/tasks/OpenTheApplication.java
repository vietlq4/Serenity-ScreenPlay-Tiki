package vn.tiki.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import vn.tiki.ui.TikiPage;



public class OpenTheApplication implements Task {

    TikiPage tikiPage;

    @Step("Open the application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(tikiPage)
        );
    }


}
