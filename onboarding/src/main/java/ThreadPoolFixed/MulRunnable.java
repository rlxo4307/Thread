package ThreadPoolFixed;

class MulRunnable implements Runnable{
    public MulRunnable(){}
    @Override
    public void run(){
        SingletonLazyHolder si = SingletonLazyHolder.getInstance();
        System.out.println(Thread.currentThread().getName());
        si.add();
        sleepThread();
    }

    private void sleepThread(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
