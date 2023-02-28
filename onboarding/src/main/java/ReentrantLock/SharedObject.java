package ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
class SharedObject {
    private int money = 0;
    private Lock lock = new ReentrantLock();
    public Lock getLock(){
        return lock;
    };
    public void add() {
        for(int i=0; i<100; i++) {
            lock.lock();
            System.out.println("입금:" + ++money + " | 1번 스레드");
            lock.unlock();
        }
    }
    public void sub() {
        for(int i=0; i<100; i++) {
            lock.lock();
            System.out.println("출금:" + --money + " | 2번 스레드");
            lock.unlock();
        }
    }
}

