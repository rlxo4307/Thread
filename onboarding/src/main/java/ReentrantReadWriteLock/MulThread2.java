package ReentrantReadWriteLock;
class MulThread2 implements Runnable {
    SharedObject so = new SharedObject();
    @Override
    public void run() {
        so.getMoney();
    }
}
