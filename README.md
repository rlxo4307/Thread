# 스레드(THREAD) 개요
### 일반적으로 특정 작업을 수행하는 소프트웨어를 프로그램이라고 합니다.
### 프로그램이 실행되어, 메모리나 CPU와 같은 자원을 할당 받으면 이를 프로세스라 합니다.
### 스레드는 프로세스를 구성하는 하나의 단위입니다. 따라서 하나의 프로세스에는 여러 스레드가 작동할 수 있습니다.
### 스레드는 작업의 한 단위이며, 프로세스는 독자적인 메모리를 할당 받아서 서로 다른 프로세스끼리는 일반적으로 서로의 메모리 영역을 침범하지 못합니다.
### 하지만 프로세스 내부에 있는 여러 스레드들은 서로 같은 프로세스 내부에 존재하기 때문에 같은 자원을 공유하여 사용할 수 있습니다.
### 같은 자원을 공유할 수 있기 때문에 동시에 같은 자원을 두고 여러 일을 수행할 수 있고, 이는 곧 병렬성의 향상으로 이어집니다.
### 하지만 스레드를 사용에는 단점도 있습니다. 여러 스레드가 동시에 하나의 자원을 공유하고 있기 때문에 이 자원을 두고 여러 가지 문제점이 발생할 수 있습니다.
### 발생하는 문제로는 동시성 문제, 데드락과 같은 여러 가지 문제점이 있습니다. 
### 이러한 문제를 해결하여 문제없는 멀티스레드 프로그램을 제작하는 것이 최종 목표입니다.


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
        System.out.print("입금:" + ++money);
    }
    public void minus() {
        System.out.print("출금:" + --money);
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
            System.out.println(" | 1번 스레드");
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
![804-20232-22-105-53.png](/files/194)![804-20232-22-105-53.png](/files/194)
## 문제점
여러 멀티 쓰레드가 공유객체인 SharedOjbect에 동시에 접근하는 경우 동시성문제 발생.
첫 번째 동작할 때와 두 번째 동작할 때의 자원 상태가 변하기 때문에 문제가 발생합니다.
## 해결 방법
.join()을 활용해 하나의 멀티스레드가 작업을 마칠 때 까지 다른 멀티스레드는 공유 자원(메서드, 변수)에 접근하지 못하게 할 수 있습니다.
하지만 하나의 자원에만 접근하는 멀티스레드에 join을 사용한다면 결국 하나의 스레드만 작동하게 되는 것이므로 병렬성의 이점이 없습니다.
![291-20232-22-109-54.png](/files/![291-20232-22-109-54.png](/files/195) 195)


# 2. Runnable을 이용한 방법
2-1. 공유로 자원을 사용한 공유객체인 SharedOjbect class를 만듭니다. (Thread와 동일)
```javascript
class SharedObject{
    int money = 0;
    public void add() {
        System.out.print("입금:" + ++money);
    }
    public void minus() {
        System.out.print("출금:" + --money);
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
            System.out.println(" | 1번 스레드");
        }
    }
}
```
2-3. 메인 함수에서 SharedObject 객체를 생성한 후 interface 객체의 생성자에 SharedObject 객체를 생성자 파라미터로 넣어준 후,
     멀티쓰레드 1, 2 생성시 interface 객체1, 2를 생성자 파라미터로 넣어준다.
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
![109-20232-22-1021-12.png](/files/196)![109-20232-22-1021-12.png](/files/196)  
## 문제점
Thread와 마찬가지로 동시성 문제 발생.
## 해결 방법
Synchronized 사용
