package booking.tasks;

import booking.Utils;
import booking.abilities.GetBookingInformation;
import booking.actions.InputDate;
import booking.actions.InputPlace;
import booking.actions.Book;
import booking.actions.SelectBusinessTravel;
import booking.ui.BookingBox;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.time.LocalDate;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BookRoom implements Task {
    public static BookRoom withBookingInfor() {
        return instrumented(BookRoom.class);
    }

    public enum BusinessTravel{
        YES, NO
    }

    private String place;
    private BusinessTravel businessTravel;
    private LocalDate fromDate;
    private LocalDate toDate;
    private int adults;
    private int children;
    private int room;

    public BookRoom(String place, BusinessTravel businessTravel, LocalDate fromDate, LocalDate toDate, int adults, int children, int room) {
        this.place = place;
        this.businessTravel = businessTravel;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.adults = adults;
        this.children = children;
        this.room = room;
    }

    public static BookRoomBuilder placeOfStay(String place) {
        return new BookRoomBuilder(place);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                InputPlace.atPlace(this.place),
                InputDate.fromDate(this.fromDate).toDate(this.toDate),
                Book.forAdults(this.adults).andChildren(this.children).amountOfRoom(this.room),
                SelectBusinessTravel.selectBusinessTravel(this.businessTravel),
                Click.on(BookingBox.BUTTON_SEARCH)
        );
    }


    public static class BookRoomBuilder {
        public String place;
        public BusinessTravel businessTravel;
        public LocalDate fromDate;
        public LocalDate toDate;
        public int adults;
        public int children;

        public BookRoomBuilder(String place) {
            this.place = place;
        }

        public BookRoomBuilder businessTravel() {
            this.businessTravel = BusinessTravel.YES;
            return this;
        }

        public BookRoomBuilder fromDate(LocalDate fromDate) {
            this.fromDate = fromDate;
            return this;
        }

        public BookRoomBuilder toDate(LocalDate toDate) {
            this.toDate = toDate;
            return this;
        }

        public BookRoomBuilder forAdults (int adults) {
            this.adults = adults;
            return this;
        }

        public BookRoomBuilder andChildren(int children) {
            this.children = children;
            return this;
        }

        public BookRoom amountOfRoom(int room) {
            return instrumented(BookRoom.class, this.place, this.businessTravel, this.fromDate, this.toDate, this.adults, this.children, room);
        }
    }
}
