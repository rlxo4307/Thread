package Producer_Consumer_Parttern;
class ProducerTask implements Runnable{
    int x, y;
    ProducerTask(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public void run(){
        try {
            Thread.sleep(1000L);
            System.out.println("생성자가 작업(덧셈)을 생성합니다 | "+Thread.currentThread().getName());
            SharedResource.getInstance().put(new ConsumerTask(this.x, this.y));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}