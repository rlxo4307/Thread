package SingletonRunnable;
class MulThread1 implements Runnable {
    Singleton st = Singleton.getInstance();
    public MulThread1(Singleton st) {
        this.st = st;
    }
    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            st.add();
        }
    }
}