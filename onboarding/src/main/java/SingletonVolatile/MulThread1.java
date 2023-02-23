package SingletonVolatile;
class MulThread1 implements Runnable {
    SingletonVolatile st = SingletonVolatile.getInstance();
    public MulThread1(SingletonVolatile st) {
        this.st = st;
    }

    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            st.add();
        }
    }
}