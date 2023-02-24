package CallableRunnable;

public class Runnable1 implements Runnable{
    public Runnable1(){}
    @Override
    public void run() {
        try {
            new Thread().sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Runnable Success");
    }
}
