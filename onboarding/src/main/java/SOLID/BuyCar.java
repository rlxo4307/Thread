package SOLID;

import java.util.List;
import java.util.Scanner;
class BuyCar {
    private List<Car> list;
    Scanner sc = new Scanner(System.in);
    public BuyCar(){
        this.list = new CarList().getList();

        for(int i=1; i<=list.size(); i++){
            System.out.println("차량 번호 "+i+"."+list.get(i-1));
        }
        System.out.print("구매할 차량 번호를 입력하세요:");
        ment(sc.nextInt());
    }
    public void ment(int num){
        System.out.println(list.get(num-1)+"을(를) 구매해 주셔서 감사합니다.");
    }
}