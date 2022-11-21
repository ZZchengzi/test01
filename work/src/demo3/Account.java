package demo3;

abstract class Account {
    private String name;
    private String aid;
    private int money;
    public void deposit(int money){
        this.money += money;
    }

    public boolean withdraw(int money)
    {
        if(money > this.money)
        {
            return false;
        }
        else
        {
            this.money -= money;
            return true;
        }
    }

    public int getBalance()
    {
        return money;
    }


    public Account(String name, String aid, int money) {
        this.name = name;
        this.aid = aid;
        this.money = money;
    }

    public Account() {
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }
}
