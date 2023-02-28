package Education_0227;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class Consumer implements Runnable {
    private static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(5);
    @Override
    public void run() {
        while (true) {
            ConsumerTask consumerTask = SharedResource.getInstance().take();
            THREAD_POOL.submit(consumerTask);
        }
    }
}