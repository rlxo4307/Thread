package CallableRunnable;

import java.util.Scanner;
import java.util.concurrent.*;

class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.print("두 수를 입력하세요:");
        Scanner sc = new Scanner(System.in);
        Integer a = sc.nextInt();
        Integer b = sc.nextInt();
        System.out.println();

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable1 c1 = new Callable1(a, b);
        Future<Integer> f1 = executor.submit(c1);

        int i = 0;
            while(true) {
                i += f1.get();
                System.out.println("Callable Add Result [("+a+"+"+b+")배로 증가]:" + i);
                new Thread(new Runnable1()).start();
            }
    }
}
