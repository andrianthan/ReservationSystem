

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

    /**
     * Constructor for creating an instance of User object.
     *
     * @param id the user account id.
     * @param name name of user creating account.
     * @param password password chosen by user.
     */

    public User(String id, String name, String password)
    {
        this.id = id;
        this.name = name;
        this.password = password;

    }

    /**
     * Returns ID associated with User instance.
     */

    public String getId(){
        return id;
    }

    /**
     * Returns name associated with User instance.
     */

    public String getName(){
        return name;
    }

    /**
     * Returns password associated with User instance.
     */

    public String getPassword(){
        return password;
    }

}
