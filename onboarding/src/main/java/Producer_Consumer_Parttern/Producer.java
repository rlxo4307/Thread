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
            System.out.println("더할 두 수를 입력하세요");
            Thread_Pool.submit(new ProducerTask(sc.nextInt(), sc.nextInt()));
        }
    }
}

