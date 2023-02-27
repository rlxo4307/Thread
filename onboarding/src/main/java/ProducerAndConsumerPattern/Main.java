package ProducerAndConsumerPattern;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Main {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(3);
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Scanner sc = new Scanner(System.in);
        int a;
        int b;

        while(true){
            System.out.println("더할 두 수를 입력하세요 : ");
            a = sc.nextInt();
            b = sc.nextInt();

            Producer p = new Producer(queue, a, b);
            Consumer c = new Consumer(queue);

            executor.submit(p);
            executor.submit(p);
            executor.submit(c);
        }
    }
}