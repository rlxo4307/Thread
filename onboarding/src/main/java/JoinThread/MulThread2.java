package JoinThread;
class MulThread2 extends Thread {
    SharedObject so;
    public MulThread2(SharedObject so) {
        this.so = so;
    }
    @Override
    public void run() {
        so.sub();
    }
}
