package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        new App(sc).run();

        sc.close();

        // git test1
        System.out.println("깃 테스트1");
        // git test2
        System.out.println("깃 테스트2");

    }
}