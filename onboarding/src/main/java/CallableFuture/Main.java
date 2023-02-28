package CallableFuture;

import jdk.nashorn.internal.runtime.regexp.joni.exception.SyntaxException;

import java.util.Scanner;
import java.util.concurrent.*;
class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        int i = 0;
        while (i < 1000) {
            Callable1 c1 = new Callable1();
            Future<Integer> future = new Future1(c1);
            i += future.get();
            System.out.println("Future Add Result > "+i+" 증가");
            System.out.println();
        }

    }
}