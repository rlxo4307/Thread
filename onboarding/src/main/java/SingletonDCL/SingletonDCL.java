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
    public void add(){
        for(int i=0; i<100; i++) {
            synchronized (this) {
                System.out.println("입금:" + ++money + " | 1번 스레드");
            }
        }
    }
    public void sub(){
        for(int i=0; i<100; i++) {
            synchronized (this) {
                System.out.println("출금:" + --money + " | 2번 스레드");
            }
        }
    }
}

