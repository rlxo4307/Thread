package ReentrantReadWriteLock;
class MulThread1 implements Runnable {
    SharedObject so = new SharedObject();
    @Override
    public void run() {
        so.add();
    }
}