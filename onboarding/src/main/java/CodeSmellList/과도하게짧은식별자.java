package CodeSmellList;
class 과도하게짧은식별자 {
    void a(int a, int b, int c){
        if(a+b+c >= 10){
            System.out.println("합격");
            return;
        }
        if(a+b+c < 10) {
            System.out.println("불합격");
            return;
        }
    }
}
