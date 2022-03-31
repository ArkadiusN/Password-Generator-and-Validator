package com.company;
import java.util.ArrayList;

public class Password {
    static String generator(int length, int symbols, int digits) {
        //Array list for our symbols, digits and chars to be stored.
        ArrayList<String> alphanumeric_list = new ArrayList<>();

        //Strings with characters, symbols and digits.
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String text_signs = "¬!£$%^&*()_+{}:@~<>?|,.;'#[]=-`";
        String numbers = "1234567890";

        //Our password.
        String  randomString = "";

        //Adding random symbols to our array list.
        for (var i = 0; i < symbols; i++) {
            int randomPoz = (int) Math.floor(Math.random() * text_signs.length());
            alphanumeric_list.add(text_signs.substring(randomPoz,randomPoz+1));
        }

        //Adding random digits to our array list.
        for (var i = 0; i < digits; i++) {
            int randomPoz = (int) Math.floor(Math.random() * numbers.length());
            alphanumeric_list.add(numbers.substring(randomPoz,randomPoz+1));
        }

        //Adding random lowercase or uppercase chars to fill remaining gap.
        for (var i = 0; i < length - (symbols + digits); i++) {
            int randomPoz = (int) Math.floor(Math.random() * alphabet.length());
            alphanumeric_list.add(alphabet.substring(randomPoz, randomPoz + 1));
        }

        //Placing the characters randomly to our password and removing it from list.
        for (int i = 0; i < length; i++) {
            int randomPoz = (int) Math.floor(Math.random() * alphanumeric_list.size());
            randomString += alphanumeric_list.get(randomPoz);
            alphanumeric_list.remove(randomPoz);
        }
        //Giving back randomly generated password.
        return randomString;
    }

    //Method to validate a password.
    static String Validator(String password) {
        //Counters for defining how many does the password include.
        int letters_up = 0;
        int letters_low = 0;
        int digits = 0;
        int symbol = 0;
        //If password provided by user has upper case letters/lower case letters/
        //digits or symbols sum them individually, for further use.
        for (int i = 0; i < password.length(); i++) {
            if(password.charAt(i) >= 'a' && password.charAt(i)<='z'){
                letters_low++;
            }
            else if(password.charAt(i) >= 'A' && password.charAt(i)<='Z'){
                letters_up++;
            }
            else if(password.charAt(i) >= '0' && password.charAt(i)<='9'){
                digits++;
            }
            else {
                symbol++;
            }
        }

        //Checking if password meets criteria for 'Poor password'.
        if((symbol == 0 && digits == 0 && password.length() <=8) &&
        (letters_low ==0  || letters_up ==0)){
            return "Your password is: Poor";
        }
        //Checking if password meets criteria for 'Ok password'.
        else if (symbol > 1 && digits > 2 && password.length() > 8 && password.length() < 13 &&
        (letters_low >0 && letters_up == 0 || letters_up>0 && letters_low ==0)) {
            return "Your password is: Ok";
        }
        //Checking if password meets criteria for 'Good password'.
        else if (symbol >3 && digits >2 && password.length() > 12 && password.length() < 16 &&
                (letters_low >0 && letters_up >0)) {
            return "Your password is: Good";
        }
        //Checking if password meets criteria for 'Excellent password'.
        else if (symbol > 4 && digits > 4 && password.length() >= 16 &&
                (letters_low >0 && letters_up >0)) {
            return "Your password is: Excellent";
        }
        //If none criteria was met, inform the user.
        else{
            return "Password provided does not meet the criteria \n";
        }
    }

}
