package Producer_Consumer_Parttern;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class Producer implements Runnable{
    private static ExecutorService Thread_Pool = Executors.newFixedThreadPool(2);
    Scanner sc = new Scanner(System.in);
    @Override
    public void run(){
        while(true){
            System.out.println("두 수와 연산을 입력하세요(덧셉:1, 뺼셈:2, 곱셈:3, 나눗셈:4):");
            Thread_Pool.submit(new ProducerTask(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
    }
}
