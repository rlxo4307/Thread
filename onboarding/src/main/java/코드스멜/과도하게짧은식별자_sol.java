package 코드스멜;

class 과도하게짧은식별자_sol {
    void 입학시험(int math, int english){
        if(math+english >= 100){
            System.out.println("합격");
            return;
        }
        if(math+english < 100) {
            System.out.println("불합격");
            return;
        }
    }
}

