package SingletonLazyHolder;
class SingletonLazyHolder {
    private SingletonLazyHolder() {}

    public static SingletonLazyHolder getInstance() {
        return LazyHolder.INSTANCE;
    }
    private static class LazyHolder {
        private static final SingletonLazyHolder INSTANCE = new SingletonLazyHolder();
    }
    private int money = 0;

    public synchronized void add(){
        for(int i=0; i<100; i++) {
            System.out.println("입금:" + ++money + " | 1번 스레드");
        }
    }
    public synchronized void sub(){
        for(int i=0; i<100; i++) {
            System.out.println("출금:" + --money + " | 2번 스레드");
        }
    }
}

