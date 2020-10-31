/***
 
 Name: Hassan Mahmoud Hassan 	id: 20180088
 Name: Bishoy Mokhless khela  	id: 20180072
 Name: Mostafa Adel          	id: 20180279
 
 ***/

package bankSystem;

import java.util.Scanner;

class Account		//class Account created
{
    Scanner input = new Scanner(System.in);
    private long accountNumber;	//account number and balance attributes are private as it supposed to be
    private long balance;
    public boolean sign;		// boolean variable to check input of the user
    public long value;

    public Account()		//constructor to initialize account number , the balance and sign
    {
        accountNumber = 0;
        balance = 0;
        sign = true;
        value = 0;
    }
    
    public long stringChecker(String text) // check user's input if it's positive number
    {
    	
    	while(true)
    	{
    		try 
            {
                value = Long.parseLong(text);  //it means that value equals the value of text after transforming it into number 
            	String string;
                sign = (value > 0);				//if the value is positive then sign will be equal true and won't go to while loop
                
                while(sign == false)			// if it doesn't positive then it will print message to user and ask him to enter positive number
                {
                    System.out.println("please enter positive value");
                    string = input.nextLine();	//will take the input from user 
                    value = stringChecker(string);	//then passing the input to the function again to check if it's a positive number or negative or string
                    sign = (value > 0);          
                }
                
                return value;
            } 
            catch (NumberFormatException e)		//if user's input is string not a number then it will catch this exception
            {
               System.out.println("Please enter numeric value");		//and ask user to enter the input again
               text = input.nextLine();
            }
    	}    
    }

    public void setAccountNumber(long accountNumber)	//setter for account number it equates account number with passed value
    {
        this.accountNumber = accountNumber;
    }

    public long getAccountNumber() {		//getter for account number it return the value of account number
        return this.accountNumber;
    }
    public void setBalance(long balance)    //setter for balance it equates balance with passed value
    {
        this.balance = balance;
    }
    public long getBalance() 		  //getter for balance it returns the value of the balance
    {
        return this.balance;
    }
    public void withdraw(long amount)		// withdraw method
    {
        boolean flag = true;
        while(flag)
        {

            if(balance >= amount)	//it checks if balance is equal or more than the amount wanted to be withdrawn
            {
                balance -= amount;				// if the condition is right then the money will be withdrawn
                setBalance(balance);		//renewing balance
                flag = false;
            }
            else
            {
                System.out.println("You can't withdraw more than " + balance );	//if it's not right then it will send message to him that it's not legal
                System.out.println("Enter the value again");	//and ask him to enter it again
                amount = input.nextLong(); //taking the amount value from user
                flag = true;
            }

        }
    }
    public void deposit(long amount)     //deposit method
    {
       
        balance += amount;   	 // adding the amount to his balance
        setBalance(balance);	//then renewing balance
    }

    @Override
    public String toString() {    //overriding to string function
        return ("The Account data : \n"+
                "Account number = " + getAccountNumber() + "\n"
                +"Account balance = " + getBalance() + "\n"
                + "Account type is Normal \n");
    }
}
