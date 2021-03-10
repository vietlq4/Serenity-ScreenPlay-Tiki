package vn.tiki.tasks;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import javafx.scene.Node;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementFacadeWait;
import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.matchers.statematchers.IsCurrentlyVisibleMatcher;
import net.serenitybdd.screenplay.matchers.statematchers.IsVisibleMatcher;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static vn.tiki.ui.LoginPopup.*;

public class Login extends IsVisibleMatcher implements Task{

    private final String sdt;
    private final String pass;

    protected Login(String sdt, String pass) {
        this.sdt = sdt;
        this.pass = pass;

    }

    @Step("Click button login")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BUTTON_ALERT, isVisible()).forNoMoreThan(10).seconds()
        );

        if (new WebElementQuestion(BUTTON_ALERT).answeredBy(actor).isCurrentlyVisible()) {
            actor.attemptsTo(
                    Click.on(BUTTON_ALERT)
            );
        }
        actor.attemptsTo(
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
