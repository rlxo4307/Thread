package 코드스멜;

class 과도하게긴식별자_sol {
    public String bmi(int tall, int kg){
        double result = kg / (tall*tall);
        String state = "저체중";

        if(result >= 25.0){
            state = "비만";
            return state;
        }
        if(result >= 23.0){
            state = "과체중";
            return state;
        }if(result >= 18.5){
            state = "정상";
            return state;
        }
        return state;

    }
}

