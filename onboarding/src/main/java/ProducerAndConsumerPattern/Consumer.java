package ProducerAndConsumerPattern;

import java.util.concurrent.BlockingQueue;

class Consumer implements Runnable {
    private BlockingQueue queue;
    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1100L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int result = 0;
        try {
            result = (Integer)queue.take() * 2;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("소비자가 작업(곰셈)을 처리합니다 | 결과:"+ result +" (덧셈결과 * 2, 두 번씩 나타납니다) | "+Thread.currentThread().getName()+" | Queue Size:["+queue.size()+"]");
    }
}