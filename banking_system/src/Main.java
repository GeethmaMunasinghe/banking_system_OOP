import java.util.Scanner;

public class Main {
    static BankAcc[] accDB=new BankAcc[100];
    static int index;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        boolean isRun=true;

        System.out.println("----------Main Menu---------");
        System.out.println();
        System.out.println("01. to open bank account");
        System.out.println("02. to deposit money");
        System.out.println("03. to withdraw money");
        System.out.println("04. to display account details");
        System.out.println();
        System.out.println("Enter choice (if exit enter 0): ");

        int choice= scanner.nextInt();

        do{
            switch (choice){
                case 0:
                    isRun=false;
                    break;
                case 1:
                    System.out.println("Open new account");
                    System.out.println();
                    System.out.println("Enter account number: ");
                    int accNum=scanner.nextInt();
                    System.out.println("Enter amount: ");
                    double amount = scanner.nextDouble();
                    System.out.println("Enter account type: ");
                    String accType=scanner.next();

                    toOpenAccount(accNum,amount,accType);
                    break;
                case 2:
                    System.out.println("Deposit money");
                    System.out.println();
                    System.out.println("Enter account number: ");
                    int accNumber= scanner.nextInt();
                    System.out.println("Enter the amount: ");
                    double depositAmount=scanner.nextDouble();

                    toDepositAccount(accNumber,depositAmount);

                    break;
                case 3:
                    System.out.println("Withdraw money");
                    System.out.println();
                    System.out.println("Enter account number: ");
                    int accountNum=scanner.nextInt();
                    System.out.println("Enter withdraw amount: ");
                    double withdrawAmount=scanner.nextDouble();

                    toWithdraw(accountNum,withdrawAmount);
                    break;
                case 4:
                    System.out.println("Display account details");
                    System.out.println();
                    System.out.println("Enter account number: ");
                    int accnum=scanner.nextInt();

                    toDisplay(accnum);

                    break;
            }
        }while (isRun);



    }

    private static void toDisplay(int accnum) {
        for (BankAcc acc:accDB){
            if (acc.accNo==accnum){
                System.out.println("Account number: "+acc.accNo);
                System.out.println("Amount: "+acc.amount);
                System.out.println("Account Type: "+acc.type);
                System.out.println();
            }
        }

    }

    private static void toWithdraw(int accountNum,double withdrawAmount) {
        for (BankAcc acc:accDB){
            if(acc.accNo==accountNum && acc.amount>withdrawAmount){
                acc.amount-=withdrawAmount;
                System.out.println("Withdraw access...");
                System.out.println();
            }
        }
    }

    private static void toDepositAccount(int accountNumber,double depositAmount) {
        for (BankAcc acc: accDB){
            if (acc.accNo==accountNumber){
                acc.amount+=depositAmount;
                System.out.println("Deposit success...");
                System.out.println();
                break;
            }
        }
        
    }

    private static void toOpenAccount(int accNum,double amount,String accType) {
        if (index>99){
            System.out.println("Fail to create account...");
        }else {
            BankAcc account=new BankAcc(accNum,amount,accType);
            accDB[index] =account;
            index++;
            System.out.println("Account created success....");
        }

    }
}