package SingletonDCL;
class Main {
    public static void main(String[] args){
        SingletonDCL si = SingletonDCL.getInstance();

        Runnable r1 = new MulThread1(si);
        Runnable r2 = new MulThread2(si);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}
