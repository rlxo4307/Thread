package ReentrantReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;
class SharedObject {
    private int money = 0;
    private ReentrantReadWriteLock useLock = new ReentrantReadWriteLock();
    public void add() {
        useLock.writeLock().lock();
        try {
            System.out.println("입금:" + ++money);
        }finally {
            useLock.writeLock().unlock();
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

