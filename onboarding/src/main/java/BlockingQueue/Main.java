package BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Main {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(5);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Producer p = new Producer(queue);
        Consumer c = new Consumer(queue);

        int i = 0;
        while(i < 1000) {
            executor.submit(p);
            executor.submit(c);
            i++;
        }
        executor.shutdown();
    }
}