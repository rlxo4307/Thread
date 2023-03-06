package CodeSmellList;

class 다운캐스팅 extends 커다란클래스{
    커다란클래스 hugeClass = new 커다란클래스();
    다운캐스팅 downBmi = (다운캐스팅)hugeClass;
    double bmi = downBmi.bmi(178, 66);
}