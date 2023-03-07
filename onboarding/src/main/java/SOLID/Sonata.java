package SOLID;

class Sonata implements Car{
    public Sonata(){}

    @Override
    public void speed(){
        System.out.println("소나타는 1순위 스피드를 가졌다");
    }

}