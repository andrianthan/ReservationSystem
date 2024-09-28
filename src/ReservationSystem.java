import java.util.*;
import java.io.*;

/**
 * ReservationSystem
 * Andrian Than
 * @version 1.0 10/02/2024
 */

public class ReservationSystem {
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String reservationFileName = args[2];
        String userFileName = args[3];
        try{
            File file1 = new File("/Users/andrianthan/IdeaProjects/ReservationSystem/src/" + reservationFileName + ".txt");
            File file2 = new File("/Users/andrianthan/IdeaProjects/ReservationSystem/src/" + userFileName + ".txt");
            if(!file1.exists() && !file2.exists())
            {
                AirlineReservation.createFile(reservationFileName);
                AirlineReservation.createFile(userFileName);
                System.out.println("Files created.");

            }else{
                AirlineReservation.loadFiles(reservationFileName);

                System.out.println("Files loaded.");
            }

            System.out.println("Choose user type: [P]ublic or [A]dmin");
            while(true){
                String userInput = scan.nextLine();
                if(userInput.equals("P"))
                {


                }else if(userInput.equals("A"))
                {

                }else{
                    System.out.println("Invalid Input. Please choose 'P' for Public User and 'A' for Admin User");
                }
            }

        }catch(IOException e){
            e.printStackTrace();


    }

    }
}
