package CallableRunnable;

import java.util.Scanner;
import java.util.concurrent.*;

class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable1 c = new Callable1();
        FutureTask<Integer> ft = new FutureTask<>(c);
        ft.run();

        int i = 0;
            while(true) {
                i += ft.get();
                System.out.println("Callable Add Result : " + i);
                new Thread(new Runnable1()).start();
            }
    }
}
