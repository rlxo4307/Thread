package synchronizedRunnable;

class MulThread2 implements Runnable {
    public MulThread2(){}
    SharedObject so = new SharedObject();
    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            so.sub();
        }
    }
}