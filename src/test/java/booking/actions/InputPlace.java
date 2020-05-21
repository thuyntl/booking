package booking.actions;

import booking.ui.BookingBox;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class InputPlace implements Interaction {
    public String place;

    public InputPlace(String place) {
        this.place = place;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        BookingBox.PLACE_FIELD.resolveFor(actor).click();
        BookingBox.PLACE_FIELD.resolveFor(actor).sendKeys(this.place);
        BookingBox.PLACE_LIST.resolveFor(actor).waitUntilVisible();
        BookingBox.FIRST_SUGGESTION.resolveFor(actor).click();
    }

    public static Interaction atPlace(String place) {
        return instrumented(InputPlace.class, place);
    }
}
