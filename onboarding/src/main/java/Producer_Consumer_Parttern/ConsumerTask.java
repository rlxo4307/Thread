package Producer_Consumer_Parttern;
class ConsumerTask implements Runnable{
    private final int x;
    private final int y;
    private final int z;
    private String state;
    public ConsumerTask(int x, int y, int z, String state) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.state = state;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1100L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int result = 0;
        switch(z) {
            case 1: result = this.x + this.y;
                break;
            case 2: result = this.x - this.y;
                break;
            case 3: result = this.x * this.y;
                break;
            case 4: result = (Integer)(this.x / this.y);
                break;
            default:
                state = "fail";
        }
        if(state.equals("success")){
            System.out.println("소비자가 작업을 처리합니다 > 결과:" + Thread.currentThread().getName() + " : " + result);
        }else{
            System.out.println("소비자가 작업을 처리합니다 > 사칙연산을 잘못 선택했습니다 | " + Thread.currentThread().getName());
        }
    }
}
