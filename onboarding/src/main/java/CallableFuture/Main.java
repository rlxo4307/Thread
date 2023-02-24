package CallableFuture;

import java.util.Scanner;
import java.util.concurrent.*;
class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.print("두 수를 입력하세요:");
        Scanner sc = new Scanner(System.in);
        Integer a = sc.nextInt();
        Integer b = sc.nextInt();
        System.out.println();

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable1 c1 = new Callable1(a, b);
        Future<Integer> future = executor.submit(c1);

        int i = 0;
        while (i < 1000) {
            i += future.get();
            System.out.println("Future Add Result [("+a+"+"+b+")배로 증가]:" + i);
        }

    }
}