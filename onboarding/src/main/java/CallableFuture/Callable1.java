package CallableFuture;

import java.util.concurrent.Callable;

class Callable1 implements Callable<Integer> {
    int a;
    int b;
    public Callable1(Integer a, Integer b){
        this.a = a;
        this.b = b;
    }
    @Override
    public Integer call() throws Exception {
        new Thread().sleep(1000);
        Integer result = a + b;
        return result;
    }

}