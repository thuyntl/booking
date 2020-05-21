package booking.ui;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegistrationPage {
    public static Target REGISTER_BUTTON = Target.the("Register button").located(By.xpath("//ul[@class=\"user_center_nav\"]/li[5]"));
    public static Target EMAIL_FIELD = Target.the("Email field").located(By.xpath("//input[@type=\"email\"]"));
    public static Target START_BUTTON = Target.the("Start button").located(By.xpath("//span[contains(text(),\"Get started\")]/.."));
    public static Target PASSWORD_FIELD = Target.the("Password field").located(By.xpath("//input[@id=\"password\"]"));
    public static Target CONFIRMED_PASSWORD_FIELD = Target.the("Password field").located(By.xpath("//input[@id=\"confirmed_password\"]"));
    public static Target SUBMIT_BUTTON = Target.the("Submit button").located(By.xpath("//span[contains(text(),\"Create account\")]/.."));

}
