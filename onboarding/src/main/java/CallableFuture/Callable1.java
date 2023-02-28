package CallableFuture;

import java.util.Scanner;
import java.util.concurrent.Callable;

class Callable1 implements Callable<Integer> {
    Integer a, b;
    public Callable1(){}
    Scanner sc = new Scanner(System.in);
    @Override
    public Integer call() throws Exception {
            System.out.println("더할 두 수를 입력하세요");
            a = sc.nextInt();
            b = sc.nextInt();
            Integer result = a + b;
            new Thread().sleep(1500L);
        return result;
    }
}
