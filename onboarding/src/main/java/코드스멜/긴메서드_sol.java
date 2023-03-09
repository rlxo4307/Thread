package 코드스멜;

class 긴메서드_sol {
    private int tall;
    private int kg;
    public 긴메서드_sol(int tall, int kg){
        this.tall = tall;
        this.kg = kg;
    }
    public String bmi(int tall, int kg) {
        double result = kg / (tall * tall);
        String state = "저체중";

        if (result >= 25.0) {
            state = "비만";
            return state;
        }
        if (result >= 23.0) {
            state = "과체중";
            return state;
        }
        if (result >= 18.5) {
            state = "정상";
            return state;
        }
        return state;
    }
}

