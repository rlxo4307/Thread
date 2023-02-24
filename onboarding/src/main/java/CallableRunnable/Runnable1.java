package CallableRunnable;

public class Runnable1 implements Runnable{
    public Runnable1(){}
    @Override
    public void run() {
        System.out.println("Runnable Success");
        try {
            new Thread().sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
