package SingletonVolatile;

class SingletonVolatile {
    private volatile static SingletonVolatile myInstance = null;
    private SingletonVolatile() {}
    public static SingletonVolatile getInstance() {
        if (myInstance == null) {
            synchronized (SingletonVolatile.class) {
                if (myInstance == null) {
                    myInstance = new SingletonVolatile();
                }
            }
        }
        return myInstance;
    }
    private int money = 0;
    public synchronized void add(){
        System.out.println("입금:"+ ++money + " | 1번 스레드");
    }
    public synchronized void sub(){
        System.out.println("출금:"+ --money + " | 2번 스레드");
    }
}


