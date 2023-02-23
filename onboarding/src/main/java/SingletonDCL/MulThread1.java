package SingletonDCL;
class MulThread1 implements Runnable {
    SingletonDCL si = null;
    public MulThread1(){}
    public MulThread1(SingletonDCL si){
        this.si = si;
    }

    @Override
    public void run(){
        for(int i=0; i<100; i++){
            si.add();
        }
    }
}