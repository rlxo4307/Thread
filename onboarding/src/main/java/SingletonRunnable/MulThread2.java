package SingletonRunnable;
class MulThread2 implements Runnable {
    Singleton st = Singleton.getInstance();
    public MulThread2(Singleton st) {
        this.st = st;
    }
    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            st.sub();
        }
    }
}