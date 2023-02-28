package synchronizedRunnable;

class MulThread1 implements Runnable {
    public MulThread1(){}
    SharedObject so = new SharedObject();
    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            so.add();
        }
    }
}