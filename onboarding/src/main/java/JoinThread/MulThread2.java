package JoinThread;
class MulThread2 extends Thread {
    SharedObject so;
    public MulThread2(SharedObject so) {
        this.so = so;
    }
    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            so.sub();
        }
    }
}
