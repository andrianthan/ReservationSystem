
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
    }

    public static void printAdminMenu(){
        System.out.println("Please select one of the Admin Menu Options:\nShow [M]anifest list, E[X]it");
    }






}
