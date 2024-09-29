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
        String serviceClass = "";
        char seatLetter = ' ';
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
                        serviceClass ="First Class";
                        Seat s = new Seat(j, seatLetter, serviceClass);
                        passengerSeats.add(s);
                    }
                }else if(j == 16 && (seatLetter == 'D' || seatLetter == 'E' || seatLetter == 'F' || seatLetter == 'G'))
                {
                    //economy plus seats
                    serviceClass = "Economy Plus";
                    Seat s = new Seat(j, seatLetter, serviceClass);
                    passengerSeats.add(s);
                }else if(j>=17 && j <=26)
                {
                    if(j >=24 && j <= 26 && (seatLetter == 'D' || seatLetter == 'E' || seatLetter == 'F' || seatLetter == 'G'))
                    {
                        serviceClass = "Economy";
                        Seat s = new Seat(j, seatLetter, serviceClass);
                        passengerSeats.add(s);
                    }else{
                        serviceClass = "Economy Plus";
                        Seat s = new Seat(j, seatLetter, serviceClass);
                        passengerSeats.add(s);
                    }

                }else if(j >= 27 && j <= 36)
                {
                    serviceClass = "Economy";
                    Seat s = new Seat(j, seatLetter, serviceClass);
                    passengerSeats.add(s);
                }else if (j == 37)
                {
                    if (seatLetter == 'A' || seatLetter == 'B' || seatLetter == 'K' || seatLetter == 'L')
                    {
                        serviceClass = "Economy";
                        Seat s = new Seat(j, seatLetter, serviceClass);
                        passengerSeats.add(s);
                    }else{
                        //no seats
                    }
                }else if(j ==38){
                    //no seats
                }else if(j == 39 ){
                    if(seatLetter == 'A' || seatLetter == 'B' || seatLetter == 'C' || seatLetter == 'J' || seatLetter == 'K' || seatLetter == 'L')
                    {
                        serviceClass = "Economy Plus";
                        Seat s = new Seat(j, seatLetter, serviceClass);
                        passengerSeats.add(s);
                    }else {
                        //no seats
                    }
                }else if(j >= 40 && j <= 47)
                {
                    if(j == 40 && (seatLetter == 'D' || seatLetter == 'E' || seatLetter == 'F' || seatLetter == 'G'))
                    {
                        serviceClass = "Economy Plus";
                        Seat s = new Seat(j, seatLetter, serviceClass);
                        passengerSeats.add(s);
                    }else{
                        serviceClass = "Economy";
                        Seat s = new Seat(j, seatLetter, serviceClass);
                        passengerSeats.add(s);
                    }
                }else if(j >= 48 && j <= 53)
                {
                    if(j>= 48 && j <= 51 && (seatLetter == 'A' || seatLetter == 'B' || seatLetter == 'D' || seatLetter == 'E' || seatLetter == 'F' || seatLetter == 'G' || seatLetter == 'K' || seatLetter == 'L'))
                    {
                        serviceClass = "Economy";
                        Seat s = new Seat(j, seatLetter, serviceClass);
                        passengerSeats.add(s);

                    }else if(j == 52 && (seatLetter == 'A' || seatLetter == 'B' || seatLetter == 'D' || seatLetter == 'E' || seatLetter == 'F' || seatLetter == 'G'))
                    {
                        serviceClass = "Economy";
                        Seat s = new Seat(j, seatLetter, serviceClass);
                        passengerSeats.add(s);
                    }else if(j == 53 && (seatLetter == 'D' || seatLetter == 'E' || seatLetter == 'F' || seatLetter == 'G')){
                        serviceClass = "Economy";
                        Seat s = new Seat(j, seatLetter, serviceClass);
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
        File file1 = new File("/Users/andrianthan/IdeaProjects/ReservationSystem/src/" + fileName + ".txt");
        try{
            Scanner scan = new Scanner(file1);
            while(scan.hasNextLine())
            {
                String reservationInfo = scan.nextLine();
                String[] split = reservationInfo.split(" ");
                int seatNumber = Integer.parseInt(split[0]);
                char seatLetter = split[1].charAt(0);
                String name = split[4] + " " + split[5];
                String serviceClass = ""; // Assign appropriate value based on your file structure

            }

        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    public static void printUserMenu(){
        System.out.println("Please select one of the User Menu Options:\nCheck [A]vailability  Make [R]eservation  [C]ancel Reservation   [V]iew Reservations  [D]one");
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
    public static void checkAvailability() {
        System.out.println("Seat Availability");
        System.out.println();

        System.out.println("First Class (price: $1000/seat)");
        boolean firstLetter = true;
        for (int i = 1; i <= 4; i++) {
            System.out.print(i + ": ");
            firstLetter = true;
            for (Seat s : passengerSeats) {
                if (s.getClassService().equals("First Class") && s.getNumber() == i && s.getAvailability()) {
                    if (firstLetter) {
                        System.out.print(s.getLetter());
                        firstLetter = false;
                    } else {
                        System.out.print(", " + s.getLetter());
                    }
                }
            }
            System.out.println();
        }

        System.out.println();

        System.out.println("Economy Plus (price: $500/seat)");
        for (int i = 16; i <= 26; i++) {
            System.out.print(i + ": ");
            firstLetter = true;
            for (Seat s : passengerSeats) {
                if (s.getClassService().equals("Economy Plus") && s.getNumber() == i && s.getAvailability()) {
                    if (firstLetter) {
                        System.out.print(s.getLetter());
                        firstLetter = false;
                    } else {
                        System.out.print(", " + s.getLetter());
                    }
                }
            }
            System.out.println();
        }
        for (int i = 39; i <= 40; i++) {
            System.out.print(i + ": ");
            firstLetter = true;
            for (Seat s : passengerSeats) {
                if (s.getClassService().equals("Economy Plus") && s.getNumber() == i && s.getAvailability()) {
                    if (firstLetter) {
                        System.out.print(s.getLetter());
                        firstLetter = false;
                    } else {
                        System.out.print(", " + s.getLetter());
                    }
                }
            }
            System.out.println();
        }

        System.out.println();

        System.out.println("Economy (price: $250/seat)");
        for (int i = 24; i <= 37; i++) {
            System.out.print(i + ": ");
            firstLetter = true;
            for (Seat s : passengerSeats) {
                if (s.getClassService().equals("Economy") && s.getNumber() == i && s.getAvailability()) {
                    if (firstLetter) {
                        System.out.print(s.getLetter());
                        firstLetter = false;
                    } else {
                        System.out.print(", " + s.getLetter());
                    }
                }
            }
            System.out.println();
        }
        for (int i = 40; i <= 53; i++) {
            System.out.print(i + ": ");
            firstLetter = true;
            for (Seat s : passengerSeats) {
                if (s.getClassService().equals("Economy") && s.getNumber() == i && s.getAvailability()) {
                    if (firstLetter) {
                        System.out.print(s.getLetter());
                        firstLetter = false;
                    } else {
                        System.out.print(", " + s.getLetter());
                    }
                }
            }
            System.out.println();
        }
    }


    public static void makeReservation(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String name = scan.nextLine();
        System.out.println("Please enter seat number (e.g., 12A)");
        int seatNumber = 0;
        char seatLetter = ' ';
        String serviceClass = "";
        String seatPrice = "";
        Seat reservedSeat = null;
        while(true)
        {
            String seat = scan.nextLine();
            seat = seat.toUpperCase().trim();
            String seatNumberStr = seat.substring(0, seat.length() - 1);
            seatLetter = seat.charAt(seat.length() - 1);
            seatNumber = Integer.parseInt(seatNumberStr);

            if (seatNumber < 1 || seatNumber > 53 ||
                    (seatLetter != 'A' && seatLetter != 'B' && seatLetter != 'C' && seatLetter != 'D' &&
                            seatLetter != 'E' && seatLetter != 'F' && seatLetter != 'G' && seatLetter != 'J' &&
                            seatLetter != 'K' && seatLetter != 'L') ||
                    ((seatNumber >= 1 && seatNumber <= 3) && (seatLetter == 'C' || seatLetter == 'J')) ||
                    (seatNumber == 4 && (seatLetter == 'C' || seatLetter == 'J' || seatLetter == 'D' ||
                            seatLetter == 'E' || seatLetter == 'F' || seatLetter == 'G')))
            {
                System.out.println("Invalid seat number. Please enter another seat number");
            }else{
                break;
            }
        }
        for(Seat s: passengerSeats)
        {
            if(s.getNumber() == seatNumber && s.getLetter() == seatLetter && s.getAvailability())
            {
                s.notAvailable();
                passengerSeats.remove(s);
                reservedSeats.add(s);
                serviceClass = s.getClassService();
                reservedSeat = s;
                break;
            }
        }

        if(serviceClass.equals("First Class"))
        {
            seatPrice = "$1000";
        }else if(serviceClass.equals("Economy Plus"))
        {
            seatPrice = "$500";
        }else if(serviceClass.equals("Economy"))
        {
            seatPrice = "$250";
        }
        System.out.println("Please confirm selection:");
        System.out.println("Seat: " + seatNumber + seatLetter);
        System.out.println("Class Service: " + serviceClass);
        System.out.println("Price: " + seatPrice);
        System.out.println("Please type [Y] to confirm or [N] to deny selection");
        String confirmation = scan.nextLine().toUpperCase();

        if (confirmation.equals("Y")) {
            if (reservation.containsKey(name)) {
                reservation.get(name).add(new Seat(seatNumber, seatLetter, serviceClass));
            } else {
                reservation.put(name, new ArrayList<>(Arrays.asList(new Seat(seatNumber, seatLetter, serviceClass))));
            }
            System.out.println("Reservation complete.");
        } else {
            reservedSeat.setAvailable();
            passengerSeats.add(reservedSeat);
            reservedSeats.remove(reservedSeat);
            System.out.println("Reservation cancelled. The seat has been returned to availability.");
        }


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
        System.out.println("First\n");

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
