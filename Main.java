package bankSystem;

import java.util.Scanner;


public class Main {
    public static void main(String[] args)      //main class
    {

        Bank bank = new Bank();  //creating an object from class bank
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        long choice1 = 0, choice2 = 0 , phone = 0;
        int repeat = 0;
        String text,name,address;
        Account temp = new Account();
        boolean bool = false;
        System.out.println("Enter Bank name: "); //take the name of the Bank
        name = input2.nextLine();
        while(name == null || name.isEmpty()) //check if the name is string
        {
            System.out.println("please enter Bank name");
            name = input2.nextLine();
        }
        bank.setBankName(name); //set the bank name
        System.out.println("Enter Bank address: "); //take the address of the Bank
        address = input2.nextLine();
        while(address == null || address.isEmpty())
        {
            System.out.println("please enter Bank address");
            address = input2.nextLine();
        }
        bank.setBankAddress(address); //set the bank address
        System.out.println("Enter Bank Phone number: "); //take the phone number of the Bank
        text = input2.nextLine();
        phone = temp.stringChecker(text); //check if the phone is integers
        bank.setBankPhoneNumber(phone); //set the bank phone number

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
                    bank.displayClients();  //calling the method from Bank class
                    bool = true;
                }
                else if (choice1 == 3)  //if the user chose 3 then he wants to view all the accounts , so method (display accounts is called from Bank class)
                {
                    bank.displayAccounts();  //calling the method from Bank class
                    bool = true;
                }
                else if (choice1 == 4) {  // choice 4 means he wants to exit the program
                    System.exit(0);

                }
                else {
                    System.out.println("PLEASE ENTER FROM 1 TO 4 ONLY ");
                    choice1 = input.nextInt();
                }


            }
        }
    }
}

