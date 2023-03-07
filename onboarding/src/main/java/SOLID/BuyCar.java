package SOLID;

class BuyCar {
    int num;
    Sonata sonata;
    public BuyCar(int num){
        this.num = num;
    }
    public Car getCar(){
        if(this.num == 1) new Sonata().speed();
        if(this.num == 2) new Avante().speed();
        return new Sonata();
    }
}
