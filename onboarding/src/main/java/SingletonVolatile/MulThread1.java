package SingletonVolatile;

import SingletonRunnable.Singleton;

class MulThread1 implements Runnable {
    public MulThread1(){}
    @Override
    public void run() {
        Singleton st = Singleton.getInstance();
        st.add();
    }
}

