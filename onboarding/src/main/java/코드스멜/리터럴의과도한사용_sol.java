package 코드스멜;

class 리터럴의과도한사용_sol {
    private Player player;
    public 리터럴의과도한사용_sol(Player player){
        this.player = player;
    }
    void medal(Player player){
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
