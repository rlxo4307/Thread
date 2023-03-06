package 객체지향생활체조원칙;
class 모든원시값과문자열을포장한다_sol {
    private Annual_Income annualIncome;
    public void changeMoney(int money){
        this.annualIncome = annualIncome.changeMoney(money);
    }
}

class Annual_Income {
    private int money;
    public Annual_Income(final int money) {
        validatePositiveBettingMoney(money);
        this.money = money;
    }
    public Annual_Income changeMoney(final int money){
        return new Annual_Income(money + money);
    }
    private void validatePositiveBettingMoney(int bettingMoney) {
        if (bettingMoney <= 0) {
            throw new IllegalArgumentException();
        }
    }
}