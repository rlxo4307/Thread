package CodeSmellList;

class 리터럴의과도한사용 {
    final int gold = 1;
    final int silver = 2;
    final int bronze = 3;
    final int none = 0;
    void medal(int rank){
        if(rank==gold) {
            System.out.println("금메달을 축하합니다.");
            return;
        }
        if(rank==silver) {
            System.out.println("은메달을 축하합니다.");
            return;
        }
        if(rank==bronze) {
            System.out.println("동메달을 축하합니다.");
            return;
        }
        if(rank==none) {
            System.out.println("다음 기회가 있습니다.");
        }
    }

}
