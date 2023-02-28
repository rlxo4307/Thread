package SingletonLazyHolder;
class MulThread1 implements Runnable {
    public MulThread1(){}
    @Override
    public void run(){
        SingletonLazyHolder si = SingletonLazyHolder.getInstance();
        si.add();
    }
}
