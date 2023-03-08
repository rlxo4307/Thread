package SOLID;

import java.util.ArrayList;
import java.util.List;

class CarList {
    public CarList(){
        List<String> list = new ArrayList<>();
        list.add("Sonata");
        list.add("Avante");
        for(int i=1; i<=list.size(); i++){
            System.out.println("차량 번호 "+i+"."+list.get(i-1));
        }
    }
}