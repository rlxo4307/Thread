package SingletonVolatile;
class MulThread2 implements Runnable {
    SingletonVolatile st = SingletonVolatile.getInstance();
    public MulThread2() {}
    @Override
    public void run() {
        st.sub();
    }
}