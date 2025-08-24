package org.example;

import java.util.Scanner;

public class Container {
    // 공유자원

    private static Scanner sc;

    public static void init() {
        sc = new Scanner(System.in);
    }

    public static void close() {
        sc.close();
    }

    public static Scanner getScanner() {
        return sc;
    }
}
