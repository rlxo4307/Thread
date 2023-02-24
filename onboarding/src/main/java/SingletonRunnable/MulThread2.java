package SingletonRunnable;
class MulThread2 implements Runnable {
    Singleton st = Singleton.getInstance();
    public MulThread2(){}
    @Override
    public void run() {
        st.sub();
    }
}