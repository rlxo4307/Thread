package Producer_Consumer_Parttern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Consumer implements Runnable{
    private static final ExecutorService Thread_Pool = Executors.newFixedThreadPool(5);
    @Override
    public void run(){
        while(true){
            Thread_Pool.submit(SharedResource.getInstance().take());
        }
    }
}
