# 스레드(THREAD) 개요
일반적으로 특정 작업을 수행하는 소프트웨어를 프로그램이라고 합니다.
프로그램이 실행되어, 메모리나 CPU와 같은 자원을 할당 받으면 이를 프로세스라 합니다.
스레드는 프로세스를 구성하는 하나의 단위입니다.
따라서 하나의 프로세스에는 여러 스레드가 작동할 수 있습니다.
스레드는 작업의 한 단위이며, 프로세스는 독자적인 메모리를 할당 받아서, 서로 다른 프로세스끼리는 일반적으로 서로의 메모리 영역을 침범하지 못합니다.

프로세스 내부에 있는 여러 스레드들은 서로 같은 프로세스 내부에 존재하기 때문에 같은 자원을 공유하여 사용할 수 있습니다.
때문에 동시에 같은 자원을 두고 여러 일을 수행할 수 있고, 이는 병렬성의 향상으로 이어집니다.

그러나 스레드가 동시에 하나의 자원을 공유하고 있기 때문에 동시성 문제, 데드락과 같은 여러 가지 문제점이 발생할 수 있습니다.



## 스레드 생성 방법
### 1. Thread를 이용한 방법
### 2. Runnable를 이용한 방법
### 3. Callable를 이용한 방법



# 1. Thread를 이용한 방법
1-1. 공유로 자원을 사용한 공유객체인 SharedOjbect class를 만듭니다.
      SharedOjbect 안에 멀티스레드가 사용할 변수와 메서드를 작성합니다.
```javascript
class SharedObject{
    int money = 0;
    public void add() {
        for(int i=0; i<100; i++){
            System.out.println("입금:" + ++money + " | 1번 스레드");
        }
    }
    public void sub() {
        for(int i=0; i<100; i++){
            System.out.println("출금:" + --money + " | 2번 스레드");
        }
    }
}
```
1-2. 생성할 멀티스레드 class를 만들며 Thread를 extends 합니다.
     멀티스레드 class 안에 공유객체인 SharedObject를 선언한 후 생성자에 주입하는 코드를 작성합니다.
     public void run() 메서드를 @Override 하여 함수를 작성합니다.
```javascript
class MulThread1 extends Thread {
    SharedObject so;

    public MulThread1(SharedObject so) {
        this.so = so;
    }

    @Override
    public void run() {
        so.add();
    }
}
```
1.3. 메인 함수에서 SharedObject 객체를 생성한 후 멀티스레드1, 2 객체를 생성하며 생성자를 주입합니다.
```javascript
class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedObject so = new SharedObject();

        MulThread1 t1 = new MulThread1(so);
        MulThread2 t2 = new MulThread2(so);
    }
}
```
1-4. .start() 메서드를 사용해 멀티스레드가 잘 돌아가는 지 확인합니다.
```javascript
class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedObject so = new SharedObject();

        MulThread1 t1 = new MulThread1(so);
        MulThread2 t2 = new MulThread2(so);

        t1.start();
        t2.start();
    }
}
```
## 결과
```javascript
출금:-15 | 2번 스레드
출금:-16 | 2번 스레드
출금:-17 | 2번 스레드
입금:0 | 1번 스레드
입금:-17 | 1번 스레드
출금:-18 | 2번 스레드
입금:-16 | 1번 스레드
입금:-16 | 1번 스레드
```
## 문제점
여러 멀티 쓰레드가 공유객체인 SharedOjbect에 동시에 접근하는 경우 동시성문제 발생.
첫 번째 동작할 때와 두 번째 동작할 때의 자원 상태가 변하기 때문에 문제가 발생합니다.
## 해결 방법
.join()을 활용해 하나의 멀티스레드가 작업을 마칠 때 까지 다른 멀티스레드는 공유 자원(메서드, 변수)에 접근하지 못하게 할 수 있습니다.
하지만 하나의 자원에만 접근하는 멀티스레드에 join을 사용한다면 결국 하나의 스레드만 작동하게 되는 것이므로 병렬성의 이점이 없습니다.




# 2. Runnable을 이용한 방법
2-1. 공유로 자원을 사용한 공유객체인 SharedOjbect class를 만듭니다. (Thread와 동일)
```javascript
class SharedObject{
    int money = 0;
    public void add() {
        for(int i=0; i<100; i++){
            System.out.print("입금:" + ++money + " | 1번 스레드");
        {
    }
    public void sub() {
        for(int i=0; i<100; i++){
            System.out.print("출금:" + --money + " | 2번 스레드");
        }
    }
}
```
2-2. 생성할 멀티스레드 class를 만들며 Runnable를 implements 합니다.
     멀티스레드 class 안에 공유객체인 SharedObject를 선언한 후 생성자에 주입하는 코드를 작성합니다.
```javascript
class MulThread1 implements Runnable {
    SharedObject so;

    public MulThread1(SharedObject so) {
        this.so = so;
    }

    @Override
    public void run() {
        so.add();
    }
}
```
2-3. 메인 함수에서 SharedObject 객체를 생성한 후 interface 객체의 생성자에 SharedObject 객체를 생성자 파라미터로 넣어준 후,
     멀티쓰레드 1, 2 생성시 interface 객체1, 2를 생성자 파라미터로 넣어줍니다.
```javascript
class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedObject so = new SharedObject();

        Runnable r1 = new MulThread1(so);
        Runnable r2 = new MulThread2(so);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
    }
}
```
2-4. .start() 메서드를 사용해 멀티스레드가 잘 돌아가는 지 확인합니다.
```javascript
class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedObject so = new SharedObject();

        Runnable r1 = new MulThread1(so);
        Runnable r2 = new MulThread2(so);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
}
```
## 결과
```javascript
입금:-3 | 1번 스레드
입금:-2 | 1번 스레드
입금:-1 | 1번 스레드
입금:0 | 1번 스레드
출금:-9 | 2번 스레드

Process finished with exit code 0
```
## 문제점
Thread와 마찬가지로 동시성 문제 발생.
## 해결 방법
암시적 Lock(Synchronized), 명시적 Lock(ReentrantLock) 사용



# Synchronized
### 스레드 동기화란?
스레드 동기화는 멀티스레드 환경에서 여러 스레드가 하나의 공유자원에 동시에 접근하지 못하도록 막는 것입니다.
공유데이터가 사용되어 동기화가 필요한 부분을 임계영역이라 부르며, 이 임계영역에 synchronized 키워드를 사용하여
여러 스레드가 동시에 접근하는 것을 금지함으로써 동기화를 할 수 있습니다.

Lock은 메서드, 변수에 각각 걸 수 있습니다.
단, 변수에 lock을 걸기 위해선 해당 변수는 객체이어야 합니다.

### synchronized (암시적 Lock)
동기화가 필요한 메소드나 코드블럭 앞에 사용합니다.
한 스레드가 synchronized 로 지정된 임계영역에 접근하면 lock이 걸림으로써 다른 스레드가 접근하지 못합니다.
이후 임계영역의 코드를 모두 실행하게 되면 unlock 상태가 되어 대기하고 있던 다른 스레드가 이 임계영역에 다시 접근하여 다시 lock을 걸며 사용합니다.

1. 메서드에 synchronized 설정
```javascript
int money = 0;
    public synchronized void add() {
        System.out.println("입금:" + ++money + " | 1번 스레드");
    }
```
2. 코드블럭에 synchronized 설정
```javascript
int money = 0;
    public void add() {
        synchronized (this){
            this.money++;
        }
        System.out.println("입금:" + money + " | 1번 스레드");
    }
```

## 결과
```javascript
출금:-1 | 2번 스레드
출금:-2 | 2번 스레드
출금:-3 | 2번 스레드
출금:-4 | 2번 스레드
출금:-5 | 2번 스레드
출금:-6 | 2번 스레드
입금:-5 | 1번 스레드
입금:-4 | 1번 스레드
입금:-3 | 1번 스레드
입금:-2 | 1번 스레드
```
동시성 문제가 해결되었다.
 
### ReentrantLock (명시적 Lock)
synchronized 키워드 없이 명시적으로 ReentratLcok을 사용하는 Lock.
해당 Lock의 범위를 메서드 내부에서 한정하기 어렵거나, 동시에 여러 Lock을 사용하고 싶을 때 사용합니다.
직접적으로 Lock 객체를 생성하여 사용하며, 
한 스레드가 lock() 메서드를 사용하면 다른 스레드는 해당 lock() 메서드 시작점에 접근하지 못하고 대기합니다.
이는 unlock()메서드를 실행하면 다른 메서드가 lock을 얻음으로써 해결할 수 있습니다.
```javascript
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedObject so = new SharedObject();

        Runnable r1 = new MulThread1(so);
        Runnable r2 = new MulThread2(so);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

    }
}

class SharedObject {
    private int money = 0;
    private Lock lock = new ReentrantLock();
    public Lock getLock(){
        return lock;
    };
    public void add() {
        lock.lock();
        System.out.println("입금:" + ++money + " | 1번 스레드");
        lock.unlock();
    }
    public void sub() {
        for(int i=0; i<100; i++){
            lock.lock();
            System.out.println("출금:" + --money + " | 2번 스레드");
            lock.unlock();
        }
    }
}

class MulThread1 implements Runnable {
    SharedObject so;
    public MulThread1(SharedObject so) {
        this.so = so;
    }

    @Override
    public void run() {
        so.add();
    }
}

class MulThread2 implements Runnable {
    SharedObject so;
    public MulThread2(SharedObject so) {
        this.so = so;
    }

    @Override
    public void run() {
        so.sub();
    }
}
```
## 결과
```javascript
출금:-1 | 2번 스레드
입금:0 | 1번 스레드
입금:1 | 1번 스레드
입금:2 | 1번 스레드
입금:3 | 1번 스레드
입금:4 | 1번 스레드
```

### writeLock & readLock
   readLock = 메모리 내 값을 가져오기 위해 사용하는 lock

1. writeLock = 메모리에 값을 변경하기 위해 사용하는 lock
```javascript
class SharedObject {
    private int money = 0;
    private Lock lock = new ReentrantLock();
    public Lock getLock(){
        return lock;
    };
    private ReentrantReadWriteLock readlock;
    
    public void add() {
        for(int i=0; i<100; i++){
            useLock.writeLock().lock();
            System.out.println("입금:" + ++money + " | 1번 스레드");
            lock.unlock();
        }
    }
    public void sub() {
        for(int i=0; i<100; i++){
            useLock.writeLock().lock();
            System.out.println("출금:" + --money + " | 2번 스레드");
            lock.unlock();
        }
    }
}
```

2. writelock을 사용할 곳에 readlock을 사용한다면?
```javascript
class SharedObject {
    private int money = 0;

    private ReentrantReadWriteLock useLock = new ReentrantReadWriteLock();

    public void add() {
        for(int i=0; i<100; i++){
            useLock.readLock().lock();
            System.out.println("입금:" + ++money + " | 1번 스레드");
            useLock.readLock().unlock();
        }
    }
    public void sub() {
        for(int i=0; i<100; i++){
            useLock.writeLock().lock();
            System.out.println("출금:" + --money + " | 2번 스레드");
            useLock.writeLock().lock();
        }
    }
}
```
### 결과
```javascript
출금:-96 | 2번 스레드
출금:-97 | 2번 스레드
출금:-98 | 2번 스레드
출금:-99 | 2번 스레드
출금:-100 | 2번 스레드
```
readLock을 설정한 add() 메서드가 실행되지 않고, writeLock을 설정한 sub() 메서드는 실행된다.
첫 add() 실행에 readLock을 걸었지만 변수를 변경하려고 접근하니 readLock에 막혀
useLock.readLock().unlock();이 실행되지 않아 add()에 계속 readLock이 걸려있는 상태이므로
add()를 run()하는 MulThread1인 t1.start()가 더 이상 진행되지 않는다.

3. 제대로 된 readLock, writeLock 사용
```javascript
class SharedObject {
    private int money = 0;
    private ReentrantReadWriteLock useLock = new ReentrantReadWriteLock();

    public void add() {
        for(int i=0; i<100; i++){
            useLock.writeLock().lock();
            try {
                ++money;
            }finally {
                useLock.writeLock().unlock();
            }
        }
    }
    public void getMoney() {
        for(int i=0; i<100; i++){
            useLock.readLock().lock();
            try{
                System.out.println("현재 잔액:" + money);
            }finally {
                useLock.readLock().unlock();
            }
        }
    }
}

class MulThread1 implements Runnable {
    SharedObject so;
    public MulThread1(SharedObject so) {
        this.so = so;
    }

    @Override
    public void run() {
        so.add();
    }
}

class MulThread2 implements Runnable {
    SharedObject so;
    public MulThread2(SharedObject so) {
        this.so = so;
    }

    @Override
    public void run() {
        so.getMoney();
    }
}
```
### 결과
```javascript
현재 잔액:0
현재 잔액:0
현재 잔액:0
현재 잔액:0
현재 잔액:0
현재 잔액:0
현재 잔액:2
현재 잔액:52
```
readLock이 걸린 MulThread2(getMoney())와 writeLock이 걸린 MulThread1(add())이 잘 작동한다.

# Singleton Parttern
## Singleton Pattern이란?
같은 생성자가 여러 번 호출되더라도 처음 생성자 호출 시 생성된 하나의 동일한 인스턴스가 반복적으로 반환되는 패턴입니다.
그러므로 멀티스레드 환경에서 공유객체인 SharedObject 대신 사용할 수 있습니다.

## java에서 가장 일반적인 싱글톤 패턴 구현 방법
```javascript
class Singleton {
    private static Singleton myInstance = null;

    private Singleton() {}

    public static Singleton getInstance() {
        if (myInstance == null) {
            myInstance = new Singleton();
        }

        return myInstance;
    }
}

```
### Runnable 방식으로 일반적인 singleton 구현하기
```javascript
public class Singleton {
    private static Singleton myInstance = null;
    private Singleton() {}
    public static Singleton getInstance(){
        if(myInstance == null) {
            myInstance = new Singleton();
        }
        return myInstance;
    }
    private int money = 0;
    public void add(){
        for(int i=0; i<100; i++) {
            synchronized (this) {
                System.out.println("입금:" + ++money + " | 1번 스레드");
            }
        }
    }
    public void sub(){
        for(int i=0; i<100; i++) {
            synchronized (this) {
                System.out.println("출금:" + --money + " | 2번 스레드");
            }
        }
    }
}

class Main {
    public static void main(String[] args){
        SingletonDCL si = SingletonDCL.getInstance();

        Runnable r1 = new MulThread1(si);
        Runnable r2 = new MulThread2(si);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}

class MulThread1 implements Runnable {
    SingletonDCL si = null;
    public MulThread1(){}
    public MulThread1(SingletonDCL si){
        this.si = si;
    }

    @Override
    public void run(){
        si.add();
    }
}

class MulThread2 implements Runnable {
    SingletonDCL si = null;
    public MulThread2(){}
    public MulThread2(SingletonDCL si){
        this.si = si;
    }

    @Override
    public void run(){
        si.sub();
    }
}
```
싱글톤 패턴은 생성자를 사용하여 이미 만들어진 인스턴스가 있는지 존재한 후
객체를 생성 혹은 반환하는 static 메소드를 활용하여 호출합니다.
```javascripnt
Singleton singleton = Singleton.getInstance();
```

## 멀티스레드 환경에서 Singleton Parttern의 문제점
하지만 위의 방법(가장 일반적인 싱글톤 패턴)은 멀티스레드 환경에서 여러 개의 스레드가 
동시에 getInstance() 메소드에 접근한다고 할 때 여러 개의 인스턴스가 만들어질 수 있기 때문에 동시성 문제가 발생할 수 있습니다.

## 해결 방법
### 1. synchronized 메소드 선언
synchronized 키워드를 사용하여 getInstance() 메소드를 동기화하면, 최초로 접근한 스레드가
해당 메서드 호출을 종료할 때 까지 다른 스레드가 접근하지 못하게 lock을 겁니다.
```javascript
class SingletonSyn {
    private static SingletonSyn myInstance = null;

    private SingletonSyn() {}

    public static synchronized SingletonSyn getInstance() {
        if (myInstance == null) {
            myInstance = new SingletonSyn();
        }

        return myInstance;
    }
}
```
여러 스레드가 동시에 접근할 때 발생하는 문제는 해결할 수 있지만
getInstatnce() 메서드를 호출할 때 마다 lock이 걸려 성능 저하가 발생하는 단점이 있습니다.

### 2. DCL(Double Checked Locking)
synchronized 메소드 선언 방식의 단점을 보완하여, 생성된 인스턴스가 존재하지 않을 때만 lock을 거는 방법입니다.

### DCL 방식으로 Singleton 구현하기
```javascript
class SingletonDCL {
    private static SingletonDCL myInstance = null;
    private SingletonDCL() {}
    public static SingletonDCL getInstance() {
        if (myInstance == null) {
            synchronized (SingletonDCL.class) {
                if (myInstance == null) {
                    myInstance = new SingletonDCL();
                }
            }
        }
        return myInstance;
    }
    private int money = 0;
    public void add(){
        for(int i=0; i<100; i++) {
            synchronized (this) {
                System.out.println("입금:" + ++money + " | 1번 스레드");
            }
        }
    }
    public void sub(){
        for(int i=0; i<100; i++) {
            synchronized (this) {
                System.out.println("출금:" + --money + " | 2번 스레드");
            }
        }
    }
}
```
### 결과
```javascript
출금:-1 | 2번 스레드
입금:0 | 2번 스레드
:
출금:1 | 2번 스레드
출금:0 | 2번 스레드

Process finished with exit code 0
```

### 3. DCL 방식에 volatile 키워드 사용
volatile 키워드를 myInstance 선언문에 붙여서 사용하면, myInstance에 값을 할당하거나 수정할 때
메인 메모리에 바로 쓰게 됩니다.
```javascript
class SingletonVolatile {
    private volatile static SingletonVolatile myInstance = null;
    private SingletonVolatile() {}
    public static SingletonVolatile getInstance() {
        if (myInstance == null) {
            synchronized (SingletonVolatile.class) {
                if (myInstance == null) {
                    myInstance = new SingletonVolatile();
                }
            }
        }
        return myInstance;
    }
    private int money = 0;
    public void add(){
        for(int i=0; i<100; i++) {
            synchronized (this) {
                System.out.println("입금:" + ++money + " | 1번 스레드");
            }
        }
    }
    public void sub(){
        for(int i=0; i<100; i++) {
            synchronized (this) {
                System.out.println("출금:" + --money + " | 2번 스레드");
            }
        }
    }
}
```
 MyInstance의 값을 읽어 들이는 경우에도 CPU 캐시를 거치지 않고 메인 메모리로부터 읽어 들이게 강제하므로
visibility 문제를 해결 할 수 있습니다.

### 4. LazyHolder 방식
위 세가지 방법은 런타임 시 필요한 인스턴스를 생성해서 할당하는 방식입니다.
LazyHolder 방식은 최초 JVM이 Class Loader를 이용해서 class path 내에 있는 모든 class들을
로드할 때 미리 인스턴스를 생성해주는 방식입니다.
```javascript
class SingletonLazyHolder {
    private SingletonLazyHolder() {}

    public static SingletonLazyHolder getInstance() {
        return LazyHolder.INSTANCE;
    }
    private static class LazyHolder {
        private static final SingletonLazyHolder INSTANCE = new SingletonLazyHolder();
    }
    private int money = 0;

    public void add(){
        for(int i=0; i<100; i++) {
            synchronized (this) {
                System.out.println("입금:" + ++money + " | 1번 스레드");
            }
        }
    }
    public void sub(){
        for(int i=0; i<100; i++) {
            synchronized (this) {
                System.out.println("출금:" + --money + " | 2번 스레드");
            }
        }
    }
}
```
LazeHolder라는 Inner Class를 선언해 사용함으로써

Singleton 클래스가 최초 로딩 단계에서 로드가 되더라도, LazyHolder 클래스에 대한 변수를
가지고 있지 않아 함께 초기화되지 않는 점을 이용한 방법입니다.

따라서 getInstance()가 호출될 때 LazyHolder 클래스가 로딩되며 인스턴스를 생성합니다.

또한 class를 로드하고 초기화하는 단계에서는 thread safety가 보장되기 때문에 별도의
synchronized, volatile 키워드 없이 동시성 문제를 해결할 수 있습니다.


# Callable / Future
### main
```javascript
class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        int i = 0;
        while (i < 1000) {
            System.out.print("두 수를 입력하세요:");
            Scanner sc = new Scanner(System.in);
            Integer a = sc.nextInt();
            Integer b = sc.nextInt();

            Callable1 c1 = new Callable1(a, b);
            Future<Integer> future = new Future1(c1);
            i += future.get();
            System.out.println("Only maked by Future : " + i);
            System.out.println("Future Add Result [("+a+"+"+b+")배로 증가]:" + i);
            System.out.println();
        }

    }
}
```
### Callable
```javascript
class Callable1 implements Callable<Integer> {
    int a;
    int b;
    public Callable1(int a, int b){
        this.a = a;
        this.b = b;
    }
    @Override
    public Integer call() throws Exception {
        new Thread().sleep(1500L);
        Integer result = a + b;
        return result;
    }
}
```
### Future
```javascript
public class Future1 implements Future<Integer> {
    int a;
    int b;
    Callable1 c1;
    public Future1(){}
    public Future1(Callable1 c1){
        this.c1 = c1;
    }
    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public Integer get() throws InterruptedException, ExecutionException {
        try {
            return c1.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}
```

# Callable / Runnable
### main
```javascript
int i = 0;
while(true) {
    i += f1.get();
    System.out.println("Callable Add Result [("+a+"+"+b+")배로 증가]:" + i);
    new Thread(new Runnable1()).start();
}
```
### Runnable
```javascript
public class Runnable1 implements Runnable{
    public Runnable1(){}
    @Override
    public void run() {
        System.out.println("Runnable Success");
        try {
            new Thread().sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
```
# FixedThreadPool
### main
```javascript
class Main {
    public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 9; i++) {
            Runnable r1=new MulRunnable();
            executor.submit(r1);
        }
        executor.shutdown();
    }
}
```
### LazyHolderSingleton
```javascript
class SingletonLazyHolder {
    private SingletonLazyHolder() {}

    public static SingletonLazyHolder getInstance() {
        return SingletonLazyHolder.LazyHolder.INSTANCE;
    }
    private static class LazyHolder {
        private static final SingletonLazyHolder INSTANCE = new SingletonLazyHolder();
    }
    private int money = 0;
    public synchronized void add(){
        System.out.println(" 입금:" + ++money);
    }
}
```
### Runnable
```javascript
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
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
```
### 결과
```javascript
pool-1-thread-1가 시작되었습니다
pool-1-thread-2가 시작되었습니다
pool-1-thread-3가 시작되었습니다
 입금:1
pool-1-thread-1가 종료되었습니다
 입금:2
pool-1-thread-3가 종료되었습니다
 입금:3
pool-1-thread-2가 종료되었습니다
pool-1-thread-2가 시작되었습니다
pool-1-thread-3가 시작되었습니다
pool-1-thread-1가 시작되었습니다
 입금:4
pool-1-thread-2가 종료되었습니다
 입금:5
pool-1-thread-1가 종료되었습니다
 입금:6
pool-1-thread-3가 종료되었습니다
pool-1-thread-3가 시작되었습니다
pool-1-thread-1가 시작되었습니다
pool-1-thread-2가 시작되었습니다
 입금:7
pool-1-thread-3가 종료되었습니다
 입금:8
pool-1-thread-2가 종료되었습니다
 입금:9
pool-1-thread-1가 종료되었습니다

Process finished with exit code 0
```
main.class의 ExecutorService executor = Executors.newFixedThreadPool(3);
에 설정한 스레드 3개씩 실행됨을 확인할 수 있다.


# Producer & Consumer Pattern (BlockingQueue)
### Producer
```javascript
class Producer implements Runnable {
    private BlockingQueue queue;
    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000L);

            Date d = new Date();
            String msg = "생성 시간 : "+d.toString();
            queue.put(msg);

            System.out.println("생산자가 작업(메시지)을 생성합니다 | Queue Size:[" + queue.size() + "]");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000L);

            Date d = new Date();
            String msg = "생성 시간:"+d.toString();
            queue.put(msg);

            System.out.println("생산자가 작업(메시지)을 생성합니다 | Queue Size:[" + queue.size() + "]");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

### Consumer
```javascript
class Consumer implements Runnable {
    private BlockingQueue queue;
    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1001L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String msg = null;
        try {
            msg = (String) queue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("소비자가 작업(메시지)을 처리합니다 | " + msg + " Queue Size:[" + queue.size() + "]");
    }
}
```

### Main (BlockingQueue)
```javascript
class Main {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(50);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Producer p = new Producer(queue);
        Consumer c = new Consumer(queue);

        int i = 0;
        while(i < 1000) {
            executor.submit(p);
            executor.submit(c);
            i++;
        }
        executor.shutdown();
    }
}
```
