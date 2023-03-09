package 코드스멜;

import java.util.Scanner;

class 리터럴의과도한사용_sol {
    private final Player player;
    public 리터럴의과도한사용_sol(){
        this.player = new Player();
    }
    void medal(){
        if(player.rank().equals("gold")) {
            System.out.println("금메달을 축하합니다.");
            return;
        }
        if(player.rank().equals("silver")) {
            System.out.println("은메달을 축하합니다.");
            return;
        }
        if(player.rank().equals("bronze")) {
            System.out.println("동메달을 축하합니다.");
            return;
        }
        if(player.rank().equals("none")) {
            System.out.println("다음 기회가 있습니다.");
        }
    }
}

class Player{
    Scanner sc = new Scanner(System.in);
    private String medal;
    public Player(){
        System.out.print("획득한 메달의 색깔을 입력하세요. (없을 시, [none] 입력 : ");
        this.medal = sc.nextLine();
    }
    public String rank(){
        return medal;
    }
}
