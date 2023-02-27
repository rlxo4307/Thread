package ThreadPoolFixed;

class MulRunnable implements Runnable{
    public MulRunnable(){}
    @Override
    public void run(){
        SingletonLazyHolder si = SingletonLazyHolder.getInstance();
        System.out.println(Thread.currentThread().getName()+"가 시작되었습니다");
        si.add();
        System.out.println(Thread.currentThread().getName()+"가 종료되었습니다");
        sleepThread();
    }

    private void sleepThread(){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
