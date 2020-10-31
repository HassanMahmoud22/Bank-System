/***
 
 Name: Hassan Mahmoud Hassan 	id: 20180088
 Name: Bishoy Mokhless khela  	id: 20180072
 Name: Mostafa Adel          	id: 20180279
 
 ***/

package bankSystem;

import bankSystem.Account;
import bankSystem.Client;

public class CommercialClient extends Client {   //inheriting a special type of clients , Commercial client

    long commercialID;              // commercial id for the commercial client


    public CommercialClient()       //default constructor to set a default value for the commercial id
    {
        commercialID = 00000;
    }

    public void setNationalID(long nationalID) {  //setting the value (00000000000000) to the national id as the commercial client does not have a national id
        long n = 00000000000000;
        super.setNationalID(n);     /*Super is a keyword of Java which refers to the immediate parent of a class
                                     and is used inside the subclass method definition for calling a method defined in the superclass. */
    }

    public void setCommercialID(long commercialID) {     // setting value to client commercial id
        this.commercialID = commercialID;
    }



    public long getCommercialID() {   //returning client commercial id to view it or use it in another function
        return commercialID;
    }


    /*parameterized constructor , set values(passed by the user) to the class variables
     passing the object account to set values for its variables (balance and account number)*/
    public CommercialClient(String newName, long newCommercialID, String newAddress, long newPhone, Account newAccount)
    {
        setName(newName);
        setCommercialID(newCommercialID);
        setAddress(newAddress);
        setPhone(newPhone);
        this.account = newAccount;
    }
    //overriding to string() to view commercial client information
    @Override
    public String toString() {
        return ("Client Name : " + getName() + "\n" +
                "Client Commercial ID : " + getCommercialID() + "\n" +
                "Client National ID : " + getNationalID() + "\n" +
                "Client Address : " + getAddress() + "\n" +
                "Client Phone number : " + getPhone() + "\n" +
                account.toString());
                /*"Client account number : " + account.getAccountNumber() + "\n" +
                "Client account balance : " + account.getBalance() + "\n");**/
    }
}

