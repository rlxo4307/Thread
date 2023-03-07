package 객체지향생활체조원칙;

class else키워드를쓰지않는다_sol {
    private static void main(String[] args) {
        int num = Math.round((int)Math.random()*6);

        if (num == 1) {
            System.out.println("주사위 숫자는 1");
            return;
        }
        if (num == 2) {
            System.out.println("주사위 숫자는 2");
            return;
        }
        if (num == 3) {
            System.out.println("주사위 숫자는 3");
            return;
        }
        if (num == 4) {
            System.out.println("주사위 숫자는 4");
            return;
        }
        if (num == 5) {
            System.out.println("주사위 숫자는 5");
            return;
        }
        if (num == 6) {
            System.out.println("주사위 숫자는 5");
        }
    }
}