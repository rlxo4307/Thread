package JoinRunnable;

class MulThread2 implements Runnable {
    SharedObject so;
    public MulThread2(SharedObject so) {
        this.so = so;
    }
    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            so.sub();
            System.out.println(" | 2번 스레드");
        }
    }
}