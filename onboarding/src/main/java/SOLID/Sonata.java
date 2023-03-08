package SOLID;
class Sonata implements Car{
    public Sonata(){}
    @Override
    public void buy(){
        System.out.println("Sonata를 구매해 주셔서 감사합니다.");
    }
}
