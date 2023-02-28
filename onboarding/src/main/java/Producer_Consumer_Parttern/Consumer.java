package Producer_Consumer_Parttern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Consumer implements Runnable{
    private static final ExecutorService Thread_Pool = Executors.newFixedThreadPool(5);
    public Consumer(){}
    @Override
    public void run(){
        while(true){
            Thread_Pool.submit(SharedOjbect.getInstance().take());
        }
    }
}