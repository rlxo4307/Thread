package SingletonRunnable;
class MulThread2 implements Runnable {
    public MulThread2(){}
    @Override
    public void run() {
        Singleton st = Singleton.getInstance();
        st.sub();
    }
}

