package SingletonLazyHolder;
class MulThread1 implements Runnable {
    SingletonLazyHolder si = SingletonLazyHolder.getInstance();
    public MulThread1(){}
    @Override
    public void run(){
        si.add();
    }
}