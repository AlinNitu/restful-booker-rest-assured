package utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DateHandler {

    private static LocalDate localDate = LocalDate.of(LocalDate.now().getYear(),
            LocalDate.now().getMonthValue(),
            LocalDate.now().getDayOfMonth());

    public static String getNextMonday() {

        LocalDate nextMonday = localDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        return nextMonday.toString();
    }

    public static String getNextSunday() {

        LocalDate nextSunday = LocalDate.parse(getNextMonday()).plusDays(6);
        return nextSunday.toString();
    }

    public static String getNextYear() {

        LocalDate nextYear = localDate.with(TemporalAdjusters.firstDayOfNextYear());
        return nextYear.toString();
    }
}
