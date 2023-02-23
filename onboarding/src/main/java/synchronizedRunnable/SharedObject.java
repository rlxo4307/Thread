package synchronizedRunnable;

class SharedObject{
    int money = 0;
    public synchronized void add() {
        System.out.println("입금:" + ++money + " | 1번 스레드");
    }
    public synchronized void sub() {
        System.out.println("출금:" + --money + " | 2번 스레드");
    }
}