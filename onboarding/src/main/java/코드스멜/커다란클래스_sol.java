package 코드스멜;

class 커다란클래스_sol {
    private int tall;
    private int kg;
    public 커다란클래스_sol(int tall, int kg){
        this.tall = tall;
        this.kg = kg;
    }
    public double bmi(int tall, int kg){
        double result = this.kg / (this.tall * this.tall);
        return result;
    }
}

