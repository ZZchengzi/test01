package demo3;

public class creditLevel {
    private String level;
    private int lineOfCredit;
    private int overdraw = 0;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getLineOfCredit() {
        return lineOfCredit;
    }

    public void setLineOfCredit(int lineOfCredit) {
        this.lineOfCredit = lineOfCredit;
    }

    public int getOverdraw() {
        return overdraw;
    }

    public void setOverdraw(int overdraw) {
        this.overdraw = overdraw;
    }

    public creditLevel() {
    }

    public creditLevel(String level) {
        this.level = level;
        switch (level){
            case "A":
                this.lineOfCredit = 10000;
                break;
            case "B":
                this.lineOfCredit = 5000;
                break;
            case "C":
                this.lineOfCredit = 2000;
                break;
            default:this.lineOfCredit = 1000;
        }
    }
}
