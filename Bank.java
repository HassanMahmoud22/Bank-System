package bankSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    private String bankName; //BankName
    private String bankAddress; //BankAddress
    private long bankPhoneNumber; //Bank PhoneNumber
    private int numberOfClients; //Number of clients
    private int numberOfAccounts; //number of accounts
    protected Client client = null; // object of clients
    public ArrayList<Account> accountData = new ArrayList<Account>(); //create array list of type account
    public ArrayList<Client> clientData = new ArrayList<Client>(); // create arrayList of type Client
    Scanner input = new Scanner(System.in); // scanner to take inputs
    Scanner input2 = new Scanner(System.in); // scanner to take inputs

    public Bank( ) {
        bankName = " ";
        bankAddress = " ";
        bankPhoneNumber = 0;
        numberOfClients = 0;
        numberOfAccounts = 0;
    } //default constructor

    public Bank(String bankName, String bankAddress, long bankPhoneNumber) {
        this.bankName = bankName;
        this.bankAddress = bankAddress;
        this.bankPhoneNumber = bankPhoneNumber;
    }// //constructor to initialize the name , address and number of bank

    public void setBankName(String bankName) {
        this.bankName = bankName;
    } //Setter to bank name

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    } //Setter to bank address

    public void setBankPhoneNumber(long bankPhoneNumber) {
        this.bankPhoneNumber = bankPhoneNumber;
    } //Setter to bank phone number

    public String getBankName() {
        return bankName;
    } //getter for bank name

    public long getBankPhoneNumber() {
        return bankPhoneNumber;
    }//getter for bank phone number

    public String getBankAddress() {
        return bankAddress;
    } //getter for bank address






    public void addClient (Client NewClient)//Method to add new client
    {
        clientData.add(numberOfClients, NewClient);
        numberOfClients++;

    }

    public void addAccount (Account newAccount)//Method to add new client
    {
        accountData.add(numberOfAccounts, newAccount);
        numberOfAccounts++;
    }

    public long uniqueAccountNumber(long accountNumber) //method to check if the account number the user entered is repeated
    {
        for(int i=0; i < numberOfClients ; i++) //loop on the arrayList
        {
            Client c1 = new Client(); //object of client
            c1 = clientData.get(i);
            boolean flag = true;
            while (flag)
            {
                //check if the account number the user enter is exist on the arraylist or not
                if(accountNumber == c1.account.getAccountNumber()) {
                    System.out.println("The Account number you entered is repeated, Please enter another number");
                    accountNumber = input.nextLong(); //scanner to take the account number
                    flag = true;
                }
                else
                    flag = false;
            }
        }
        return accountNumber;
    }


    public void displayClients() //method to display the clients stored on the arrayList
    {
        if(clientData.size() == 0) // check if the arrayList is empty
        {
            System.out.println("There is no client registered yet");
        }
        else
        {
            for (int i=0 ; i < numberOfClients ; i++ ) //loop on the arrayList
            {
                Client c1 = new Client(); //object of client
                c1 = clientData.get(i);
                System.out.println("The Client number " + (i+1) +" data : \n" + c1);

            }
        }
    }

    public void displayAccounts() //method to display account data
    {
        if(accountData.size() == 0) // check if the arrayList is empty
        {
            System.out.println("There is no clients registered yet");
        }
        else
        {
            for (int i=0 ; i < numberOfAccounts ; i++ ) //loop on the arrayList of accounts
            {
                Account c1 = null; //object of account
                c1 = accountData.get(i);
                System.out.println( "The Client number " + (i+1) +" account's data : \n" +c1); //display data of accont

            }
        }
    }

    public void ClientInfo(long choice2) // Method to take data from user
    {
        String name , address;
        long  choice3 = 0 , choice4 = 0 ,phone = 0, id = 0, accountNumber = 0 ,balance =0 , money = 0;
        boolean bool = true;
        String text , accountType = "none" ,clientType = "none";
        Account temp = new Account();

        System.out.println("Enter client's name: "); //take the name of the client
        name = input2.nextLine();
        while(name == null || name.isEmpty())
        {
        		System.out.println("please enter client's name");
        		name = input2.nextLine();
        }
        System.out.println("Enter client's address: "); //take the address of the client
        address = input2.nextLine();
        while(address == null || address.isEmpty())
        {
        		System.out.println("please enter client's address");
        		address = input2.nextLine();
        }
        
        System.out.println("Enter Your Phone number: "); //take the phone number of the client
        text = input2.nextLine();
        phone = temp.stringChecker(text);

        if(choice2 == 1) // if the client is Normal
        {
        	System.out.println("Enter Your National ID: ");
        	clientType = "normalClient";
        }
        else //else it's Commercial client
        {
        	System.out.println("Enter Your Commercial ID: ");
        	clientType = "commercialClient";
        }
        text = input2.nextLine();
        id = temp.stringChecker(text);
        
        System.out.println("Which type of account you want to add? \n 1-Add Normal Account \n 2- Add Special Account");
        text = input2.nextLine();
        choice3 = temp.stringChecker(text);
        while(bool)
        {
        	if(choice3 == 1)
        	{
        		//normal account
        		Account account = new Account();    //object of account
        		System.out.println("Enter the account number: ");
        		text = input2.nextLine();
                accountNumber = temp.stringChecker(text);
        		accountNumber = uniqueAccountNumber(accountNumber);
        		account.setAccountNumber(accountNumber);		//passing user's value to set account number function**/
        		System.out.println("Enter the account balance: ");
        		text = input2.nextLine();
                balance = temp.stringChecker(text);
                account.setBalance(balance);
        		if(clientType == "normalClient")
        		{
        			client = new Client(name, id, address, phone, account);     //call the constructor
        		}
        		else
        		{
        			client = new CommercialClient(name, id, address, phone, account); // call commercial account constructor
        		}
        		bool = false;
        		accountType = "Normal";
        	}
        	else if(choice3 == 2)
        	{
        		//Special account
        		Account account = new SpecialAccount(); //object of special account
        		System.out.println("Enter the account number: ");
        		text = input2.nextLine();
                accountNumber = temp.stringChecker(text);
        		accountNumber = uniqueAccountNumber(accountNumber); //check if the account number is unique
        		account.setAccountNumber(accountNumber);     //set account number
        		System.out.println("Enter the account balance: ");
        		text = input2.nextLine();
                balance = temp.stringChecker(text);
        		account.setBalance(balance);    //set balance
                if(clientType == "normalClient")
                {
                    client = new Client(name, id, address, phone, account);     //call the constructor
                }
                else
                {
                    client = new CommercialClient(name, id, address, phone, account); // call commercial account constructor
                }
        		bool = false;
        		accountType = "Special";
        	}
        	else
        	{
                System.out.println("Please enter 1 or 2"); // if the user entered wrong choice
                text = input2.nextLine();
                choice3 = temp.stringChecker(text);
            }
        }
        System.out.println("The "+ accountType +" Account Created successfully! \n");
        bool = true;
        while(bool)
        {
            //the operations
            System.out.println("Please choose next operation \n 1-Deposit \n 2-Withdraw \n 3-Show the balance \n 4-Back to main menu \n 5-Exit program");
            text = input2.nextLine();
            choice4 = temp.stringChecker(text);
            
            if(choice4 == 1)
            {
                System.out.println("How much money you want to deposit?");
                
                text = input2.nextLine();
                money = temp.stringChecker(text);
                client.account.deposit(money); //call deposit method

            }
            else if(choice4 == 2)
            {
                System.out.println("How much money you want to withdraw?");
                text = input2.nextLine();
                money = temp.stringChecker(text);
                client.account.withdraw(money); // call withdraw method
            }
            else if(choice4 == 3)
            {
                System.out.println(client.account.getBalance()); // display balance


            }
            else if(choice4 == 4)
            {
                addClient(client); // add client object to the array List of the clients
                addAccount(client.account); // add account object to the array list of account
                bool = false;

            }
            else if(choice4 == 5)
            {
                System.exit(0); // exit the program
            }

        }
    }
}


