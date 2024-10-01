import java.util.*;
import java.io.*;

/**
 * ReservationSystem
 * Andrian Than
 * @version 1.0 10/02/2024
 */

/**
 * Facilitates activity of public users and admin users.
 * Allows public users to reserve seats
 * Allows admin users to view manifest list.
 */
public class ReservationSystem {
    public static void main(String[] args) {
        String reservationFileName = args[0];
        String userFileName = args[1];

        AirlineReservation airline = new AirlineReservation();

        airline.initializeSeating();

        File reservationFile = new File(reservationFileName);
        File userFile = new File(userFileName);

        if (reservationFile.exists() && userFile.exists()) {
            airline.loadUsers(userFileName);
            airline.loadReservations(reservationFileName);
            System.out.println("Existing Reservations and Users are loaded.");
        } else {
            try {
                if (!reservationFile.exists()) {
                    reservationFile.createNewFile();
                }
                if (!userFile.exists()) {
                    userFile.createNewFile();
                }
                System.out.println(reservationFileName + " and " + userFileName + " are now created.");
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Choose user type: [P]ublic or [A]dmin or E[X]IT");
            String userInput = scan.nextLine().trim().toUpperCase();

            if (userInput.equals("P")) {
                airline.handlePublicUser();
                break;
            } else if (userInput.equals("A")) {
                airline.handleAdmin();
                break;

            } else if (userInput.equals("X")) {

                break;
            } else {
                System.out.println("Invalid input. Please choose 'P' for Public User, 'A' for Admin User, or 'E' to Exit.");
            }
        }
        airline.saveReservations(reservationFileName);
        airline.saveUsers(userFileName);
        System.out.println("Data saved. Exiting the system.");

    }
}
