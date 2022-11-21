package demo3;

public class JLab0503 {
    public static void main(String[] args) {
        CreditAccount credit = new CreditAccount();
        CashAccount debit = new CashAccount();
        //存500
        credit.deposit(500);
        debit.deposit(500);
        //取200
        if(credit.withdraw(200)){
            System.out.println("credit成功取200");
        }
        else System.out.println("credit取200失败余额为: "+ credit.getBalance());
        if(debit.withdraw(200))
        {
            System.out.println("debit成功取200,余额还有："+debit.getBalance());
        }
        else System.out.println("debit取200失败余额为: "+ debit.getBalance());
        //继续取400
        if(credit.withdraw(400)){
            System.out.println("credit成功取400,余额还有："+credit.getBalance());
        }
        else System.out.println("credit取400失败余额为: "+ credit.getBalance());
        if(debit.withdraw(400))
        {
            System.out.println("debit成功取400,余额还有："+debit.getBalance());
        }
        else System.out.println("debit取400失败余额为: "+ debit.getBalance());

    }

}
