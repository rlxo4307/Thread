package SingletonRunnable;
public class Singleton {
    private static Singleton myInstance = null;
    private Singleton() {}
    public static Singleton getInstance(){
        if(myInstance == null) {
            myInstance = new Singleton();
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
