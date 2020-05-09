package app;
import java.util.Random;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;
import java.time.LocalDateTime; 

public class App {

    public class Customer {
        String name, email, id;
        boolean ActiveStatus;
      }


    public static void main()  {
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
        String id, name, email, JoinMonth, MemberInput;
        boolean ActiveStatus;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM");  
        LocalDateTime now = LocalDateTime.now(); 
        JoinMonth = dtf.format(now);

        System.out.println("enter your first and last name: ");
        name = System.console().readLine();

        System.out.println("enter your email address: ");
        email = System.console().readLine();

        System.out.println("do you want to buy a membership?: ");
        MemberInput = System.console().readLine();
        if (MemberInput == "y") {ActiveStatus = true;}
        if (MemberInput == "n") {ActiveStatus = false;}

        //System.out.println(GenerateID(name, email, JoinMonth));

    }
    
    public static void SearchMembers() {
        
    }

    public static void EndingMonth() {
        
    }

    public static String GenerateID(String name, String email, String JoinMonth) {
        String ID, letter;
        int num[] = {0, 0, 0, 0};
        Random rnd = new Random();

        for (int i =0; i<=3; i++) {
            num[i] = rnd.nextInt(10);
        }
        
        letter = name.substring(0, 1).toUpperCase();

        ID = JoinMonth + letter + num[0] + num[1] + num[2] + num[3];

        return ID;
    }
}