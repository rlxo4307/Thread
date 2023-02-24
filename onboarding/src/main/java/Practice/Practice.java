package Practice;

import java.util.concurrent.*;

class Practice {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<Integer> c1 = () -> {
            return 1;
        };
        Future<Integer> f1 = executor.submit(c1);

        System.out.println(f1.get());
    }
}
