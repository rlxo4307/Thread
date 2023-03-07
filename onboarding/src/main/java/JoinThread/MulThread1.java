package JoinThread;
class MulThread1 extends Thread {
    SharedObject so;
    public MulThread1(SharedObject so) {
        this.so = so;
    }
    @Override
    public void run() {
        so.add();
    }
}