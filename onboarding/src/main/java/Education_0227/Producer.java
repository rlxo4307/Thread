package Education_0227;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Producer implements Runnable {
    private static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(2);
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("더할 두 수를 입력 하세요>");
            THREAD_POOL.submit(new ProducerTask(sc.nextInt(), sc.nextInt()));
        }
    }
}