package JoinRunnable;
class SharedObject{
    int money = 0;
    public void add() {
        for(int i=0; i<100; i++) {
            System.out.print("입금:" + ++money + " | 1번 스레드");
        }
    }
    public void sub() {
        for(int i=0; i<100; i++) {
            System.out.print("출금:" + --money + " | 2번 스레드");
        }
    }
}