package SOLID;

import java.util.List;
import java.util.Scanner;
class BuyCar {
    Scanner sc = new Scanner(System.in);
    private List<Car> list;

    public BuyCar(){
        this.list = new CarList().getList();

        for(int i=1; i<=list.size(); i++){
            System.out.println("차량 번호 "+i+"."+list.get(i-1));
        }
        System.out.print("구매할 차량 번호를 입력하세요:");
        ment(sc.nextInt());
    }

    public void ment(int carNumber){
        System.out.println(list.get(carNumber-1)+"을(를) 구매해 주셔서 감사합니다.");
    }
}