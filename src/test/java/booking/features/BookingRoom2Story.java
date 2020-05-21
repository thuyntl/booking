package booking.features;

import booking.Utils;
import booking.abilities.GetBookingInformation;
import booking.questios.SearchResultForBooking;
import booking.questios.VerificationMailAfterRegister;
import booking.tasks.BookRoom;
import booking.tasks.BookRoom2;
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

import javax.mail.Message;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class BookingRoom2Story {

    Actor anna = Actor.named("Anna").whoCan(GetBookingInformation.getInfor());

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenTheApplication openTheApplication;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void show_input_information_for_booking_room() {

        givenThat(anna).wasAbleTo(openTheApplication);

        when(anna).attemptsTo(
                BookRoom2.withBookingInfor()
        );

        then(anna).should("Number of matched rooms",seeThat(SearchResultForBooking.totalRoom(), equalTo(630)));
    }
}