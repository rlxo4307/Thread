package SingletonRunnable;
public class Main {
    public static void main(String[] args) {
        Singleton st = Singleton.getInstance();

        Runnable r1 = new MulThread1(st);
        Runnable r2 = new MulThread2(st);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}