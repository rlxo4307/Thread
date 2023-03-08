package SOLID;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        new CarList();
        System.out.print("구매할 차량 번호를 입력하세요:");
        new BuyCar(sc.nextInt());
    }
}
