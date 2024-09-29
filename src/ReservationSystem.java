import java.util.*;
import java.io.*;

/**
 * ReservationSystem
 * Andrian Than
 * @version 1.0 10/02/2024
 */
public class ReservationSystem {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java ReservationSystem <ReservationFile> <UserFile>");
            return;
        }
        String reservationFileName = args[0];
        String userFileName = args[1];

        AirlineReservation system = new AirlineReservation();

        system.initializeSeating();

        File reservationFile = new File(reservationFileName);
        File userFile = new File(userFileName);

        if (reservationFile.exists() && userFile.exists()) {
            system.loadUsers(userFileName);
            system.loadReservations(reservationFileName);
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
                system.handlePublicUser();
                break;
            } else if (userInput.equals("A")) {
                system.handleAdmin();
                break;

            } else if (userInput.equals("X")) {

                break;
            } else {
                System.out.println("Invalid input. Please choose 'P' for Public User, 'A' for Admin User, or 'E' to Exit.");
            }
        }
        system.saveReservations(reservationFileName);
        system.saveUsers(userFileName);
        System.out.println("Data saved. Exiting the system.");

    }
}
