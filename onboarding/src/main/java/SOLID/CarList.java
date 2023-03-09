package SOLID;

import java.util.ArrayList;
import java.util.List;

class CarList {
    private final List<String> list = new ArrayList<>();
    public CarList(){
        this.list.add("Sonata");
        this.list.add("Avante");
        run();
    }
    void run(){
        for(int i=1; i<=this.list.size(); i++){
            System.out.println("차량 번호 "+i+"."+this.list.get(i-1));
        }
    }
}


