package BlockingQueue;

import java.util.concurrent.BlockingQueue;

class Consumer implements Runnable {
    private BlockingQueue queue;
    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1001L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String msg = null;
        try {
            msg = (String) queue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("소비자가 작업(메시지)을 처리합니다 | " + msg + " Queue Size:[" + queue.size() + "]");
    }
}


