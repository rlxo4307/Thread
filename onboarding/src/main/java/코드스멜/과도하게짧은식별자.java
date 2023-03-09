package 코드스멜;
class 과도하게짧은식별자 {
    void a(int a, int b){
        if(a+b >= 100){
            System.out.println("합격");
            return;
        }
        if(a+b < 100) {
            System.out.println("불합격");
            return;
        }
    }
}