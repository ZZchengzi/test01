package demo3;

public class CreditAccount extends Account {
    private creditLevel credit;

    //展示信用情况
    public void showCredit(){
        System.out.println("当前信用等级为：" + credit.getLevel());
        System.out.println("可透支余额：" + credit.getLineOfCredit());
    }

    //重写信用卡用户的取钱方式，当钱不够时透支信用余额
    @Override
    public boolean withdraw(int money) {
        if(super.withdraw(money))
        {
            if(this.getMoney() + credit.getLineOfCredit() - credit.getOverdraw() >= money)
            {
                credit.setOverdraw(money);
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return true;
        }
    }

    public void findOverdraw(){
        System.out.println("已透支余额：" + credit.getOverdraw());
    }



    public CreditAccount(String name, String aid, int money, creditLevel credit) {
        super(name, aid, money);
        this.credit = credit;
    }

    public CreditAccount() {
    }

    public creditLevel getCredit() {
        return credit;
    }

    public void setCredit(creditLevel credit) {
        this.credit = credit;
    }
}
