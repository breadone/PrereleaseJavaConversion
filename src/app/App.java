package app;
import java.util.Random;
//import java.lang.reflect.Member;
//import java.lang.reflect.Method;
import java.time.format.DateTimeFormatter;
//import java.util.function.Function;
import java.time.LocalDateTime;
import java.io.FileWriter;
import java.io.IOException;
//import java.lang.reflect.Member;

public class App {
    public static void main(String[] args)  {
        HomeScreen();
 }

    public static void HomeScreen() {
        String selection;

        //display title sequence
        System.out.println("#########################################################");
        System.out.println("##########  Dwight Schrute's Gym For Muscules  ##########");
        System.out.println("#################  by Pradyun Setti  ####################");
        System.out.println("#########################################################");

        System.out.println("\n 1. add new member\n 2. search for member\n 3. membership ending month");

        System.out.println("what action would you like to perform?: ");
        selection = System.console().readLine();

        switch(selection) {
            case "1":
                AddNewMember();
            case "2":
                SearchMembers();
            case "3":
                EndingMonth();
        }
    }

    public static void AddNewMember() {
        String MemberInput;
        Customer NewCustomer = new Customer();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM");  
        LocalDateTime now = LocalDateTime.now(); 
        NewCustomer.JoinMonth = dtf.format(now);

        System.out.print("enter your first and last name: ");
        NewCustomer.name = System.console().readLine();

        System.out.print("enter your email address: ");
        NewCustomer.email = System.console().readLine();

        while (Validate(NewCustomer.email) == false) {
            System.out.print("invalid email. please try again: ");
            NewCustomer.email = System.console().readLine();
        }

        System.out.print("do you want to buy a membership?: ");
        MemberInput = System.console().readLine();

        switch (MemberInput) {
            case "y": 
                NewCustomer.ActiveStatus = true;
            case "n":
                NewCustomer.ActiveStatus = false;
        }

       // if (MemberInput == "y") {NewCustomer.ActiveStatus = true;}
       // if (MemberInput == "n") {NewCustomer.ActiveStatus = false;}
        System.out.println(NewCustomer.ActiveStatus);
        

        NewCustomer.id = GenerateID(NewCustomer.name, NewCustomer.email, NewCustomer.JoinMonth);

        WriteToFile(NewCustomer.id, NewCustomer.name, NewCustomer.email, NewCustomer.JoinMonth, NewCustomer.ActiveStatus);
    }
    
    public static void SearchMembers() {
        
        
    }

    public static void EndingMonth() {
        
    }

    public static void WriteToFile(String name, String email, String JoinMonth, String id, boolean ActiveStatus) {
        try {
            FileWriter WriteCustomerRecord = new FileWriter("record.txt", true);
            WriteCustomerRecord.write(id + "!" + name + "!" + email + "!" + JoinMonth + "!" + ActiveStatus + "\n");
            WriteCustomerRecord.close();
            System.out.println("succesfully added customer");
        } catch (IOException e) {
            System.out.println("An error occured while writing to the file.");
        }
    }

    public static String GenerateID(String name, String email, String JoinMonth) {
        String ID, letter;
        int num[] = new int[4];
        Random rnd = new Random();

        for (int i =0; i<=3; i++) {
            num[i] = rnd.nextInt(10);
        }
        
        letter = name.substring(0, 1).toUpperCase();

        ID = JoinMonth + letter + num[0] + num[1] + num[2] + num[3];

        return ID;
    }

    public static boolean Validate(String email) {
        int LengthOfEmail = email.length();
        char letters[] = new char[LengthOfEmail];
        boolean ValidAt = false, ValidDot = false;
        
        for (int i = 0; i <= LengthOfEmail -1 ; i++) {
            letters[i] = email.charAt(i);

            if (letters[i] == '@') {ValidAt = true;}
            if (letters[i] == '.') {ValidDot = true;}
       }
       if (ValidAt == true && ValidDot == true) {
        return true;
    } else {
        return false;
    }
    }

     public static void GoHome() {
        String input;
        System.out.println("press h to go home or press enter to exit");
        input = System.console().readLine();
        if (input == "h") {
            HomeScreen();
        }
    }


}