package ProducerAndConsumerPattern;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Main {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(5);
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Scanner sc = new Scanner(System.in);
        int a;
        int b;

        while(true){
            System.out.println("더할 두 수를 입력하세요 : ");
            a = sc.nextInt();
            b = sc.nextInt();

            Producer p = new Producer(queue, a, b);
            executor.submit(p);
            executor.submit(p);
            Consumer c = new Consumer(queue);
            executor.submit(c);
        }
    }
}