package CallableRunnable;

import java.util.concurrent.Callable;

public class Callable1 implements Callable<Integer> {
    int a;
    int b;
    public Callable1(int a, int b){
        this.a = a;
        this.b = b;
    }
    @Override
    public Integer call() throws Exception{
        int result = a + b;
        new Thread().sleep(1000L);
        return result;
    }
}
