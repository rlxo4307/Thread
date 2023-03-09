package 코드스멜;

class 너무많은매개변수 {
    void PlayerLank(int goals, int pass, int dribbles, int heading, int skill, int defense, int blocking){

        double result = (goals * 3) + (pass * 1.6) + (dribbles * 1.5) + heading + (skill * 1.5)
                +(defense * 1.4) + (blocking * 1.4);

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
