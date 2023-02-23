package SingletonLazyHolder;
class MulThread2 implements Runnable {
    SingletonLazyHolder si = null;
    public MulThread2(){}
    public MulThread2(SingletonLazyHolder si){
        this.si = si;
    }

    @Override
    public void run(){
        for(int i=0; i<100; i++){
            si.sub();
        }
    }
}