package CodeSmellList;

class 과도하게긴식별자 {
    void rewardsBasedOnTheNumberOfSuccesses(int success){
        if(success >= 10){
            System.out.println("만점입니다. 금상을 수여합니다.");
            return;
        }
        if(success >= 8){
            System.out.println("우수한 성적입니다. 은상을 수여합니다.");
            return;
        }
        if(success >= 7){
            System.out.println("순위권에 들었습니다. 동상을 수여합니다.");
            return;
        }
        if(success >= 5){
            System.out.println("고생했습니다. 장려상을 수여합니다.");
            return;
        }
    }
}