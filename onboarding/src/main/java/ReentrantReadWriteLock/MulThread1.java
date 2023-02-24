package ReentrantReadWriteLock;
class MulThread1 implements Runnable {
    SharedObject so;
    public MulThread1(SharedObject so) {
        this.so = so;
    }
    @Override
    public void run() {
        so.add();
    }
}