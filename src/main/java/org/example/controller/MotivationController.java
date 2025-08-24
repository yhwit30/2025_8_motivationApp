package org.example.controller;

import org.example.vo.Motivation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MotivationController {

    private Scanner sc;
    private int lastId = 0;
    private List<Motivation> motivationList = new ArrayList<>();

    public MotivationController(Scanner sc) {
        this.sc = sc;
    }

    public void add() {
        System.out.print("명언 : ");
        String body = sc.nextLine().trim();
        System.out.print("저자 : ");
        String author = sc.nextLine().trim();
        ++lastId;

        Motivation addMotiv = new Motivation(lastId, body, author);

        motivationList.add(addMotiv);


        System.out.println(lastId + "번 명언이 등록되었습니다.");
    }

    public void list() {
        System.out.println("=".repeat(50));
        System.out.println("  번호     /     명언     /      저자");

        if (motivationList.size() == 0) {
            System.out.println("등록된 명언이 없습니다.");
        } else {

            Collections.reverse(motivationList);
            for (Motivation m : motivationList) {
                if (m.getBody().length() < 5) {
                    System.out.println(m.getId() + "           " + m.getBody() + "             " + m.getAuthor());
                } else {
                    System.out.println(m.getId() + "           " + m.getBody().substring(0, 5) + " ..." + "             " + m.getAuthor());
                }

            }
        }
    }
}
