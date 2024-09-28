

/**
 * Seat
 * Andrian Than
 * @version 1.0 10/02/2024
 */
public class Seat {
    private int number;
    private char letter;
    private String classService;

    public Seat(int number, char letter, String cs)
    {
        this.number = number;
        this.letter = letter;
        this.classService = cs;
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
