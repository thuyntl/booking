package booking.tasks;

import booking.Utils;
import booking.abilities.GetBookingInformation;
import booking.actions.Book;
import booking.actions.InputDate;
import booking.actions.InputPlace;
import booking.actions.SelectBusinessTravel;
import booking.ui.BookingBox;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BookRoom2 implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                InputPlace.atPlace(BookingInfor(actor).place),
                InputDate.fromDate(Utils.convertStringToDate(BookingInfor(actor).fromDate))
                        .toDate(Utils.convertStringToDate(BookingInfor(actor).toDate)),
                Book.forAdults(Integer.parseInt(BookingInfor(actor).adults))
                        .andChildren(Integer.parseInt(BookingInfor(actor).children))
                        .amountOfRoom(Integer.parseInt(BookingInfor(actor).room)),
                Click.on(BookingBox.BUTTON_SEARCH)
        );
    }

    public static BookRoom2 withBookingInfor() {
        return instrumented(BookRoom2.class);
    }

    private GetBookingInformation BookingInfor(Actor actor){
        return GetBookingInformation.as(actor);
    }
}
