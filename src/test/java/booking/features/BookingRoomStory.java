package booking.features;

import booking.Utils;
import booking.abilities.GetBookingInformation;
import booking.tasks.BookRoom;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
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
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

@RunWith(SerenityRunner.class)
public class BookingRoomStory {

    Actor anna = Actor.named("Anna");

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
                BookRoom.placeOfStay("Da Lat")
                        .businessTravel()
                        .fromDate(Utils.todayOfCurrentMonth())
                        .toDate(Utils.randomDayOfNextMonth())
                        .forAdults(3)
                        .andChildren(2)
                        .amountOfRoom(2)
        );

        then(anna).should();

    }
}