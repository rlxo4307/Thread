package JoinRunnable;

class MulThread1 implements Runnable {
    SharedObject so;
    public MulThread1(SharedObject so) {
        this.so = so;
    }
    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            so.add();
            System.out.println(" | 1번 스레드");
        }
    }
}
