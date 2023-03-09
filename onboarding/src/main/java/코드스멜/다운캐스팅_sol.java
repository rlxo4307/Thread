package 코드스멜;

class 다운캐스팅_sol {
    다운캐스팅 downCasting = new 다운캐스팅();
    커다란클래스 upBmi = (커다란클래스)downCasting;
    다운캐스팅 downBmi = (다운캐스팅)upBmi;
    double bmi = downBmi.bmi(178, 66);
}
