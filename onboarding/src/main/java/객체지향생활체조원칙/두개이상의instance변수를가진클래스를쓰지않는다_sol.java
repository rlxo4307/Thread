package 객체지향생활체조원칙;

class 두개이상의instance변수를가진클래스를쓰지않는다_sol {
    private int height;
    private int weight;

    public 두개이상의instance변수를가진클래스를쓰지않는다_sol(int height, int weight){
        this.height = height;
        this.weight = weight;
    }
    public void bmi(String name){
        double result = this.weight / (this.height * this.height);
        System.out.println(name+"님의 bmi는 " + result+"입니다.");
    }

}