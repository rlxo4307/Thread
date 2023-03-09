package 코드스멜;

import java.util.Scanner;

class 과도하게긴식별자 {
    Scanner sc = new Scanner(System.in);

    void rewardsBasedOnTheNumberOfSuccesses(double success){
        success = (int)(Math.random()*10+1);

        if(success == 10){
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
        }
    }
}