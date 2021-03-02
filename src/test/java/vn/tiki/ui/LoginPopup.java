package vn.tiki.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginPopup extends PageObject {
    public static Target BUTTON_REGISTER = Target.the("Button register/login").located(By.xpath("//*[contains(text(),'Đăng Nhập / Đăng Ký')]"));
    public static Target BUTTON_LOGIN = Target.the("Button login").located(By.xpath("//button[contains(text(),'Đăng nhập')]"));
    public static Target SDT = Target.the("Fill sdt").located(By.xpath("//input[@id='email']"));
    public static Target PASSWORD = Target.the("Fill password").located(By.xpath("//input[@id='password']"));
    public static Target BUTTON_ALERT = Target.the("Button register/login").located(By.xpath("//*[@id=\"onesignal-slidedown-cancel-button\"]"));
    public static Target BUTTON_SUBMIT = Target.the("Button submit").located(By.xpath("//div[contains(@class,'UserModalstyle__Right-tngk37-2')]//button[text()='Đăng nhập']"));
}
