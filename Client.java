package bankSystem;

import bankSystem.Account;

public class Client {
    private String name;                      //client name
    private long nationalID;                 //client national id
    private String address;                 // client address
    private long phone;                    //client phone
    protected Account account = null;     //object of class account as the client has an account

    public Client(){        //default constructor , setting default values to the variables
        name = " ";
        nationalID = 0;
        address = " ";
        phone = 0;
    }


    /*parameterized constructor , set values(passed by the user) to the class variables
   passing the object account to set values for its variables (balance and account number)*/
    public Client(String newName, long newNationalID, String newAddress, long newPhone, Account newAccount) {
        setName(newName);
        setNationalID(newNationalID);
        setAddress(newAddress);
        setPhone(newPhone);
        this.account = newAccount;

    }

    public void setName(String name) {               // setting value to client name
        this.name = name;
    }


    public void setNationalID(long nationalID) {  // setting value to client national id
        this.nationalID = nationalID;
    }

    public void setAddress(String address) {    // setting value to client address
        this.address = address;
    }

    public void setPhone(long phone) {         // setting value to client phone number
        this.phone = phone;
    }

    public String getName() {                //returning client name to view it or use it in another function
        return name;
    }

    public long getNationalID() {       //returning client national id to view it or use it in another function
        return nationalID;
    }

    public String getAddress() {        //returning client address to view it or use it in another function
        return address;
    }

    public long getPhone() {        //returning client phone number to view it or use it in another function
        return phone;
    }

    //overriding to string() to view client information
    @Override
    public String toString() {
        return ("Client Name : " + getName() + "\n" +
                "Client National ID : " + getNationalID() + "\n" +
                "Client Address : " + getAddress() + "\n" +
                "Client Phone number : " + getPhone() + "\n" +
                account.toString());
                /*"Client account number : " + account.getAccountNumber() + "\n" +
                "Client account balance : " + account.getBalance() + "\n")*/
    }


}
