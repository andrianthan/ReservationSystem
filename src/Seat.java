

/**
 * Seat
 * Andrian Than
 * @version 1.0 10/02/2024
 */
public class Seat {
    private int number;
    private char letter;
    private String classService;
    private boolean availability;

    public Seat(int number, char letter, String cs)
    {
        this.number = number;
        this.letter = letter;
        this.classService = cs;
        this.availability = true;
    }

    public boolean getAvailability()
    {
        return availability;
    }
    public static void notAvailable(){
        this.availability = false;
    }

    public static void setAvailable(){
        this.availability = true;
    }
    public String toString(){
        return ("" + number + "" + letter);
    }

    public String getClassService()
    {
        return classService;
    }

    public String getLetter(){
        return letter;
    }

    public int getNumber(){
        return number;
    }



}
