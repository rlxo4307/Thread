package SingletonDCL;
class SingletonDCL {
    private static SingletonDCL myInstance = null;
    private SingletonDCL() {}
    public static SingletonDCL getInstance() {
        if (myInstance == null) {
            synchronized (SingletonDCL.class) {
                if (myInstance == null) {
                    myInstance = new SingletonDCL();
                }
            }
        }
        return myInstance;
    }
    private int money = 0;

    public synchronized void add(){
        System.out.println("입금:" + ++money + " | 1번 스레드");
    }
    public synchronized void sub(){
        System.out.println("출금:" + --money + " | 2번 스레드");
    }
}