package org.example;

import vo.Motivation;

import java.util.*;

public class App {

    private Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("== 명언 앱 ==");
        int lastId = 0;

//        Motivation m1 = null;
//        Motivation m2 = null;
//        Motivation m3 = null;

//        Motivation[] motivs = new Motivation[100];

        List<Motivation> motivationList = new ArrayList<>();

        while (true) {
            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("exit")) {
                System.out.println("== 명언 앱 종료 ==");
                break;
            } else if (cmd.equals("add")) {
                System.out.print("명언 : ");
                String body = sc.nextLine().trim();
                System.out.print("저자 : ");
                String author = sc.nextLine().trim();
                ++lastId;

                Motivation addMotiv = new Motivation(lastId, body, author);

                motivationList.add(addMotiv);


                System.out.println(lastId + "번 명언이 등록되었습니다.");
            } else if (cmd.equals("list")) {
                System.out.println("=".repeat(50));
                System.out.println("  번호     /     명언     /      저자");

                if (motivationList.size() == 0) {
                    System.out.println("등록된 명언이 없습니다.");
                } else {

                    Collections.reverse(motivationList);
                    for (Motivation m : motivationList) {
                        System.out.println(m.getId() + "           " + m.getBody().substring(0, 5) + " ..." + "             " + m.getAuthor());
                    }
                }


            } else {
                System.out.println("사용할 수 없는 명령어입니다.");
            }


        }
    }
}
