

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
    String price = "";

    public Seat(int number, char letter, String cs)
    {
        this.number = number;
        this.letter = letter;
        this.classService = cs;
        this.availability = true;
        if(cs.equals("First Class"))
        {
            price = "$1000";

        }else if(cs.equals("Economy Plus"))
        {
            price = "$500";
        }else if(cs.equals("Economy"))
        {
            price = "$250";
        }
    }
    public String getPrice()
    {
        return price;
    }

    public boolean getAvailability()
    {
        return availability;
    }
    public void notAvailable(){
        this.availability = false;
    }

    public void setAvailable(){
        this.availability = true;
    }
    public String toString(){
        return ("" + number + "" + letter);
    }

    public String getClassService()
    {
        return classService;
    }

    public char getLetter(){
        return letter;
    }

    public int getNumber(){
        return number;
    }



}
