package CallableRunnable;

import java.util.Scanner;
import java.util.concurrent.Callable;

public class Callable1 implements Callable<Integer> {
    public Callable1(){}
    Scanner sc = new Scanner(System.in);
    @Override
    public Integer call() throws Exception{
            System.out.print("더할 두 수를 입력하세요:");
            Integer a = sc.nextInt();
            Integer b = sc.nextInt();
            int result = a + b;
            new Thread().sleep(1000L);
        return result;
    }
}
