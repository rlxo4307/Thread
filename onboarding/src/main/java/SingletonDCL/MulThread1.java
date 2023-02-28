package SingletonDCL;
class MulThread1 implements Runnable {
    public MulThread1(){}
    @Override
    public void run(){
        SingletonDCL si = SingletonDCL.getInstance();
        si.add();
    }
}
