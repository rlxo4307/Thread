package ReentrantReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;
class SharedObject {
    private int money = 0;
    private ReentrantReadWriteLock useLock = new ReentrantReadWriteLock();
    public void add() {
        useLock.readLock().lock();
        try {
            System.out.println("잔액:" + money);
        }finally {
            useLock.readLock().unlock();
        }
    }
    public void getMoney() {
        useLock.readLock().lock();
        try{
            System.out.println("현재 잔액:" + money);
        }finally {
            useLock.readLock().unlock();
        }
    }
}

