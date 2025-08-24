package org.example.controller;

import org.example.vo.Motivation;
import org.example.vo.Rq;

import java.util.*;

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

    public void delete(String cmd) {

        if (cmd.split(" ").length > 2) {
            System.out.println("delete 뒤에는 숫자 하나만 입력가능합니다.");
            return;
        }

        int id = -1;
        try {
            id = Integer.parseInt(cmd.split(" ")[1]);
        } catch (NumberFormatException e) {
            System.out.println("delete 뒤에는 숫자만 입력가능합니다.");
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("delete 한칸 띄고 숫자 입력하십시오.");
            return;
        }

        int foundIndex = -1;
        Motivation foundMotivation = null;
        for (int i = 0; i < motivationList.size(); i++) {
            foundMotivation = motivationList.get(i);
            if (foundMotivation.getId() == id) {
                System.out.println(foundMotivation.toString());
                foundIndex = i;
            }
        }

        System.out.println("foundMotiv : " + foundMotivation.toString());

        if (foundMotivation == null) {
            System.out.println(id + "번 글은 없습니다");
            return;
        }
        motivationList.remove(foundIndex);
        System.out.println(id + "번 글이 삭제되었습니다.");
    }

    public void newDelete(String cmd) {

        Rq rq = new Rq(cmd);

        if (rq.getParams().get("id") == null) {
            System.out.println("delete?id=값 형식으로 작성하십시오.");
            return;
        }
        int id = -1;
        try {
            id = Integer.parseInt(rq.getParams().get("id"));
        } catch (NumberFormatException e) {
            System.out.println("id=숫자 여야 합니다.");
            return;
        }
        System.out.println("id : " + id);

        Motivation foundMotivation = null;
        for (Motivation m : motivationList) {
            if(m.getId() == id){
                foundMotivation = m;
                break;
            }
        }

        System.out.println("foundMotivation : " + foundMotivation);

        if (foundMotivation == null) {
            System.out.println(id + "번 글은 없습니다");
            return;
        }
        motivationList.remove(foundMotivation);
        System.out.println(id + "번 글이 삭제되었습니다.");


    }

}












