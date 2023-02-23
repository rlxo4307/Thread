package SingletonVolatile;
class MulThread2 implements Runnable {
    SingletonVolatile st;

    public MulThread2(SingletonVolatile st) {
        this.st = st;
    }

    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            st.sub();
        }
    }
}