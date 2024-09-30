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

    /**
     * Constructor for creating a Seat object.
     *
     * @param number seat number.
     * @param letter seat letter.
     * @param cs class of service.
     */

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

    /**
     * Returns the price of the seat based on its class of service.
     *
     * @return the seat price as a string
     */

    public String getPrice()
    {
        return price;
    }


    /**
     * Checks whether the seat is available.
     *
     * @return true if the seat is available, false otherwise
     */

    public boolean getAvailability()
    {
        return availability;
    }

    /**
     * Marks the seat as not available.
     */
    public void notAvailable(){
        this.availability = false;
    }

    /**
     * Marks the seat as available.
     */
    public void setAvailable(){
        this.availability = true;
    }

    /**
     * Returns a string representation of the seat in the format of its number and letter.
     *
     * @return the seat number and letter as a string
     */
    public String toString(){
        return ("" + number + "" + letter);
    }


    /**
     * Retrieves the class of service for the seat.
     *
     * @return the class of service
     */
    public String getClassService()
    {
        return classService;
    }

    /**
     * Retrieves the letter of the seat.
     *
     * @return the seat letter
     */

    public char getLetter(){
        return letter;
    }


    /**
     * Retrieves the number of the seat.
     *
     * @return the seat number
     */

    public int getNumber(){
        return number;
    }

}
