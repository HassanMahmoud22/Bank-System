package bankSystem;

import bankSystem.Account;

public class SpecialAccount extends Account {
	private String text;
	SpecialAccount()
	{
		text = " ";
	}
    @Override
    public void withdraw(long amount)		// overriding withdraw method to make overdraft
    {
        boolean flag = true;
        long Balance = getBalance();		// creating a variable to give it the value of balance

        while(flag)
        {

            if((Balance - amount) >= -1000)	//  if the difference between the balance and the amount he want to withdraw is more than or equal to -1000
            {
                Balance -=amount;		// then it will be withdrawn
                setBalance(Balance);
                flag = false;
            }
            else
            {
                System.out.println("You can't withdraw more than " + (Balance + 1000) );	//if it's not right then it will send message to him that it's not legal
                System.out.println("Enter the value again");	//and ask him to enter it again
                text = input.nextLine();  //taking the input from user again
                amount = stringChecker(text);  //check if it's positive or negative number or string
                flag = true;
            }
        }
    }

    @Override
    public String toString() {
        return  ("The Account data : \n"+
                "Account number = " + getAccountNumber()+ "\n"
                +"Account balance = " + getBalance()+ "\n"
                +"Account type is Special \n");
    }
}
