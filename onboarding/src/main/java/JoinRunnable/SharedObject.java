package JoinRunnable;
class SharedObject{
    int money = 0;
    public void add() {
        System.out.print("입금:" + ++money);
    }
    public void sub() {
        System.out.print("출금:" + --money);
    }
}
