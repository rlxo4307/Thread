package Producer_Consumer_Parttern;
class ConsumerTask implements Runnable{
    private final int x;
    private final int y;
    public ConsumerTask(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public void run(){
        try {
            Thread.sleep(1020L);
            int result = x + y;
            System.out.println("소비자가 작업(덧셈)을 처리합니다 | 결과:"+result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
