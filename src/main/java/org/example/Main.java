package org.example;

public class Main {
    public static void main(String[] args) {

        Container.init();
//        Scanner sc = new Scanner(System.in);

        new App().run();

        Container.close();
//        sc.close();

    }
}