package SOLID;

import java.util.ArrayList;
import java.util.List;

class CarList {
    private List<Car> list;
    public CarList(){
        List<Car> list = new ArrayList<>();
        this.list = list;
        this.list.add(new Avante());
        this.list.add(new Sonata());
    }
    public List<Car> getList(){
        return this.list;
    }
}


