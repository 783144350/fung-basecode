package fung.java.test.time;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeTest {

    @Test
    public void testDate() {
        LocalDate today = LocalDate.now();
        System.out.println("Current date: " + today);

        LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
        System.out.println("Specific date: " + firstDay_2014);

        LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current Date in IST: " + todayKolkata);

        LocalDate dateFromBase = LocalDate.ofEpochDay(365);
        System.out.println("365th day from base date: " + dateFromBase);

        LocalDate hundredDay2014 = LocalDate.ofYearDay(2014, 100);
        System.out.println("100th day of 2014: " + hundredDay2014);
    }

    @Test
    public void testTime() {
        LocalTime time = LocalTime.now();
        System.out.println("Current time: " + time);

        LocalTime specificTime = LocalTime.of(12, 20, 25, 40);
        System.out.println("Specific time: " + specificTime);

        LocalTime timeKolkata = LocalTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current time in IST: " + timeKolkata);
    }

    @Test
    public void testDateTime() {
        LocalDateTime today = LocalDateTime.now();
        System.out.println("Current datetime: " + today);

        LocalDateTime specificDatetime = LocalDateTime.of(2018, Month.MARCH, 25, 11, 18, 20);
        System.out.println("Specific datetime: " + specificDatetime);

        LocalDateTime todayKolkata = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current datetime in IST: " + todayKolkata);
    }

    @Test
    public void testInstant() {
        Instant timestamp = Instant.now();
        System.out.println("Current timestamp: " + timestamp);
    }

    @Test
    public void testDateAPI() {
        LocalDate today = LocalDate.now();

        System.out.println("Year " + today.getYear() + " is leap year? " + today.isLeapYear());
        System.out.println("Today is before 2015-1-1? " + today.isBefore(LocalDate.of(2015, 1, 1)));
        System.out.println("Current datetime: " + today.atTime(LocalTime.now()));
        System.out.println("10 days after today will be: " + today.plusDays(10));
        System.out.println("2 months after today will be: " + today.plusMonths(2));
        System.out.println("3 weeks after today will be: " + today.plusWeeks(3));
    }

    @Test
    public void testDateTimeFormatter() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Default format: " + now);
        System.out.println("Specific format: " + now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")));
        System.out.println("BASIC ISO format: " + now.format(DateTimeFormatter.BASIC_ISO_DATE));
    }
}
