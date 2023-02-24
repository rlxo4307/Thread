package ThreadPoolFixed;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class Main {
    public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 10; i++) {
            Runnable r1=new MulRunnable();
            executor.submit(r1);
        }
        executor.shutdown();
    }
}
