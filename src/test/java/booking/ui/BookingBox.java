package booking.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BookingBox {
    public static Target PLACE_FIELD = Target.the("Place field").located(By.xpath("//input[@type='search']"));
    public static Target PLACE_LIST = Target.the("Place list").located(By.xpath("//ul[starts-with(@class, 'autocomplete') or @data-list]"));
    public static Target CHECKBOX_BUSINESSTRAVEL = Target.the("Business travel checkbox").located(By.xpath("//div[@data-visible='accommodation']"));
    public static Target FIRST_SUGGESTION = Target.the("the first suggestion").located(By.xpath("//ul[starts-with(@class, 'autocomplete') or @data-list]/li[1]"));
    public static Target DATE_BOX = Target.the("date field").located(By.xpath("//div[@class='xp__dates-inner']"));
    public static Target DATE_PICKER = Target.the("Date picker").located(By.xpath("//div[@class='bui-calendar']"));
    public static Target DATE_FIELD = Target.the("Date {0}").locatedBy("//td[@data-date='{0}']");
    public static Target BOOKING_BOX = Target.the("Booking boxes").located(By.xpath("//div[@data-visible='accommodation,flights']"));
    public static Target BUTTON_INCREASE_ADULTS = Target.the("Increase adults button").located(By.xpath("//button[@aria-describedby='group_adults_desc'][2]"));
    public static Target BUTTON_DECREASE_ADULTS = Target.the("Decrease adults button").located(By.xpath("//button[@aria-describedby='group_adults_desc'][1]"));
    public static Target BUTTON_INCREASE_CHILDREN = Target.the("Increase children button").located(By.xpath("//button[@aria-describedby='group_children_desc'][2]"));
    public static Target BUTTON_DECREASE_CHILDREN = Target.the("Decrease children button").located(By.xpath("//button[@aria-describedby='group_children_desc'][1]"));
    public static Target BUTTON_INCREASE_ROOM = Target.the("Increase room button").located(By.xpath("//button[@aria-describedby='no_rooms_desc'][2]"));
    public static Target BUTTON_SEARCH = Target.the("Search button").located(By.xpath("//button[@type='submit']"));
}
