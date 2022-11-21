package demo3;

public class CashAccount extends Account {
    private String kind;

    public void changeKind(String kind){
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public CashAccount(String name, String aid, int money, String kind) {
        super(name, aid, money);
        this.kind = kind;
    }
    public CashAccount()
    {
        super();
    }

}
