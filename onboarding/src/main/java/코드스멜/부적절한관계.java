package 코드스멜;

class 부적절한관계 {
    void health(){
        System.out.println("PT를 시작하기에 앞서 bmi를 측정하겠습니다.");
    }
    static double bmi(int tall, int kg){
        double result = kg / (tall*tall);
        return result;
    }

    void result(double bmi){
        if(bmi >= 25.0){
            System.out.println("비만");
        }else if(bmi >= 23.0){
            System.out.println("과체중");
        }else if(bmi >= 18.5){
            System.out.println("정상");
        }else{
            System.out.println("저체중");
        }
    }
}