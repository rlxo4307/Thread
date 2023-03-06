package 객체지향생활체조원칙;

class 한메서드에하나의들여쓰기만한다 {
    private static void main(String[] args){
        int result = 0;
        for(int i=0; i<10; i++){
            result += i;
            if(result == 10){
                for(int j=0; j<10; j++){
                    if(result == 20){
                        System.out.println("1을 20번 더하면 합은 20");
                        return;
                    }
                    if(result != 20){
                        System.out.println("1을 20번 더하면 합은 20이 아닙니다");
                        return;
                    }
                }
            }
        }
    }
}