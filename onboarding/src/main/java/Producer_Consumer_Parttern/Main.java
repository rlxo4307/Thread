package Producer_Consumer_Parttern;

class Main {
    public static void main(String[] args){
        new Thread(new Consumer()).start();
        new Thread(new Producer()).start();
    }
}
