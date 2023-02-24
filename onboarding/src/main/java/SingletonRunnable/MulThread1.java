package SingletonRunnable;
class MulThread1 implements Runnable {
    Singleton st = Singleton.getInstance();
    public MulThread1(){}
    @Override
    public void run() {
        st.add();
    }
}