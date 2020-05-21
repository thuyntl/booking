package booking.actions;

import booking.tasks.BookRoom.BusinessTravel;
import booking.ui.BookingBox;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectBusinessTravel implements Interaction {
    public BusinessTravel businessTravel;

    public SelectBusinessTravel(BusinessTravel businessTravel) {
        this.businessTravel = businessTravel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (this.businessTravel)
        {
            case YES:
                BookingBox.CHECKBOX_BUSINESSTRAVEL.resolveFor(actor).click();
            default:
                break;
        }
    }

    public static Interaction selectBusinessTravel(BusinessTravel businessTravel) {
        return instrumented(SelectBusinessTravel.class, businessTravel);
    }
}
