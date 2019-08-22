package org.core.time;

import java.util.concurrent.TimeUnit;

public class TimeUnitExample {
    public static void main(String[] args) {
        example1();
    }

    public static void example1() {
        long hours = TimeUnit.SECONDS.toHours(3600L);
        System.out.println(hours);
    }
}
