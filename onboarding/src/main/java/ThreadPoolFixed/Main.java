package ThreadPoolFixed;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class Main {
    public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 9; i++) {
            Runnable r1 = new MulRunnable();
            executor.submit(r1);
        }
        executor.shutdown();
    }
}
