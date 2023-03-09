package 코드스멜;

class 순환복잡도_sol {
    private static void main(String[] main){
        int num = 0;

        for(int i=0; i<=10; i++){
            num += i;
        }
        if(num != 55)
            return;

        for(int i=11; i<=100; i++){
            num += i;
        }
        if(num == 5500)
            System.out.println("1부터 100까지 더한 값:" + num);
    }
}

