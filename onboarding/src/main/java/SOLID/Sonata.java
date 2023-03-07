package SOLID;

class Sonata implements Car{
    public Sonata(){}

    @Override
    public void speed(){
        System.out.println("1위의 스피드를 가진 자동차는 소나타이다");
    }

}