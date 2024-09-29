

/**
 * User
 * Andrian Than
 * @version 1.0 10/02/2024
 */

/**
 * Represents a seat in the Airline Reservation System
 */

public class User {
    private String id;
    private String name;
    private String password;
    private boolean isAdmin = false;

    public User(String id, String name, String password)
    {
        this.id = id;
        this.name = name;
        this.password = password;

    }
    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

}
