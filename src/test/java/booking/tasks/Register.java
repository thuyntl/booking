package booking.tasks;

import booking.abilities.GetUserInformation;
import booking.ui.BookingBox;
import booking.ui.RegistrationPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Register implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(RegistrationPage.REGISTER_BUTTON),
                Enter.theValue(accountInformation(actor).email).into(RegistrationPage.EMAIL_FIELD),
                Click.on(RegistrationPage.START_BUTTON),
                Enter.theValue(accountInformation(actor).password).into(RegistrationPage.PASSWORD_FIELD),
                Enter.theValue(accountInformation(actor).password).into(RegistrationPage.CONFIRMED_PASSWORD_FIELD),
                Click.on(RegistrationPage.SUBMIT_BUTTON)
        );
    }

    public static Register withUserInformation() {
        return instrumented(Register.class);
    }

    private GetUserInformation accountInformation (Actor actor) {
        return GetUserInformation.as(actor);
    }
}
