package booking.abilities;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GetBookingInformation implements Ability {
    public enum BusinessTravel {
        YES, NO
    }
    public String place;
    public BusinessTravel businessTravel;
    public String fromDate;
    public String toDate;
    public String adults;
    public String children;
    public String room;


    public GetBookingInformation(String place, String businessTravel, String fromDate, String toDate, String adults, String children, String room ) {
        this.place = place;
        if (businessTravel.toUpperCase().equals(BusinessTravel.YES)) {
            this.businessTravel = BusinessTravel.YES;
        } else  {
            this.businessTravel = BusinessTravel.NO;
        }
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.adults = adults;
        this.children = children;
        this.room = room;
    }

    public static GetBookingInformation getInfor() {
        FileReader reader = null;
        Properties properties = null;
        try {
            reader = new FileReader("src/test/resources/BookingInfor.properties");
            properties = new Properties();
            properties.load(reader);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new GetBookingInformation(properties.getProperty("Place"),
                properties.getProperty("BusinessTravel"),
                properties.getProperty("FromDate"),
                properties.getProperty("ToDate"),
                properties.getProperty("AdultsNumber"),
                properties.getProperty("ChildrenNumber"),
                properties.getProperty("RoomNumber"));
    }

    public static GetBookingInformation as(Actor actor) {
        return actor.abilityTo(GetBookingInformation.class);
    }
}
