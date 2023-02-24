package SingletonDCL;
class MulThread2 implements Runnable {
    public MulThread2(){}
    @Override
    public void run(){
        SingletonDCL si = SingletonDCL.getInstance();
        si.sub();
    }
}
