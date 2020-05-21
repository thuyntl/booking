package booking.actions;

import booking.ui.BookingBox;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Book implements Interaction {
    public int adults;
    public int children;
    public int room;

    public Book(int adults, int children, int room) {
        this.adults = adults;
        this.children = children;
        this.room = room;
    }

    public static BookBuilder forAdults(int adults) {
        return new BookBuilder(adults);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        BookingBox.BOOKING_BOX.resolveFor(actor).click();
        if (this.adults > 2) {
            for(int i = 1; i < this.adults; i++) {
                BookingBox.BUTTON_INCREASE_ADULTS.resolveFor(actor).click();
            }
        }
        if (this.adults == 1){
            BookingBox.BUTTON_DECREASE_ADULTS.resolveFor(actor).click();
        }

        if (this.children > 0) {
            for(int i = 0; i < this.children; i++) {
                BookingBox.BUTTON_INCREASE_CHILDREN.resolveFor(actor).click();
            }
        }

        if (this.room > 1) {
            for (int i=1; i < this.room; i++) {
                BookingBox.BUTTON_INCREASE_ROOM.resolveFor(actor).click();
            }
        }
    }

    public static class BookBuilder {
        private int adults;
        private int children;

        public BookBuilder(int adults) {
            this.adults = adults;
        }
        public BookBuilder andChildren(int children) {
            this.children = children;
            return this;
        }


        public Book amountOfRoom(int room) {
            return instrumented(Book.class, this.adults, this.children, room);
        }
    }
}
