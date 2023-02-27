package BlockingQueue;

import java.util.Date;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
    private BlockingQueue queue;
    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000L);

            Date d = new Date();
            String msg = "생성 시간 : "+d.toString();
            queue.add(msg);

            System.out.println("생산자가 작업(메시지)을 생성합니다 | Queue Size:[" + queue.size() + "]");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000L);

            Date d = new Date();
            String msg = "생성 시간:"+d.toString();
            queue.add(msg);

            System.out.println("생산자가 작업(메시지)을 생성합니다 | Queue Size:[" + queue.size() + "]");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}