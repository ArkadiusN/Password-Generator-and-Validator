package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String menu;
        Scanner key = new Scanner(System.in);

        //Menu
        do {
            //Options to chose from.
            System.out.println("1. Password Generator");
            System.out.println("2. Password Validator");
            System.out.println("3. Quit");
            System.out.println("Select your option then press enter");
            menu = key.next(); //Our chosen option.
            switch (menu)
            {
                //Case 1 if for creating a random password of the given size
                //and chosen number of special characters/digits.
                case "1":
                    int length;
                    int symbols;
                    int digits;
                    System.out.println("How long should the password be?:");
                    length = key.nextInt();
                    System.out.println("How many special characters do you want?:");
                    symbols = key.nextInt();
                    System.out.println("How many digits do you want?:");
                    digits = key.nextInt();
                    System.out.println(Password.generator(length,symbols,digits));
                    System.out.println();
                    break;
                //Case 2 is for validating a password given by the user
                //to see exactly if it's a good password or not.
                case "2":
                    String our_password;
                    System.out.println("Please enter your password:");
                    our_password = key.next();
                    System.out.println(Password.Validator(our_password));
                    break;
                //Case 3 is to exit program.
                case "3":
                    System.out.println("Exiting program, bye.");
                    break;
                //In case of invalid input, default will inform the user.
                default:
                    System.out.println("Invalid output");
                    System.out.println();
                    break;
            }
        }while(!menu.equals("3"));
    }

}
