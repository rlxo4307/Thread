package JoinThread;
class SharedObject{
    int money = 0;
    public void add() {
        System.out.println("입금:" + ++money + " | 1번 스레드");
    }
    public void sub() {
        System.out.println("출금:" + --money + " | 2번 스레드");
    }
}
