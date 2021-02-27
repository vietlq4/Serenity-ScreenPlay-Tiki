package vn.tiki.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import static java.lang.Thread.sleep;
import static net.serenitybdd.screenplay.Tasks.instrumented;
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
        try {
            sleep(10);
            actor.attemptsTo(
                Click.on(BUTTON_ALERT),
                Click.on(BUTTON_REGISTER),
                Click.on(BUTTON_LOGIN),
                Enter.theValue(sdt).into(SDT),
                Enter.theValue(pass).into(PASSWORD),
                Click.on(BUTTON_SUBMIT)
            );

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Login fillInfoLogin(String sdt, String pass) {
        return instrumented(Login.class, sdt, pass);
    }

}
