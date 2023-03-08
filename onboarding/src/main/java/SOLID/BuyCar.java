package SOLID;

class BuyCar {
    private int num;
    public BuyCar(int num){
        this.num = num;
        ment();
    }
    public void ment(){
        if(this.num == 1) new Sonata().buy();
        if(this.num == 2) new Avante().buy();
    }
}
