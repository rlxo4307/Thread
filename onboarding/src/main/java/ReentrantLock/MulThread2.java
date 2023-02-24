package ReentrantLock;
class MulThread2 implements Runnable {
    SharedObject so;
    public MulThread2(SharedObject so) {
        this.so = so;
    }
    @Override
    public void run() {
        so.sub();
    }
}