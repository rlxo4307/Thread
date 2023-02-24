package SingletonLazyHolder;
class MulThread2 implements Runnable {
    SingletonLazyHolder si = SingletonLazyHolder.getInstance();
    public MulThread2(){}
    @Override
    public void run(){
        si.sub();
    }
}