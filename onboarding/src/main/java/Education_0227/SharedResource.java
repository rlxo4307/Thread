package Education_0227;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class SharedResource {
    private static final BlockingQueue<ConsumerTask> queue = new ArrayBlockingQueue<>(3);
    private SharedResource() {
    }
    private static final class SharedResourceHolder {
        static final SharedResource sharedResource = new SharedResource();
    }
    public static SharedResource getInstance() {
        return SharedResourceHolder.sharedResource;
    }

    public void put(ConsumerTask task) {
        try {
            queue.put(task);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public ConsumerTask take() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
