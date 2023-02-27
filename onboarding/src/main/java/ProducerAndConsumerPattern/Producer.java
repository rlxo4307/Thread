package ProducerAndConsumerPattern;

import java.util.Date;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
    private BlockingQueue queue;
    int a;
    int b;
    public Producer(BlockingQueue queue, int a, int b) {
        this.queue = queue;
        this.a = a;
        this.b = b;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000L);
            int result = this.a + this.b;
            queue.add(result);
            System.out.println("생산자가 덧셈 결과를 생성합니다 | "+Thread.currentThread().getName()+" | Queue Size:[" + queue.size() + "]");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}