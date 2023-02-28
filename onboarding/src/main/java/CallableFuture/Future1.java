package CallableFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Future1 implements Future<Integer> {
    int a, b;
    Callable1 c1;
    public Future1(){}
    public Future1(Callable1 c1){
        this.c1 = c1;
    }
    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public Integer get() throws InterruptedException, ExecutionException {
        try {
            return c1.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}
