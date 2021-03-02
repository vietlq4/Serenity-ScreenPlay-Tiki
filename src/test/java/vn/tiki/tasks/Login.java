package vn.tiki.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.statematchers.IsVisibleMatcher;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static java.lang.Thread.sleep;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static vn.tiki.ui.LoginPopup.*;

public class Login implements Task {

    private final String sdt;
    private final String pass;

    protected Login(String sdt, String pass) {
        this.sdt = sdt;
        this.pass = pass;

    }

    @Step("Click button login")
    public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    WaitUntil.the(BUTTON_ALERT, isVisible()).forNoMoreThan(100).seconds(),
                    new IsVisibleMatcher().matches(BUTTON_ALERT) ? Click.on(BUTTON_ALERT): c
                    Click.on(BUTTON_REGISTER),
                    Click.on(BUTTON_LOGIN),
                    Enter.theValue(sdt).into(SDT),
                    Enter.theValue(pass).into(PASSWORD),
                    Click.on(BUTTON_SUBMIT)
            );

    }

    public static Login fillInfoLogin(String sdt, String pass) {
        return instrumented(Login.class, sdt, pass);
    }

}
