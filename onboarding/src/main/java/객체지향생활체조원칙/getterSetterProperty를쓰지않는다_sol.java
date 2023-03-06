package 객체지향생활체조원칙;

class getterSetterProperty를쓰지않는다_sol {
    private static void main(String[] args){
        Test2 testBmi = new Test2();
        System.out.println("테스트 bmi 지수는 " + testBmi.result() + "입니다.");
    }
}

class Test2 {
    private double bmi = 20.0;
    String result() {
        if (this.bmi >= 20.0) return "표준 이상";
        if (this.bmi < 20.0) return "표준 이하";
        return "";
    }
}