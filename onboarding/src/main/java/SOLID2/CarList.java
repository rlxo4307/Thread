package SOLID2;

import java.util.ArrayList;
import java.util.List;
class CarList {
    private List<String> list = new ArrayList<>();
    public CarList(){}
    public CarList(String car){
        valid(car);
        list.add(car);
    }
    private void valid(String car) {
        if (!(car instanceof String)) {
            try {
                throw new IllegalArgumentException();
            } catch (Exception e) {
            }
        }
    }
    public List<String> getList(){
        return this.list;
    }
}
