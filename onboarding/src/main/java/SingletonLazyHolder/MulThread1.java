package SingletonLazyHolder;
class MulThread1 implements Runnable {
    SingletonLazyHolder si = null;
    public MulThread1(){}
    public MulThread1(SingletonLazyHolder si){
        this.si = si;
    }

    @Override
    public void run(){
        for(int i=0; i<100; i++){
            si.add();
        }
    }
}