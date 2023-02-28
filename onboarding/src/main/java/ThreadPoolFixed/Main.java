package ThreadPoolFixed;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class Main {
    public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 15; i++) {
            executor.submit(new MulRunnable());
        }
        executor.shutdown();
    }
}
