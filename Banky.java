import java.util.Scanner;

class BankDetails {
    private String accno;
    private String name;
    private String acc_type;
    private int balance;
    Scanner sc = new Scanner(System.in);

    public void openAccount() {
        System.out.print("Enter Account No: ");
        accno = sc.next();
        System.out.print("Enter Account type: ");
        acc_type = sc.next();
        System.out.print("Enter Name: ");
        name = sc.next();
        System.out.print("Enter Balance: ");
        balance = sc.nextInt();
    }

    public void showAccount() {
        System.out.println("Name of account holder: " + name);
        System.out.println("Account no.: " + accno);
        System.out.println("Account type: " + acc_type);
        System.out.println("Balance: " + balance);
    }

    // Tranfer Money
    public void transfer() {

    }

    public void deposit() {
        int amt;
        System.out.println("Enter the amount you want to deposit: ");
        amt = sc.nextInt();
        balance = balance + amt;
    }

    public void withdrawal() {
        int amt;
        System.out.println("Enter the amount you want to withdraw: ");
        amt = sc.nextInt();
        if (balance >= amt) {
            balance = balance - amt;
            System.out.println("Balance after withdrawal: " + balance);
        } else {
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!");
        }
    }

    public boolean search(String ac_no) {
        if (accno.equals(ac_no)) {
            showAccount();
            return (true);
        }
        return (false);
    }
}

public class Banky {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        // create initial accounts
        System.out.print("How many number of customers to create an account: ");
        int n = sc.nextInt();
        BankDetails C[] = new BankDetails[n];
        for (int i = 0; i < C.length; i++) {
            System.out.print("Enter Details of " + (i + 1) + " no. account\n");
            C[i] = new BankDetails();
            C[i].openAccount();
        }
        // loop runs until number 5 is not pressed to exit
        int ch;
        do {
            System.out.println("Banking System");
            System.out.println(
                    "1. Display all account details \n2.Search by Account Number\n3. Deposit the Amount \n4. Withdraw the Amount \n5.Exit ");
            System.out.println("Enter your choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    for (int i = 0; i < C.length; i++) {
                        C[i].showAccount();
                    }
                    break;
                case 2:
                    System.out.println("Searching.....");
                    System.out.print("Enter account no: ");
                    String ac_no = sc.next();
                    boolean found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account no. : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            C[i].deposit();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account No : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            C[i].withdrawal();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed!!\nAccount doesn't exist..!!");
                    }
                    break;
                case 5:
                    System.out.println("EXIT...!!!!!");
                    break;

            }
        } while (ch != 5);
    }
}