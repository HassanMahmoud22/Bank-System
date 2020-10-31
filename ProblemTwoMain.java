/***
 
 Name: Hassan Mahmoud Hassan 	id: 20180088
 Name: Bishoy Mokhless khela  	id: 20180072
 Name: Mostafa Adel          	id: 20180279
 
 ***/

package bankSystem;

import java.util.Scanner;

public class ProblemTwoMain {
    public static void main(String[] args) {
        Client client1 = new Client();
        CommercialClient client2 = new CommercialClient();
        Account testAccount = new Account(); //create a null object to use the methods in this class and to pass it to the constructor
        testAccount.setAccountNumber(1); //setting account number and balance to 1
        testAccount.setBalance(1);
        System.out.println(client1);
        Scanner input = new Scanner(System.in); // scanner to take inputs
        Scanner input2 = new Scanner(System.in); // scanner to take inputs
        System.out.println("Enter Your name: "); //take the name of the client
        String name = input2.nextLine();
        client1.setName(name); //setting user input name to the client name

        System.out.println("Enter Your address: "); //take the address of the client
        String address = input2.nextLine();
        client1.setAddress(address); //setting user input address to the client address

        System.out.println("Enter Your Phone number: "); //take the phone number of the client

        String text = input.nextLine();           //taking the account number from user
        long phone = testAccount.stringChecker(text);        //check is the phone number is positive or not
        client1.setPhone(phone); //setting user input phone number to the client phone number

        System.out.println("Enter your National ID: ");

        text = input.nextLine();           //take the id for the client
        long id = testAccount.stringChecker(text);         //check if the id is positive or not
        client1.setNationalID(id); //setting user input id  to the client id

        System.out.println("Client Name : " + client1.getName() + "\n" +      //viewing user data using method get
                "Client National ID : " + client1.getNationalID() + "\n" +
                "Client Address : " + client1.getAddress() + "\n" +
                "Client Phone number : " + client1.getPhone() + "\n");


        System.out.println("Enter Your name: "); //take the name of the client
        name = input2.nextLine();

        System.out.println("Enter Your address: "); //take the address of the client
        address = input2.nextLine();

        System.out.println("Enter Your Phone number: "); //take the phone number of the client

        text = input.nextLine();           //take the id for the client
        phone = testAccount.stringChecker(text);         //check if the id is positive or not


        System.out.println("Enter your Commercial ID: ");

        text = input.nextLine();           //take the id for the client
        id = testAccount.stringChecker(text);         //check if the id is positive or not

        client2 = new CommercialClient(name , id,address,phone , testAccount); //passing parameters to the paramterized constructod

        System.out.println(client2);   //overriding to string method to view user's data
    }
}
