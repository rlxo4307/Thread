package SingletonVolatile;
class MulThread2 implements Runnable {
    public MulThread2() {}
    @Override
    public void run() {
        SingletonVolatile st = SingletonVolatile.getInstance();
        st.sub();
    }
}