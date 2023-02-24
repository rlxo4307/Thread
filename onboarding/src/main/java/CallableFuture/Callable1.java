package CallableFuture;

import java.util.concurrent.Callable;

class Callable1 implements Callable<Integer> {
    int a;
    int b;
    public Callable1(int a, int b){
        this.a = a;
        this.b = b;
    }
    @Override
    public Integer call() throws Exception {
        new Thread().sleep(1500L);
        Integer result = a + b;
        return result;
    }
}