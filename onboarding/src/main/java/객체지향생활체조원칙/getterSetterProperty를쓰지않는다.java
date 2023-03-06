package 객체지향생활체조원칙;

class getterSetterProperty를쓰지않는다 {
    private static void main(String[] args){
        Test1 testBmi = new Test1();
        if(testBmi.getBmi() >= 20.0){
            System.out.println("표준 이상입니다.");
        }
    }
}
class Test1{
    private double bmi = 20.0;
    double getBmi(){
        return this.bmi;
    }
}