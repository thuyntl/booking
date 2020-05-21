package booking.actions;

import booking.Utils;
import booking.tasks.BookRoom;
import booking.ui.BookingBox;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;


import java.time.LocalDate;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class InputDate implements Interaction {
    public LocalDate fromDate;
    public LocalDate toDate;

    public InputDate(LocalDate fromDate, LocalDate toDate) {
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public static InputDateBuilder fromDate(LocalDate fromDate) {
        return new InputDateBuilder(fromDate);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        BookingBox.DATE_PICKER.resolveFor(actor).waitUntilVisible();
        BookingBox.DATE_FIELD.of(Utils.convertDateToString(this.fromDate)).resolveFor(actor).click();
        BookingBox.DATE_FIELD.of(Utils.convertDateToString(this.toDate)).resolveFor(actor).click();
    }

    public static class InputDateBuilder {
        private LocalDate fromDate;

        public InputDateBuilder(LocalDate fromDate) {
            this.fromDate = fromDate;
        }

        public InputDate toDate(LocalDate toDate) {
            return instrumented(InputDate.class, this.fromDate, toDate);
        }
    }

}
