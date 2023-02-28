package SingletonLazyHolder;
class MulThread2 implements Runnable {
    public MulThread2(){}
    @Override
    public void run(){
        SingletonLazyHolder si = SingletonLazyHolder.getInstance();
        si.sub();
    }
}

