
import java.io.*;
import java.util.*;

/**
 * AirlineReservation
 * Andrian Than
 * @version 1.0 10/02/2024
 */

public class AirlineReservation {
    private static ArrayList<User> publicUsers = new ArrayList<User>();
    private static ArrayList<User> adminUsers = new ArrayList<User>();
    private static ArrayList<Seat> passengerSeats = new ArrayList<Seat>();
    private static ArrayList<Seat> reservedSeats = new ArrayList<Seat>();
    private static HashMap<String, ArrayList<Seat>> reservation = new HashMap<>();
    private static File CL34;
    private static File Users;


    public static void initializeSeating(){
        String class ="";
        char seatLetter = '';
        for(int i = 1; i < 11; i++)
        {
            if(i ==1)
            {
                seatLetter = 'A';
            }else if(i == 2)
            {
                seatLetter = 'B';
            }else if(i==3)
            {
             seatLetter = 'C';
            }else if(i ==4){
                seatLetter = 'D';
            }else if(i ==5)
            {
                seatLetter = 'E';
            }else if(i ==6)
            {
                seatLetter = 'F';
            }else if(i ==7){
                seatLetter = 'G';
            }else if(i ==8)
            {
                seatLetter = 'J';
            }else if (i==9)
            {
                seatLetter = 'K';
            }else if(i ==10)
            {
                seatLetter = 'L';
            }
            for(int j = 1; j <= 53; j++) {
                //first class seats
                if (j >= 1 && j <= 4) {
                    if (j == 4 && (seatLetter == 'D' || seatLetter == 'E' || seatLetter == 'F' || seatLetter == 'G')) {
                        //no seats
                    } else if (seatLetter == 'C' || seatLetter == 'J') {
                        //no seats
                    } else {
                        //initialize first class seats
                        class ="First Class";
                        Seat s = new Seat(j, seatLetter, class);
                        passengerSeats.add(s);
                    }
                }else if(j == 16 && (seatLetter == 'D' || seatLetter == 'E' || seatLetter == 'F' || seatLetter == 'G'))
                {
                    //economy plus seats
                    class = "Economy Plus";
                    Seat s = new Seat(j, seatLetter, class);
                    passengerSeats.add(s);
                }else if(j>=17 && j <=26)
                {
                    if(j >=24 && j <= 26 && (seatLetter == 'D' || seatLetter == 'E' || seatLetter == 'F' || seatLetter == 'G'))
                    {
                        class = "Economy";
                        Seat s = new Seat(j, seatLetter, class);
                        passengerSeats.add(s);
                    }else{
                        class = "Economy Plus";
                        Seat s = new Seat(j, seatLetter, class);
                        passengerSeats.add(s);
                    }

                }else if(j >= 27 && j <= 36)
                {
                    class = "Economy";
                    Seat s = new Seat(j, seatLetter, class);
                    passengerSeats.add(s);
                }else if (j == 37)
                {
                    if (seatLetter == 'A' || seatLetter == 'B' || seatLetter == 'K' || seatLetter == 'L')
                    {
                        class = "Economy";
                        Seat s = new Seat(j, seatLetter, class);
                        passengerSeats.add(s);
                    }else{
                        //no seats
                    }
                }else if(j ==38){
                    //no seats
                }else if(j == 39 ){
                    if(seatLetter == 'A' || seatLetter == 'B' || seatLetter == 'C' || seatLetter == 'J' || seatLetter == 'K' || seatLetter == 'L')
                    {
                        class = "Economy Plus";
                        Seat s = new Seat(j, seatLetter, class);
                        passengerSeats.add(s);
                    }else {
                        //no seats
                    }
                }else if(j >= 40 && j <= 47)
                {
                    if(j == 40 && (seatLetter == 'D' || seatLetter == 'E' || seatLetter == 'F' || seatLetter == 'G'))
                    {
                        class = "Economy Plus";
                        Seat s = new Seat(j, seatLetter, class);
                        passengerSeats.add(s);
                    }else{
                        class = "Economy";
                        Seat s = new Seat(j, seatLetter, class);
                        passengerSeats.add(s);
                    }
                }else if(j >= 48 && j <= 53)
                {
                    if(j>= 48 && j <= 51 && (seatLetter == 'A' || seatLetter == 'B' || seatLetter == 'D' || seatLetter == 'E' || seatLetter == 'F' || seatLetter == 'G' || seatLetter == 'K' || seatLetter == 'L'))
                    {
                        class = "Economy";
                        Seat s = new Seat(j, seatLetter, class;
                        passengerSeats.add(s);

                    }else if(j == 52 && (seatLetter == 'A' || seatLetter == 'B' || seatLetter == 'D' || seatLetter == 'E' || seatLetter == 'F' || seatLetter == 'G'))
                    {
                        class = "Economy";
                        Seat s = new Seat(j, seatLetter, class);
                        passengerSeats.add(s);
                    else if(j == 53 && (seatLetter == 'D' || seatLetter == 'E' || seatLetter 'F' || seatLetter 'G')){
                        class = "Economy";
                        Seat s = new Seat(j, seatLetter, class);
                        passengerSeats.add(s);
                    }else {
                        // no seats
                    }
                }

            }

         }
        }
    }


    public static void createFile(String fileName)
    {
        CL34 = new File("/Users/andrianthan/IdeaProjects/ReservationSystem/src/" + fileName + ".txt");
        try{
            CL34.createNewFile();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void loadFiles(String fileName){
        File file1 = new File('/Users/andrianthan/IdeaProjects/ReservationSystem/src/' + fileName + '.txt');
       try{
           Scanner scan = new Scanner(file1);
           while(scan.hasNextLine())
           {
               String reservationInfo = scan.nextLine();
               String split = reservationInfo.split(" ");
               int seatNumber = Integer.parseInt(split[0]);
               char seatLetter = split[1].charAt(0);
               String name = split[4] + " " + split[5];
               String serviceClass =


           }

       }catch(FileNotFoundException e)
       {
           e.printStackTrace();
       }

    }

    public static void printUserMenu(){
        System.out.println("Please select one of the User Menu Options:\nCheck [A]availability  Make [R]eservation  [C]ancel Reservation   [V]iew Reservations  [D]one");
        selectUser();
    }

    public static void selectUser(){
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().toUpperCase();
        while(true){

            if(input.equals("A"))
            {
                checkAvailability();
                break;

            }else if(input.equals("R"))
            {
                makeReservation();
                break;

            }else if(input.equals("C"))
            {
                cancelReservation();
                break;

            }else if(input.equals("V"))
            {
                viewReservation();
                break;

            }else if(input.equals("D"))
            {
                userExit();
                break;

            }else{
                System.out.println("Invalid input. Please try again");
                input = scan.nextLine().toUpperCase();
            }
        }


    }
    public static void checkAvailability(String name){
        System.out.println("Seat Availability\n\nFirst Class (price: $1000/seat)");
        boolean
    }

    public static void makeReservation(){

    }

    public static void cancelReservation(){

    }

    public static void viewReservation(){

    }

    public static void userExit(){

    }
    public static void selectAdmin(){
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while(true)
        {
            if(input.equals("M"))
            {
                adminManifest();
                break;

            }else if(input.equals("X"))
            {
                adminExit();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                input = scan.nextLine().toUpperCase();
            }
        }


    }

    public static void adminManifest(){

    }

    public static void adminExit()
    {

    }

    public static void printAdminMenu(){
        System.out.println("Please select one of the Admin Menu Options:\nShow [M]anifest list, E[X]it");
        selectAdmin();
    }

    public static void getUserInfo() {
        Scanner scan = new Scanner(System.in);
        User validAccount = null;
        String id;
        String name;
        String password;

        while (true) {
            System.out.println("Are you a [F]irst Time User, [R]eturning User, or [E]xit?");
            String userInput = scan.nextLine().toUpperCase();

            if (userInput.equals("E")) {
                System.out.println("Exiting. Thank you!");
                break;
            }

            if (userInput.equals("F")) {
                System.out.println("Please enter id for account creation.");
                id = scan.nextLine();
                boolean validId;

                while (true) {
                    validId = true;
                    if (publicUsers.size() == 0) {
                        break;
                    } else {
                        for (User u : publicUsers) {
                            if (u.getId().equals(id)) {
                                System.out.println("Account id exists. Please enter another account id.");
                                validId = false;
                                break;
                            }
                        }
                        if (validId) {
                            break;
                        } else {
                            id = scan.nextLine();
                        }
                    }
                }

                System.out.println("Please enter name for account creation.");
                name = scan.nextLine();
                System.out.println("Please enter password for account creation.");
                password = scan.nextLine();
                User user = new User(id, name, password);
                publicUsers.add(user);
                System.out.println("Airline Reservation account successfully created.");

            } else if (userInput.equals("R")) {
                if (publicUsers.size() == 0) {
                    System.out.println("No valid account found, please create an account first");
                    userInput = "F";
                    continue;
                }

                boolean validUser = false;
                System.out.println("Please enter account id.");
                id = scan.nextLine();

                while (!validUser) {
                    for (User u : publicUsers) {
                        if (u.getId().equals(id)) {
                            validUser = true;
                            validAccount = u;
                            break;
                        }
                    }
                    if (!validUser) {
                        System.out.println("Valid account Id not found. Please enter 1 to try again or 2 to proceed to account creation");
                        String c = scan.nextLine();
                        if (c.equals("1")) {
                            System.out.println("Please enter account id");
                            id = scan.nextLine();
                        } else if (c.equals("2")) {
                            userInput = "F";
                            continue;
                        } else {
                            System.out.println("Invalid choice. Going back to menu");
                            break;
                        }
                    } else {
                        break;
                    }
                }

                if (!validUser) {
                    continue;
                }

                System.out.println("Please enter account password.");
                password = scan.nextLine();
                boolean correctPassword = false;

                while (!correctPassword) {
                    if (validAccount.getPassword().equals(password)) {
                        correctPassword = true;
                        System.out.println("Successfully logged in.");
                        return; // Exit after successful login
                    } else {
                        System.out.println("Incorrect password entered. Please enter 1 to try again or 2 to proceed to account creation.");
                        String c = scan.nextLine();
                        if (c.equals("1")) {
                            System.out.println("Please enter account password.");
                            password = scan.nextLine();
                        } else if (c.equals("2")) {
                            userInput = "F";
                            continue;
                        } else {
                            System.out.println("Invalid choice. Going back to menu");
                            break;
                        }
                    }
                }
            } else {
                System.out.println("Invalid Input. Please try again");
            }
        }
    }



}