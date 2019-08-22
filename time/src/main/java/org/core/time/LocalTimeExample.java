package org.core.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalTimeExample {
    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    public static void example1() {
        LocalTime now = LocalTime.now();
        System.out.println(now);
    }

    public static void example2() {
        LocalTime time = LocalTime.of(12, 9, 7);
        int second = time.getSecond();
        System.out.println(second);
        System.out.println(time);
    }

    public static void example3() {
        LocalTime now = LocalTime.now();
        LocalDateTime dateTime = now.atDate(LocalDate.now());
        System.out.println(dateTime);
    }
}
