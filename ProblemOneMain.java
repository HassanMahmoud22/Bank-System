/***
 
 Name: Hassan Mahmoud Hassan 	id: 20180088
 Name: Bishoy Mokhless khela  	id: 20180072
 Name: Mostafa Adel          	id: 20180279
 
 ***/

package bankSystem;

import java.util.Scanner;


public class ProblemOneMain {
    public static void main(String[] args)      //main class
    {
        Account ac1 = new Account();  //object to test the normal account
        Account ac2 = new SpecialAccount();			//object to test the special account
        Scanner input = new Scanner(System.in);
        long num;
        String text;
        Account temp = new Account();
        Account temp2 = new SpecialAccount();
        System.out.println("You are using a normal account");
        System.out.println("Enter your account number: ");
        text = input.nextLine();           //taking the account number from user
        num = temp.stringChecker(text);
        ac1.setAccountNumber(num);		//passing user's value to set account number function

        System.out.println("Enter Your balance:");
        text = input.nextLine();			//taking balance from user
        num = temp.stringChecker(text);
        ac1.setBalance(num);			//passing user's value to set balance function

        System.out.println("How much money you want to deposit ?");
        text = input.nextLine();				//taking balance from user
        num = temp.stringChecker(text);
        ac1.deposit(num);					//passing user's value to deposit function

        System.out.println("How much money you want to withdraw?");
        text = input.nextLine();				//taking the amount of money to be withdrawn from user
        num = temp.stringChecker(text);
        ac1.withdraw(num);					//passing user's value to withdraw function

        System.out.println(ac1);			// printing account's data

        System.out.println("You are in special account");		//testing special account
        System.out.println("Enter your account number: ");
        text = input.nextLine();//taking account number from user
        num = temp2.stringChecker(text);
        ac2.setAccountNumber(num);			//passing user's value to account number function

        System.out.println("Enter Your balance: ");
        text = input.nextLine();			//taking balance from user
        num = temp2.stringChecker(text);
        ac2.setBalance(num);			//passing user's value to set balance function

        System.out.println("How much money you want to deposit ?");
        text = input.nextLine();			//taking amount needed to be deposited from user
        num = temp2.stringChecker(text);
        ac2.deposit(num);				//passing user's value to deposit function

        System.out.println("How much money you want to withdraw?");
        text = input.nextLine();		//taking account number from user
        num = temp2.stringChecker(text);
        ac2.withdraw(num);			//passing user's value to withdraw function

        System.out.println(ac2);	//printing the data of the second object which is testing special account

    }
}

