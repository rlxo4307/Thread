# 스레드(THREAD) 개요
일반적으로 특정 작업을 수행하는 소프트웨어를 프로그램이라고 합니다.
프로그램이 실행되어, 메모리나 CPU와 같은 자원을 할당 받으면 이를 프로세스라 합니다.
스레드는 프로세스를 구성하는 하나의 단위입니다. 따라서 하나의 프로세스에는 여러 스레드가 작동할 수 있습니다.
스레드는 작업의 한 단위이며, 프로세스는 독자적인 메모리를 할당 받아서 서로 다른 프로세스끼리는 일반적으로 서로의 메모리 영역을 침범하지 못합니다.
하지만 프로세스 내부에 있는 여러 스레드들은 서로 같은 프로세스 내부에 존재하기 때문에 같은 자원을 공유하여 사용할 수 있습니다.
같은 자원을 공유할 수 있기 때문에 동시에 같은 자원을 두고 여러 일을 수행할 수 있고, 이는 곧 병렬성의 향상으로 이어집니다.
하지만 스레드를 사용에는 단점도 있습니다. 여러 스레드가 동시에 하나의 자원을 공유하고 있기 때문에 이 자원을 두고 여러 가지 문제점이 발생할 수 있습니다.
발생하는 문제로는 동시성 문제, 데드락과 같은 여러 가지 문제점이 있습니다. 
이러한 문제를 해결하여 문제없는 멀티스레드 프로그램을 제작하는 것이 최종 목표입니다.



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
        System.out.println("입금:" + ++money + " | 1번 스레드");
    }
    public void minus() {
        System.out.println("출금:" + --money + " | 2번 스레드");
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
        for(int i=0; i<100; i++) {
            so.add();
        }
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
![ThreadResult.PNG](/files/187) 
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
        System.out.print("입금:" + ++money + " | 1번 스레드");
    }
    public void minus() {
        System.out.print("출금:" + --money + " | 2번 스레드");
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
        for(int i=0; i<100; i++) {
            so.add();
        }
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
![RunnableResult.PNG](/files/188) 
## 문제점
Thread와 마찬가지로 동시성 문제 발생.
## 해결 방법
Synchronized 사용



# Synchronized
### 스레드 동기화란?
스레드 동기화는 멀티스레드 환경에서 여러 스레드가 하나의 공유자원에 동시에 접근하지 못하도록 막는 것입니다.
공유데이터가 사용되어 동기화가 필요한 부분을 임계영역이라 부르며, 이 임계영역에 synchronized 키워드를 사용하여
여러 스레드가 동시에 접근하는 것을 금지함으로써 동기화를 할 수 있습니다.

### synchronized 사용방법
동기화가 필요한 메소드나 코드블럭 앞에 사용합니다.
한 스레드가 synchronized 로 지정된 임계영역에 접근하면 lock이 걸림으로써 다른 스레드가 접근하지 못합니다.
이후 임계영역의 코드를 모두 실행하게 되면 unlock 상태가 되어 대기하고 있던 다른 스레드가 이 임계영역에 다시 접근하여 다시 lock을 걸며 사용합니다.

1. 메서드에 synchronized 설정
![SynchronizedMethod.PNG](/files/202) 
2. 코드블럭에 synchronized 설정
![SynchronizedCodeBlock.PNG](/files/201) 

## 결과
![SynchronizedRunnableResult.PNG](/files/192) 
동시성 문제가 해결되었다.
 


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
class Singleton {
    private static Singleton myInstance = null;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (myInstance == null) {
            myInstance = new Singleton();
        }

        return myInstance;
    }
}
```
여러 스레드가 동시에 접근할 때 발생하는 문제는 해결할 수 있지만
getInstatnce() 메서드를 호출할 때 마다 lock이 걸려 성능 저하가 발생하는 단점이 있습니다.

### 2. DCL(Double Checked Locking)
synchronized 메소드 선언 방식의 단점을 보완하여, 생성된 인스턴스가 존재하지 않을 때만 lock을 거는 방법입니다.
```javascript
class Singleton {
    private static Singleton myInstance = null;

    private Singleton() {}

    public static Singleton getInstance() {
        if (myInstance == null) {
            synchronized (Singleton.class) {
                if (myInstance == null) {
                    myInstance = new Singleton();
                }
            }
        }

        return myInstance;
    }
}
```
 
### 3. DCL 방식에 volatile 키워드 사용
volatile 키워드를 myInstance 선언문에 붙여서 사용하면, myInstance에 값을 할당하거나 수정할 때
메인 메모리에 바로 쓰게 됩니다.
```javascript
class SingletonVolatile {
    private volatile static SingletonVolatile myInstance = null;
    private SingletonVolatile() {}
    private int money = 0;
    synchronized void add(){
        System.out.println("입금:"+ ++money + " | 1번 스레드");
    }
    synchronized void minus(){
        System.out.println("출금:"+ --money + " | 2번 스레드");
    }
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
    private int money = 0;
    public static SingletonLazyHolder getInstance() {
        return LazyHolder.INSTANCE;
    }
    private static class LazyHolder {
        private static final SingletonLazyHolder INSTANCE = new SingletonLazyHolder();
    }
    public synchronized void add(){
        System.out.println("입금:" + ++money + " | 1번 스레드");
    }
    public synchronized void minus(){
        System.out.println("출금:" + --money + " | 2번 스레드");
    }
}
```
LazeHolder라는 Inner Class를 선언해 사용함으로써

Singleton 클래스가 최초 로딩 단계에서 로드가 되더라도, LazyHolder 클래스에 대한 변수를
가지고 있지 않아 함께 초기화되지 않는 점을 이용한 방법입니다.

따라서 getInstance()가 호출될 때 LazyHolder 클래스가 로딩되며 인스턴스를 생성합니다.

또한 class를 로드하고 초기화하는 단계에서는 thread safety가 보장되기 때문에 별도의
synchronized, volatile 키워드 없이 동시성 문제를 해결할 수 있습니다.
