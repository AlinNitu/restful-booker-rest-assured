package utils;

import java.time.LocalDate;
import java.util.Calendar;

public class DateHandler {

    public static String getNextMonday() {

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        switch (day) {

            case Calendar.SUNDAY:
                return LocalDate.now().plusDays(1).toString();
            case Calendar.MONDAY:
                return LocalDate.now().plusDays(7).toString();
            case Calendar.TUESDAY:
                return LocalDate.now().plusDays(6).toString();
            case Calendar.WEDNESDAY:
                return LocalDate.now().plusDays(5).toString();
            case Calendar.THURSDAY:
                return LocalDate.now().plusDays(4).toString();
            case Calendar.FRIDAY:
                return LocalDate.now().plusDays(3).toString();
            case Calendar.SATURDAY:
                return LocalDate.now().plusDays(2).toString();
            default:
                return "Invalid day";
        }
    }

    public static String getNextSunday() {

        LocalDate nextSunday = LocalDate.parse(getNextMonday()).plusDays(6);
        return nextSunday.toString();
    }
}
