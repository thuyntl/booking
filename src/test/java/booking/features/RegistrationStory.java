package booking.features;

import booking.Utils;
import booking.abilities.GetUserInformation;
import booking.questios.VerificationMailAfterRegister;
import booking.tasks.BookRoom;
import booking.tasks.Register;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import booking.tasks.OpenTheApplication;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class RegistrationStory {

    Actor anna = Actor.named("Anna").whoCan(GetUserInformation.getUserInfo());

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenTheApplication openTheApplication;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    @Ignore
    public void show_input_information_for_booking_room() {

        givenThat(anna).wasAbleTo(openTheApplication);

        when(anna).attemptsTo(
                Register.withUserInformation()
        );

       then(anna).should(seeThat("Result for verification mail", VerificationMailAfterRegister.getVerificationMail(), equalTo(true)));

    }
}