### Thread
프로그램을 효율적으로 실행시키기 위해 일반적으로 Thread를 사용하여 병렬 프로그램으로 실행시킨다.
Thread를 구현하는 방법은 리턴 객체가 없이 Runnable를 인터페이스를 상속받아 클래스를 구성하는 방법과
리턴 객체가 있는 Callable 인터페이스를 상속받아 클래스를 구현하는 방법이 있다.
두 방식의 공통점은 run함수를 @Override 하여 구현해 Thread에서 실행시켜 사용한다는 것이다.

### Runnable
return 객체가 없어 void를 반환
```javascript
@Override
    public void run() {
        System.out.Println(“실행할 구문”);
    }
```

### Callable
return 객체가 있어 형식에 맞는 자료형을 작성
```javascript
@Override
    public Integer call() throws Exception {
            System.out.println("더할 두 수를 입력하세요");
            a = sc.nextInt();
            b = sc.nextInt();
            Integer result = a + b;
            new Thread().sleep(1500L);
        return result;
    }
```

하나의 프로그램을 여러 Thread로 구현한다는 것은 결국 하나의 자원을 공유해야 하므로
Shared Object 혹은 Singleton을 만들어서 구현한다.
공유객체(Shared Object)의 경우 Synchronized 키워드를 이용해 동시성 문제를 해결하거나
ReentrantReadWriteLock 객체를 사용해 구문에 Lock을 거는 방법이 있다.

### synchronized (method)
```javascript
public synchronized void add() {
     System.out.println("입금:" + ++money + " | 1번 스레드");
 }
```

### synchronized (code block)
```javascript
public void add() {
     synchronized (this){
         this.money++;
     }
     System.out.println("입금:" + money + " | 1번 스레드");
 }
```

메모리에서 값을 가져와 변경하는 경우 WriteLock을 사용하고 단지 값을 읽어 들일 경우 ReadLock을 사용한다.
### Writelock / Readlock / unlock
```javascript
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
```

Singleton을 사용해 자원을 공유할 경우, DCL 방식을 사용할 수 있지만,
동시접근 문제로 인해 LazyHolder 방식을 사용한다.
이 경우, 동기화 문제와 Safe-Tread 구현이 되어 있어 Synchronized 키워드를 사용 안 해도 된다.

여러 Thread를 활용하여 프로그램을 실행시킬 때, 매번 새로운 Thread를 만들고 삭제한다면
많은 자원을 소비하게 될 것이며 이는 성능저하로 이어질 것이다.

따라서 ThreadPool을 사용해 일정한 크기의 쓰레드 개수를 생성한 다음 필요에 따라 사용과 재사용을 한다.
재사용을 통해 Thread 생산, 삭제를 생략할 수 있으므로 성능저하의 문제를 해결할 수 있다.
### ThreadPool
```javascript
ExecutorService executor = Executors.newFixedThreadPool(3);
```

### Producer & Consumer pattern (BlockingQueue)
ThreadPool과 BlockingQueue를 이용해 생산자–소비자 패턴의 프로그램을 구현할 수 있다.

BlockingQueue라는 작업 저장 장소를 Lazyholder 방식으로 구현해 공유 객체로 만들고 put, take등의 메서드를 공유 메서드로 구현한다.
그리고 Producer 클래스에서 반복문을 이용해 ProducerTask를 submit한 후,
ProducerTask에서 ConsumerTask를 BlockingQueue에 put하여 작업을 생성한다.

Consumer에서는 BlockingQueue의 take함수를 실행해 Producer에서 생성한 작업을 실행한다.
그러면 ConsumerTake에 작성한 작업 실행 구문이 실행된다.
이렇게 작업의 생성과 실행을 분리하여 프로그램 구현을 한 패턴을 생성자-소비자 패턴이라고 한다.

### visualVM
intellij와 연동하여 프로그램 시작 시,
Heap 영역의 메모리 사용 현황과 Live Thread, Daemon thread 사용 현황을 확인할 수 있다.


### JVM memory structure
Java memory 구조 중 Runtime Data Area는 5개의 영역으로 나뉜다.

1. Method 영역
   모든 Thread가 공유하는 영역이며, class, interface, meothd, field, statc 변수 등을 보관한다.
   그리고 Heap 영역에 생성할 class 객체가 참조할 원본 class가 저장된다.

2. Heap 영역
   모든 Thread가 공유하는 영역이며 객체, 배열이 생성되고,
   Method 영역에 선언된 class만 생성이 가능하다.
   또한 Garbage Collector가 참조되지 않은 메모리를 제거한다.

3. Stack 영역
   메서드 호출 시마다 스택 프레임이 호출되어 메서드가 종료되면 스텍 프레임이 마지막에 호출된 메서드 기준으로 삭제된다.

4. PC 레지스터
   Thread가 생성될 때 생성되는 공간이며 Thread 마다 하나씩 존재한다.
   Thread가 어떤 부분을 무슨 명령으로 실행해야 할 지에 대한 기록을 하는 부분으로 현재 수행중인 JVM 명령의 주소를 갖는다.

5. Native method stack
   자바 외 언어로 작성된 네이티브 코드를 위한 메모리 영역
