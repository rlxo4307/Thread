package Producer_Consumer_Parttern;
class ProducerTask implements Runnable{
    private int x, y, z;
    private String state;
    ProducerTask(int x, int y, int z, String state){
        this.x = x;
        this.y = y;
        this.z = z;
        this.state = state;
    }
    @Override
    public void run(){
        try {
            Thread.sleep(1000L);
            System.out.println("생성자가 작업((사칙연산)을 생성합니다 | "+Thread.currentThread().getName());
            SharedResource.getInstance().put(new ConsumerTask(this.x, this.y, this.z, this.state));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}