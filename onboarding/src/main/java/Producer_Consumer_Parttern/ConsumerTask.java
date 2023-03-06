package Producer_Consumer_Parttern;
class ConsumerTask implements Runnable{
    private final int x;
    private final int y;
    private final int sign;
    private String state;
    public ConsumerTask(int x, int y, int sign, String state) {
        this.x = x;
        this.y = y;
        this.sign = sign;
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

        if(sign == 1) result = this.x + this.y;
        if(sign == 2) result = this.x - this.y;
        if(sign == 3) result = this.x * this.y;
        if(sign == 4 && this.y != 0) result = (Integer) (this.x / this.y);
        if(sign == 4 && this.y == 0) {
            state = "zero divide";
            System.out.println("소비자가 작업을 처리합니다 > 나눗셈 분모가 0입니다 | " + Thread.currentThread().getName());
        }
        if(sign < 1 && sign > 4) {
            state = "fail";
            System.out.println("소비자가 작업을 처리합니다 > 연산을 잘못 선택했습니다 | " + Thread.currentThread().getName());
        }
        if(state.equals("success"))
            System.out.println("소비자가 작업을 처리합니다 > 결과:" + Thread.currentThread().getName() + " : " + result);
    }
}