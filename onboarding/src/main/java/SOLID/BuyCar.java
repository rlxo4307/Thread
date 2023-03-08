package SOLID;

import java.util.Scanner;
class BuyCar {
    private int num;
    Scanner sc = new Scanner(System.in);
    public BuyCar(){
        System.out.print("구매할 차량 번호를 입력하세요:");
        this.num = sc.nextInt();
        ment();
    }
    public void ment(){
        if(this.num == 1) new Sonata().buy();
        if(this.num == 2) new Avante().buy();
    }
}
