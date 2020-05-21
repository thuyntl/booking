package booking;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Utils {
    public static LocalDate todayOfCurrentMonth () {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return LocalDate.now();
    }

    public static LocalDate randomDayOfNextMonth() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.MONTH, 1);
        int numberDaysOfMonth = c.getMaximum(Calendar.DATE);
        Random random = new Random();
        int randomDay = random.nextInt(numberDaysOfMonth - 1) +1;
        LocalDate dateOfNextMonth = LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH), randomDay);
        return dateOfNextMonth;
    }

    public static String convertDateToString (LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }

    public static LocalDate convertStringToDate (String strDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(strDate, formatter);
        return date;
    }
}
