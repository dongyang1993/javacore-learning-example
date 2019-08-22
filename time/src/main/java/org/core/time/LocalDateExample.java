package org.core.time;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class LocalDateExample {
    public static void main(String[] args) {
        example1();
        example2();
    }

    public static void example1() {
        LocalDate now = LocalDate.now();
        System.out.println(now);
    }

    public static void example2() {
        LocalDate date = LocalDate.of(2019, 5, 16);
        System.out.println(date.isLeapYear());
        int year = date.get(ChronoField.YEAR);
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_MONTH);
        int dayOfYear = date.get(ChronoField.DAY_OF_YEAR);
        System.out.println(dayOfYear);
    }
}
