package SingletonDCL;
class MulThread1 implements Runnable {
    SingletonDCL si = SingletonDCL.getInstance();
    public MulThread1(){}
    @Override
    public void run(){
        si.add();
    }
}