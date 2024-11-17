package org.core.feature;

import org.junit.jupiter.api.Test;

public class SwitchCaseExample {

    @Test
    public void test1() {
        String text = "A";
        switch (text) {
            case "A": {
                System.out.println("A");
                break;
            }
            case "B": {
                System.out.println("B");
                break;
            }
            default: {
                System.out.println("Default");
                break;
            }
        }
    }
}
