package 코드스멜;

class 너무많은매개변수_sol {
    void PlayerLank(Attack attack, Defense defense){

        double result = attack.score() + defense.score();

        if(result >= 100) {
            System.out.println("Star Player");
            return;
        }
        if(result >= 90) {
            System.out.println("Excellent Player");
            return;
        }
        if(result >= 80) {
            System.out.println("Nice Player");
            return;
        }
        if(result >= 70) {
            System.out.println("good Player");
            return;
        }
        if(result >= 60) {
            System.out.println("normal Player");
        }
    }
}

