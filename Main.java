/***
 
 Name: Hassan Mahmoud Hassan 	id: 20180088
 Name: Bishoy Mokhless khela  	id: 20180072
 Name: Mostafa Adel          	id: 20180279
 
 ***/

package bankSystem;

import java.util.Scanner;


public class Main {
    public static void main(String[] args)      //main class
    {

        Bank bank = new Bank();  //creating an object from class bank
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        long choice1 = 0, choice2 = 0 , bankPhone = 0;
        int repeat = 0;
        String text, bankName, bankAddress;
        Account temp = new Account();
        boolean bool = false;
        
        System.out.println("Enter Bank name: "); //take the name of the Bank
        bankName = input.nextLine();
        while(bankName == null || bankName.isEmpty()) //check if the name is string
        {
            System.out.println("please enter Bank name");
            bankName = input2.nextLine();
        }
        bank.setBankName(bankName); //set the bank name
        
        System.out.println("Enter Bank address: "); //take the address of the Bank
        bankAddress = input2.nextLine();
        while(bankAddress == null || bankAddress.isEmpty())
        {
            System.out.println("please enter Bank address");
            bankAddress = input2.nextLine();
        }
        bank.setBankAddress(bankAddress); //set the bank address
        
        System.out.println("Enter Bank Phone number: "); //take the phone number of the Bank
        text = input2.nextLine();
        bankPhone = temp.stringChecker(text); //check if the phone is integers
        bank.setBankPhoneNumber(bankPhone); //set the bank phone number

        while (repeat == 0) {
            choice1 = 0;
            choice2 = 0;
            bool = false;
            System.out.println("Welcome to our Bank System, please choose the number of operation you want \n 1- Add client \n 2- Display all clients with their accounts \n 3- Dsiplay all accounts \n 4- Exit program");
            text = input.nextLine();
            choice1 = temp.stringChecker(text);

            while (!bool) 
            {
                if (choice1 == 1) 			//if the user chose 1 then he wants to add a client
                { 
                    System.out.println(" 1- Add normal client \n 2- Add commercial client");
                    text = input.nextLine();  //take input from user
                    choice2 = temp.stringChecker(text);  //check it
                    
                    while (!bool)
                    {
                        if (choice2 == 1)		 // choice 1 means he wants to add a normal client
                        {
                            bank.ClientInfo(choice2);
                            bool = true;
                        } 
                        else if (choice2 == 2)		// choice 2 means he wants to add a commercial client
                        {  
                            bank.ClientInfo(choice2);
                            bool = true;
                        } 
                        else 
                        {
                            System.out.println("PLEASE ENTER 1 (OR) 2");  // if the user chose either 1 or 2 an error message is viewed to him
                            choice2 = input.nextInt();
                        }
                    }
                }
                else if (choice1 == 2) {  //if the user chose 2 then he wants to view all the clients , so method (display clients is called from Bank class)
                	System.out.println("Bank name: " + bank.getBankName() + "\n" + "Bank address: " + bank.getBankAddress() + "\n" + "Bank phone: " + bank.getBankPhoneNumber());
                    bank.displayClients();  //calling the method from Bank class
                    bool = true;
                }
                else if (choice1 == 3)  //if the user chose 3 then he wants to view all the accounts , so method (display accounts is called from Bank class)
                {
                	System.out.println("Bank name: " + bank.getBankName() + "\n" + "Bank address: " + bank.getBankAddress() + "\n" + "Bank phone: " + bank.getBankPhoneNumber());
                    bank.displayAccounts();  //calling the method from Bank class
                    bool = true;
                }
                else if (choice1 == 4) {  // choice 4 means he wants to exit the program
                    System.exit(0);

                }
                else 
                {
                    System.out.println("PLEASE ENTER FROM 1 TO 4 ONLY ");
                    choice1 = input.nextInt();
                }
            }
        }
    }
}

