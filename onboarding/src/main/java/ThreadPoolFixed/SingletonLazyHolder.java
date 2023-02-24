package ThreadPoolFixed;
class SingletonLazyHolder {
    private SingletonLazyHolder() {}

    public static SingletonLazyHolder getInstance() {
        return SingletonLazyHolder.LazyHolder.INSTANCE;
    }
    private static class LazyHolder {
        private static final SingletonLazyHolder INSTANCE = new SingletonLazyHolder();
    }
    private int money = 0;
    public synchronized void add(){
        System.out.println(" 입금:" + ++money);
    }
}