package 객체지향생활체조원칙;
class 모든원시값과문자열을포장한다_sol {
    private Annual_Income annualIncome;
    public void changeMoney(int money){
        this.annualIncome = annualIncome.changeMoney(money);
    }
}

class Annual_Income {
    private int earnMoney;
    public Annual_Income(final int earnMoney) {
        validatePositiveEarnMoney(earnMoney);
        this.earnMoney = earnMoney;
    }
    public Annual_Income changeMoney(final int money){
        return new Annual_Income(earnMoney + money);
    }
    private void validatePositiveEarnMoney(int earnMoney) {
        if (earnMoney <= 0) {
            throw new IllegalArgumentException();
        }
    }
}