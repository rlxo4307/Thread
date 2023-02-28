package Practice;

import java.util.concurrent.locks.ReentrantReadWriteLock;
class Singleton {
    private int money = 0;
    public static Singleton getInstance(){
        return LazyHolder.INSTANCE;
    }
    private static class LazyHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void add(){
        for(int i=0; i<100; i++){
            lock.writeLock().lock();
            System.out.println("입금:"+ ++money);
            lock.writeLock().unlock();
        }
    }


}
