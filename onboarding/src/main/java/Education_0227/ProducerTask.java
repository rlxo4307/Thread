package Education_0227;

class ProducerTask implements Runnable {
    private int a;
    private int b;
    ProducerTask(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000L);
            ConsumerTask task = new ConsumerTask(this.a, this.b);
            System.out.println("생산자가 작업을 생성합니다 > " + Thread.currentThread().getName());
            SharedResource.getInstance().put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}