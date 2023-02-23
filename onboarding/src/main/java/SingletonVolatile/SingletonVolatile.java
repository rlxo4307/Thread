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
    synchronized void add(){
        System.out.println("입금:"+ ++money + " | 1번 스레드");
    }
    synchronized void sub(){
        System.out.println("출금:"+ --money + " | 2번 스레드");
    }
}


