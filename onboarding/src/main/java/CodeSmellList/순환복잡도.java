package CodeSmellList;

class 순환복잡도 {
    public static void main(String[] main){
        int num = 0;

        for(int i=0; i<=10; i++){
            num += i;
            if(num == 55){
                for(int j=11; j<=100; j++){
                    num += j;
                    if(num == 5050){
                        System.out.println("1부터 100까지 더한 값:"+num);
                    }
                }
            }
        }
    }
}