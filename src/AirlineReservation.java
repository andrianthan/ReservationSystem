import java.io.*;
import java.util.*;

/**
 * AirlineReservation
 * Andrian Than
 * @version 1.0 10/02/2024
 */
public class AirlineReservation {
    private HashMap<String, User> publicUsers = new HashMap<>();
    private Set<String> employeeIds = new HashSet<>(Arrays.asList("admin1", "admin2"));
    private ArrayList<Seat> passengerSeats = new ArrayList<>();
    private ArrayList<Seat> reservedSeats = new ArrayList<>();
    private HashMap<User, ArrayList<Seat>> reservation = new HashMap<>();
    private User currentUser = null;
    private boolean isAdminLoggedIn = false;
    private boolean exitFlag = false;

    public void initializeSeating() {

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

    public void handlePublicUser() {
        boolean exitFlag = false;
        while (!exitFlag) {
            getUserInfo();
            if (currentUser == null) {
                return; // Exit if user wants to exit or there's no current user
            }

            while (!exitFlag) {
                printUserMenu();
                //selectUser();  // This method now doesn't return anything
                System.out.println("Would you like to E[X]it or continue? (Press X to exit)");
                Scanner scan = new Scanner(System.in);
                String choice = scan.nextLine().toUpperCase();
                if (choice.equals("X")) {
                    userExit();  // Exit the user session
                    exitFlag = true;
                }
            }
        }
    }

    public void handleAdmin() {
        adminSignIn();
        if (isAdminLoggedIn) {
            boolean exitFlag = false;
            while (!exitFlag) {
                printAdminMenu();
                //selectAdmin();  // This method now doesn't return anything
                System.out.println("Would you like to E[X]it or continue? (Press X to exit)");
                Scanner scan = new Scanner(System.in);
                String choice = scan.nextLine().toUpperCase();
                if (choice.equals("X")) {
                    adminExit();  // Exit admin session
                    exitFlag = true;
                }
            }
        }
    }

    private void adminSignIn() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your employee ID:");
        String employeeId = scan.nextLine();

        while (!employeeIds.contains(employeeId)) {
            System.out.println("Invalid employee ID. Please try again or enter [E]xit");
            employeeId = scan.nextLine();
            if(employeeId.length() ==1)
            {
                employeeId = employeeId.toUpperCase();
                if(employeeId.equals("E"))
                {
                    return;
                }
            }
        }
        isAdminLoggedIn = true;
        System.out.println("Administrator logged in successfully.");
    }

    public void loadUsers(String userFileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(userFileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String userId = parts[0];
                String password = parts[1];
                String name = parts[2];
                User user = new User(userId, name, password);
                publicUsers.put(userId, user);
            }
            System.out.println("Users loaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadReservations(String reservationFileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(reservationFileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String userId = parts[0];
                int seatNumber = Integer.parseInt(parts[1]);
                char seatLetter = parts[2].charAt(0);
                String classService = parts[3];

                User user = publicUsers.get(userId);
                if (user != null) {
                    Seat seat = findSeat(seatNumber, seatLetter);
                    if (seat != null) {
                        seat.notAvailable();
                        reservedSeats.add(seat);
                        reservation.computeIfAbsent(user, k -> new ArrayList<>()).add(seat);
                    }
                }
            }
            System.out.println("Reservations loaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Seat findSeat(int seatNumber, char seatLetter) {
        for (Seat s : passengerSeats) {
            if (s.getNumber() == seatNumber && s.getLetter() == seatLetter) {
                return s;
            }
        }
        return null;
    }

    public void saveUsers(String userFileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(userFileName))) {
            for (User user : publicUsers.values()) {
                bw.write(user.getId() + "," + user.getPassword() + "," + user.getName());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveReservations(String reservationFileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(reservationFileName))) {
            for (Map.Entry<User, ArrayList<Seat>> entry : reservation.entrySet()) {
                String userId = entry.getKey().getId();
                for (Seat seat : entry.getValue()) {
                    bw.write(userId + "," + seat.getNumber() + "," + seat.getLetter() + "," + seat.getClassService());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printUserMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please select one of the User Menu Options:");
        System.out.println("Check [A]vailability  Make [R]eservation  [C]ancel Reservation   [V]iew Reservations  [D]one");

        String input = scan.next().toUpperCase();  // Get user input
        selectUser(input);  // Pass input to selectUser method
    }


    public void selectUser(String input) {
        while (!exitFlag) {  // Keep running until exitFlag is true
            if (input.equals("A")) {
                checkAvailability();
                if (exitFlag) return;  // If exitFlag is true, exit
                System.out.println("\nPlease select another option or [D]one:");
                printUserMenu();  // Call this method to display the menu again
                continue;

            } else if (input.equals("R")) {
                makeReservation();
                if (exitFlag) return;  // If exitFlag is true, exit
                System.out.println("\nPlease select another option or [D]one:");
                printUserMenu();
                continue;

            } else if (input.equals("C")) {
                cancelReservation();
                if (exitFlag) return;  // If exitFlag is true, exit
                System.out.println("\nPlease select another option or [D]one:");
                printUserMenu();
                continue;

            } else if (input.equals("V")) {
                viewReservation();
                if (exitFlag) return;  // If exitFlag is true, exit
                System.out.println("\nPlease select another option or [D]one:");
                printUserMenu();
                continue;

            } else if (input.equals("D")) {
                exitFlag = true;  // Set exitFlag to true to stop further recursion
                System.out.println("Exiting user menu...");
                return;

            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }


    public void checkAvailability() {
        System.out.println("Seat Availability");
        System.out.println();

        System.out.println("First Class (price: $1000/seat)");
        boolean firstLetter = true;
        for (int i = 1; i <= 4; i++) {
            System.out.print(i + ": ");
            firstLetter = true;  // Reset for each row
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
            System.out.println();  // Move to next row
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

    public void makeReservation() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter seat number");
        int seatNumber = 0;
        char seatLetter = ' ';
        String serviceClass = "";
        String seatPrice = "";
        Seat reservedSeat = null;
        while (true) {
            String seat = scan.nextLine().toUpperCase().trim();
            String seatNumberStr = seat.substring(0, seat.length() - 1);
            seatLetter = seat.charAt(seat.length() - 1);
            try {
                seatNumber = Integer.parseInt(seatNumberStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid seat number. Please enter another seat number");
                continue;
            }

            if (seatNumber < 1 || seatNumber > 53 ||
                    (seatLetter != 'A' && seatLetter != 'B' && seatLetter != 'C' && seatLetter != 'D' &&
                            seatLetter != 'E' && seatLetter != 'F' && seatLetter != 'G' && seatLetter != 'J' &&
                            seatLetter != 'K' && seatLetter != 'L') ||
                    ((seatNumber >= 1 && seatNumber <= 3) && (seatLetter == 'C' || seatLetter == 'J')) ||
                    (seatNumber == 4 && (seatLetter == 'C' || seatLetter == 'J' || seatLetter == 'D' ||
                            seatLetter == 'E' || seatLetter == 'F' || seatLetter == 'G'))) {
                System.out.println("Invalid seat number. Please enter another seat number");
            } else {
                break;
            }
        }

        Seat selectedSeat = findSeat(seatNumber, seatLetter);
        if (selectedSeat == null || !selectedSeat.getAvailability()) {
            System.out.println("Seat is not available. Please choose another seat.");
            return;
        }

        serviceClass = selectedSeat.getClassService();
        selectedSeat.notAvailable();
        reservedSeats.add(selectedSeat);

        if (serviceClass.equals("First Class")) {
            seatPrice = "$1000";
        } else if (serviceClass.equals("Economy Plus")) {
            seatPrice = "$500";
        } else if (serviceClass.equals("Economy")) {
            seatPrice = "$250";
        }
        System.out.println("Please confirm selection:");
        System.out.println("Seat: " + seatNumber + seatLetter);
        System.out.println("Class Service: " + serviceClass);
        System.out.println("Price: " + seatPrice);
        System.out.println("Please type [Y] to confirm or [N] to deny selection");
        String confirmation = scan.nextLine().toUpperCase();

        if (confirmation.equals("Y")) {
            reservation.computeIfAbsent(currentUser, k -> new ArrayList<>()).add(selectedSeat);
            System.out.println("Reservation complete.");
        } else {
            selectedSeat.setAvailable();
            reservedSeats.remove(selectedSeat);
            System.out.println("Reservation cancelled. The seat has been returned to availability.");
        }
    }

    public void cancelReservation() {
        Scanner scan = new Scanner(System.in);
        User user = currentUser;

        if (!reservation.containsKey(user) || reservation.get(user).isEmpty()) {
            System.out.println("No reservations found under your name.");
            return;
        }

        ArrayList<Seat> userReservations = reservation.get(user);

        System.out.println("Your reservations:");
        for (int i = 0; i < userReservations.size(); i++) {
            Seat s = userReservations.get(i);
            System.out.println((i + 1) + ". Seat: " + s.getNumber() + s.getLetter() + ", Class: " + s.getClassService());
        }

        System.out.println("Enter the number of the reservation you wish to cancel:");
        int choice = -1;
        try {
            choice = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }

        if (choice < 1 || choice > userReservations.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        Seat seatToCancel = userReservations.get(choice - 1);
        userReservations.remove(choice - 1);

        seatToCancel.setAvailable();
        reservedSeats.remove(seatToCancel);

        System.out.println("Reservation cancelled for seat: " + seatToCancel.getNumber() + seatToCancel.getLetter());
    }

    public void viewReservation() {
        User user = currentUser;

        if (!reservation.containsKey(user) || reservation.get(user).isEmpty()) {
            System.out.println("No reservations found under your name.");
            return;
        }

        ArrayList<Seat> userReservations = reservation.get(user);

        System.out.println("Name: " + user.getName());
        double totalBalance = 0;
        System.out.print("Seats: ");

        for (Seat s : userReservations) {
            String priceStr = s.getPrice();
            double price = Double.parseDouble(priceStr.replace("$", ""));
            totalBalance += price;

            System.out.print(String.valueOf(s.getNumber())+ "" + s.getLetter() +" " + priceStr + ", ");
        }

        System.out.println("\nTotal Balance Due: $" + totalBalance);
    }


    public void userExit() {
        System.out.println("Exiting user menu. Thank you for using the Airline Reservation System.");
        currentUser = null; // Reset currentUser
    }

    public void printAdminMenu() {
        System.out.println("Please select one of the Admin Menu Options:");
        System.out.println("Show [M]anifest list  E[X]it");
        selectAdmin();
    }

    public void selectAdmin() {
        Scanner scan = new Scanner(System.in);
        String input;
        while (true) {
            input = scan.nextLine().toUpperCase();
            if (input.equals("M")) {
                adminManifest();
                System.out.println("\nPlease select another option or E[X]it:");
                continue;

            } else if (input.equals("X")) {
                adminExit();
                break;
            } else {
                System.out.println("Invalid input. Please try again");
            }
        }
    }

    public void adminManifest() {
        System.out.println("Reservation Manifest:");

        // Organize reservations by class
        Map<String, List<String>> manifest = new LinkedHashMap<>();
        manifest.put("First Class", new ArrayList<>());
        manifest.put("Economy Plus", new ArrayList<>());
        manifest.put("Economy", new ArrayList<>());

        for (Map.Entry<User, ArrayList<Seat>> entry : reservation.entrySet()) {
            String passengerName = entry.getKey().getName();
            for (Seat s : entry.getValue()) {
                String classService = s.getClassService();
                String seatInfo = s.getNumber() + s.getLetter() + ": " + passengerName;
                manifest.get(classService).add(seatInfo);
            }
        }

        for (String classService : manifest.keySet()) {
            System.out.println("\n" + classService + ":");
            List<String> reservations = manifest.get(classService);
            if (reservations.isEmpty()) {
                System.out.println("No reservations in this class.");
            } else {
                for (String info : reservations) {
                    System.out.println(info);
                }
            }
        }
    }

    public void adminExit() {
        System.out.println("Exiting admin menu.");
        isAdminLoggedIn = false;
    }

    public void getUserInfo() {
        Scanner scan = new Scanner(System.in);
        String id;
        String name;
        String password;

        while (true) {
            System.out.println("Are you a [F]irst Time User, [R]eturning User, or [E]xit?");
            String userInput = scan.nextLine().toUpperCase();

            if (userInput.equals("E")) {
                System.out.println("Exiting. Thank you!");
                currentUser = null;
                break;
            }

            if (userInput.equals("F")) {
                System.out.println("Please enter id for account creation.");
                id = scan.nextLine().trim();
                if (publicUsers.containsKey(id)) {
                    System.out.println("Account id exists. Please enter another account id.");
                    continue;
                }
                System.out.println("Please enter name for account creation.");
                name = scan.nextLine().trim();
                System.out.println("Please enter password for account creation.");
                password = scan.nextLine().trim();
                User user = new User(id, name, password);
                publicUsers.put(id, user);
                currentUser = user;
                System.out.println("Airline Reservation account successfully created.");
                break;

            } else if (userInput.equals("R")) {
                System.out.println("Please enter account id.");
                id = scan.nextLine().trim();
                User user = publicUsers.get(id);
                if (user == null) {
                    System.out.println("Valid account ID not found. Please try again.");
                    continue;
                }
                System.out.println("Please enter account password.");
                password = scan.nextLine().trim();
                if (user.getPassword().equals(password)) {
                    currentUser = user;
                    System.out.println("Successfully logged in.");
                    break;
                } else {
                    System.out.println("Incorrect password entered. Please try again.");
                }
            } else {
                System.out.println("Invalid Input. Please try again");
            }
        }
    }
}
