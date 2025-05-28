package com.back.step11;

import com.back.step11.command.WiseSayingCommand;
import com.back.step11.repository.WiseSayingList;

import java.util.Scanner;

public class WiseSayingController {
    WiseSayingService service;
    Scanner scanner;

    WiseSayingController(){
        service = new WiseSayingService();
        scanner = new Scanner(System.in);
    }

    public void close(){
        scanner.close();
        service.close();
    }

    private String banSpecialLetters(String str){
        return str.replaceAll("[@?]", "");
    }

    private String getInput(){
        String input_str = scanner.nextLine().trim();
        return banSpecialLetters(input_str);
    }

    private void insert(){
        System.out.print("명언 : ");
        String content = getInput();
        System.out.print("작가 : ");
        String author = getInput();
        int id = service.insertWiseSaying(content, author);
        System.out.println(id + "번 명언이 등록되었습니다.");
    }

    private void show(){
        WiseSayingList wiseSayingList = service.showWiseSayings();
        System.out.print(wiseSayingList);
    }

    private void delete(WiseSayingCommand wiseSayingCommand){
        try{
            int id = wiseSayingCommand.getIntParameter("id");
            if (!service.hasWiseSaying(id)){
                System.out.println( id+"번 명언은 존재하지 않습니다.");
                return;
            }
            service.deleteWiseSaying(id);
            System.out.println(id + "번 명언이 삭제되었습니다.");
        }catch (RuntimeException e){
            System.out.println("ID를 입력하시오.");
        }
    }

    private void update(WiseSayingCommand wiseSayingCommand){
        try{
            int id = wiseSayingCommand.getIntParameter("id");
            WiseSaying wiseSaying = service.getWiseSaying(id);
            if (wiseSaying == null){
                System.out.println( id+"번 명언은 존재하지 않습니다.");
                return;
            }
            System.out.println("명언(기존) : " + wiseSaying.getContent());
            System.out.print("명언 : ");
            String content = getInput();
            System.out.println("작가(기존) : " + wiseSaying.getAuthor());
            System.out.print("작가 : ");
            String author = getInput();
            service.updateWiseSaying(id,content, author);

        }catch (RuntimeException e){
            System.out.println("ID를 입력하시오.");
        }
    }

    private void build(){
        service.buildWiseSayingList();
        System.out.println("data.json 파일의 내용이 갱신되었습니다.");
    }

    public void work(WiseSayingCommand cmd){
        switch (cmd.getMainCommandToken()){
            case Insert -> insert();
            case Show -> show();
            case Delete -> delete(cmd);
            case Update -> update(cmd);
            case Build -> build();
        }
    }
}
