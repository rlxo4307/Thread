package Producer_Consumer_Parttern;
class ConsumerTask implements Runnable{
    private final int x;
    private final int y;
    private final int sign;
    public ConsumerTask(int x, int y, int sign) {
        this.x = x;
        this.y = y;
        this.sign = sign;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1100L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int result = 0;
        String ment = "소비자가 작업을 처리합니다 | ";
        String thread = Thread.currentThread().getName();

        if(sign == 1) result = this.x + this.y;
        if(sign == 2) result = this.x - this.y;
        if(sign == 3) result = this.x * this.y;
        if(sign == 4 && this.y != 0) result = (Integer) (this.x / this.y);
        if(sign == 4 && this.y == 0) {
            System.out.println(ment + "나눗셈 분모가 0입니다 | " + thread);
            return;
        }
        if(sign == 1 || sign == 2 || sign == 3 || sign == 4) {
            System.out.println(ment + "결과:" + result +" | " + thread);
            return;
        }
        if(sign != 1 && sign != 2 && sign != 3 && sign != 4) {
            System.out.println(ment + "연산을 잘못 선택했습니다 | " + thread);
        }
    }
}
