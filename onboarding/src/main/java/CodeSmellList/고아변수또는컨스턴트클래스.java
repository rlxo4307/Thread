package CodeSmellList;

final class 고아변수또는컨스턴트클래스 {
    int people = 0;
    void total() {
        System.out.println("폐점한 가게의 손님 수:" + people);
    }
}