package Producer_Consumer_Parttern;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
class SharedOjbect {
    private static final BlockingQueue<ConsumerTask> BQ = new ArrayBlockingQueue(5);
    private SharedOjbect(){}
    public static SharedOjbect getInstance(){
        return LazyHolder.INSTANCE;
    }
    private static class LazyHolder{
        private static final SharedOjbect INSTANCE = new SharedOjbect();
    }

    public void put(ConsumerTask CT){
        try {
            BQ.put(CT);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public ConsumerTask take(){
        try {
            return BQ.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
