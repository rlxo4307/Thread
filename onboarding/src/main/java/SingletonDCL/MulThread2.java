package SingletonDCL;
class MulThread2 implements Runnable {
    SingletonDCL si = SingletonDCL.getInstance();
    public MulThread2(){}
    @Override
    public void run(){
        si.sub();
    }
}
